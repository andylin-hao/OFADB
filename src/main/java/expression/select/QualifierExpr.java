package expression.select;

import types.ExprTypes;
import types.QualifyEleTypes;
import types.QualifyTypes;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The qualifier expression. Derived from {@code WhereExpr}.
 *
 * <p>The qualifier expression used in where clause, join-on clause, etc.
 * It's a ternary expression consists of two elements and a operator,
 * which represents the relation between two elements. For instances,
 * ele1 = ele2, ele1 > ele2, etc. The type of qualifier's element is {@code QualifyEleExpr}</p>
 *
 * @see WhereExpr
 * @author Hao Lin
 * @version 1.0
 * @since 1.0
 */

public class QualifierExpr extends WhereExpr {
    private QualifyTypes qualifyTypes;
    private QualifyEleExpr lhs;
    private QualifyEleExpr rhs;

    public QualifierExpr() {
        setExprType(ExprTypes.EXPR_QUALIFIER);
    }

    public QualifierExpr(QualifyTypes qualifyTypes, QualifyEleExpr lhs, QualifyEleExpr rhs) {
        setExprType(ExprTypes.EXPR_QUALIFIER);
        this.qualifyTypes = qualifyTypes;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public QualifyTypes getQualifyTypes() {
        return qualifyTypes;
    }

    public void setQualifyTypes(QualifyTypes qualifyTypes) {
        this.qualifyTypes = qualifyTypes;
    }

    public QualifyEleExpr getLhs() {
        return lhs;
    }

    public void setLhs(QualifyEleExpr lhs) {
        this.lhs = lhs;
    }

    public QualifyEleExpr getRhs() {
        return rhs;
    }

    public void setRhs(QualifyEleExpr rhs) {
        this.rhs = rhs;
    }

    /**
     * Acquire all the qualifier elements of attribute types in a qualify expression
     * @return {@code ArrayList} of {@code QualifyELeExpr}
     */
    ArrayList<QualifyEleExpr> getAttrELes() {
        ArrayList<QualifyEleExpr> result = new ArrayList<>();
        if (lhs.getEleTypes() == QualifyEleTypes.QUA_ELE_ATTR)
            result.add(lhs);
        if (rhs.getEleTypes() == QualifyEleTypes.QUA_ELE_ATTR)
            result.add(rhs);
        return result;
    }

    public void checkValidity(RangeTableExpr rangeTableExpr) throws IOException {
        QualifyEleTypes leftType = lhs.getBasicEleTypes(rangeTableExpr);
        QualifyEleTypes rightType = rhs.getBasicEleTypes(rangeTableExpr);

        // Integer is comparable with respect to Double
        if (leftType.equals(QualifyEleTypes.QUA_ELE_DOUBLE))
            leftType = QualifyEleTypes.QUA_ELE_INT;
        if (rightType.equals(QualifyEleTypes.QUA_ELE_DOUBLE))
            rightType = QualifyEleTypes.QUA_ELE_INT;

        if (!leftType.equals(rightType))
            throw new RuntimeException("The types of two sides of a qualifier must remain consistent");
        if (leftType.equals(QualifyEleTypes.QUA_ELE_BOOL) &&
                (!qualifyTypes.equals(QualifyTypes.QUA_EQ) && !qualifyTypes.equals(QualifyTypes.QUA_NOT_EQ)))
            throw new RuntimeException("Bool comparision must be = or <>");
    }
}
