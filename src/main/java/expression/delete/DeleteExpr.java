package expression.delete;

import expression.Expression;
import expression.select.*;
import result.RelationResult;
import types.ExprTypes;

import java.io.IOException;
import java.util.ArrayList;

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

    public static SelectExpr getSelectExpr(WhereExpr whereExpr, RelationExpr table) throws IOException {
        SelectExpr selectExpr = new SelectExpr();
        selectExpr.setWhereExpr(whereExpr);
        selectExpr.setFromExpr(table);
        ResultColumnExpr resultColumnExpr = new ResultColumnExpr();
        resultColumnExpr.setAttrName("*");
        selectExpr.getResultColumnExprs().add(resultColumnExpr);
        selectExpr.checkValidity();
        return selectExpr;
    }

    @Override
    public void checkValidity() throws IOException {
        table.checkValidity();

        SelectExpr.checkWhereClause(whereExpr, table);
    }
}
