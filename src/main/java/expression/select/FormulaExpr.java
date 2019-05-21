package expression.select;

import expression.Expression;
import types.ExprTypes;
import types.OpTypes;


public class FormulaExpr extends Expression {
    private FormulaExpr left;
    private FormulaExpr right;
    private OpTypes op;

    public FormulaExpr() {
        super(ExprTypes.EXPR_FORMULA);
    }

    public FormulaExpr(FormulaExpr left, FormulaExpr right, OpTypes op) {
        super(ExprTypes.EXPR_FORMULA);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public Number getValue() {
        Number leftValue = left.getValue();
        Number rightValue = right.getValue();

        boolean isInteger = false;
        if (leftValue instanceof Integer && rightValue instanceof Integer)
            isInteger = true;
        else if (!(leftValue instanceof Double) && !(rightValue instanceof Double))
            throw new RuntimeException("Value type error:" + leftValue.getClass() + "/" + rightValue.getClass());

        switch (op) {
            case OP_MUL:
                if (isInteger)
                    return (Integer) leftValue * (Integer) rightValue;
                else
                    return Double.parseDouble(leftValue.toString()) * Double.parseDouble(rightValue.toString());
            case OP_DIV:
                if (Double.parseDouble(rightValue.toString()) == 0)
                    throw new RuntimeException("Illegal division of number 0");
                return Double.parseDouble(leftValue.toString()) / Double.parseDouble(rightValue.toString());
            case OP_MOD:
                if (isInteger) {
                    if ((Integer) rightValue == 0)
                        throw new RuntimeException("Illegal division of number 0");
                    return (Integer) leftValue % (Integer) rightValue;
                } else {
                    if (Double.parseDouble(rightValue.toString()) == 0)
                        throw new RuntimeException("Illegal division of number 0");
                    return Double.parseDouble(leftValue.toString()) % Double.parseDouble(rightValue.toString());
                }
            case OP_PLUS:
                if (isInteger)
                    return (Integer) leftValue + (Integer) rightValue;
                else
                    return Double.parseDouble(leftValue.toString()) + Double.parseDouble(rightValue.toString());
            case OP_MINUS:
                if (isInteger)
                    return (Integer) leftValue - (Integer) rightValue;
                else
                    return Double.parseDouble(leftValue.toString()) - Double.parseDouble(rightValue.toString());
        }

        throw new RuntimeException("Unable to calculate");
    }
}