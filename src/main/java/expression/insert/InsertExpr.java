package expression.insert;

import expression.Expression;
import expression.select.FormulaExpr;
import meta.ColumnInfo;
import meta.MetaData;
import meta.TableInfo;
import utils.Utils;
import expression.select.RelationExpr;
import types.ExprTypes;

import java.io.IOException;
import java.io.ObjectOutputStream;
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

        if (columns.size() == 0) {
            for (ColumnInfo columnInfo : columnInfos) {
                columns.add(columnInfo.columnName);
            }
        }
        for (int i = 0; i < columns.size(); i++) {
            columnIndexMap.put(columns.get(i), i);
        }

        columns.clear();
        for (ColumnInfo columnInfo : columnInfos) {
            columns.add(columnInfo.columnName);
        }

        ArrayList<ArrayList<Object>> newValues = new ArrayList<>();
        for (ArrayList<Object> value : values) {
            ArrayList<Object> newValue = new ArrayList<>();
            for (ColumnInfo columnInfo : columnInfos) {
                if (columnIndexMap.containsKey(columnInfo.columnName)) {
                    Object valueObject = value.get(columnIndexMap.get(columnInfo.columnName));
                    if (valueObject instanceof FormulaExpr)
                        valueObject = ((FormulaExpr) valueObject).getValue();
                    newValue.add(Utils.convertValueTypes(valueObject, columnInfo.columnType.typeCode));
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
        completeValues();
        Utils.checkColumnsValues(table, columns, values);
    }
}
