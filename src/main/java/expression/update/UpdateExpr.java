package expression.update;

import expression.Expression;
import utils.Utils;
import expression.select.RelationExpr;
import expression.select.WhereExpr;
import types.ExprTypes;

import java.io.IOException;
import java.util.ArrayList;

public class UpdateExpr extends Expression {
    private RelationExpr table = new RelationExpr();
    private ArrayList<String> attrNames = new ArrayList<>();
    private ArrayList<Object> values = new ArrayList<>();
    private WhereExpr whereExpr;

    public UpdateExpr() {
        super(ExprTypes.EXPR_UPDATE);
    }

    public UpdateExpr(String dbName, String tableName) {
        super(ExprTypes.EXPR_UPDATE);
        table.setDbName(dbName);
        table.setTableName(tableName);
    }

    public String getDbName() {
        return table.getDbName();
    }

    public String getTableName() {
        return table.getTableName();
    }

    public ArrayList<String> getAttrNames() {
        return attrNames;
    }

    public void setAttrNames(ArrayList<String> attrNames) {
        this.attrNames = attrNames;
    }

    public ArrayList<Object> getValues() {
        return values;
    }

    public void setValues(ArrayList<Object> values) {
        this.values = values;
    }

    public WhereExpr getWhereExpr() {
        return whereExpr;
    }

    public void setWhereExpr(WhereExpr whereExpr) {
        this.whereExpr = whereExpr;
    }

    @Override
    public void checkValidity() throws IOException {
        ArrayList<ArrayList<Object>> values = new ArrayList<>();
        values.add(this.values);
        Utils.checkColumnsValues(table, attrNames, values);
        Utils.checkWhereClause(whereExpr, table);
    }
}
