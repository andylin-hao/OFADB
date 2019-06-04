package engine;

import disk.System;
import expression.Expression;
import expression.show.ShowDBExpr;
import result.InfoResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class InfoEngine {
    private Expression expression;
    public InfoEngine(Expression expression){
        this.expression = expression;
    }

    public InfoResult getResult()throws IOException{
        String dbName = ((ShowDBExpr)expression).getDbName();
        if(dbName == null)
            return getDatabasesResult();
        else
            return getTablesResult();
    }

    private InfoResult getDatabasesResult()throws IOException {
        String name = "All databases";
        return new InfoResult(name,System.getAllDatabaseNames());
    }

    private InfoResult getTablesResult()throws IOException{
        String name = ((ShowDBExpr)expression).getDbName();
        ArrayList<String> tbName = new ArrayList<>(Objects.requireNonNull(System.getDataBase(name)).tables.keySet());
        return new InfoResult(name,tbName);
    }
}
