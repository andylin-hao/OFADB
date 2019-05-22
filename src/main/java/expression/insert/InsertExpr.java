package expression.insert;

import expression.Expression;
import expression.select.RelationExpr;
import types.ExprTypes;

import java.util.ArrayList;

public class InsertExpr extends Expression {
    private RelationExpr table = new RelationExpr();
    private ArrayList<String> columns = new ArrayList<>();
    private ArrayList<ArrayList<Object>> values = new ArrayList<>();

    public InsertExpr() {
        super(ExprTypes.EXPR_INSERT);
    }

    public InsertExpr(String dbName, String tableName) {
        super(ExprTypes.EXPR_INSERT);
        table.setDbName(dbName);
        table.setTableName(tableName);
    }

    public String getDbName() {
        return table.getDbName();
    }

    public String getTableName() {
        return table.getTableName();
    }

    public ArrayList<String> getColumns() {
        return columns;
    }

    public ArrayList<ArrayList<Object>> getValues() {
        return values;
    }
}
