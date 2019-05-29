package expression.delete;

import expression.Expression;
import expression.select.*;
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

    private void checkWhereClause(WhereExpr root) throws IOException {
        if (root.getExprType() == ExprTypes.EXPR_QUALIFIER) {
            QualifierExpr qualifierExpr = ((QualifierExpr) root);
            ArrayList<QualifyEleExpr> attrELes = qualifierExpr.getAttrELes();
            SelectExpr.checkAttrEles(table, attrELes);
            qualifierExpr.checkValidity(table);
        } else {
            checkWhereClause(root.getRight());
            checkWhereClause(root.getLeft());
        }
    }

    @Override
    public void checkValidity() throws IOException {
        table.checkValidity();

        checkWhereClause(whereExpr);
    }
}
