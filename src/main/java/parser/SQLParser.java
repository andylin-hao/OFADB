package parser;

import expression.Expression;
import expression.create.ColumnDefExpr;
import expression.create.CreateDBExpr;
import expression.create.CreateTableExpr;
import expression.create.TableConstraintExpr;
import expression.delete.DeleteExpr;
import expression.drop.DropDBExpr;
import expression.drop.DropTableExpr;
import expression.insert.InsertExpr;
import expression.select.*;
import expression.show.ShowDBExpr;
import expression.show.ShowTableExpr;
import expression.update.UpdateExpr;
import types.*;
import expression.use.UseDBExpr;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * A parser for SQL language based on ANTLR-4
 *
 * <p>This class provides the implementation of the ANTLR listener.
 * Despite the fact that certain features of SQL are omitted,
 * this class does complete the basic structure of a SQL parser.
 * For detail functions of this class, please refer to the official
 * document of ANTLR-4: https://github.com/antlr/antlr4/blob/master/doc/index.md</p>
 *
 * @author Hao Lin
 * @version 1.0
 * @since 1.0
 */

public class SQLParser extends SQLiteBaseListener {
    private Expression expr;
    private ParseTreeProperty<Expression> ctxExpr = new ParseTreeProperty<>();

    /**
     * This function if for acquiring the parsing result.
     * @return A {@code Expression} type variable.
     */
    public Expression getExpr() {
        return expr;
    }

    @Override
    public void exitCreate_table_stmt(SQLiteParser.Create_table_stmtContext ctx) {
        String dbName = "";
        if (ctx.database_name() != null)
            dbName = ctx.database_name().getText().toLowerCase();
        expr = new CreateTableExpr(dbName, ctx.table_name().getText().toLowerCase());
        CreateTableExpr createTableExpr = (CreateTableExpr) expr;
        HashMap<String, ColumnDefExpr> columnExprs = new HashMap<>();

        List<SQLiteParser.Column_defContext> columnDefContexts = ctx.column_def();
        for (SQLiteParser.Column_defContext defCtx : columnDefContexts) {
            String columnName = defCtx.column_name().getText().toLowerCase();
            ColumnTypes columnType = ColumnTypes.valueOf("COL_" + defCtx.type_name().name().getText().toUpperCase());
            int signedNum = 0;
            if (defCtx.type_name().signed_number().size() > 0 && defCtx.type_name().signed_number() != null) {
                if (defCtx.type_name().signed_number().size() == 1)
                    signedNum = Integer.parseInt(defCtx.type_name().signed_number(0).getText().toLowerCase());
                else
                    throw new RuntimeException("Unable to parse:" + defCtx.getText().toLowerCase());
            }
            ColumnDefExpr columnDefExpr = new ColumnDefExpr(columnName, columnType, signedNum);
            columnExprs.put(columnName, columnDefExpr);

            List<SQLiteParser.Column_constraintContext> columnConstraintContexts = defCtx.column_constraint();
            for (SQLiteParser.Column_constraintContext colConstraintCtx : columnConstraintContexts) {
                ColumnConstraintTypes type = getColConstraintType(colConstraintCtx);
                columnDefExpr.getConstraintTypes().add(type);
            }

            createTableExpr.getColumnDefExprs().add(columnDefExpr);
        }

        List<SQLiteParser.Table_constraintContext> tableConstraintContexts = ctx.table_constraint();
        for (SQLiteParser.Table_constraintContext tblConstraintCtx : tableConstraintContexts) {
            TableConstraintTypes tblConstraintType = getTableConstraintType(tblConstraintCtx);
            TableConstraintExpr tblConstraintExpr = new TableConstraintExpr(tblConstraintType);

            List<SQLiteParser.Indexed_columnContext> columnContexts = tblConstraintCtx.indexed_column();
            for (SQLiteParser.Indexed_columnContext columnCtx : columnContexts) {
                ColumnDefExpr column = columnExprs.get(columnCtx.getText().toLowerCase());
                if (column == null) {
                    throw new RuntimeException("Table constraint incorrect:" + tblConstraintCtx.getText().toLowerCase());
                } else {
                    tblConstraintExpr.getColumns().add(column);
                }
            }

            createTableExpr.getTableConstraintExprs().add(tblConstraintExpr);
        }
    }

    @Override
    public void exitCreate_database_stmt(SQLiteParser.Create_database_stmtContext ctx) {
        expr = new CreateDBExpr(ctx.database_name().getText().toLowerCase());
    }

    @Override
    public void enterDelete_stmt(SQLiteParser.Delete_stmtContext ctx) {
        String dbName = "";
        if (ctx.qualified_table_name().database_name() != null)
            dbName = ctx.qualified_table_name().database_name().getText().toLowerCase();
        expr = new DeleteExpr(dbName, ctx.qualified_table_name().table_name().getText().toLowerCase());
        ctxExpr.put(ctx, expr);
    }

    @Override
    public void exitDrop_table_stmt(SQLiteParser.Drop_table_stmtContext ctx) {
        String dbName = "";
        if (ctx.database_name() != null)
            dbName = ctx.database_name().getText().toLowerCase();
        expr = new DropTableExpr(dbName, ctx.table_name().getText().toLowerCase());
    }

    @Override
    public void exitDrop_database_stmt(SQLiteParser.Drop_database_stmtContext ctx) {
        expr = new DropDBExpr(ctx.database_name().getText().toLowerCase());
    }

    @Override
    public void exitParse(SQLiteParser.ParseContext ctx) {
        try {
            expr.checkValidity();
        } catch (IOException e) {
            throw new RuntimeException("IO error");
        }
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

        if (ctx.expr() == null && ctx.getText().toLowerCase().equals("*"))
            resultColumnExpr.setAttrName("*");
        else {
            if (ctx.expr() == null)
                throw new RuntimeException("Unable to parse \"" + ctx.getText().toLowerCase() + "\"");
            resultColumnExpr = getColumnExpr(ctx.expr());
            if (ctx.column_alias() != null)
                resultColumnExpr.setAlias(ctx.column_alias().getText().toLowerCase());
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
    public void exitShow_database_stmt(SQLiteParser.Show_database_stmtContext ctx) {
        if (ctx.K_DATABASES() != null) {
            expr = new ShowDBExpr();
        } else if (ctx.K_DATABASE() != null) {
            expr = new ShowDBExpr(ctx.database_name().getText().toLowerCase());
        } else {
            throw new RuntimeException("Unable to parse:" + ctx.getText().toLowerCase());
        }
    }

    @Override
    public void exitShow_table_stmt(SQLiteParser.Show_table_stmtContext ctx) {
        String dbName = "";
        if (ctx.database_name() != null)
            dbName = ctx.database_name().getText().toLowerCase();
        expr = new ShowTableExpr(dbName, ctx.table_name().getText().toLowerCase());
    }

    @Override
    public void exitTable_or_subquery(SQLiteParser.Table_or_subqueryContext ctx) {
        if (ctx.table_name() != null) {
            String tableName = "", dbName = "", alias = "";
            if (ctx.table_name() != null)
                tableName = ctx.table_name().getText().toLowerCase();
            if (ctx.database_name() != null)
                dbName = ctx.database_name().getText().toLowerCase();
            if (ctx.table_alias() != null)
                alias = ctx.table_alias().getText().toLowerCase();
            RelationExpr relationExpr = new RelationExpr(tableName, alias, dbName);
            ctxExpr.put(ctx, relationExpr);
        } else if (ctx.select_stmt() != null) {
            String alias = "";
            if (ctx.table_alias() != null)
                alias = ctx.table_alias().getText().toLowerCase();
            SubSelectExpr subSelectExpr = new SubSelectExpr(alias);
            subSelectExpr.setSelectExpr((SelectExpr) ctxExpr.get(ctx.select_stmt().select_or_values(0)));
            ctxExpr.put(ctx, subSelectExpr);
        }
    }

    @Override
    public void exitInsert_stmt(SQLiteParser.Insert_stmtContext ctx) {
        String dbName = "";
        if (ctx.database_name() != null) {
            dbName = ctx.database_name().getText().toLowerCase();
        }
        expr = new InsertExpr(dbName, ctx.table_name().getText().toLowerCase());
        InsertExpr insertExpr = (InsertExpr) expr;

        List<SQLiteParser.Column_nameContext> columnContexts = ctx.column_name();
        for (SQLiteParser.Column_nameContext columnCtx : columnContexts) {
            insertExpr.getColumns().add(columnCtx.getText().toLowerCase());
        }

        List<SQLiteParser.Insert_value_stmtContext> valueContexts = ctx.insert_value_stmt();
        for (int i = 0; i < valueContexts.size(); i++) {
            SQLiteParser.Insert_value_stmtContext valueCtx = valueContexts.get(i);
            List<SQLiteParser.ExprContext> exprContexts = valueCtx.expr();
            insertExpr.getValues().add(new ArrayList<>());
            for (SQLiteParser.ExprContext exprCtx : exprContexts) {
                Object value = getValue(exprCtx);
                if (value instanceof ResultColumnExpr)
                    throw new RuntimeException("Illegal insert values");
                insertExpr.getValues().get(i).add(value);
            }
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

                if (rangeTblContexts.get(i - 1).table_alias() != null &&
                        rangeTblContexts.get(i - 1).table_alias().getText().toLowerCase().toLowerCase().equals("natural") ||
                        ctx.join_operator(i - 1).getText().toLowerCase().equals("naturaljoin")) {
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
                            column.setAttrName(context.getText().toLowerCase());
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
        WhereExpr whereExpr = getWhereExpr(ctx.expr());
        Expression expression = ctxExpr.get(ctx.getParent());

        switch (expression.getExprType()) {
            case EXPR_SELECT:
                SelectExpr selectExpr = (SelectExpr) expression;
                selectExpr.setWhereExpr(whereExpr);
                break;
            case EXPR_UPDATE:
                UpdateExpr updateExpr = (UpdateExpr) expression;
                updateExpr.setWhereExpr(whereExpr);
                break;
            case EXPR_DELETE:
                DeleteExpr deleteExpr = (DeleteExpr) expression;
                deleteExpr.setWhereExpr(whereExpr);
                break;
            default:
                throw new RuntimeException("Illegal parent of where clause");
        }
    }

    @Override
    public void enterUpdate_stmt(SQLiteParser.Update_stmtContext ctx) {
        String dbName = "";
        if (ctx.qualified_table_name().database_name() != null) {
            dbName = ctx.qualified_table_name().database_name().getText().toLowerCase();
        }
        expr = new UpdateExpr(dbName, ctx.qualified_table_name().table_name().getText().toLowerCase());
        UpdateExpr updateExpr = (UpdateExpr) expr;

        List<SQLiteParser.Update_values_stmtContext> valuesContexts = ctx.update_values_stmt();
        for (SQLiteParser.Update_values_stmtContext valueCtx : valuesContexts) {
            updateExpr.getAttrNames().add(valueCtx.column_name().getText().toLowerCase());
            updateExpr.getValues().add(getValue(valueCtx.expr()));
        }

        ctxExpr.put(ctx, expr);
    }

    @Override
    public void enterUse_database_stmt(SQLiteParser.Use_database_stmtContext ctx) {
        expr = new UseDBExpr(ctx.database_name().getText().toLowerCase());
    }

    private QualifyEleExpr getQualifyEle(SQLiteParser.ExprContext exprCtx) {
        Object value = getValue(exprCtx);
        Class valueClass = Objects.requireNonNull(value).getClass();
        if (valueClass == Long.class) {
            return new QualifyEleExpr(QualifyEleTypes.QUA_ELE_INT, value);
        } else if (valueClass == Double.class) {
            return new QualifyEleExpr(QualifyEleTypes.QUA_ELE_DOUBLE, value);
        } else if (valueClass == FormulaExpr.class) {
            return new QualifyEleExpr(QualifyEleTypes.QUA_ELE_FORMULA, value);
        } else if (valueClass == Boolean.class) {
            return new QualifyEleExpr(QualifyEleTypes.QUA_ELE_BOOL, value);
        } else if (valueClass == String.class) {
            return new QualifyEleExpr(QualifyEleTypes.QUA_ELE_STR, value);
        } else if (valueClass == ResultColumnExpr.class) {
            return new QualifyEleExpr(QualifyEleTypes.QUA_ELE_ATTR, value);
        } else
            throw new RuntimeException("Unable to parse:" + exprCtx.getText().toLowerCase());
    }

    private Object getValue(SQLiteParser.ExprContext exprCtx) {
        String text = exprCtx.getText().toLowerCase();
        if (isNull(text))
            return null;
        else if (isInteger(text))
            return Long.parseLong(text);
        else if (isDouble(text))
            return Double.parseDouble(text);
        else if (isBool(text))
            return Boolean.parseBoolean(text.toLowerCase());
        else if (isStr(text))
            return text.substring(1, text.length() - 1);
        else if (isFormula(exprCtx))
            return getFormulaExpr(exprCtx);
        else
            return getColumnExpr(exprCtx);
    }

    private ResultColumnExpr getColumnExpr(SQLiteParser.ExprContext exprCtx) {
        ResultColumnExpr columnExpr = new ResultColumnExpr();
        if (exprCtx.database_name() != null)
            columnExpr.setDbName(exprCtx.database_name().getText().toLowerCase());
        if (exprCtx.table_name() != null)
            columnExpr.setTableName(exprCtx.table_name().getText().toLowerCase());
        if (exprCtx.column_name() != null)
            columnExpr.setAttrName(exprCtx.column_name().getText().toLowerCase());
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

    private OpTypes getOperator(SQLiteParser.ExprContext exprCtx) {
        if (exprCtx.K_AND() != null)
            return OpTypes.OP_AND;
        if (exprCtx.K_OR() != null)
            return OpTypes.OP_OR;
        if (exprCtx.STAR() != null)
            return OpTypes.OP_MUL;
        if (exprCtx.DIV() != null)
            return OpTypes.OP_DIV;
        if (exprCtx.MOD() != null)
            return OpTypes.OP_MOD;
        if (exprCtx.PLUS() != null)
            return OpTypes.OP_PLUS;
        if (exprCtx.MINUS() != null)
            return OpTypes.OP_MINUS;
        return null;
    }

    private WhereExpr getWhereExpr(SQLiteParser.ExprContext exprCtx) {
        if (isWhereTerminal(exprCtx)) {
            return getQualifier(exprCtx);
        }

        if (exprCtx.expr().size() == 1 && exprCtx.getText().toLowerCase().equals("(" + exprCtx.expr(0) + ")")) {
            exprCtx = exprCtx.expr(0);
        }

        if (exprCtx.expr().size() == 2) {
            OpTypes op = getOperator(exprCtx);
            if (op == null)
                throw new RuntimeException("Unable to parse:" + exprCtx.getText().toLowerCase());

            SQLiteParser.ExprContext left = exprCtx.expr(0);
            SQLiteParser.ExprContext right = exprCtx.expr(1);
            WhereExpr whereLeft = getWhereExpr(left);
            WhereExpr whereRight = getWhereExpr(right);

            return new WhereExpr(whereLeft, whereRight, op);
        }
        throw new RuntimeException("Unable to parse:" + exprCtx.getText().toLowerCase());
    }

    private FormulaExpr getFormulaExpr(SQLiteParser.ExprContext exprCtx) {
        if (isInteger(exprCtx.getText().toLowerCase())) {
            return new FormulaNodeExpr(Integer.parseInt(exprCtx.getText().toLowerCase()));
        } else if (isDouble(exprCtx.getText().toLowerCase())) {
            return new FormulaNodeExpr(Double.parseDouble(exprCtx.getText().toLowerCase()));
        } else {
            if (exprCtx.expr().size() == 1) {
                exprCtx = exprCtx.expr(0);
            }
            if (exprCtx.expr().size() == 2) {
                OpTypes op = getOperator(exprCtx);
                FormulaExpr left = getFormulaExpr(exprCtx.expr(0));
                FormulaExpr right = getFormulaExpr(exprCtx.expr(1));
                return new FormulaExpr(left, right, op);
            }
            throw new RuntimeException("Unable to parse:" + exprCtx.getText().toLowerCase());
        }
    }

    private ColumnConstraintTypes getColConstraintType(SQLiteParser.Column_constraintContext exprCtx) {
        switch (exprCtx.getText().toLowerCase().toLowerCase()) {
            case "notnull":
                return ColumnConstraintTypes.COL_NOT_NULL;
            case "primarykey":
                return ColumnConstraintTypes.COL_PRIMARY_KEY;
            case "primarykeyautoincrement":
                return ColumnConstraintTypes.COL_AUTO_INC;
            case "unique":
                return ColumnConstraintTypes.COL_UNIQUE;
            default:
                throw new RuntimeException("Unsupported column constraint type");
        }
    }

    private TableConstraintTypes getTableConstraintType(SQLiteParser.Table_constraintContext exprCtx) {
        String str = exprCtx.getText().toLowerCase().toLowerCase();
        if (str.startsWith("primarykey"))
            return TableConstraintTypes.TBL_PRIMARY_KEY;
        else
            throw new RuntimeException("Unsupported column constraint type");
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

    private boolean isBool(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        return str.toLowerCase().equals("true") || str.toLowerCase().equals("false");
    }

    private boolean isNull(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        return str.toLowerCase().equals("null");
    }

    private boolean isStr(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        return str.startsWith("\"") && str.endsWith("\"") || str.startsWith("\'") && str.endsWith("\'");
    }

    private boolean isFormula(SQLiteParser.ExprContext exprCtx) {
        return exprCtx.STAR() != null || exprCtx.DIV() != null || exprCtx.MOD() != null || exprCtx.PLUS() != null || exprCtx.MINUS() != null;
    }

    private boolean isWhereTerminal(SQLiteParser.ExprContext exprCtx) {
        checkQualifier(exprCtx);
        return (exprCtx.expr(0).column_name() != null || exprCtx.expr(0).literal_value() != null || isFormula(exprCtx.expr(0))) &&
                (exprCtx.expr(1).column_name() != null || exprCtx.expr(1).literal_value() != null || isFormula(exprCtx.expr(1)));
    }

    private void checkQualifier(SQLiteParser.ExprContext exprCtx) {
        if (exprCtx.expr().size() != 2)
            throw new RuntimeException("Cannot parse qualifier:" + exprCtx.getText().toLowerCase());
    }
}