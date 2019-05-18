package expression.select;

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
