package expression.create;

import expression.Expression;
import expression.types.ExprTypes;

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
}
