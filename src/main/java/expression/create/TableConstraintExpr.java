package expression.create;

import expression.Expression;
import types.ExprTypes;
import types.TableConstraintTypes;

import java.util.ArrayList;

public class TableConstraintExpr extends Expression {
    private TableConstraintTypes type;
    private ArrayList<ColumnDefExpr> columns = new ArrayList<>();

    public TableConstraintExpr() {
        super(ExprTypes.EXPR_TABLE_CONSTRAINT);
    }

    public TableConstraintExpr(TableConstraintTypes type) {
        super(ExprTypes.EXPR_TABLE_CONSTRAINT);
        this.type = type;
    }

    public ArrayList<ColumnDefExpr> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<ColumnDefExpr> columns) {
        this.columns = columns;
    }

    public TableConstraintTypes getType() {
        return type;
    }
}
