package expression.select;

import expression.types.RangeTableTypes;

import java.util.ArrayList;

public class JoinExpr extends RangeTableExpr {
    private RangeTableExpr lhs;
    private RangeTableExpr rhs;
    private boolean isNatural = false;
    private QualifierExpr qualifierExpr;
    private ArrayList<ResultColumnExpr> usingExpr = new ArrayList<>();

    public JoinExpr() {
        super(RangeTableTypes.RT_JOIN);
    }

    public RangeTableExpr getLhs() {
        return lhs;
    }

    public void setLhs(RangeTableExpr lhs) {
        this.lhs = lhs;
    }

    public RangeTableExpr getRhs() {
        return rhs;
    }

    public void setRhs(RangeTableExpr rhs) {
        this.rhs = rhs;
    }

    public boolean isNatural() {
        return isNatural;
    }

    public void setNatural(boolean natural) {
        isNatural = natural;
    }

    public QualifierExpr getQualifierExpr() {
        return qualifierExpr;
    }

    public void setQualifierExpr(QualifierExpr qualifierExpr) {
        this.qualifierExpr = qualifierExpr;
    }

    public ArrayList<ResultColumnExpr> getUsingExpr() {
        return usingExpr;
    }

    public void setUsingExpr(ArrayList<ResultColumnExpr> usingExpr) {
        this.usingExpr = usingExpr;
    }

}
