package expression.select;

import expression.types.RangeTableTypes;

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

    public String getAlias() {
        return alias;
    }

    public String getDbName() {
        return dbName;
    }
}
