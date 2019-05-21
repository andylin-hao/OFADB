package expression.update;

import expression.Expression;
import types.ExprTypes;

public class UpdateExpr extends Expression {
    public UpdateExpr() {
        super(ExprTypes.EXPR_UPDATE);
    }
}
