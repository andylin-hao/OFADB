package expression.show;

import expression.Expression;
import expression.select.RelationExpr;
import types.ExprTypes;

public class ShowTableExpr extends Expression {
    private RelationExpr table = new RelationExpr();

    public ShowTableExpr() {
        super(ExprTypes.EXPR_SHOW_TABLE);
    }

    public ShowTableExpr(String dbName, String tableName) {
        super(ExprTypes.EXPR_SHOW_TABLE);
        table.setDbName(dbName);
        table.setTableName(tableName);
    }

    public String getDbName() {
        return table.getDbName();
    }

    public String getTableName() {
        return table.getTableName();
    }
}
