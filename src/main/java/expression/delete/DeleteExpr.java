package expression.delete;

import expression.Expression;
import utils.Utils;
import expression.select.*;
import types.ExprTypes;

import java.io.IOException;

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

    @Override
    public void checkValidity() throws IOException {
        table.checkValidity();

        Utils.checkWhereClause(whereExpr, table);
    }
}
