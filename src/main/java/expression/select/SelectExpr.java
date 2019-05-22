package expression.select;

import expression.Expression;
import types.ExprTypes;
import types.RangeTableTypes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

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

    private HashSet<String> getTableNameList(RangeTableExpr root) {
        ArrayList<RangeTableExpr> fromTableList = getFromTableList(root);
        HashSet<String> tableNames = new HashSet<>();
        for (RangeTableExpr tableExpr : fromTableList) {
            if (tableExpr.getRtTypes() == RangeTableTypes.RT_SUB_QUERY) {
                SubSelectExpr subSelectExpr = (SubSelectExpr) tableExpr;
                if (subSelectExpr.getAlias() == null)
                    throw new RuntimeException("The sub-select statement needs an alias");
                tableNames.add(((SubSelectExpr) tableExpr).getAlias());
            } else if (tableExpr.getRtTypes() == RangeTableTypes.RT_RELATION) {
                RelationExpr relationExpr = (RelationExpr) tableExpr;
                if (!relationExpr.getAlias().equals(""))
                    tableNames.add(relationExpr.getAlias());
                else {
                    if (!relationExpr.getDbName().equals(""))
                        tableNames.add(relationExpr.getDbName() + "." + relationExpr.getTableName());
                    else
                        tableNames.add(relationExpr.getTableName());
                }
            } else
                throw new RuntimeException("The from expression wasn't expanded correctly");
        }
        return tableNames;
    }

    private void checkWhereClause(WhereExpr root) {
        if (root.getExprType() == ExprTypes.EXPR_QUALIFIER) {
            HashSet<String> tableNames = getTableNameList(fromExpr);
            ArrayList<QualifyEleExpr> attrELes = ((QualifierExpr) root).getAttrELes();
            checkAttrEles(tableNames, attrELes, "where");
        } else {
            checkWhereClause(root.getRight());
            checkWhereClause(root.getLeft());
        }
    }

    private void checkAttrEles(HashSet<String> tableNames, ArrayList<QualifyEleExpr> attrELes, String clause) {
        for (QualifyEleExpr eleExpr : attrELes) {
            ResultColumnExpr attr = (ResultColumnExpr) eleExpr.getValue();
            if (attr.getTableName().equals(""))
                continue;
            String dbPrefix = "";
            if (!attr.getDbName().equals(""))
                dbPrefix = attr.getDbName() + ".";
            if (!tableNames.contains(dbPrefix + attr.getTableName()))
                throw new RuntimeException("The table name " + dbPrefix + attr.getTableName() + " in " + clause + " clause is illegal");
        }
    }

    @Override
    public void checkValidity() {
        // Acquire the table names in the statement and verify sub-select statement
        ArrayList<RangeTableExpr> fromTableList = getFromTableList(fromExpr);
        HashSet<String> tableNames = getTableNameList(fromExpr);
        for (RangeTableExpr rangeTableExpr : fromTableList) {
            if (rangeTableExpr.getRtTypes() == RangeTableTypes.RT_SUB_QUERY)
                ((SubSelectExpr) rangeTableExpr).getSelectExpr().checkValidity();
        }

        // Verify the uniqueness of table names
        if (tableNames.size() != fromTableList.size())
            throw new RuntimeException("The from expression can't have two identical table names");

        // Verify the table names in the statement
        for (ResultColumnExpr columnExpr : resultColumnExprs) {
            if (columnExpr.getTableName().equals(""))
                continue;
            String dbPrefix = "";
            if (!columnExpr.getDbName().equals(""))
                dbPrefix = columnExpr.getDbName() + ".";
            if (!tableNames.contains(dbPrefix + columnExpr.getTableName()))
                throw new RuntimeException("The table name " + dbPrefix + columnExpr.getTableName() + " in select-columns is illegal");
        }

        // Verify the table names, on-clause and using-clause in from expression
        RangeTableExpr fromRoot = this.fromExpr;
        while (true) {
            if (fromRoot.getRtTypes() == RangeTableTypes.RT_SUB_QUERY ||
                    fromRoot.getRtTypes() == RangeTableTypes.RT_RELATION)
                break;
            else if (fromRoot.getRtTypes() == RangeTableTypes.RT_JOIN) {
                JoinExpr joinExpr = (JoinExpr) fromRoot;
                HashSet<String> tables = getTableNameList(joinExpr);

                if (joinExpr.isNatural() && (joinExpr.getQualifierExpr() != null || joinExpr.getUsingExpr() != null))
                    throw new RuntimeException("Natural join cannot have on-clause and using-clause");

                if (joinExpr.getQualifierExpr() != null) {
                    ArrayList<QualifyEleExpr> attrELes = joinExpr.getQualifierExpr().getAttrELes();
                    checkAttrEles(tables, attrELes, "on");
                }

                // TODO Verify the column names against table names in on-clause and using-clause
                fromRoot = joinExpr.getLhs();
            } else
                throw new RuntimeException("The from expression wasn't expanded correctly");
        }

        // Verify the table names in where-clause
        checkWhereClause(whereExpr);

        // TODO Verify the table names against database names

        // TODO Verify the column names against table names

        /*
        TODO Verify the where clause and join-on qualifier
         with respect to the qualifier types (only = and <> can qualify boolean)
          and the consistency of column types and expression types
         (call corresponding checkValidity function in QualifierExpr)
         */

        // TODO Verify ambiguous attributes

        // TODO Verify the uniqueness of column names

    }
}
