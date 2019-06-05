package expression.select;

import disk.System;
import expression.Expression;
import utils.Utils;
import meta.ColumnInfo;
import meta.MetaData;
import meta.TableInfo;
import types.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * The select expression.
 *
 * <p>This class is the representation of a select expression.
 * It contains the column clause, from clause and where clause{@code nullable} of a select expression.
 * In addition, it provides multiple utility static function for information acquiring and validity checking.</p>
 *
 * @author Hao Lin
 * @version 1.0
 * @since 1.0
 */

public class SelectExpr extends Expression {

    private ArrayList<ResultColumnExpr> resultColumnExprs = new ArrayList<>();
    private RangeTableExpr fromExpr;
    private WhereExpr whereExpr;

    public SelectExpr() {
        super(ExprTypes.EXPR_SELECT);
    }

    public boolean insertResultColumns(ResultColumnExpr r) {
        for (ResultColumnExpr column : resultColumnExprs) {
            if (column.equals(r))
                return false;
        }
        resultColumnExprs.add(r);
        return true;
    }

    public ArrayList<ResultColumnExpr> getResultColumnExprs() {
        return resultColumnExprs;
    }

    public RangeTableExpr getFromExpr() {
        return fromExpr;
    }

    public void setFromExpr(RangeTableExpr fromExpr) {
        this.fromExpr = fromExpr;
    }

    public WhereExpr getWhereExpr() {
        return whereExpr;
    }

    public void setWhereExpr(WhereExpr whereExpr) {
        this.whereExpr = whereExpr;
    }

    /**
     * Acquire corresponding {@code ResultColumnExpr} variable with column name.
     * When the column has alias, it returns the column that has alias equaling column name.
     * Noticeably, the column variable is not a copy of the original column.
     * Thus, be careful when editing the return value of this function.
     *
     * @param columnName The column name of intended column.
     * @return {@code ResultColumnExpr} variable.
     */
    public ResultColumnExpr getColumn(String columnName) {
        for (ResultColumnExpr columnExpr : this.resultColumnExprs) {
            if (columnExpr.getName().equals(columnName))
                return columnExpr;
        }

        return null;
    }

    private void checkTableNames(HashMap<String, String> tableNames) throws IOException {
        String dbName = System.getCurDB().dataBaseName;
        for (String tableAlias : tableNames.keySet()) {
            String tableName = tableNames.get(tableAlias);
            if (tableName == null)
                continue;
            if (MetaData.isTableNotExist(dbName, tableName))
                throw new RuntimeException(tableName + " does not exist in " + dbName);
        }
    }

    private void checkColumnUniqueness(ArrayList<ResultColumnExpr> columnExprs) {
        for (int i = 0; i < columnExprs.size(); i++) {
            String columnName = columnExprs.get(i).getName();

            for (int j = 0; j < i; j++) {
                if (columnName.equals(columnExprs.get(j).getName()))
                    throw new RuntimeException("The expression can't have two identical column names");
            }
        }
    }

    @Override
    public void checkValidity() throws IOException {
        alterResultColumn();

        // Acquire the table names in the statement and verify sub-select statement
        ArrayList<RangeTableExpr> fromTableList = Utils.getFromTableList(fromExpr);
        HashMap<String, String> tableNames = Utils.getTableNameList(fromExpr);
        for (RangeTableExpr rangeTableExpr : fromTableList) {
            if (rangeTableExpr.getRtTypes() == RangeTableTypes.RT_SUB_QUERY) {
                SelectExpr selectExpr = ((SubSelectExpr) rangeTableExpr).getSelectExpr();
                selectExpr.checkValidity();
                selectExpr.checkColumnUniqueness(selectExpr.resultColumnExprs);
            }
            if (rangeTableExpr.getRtTypes() == RangeTableTypes.RT_RELATION && !((RelationExpr) rangeTableExpr).getDbName().equals(System.getCurDB().dataBaseName))
                throw new RuntimeException("Syntax error of writing database name in query statement");
        }

        // Verify the uniqueness of table names
        if (tableNames.size() != fromTableList.size())
            throw new RuntimeException("The from expression can't have two identical table names");

        // Verify the table names against database names
        checkTableNames(tableNames);

        // Verify the table names in the statement
        for (ResultColumnExpr columnExpr : resultColumnExprs) {
            Utils.checkColumnExpr(columnExpr, fromExpr, true);
        }

        // Verify the table names, on-clause and using-clause in from expression
        RangeTableExpr fromRoot = this.fromExpr;
        while (true) {
            if (fromRoot.getRtTypes() == RangeTableTypes.RT_SUB_QUERY ||
                    fromRoot.getRtTypes() == RangeTableTypes.RT_RELATION)
                break;
            else if (fromRoot.getRtTypes() == RangeTableTypes.RT_JOIN) {
                JoinExpr joinExpr = (JoinExpr) fromRoot;
                HashMap<String, String> tables = Utils.getTableNameList(joinExpr);

                if (joinExpr.isNatural() && (joinExpr.getQualifierExpr() != null || joinExpr.getUsingExpr() != null))
                    throw new RuntimeException("Natural join cannot have on-clause and using-clause");

                if (joinExpr.getQualifierExpr() != null) {
                    QualifierExpr qualifierExpr = joinExpr.getQualifierExpr();
                    ArrayList<QualifyEleExpr> attrELes = qualifierExpr.getAttrELes();
                    Utils.checkAttrEles(joinExpr, attrELes);
                    qualifierExpr.checkValidity(joinExpr);
                }

                if (joinExpr.getUsingExpr() != null) {
                    ArrayList<ResultColumnExpr> usingExpr = joinExpr.getUsingExpr();
                    checkColumnUniqueness(usingExpr);
                    for (ResultColumnExpr using : usingExpr) {
                        if (!using.getTableName().equals(""))
                            throw new RuntimeException("Using clause should not has table name");
                        Utils.checkColumnExpr(using, joinExpr.getLhs(), false);
                        Utils.checkColumnExpr(using, joinExpr.getRhs(), false);
                    }
                }

                fromRoot = joinExpr.getLhs();
            } else
                throw new RuntimeException("The from expression wasn't expanded correctly");
        }

        // Verify the table names in where-clause
        Utils.checkWhereClause(whereExpr, fromExpr);
        trimJoin();
    }

    public void trimWhere(HashSet<String> trimTargetTables) {
        if (whereExpr != null)
            whereExpr.trim(trimTargetTables);
    }

    @SuppressWarnings("ConstantConditions")
    private LinkedHashSet<String> getColumns(RangeTableExpr table) throws IOException {
        LinkedHashSet<String> result = new LinkedHashSet<>();
        if (table.getRtTypes().equals(RangeTableTypes.RT_SUB_QUERY)) {
            for (ResultColumnExpr columnExpr : ((SubSelectExpr) table).getSelectExpr().getResultColumnExprs()) {
                result.add(columnExpr.getAttrName());
            }
        } else if (table.getRtTypes().equals(RangeTableTypes.RT_RELATION)) {
            TableInfo tableInfo = MetaData.getTableInfoByName(System.getCurDB().dataBaseName, ((RelationExpr) table).getTableName());
            for (ColumnInfo columnInfo : tableInfo.columns) {
                result.add(columnInfo.columnName);
            }
        } else {
            throw new RuntimeException("Table must be relation or sub query");
        }

        return result;
    }

    private void trimJoin() throws IOException {
        alterJoinQualifier(fromExpr);
    }

    private void alterResultColumn() throws IOException {
        if (resultColumnExprs.size() == 1 && resultColumnExprs.get(0).getAttrName().equals("*")) {
            resultColumnExprs.clear();
            RangeTableExpr root = fromExpr;
            while (true) {
                if (root.getRtTypes() == RangeTableTypes.RT_RELATION ||
                        root.getRtTypes() == RangeTableTypes.RT_SUB_QUERY) {
                    for (String columnName : root.getColumnNames()) {
                        ResultColumnExpr columnExpr = new ResultColumnExpr();
                        columnExpr.setTableName(root.getRangeTableName());
                        columnExpr.setAttrName(columnName);
                        resultColumnExprs.add(0, columnExpr);
                    }
                    return;
                } else if (root.getRtTypes() == RangeTableTypes.RT_JOIN) {
                    RangeTableExpr right = ((JoinExpr) root).getRhs();
                    for (String columnName : right.getColumnNames()) {
                        ResultColumnExpr columnExpr = new ResultColumnExpr();
                        columnExpr.setTableName(right.getRangeTableName());
                        columnExpr.setAttrName(columnName);
                        resultColumnExprs.add(0, columnExpr);
                    }
                    root = ((JoinExpr) root).getLhs();
                } else
                    throw new RuntimeException("The from expression wasn't expanded correctly");
            }
        }
    }

    private void alterJoinQualifier(RangeTableExpr root) throws IOException {
        if (root.getRtTypes().equals(RangeTableTypes.RT_JOIN)) {
            JoinExpr joinExpr = (JoinExpr) root;
            if (joinExpr.getQualifierExpr() != null) {
                whereExpr = new WhereExpr(joinExpr.getQualifierExpr(), whereExpr, OpTypes.OP_AND);
            }
            if (joinExpr.getUsingExpr() != null) {
                ArrayList<ResultColumnExpr> usingExpr = joinExpr.getUsingExpr();
                for (ResultColumnExpr using : usingExpr) {
                    if (!using.getTableName().equals(""))
                        throw new RuntimeException("Using clause should not has table name");
                    try {
                        ResultColumnExpr rightUsing = using.clone();
                        ResultColumnExpr leftUsing = using.clone();
                        Utils.checkColumnExpr(leftUsing, joinExpr.getLhs(), true);
                        Utils.checkColumnExpr(rightUsing, joinExpr.getRhs(), true);

                        QualifyEleExpr leftEle = new QualifyEleExpr(QualifyEleTypes.QUA_ELE_ATTR, leftUsing);
                        QualifyEleExpr rightEle = new QualifyEleExpr(QualifyEleTypes.QUA_ELE_ATTR, rightUsing);

                        QualifierExpr qualifierExpr = new QualifierExpr(QualifyTypes.QUA_EQ, leftEle, rightEle);

                        whereExpr = new WhereExpr(whereExpr, qualifierExpr, OpTypes.OP_AND);
                    } catch (CloneNotSupportedException e) {
                        throw new RuntimeException("Class cast error");
                    }
                }
            }
            if (joinExpr.isNatural() && joinExpr.getQualifierExpr() == null && joinExpr.getUsingExpr() == null) {
                RangeTableExpr right = joinExpr.getRhs();
                HashSet<String> rightColumnNames = getColumns(right);
                RangeTableExpr left = joinExpr.getLhs();
                LinkedHashSet<String> leftColumnNames;
                if (left.getRtTypes().equals(RangeTableTypes.RT_JOIN))
                    leftColumnNames = getColumns(((JoinExpr) left).getRhs());
                else
                    leftColumnNames = getColumns(left);
                LinkedHashSet<String> interColumns = new LinkedHashSet<>(rightColumnNames);
                interColumns.retainAll(leftColumnNames);
                for (String columnName : interColumns) {
                    ResultColumnExpr leftColumn = new ResultColumnExpr();
                    leftColumn.setTableName(left.getRangeTableName());
                    leftColumn.setAttrName(columnName);
                    QualifyEleExpr leftEle = new QualifyEleExpr(QualifyEleTypes.QUA_ELE_ATTR, leftColumn);

                    ResultColumnExpr rightColumn = new ResultColumnExpr();
                    rightColumn.setTableName(right.getRangeTableName());
                    rightColumn.setAttrName(columnName);
                    QualifyEleExpr rightEle = new QualifyEleExpr(QualifyEleTypes.QUA_ELE_ATTR, leftColumn);

                    QualifierExpr qualifierExpr = new QualifierExpr(QualifyTypes.QUA_EQ, leftEle, rightEle);
                    whereExpr = new WhereExpr(whereExpr, qualifierExpr, OpTypes.OP_AND);
                }
            }

            alterJoinQualifier(joinExpr.getLhs());
        }
    }
}
