package expression.select;

import expression.Expression;
import expression.types.ExprTypes;
import expression.types.RangeTableTypes;

public class RangeTableExpr extends Expression {
    private RangeTableTypes rtTypes;

    public RangeTableExpr(RangeTableTypes types) {
        super(ExprTypes.EXPR_RANGE_TABLE);
        this.rtTypes = types;
    }

    public RangeTableExpr() {
        super(ExprTypes.EXPR_RANGE_TABLE);
    }

    public RangeTableTypes getRtTypes() {
        return rtTypes;
    }

    public void setRtTypes(RangeTableTypes rtTypes) {
        this.rtTypes = rtTypes;
    }

}