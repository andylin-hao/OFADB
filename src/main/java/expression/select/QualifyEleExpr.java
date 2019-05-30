package expression.select;

import expression.Expression;
import types.ColumnTypes;
import types.ExprTypes;
import types.QualifyEleTypes;

import java.io.IOException;

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

    private QualifyEleTypes columnTypeToEleType(ColumnTypes type) {
        switch (type) {
            case COL_FLOAT:
            case COL_DOUBLE:
                return QualifyEleTypes.QUA_ELE_DOUBLE;
            case COL_VARCHAR:
            case COL_CHAR:
                return QualifyEleTypes.QUA_ELE_STR;
            case COL_SHORT:
            case COL_INT:
            case COL_LONG:
                return QualifyEleTypes.QUA_ELE_INT;
            case COL_BOOL:
                return QualifyEleTypes.QUA_ELE_BOOL;
            default:
                throw new RuntimeException("Unknown column type");
        }
    }

    QualifyEleTypes getBasicEleTypes(RangeTableExpr rangeTableExpr) throws IOException {
        switch (eleTypes) {
            case QUA_ELE_ATTR:
                ColumnTypes type = SelectExpr.checkColumnExpr((ResultColumnExpr)value, rangeTableExpr, true);
                return columnTypeToEleType(type);
            case QUA_ELE_FORMULA:
                Number result = ((FormulaExpr) value).getValue();
                if (result instanceof Long)
                    return QualifyEleTypes.QUA_ELE_INT;
                else if (result instanceof Double)
                    return QualifyEleTypes.QUA_ELE_DOUBLE;
                else
                    throw new RuntimeException("Unknown type of formula result");
            default:
                return eleTypes;
        }
    }
}
