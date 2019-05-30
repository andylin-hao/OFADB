package expression.select;

import expression.Expression;
import types.ExprTypes;
import types.OpTypes;

import java.util.ArrayList;
import java.util.HashSet;

public class WhereExpr extends Expression {

    private WhereExpr left;
    private WhereExpr right;
    private OpTypes op;
    private boolean isInvalid = false;

    WhereExpr() {
        super(ExprTypes.EXPR_WHERE);
    }

    public WhereExpr(WhereExpr left, WhereExpr right, OpTypes op) {
        super(ExprTypes.EXPR_WHERE);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public WhereExpr getLeft() {
        return left;
    }

    public WhereExpr getRight() {
        return right;
    }

    public OpTypes getOp() {
        return op;
    }

    public boolean isInvalid() {
        return isInvalid;
    }

    void setInvalid(boolean invalid) {
        isInvalid = invalid;
    }

    void trim(HashSet<String> trimTargetTables) {
        this.isInvalid = false;
        if (this.getExprType().equals(ExprTypes.EXPR_QUALIFIER)) {
            QualifierExpr qualifierExpr = (QualifierExpr) this;
            ArrayList<QualifyEleExpr> attrELes = qualifierExpr.getAttrELes();
            for (QualifyEleExpr attrEle: attrELes) {
                String tableName = ((ResultColumnExpr) attrEle.getValue()).getTableName();
                if (trimTargetTables.contains(tableName)) {
                    qualifierExpr.setInvalid(true);
                } else {
                    qualifierExpr.setInvalid(false);
                }
            }
        } else {
            left.trim(trimTargetTables);
            right.trim(trimTargetTables);
            if (op.equals(OpTypes.OP_AND)) {
                this.isInvalid = left.isInvalid() && right.isInvalid();
            } else if (op.equals(OpTypes.OP_OR)) {
                this.isInvalid = left.isInvalid() || right.isInvalid();
            }
        }
    }
}
