package expression.select;

import types.RangeTableTypes;

import java.io.IOException;
import java.util.ArrayList;

public class SubSelectExpr extends RangeTableExpr {
    private String alias;
    private SelectExpr selectExpr;
    private JoinExpr parent;

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

    @Override
    public ArrayList<String> getColumnNames() throws IOException {
        ArrayList<String> result = new ArrayList<>();
        for (ResultColumnExpr columnExpr: selectExpr.getResultColumnExprs()) {
            result.add(columnExpr.getName());
        }

        return result;
    }
}
