package expression.select;

import expression.Expression;
import types.ExprTypes;
import types.OpTypes;

/**
 * The formula expression.
 *
 * <p>This class is the representation of a formula such as:
 * 1+2*3, 1+6/2, (1+4)*5, which supports the basic arithmetic including
 * multiplication, division, addition, subtraction and bracket. A function
 * {@code getValue} is provided to calculate the value of a formula automatically.
 * The structure of the formula expression is a binary tree, and the node type is
 * {@code FormulaNodeExpr}</p>
 *
 * @see FormulaNodeExpr
 * @author Hao Lin
 * @version 1.0
 * @since 1.0
 */

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

    /**
     * A function to calculate the value of a formula
     * @return {@code Number} type's subclass including {@code Integer} and {@code Double}
     */
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