import expression.Expression;
import expression.create.ColumnDefExpr;
import expression.create.CreateTableExpr;
import expression.create.TableConstraintExpr;
import expression.select.FormulaExpr;
import expression.select.QualifierExpr;
import expression.select.ResultColumnExpr;
import expression.select.SelectExpr;
import expression.types.ColumnConstraintTypes;
import expression.types.ColumnTypes;
import expression.types.TableConstraintTypes;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void selectTest() throws IOException {
        String sql = "select class_num, classname as name\n" +
                "from sc, (select * from class where class.gno = 'grade one') as sub on a = 1 join sc using (abc)\n" +
                "where sc.no = 4 and sc.yes = 5 or sc.a = 8 and sc.b = (9+3*4+(4-3)*7)/10+7/10\n" +
                "order by name";
        SelectExpr stmt = (SelectExpr) getParseResult(sql);
        assertEquals(((FormulaExpr) ((QualifierExpr) stmt.getWhereExpr().getRight().getRight()).getRhs().getValue()).getValue(), 3.5);
    }

    @Test
    void createTableTest() throws IOException {
        String sql = "create table DB.MyTable (" +
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
}
