package expression.select;

import disk.System;
import meta.MetaData;
import types.RangeTableTypes;

import java.io.IOException;

public class RelationExpr extends RangeTableExpr {
    private String tableName = "";
    private String alias = "";
    private String dbName = "";

    public RelationExpr(String tableName, String alias, String daName) {
        super(RangeTableTypes.RT_RELATION);
        this.tableName = tableName;
        this.alias = alias;
        this.dbName = daName;
    }

    public RelationExpr() {
        super(RangeTableTypes.RT_RELATION);
    }

    public String getTableName() {
        return tableName;
    }

    String getAlias() {
        return alias;
    }

    public String getDbName() {
        if (dbName.equals(""))
            return System.getCurDB().dataBaseName;
        else
            return dbName;
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
        if (MetaData.isTableNotExist(getDbName(), getTableName()))
            throw new RuntimeException("Table " + getTableName() + " does not exist");
    }
}
