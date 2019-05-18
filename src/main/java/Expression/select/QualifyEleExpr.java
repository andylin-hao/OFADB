package Expression.select;

import Expression.Expression;
import Expression.types.ExprTypes;
import Expression.types.QualifyEleTypes;

public class QualifyEleExpr extends Expression {
    private QualifyEleTypes eleTypes;
    private Object value;

    public QualifyEleExpr() {
        super(ExprTypes.EXPR_QUALIFY_ELE);
    }

    public QualifyEleExpr(QualifyEleTypes eleTypes, Object value) {
        super(ExprTypes.EXPR_QUALIFY_ELE);
        this.eleTypes = eleTypes;
        this.value = value;
    }

    public QualifyEleTypes getEleTypes() {
        return eleTypes;
    }

    public void setEleTypes(QualifyEleTypes eleTypes) {
        this.eleTypes = eleTypes;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
