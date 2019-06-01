package expression.select;

/**
 * The node type of the binary tree structure in {@code FormulaExpr}.
 *
 * @see FormulaExpr
 * @author Hao Lin
 * @version 1.0
 * @since 1.0
 */

public class FormulaNodeExpr extends FormulaExpr {
    private Number value;

    public FormulaNodeExpr(Number value) {
        this.value = value;
    }

    @Override
    public Number getValue() {
        return value;
    }
}
