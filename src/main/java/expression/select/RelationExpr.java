package expression.select;

import disk.System;
import meta.ColumnInfo;
import meta.MetaData;
import meta.TableInfo;
import types.RangeTableTypes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * The relation type of range table.
 *
 * <p>This class is a deriving class of {@code RangeTableExpr}.
 * It is the representation of a relational range table.</p>
 *
 * @see RangeTableExpr
 * @author Hao Lin
 * @version 1.0
 * @since 1.0
 */

public class RelationExpr extends RangeTableExpr {
    private String tableName = "";
    private String alias = "";
    private String dbName = "";
    private JoinExpr parent = null;

    public RelationExpr(String tableName, String alias, String dbName) {
        super(RangeTableTypes.RT_RELATION);
        this.tableName = tableName;
        this.alias = alias;
        this.dbName = dbName;
    }

    public RelationExpr() {
        super(RangeTableTypes.RT_RELATION);
    }

    public String getTableName() {
        return tableName;
    }

    public String getAlias() {
        return alias;
    }

    public String getDbName() {
        return System.getCurDB().dataBaseName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getName() {
        if (!alias.equals(""))
            return alias;
        else
            return tableName;
    }

    @Override
    public void checkValidity() throws IOException {
        if (MetaData.isTableNotExist(System.getCurDB().dataBaseName, getTableName()))
            throw new RuntimeException("Table " + getTableName() + " does not exist");
    }

    @Override
    protected RelationExpr clone() throws CloneNotSupportedException {
        return new RelationExpr(tableName, alias, dbName);
    }

    @Override
    public ArrayList<String> getColumnNames() throws IOException {
        ArrayList<String> result = new ArrayList<>();
        TableInfo tableInfo = MetaData.getTableInfoByName(System.getCurDB().dataBaseName, tableName);
        for (ColumnInfo info: Objects.requireNonNull(tableInfo).columns) {
            result.add(info.columnName);
        }

        return result;
    }
}
