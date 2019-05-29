package expression.create;

import expression.Expression;
import expression.select.RelationExpr;
import meta.MetaData;
import types.ColumnTypes;
import types.ExprTypes;
import types.TableConstraintTypes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class CreateTableExpr extends Expression {

    private RelationExpr table = new RelationExpr();
    private ArrayList<ColumnDefExpr> columnDefExprs = new ArrayList<>();
    private ArrayList<TableConstraintExpr> tableConstraintExprs = new ArrayList<>();

    public CreateTableExpr() {
        super(ExprTypes.EXPR_CREATE_TABLE);
    }

    public CreateTableExpr(String dbName, String tableName) {
        super(ExprTypes.EXPR_CREATE_TABLE);
        table.setDbName(dbName);
        table.setTableName(tableName);
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
        return table.getDbName();
    }

    public String getTableName() {
        return table.getTableName();
    }

    public HashSet<String> checkPrimaryKey() {
        HashSet<String> primaryKeys = new HashSet<>();
        for (ColumnDefExpr columnDefExpr: columnDefExprs) {
            if (primaryKeys.contains(columnDefExpr.getColumnName()))
                throw new RuntimeException("Duplicate definition of primary key " + columnDefExpr.getColumnName());
            primaryKeys.add(columnDefExpr.getColumnName());
        }

        for (TableConstraintExpr tableConstraintExpr: tableConstraintExprs) {
            if (tableConstraintExpr.getType().equals(TableConstraintTypes.TBL_PRIMARY_KEY)) {
                for (ColumnDefExpr columnDefExpr: tableConstraintExpr.getColumns()) {
                    if (primaryKeys.contains(columnDefExpr.getColumnName()))
                        throw new RuntimeException("Duplicate definition of primary key " + columnDefExpr.getColumnName());
                    primaryKeys.add(columnDefExpr.getColumnName());
                }
            }
        }

        return primaryKeys;
    }

    private void checkColumnUniqueness() {
        HashSet<String> columnNames = new HashSet<>();
        for (ColumnDefExpr columnDefExpr: columnDefExprs) {
            columnNames.add(columnDefExpr.getColumnName());
        }

        if (columnNames.size() != columnDefExprs.size())
            throw new RuntimeException("Duplicate column definition");
    }

    @Override
    public void checkValidity() throws IOException {
        if (MetaData.isDBNotExist(getDbName()))
            throw new RuntimeException("Database " + getDbName() + " does not exist");
        if (!MetaData.isTableNotExist(getDbName(), getTableName()))
            throw new RuntimeException("Table " + getTableName() + " already exists");

        checkPrimaryKey();

        checkColumnUniqueness();
    }
}
