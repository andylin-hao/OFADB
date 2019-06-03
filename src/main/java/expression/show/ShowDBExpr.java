package expression.show;

import expression.Expression;
import meta.MetaData;
import types.ExprTypes;

import java.io.IOException;

public class ShowDBExpr extends Expression {
    private String dbName;

    public ShowDBExpr() {
        super(ExprTypes.EXPR_SHOW_DBS);
    }

    public ShowDBExpr(String dbName) {
        super(ExprTypes.EXPR_SHOW_DB);
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }

    @Override
    public void checkValidity() throws IOException {
        if (dbName == null)
            return;
        if (MetaData.isDBNotExist(dbName))
            throw new RuntimeException("Database " + dbName + " does not exist");
    }
}
