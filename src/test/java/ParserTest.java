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
import expression.update.UpdateExpr;
import types.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import parser.SQLParser;
import parser.SQLiteLexer;
import parser.SQLiteParser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;


class ParserTest {

    Expression getParseResult(String sql) throws IOException {
        ByteArrayInputStream is = new ByteArrayInputStream(sql.getBytes());
        CharStream stream = CharStreams.fromStream(is);
        SQLiteLexer lexer = new SQLiteLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SQLiteParser parser = new SQLiteParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.parse();
        ParseTreeWalker walker = new ParseTreeWalker();
        SQLParser constructor = new SQLParser();
        walker.walk(constructor, tree);
        return constructor.getExpr();
    }

    @Test
    void noTest() {
        assertEquals(1, 1);
    }

    void selectTest() throws IOException {
        String sql =
                "select db.sc.class_num, classname as name\n" +
                        "from db.sc, (select * from class where class.gno = 'grade one') as sub on sc.a = 1 join sc using (abc)\n" +
                        "where sc.no = 4 and sc.yes = 5 or sc.a = 8 and sc.b > (9+3*4+(4-3)*7)/10+7/10\n";
        SelectExpr stmt = (SelectExpr) getParseResult(sql);

        ResultColumnExpr firstCol = stmt.getResultColumnExprs().get(0);
        ResultColumnExpr secondCol = stmt.getResultColumnExprs().get(1);
        assertEquals(stmt.getResultColumnExprs().size(), 2);
        assertEquals(firstCol.getDbName(), "db");
        assertEquals(firstCol.getTableName(), "sc");
        assertEquals(firstCol.getAttrName(), "class_num");
        assertEquals(secondCol.getAttrName(), "classname");
        assertEquals(secondCol.getAlias(), "name");

        JoinExpr rangeTableExpr = (JoinExpr) stmt.getFromExpr();
        assertEquals(rangeTableExpr.getRhs().getClass(), RelationExpr.class);
        assertEquals(((RelationExpr) rangeTableExpr.getRhs()).getTableName(), "sc");
        assertEquals(rangeTableExpr.getUsingExpr().get(0).getAttrName(), "abc");

        JoinExpr joinOnExpr = (JoinExpr) rangeTableExpr.getLhs();
        assertEquals(joinOnExpr.getRhs().getClass(), SubSelectExpr.class);
        assertEquals(((SubSelectExpr) joinOnExpr.getRhs()).getAlias(), "sub");
        assertEquals(((SubSelectExpr) joinOnExpr.getRhs()).getSelectExpr().getResultColumnExprs().get(0).getAttrName(), "*");
        assertEquals(joinOnExpr.getQualifierExpr().getQualifyTypes(), QualifyTypes.QUA_EQ);
        assertEquals(joinOnExpr.getQualifierExpr().getLhs().getEleTypes(), QualifyEleTypes.QUA_ELE_ATTR);
        assertEquals(joinOnExpr.getQualifierExpr().getRhs().getValue(), 1L);

        assertEquals(((QualifierExpr) stmt.getWhereExpr().getRight().getRight()).getQualifyTypes(), QualifyTypes.QUA_GT);
        assertEquals(((FormulaExpr) ((QualifierExpr) stmt.getWhereExpr().getRight().getRight()).getRhs().getValue()).getValue(), 3.5);
    }


    void createTableTest() throws IOException {
        String sql =
                "create table DB.MyTable (" +
                        "id INT primary key not null," +
                        "name VARCHAR(8) not null," +
                        "stu_num DOUBLE primary key autoincrement," +
                        "primary key(name, stu_num) )";

        CreateTableExpr stmt = (CreateTableExpr) getParseResult(sql);
        String[] columnNames = {"id", "name", "stu_num"};
        ColumnTypes[] columnTypes = {ColumnTypes.COL_INT, ColumnTypes.COL_VARCHAR, ColumnTypes.COL_DOUBLE};
        int[] typeValues = {0, 8, 0};
        ColumnConstraintTypes[][] constraintTypes = {
                {ColumnConstraintTypes.COL_PRIMARY_KEY, ColumnConstraintTypes.COL_NOT_NULL},
                {ColumnConstraintTypes.COL_NOT_NULL},
                {ColumnConstraintTypes.COL_AUTO_INC}
        };
        TableConstraintTypes[] tableConstraintTypes = {TableConstraintTypes.TBL_PRIMARY_KEY};
        String[][] tblConstraintCols = {{"name", "stu_num"}};

        assertEquals(stmt.getDbName(), "DB");
        assertEquals(stmt.getTableName(), "MyTable");
        ArrayList<ColumnDefExpr> columnDefExprs = stmt.getColumnDefExprs();
        for (int i = 0; i < columnNames.length; i++) {
            assertEquals(columnNames[i], columnDefExprs.get(i).getColumnName());
            assertEquals(columnTypes[i], columnDefExprs.get(i).getColType());
            assertEquals(typeValues[i], columnDefExprs.get(i).getTypeNum());
            for (int j = 0; j < constraintTypes[i].length; j++) {
                assertEquals(constraintTypes[i][j], columnDefExprs.get(i).getConstraintTypes().get(j));
            }
        }

        ArrayList<TableConstraintExpr> tableConstraintExprs = stmt.getTableConstraintExprs();
        for (int i = 0; i < tableConstraintExprs.size(); i++) {
            assertEquals(tableConstraintTypes[i], tableConstraintExprs.get(i).getType());
            for (int j = 0; j < tblConstraintCols[i].length; j++) {
                assertEquals(tblConstraintCols[i][j], tableConstraintExprs.get(i).getColumns().get(j).getColumnName());
            }
        }
    }


    void createDBTest() throws IOException {
        String sql = "create database name";
        CreateDBExpr stmt = (CreateDBExpr) getParseResult(sql);
        assertEquals(stmt.getDbName(), "name");
    }


    void dropTableTest() throws IOException {
        String sql = "drop table db.test";
        DropTableExpr stmt = (DropTableExpr) getParseResult(sql);
        assertEquals(stmt.getDbName(), "db");
        assertEquals(stmt.getTableName(), "test");
    }


    void dropDBTest() throws IOException {
        String sql = "drop database db";
        DropDBExpr stmt = (DropDBExpr) getParseResult(sql);
        assertEquals(stmt.getDbName(), "db");
    }


    void showDBTest() throws IOException {
        String sql = "show databases";
        ShowDBExpr stmt = (ShowDBExpr) getParseResult(sql);
        assertEquals(stmt.getExprType(), ExprTypes.EXPR_SHOW_DBS);

        sql = "show database db";
        stmt = (ShowDBExpr) getParseResult(sql);
        assertEquals(stmt.getExprType(), ExprTypes.EXPR_SHOW_DB);
    }


    void insertTest() throws IOException {
        String sql = "insert into db.test (a,b,c,d) values" +
                "(1,1.0,true,'now')," +
                "(2,2.0,false,'go')";
        InsertExpr stmt = (InsertExpr) getParseResult(sql);
        assertEquals(stmt.getDbName(), "db");
        assertEquals(stmt.getTableName(), "test");

        String[] columns = {"a", "b", "c", "d"};
        Object[][] values = {{1L, 1.0D, true, "now"}, {2L, 2.0D, false, "go"}};
        for (int i = 0; i < columns.length; i++) {
            assertEquals(stmt.getColumns().get(i), columns[i]);
            for (int j = 0; j < values.length; j++) {
                assertEquals(stmt.getValues().get(j).get(i), values[j][i]);
            }
        }
    }


    void updateTest() throws IOException {
        String sql = "update db.table set a = 1 where b > 1 and c < 3";
        UpdateExpr stmt = (UpdateExpr) getParseResult(sql);

        assertEquals(stmt.getAttrNames().get(0), "a");
        assertEquals(stmt.getValues().get(0), 1L);
        assertEquals(((QualifierExpr)stmt.getWhereExpr().getLeft()).getQualifyTypes(), QualifyTypes.QUA_GT);
        assertEquals(((QualifierExpr)stmt.getWhereExpr().getRight()).getQualifyTypes(), QualifyTypes.QUA_LT);
    }


    void deleteTest() throws IOException {
        String sql = "delete from db.table where b >= 1 and c <> 4";
        DeleteExpr stmt = (DeleteExpr) getParseResult(sql);

        assertEquals(stmt.getDBName(), "db");
        assertEquals(stmt.getTableName(), "table");
        assertEquals(((QualifierExpr)stmt.getWhereExpr().getLeft()).getLhs().getEleTypes(), QualifyEleTypes.QUA_ELE_ATTR);
        assertEquals(((QualifierExpr)stmt.getWhereExpr().getLeft()).getRhs().getValue(), 1L);
        assertEquals(((QualifierExpr)stmt.getWhereExpr().getLeft()).getQualifyTypes(), QualifyTypes.QUA_GET);
        assertEquals(((QualifierExpr)stmt.getWhereExpr().getRight()).getQualifyTypes(), QualifyTypes.QUA_NOT_EQ);
    }
}
