package expression.select;

import expression.Expression;
import types.ExprTypes;
import types.RangeTableTypes;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The base class of all range table classes.
 *
 * <p>This class is the representation of all kinds of range tables such as:
 * join expression, relation table, sub query</p>
 *
 * @author Hao Lin
 * @version 1.0
 * @since 1.0
 */

public class RangeTableExpr extends Expression {
    private RangeTableTypes rtTypes;

    public RangeTableExpr(RangeTableTypes types) {
        super(ExprTypes.EXPR_RANGE_TABLE);
        this.rtTypes = types;
    }

    public RangeTableExpr() {
        super(ExprTypes.EXPR_RANGE_TABLE);
    }

    public RangeTableTypes getRtTypes() {
        return rtTypes;
    }

    public void setRtTypes(RangeTableTypes rtTypes) {
        this.rtTypes = rtTypes;
    }

    /**
     * Acquire all columns' names
     *
     * @return {@code ArrayList} of {@code String}
     * @throws IOException IO exception
     */
    public ArrayList<String> getColumnNames() throws IOException {
        return new ArrayList<>();
    }

    public String getRangeTableName() {
        switch (this.rtTypes) {
            case RT_RELATION:
                return ((RelationExpr) this).getName();
            case RT_SUB_QUERY:
                return ((SubSelectExpr) this).getAlias();
            default:
                return null;
        }
    }
}
