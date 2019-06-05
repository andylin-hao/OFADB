package engine;

import expression.Expression;
import expression.select.SelectExpr;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.SQLParser;
import parser.SQLiteLexer;
import parser.SQLiteParser;
import result.InfoResult;
import result.Result;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Engine {
    public static Result expressionExec(String sql) throws IOException {
        Expression expression = getParseResult(sql);
        switch (expression.getExprType()) {
            case EXPR_SELECT:
                return new QueryEngine(expression).getResult();
            case EXPR_CREATE_DB:
            case EXPR_DROP_DB:
            case EXPR_USE_DB:
                return new DBManiEngine(expression).getResult();
            case EXPR_CREATE_TABLE:
            case EXPR_DROP_TABLE:
                return new TableManiEngine(expression).getResult();
            case EXPR_SHOW_DB:
            case EXPR_SHOW_DBS:
            case EXPR_SHOW_TABLE:
                return new InfoEngine(expression).getResult();
            case EXPR_INSERT:
            case EXPR_DELETE:
            case EXPR_UPDATE:
                return new TableModifyEngine(expression).getResult();
            default:
                return null;
        }
    }

    private static Expression getParseResult(String sql) throws IOException {
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
}
