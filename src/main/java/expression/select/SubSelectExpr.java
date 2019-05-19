package expression.select;

import expression.types.RangeTableTypes;

public class SubSelectExpr extends RangeTableExpr {
    private String alias;
    private SelectExpr selectExpr;

    public SubSelectExpr(String alias) {
        super(RangeTableTypes.RT_SUB_QUERY);
        this.alias = alias;
    }

    public SelectExpr getSelectExpr() {
        return selectExpr;
    }

    public void setSelectExpr(SelectExpr selectExpr) {
        this.selectExpr = selectExpr;
    }

    public String getAlias() {
        return alias;
    }
}
