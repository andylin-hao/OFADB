package expression.delete;

import expression.Expression;
import expression.select.RelationExpr;
import expression.select.WhereExpr;
import types.ExprTypes;

public class DeleteExpr extends Expression {
    private RelationExpr table = new RelationExpr();
    private WhereExpr whereExpr;

    public DeleteExpr(String dbName, String tableName) {
        super(ExprTypes.EXPR_DELETE);
        table.setDbName(dbName);
        table.setTableName(tableName);
    }

    public DeleteExpr() {
        super(ExprTypes.EXPR_DELETE);
    }

    public String getTableName() {
        return table.getTableName();
    }

    public String getDBName() {
        return table.getDbName();
    }

    public WhereExpr getWhereExpr() {
        return whereExpr;
    }

    public void setWhereExpr(WhereExpr whereExpr) {
        this.whereExpr = whereExpr;
    }
}
