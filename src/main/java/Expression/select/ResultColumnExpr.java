package Expression.select;

import Expression.Expression;
import Expression.types.ExprTypes;

public class ResultColumnExpr extends Expression {
    private String attrName = "";
    private String tableName = "";
    private String dbName = "";
    private String alias = "";

    public ResultColumnExpr() {
        super(ExprTypes.EXPR_COLUMN);
    }

    boolean equals(ResultColumnExpr r) {
        return alias.equals(r.getAlias()) && attrName.equals(r.getAttrName()) && tableName.equals(r.getTableName());
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDbName() { return dbName; }

    public void setDbName(String dbName) { this.dbName = dbName; }
}
