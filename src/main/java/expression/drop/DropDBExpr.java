package expression.drop;

import expression.Expression;
import meta.MetaData;
import types.ExprTypes;

import java.io.IOException;

public class DropDBExpr extends Expression {
    private String dbName;

    public DropDBExpr() {
        super(ExprTypes.EXPR_DROP_DB);
    }

    public DropDBExpr(String dbName) {
        super(ExprTypes.EXPR_DROP_DB);
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
