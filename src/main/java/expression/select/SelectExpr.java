package expression.select;

import disk.System;
import expression.Expression;
import meta.MetaData;
import types.ColumnTypes;
import types.ExprTypes;
import types.QualifyEleTypes;
import types.RangeTableTypes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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

    private RangeTableExpr getFromExpr() {
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

    private ResultColumnExpr getColumn(String columnName) {
        for (ResultColumnExpr columnExpr : this.resultColumnExprs) {
            if (columnExpr.getName().equals(columnName))
                return columnExpr;
        }

        return null;
    }

    private ArrayList<RangeTableExpr> getFromTableList(RangeTableExpr root) {
        ArrayList<RangeTableExpr> result = new ArrayList<>();
        while (true) {
            if (root.getRtTypes() == RangeTableTypes.RT_RELATION ||
                    root.getRtTypes() == RangeTableTypes.RT_SUB_QUERY) {
                result.add(root);
                return result;
            } else if (root.getRtTypes() == RangeTableTypes.RT_JOIN) {
                result.add(((JoinExpr) root).getRhs());
                root = ((JoinExpr) root).getLhs();
            } else
                throw new RuntimeException("The from expression wasn't expanded correctly");
        }
    }

    private HashMap<String, String> getTableNameList(RangeTableExpr root) {
        ArrayList<RangeTableExpr> fromTableList = getFromTableList(root);
        HashMap<String, String> tableNames = new HashMap<>();
        for (RangeTableExpr tableExpr : fromTableList) {
            if (tableExpr.getRtTypes() == RangeTableTypes.RT_SUB_QUERY) {
                SubSelectExpr subSelectExpr = (SubSelectExpr) tableExpr;
                if (subSelectExpr.getAlias() == null)
                    throw new RuntimeException("The sub-select statement needs an alias");
                tableNames.put(((SubSelectExpr) tableExpr).getAlias(), null);
            } else if (tableExpr.getRtTypes() == RangeTableTypes.RT_RELATION) {
                RelationExpr relationExpr = (RelationExpr) tableExpr;
                if (!relationExpr.getAlias().equals(""))
                    tableNames.put(relationExpr.getAlias(), relationExpr.getTableName());
                else {
                    tableNames.put(relationExpr.getTableName(), relationExpr.getTableName());
                }
            } else
                throw new RuntimeException("The from expression wasn't expanded correctly");
        }
        return tableNames;
    }

    private void checkWhereClause(WhereExpr root) {
        if (root.getExprType() == ExprTypes.EXPR_QUALIFIER) {
            QualifierExpr qualifierExpr = ((QualifierExpr) root);
            ArrayList<QualifyEleExpr> attrELes = qualifierExpr.getAttrELes();
            checkAttrEles(fromExpr, attrELes);
            qualifierExpr.checkValidity(this, fromExpr);
        } else {
            checkWhereClause(root.getRight());
            checkWhereClause(root.getLeft());
        }
    }

    private void checkAttrEles(RangeTableExpr rangeTableExpr, ArrayList<QualifyEleExpr> attrELes) {
        for (QualifyEleExpr eleExpr : attrELes) {
            ResultColumnExpr attr = (ResultColumnExpr) eleExpr.getValue();
            checkColumnExpr(attr, rangeTableExpr);
        }
    }

    private void checkTableNames(HashMap<String, String> tableNames) {
        String dbName = System.getCurDB().dataBaseName;
        for (String tableAlias : tableNames.keySet()) {
            try {
                String tableName = tableNames.get(tableAlias);
                if (tableName == null)
                    continue;
                if (MetaData.isTableNotExist(dbName, tableName))
                    throw new RuntimeException(tableName + " does not exist in " + dbName);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    @SuppressWarnings("ConstantConditions")
    ColumnTypes checkColumnExpr(ResultColumnExpr columnExpr, RangeTableExpr rangeTableExpr) {
        ArrayList<RangeTableExpr> fromTableList = getFromTableList(rangeTableExpr);
        HashMap<String, String> tableNames = getTableNameList(rangeTableExpr);
        String dbName = System.getCurDB().dataBaseName;
        String tableName = tableNames.get(columnExpr.getTableName());
        SubSelectExpr subSelectExpr = null;

        if (!columnExpr.getDbName().equals(""))
            throw new RuntimeException("Syntax error of writing database name in query statement");

        // Verify column name that has no table name
        if (columnExpr.getTableName().equals("")) {
            int occurTimes = 0;
            for (RangeTableExpr fromExpr : fromTableList) {
                if (fromExpr.getRtTypes() == RangeTableTypes.RT_SUB_QUERY &&
                        ((SubSelectExpr) fromExpr).getSelectExpr().getColumn(columnExpr.getAttrName()) != null) {
                    occurTimes += 1;
                    subSelectExpr = (SubSelectExpr) fromExpr;
                    tableName = null;
                    columnExpr.setTableName(subSelectExpr.getAlias());
                } else {
                    try {
                        if (fromExpr.getRtTypes() == RangeTableTypes.RT_RELATION &&
                                MetaData.isColumnExist(dbName, ((RelationExpr) fromExpr).getTableName(), columnExpr.getAttrName())) {
                            occurTimes += 1;
                            tableName = ((RelationExpr) fromExpr).getTableName();
                            columnExpr.setTableName(((RelationExpr) fromExpr).getName());
                        }
                    } catch (IOException e) {
                        throw new RuntimeException("IO error");
                    }
                }
            }

            if (occurTimes == 0)
                throw new RuntimeException("Column name " + columnExpr.getAttrName() + " does not exist");
            if (occurTimes > 1)
                throw new RuntimeException("Ambiguous column name " + columnExpr.getAttrName());
            else{
                if (tableName == null) {
                    SelectExpr selectExpr = subSelectExpr.getSelectExpr();
                    return selectExpr.checkColumnExpr(selectExpr.getColumn(columnExpr.getAttrName()), selectExpr.getFromExpr());
                } else {
                    try {
                        return MetaData.getColumnType(System.getCurDB().dataBaseName, tableName, columnExpr.getAttrName()).columnType.typeCode;
                    } catch (IOException e) {
                        throw new RuntimeException("IO error");
                    }
                }
            }
        }

        // Verify column name of sub query or not-exist table name
        if (tableName == null) {
            for (RangeTableExpr fromExpr : fromTableList) {
                if (fromExpr.getRtTypes() == RangeTableTypes.RT_SUB_QUERY &&
                        ((SubSelectExpr) fromExpr).getAlias().equals(columnExpr.getTableName())) {
                    if (((SubSelectExpr) fromExpr).getSelectExpr().getColumn(columnExpr.getAttrName()) == null)
                        throw new RuntimeException("Column name " + columnExpr.getAttrName() + " does not exist");
                    else {
                        SelectExpr selectExpr = ((SubSelectExpr) fromExpr).getSelectExpr();
                        return selectExpr.checkColumnExpr(selectExpr.getColumn(columnExpr.getAttrName()), selectExpr.getFromExpr());
                    }
                }
            }
            throw new RuntimeException("Table name " + columnExpr.getTableName() + " does not exist");
        }

        // Verify column name of relation
        try {
            if (!MetaData.isColumnExist(dbName, tableName, columnExpr.getAttrName()))
                throw new RuntimeException("Column " + columnExpr.getAttrName() + " does not exist in table " + tableName);
            else {
                return MetaData.getColumnType(System.getCurDB().dataBaseName, tableName, columnExpr.getAttrName()).columnType.typeCode;
            }
        } catch (IOException e) {
            throw new RuntimeException("IO error");
        }
    }

    private void checkColumnUniqueness(ArrayList<ResultColumnExpr> columnExprs) {
        for (int i = 0; i < columnExprs.size(); i++) {
            String columnName = columnExprs.get(i).getName();

            for (int j = 0; j < i; j++) {
                if (columnName.equals(columnExprs.get(i).getName()))
                    throw new RuntimeException("The expression can't have two identical column names");
            }
        }
    }

    @Override
    public void checkValidity() {
        // Acquire the table names in the statement and verify sub-select statement
        ArrayList<RangeTableExpr> fromTableList = getFromTableList(fromExpr);
        HashMap<String, String> tableNames = getTableNameList(fromExpr);
        for (RangeTableExpr rangeTableExpr : fromTableList) {
            if (rangeTableExpr.getRtTypes() == RangeTableTypes.RT_SUB_QUERY)
                ((SubSelectExpr) rangeTableExpr).getSelectExpr().checkValidity();
            if (rangeTableExpr.getRtTypes() == RangeTableTypes.RT_RELATION && !((RelationExpr) rangeTableExpr).getDbName().equals(""))
                throw new RuntimeException("Syntax error of writing database name in query statement");
        }

        checkColumnUniqueness(resultColumnExprs);

        // Verify the uniqueness of table names
        if (tableNames.size() != fromTableList.size())
            throw new RuntimeException("The from expression can't have two identical table names");

        // Verify the table names against database names
        checkTableNames(tableNames);

        // Verify the table names in the statement
        for (ResultColumnExpr columnExpr : resultColumnExprs) {
            checkColumnExpr(columnExpr, fromExpr);
        }

        // Verify the table names, on-clause and using-clause in from expression
        RangeTableExpr fromRoot = this.fromExpr;
        while (true) {
            if (fromRoot.getRtTypes() == RangeTableTypes.RT_SUB_QUERY ||
                    fromRoot.getRtTypes() == RangeTableTypes.RT_RELATION)
                break;
            else if (fromRoot.getRtTypes() == RangeTableTypes.RT_JOIN) {
                JoinExpr joinExpr = (JoinExpr) fromRoot;
                HashMap<String, String> tables = getTableNameList(joinExpr);

                if (joinExpr.isNatural() && (joinExpr.getQualifierExpr() != null || joinExpr.getUsingExpr() != null))
                    throw new RuntimeException("Natural join cannot have on-clause and using-clause");

                if (joinExpr.getQualifierExpr() != null) {
                    QualifierExpr qualifierExpr = joinExpr.getQualifierExpr();
                    ArrayList<QualifyEleExpr> attrELes = qualifierExpr.getAttrELes();
                    checkAttrEles(joinExpr, attrELes);
                    qualifierExpr.checkValidity(this, joinExpr);
                }

                if (joinExpr.getUsingExpr() != null) {
                    ArrayList<ResultColumnExpr> usingExpr = joinExpr.getUsingExpr();
                    checkColumnUniqueness(usingExpr);
                    for (ResultColumnExpr using : usingExpr) {
                        if (!using.getTableName().equals(""))
                            throw new RuntimeException("Using clause should not has table name");
                        checkColumnExpr(using, joinExpr.getLhs());
                        checkColumnExpr(using, joinExpr.getRhs());
                    }
                }

                fromRoot = joinExpr.getLhs();
            } else
                throw new RuntimeException("The from expression wasn't expanded correctly");
        }

        // Verify the table names in where-clause
        checkWhereClause(whereExpr);
    }
}
