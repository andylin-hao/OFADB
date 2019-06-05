package engine;

import disk.System;
import expression.Expression;
import expression.create.CreateDBExpr;
import expression.drop.DropDBExpr;
import expression.use.UseDBExpr;
import result.MsgResult;

import java.io.IOException;

public class DBManiEngine {
    private Expression dbExpr;


    DBManiEngine(Expression expr) {
        this.dbExpr = expr;
    }

    public MsgResult getResult() throws IOException {
        switch (dbExpr.getExprType()) {
            case EXPR_CREATE_DB:
                return getCreateResult();
            case EXPR_DROP_DB:
                return getDropResult();
            case EXPR_USE_DB:
                return getUseResult();
            default:
                throw new RuntimeException("No such database manipulation expression");
        }
    }

    private MsgResult getCreateResult() throws IOException {
        String dbName = ((CreateDBExpr) dbExpr).getDbName();
        try {
            System.createNewDatabase(dbName);
        } catch (RuntimeException e) {
            return new MsgResult(e.getMessage());
        }
        return new MsgResult("Create database successfully");
    }

    private MsgResult getDropResult() throws IOException {
        String dbName = ((DropDBExpr) dbExpr).getDbName();
        try {
            System.removeDatabase(dbName);
        } catch (RuntimeException e) {
            return new MsgResult(e.getMessage());
        }
        return new MsgResult("Drop database " + dbName + " successfully");
    }

    private MsgResult getUseResult() throws IOException {
        String dbName = ((UseDBExpr) dbExpr).getDbName();
        try {
            System.switchDatabase(dbName);
        } catch (RuntimeException e) {
            return new MsgResult(e.getMessage());
        }
        return new MsgResult("Use database " + dbName + " successfully");
    }


}
