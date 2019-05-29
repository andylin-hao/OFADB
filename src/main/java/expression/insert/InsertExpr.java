package expression.insert;

import expression.Expression;
import expression.select.RelationExpr;
import meta.MetaData;
import types.ColumnTypes;
import types.ExprTypes;

import java.io.IOException;
import java.util.ArrayList;

public class InsertExpr extends Expression {
    private RelationExpr table = new RelationExpr();
    private ArrayList<String> columns = new ArrayList<>();
    private ArrayList<ArrayList<Object>> values = new ArrayList<>();

    public InsertExpr() {
        super(ExprTypes.EXPR_INSERT);
    }

    public InsertExpr(String dbName, String tableName) {
        super(ExprTypes.EXPR_INSERT);
        table.setDbName(dbName);
        table.setTableName(tableName);
    }

    public String getDbName() {
        return table.getDbName();
    }

    public String getTableName() {
        return table.getTableName();
    }

    public ArrayList<String> getColumns() {
        return columns;
    }

    public ArrayList<ArrayList<Object>> getValues() {
        return values;
    }

    private boolean objectEqualsColumnType(Object object, ColumnTypes type) {
        if (object instanceof Long) {
            return type.equals(ColumnTypes.COL_SHORT) ||
                    type.equals(ColumnTypes.COL_INT) ||
                    type.equals(ColumnTypes.COL_LONG);
        }

        if (object instanceof Double) {
            return type.equals(ColumnTypes.COL_FLOAT) ||
                    type.equals(ColumnTypes.COL_DOUBLE);
        }

        if (object instanceof String) {
            return type.equals(ColumnTypes.COL_VARCHAR) ||
                    type.equals(ColumnTypes.COL_CHAR);
        }

        if (object instanceof Boolean) {
            return type.equals(ColumnTypes.COL_BOOL);
        }

        else
            throw new RuntimeException("Unknown insert value type");
    }

    @Override
    public void checkValidity() throws IOException {
        if (columns.size() == 0) {
            // TODO
        }
    }
}
