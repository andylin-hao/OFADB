package result;

import block.BlockInfo;
import disk.Row;
import disk.System;
import disk.Table;
import expression.select.*;
import index.IndexBase;
import index.IndexKey;
import meta.ColumnInfo;
import meta.MetaData;
import types.*;

import java.io.IOException;
import java.util.*;

public class RelationResult extends QueryResult{
    private RelationExpr tableExpr;
    private HashSet<String> wholeRows;
    public RelationResult(RelationExpr table) {
        super();
        this.tableExpr = table;
        datas = new ArrayList<>();
        initResultByTable();
    }

    public String getName() {
        return tableExpr.getName();
    }
    private void initResultByTable(){
        wholeRows = new HashSet<>();
        String tableName = tableExpr.getTableName();
        Table table = Objects.requireNonNull(System.getCurDB().getTable(tableName));
        List<BlockInfo> blockInfos = table.dataFileManager.blockInfos;
        for(int i = 0;i<blockInfos.size();i++){
            for(int j = 0;j<blockInfos.get(i).emptyRecord.size();j++)
                if(!blockInfos.get(i).emptyRecord.get(j)) {
                    ArrayList<String> data = new ArrayList<>();
                    data.add(i + ","+ j);
                    wholeRows.addAll(data);
                    datas.add(data);
                }
        }
    }

    @Override
    public SingleResult getValue(final String position) throws IOException {
        String tableName = tableExpr.getTableName();
        Table table = Objects.requireNonNull(System.getCurDB().getTable(tableName));

        String[] br = position.split(",");
        int blockIndex = Integer.valueOf(br[0]);
        int rowIndex = Integer.valueOf(br[1]);

        Object[] rowData = table.dataFileManager.get(blockIndex, rowIndex).rowData;
        HashMap<String, Object> data = new HashMap<>();
        for (int i = 0; i < table.info.columns.length; i++)
            data.put(table.info.columns[i].columnName, rowData[i]);
        return new SingleResult(String.valueOf(datas.indexOf(new ArrayList<String>(){{add(position);}})), tableExpr.getName(), data);
    }

    @Override
    public SingleResult getValue(ArrayList<String> positions) throws IOException {
        String position = positions.get(0);
        return getValue(position);
    }

    public boolean indexUsable(WhereExpr where)throws IOException{
        if(where == null)
            return true;
        if(where.isInvalid())
            return true;
        if(where.getExprType().equals(ExprTypes.EXPR_QUALIFIER)){
            QualifyEleExpr left = ((QualifierExpr)where).getLhs();
            QualifyEleExpr right = ((QualifierExpr)where).getRhs();
            if(left.getEleTypes().equals(QualifyEleTypes.QUA_ELE_ATTR)){
                ColumnInfo columnInfo = columnInfoFromExpr((ResultColumnExpr)left.getValue());
                return (!(columnInfo.hasIndex() == null));
            }
            else if(right.getEleTypes().equals(QualifyEleTypes.QUA_ELE_ATTR)){
                ColumnInfo columnInfo = columnInfoFromExpr((ResultColumnExpr)right.getValue());
                return (!(columnInfo.hasIndex() == null));
            }
            return true;
        }
        else if(where.getExprType().equals(ExprTypes.EXPR_WHERE)){
            WhereExpr left = where.getLeft();
            WhereExpr right = where.getRight();
            return indexUsable(left) && indexUsable(right);
        }
        else
            throw new RuntimeException("Error in check index usable");

    }

    private ColumnInfo columnInfoFromExpr(ResultColumnExpr columnExpr)throws IOException{
        if(columnExpr.getTableName().equals(tableExpr.getRangeTableName())) {
            String databaseName = System.getCurDB().dataBaseName;
            String tableName = tableExpr.getTableName();
            String columnName = columnExpr.getAttrName();
            return MetaData.getColumnType(databaseName, tableName, columnName);
        }
        else
            throw new RuntimeException("Error in get columnInfo from expr");
    }

    private Object synchronizeObjectType(Object origin, QualifyTypes compareType,ColumnInfo info,boolean isLeft){
        if(origin instanceof Boolean || origin instanceof String)
            return origin;
        if(origin instanceof Double || origin instanceof Float)
        {
            if(info.columnType.typeCode.equals(ColumnTypes.COL_DOUBLE))
                return ((Number)origin).doubleValue();
            else if(info.columnType.typeCode.equals(ColumnTypes.COL_FLOAT))
                return ((Number)origin).floatValue();
            else {
                if((compareType.equals(QualifyTypes.QUA_GT) && !isLeft)
                    || (compareType.equals(QualifyTypes.QUA_LET) && !isLeft)
                    || (compareType.equals(QualifyTypes.QUA_GET) && isLeft)
                    || (compareType.equals(QualifyTypes.QUA_LT) && isLeft)
                )
                    origin = Math.floor(((Number)origin).doubleValue());
                else if((compareType.equals(QualifyTypes.QUA_GT) && isLeft)
                        || (compareType.equals(QualifyTypes.QUA_LET) && isLeft)
                        || (compareType.equals(QualifyTypes.QUA_GET) && !isLeft)
                        || (compareType.equals(QualifyTypes.QUA_LT) && !isLeft)
                )
                    origin = Math.ceil(((Number) origin).doubleValue());
                if (info.columnType.typeCode.equals(ColumnTypes.COL_SHORT))
                    return ((Number)origin).shortValue();
                else if (info.columnType.typeCode.equals(ColumnTypes.COL_INT))
                    return ((Number)origin).intValue();
                else if (info.columnType.typeCode.equals(ColumnTypes.COL_LONG))
                    return ((Number)origin).longValue();
                else
                    throw new RuntimeException("Error in type change of constant value");
            }
        }
        else if(origin instanceof Long
                ||origin instanceof Integer
                ||origin instanceof Short
        ){
            if (info.columnType.typeCode.equals(ColumnTypes.COL_SHORT))
                return ((Number)origin).shortValue();
            else if (info.columnType.typeCode.equals(ColumnTypes.COL_INT))
                return ((Number)origin).intValue();
            else if (info.columnType.typeCode.equals(ColumnTypes.COL_LONG))
                return ((Number)origin).longValue();
            else if (info.columnType.typeCode.equals(ColumnTypes.COL_DOUBLE))
                return ((Number)origin).doubleValue();
            else if (info.columnType.typeCode.equals(ColumnTypes.COL_FLOAT))
                return ((Number)origin).floatValue();
            else
                throw new RuntimeException("Error in type change of constant value");
        }

        else
            throw new RuntimeException("Error in type change of constant value");
    }

    private HashSet<String> rangeGetFromQualifier(QualifierExpr qualifier)throws IOException{
        QualifyEleExpr left = qualifier.getLhs();
        QualifyEleExpr right = qualifier.getRhs();

        ColumnInfo column;
        Comparable key;
        IndexBase index;
        if(left.getEleTypes().equals(QualifyEleTypes.QUA_ELE_ATTR) && !right.getEleTypes().equals(QualifyEleTypes.QUA_ELE_ATTR))
        {
            column = columnInfoFromExpr((ResultColumnExpr) left.getValue());
            if(right.getEleTypes().equals(QualifyEleTypes.QUA_ELE_FORMULA))
                key = (Comparable) synchronizeObjectType(((FormulaExpr)right.getValue()).getValue(),qualifier.getQualifyTypes(),column,false);
            else
                key = (Comparable) synchronizeObjectType(right.getValue(),qualifier.getQualifyTypes(),column,false);
            index = column.hasIndex();

        }else if(!left.getEleTypes().equals(QualifyEleTypes.QUA_ELE_ATTR) && right.getEleTypes().equals(QualifyEleTypes.QUA_ELE_ATTR)){
            column = columnInfoFromExpr((ResultColumnExpr) right.getValue());
            if(right.getEleTypes().equals(QualifyEleTypes.QUA_ELE_FORMULA))
                key = (Comparable) synchronizeObjectType(((FormulaExpr)right.getValue()).getValue(),qualifier.getQualifyTypes(),column,true);
            else
                key = (Comparable) synchronizeObjectType(right.getValue(),qualifier.getQualifyTypes(),column,true);
            index = column.hasIndex();
        }
        else
            throw new RuntimeException("Error in qualifier stucture");

        Object[] keyData = new Object[1];
        keyData[0] = key;
        IndexKey indexKey = new IndexKey(index.info.types,keyData);
        if(index != null) {
            HashSet<Row> rowResult;
            switch (qualifier.getQualifyTypes()){
                case QUA_LT:
                    rowResult = index.rangeQuery(indexKey, IndexQueryType.QUERY_LT);
                    break;
                case QUA_GT:
                    rowResult = index.rangeQuery(indexKey, IndexQueryType.QUERY_GT);
                    break;
                case QUA_LET:
                    rowResult = index.rangeQuery(indexKey, IndexQueryType.QUERY_LET);
                    break;
                case QUA_GET:
                    rowResult = index.rangeQuery(indexKey, IndexQueryType.QUERY_GET);
                    break;
                case QUA_EQ:
                    rowResult = index.rangeQuery(indexKey,IndexQueryType.QUERY_EQ);
                    break;
                case QUA_NOT_EQ:
                    rowResult = index.rangeQuery(indexKey,IndexQueryType.QUERY_NEQ);
                    break;
                default:
                    throw new RuntimeException("No such qualifiy type");
            }
            HashSet<String> result = new HashSet<>();
            for(Row row : rowResult)
                result.add(row.blockIndex + "," + row.rowIndex);
            return result;
        }
        else{
            throw new RuntimeException("try to query by index which doesn't exist");
        }
    }

    private HashSet<String> filterByIndex(WhereExpr where)throws IOException{
        if(where.isInvalid())
            return (HashSet<String>) wholeRows.clone();
        if(where.getExprType().equals(ExprTypes.EXPR_QUALIFIER)){
            return  rangeGetFromQualifier((QualifierExpr)where);
        }
        else if(where.getExprType().equals(ExprTypes.EXPR_WHERE)){
            HashSet<String> left = filterByIndex(where.getLeft());
            HashSet<String> right = filterByIndex(where.getRight());
            if(where.getOp().equals(OpTypes.OP_OR))
                left.addAll(right);
            else if(where.getOp().equals(OpTypes.OP_AND))
                left.retainAll(right);
            return left;

        }
        else
            throw new RuntimeException("Error in check index usable");
    }

    public void indexFilter(WhereExpr where)throws IOException{
        HashSet<String> filterResult = filterByIndex(where);
        datas.clear();
        for(final String string : filterResult) {
            datas.add(new ArrayList<String>(){{add(string);}});
        }
    }
}
