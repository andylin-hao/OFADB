package engine;

import disk.Row;
import disk.System;
import disk.Table;
import expression.Expression;
import expression.delete.DeleteExpr;
import expression.insert.InsertExpr;
import expression.select.RelationExpr;
import expression.select.SelectExpr;
import expression.select.WhereExpr;
import expression.update.UpdateExpr;
import result.MsgResult;
import result.QueryResult;
import result.RelationResult;
import utils.Utils;

import java.io.IOException;
import java.util.ArrayList;

public class TableModifyEngine {
    private Expression expression;

    public TableModifyEngine(Expression expression) {
        this.expression = expression;
    }

    public MsgResult getResult() throws IOException {
        switch (expression.getExprType()) {
            case EXPR_INSERT:
                return getInsertResult();
            case EXPR_DELETE:
                return getDeleteResult();
            case EXPR_UPDATE:
                return getUpdateResult();
            default:
                throw new RuntimeException("No such table modify expression");
        }
    }

    private MsgResult getInsertResult() throws IOException {
        String tableName = ((InsertExpr) expression).getTableName();
        ArrayList<ArrayList<Object>> allData = ((InsertExpr) expression).getValues();
        Table table = System.getCurDB().getTable(tableName);
        ArrayList<Row> insertedData = new ArrayList<>();
        try {
            for (ArrayList<Object> allDatum : allData) {
                if (table.insertConstraintCheck(allDatum.toArray())) {
                    Row row = table.insert(allDatum.toArray());
                    insertedData.add(row);
                } else {
                    for (Row row : insertedData)
                        table.delete(row.blockIndex, row.rowIndex);
                    return new MsgResult("Illegal values in insert");
                }
            }
        } catch (RuntimeException e) {
            return new MsgResult(e.getMessage());
        }
        return new MsgResult("Insert successfully");
    }

    private MsgResult getDeleteResult() throws IOException {
        String tableName = ((DeleteExpr) expression).getTableName();
        Table table = System.getCurDB().getTable(tableName);
        try {
            ArrayList<ArrayList<String>> datas = getMatchRows(((DeleteExpr) expression).getWhereExpr(), ((DeleteExpr) expression).getTable());
            for (ArrayList<String> string : datas) {
                int[] pos = Utils.getPosFromStr(string.get(0));
                table.delete(pos[0], pos[1]);
            }
        } catch (RuntimeException e) {
            return new MsgResult(e.getMessage());
        }
        return new MsgResult("Delete successfully");
    }

    private MsgResult getUpdateResult() throws IOException {
        String tableName = ((UpdateExpr) expression).getTableName();
        Table table = System.getCurDB().getTable(tableName);
        ArrayList<Object[]> originData = new ArrayList<>();
        ArrayList<Row> insertedData = new ArrayList<>();
        try {
            ArrayList<ArrayList<String>> datas = getMatchRows(((UpdateExpr) expression).getWhereExpr(), ((UpdateExpr) expression).getTable());
            for (ArrayList<String> string : datas) {

                int[] pos = Utils.getPosFromStr(string.get(0));
                Row oldRow = table.delete(pos[0], pos[1]);
                originData.add(oldRow.rowData);
                ((UpdateExpr)expression).completeValues(oldRow.rowData);
                Object[] newData = ((UpdateExpr)expression).getValues().toArray();

                if (table.insertConstraintCheck(newData)) {
                    Row newRow = table.insert(newData);
                    insertedData.add(newRow);
                } else {
                    for (Row row : insertedData)
                        table.delete(row.blockIndex, row.rowIndex);
                    for (Object[] data : originData)
                        table.insert(data);
                    return new MsgResult("Illegal values in set");
                }

            }
        } catch (RuntimeException e) {
            return new MsgResult(e.getMessage());
        }
        return new MsgResult("update successfully");
    }

    private ArrayList<ArrayList<String>> getMatchRows(WhereExpr where, RelationExpr relationExpr) throws IOException {
        SelectExpr selectExpr = Utils.getSelectExpr(where, relationExpr);
        QueryEngine queryEngine = new QueryEngine(selectExpr);
        QueryResult queryResult = queryEngine.getResult();
        RelationResult relationResult = (RelationResult) queryResult.getBasedResult();
        if (relationResult == null)
            throw new RuntimeException("Internal error");
        ArrayList<ArrayList<String>> matchedRows = new ArrayList<>();
        for(ArrayList<String> ele : queryResult.getDatas())
            matchedRows.add(relationResult.getDatas().get(Integer.parseInt(ele.get(0))));
        return matchedRows;
    }

}
