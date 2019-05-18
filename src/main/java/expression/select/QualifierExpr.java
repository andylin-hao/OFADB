package expression.select;

import expression.types.ExprTypes;
import expression.types.QualifyTypes;

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
}
