package engine;

import disk.System;
import disk.Table;
import expression.Expression;
import expression.show.ShowDBExpr;
import expression.show.ShowTableExpr;
import meta.ColumnInfo;
import meta.MetaData;
import meta.TableInfo;
import result.InfoResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class InfoEngine {
    private Expression expression;

    public InfoEngine(Expression expression) {
        this.expression = expression;
    }

    public InfoResult getResult() throws IOException {
        switch (expression.getExprType()) {
            case EXPR_SHOW_DB:
            case EXPR_SHOW_DBS:
                return getDatabaseInfoResult();
            case EXPR_SHOW_TABLE:
                return getTableInfoResult();
            default:
                throw new RuntimeException("Error in show database info");

        }
    }

    private InfoResult getTableInfoResult() throws IOException {
        String tableName = ((ShowTableExpr) expression).getTableName();
        TableInfo table = MetaData.getTableInfoByName(System.getCurDB().dataBaseName, tableName);
        if (table != null) {
            ArrayList<String> columns = new ArrayList<>();
            for (ColumnInfo columnInfo : table.columns)
                columns.add(columnInfo.columnName + "  " + columnInfo.columnType.toString());
            return new InfoResult(tableName, columns);
        } else
            throw new RuntimeException("table " + tableName + " does not exist");
    }

    private InfoResult getDatabaseInfoResult() throws IOException {
        String dbName = ((ShowDBExpr) expression).getDbName();
        if (dbName == null)
            return getDatabasesResult();
        else
            return getTablesResult();
    }

    private InfoResult getDatabasesResult() throws IOException {
        String name = "All databases";
        return new InfoResult(name, System.getAllDatabaseNames());
    }

    private InfoResult getTablesResult() throws IOException {
        String name = ((ShowDBExpr) expression).getDbName();
        ArrayList<String> tbName = new ArrayList<>(Objects.requireNonNull(System.getDataBase(name)).tables.keySet());
        return new InfoResult(name, tbName);
    }
}
