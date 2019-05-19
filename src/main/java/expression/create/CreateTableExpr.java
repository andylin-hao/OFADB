package expression.create;

import expression.Expression;
import expression.types.ExprTypes;

import java.util.ArrayList;

public class CreateTableExpr extends Expression {

    private String dbName;
    private String tableName;
    private ArrayList<ColumnDefExpr> columnDefExprs = new ArrayList<>();
    private ArrayList<TableConstraintExpr> tableConstraintExprs = new ArrayList<>();

    public CreateTableExpr() {
        super(ExprTypes.EXPR_CREATE_TABLE);
    }

    public CreateTableExpr(String dbName, String tableName) {
        super(ExprTypes.EXPR_CREATE_TABLE);
        this.dbName = dbName;
        this.tableName = tableName;
    }

    public ArrayList<ColumnDefExpr> getColumnDefExprs() {
        return columnDefExprs;
    }

    public void setColumnDefExprs(ArrayList<ColumnDefExpr> columnDefExprs) {
        this.columnDefExprs = columnDefExprs;
    }

    public ArrayList<TableConstraintExpr> getTableConstraintExprs() {
        return tableConstraintExprs;
    }

    public void setTableConstraintExprs(ArrayList<TableConstraintExpr> tableConstraintExprs) {
        this.tableConstraintExprs = tableConstraintExprs;
    }

    public String getDbName() {
        return dbName;
    }

    public String getTableName() {
        return tableName;
    }
}
