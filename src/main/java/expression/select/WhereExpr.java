package expression.select;

import expression.Expression;
import expression.types.ExprTypes;
import expression.types.OpTypes;

public class WhereExpr extends Expression {

    private WhereExpr left;
    private WhereExpr right;
    private OpTypes op;

    public WhereExpr() {
        super(ExprTypes.EXPR_WHERE);
    }

    public WhereExpr(WhereExpr left, WhereExpr right, OpTypes op) {
        super(ExprTypes.EXPR_WHERE);
        this.left = left;
        this.right = right;
        this.op = op;
    }
}
