package expression.drop;

import expression.Expression;
import expression.types.ExprTypes;

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
}
