import Expression.select.ResultColumnExpr;
import Expression.select.SelectExpr;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import parser.SQLParser;
import parser.SQLiteLexer;
import parser.SQLiteParser;

import java.io.ByteArrayInputStream;
import java.io.IOException;


public class ParserTest {
    public static void main(String[] args) throws IOException {
        String sql = "select classno, classname as name\n" +
                "from sc, (select * from class where class.gno = 'grade one') as sub on a = 1 join sc using (abc)\n" +
                "where sc.no = 4 and sc.yes = 5 or sc.a = 8 and sc.b = 9\n" +
                "order by name";
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

        SelectExpr stmt = (SelectExpr) constructor.getExpr();
        for (ResultColumnExpr col : stmt.getResultColumnExprs()) {
            System.out.println(col.getTableName() + "." + col.getAttrName() + " as " + col.getAlias() + "\n");
        }
    }
}
