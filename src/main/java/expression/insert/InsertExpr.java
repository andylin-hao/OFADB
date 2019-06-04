package expression.insert;

import expression.Expression;
import meta.ColumnInfo;
import meta.MetaData;
import meta.TableInfo;
import utils.Utils;
import expression.select.RelationExpr;
import types.ExprTypes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

    private void completeValues() throws IOException {
        TableInfo tableInfo = MetaData.getTableInfoByName(table.getDbName(), table.getTableName());
        ColumnInfo[] columnInfos = Objects.requireNonNull(tableInfo).columns;
        HashMap<String, Integer> columnIndexMap = new HashMap<>();
        for (int i = 0;i<columns.size();i++) {
            columnIndexMap.put(columns.get(i), i);
        }

        columns.clear();
        for (ColumnInfo columnInfo: columnInfos) {
            columns.add(columnInfo.columnName);
        }

        ArrayList<ArrayList<Object>> newValues = new ArrayList<>();
        for (ArrayList<Object> value: values) {
            ArrayList<Object> newValue = new ArrayList<>();
            for (ColumnInfo columnInfo: columnInfos) {
                if (columnIndexMap.containsKey(columnInfo.columnName)) {
                    newValue.add(value.get(columnIndexMap.get(columnInfo.columnName)));
                } else {
                    newValue.add(null);
                }
            }
            newValues.add(newValue);
        }

        values.clear();
        values = newValues;
    }

    @Override
    public void checkValidity() throws IOException {
        Utils.checkColumnsValues(table, columns, values);
        completeValues();
    }
}
