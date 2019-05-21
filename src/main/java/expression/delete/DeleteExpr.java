package expression.delete;

import expression.Expression;
import types.ExprTypes;

public class DeleteExpr extends Expression {
    public DeleteExpr() {
        super(ExprTypes.EXPR_DELETE);
    }
}
