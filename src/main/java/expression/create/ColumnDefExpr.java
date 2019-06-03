package expression.create;

import expression.Expression;
import types.ColumnConstraintTypes;
import types.ColumnTypes;
import types.ExprTypes;

import java.util.ArrayList;
import java.util.HashSet;

public class ColumnDefExpr extends Expression {

    private String columnName;
    private ColumnTypes colType;
    private int typeNum;
    private HashSet<ColumnConstraintTypes> constraintTypes = new HashSet<>();

    public ColumnDefExpr() {
        super(ExprTypes.EXPR_COLUMN_DEF);
    }

    public ColumnDefExpr(String columnName, ColumnTypes colType, int typeNum) {
        super(ExprTypes.EXPR_COLUMN_DEF);
        this.columnName = columnName;
        this.colType = colType;
        this.typeNum = typeNum;
    }

    public HashSet<ColumnConstraintTypes> getConstraintTypes() {
        return constraintTypes;
    }

    public String getColumnName() {
        return columnName;
    }

    public ColumnTypes getColType() {
        return colType;
    }

    public int getTypeNum() {
        return typeNum;
    }
}
