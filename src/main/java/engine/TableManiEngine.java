package engine;

import disk.System;
import disk.Type;
import expression.Expression;
import expression.create.ColumnDefExpr;
import expression.create.CreateTableExpr;
import expression.drop.DropDBExpr;
import expression.drop.DropTableExpr;
import meta.ColumnInfo;
import meta.IndexInfo;
import result.MsgResult;
import types.ColumnConstraintTypes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class TableManiEngine {
    private Expression expression;
    private ArrayList<String> columnNames;
    private ColumnInfo[] columnInfos;
    private IndexInfo pk;

    public TableManiEngine(Expression expr){
        this.expression = expr;
    }

    public MsgResult getResult()throws IOException{
        switch (expression.getExprType()){
            case EXPR_CREATE_TABLE:
                return getCreateResult();
            case EXPR_DROP_TABLE:
                return getDropResult();
            default:
                throw new RuntimeException("No such table manipulation expression");
        }
    }

    public MsgResult getCreateResult()throws IOException {
        String tableName = ((CreateTableExpr) expression).getTableName();
        ColumnInfo[] columnInfos = getColumnInfos(((CreateTableExpr) expression).getColumnDefExprs());
        List<IndexInfo> infos = createIndexInfos();
        int pkIndex = (pk == null) ? -1 : 0;
        try{
            System.getCurDB().createNewTable(tableName, columnInfos,infos,pkIndex);
        }
        catch (RuntimeException e){
            return new MsgResult(e.getMessage());
        }
        return new MsgResult("Create table "+tableName+" successfully");
    }

    private ColumnInfo[] getColumnInfos(ArrayList<ColumnDefExpr> columnDefExprs){
        columnNames = new ArrayList<>();
        int columnNum = columnDefExprs.size();
        ColumnInfo[] columns = new ColumnInfo[columnNum];
        for(int i = 0;i<columns.length;i++){
            ColumnDefExpr expr = columnDefExprs.get(i);
            columnNames.add(expr.getColumnName());
            HashSet<ColumnConstraintTypes> constraintTypes = expr.getConstraintTypes();
            boolean autoInc = constraintTypes.contains(ColumnConstraintTypes.COL_AUTO_INC);
            boolean nullable = (!constraintTypes.contains(ColumnConstraintTypes.COL_NOT_NULL)) || (!constraintTypes.contains(ColumnConstraintTypes.COL_UNIQUE));
            boolean isUnique = constraintTypes.contains(ColumnConstraintTypes.COL_UNIQUE);
            columns[i] = new ColumnInfo(
                    expr.getColumnName(),
                    new Type(expr.getColType(),expr.getTypeNum()),
                    autoInc,
                    nullable,
                    isUnique,
                    0);
        }
        this.columnInfos = columns;
        return columns;
    }

    private List<IndexInfo> createIndexInfos(){
        ArrayList<IndexInfo> indexInfos = new ArrayList<>();
        pk = getPKIndex();
        if(pk != null)
            indexInfos.add(pk);

        for(int i = 0;i<columnInfos.length;i++)
            if(columnInfos[i].isUnique){
                indexInfos.add(new IndexInfo(i,columnInfos[i].isUnique));
            }
        return indexInfos;
    }
    private IndexInfo getPKIndex(){
        HashSet<String> columnNameInPK = ((CreateTableExpr) expression).checkPrimaryKey();
        if(columnNameInPK.size()>0) {
            int[] info = new int[columnNameInPK.size()];
            Iterator<String> setIterator = columnNameInPK.iterator();
            for (int i = 0; i < columnNameInPK.size(); i++) {
                info[i] = columnNames.indexOf(setIterator.next());
                columnInfos[i].nullable = false;
            }
            return new IndexInfo(info, true);
        }
        else
            return null;
    }

    private MsgResult getDropResult()throws IOException{
        String tableName = ((DropTableExpr)expression).getTableName();
        try{
            System.getCurDB().removeTable(tableName);
        }
        catch (RuntimeException e){
            return new MsgResult(e.getMessage());
        }
        return new MsgResult("Drop table "+ tableName + " successfully");
    }
}
