package expression.select;

import expression.Expression;
import types.ExprTypes;

/**
 * The column expression.
 *
 * <P>This is the representation of a column expression.
 * For instance, {@code A.b as a}</P>
 *
 * @author Hao Lin
 * @version 1.0
 * @since 1.0
 */

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

    /**
     * Acquire the real name of a column, which means alias if exist.
     * @return {@code String}
     */
    public String getName() {
        if (!alias.equals(""))
            return alias;
        else
            return attrName;
    }

    @Override
    protected ResultColumnExpr clone() throws CloneNotSupportedException {
        ResultColumnExpr newColumn = new ResultColumnExpr();
        newColumn.attrName = attrName;
        newColumn.table = table.clone();
        newColumn.alias = alias;
        return newColumn;
    }
}
