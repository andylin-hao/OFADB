package expression.show;

import expression.Expression;
import expression.types.ExprTypes;

public class ShowDBExpr extends Expression {
    private String dbName;

    public ShowDBExpr() {
        super(ExprTypes.EXPR_SHOW_DBS);
    }

    public ShowDBExpr(String dbName) {
        super(ExprTypes.EXPR_SHOW_DB);
        this.dbName = dbName;
    }
}
