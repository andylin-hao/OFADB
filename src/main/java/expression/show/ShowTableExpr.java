package expression.show;

import expression.Expression;
import expression.types.ExprTypes;

public class ShowTableExpr extends Expression {
    private String dbName;
    private String tableName;

    public ShowTableExpr() {
        super(ExprTypes.EXPR_SHOW_TABLE);
    }

    public ShowTableExpr(String dbName, String tableName) {
        super(ExprTypes.EXPR_SHOW_TABLE);
        this.dbName = dbName;
        this.tableName = tableName;
    }

    public String getDbName() {
        return dbName;
    }

    public String getTableName() {
        return tableName;
    }
}
