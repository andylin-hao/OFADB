package engine;

import disk.System;
import expression.Expression;
import expression.show.ShowDBExpr;
import result.InfoResult;

import java.util.ArrayList;

public class InfoEngine {
    private Expression expression;
    public InfoEngine(Expression expression){
        this.expression = expression;
    }

    public InfoResult getResult(){
        String dbName = ((ShowDBExpr)expression).getDbName();
        if(dbName == null)
            return getDatabasesResult();
        else
            return getTablesResult();
    }

    private InfoResult getDatabasesResult(){
        String name = "All databases";
        ArrayList<String> dbNames = new ArrayList<>(System.getDbMap().keySet());
        return new InfoResult(name,dbNames);
    }

    private InfoResult getTablesResult(){
        String name = ((ShowDBExpr)expression).getDbName();
        ArrayList<String> tbName = new ArrayList<>(System.getCurDB().tables.keySet());
        return new InfoResult(name,tbName);
    }
}
