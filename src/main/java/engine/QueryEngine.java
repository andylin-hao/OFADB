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
        if(where.isInvalid())
            return true;
        if(where.getExprType() == ExprTypes.EXPR_QUALIFIER){
            QualifyEleExpr left = ((QualifierExpr)where).getLhs();
            QualifyEleExpr right = ((QualifierExpr)where).getRhs();
            Object leftData = getQualifyEleExprValue(data,left);
            Object rightData = getQualifyEleExprValue(data,right);
            return qualify(leftData,rightData,left.getEleTypes(),((QualifierExpr)where).getQualifyTypes());
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
                QueryResult rResult = buildJoin(((JoinExpr)joins).getLhs());
                QueryResult joinResult = new QueryResult(lResult,rResult);
                whereTrim(usedRelation(joins));
                for(int i = 0; i< Objects.requireNonNull(lResult).getDatas().size(); i++){
                    for(int j = 0; j< Objects.requireNonNull(rResult).getDatas().size(); j++){
                        SingleResult lData = lResult.getValue(i);
                        SingleResult rData  = rResult.getValue(j);
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

        for(int i = 0;i<whole.getDatas().size();i++)
            if(dataValid(whole.getValue(whole.getDatas().get(i).get(0)),selectExpr.getWhereExpr())) {
                ArrayList<String> ele = new ArrayList<>();
                ele.add(String.valueOf(i));
                filter.insert(ele);
            }
        return filter;
    }

    private QueryResult subSelectFilter(QueryResult subResult,SubSelectExpr tableExpr) throws IOException{
        QueryResult filter = new QueryResult(subResult,tableExpr);

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

    private boolean qualify(Object objectLeft, Object objectRight, QualifyEleTypes objectType, QualifyTypes op){
        switch (objectType){
            case QUA_ELE_INT:
                return compare((Integer)objectLeft,(Integer)objectRight,op);
            case QUA_ELE_DOUBLE:
                return compare((Double) objectLeft,(Double) objectRight,op);
            case QUA_ELE_BOOL:
                return compare((Boolean) objectLeft,(Boolean) objectRight,op);
            case QUA_ELE_STR:
                return compare((String) objectLeft,(String)objectRight,op);
            default:
                throw new RuntimeException("No such qualify element type");
        }
    }

    private boolean compare(Integer integer1,Integer integer2,QualifyTypes op){
        switch (op){
            case QUA_EQ:
                return integer1.equals(integer2);
            case QUA_GT:
                return integer1 > integer2;
            case QUA_LT:
                return integer1 < integer2;
            case QUA_GET:
                return integer1 >= integer2;
            case QUA_LET:
                return integer1 <= integer2;
            case QUA_NOT_EQ:
                return !integer1.equals(integer2);
            default:
                throw new RuntimeException("No such qualify type");
        }
    }
    private boolean compare(String string1, String string2, QualifyTypes op){
        switch (op){
            case QUA_EQ:
                return string1.equals(string2);
            case QUA_GT:
                return (string1.compareTo(string2) > 0);
            case QUA_LT:
                return (string1.compareTo(string2) < 0);
            case QUA_GET:
                return (string1.compareTo(string2) >= 0);
            case QUA_LET:
                return (string1.compareTo(string2) <= 0);
            case QUA_NOT_EQ:
                return !string1.equals(string2);
            default:
                throw new RuntimeException("No such qualify type");
        }
    }

    private boolean compare(Double double1, Double double2, QualifyTypes op){
        switch (op){
            case QUA_EQ:
                return double1.equals(double2);
            case QUA_GT:
                return double1 > double2;
            case QUA_LT:
                return double1 < double2;
            case QUA_GET:
                return double1 >= double2;
            case QUA_LET:
                return double1 <= double2;
            case QUA_NOT_EQ:
                return !double1.equals(double2);
            default:
                throw new RuntimeException("No such qualify type");
        }
    }

    private boolean compare(Boolean boolean1, Boolean boolean2, QualifyTypes op){
        switch (op){
            case QUA_EQ:
                return boolean1.equals(boolean2);
            case QUA_NOT_EQ:
                return !boolean1.equals(boolean2);
            default:
                throw new RuntimeException("No such qualify type");
        }
    }


}
