package expression.use;

import expression.Expression;
import meta.MetaData;
import types.ExprTypes;

import java.io.IOException;

public class UseDBExpr extends Expression {
    private String dbName;

    public UseDBExpr() {
        super(ExprTypes.EXPR_USE_DB);
    }

    public UseDBExpr(String dbName) {
        super(ExprTypes.EXPR_USE_DB);
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }

    @Override
    public void checkValidity() throws IOException {
        if (MetaData.isDBNotExist(dbName))
            throw new RuntimeException("Database " + dbName + " does not exist");
    }
}
