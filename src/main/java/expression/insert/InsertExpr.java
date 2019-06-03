package expression.insert;

import disk.Type;
import expression.Expression;
import expression.select.RangeTableExpr;
import expression.select.RelationExpr;
import meta.ColumnInfo;
import meta.MetaData;
import meta.TableInfo;
import types.ColumnTypes;
import types.ExprTypes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

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

    private static boolean objectEqualsColumnType(Object object, Type columnType) {
        ColumnTypes type = columnType.typeCode;
        if (object == null)
            return true;
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
            if (type.equals(ColumnTypes.COL_VARCHAR) ||
                    type.equals(ColumnTypes.COL_CHAR)) {
                if (((String) object).length() > columnType.maxLength)
                    throw new RuntimeException("The string is too long");
                return true;
            }

            return false;
        }

        if (object instanceof Boolean) {
            return type.equals(ColumnTypes.COL_BOOL);
        } else
            throw new RuntimeException("Unknown insert value type");
    }

    public static void checkColumnsValues(RelationExpr table, ArrayList<String> columns, ArrayList<ArrayList<Object>> values) throws IOException {
        table.checkValidity();
        TableInfo tableInfo = MetaData.getTableInfoByName(table.getDbName(), table.getTableName());
        if (columns.size() == 0) {
            ColumnInfo[] columnInfos = Objects.requireNonNull(tableInfo).columns;
            for (ColumnInfo columnInfo : columnInfos) {
                columns.add(columnInfo.columnName);
            }
        } else {
            for (String columnName : columns) {
                if (!MetaData.isColumnExist(table.getDbName(), table.getTableName(), columnName))
                    throw new RuntimeException("Column " + columnName + " does not exist");
            }
        }

        if (values.size() != columns.size())
            throw new RuntimeException("Inserted values is not enough for specified columns");

        for (int i = 0; i < values.size(); i++) {
            if (!objectEqualsColumnType(values, Objects.requireNonNull(MetaData.getColumnType(table.getDbName(), table.getTableName(), columns.get(i))).columnType))
                throw new RuntimeException("Value type does not match column type");
        }
    }

    @Override
    public void checkValidity() throws IOException {
        //TODO:补充完整values输出
        checkColumnsValues(table, columns, values);
    }
}
