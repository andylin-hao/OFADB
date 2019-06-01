package expression;

import types.ExprTypes;

import java.io.IOException;

/**
 * The basic representation of a SQL expression
 *
 * <p>This class if the basic class of all expressions parsed by parser.
 * It provides the type of a expression and a {@code checkValidity} function for
 * overriding, which verifies the validity of a expression.</p>
 *
 * @author Hao Lin
 * @version 1.0
 * @since 1.0
 */

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
