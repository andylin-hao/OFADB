package expression.use;

import expression.Expression;
import types.ExprTypes;

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
}
