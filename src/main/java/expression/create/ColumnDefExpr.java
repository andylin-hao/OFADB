package expression.create;

import expression.Expression;
import expression.types.ColumnConstraintTypes;
import expression.types.ColumnTypes;
import expression.types.ExprTypes;

import java.util.ArrayList;

public class ColumnDefExpr extends Expression {

    private String columnName;
    private ColumnTypes colType;
    private int typeNum;
    private ArrayList<ColumnConstraintTypes> constraintTypes = new ArrayList<>();

    public ColumnDefExpr() {
        super(ExprTypes.EXPR_COLUMN_DEF);
    }

    public ColumnDefExpr(String columnName, ColumnTypes colType, int typeNum) {
        super(ExprTypes.EXPR_COLUMN_DEF);
        this.columnName = columnName;
        this.colType = colType;
        this.typeNum = typeNum;
    }

    public ArrayList<ColumnConstraintTypes> getConstraintTypes() {
        return constraintTypes;
    }

    public void setConstraintTypes(ArrayList<ColumnConstraintTypes> constraintTypes) {
        this.constraintTypes = constraintTypes;
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
