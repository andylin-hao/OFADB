package expression.drop;

import expression.Expression;
import expression.types.ExprTypes;

public class DropTableExpr extends Expression {
    private String dbName;
    private String tableName;

    public DropTableExpr(String dbName, String tableName) {
        super(ExprTypes.EXPR_DROP_TABLE);
        this.dbName = dbName;
        this.tableName = tableName;
    }

    public DropTableExpr() {
        super(ExprTypes.EXPR_DROP_TABLE);
    }

    public String getTableName() {
        return tableName;
    }

    public String getDbName() {
        return dbName;
    }
}
