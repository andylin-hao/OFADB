package expression.drop;

import expression.Expression;
import expression.select.RelationExpr;
import types.ExprTypes;

public class DropTableExpr extends Expression {
    private RelationExpr table = new RelationExpr();

    public DropTableExpr(String dbName, String tableName) {
        super(ExprTypes.EXPR_DROP_TABLE);
        table.setDbName(dbName);
        table.setTableName(tableName);
    }

    public DropTableExpr() {
        super(ExprTypes.EXPR_DROP_TABLE);
    }

    public String getTableName() {
        return table.getTableName();
    }

    public String getDbName() {
        return table.getDbName();
    }
}
