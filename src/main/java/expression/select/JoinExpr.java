package expression.select;

import types.RangeTableTypes;

import java.util.ArrayList;

/**
 * The join expression. Derived from the {@code RangeTableExpr}.
 *
 * <p>This class is the representation of a join expression in query statement.
 * The structure of this class is a binary tree.
 * The left side is a join expression or a basic range table such as relation table or sub query,
 * while the right side is always a basic range table.</p>
 *
 * @see RangeTableExpr
 * @author Hao Lin
 * @version 1.0
 * @since 1.0
 */

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
