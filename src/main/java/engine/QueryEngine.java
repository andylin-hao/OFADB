package engine;

import expression.select.*;
import result.QueryResult;
import result.RelationResult;
import result.SingleResult;
import types.*;

import java.io.IOException;
import java.util.*;

public class QueryEngine{
    private SelectExpr selectExpr;
    private HashSet<String> involvedRelations;

    public QueryResult getResult() throws IOException{
        QueryResult result = buildJoin(selectExpr.getFromExpr());
        Objects.requireNonNull(result).setSelectColumns(selectExpr);
        result.setFinalResult(true);
        return result;
    }

    public QueryEngine(SelectExpr expr){
        this.selectExpr = expr;
        this.involvedRelations = new HashSet<>();

        ArrayList<RangeTableExpr> rangeTableExprs = SelectExpr.getFromTableList(expr.getFromExpr());
        for (RangeTableExpr tableExpr: rangeTableExprs) {
            involvedRelations.add(tableExpr.getRangeTableName());
        }
    }

    private boolean dataValid(SingleResult data, WhereExpr where){
        if(where == null)
            return true;
        if(where.isInvalid())
            return true;
        if(where.getExprType().equals( ExprTypes.EXPR_QUALIFIER)){
            QualifyEleExpr left = ((QualifierExpr)where).getLhs();
            QualifyEleExpr right = ((QualifierExpr)where).getRhs();
            Object leftData = getQualifyEleExprValue(data,left);
            Object rightData = getQualifyEleExprValue(data,right);
            return compare((Comparable) leftData,(Comparable) rightData,((QualifierExpr)where).getQualifyTypes());
        }
        else if (where.getOp().equals(OpTypes.OP_AND)){
            return dataValid(data,where.getLeft()) && dataValid(data,where.getRight());
        }
        else if (where.getOp().equals(OpTypes.OP_OR)){
            return dataValid(data,where.getLeft()) || dataValid(data,where.getRight());
        }
        else
            throw new RuntimeException("Error in where clause");
    }

    private static Object getQualifyEleExprValue(SingleResult data,QualifyEleExpr ele){
        switch (ele.getEleTypes()){
            case QUA_ELE_ATTR:
                return data.getValue((ResultColumnExpr)(ele.getValue()));
            case QUA_ELE_FORMULA:
                return ((FormulaExpr)ele.getValue()).getValue();
            default:
                return ele.getValue();
        }
    }

    private QueryResult buildJoin(RangeTableExpr joins)throws IOException {
        switch (joins.getRtTypes()){
            case RT_RELATION:
                RelationResult relationResult = new RelationResult((RelationExpr) joins);
                return relationFilter(relationResult);
            case RT_SUB_QUERY:
                QueryEngine queryEngine = new QueryEngine(((SubSelectExpr)joins).getSelectExpr());
                QueryResult subResult = queryEngine.getResult();
                return subSelectFilter(subResult,(SubSelectExpr)joins);
            case RT_JOIN:
                QueryResult lResult = buildJoin(((JoinExpr)joins).getLhs());
                QueryResult rResult = buildJoin(((JoinExpr)joins).getRhs());
                QueryResult joinResult = new QueryResult(lResult,rResult);
                whereTrim(usedRelation(joins));
                for(int i = 0; i< Objects.requireNonNull(lResult).getDatas().size(); i++){
                    for(int j = 0; j< Objects.requireNonNull(rResult).getDatas().size(); j++){
                        SingleResult lData = lResult.getValue(lResult.getDatas().get(i));
                        SingleResult rData  = rResult.getValue(rResult.getDatas().get(j));
                        SingleResult mergeData = SingleResult.merge(lData,rData);
                        if(dataValid(mergeData,selectExpr.getWhereExpr()))
                            joinResult.insert(mergeData.getPositions());
                    }

                }
                return joinResult;
            default:
                throw new RuntimeException("Error in join clause");
        }
    }

    private QueryResult relationFilter(RelationResult whole)throws IOException{
        QueryResult filter = new QueryResult(whole);

        HashSet<String> used = new HashSet<>();
        used.add(whole.getName());
        whereTrim(used);

        if(selectExpr.getWhereExpr() == null || selectExpr.getWhereExpr().isInvalid())
        {
            for (int i = 0; i < whole.getDatas().size(); i++) {
                ArrayList<String> ele = new ArrayList<>();
                ele.add(String.valueOf(i));
                filter.insert(ele);
            }
        }
        else if(whole.indexUsable(selectExpr.getWhereExpr())){
            whole.indexFilter(selectExpr.getWhereExpr());
            for (int i = 0; i < whole.getDatas().size(); i++) {
                ArrayList<String> ele = new ArrayList<>();
                ele.add(String.valueOf(i));
                filter.insert(ele);
            }
        }
        else
            {
            for (int i = 0; i < whole.getDatas().size(); i++)
                if (dataValid(whole.getValue(whole.getDatas().get(i).get(0)), selectExpr.getWhereExpr())) {
                    ArrayList<String> ele = new ArrayList<>();
                    ele.add(String.valueOf(i));
                    filter.insert(ele);
                }
        }
        return filter;
    }




    private QueryResult subSelectFilter(QueryResult subResult,SubSelectExpr tableExpr) throws IOException{
        QueryResult filter = new QueryResult(subResult,tableExpr);
        subResult.setSelectExpr(tableExpr);
        HashSet<String> used = new HashSet<>();
        used.add(tableExpr.getRangeTableName());
        whereTrim(used);

        for(int i = 0;i<subResult.getDatas().size();i++){
            if(dataValid(subResult.getValue(String.valueOf(i)),selectExpr.getWhereExpr())){
                ArrayList<String> ele = new ArrayList<>();
                ele.add(String.valueOf(i));
                filter.insert(ele);
            }
        }
        return filter;
    }



    private HashSet<String> usedRelation(RangeTableExpr expr){
        if(expr.getRtTypes().equals(RangeTableTypes.RT_RELATION) ||expr.getRtTypes().equals(RangeTableTypes.RT_SUB_QUERY)){
            HashSet<String> relationName = new HashSet<>();
            relationName.add(expr.getRangeTableName());
            return relationName;
        }
        else{
            HashSet<String> leftNames = usedRelation(((JoinExpr)expr).getLhs());
            HashSet<String> rightNames = usedRelation(((JoinExpr)expr).getRhs());
            leftNames.addAll(rightNames);
            return leftNames;
        }
    }

    @SuppressWarnings("unchecked")
    private HashSet<String> unusedRelation(HashSet<String> usedRelations){
        HashSet<String> unused = (HashSet<String>) involvedRelations.clone();
        unused.removeAll(usedRelations);
        return unused;
    }

    private void whereTrim(HashSet<String> usedTable){
        HashSet<String> unused = unusedRelation(usedTable);
        selectExpr.trimWhere(unused);
    }


    @SuppressWarnings("unchecked")
    private boolean compare(Comparable left, Comparable right, QualifyTypes op){
        if(left instanceof String || left instanceof Boolean) {
            switch (op) {
                case QUA_EQ:
                    return left.equals(right);
                case QUA_GT:
                    return (left.compareTo(right) > 0);
                case QUA_LT:
                    return (left.compareTo(right) < 0);
                case QUA_GET:
                    return (left.compareTo(right) >= 0);
                case QUA_LET:
                    return (left.compareTo(right) <= 0);
                case QUA_NOT_EQ:
                    return !left.equals(right);
                default:
                    throw new RuntimeException("No such qualify type");
            }
        }
        else if(left instanceof Short || left instanceof Integer || left instanceof Long || left instanceof Float || left instanceof Double){
            switch (op) {
                case QUA_EQ:
                    return ((Number)left).doubleValue() == ((Number)right).doubleValue();
                case QUA_GT:
                    return ((Number)left).doubleValue() > ((Number)right).doubleValue();
                case QUA_LT:
                    return ((Number)left).doubleValue() < ((Number)right).doubleValue();
                case QUA_GET:
                    return ((Number)left).doubleValue() >= ((Number)right).doubleValue();
                case QUA_LET:
                    return ((Number)left).doubleValue() <= ((Number)right).doubleValue();
                case QUA_NOT_EQ:
                    return ((Number)left).doubleValue() != ((Number)right).doubleValue();
                default:
                    throw new RuntimeException("No such qualify type");
            }
        }
        else{
            throw new RuntimeException("Error in qualifier compare");
        }

    }


}
