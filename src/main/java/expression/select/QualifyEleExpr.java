package expression.select;

import expression.Expression;
import utils.Utils;
import types.ColumnTypes;
import types.ExprTypes;
import types.QualifyEleTypes;

import java.io.IOException;

/**
 * The basic element expression in a qualifier.
 *
 * @see QualifierExpr
 * @author Hao Lin
 * @version 1.0
 * @since 1.0
 */

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

    /**
     * Convert column types to corresponding QualifyEleTypes for comparison.
     * For instance, the {@code COL_SHORT}, {@code COL_INT}, {@code COL_LONG}
     * types are converted to {@code QUA_ELE_INT}
     *
     * @param type a {@code ColumnTypes} variable for converting
     * @return The corresponding {@code QualifyEleTypes} of the parameter
     */
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

    /**
     * Convert the attribute and formula types of elements to their actual types
     *
     * @param rangeTableExpr The range table field of the possible attribute.
     *                       Can be {@code null} if the target qualifier type is formula.
     * @return The basic qualifier type: {@code QUA_ELE_INT}, {@code QUA_ELE_DOUBLE}, {@code QUA_ELE_STR}, {@code QUA_ELE_BOOL}
     * @throws IOException IO exception
     */
    public QualifyEleTypes getBasicEleTypes(RangeTableExpr rangeTableExpr) throws IOException {
        switch (eleTypes) {
            case QUA_ELE_ATTR:
                ColumnTypes type = Utils.checkColumnExpr((ResultColumnExpr)value, rangeTableExpr, true);
                return columnTypeToEleType(type);
            case QUA_ELE_FORMULA:
                Number result = ((FormulaExpr) value).getValue();
                if (result instanceof Integer)
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
