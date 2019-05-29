package expression.select;

import expression.Expression;
import types.ExprTypes;

public class ResultColumnExpr extends Expression {
    private String attrName = "";
    private RelationExpr table = new RelationExpr();
    private String alias = "";

    public ResultColumnExpr() {
        super(ExprTypes.EXPR_COLUMN);
    }

    boolean equals(ResultColumnExpr r) {
        return alias.equals(r.getAlias()) && attrName.equals(r.getAttrName()) && table.getTableName().equals(r.getTableName());
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getTableName() {
        return table.getTableName();
    }

    public void setTableName(String tableName) {
        table.setTableName(tableName);
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDbName() { return table.getDbName(); }

    public void setDbName(String dbName) { table.setDbName(dbName); }

    public String getName() {
        if (!alias.equals(""))
            return alias;
        else
            return attrName;
    }
}
