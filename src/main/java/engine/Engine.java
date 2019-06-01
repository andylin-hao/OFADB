package engine;

import expression.Expression;
import expression.select.SelectExpr;
import result.Result;

import java.io.IOException;

public class Engine {
    public static Result expressionExec(Expression expression)throws IOException {
        switch (expression.getExprType()){
            case EXPR_SELECT:
                QueryEngine queryEngine = new QueryEngine((SelectExpr)expression);
                return queryEngine.getResult();
            default:
                return null;
        }
    }
}
