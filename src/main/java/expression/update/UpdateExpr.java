package expression.update;

import expression.Expression;
import meta.ColumnInfo;
import meta.MetaData;
import meta.TableInfo;
import utils.Utils;
import expression.select.RelationExpr;
import expression.select.WhereExpr;
import types.ExprTypes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class UpdateExpr extends Expression {
    private RelationExpr table = new RelationExpr();
    private ArrayList<String> attrNames = new ArrayList<>();
    private ArrayList<Object> values = new ArrayList<>();
    private WhereExpr whereExpr;

    public UpdateExpr() {
        super(ExprTypes.EXPR_UPDATE);
    }

    public UpdateExpr(String dbName, String tableName) {
        super(ExprTypes.EXPR_UPDATE);
        table.setDbName(dbName);
        table.setTableName(tableName);
    }

    public String getDbName() {
        return table.getDbName();
    }

    public String getTableName() {
        return table.getTableName();
    }

    public RelationExpr getTable() {
        return table;
    }

    public ArrayList<String> getAttrNames() {
        return attrNames;
    }

    public void setAttrNames(ArrayList<String> attrNames) {
        this.attrNames = attrNames;
    }

    public ArrayList<Object> getValues() {
        return values;
    }

    public void setValues(ArrayList<Object> values) {
        this.values = values;
    }

    public WhereExpr getWhereExpr() {
        return whereExpr;
    }

    public void setWhereExpr(WhereExpr whereExpr) {
        this.whereExpr = whereExpr;
    }

    @Override
    public void checkValidity() throws IOException {
        ArrayList<ArrayList<Object>> values = new ArrayList<>();
        values.add(this.values);
        Utils.checkColumnsValues(table, attrNames, values);
        Utils.checkWhereClause(whereExpr, table);
    }

    public void completeValues(Object[] oldValues) throws IOException {
        TableInfo tableInfo = MetaData.getTableInfoByName(table.getDbName(), table.getTableName());
        ColumnInfo[] columnInfos = Objects.requireNonNull(tableInfo).columns;
        HashMap<String, Integer> columnIndexMap = new HashMap<>();
        for (int i = 0; i < attrNames.size(); i++) {
            columnIndexMap.put(attrNames.get(i), i);
        }
        attrNames.clear();
        for (ColumnInfo columnInfo : columnInfos) {
            attrNames.add(columnInfo.columnName);
        }

        ArrayList<Object> newValues = new ArrayList<>();
        for (int i = 0; i < columnInfos.length; i++) {
            ColumnInfo columnInfo = columnInfos[i];
            if (columnIndexMap.containsKey(columnInfo.columnName)) {
                newValues.add(values.get(columnIndexMap.get(columnInfo.columnName)));
            } else {
                newValues.add(oldValues[i]);
            }
        }

        values.clear();
        values = newValues;
    }
}
