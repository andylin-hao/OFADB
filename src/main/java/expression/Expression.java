package expression;

import types.ExprTypes;

import java.io.IOException;

public class Expression {
    private ExprTypes exprType;

    public Expression(ExprTypes exprType) {
        this.exprType = exprType;
    }

    public ExprTypes getExprType() {
        return exprType;
    }

    public void setExprType(ExprTypes exprType) {
        this.exprType = exprType;
    }

    public void checkValidity() throws IOException {}
}
