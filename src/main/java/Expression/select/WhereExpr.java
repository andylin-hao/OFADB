package Expression.select;

import Expression.Expression;
import Expression.types.ExprTypes;
import Expression.types.OpTypes;

import java.util.ArrayList;

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
