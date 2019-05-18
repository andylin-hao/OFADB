package parser;

import expression.Expression;
import expression.select.*;
import expression.types.*;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SQLParser extends SQLiteBaseListener {

    private Expression expr;

    private ParseTreeProperty<Expression> ctxExpr = new ParseTreeProperty<Expression>();


    public Expression getExpr() {
        return expr;
    }

    @Override
    public void enterSelect_core(SQLiteParser.Select_coreContext ctx) {
        expr = new SelectExpr();
        ctxExpr.put(ctx, expr);
    }

    @Override
    public void enterSelect_or_values(SQLiteParser.Select_or_valuesContext ctx) {
        SelectExpr selectExpr = new SelectExpr();
        ctxExpr.put(ctx, selectExpr);
    }

    @Override
    public void exitResult_column(SQLiteParser.Result_columnContext ctx) {
        ResultColumnExpr resultColumnExpr = new ResultColumnExpr();

        if (ctx.expr() == null && ctx.getText().equals("*"))
            resultColumnExpr.setAttrName("*");
        else {
            if (ctx.expr() == null)
                throw new RuntimeException("Unable to parse \"" + ctx.getText() + "\"");
            resultColumnExpr = getColumnExpr(ctx.expr());
            if (ctx.column_alias() != null)
                resultColumnExpr.setAlias(ctx.column_alias().getText());
        }

        Expression expression = ctxExpr.get(ctx.getParent());

        switch (expression.getExprType()) {
            case EXPR_SELECT:
                SelectExpr selectExpr = (SelectExpr) expression;
                if (!selectExpr.insertResultColumns(resultColumnExpr)) {
                    throw new RuntimeException("Result target already exists: " + resultColumnExpr.getAttrName());
                }
                break;
            case EXPR_INSERT:
                break;
            default:
                break;
        }
    }

    @Override
    public void exitTable_or_subquery(SQLiteParser.Table_or_subqueryContext ctx) {
        if (ctx.table_name() != null) {
            String tableName = "", dbName = "", alias = "";
            if (ctx.table_name() != null)
                tableName = ctx.table_name().getText();
            if (ctx.database_name() != null)
                dbName = ctx.database_name().getText();
            if (ctx.table_alias() != null)
                alias = ctx.table_alias().getText();
            RelationExpr relationExpr = new RelationExpr(tableName, alias, dbName);
            ctxExpr.put(ctx, relationExpr);
        } else if (ctx.select_stmt() != null) {
            String alias = "";
            if (ctx.table_alias() != null)
                alias = ctx.table_alias().getText();
            SubSelectExpr subSelectExpr = new SubSelectExpr(alias);
            subSelectExpr.setSelectExpr((SelectExpr) ctxExpr.get(ctx.select_stmt().select_or_values(0)));
            ctxExpr.put(ctx, subSelectExpr);
        }
    }

    @Override
    public void exitJoin_clause(SQLiteParser.Join_clauseContext ctx) {

        List<SQLiteParser.Table_or_subqueryContext> rangeTblContexts = ctx.table_or_subquery();
        List<SQLiteParser.Join_constraintContext> constraintContexts = ctx.join_constraint();

        if (rangeTblContexts.size() == 1) {
            RelationExpr relationExpr = (RelationExpr) ctxExpr.get(ctx.table_or_subquery(0));
            SelectExpr selectExpr = (SelectExpr) ctxExpr.get(ctx.getParent());
            selectExpr.setFromExpr(relationExpr);
        } else {
            JoinExpr joinExpr = null;
            RangeTableExpr leftRangeTblExpr = (RangeTableExpr) ctxExpr.get(rangeTblContexts.get(0));
            for (int i = 1; i < rangeTblContexts.size(); i++) {
                joinExpr = new JoinExpr();
                joinExpr.setLhs(leftRangeTblExpr);
                joinExpr.setRhs((RangeTableExpr) ctxExpr.get(rangeTblContexts.get(i)));

                if (rangeTblContexts.get(i - 1).table_alias() != null && rangeTblContexts.get(i - 1).table_alias().getText().toLowerCase().equals("natural") ||
                        ctx.join_operator(i - 1).getText().equals("naturaljoin")) {
                    joinExpr.setNatural(true);
                }

                SQLiteParser.Join_constraintContext constraint = constraintContexts.get(i - 1);
                if (constraint != null) {
                    if (constraint.K_ON() != null) {
                        QualifierExpr qualifierExpr = getQualifier(constraint.expr());

                        joinExpr.setQualifierExpr(qualifierExpr);
                    }

                    if (constraint.K_USING() != null) {
                        List<SQLiteParser.Column_nameContext> columnNameContexts = constraint.column_name();
                        ArrayList<ResultColumnExpr> usingExpr = joinExpr.getUsingExpr();
                        for (SQLiteParser.Column_nameContext context : columnNameContexts) {
                            ResultColumnExpr column = new ResultColumnExpr();
                            column.setAttrName(context.getText());
                            usingExpr.add(column);
                        }
                        joinExpr.setUsingExpr(usingExpr);
                    }
                }

                leftRangeTblExpr = joinExpr;
            }

            SelectExpr selectExpr = (SelectExpr) ctxExpr.get(ctx.getParent());
            selectExpr.setFromExpr(joinExpr);
        }
    }

    @Override
    public void exitWhere_clause(SQLiteParser.Where_clauseContext ctx) {
        SelectExpr selectExpr = (SelectExpr) ctxExpr.get(ctx.getParent());
        WhereExpr whereExpr = getWhereExpr(ctx.expr());
        selectExpr.setWhereExpr(whereExpr);
  }


    private boolean isInteger(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    private boolean isDouble(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }

    private QualifyEleExpr getQualifyEle(SQLiteParser.ExprContext exprCtx) {
        if (isInteger(exprCtx.getText())) {
            Integer integer = Integer.parseInt(exprCtx.getText());
            return new QualifyEleExpr(QualifyEleTypes.QUA_ELE_INT, integer);
        } else if (isDouble(exprCtx.getText())) {
            Double ele = Double.parseDouble(exprCtx.getText());
            return new QualifyEleExpr(QualifyEleTypes.QUA_ELE_FLOAT, ele);
        } else {
            ResultColumnExpr columnExpr = getColumnExpr(exprCtx);
            return new QualifyEleExpr(QualifyEleTypes.QUA_ELE_ATTR, columnExpr);
        }
    }

    private ResultColumnExpr getColumnExpr(SQLiteParser.ExprContext exprCtx) {
        ResultColumnExpr columnExpr = new ResultColumnExpr();
        if (exprCtx.database_name() != null)
            columnExpr.setDbName(exprCtx.database_name().getText());
        if (exprCtx.table_name() != null)
            columnExpr.setTableName(exprCtx.table_name().getText());
        if (exprCtx.column_name() != null)
            columnExpr.setAttrName(exprCtx.column_name().getText());
        return columnExpr;
    }

    private QualifierExpr getQualifier(SQLiteParser.ExprContext exprCtx) {
        checkQualifier(exprCtx);
        QualifierExpr qualifierExpr = new QualifierExpr();
        qualifierExpr.setQualifyTypes(getQualifyType(exprCtx));

        QualifyEleExpr leftEle = getQualifyEle(exprCtx.expr(0));
        qualifierExpr.setLhs(leftEle);

        QualifyEleExpr rightEle = getQualifyEle(exprCtx.expr(1));
        qualifierExpr.setRhs(rightEle);
        return qualifierExpr;
    }

    private QualifyTypes getQualifyType(SQLiteParser.ExprContext exprCtx) {
        if (exprCtx.ASSIGN() != null)
            return QualifyTypes.QUA_EQ;
        if (exprCtx.GT() != null)
            return QualifyTypes.QUA_GT;
        if (exprCtx.GT_EQ() != null)
            return QualifyTypes.QUA_GET;
        if (exprCtx.LT() != null)
            return QualifyTypes.QUA_LT;
        if (exprCtx.LT_EQ() != null)
            return QualifyTypes.QUA_LET;
        if (exprCtx.NOT_EQ2() != null)
            return QualifyTypes.QUA_NOT_EQ;
        return null;
    }
    
    private void checkQualifier(SQLiteParser.ExprContext exprCtx) {
        if (exprCtx.expr().size() != 2)
            throw new RuntimeException("Cannot parse qualifier:" + exprCtx.getText());
    }

    private OpTypes getWhereLogicalOperator(SQLiteParser.ExprContext exprCtx) {
        if (exprCtx.K_AND() != null)
            return OpTypes.OP_AND;
        if (exprCtx.K_OR() != null)
            return OpTypes.OP_OR;
        return null;
    }

    private WhereExpr getWhereExpr(SQLiteParser.ExprContext exprCtx) {
        if (isWhereTerminal(exprCtx)) {
            return getQualifier(exprCtx);
        }

        if (exprCtx.expr().size() == 1 && exprCtx.getText().equals("("+exprCtx.expr(0)+")")) {
            exprCtx = exprCtx.expr(0);
        }

        if (exprCtx.expr().size() == 2) {
            OpTypes op = getWhereLogicalOperator(exprCtx);
            if (op == null)
                throw new RuntimeException("Unable to parse:" + exprCtx.getText());

            SQLiteParser.ExprContext left = exprCtx.expr(0);
            SQLiteParser.ExprContext right = exprCtx.expr(1);
            WhereExpr whereLeft = getWhereExpr(left);
            WhereExpr whereRight = getWhereExpr(right);

            return new WhereExpr(whereLeft, whereRight, op);
        }
        throw new RuntimeException("Unable to parse:" + exprCtx.getText());
    }

    private boolean isWhereTerminal(SQLiteParser.ExprContext exprCtx) {
        checkQualifier(exprCtx);
        return (exprCtx.expr(0).column_name() != null || exprCtx.expr(0).literal_value() != null) &&
                (exprCtx.expr(1).column_name() != null || exprCtx.expr(1).literal_value() != null);
    }
}