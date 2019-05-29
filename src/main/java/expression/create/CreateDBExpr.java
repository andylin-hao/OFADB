package expression.create;

import expression.Expression;
import meta.MetaData;
import types.ExprTypes;

import java.io.IOException;
import java.util.ArrayList;

public class CreateDBExpr extends Expression {
    private String dbName;

    public CreateDBExpr() {
        super(ExprTypes.EXPR_CREATE_DB);
    }

    public CreateDBExpr(String dbName) {
        super(ExprTypes.EXPR_CREATE_DB);
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }

    @Override
    public void checkValidity() throws IOException {
        if (!MetaData.isDBNotExist(dbName))
            throw new RuntimeException("Database " + dbName + " already exists");
    }
}
