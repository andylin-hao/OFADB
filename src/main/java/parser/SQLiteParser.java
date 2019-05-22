// Generated from C:/Users/MasterYoda117/IdeaProjects/OFADB/src/main/java/parser\SQLite.g4 by ANTLR 4.7.2
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLiteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SCOL=1, DOT=2, OPEN_PAR=3, CLOSE_PAR=4, COMMA=5, ASSIGN=6, STAR=7, PLUS=8, 
		MINUS=9, TILDE=10, PIPE2=11, DIV=12, MOD=13, LT2=14, GT2=15, AMP=16, PIPE=17, 
		LT=18, LT_EQ=19, GT=20, GT_EQ=21, EQ=22, NOT_EQ1=23, NOT_EQ2=24, K_ABORT=25, 
		K_ACTION=26, K_ADD=27, K_AFTER=28, K_ALL=29, K_ALTER=30, K_ANALYZE=31, 
		K_AND=32, K_AS=33, K_ASC=34, K_ATTACH=35, K_AUTOINCREMENT=36, K_BEFORE=37, 
		K_BEGIN=38, K_BETWEEN=39, K_BY=40, K_CASCADE=41, K_CASE=42, K_CAST=43, 
		K_CHECK=44, K_COLLATE=45, K_COLUMN=46, K_COMMIT=47, K_CONFLICT=48, K_CONSTRAINT=49, 
		K_CREATE=50, K_CROSS=51, K_CURRENT_DATE=52, K_CURRENT_TIME=53, K_CURRENT_TIMESTAMP=54, 
		K_DATABASE=55, K_DATABASES=56, K_DEFAULT=57, K_DEFERRABLE=58, K_DEFERRED=59, 
		K_DELETE=60, K_DESC=61, K_DETACH=62, K_DISTINCT=63, K_DROP=64, K_EACH=65, 
		K_ELSE=66, K_END=67, K_ESCAPE=68, K_EXCEPT=69, K_EXCLUSIVE=70, K_EXISTS=71, 
		K_EXPLAIN=72, K_FAIL=73, K_FOR=74, K_FOREIGN=75, K_FROM=76, K_FULL=77, 
		K_GLOB=78, K_GROUP=79, K_HAVING=80, K_IF=81, K_IGNORE=82, K_IMMEDIATE=83, 
		K_IN=84, K_INDEX=85, K_INDEXED=86, K_INITIALLY=87, K_INNER=88, K_INSERT=89, 
		K_INSTEAD=90, K_INTERSECT=91, K_INTO=92, K_IS=93, K_ISNULL=94, K_JOIN=95, 
		K_KEY=96, K_LEFT=97, K_LIKE=98, K_LIMIT=99, K_MATCH=100, K_NATURAL=101, 
		K_NO=102, K_NOT=103, K_NOTNULL=104, K_NULL=105, K_OF=106, K_OFFSET=107, 
		K_ON=108, K_OR=109, K_ORDER=110, K_OUTER=111, K_PLAN=112, K_PRAGMA=113, 
		K_PRIMARY=114, K_QUERY=115, K_RAISE=116, K_RECURSIVE=117, K_REFERENCES=118, 
		K_REGEXP=119, K_REINDEX=120, K_RELEASE=121, K_RENAME=122, K_REPLACE=123, 
		K_RESTRICT=124, K_RIGHT=125, K_ROLLBACK=126, K_ROW=127, K_SAVEPOINT=128, 
		K_SELECT=129, K_SET=130, K_SHOW=131, K_TABLE=132, K_TEMP=133, K_TEMPORARY=134, 
		K_THEN=135, K_TO=136, K_TRANSACTION=137, K_TRIGGER=138, K_UNION=139, K_UNIQUE=140, 
		K_UPDATE=141, K_USE=142, K_USING=143, K_VACUUM=144, K_VALUES=145, K_VIEW=146, 
		K_VIRTUAL=147, K_WHEN=148, K_WHERE=149, K_WITH=150, K_WITHOUT=151, IDENTIFIER=152, 
		NUMERIC_LITERAL=153, BIND_PARAMETER=154, STRING_LITERAL=155, BLOB_LITERAL=156, 
		SINGLE_LINE_COMMENT=157, MULTILINE_COMMENT=158, SPACES=159, UNEXPECTED_CHAR=160;
	public static final int
		RULE_parse = 0, RULE_error = 1, RULE_sql_stmt_list = 2, RULE_sql_stmt = 3, 
		RULE_alter_table_stmt = 4, RULE_analyze_stmt = 5, RULE_attach_stmt = 6, 
		RULE_begin_stmt = 7, RULE_commit_stmt = 8, RULE_compound_select_stmt = 9, 
		RULE_create_index_stmt = 10, RULE_create_table_stmt = 11, RULE_create_database_stmt = 12, 
		RULE_create_trigger_stmt = 13, RULE_create_view_stmt = 14, RULE_create_virtual_table_stmt = 15, 
		RULE_delete_stmt = 16, RULE_delete_stmt_limited = 17, RULE_detach_stmt = 18, 
		RULE_drop_index_stmt = 19, RULE_drop_table_stmt = 20, RULE_drop_database_stmt = 21, 
		RULE_drop_trigger_stmt = 22, RULE_drop_view_stmt = 23, RULE_factored_select_stmt = 24, 
		RULE_insert_stmt = 25, RULE_insert_value_stmt = 26, RULE_pragma_stmt = 27, 
		RULE_reindex_stmt = 28, RULE_release_stmt = 29, RULE_rollback_stmt = 30, 
		RULE_savepoint_stmt = 31, RULE_simple_select_stmt = 32, RULE_select_stmt = 33, 
		RULE_select_or_values = 34, RULE_show_database_stmt = 35, RULE_show_table_stmt = 36, 
		RULE_update_values_stmt = 37, RULE_update_stmt = 38, RULE_update_stmt_limited = 39, 
		RULE_use_database_stmt = 40, RULE_vacuum_stmt = 41, RULE_column_def = 42, 
		RULE_type_name = 43, RULE_column_constraint = 44, RULE_conflict_clause = 45, 
		RULE_expr = 46, RULE_foreign_key_clause = 47, RULE_raise_function = 48, 
		RULE_indexed_column = 49, RULE_table_constraint = 50, RULE_with_clause = 51, 
		RULE_qualified_table_name = 52, RULE_ordering_term = 53, RULE_pragma_value = 54, 
		RULE_common_table_expression = 55, RULE_result_column = 56, RULE_table_or_subquery = 57, 
		RULE_join_clause = 58, RULE_join_operator = 59, RULE_join_constraint = 60, 
		RULE_where_clause = 61, RULE_select_core = 62, RULE_compound_operator = 63, 
		RULE_cte_table_name = 64, RULE_signed_number = 65, RULE_literal_value = 66, 
		RULE_unary_operator = 67, RULE_error_message = 68, RULE_module_argument = 69, 
		RULE_column_alias = 70, RULE_keyword = 71, RULE_name = 72, RULE_function_name = 73, 
		RULE_database_name = 74, RULE_table_name = 75, RULE_table_or_index_name = 76, 
		RULE_new_table_name = 77, RULE_column_name = 78, RULE_collation_name = 79, 
		RULE_foreign_table = 80, RULE_index_name = 81, RULE_trigger_name = 82, 
		RULE_view_name = 83, RULE_module_name = 84, RULE_pragma_name = 85, RULE_savepoint_name = 86, 
		RULE_table_alias = 87, RULE_transaction_name = 88, RULE_any_name = 89;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "error", "sql_stmt_list", "sql_stmt", "alter_table_stmt", "analyze_stmt", 
			"attach_stmt", "begin_stmt", "commit_stmt", "compound_select_stmt", "create_index_stmt", 
			"create_table_stmt", "create_database_stmt", "create_trigger_stmt", "create_view_stmt", 
			"create_virtual_table_stmt", "delete_stmt", "delete_stmt_limited", "detach_stmt", 
			"drop_index_stmt", "drop_table_stmt", "drop_database_stmt", "drop_trigger_stmt", 
			"drop_view_stmt", "factored_select_stmt", "insert_stmt", "insert_value_stmt", 
			"pragma_stmt", "reindex_stmt", "release_stmt", "rollback_stmt", "savepoint_stmt", 
			"simple_select_stmt", "select_stmt", "select_or_values", "show_database_stmt", 
			"show_table_stmt", "update_values_stmt", "update_stmt", "update_stmt_limited", 
			"use_database_stmt", "vacuum_stmt", "column_def", "type_name", "column_constraint", 
			"conflict_clause", "expr", "foreign_key_clause", "raise_function", "indexed_column", 
			"table_constraint", "with_clause", "qualified_table_name", "ordering_term", 
			"pragma_value", "common_table_expression", "result_column", "table_or_subquery", 
			"join_clause", "join_operator", "join_constraint", "where_clause", "select_core", 
			"compound_operator", "cte_table_name", "signed_number", "literal_value", 
			"unary_operator", "error_message", "module_argument", "column_alias", 
			"keyword", "name", "function_name", "database_name", "table_name", "table_or_index_name", 
			"new_table_name", "column_name", "collation_name", "foreign_table", "index_name", 
			"trigger_name", "view_name", "module_name", "pragma_name", "savepoint_name", 
			"table_alias", "transaction_name", "any_name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", "'('", "')'", "','", "'='", "'*'", "'+'", "'-'", 
			"'~'", "'||'", "'/'", "'%'", "'<<'", "'>>'", "'&'", "'|'", "'<'", "'<='", 
			"'>'", "'>='", "'=='", "'!='", "'<>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SCOL", "DOT", "OPEN_PAR", "CLOSE_PAR", "COMMA", "ASSIGN", "STAR", 
			"PLUS", "MINUS", "TILDE", "PIPE2", "DIV", "MOD", "LT2", "GT2", "AMP", 
			"PIPE", "LT", "LT_EQ", "GT", "GT_EQ", "EQ", "NOT_EQ1", "NOT_EQ2", "K_ABORT", 
			"K_ACTION", "K_ADD", "K_AFTER", "K_ALL", "K_ALTER", "K_ANALYZE", "K_AND", 
			"K_AS", "K_ASC", "K_ATTACH", "K_AUTOINCREMENT", "K_BEFORE", "K_BEGIN", 
			"K_BETWEEN", "K_BY", "K_CASCADE", "K_CASE", "K_CAST", "K_CHECK", "K_COLLATE", 
			"K_COLUMN", "K_COMMIT", "K_CONFLICT", "K_CONSTRAINT", "K_CREATE", "K_CROSS", 
			"K_CURRENT_DATE", "K_CURRENT_TIME", "K_CURRENT_TIMESTAMP", "K_DATABASE", 
			"K_DATABASES", "K_DEFAULT", "K_DEFERRABLE", "K_DEFERRED", "K_DELETE", 
			"K_DESC", "K_DETACH", "K_DISTINCT", "K_DROP", "K_EACH", "K_ELSE", "K_END", 
			"K_ESCAPE", "K_EXCEPT", "K_EXCLUSIVE", "K_EXISTS", "K_EXPLAIN", "K_FAIL", 
			"K_FOR", "K_FOREIGN", "K_FROM", "K_FULL", "K_GLOB", "K_GROUP", "K_HAVING", 
			"K_IF", "K_IGNORE", "K_IMMEDIATE", "K_IN", "K_INDEX", "K_INDEXED", "K_INITIALLY", 
			"K_INNER", "K_INSERT", "K_INSTEAD", "K_INTERSECT", "K_INTO", "K_IS", 
			"K_ISNULL", "K_JOIN", "K_KEY", "K_LEFT", "K_LIKE", "K_LIMIT", "K_MATCH", 
			"K_NATURAL", "K_NO", "K_NOT", "K_NOTNULL", "K_NULL", "K_OF", "K_OFFSET", 
			"K_ON", "K_OR", "K_ORDER", "K_OUTER", "K_PLAN", "K_PRAGMA", "K_PRIMARY", 
			"K_QUERY", "K_RAISE", "K_RECURSIVE", "K_REFERENCES", "K_REGEXP", "K_REINDEX", 
			"K_RELEASE", "K_RENAME", "K_REPLACE", "K_RESTRICT", "K_RIGHT", "K_ROLLBACK", 
			"K_ROW", "K_SAVEPOINT", "K_SELECT", "K_SET", "K_SHOW", "K_TABLE", "K_TEMP", 
			"K_TEMPORARY", "K_THEN", "K_TO", "K_TRANSACTION", "K_TRIGGER", "K_UNION", 
			"K_UNIQUE", "K_UPDATE", "K_USE", "K_USING", "K_VACUUM", "K_VALUES", "K_VIEW", 
			"K_VIRTUAL", "K_WHEN", "K_WHERE", "K_WITH", "K_WITHOUT", "IDENTIFIER", 
			"NUMERIC_LITERAL", "BIND_PARAMETER", "STRING_LITERAL", "BLOB_LITERAL", 
			"SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", "UNEXPECTED_CHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SQLite.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLiteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SQLiteParser.EOF, 0); }
		public List<Sql_stmt_listContext> sql_stmt_list() {
			return getRuleContexts(Sql_stmt_listContext.class);
		}
		public Sql_stmt_listContext sql_stmt_list(int i) {
			return getRuleContext(Sql_stmt_listContext.class,i);
		}
		public List<ErrorContext> error() {
			return getRuleContexts(ErrorContext.class);
		}
		public ErrorContext error(int i) {
			return getRuleContext(ErrorContext.class,i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCOL) | (1L << K_ALTER) | (1L << K_ANALYZE) | (1L << K_ATTACH) | (1L << K_BEGIN) | (1L << K_COMMIT) | (1L << K_CREATE) | (1L << K_DELETE) | (1L << K_DETACH))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (K_DROP - 64)) | (1L << (K_END - 64)) | (1L << (K_EXPLAIN - 64)) | (1L << (K_INSERT - 64)) | (1L << (K_PRAGMA - 64)) | (1L << (K_REINDEX - 64)) | (1L << (K_RELEASE - 64)) | (1L << (K_REPLACE - 64)) | (1L << (K_ROLLBACK - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (K_SAVEPOINT - 128)) | (1L << (K_SELECT - 128)) | (1L << (K_SHOW - 128)) | (1L << (K_UPDATE - 128)) | (1L << (K_USE - 128)) | (1L << (K_VACUUM - 128)) | (1L << (K_VALUES - 128)) | (1L << (K_WITH - 128)) | (1L << (UNEXPECTED_CHAR - 128)))) != 0)) {
				{
				setState(182);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SCOL:
				case K_ALTER:
				case K_ANALYZE:
				case K_ATTACH:
				case K_BEGIN:
				case K_COMMIT:
				case K_CREATE:
				case K_DELETE:
				case K_DETACH:
				case K_DROP:
				case K_END:
				case K_EXPLAIN:
				case K_INSERT:
				case K_PRAGMA:
				case K_REINDEX:
				case K_RELEASE:
				case K_REPLACE:
				case K_ROLLBACK:
				case K_SAVEPOINT:
				case K_SELECT:
				case K_SHOW:
				case K_UPDATE:
				case K_USE:
				case K_VACUUM:
				case K_VALUES:
				case K_WITH:
					{
					setState(180);
					sql_stmt_list();
					}
					break;
				case UNEXPECTED_CHAR:
					{
					setState(181);
					error();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ErrorContext extends ParserRuleContext {
		public Token UNEXPECTED_CHAR;
		public TerminalNode UNEXPECTED_CHAR() { return getToken(SQLiteParser.UNEXPECTED_CHAR, 0); }
		public ErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitError(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitError(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ErrorContext error() throws RecognitionException {
		ErrorContext _localctx = new ErrorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_error);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			((ErrorContext)_localctx).UNEXPECTED_CHAR = match(UNEXPECTED_CHAR);

			     throw new RuntimeException("UNEXPECTED_CHAR=" + (((ErrorContext)_localctx).UNEXPECTED_CHAR!=null?((ErrorContext)_localctx).UNEXPECTED_CHAR.getText():null));
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_stmt_listContext extends ParserRuleContext {
		public List<Sql_stmtContext> sql_stmt() {
			return getRuleContexts(Sql_stmtContext.class);
		}
		public Sql_stmtContext sql_stmt(int i) {
			return getRuleContext(Sql_stmtContext.class,i);
		}
		public List<TerminalNode> SCOL() { return getTokens(SQLiteParser.SCOL); }
		public TerminalNode SCOL(int i) {
			return getToken(SQLiteParser.SCOL, i);
		}
		public Sql_stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_stmt_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterSql_stmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitSql_stmt_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitSql_stmt_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_stmt_listContext sql_stmt_list() throws RecognitionException {
		Sql_stmt_listContext _localctx = new Sql_stmt_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sql_stmt_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SCOL) {
				{
				{
				setState(192);
				match(SCOL);
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(198);
			sql_stmt();
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(200); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(199);
						match(SCOL);
						}
						}
						setState(202); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SCOL );
					setState(204);
					sql_stmt();
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(210);
					match(SCOL);
					}
					} 
				}
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_stmtContext extends ParserRuleContext {
		public Alter_table_stmtContext alter_table_stmt() {
			return getRuleContext(Alter_table_stmtContext.class,0);
		}
		public Analyze_stmtContext analyze_stmt() {
			return getRuleContext(Analyze_stmtContext.class,0);
		}
		public Attach_stmtContext attach_stmt() {
			return getRuleContext(Attach_stmtContext.class,0);
		}
		public Begin_stmtContext begin_stmt() {
			return getRuleContext(Begin_stmtContext.class,0);
		}
		public Commit_stmtContext commit_stmt() {
			return getRuleContext(Commit_stmtContext.class,0);
		}
		public Compound_select_stmtContext compound_select_stmt() {
			return getRuleContext(Compound_select_stmtContext.class,0);
		}
		public Create_index_stmtContext create_index_stmt() {
			return getRuleContext(Create_index_stmtContext.class,0);
		}
		public Create_table_stmtContext create_table_stmt() {
			return getRuleContext(Create_table_stmtContext.class,0);
		}
		public Create_database_stmtContext create_database_stmt() {
			return getRuleContext(Create_database_stmtContext.class,0);
		}
		public Create_trigger_stmtContext create_trigger_stmt() {
			return getRuleContext(Create_trigger_stmtContext.class,0);
		}
		public Create_view_stmtContext create_view_stmt() {
			return getRuleContext(Create_view_stmtContext.class,0);
		}
		public Create_virtual_table_stmtContext create_virtual_table_stmt() {
			return getRuleContext(Create_virtual_table_stmtContext.class,0);
		}
		public Delete_stmtContext delete_stmt() {
			return getRuleContext(Delete_stmtContext.class,0);
		}
		public Delete_stmt_limitedContext delete_stmt_limited() {
			return getRuleContext(Delete_stmt_limitedContext.class,0);
		}
		public Detach_stmtContext detach_stmt() {
			return getRuleContext(Detach_stmtContext.class,0);
		}
		public Drop_index_stmtContext drop_index_stmt() {
			return getRuleContext(Drop_index_stmtContext.class,0);
		}
		public Drop_table_stmtContext drop_table_stmt() {
			return getRuleContext(Drop_table_stmtContext.class,0);
		}
		public Drop_database_stmtContext drop_database_stmt() {
			return getRuleContext(Drop_database_stmtContext.class,0);
		}
		public Drop_trigger_stmtContext drop_trigger_stmt() {
			return getRuleContext(Drop_trigger_stmtContext.class,0);
		}
		public Drop_view_stmtContext drop_view_stmt() {
			return getRuleContext(Drop_view_stmtContext.class,0);
		}
		public Factored_select_stmtContext factored_select_stmt() {
			return getRuleContext(Factored_select_stmtContext.class,0);
		}
		public Insert_stmtContext insert_stmt() {
			return getRuleContext(Insert_stmtContext.class,0);
		}
		public Pragma_stmtContext pragma_stmt() {
			return getRuleContext(Pragma_stmtContext.class,0);
		}
		public Reindex_stmtContext reindex_stmt() {
			return getRuleContext(Reindex_stmtContext.class,0);
		}
		public Release_stmtContext release_stmt() {
			return getRuleContext(Release_stmtContext.class,0);
		}
		public Rollback_stmtContext rollback_stmt() {
			return getRuleContext(Rollback_stmtContext.class,0);
		}
		public Savepoint_stmtContext savepoint_stmt() {
			return getRuleContext(Savepoint_stmtContext.class,0);
		}
		public Simple_select_stmtContext simple_select_stmt() {
			return getRuleContext(Simple_select_stmtContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Show_database_stmtContext show_database_stmt() {
			return getRuleContext(Show_database_stmtContext.class,0);
		}
		public Show_table_stmtContext show_table_stmt() {
			return getRuleContext(Show_table_stmtContext.class,0);
		}
		public Update_stmtContext update_stmt() {
			return getRuleContext(Update_stmtContext.class,0);
		}
		public Update_stmt_limitedContext update_stmt_limited() {
			return getRuleContext(Update_stmt_limitedContext.class,0);
		}
		public Use_database_stmtContext use_database_stmt() {
			return getRuleContext(Use_database_stmtContext.class,0);
		}
		public Vacuum_stmtContext vacuum_stmt() {
			return getRuleContext(Vacuum_stmtContext.class,0);
		}
		public TerminalNode K_EXPLAIN() { return getToken(SQLiteParser.K_EXPLAIN, 0); }
		public TerminalNode K_QUERY() { return getToken(SQLiteParser.K_QUERY, 0); }
		public TerminalNode K_PLAN() { return getToken(SQLiteParser.K_PLAN, 0); }
		public Sql_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterSql_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitSql_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitSql_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_stmtContext sql_stmt() throws RecognitionException {
		Sql_stmtContext _localctx = new Sql_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sql_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_EXPLAIN) {
				{
				setState(216);
				match(K_EXPLAIN);
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_QUERY) {
					{
					setState(217);
					match(K_QUERY);
					setState(218);
					match(K_PLAN);
					}
				}

				}
			}

			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(223);
				alter_table_stmt();
				}
				break;
			case 2:
				{
				setState(224);
				analyze_stmt();
				}
				break;
			case 3:
				{
				setState(225);
				attach_stmt();
				}
				break;
			case 4:
				{
				setState(226);
				begin_stmt();
				}
				break;
			case 5:
				{
				setState(227);
				commit_stmt();
				}
				break;
			case 6:
				{
				setState(228);
				compound_select_stmt();
				}
				break;
			case 7:
				{
				setState(229);
				create_index_stmt();
				}
				break;
			case 8:
				{
				setState(230);
				create_table_stmt();
				}
				break;
			case 9:
				{
				setState(231);
				create_database_stmt();
				}
				break;
			case 10:
				{
				setState(232);
				create_trigger_stmt();
				}
				break;
			case 11:
				{
				setState(233);
				create_view_stmt();
				}
				break;
			case 12:
				{
				setState(234);
				create_virtual_table_stmt();
				}
				break;
			case 13:
				{
				setState(235);
				delete_stmt();
				}
				break;
			case 14:
				{
				setState(236);
				delete_stmt_limited();
				}
				break;
			case 15:
				{
				setState(237);
				detach_stmt();
				}
				break;
			case 16:
				{
				setState(238);
				drop_index_stmt();
				}
				break;
			case 17:
				{
				setState(239);
				drop_table_stmt();
				}
				break;
			case 18:
				{
				setState(240);
				drop_database_stmt();
				}
				break;
			case 19:
				{
				setState(241);
				drop_trigger_stmt();
				}
				break;
			case 20:
				{
				setState(242);
				drop_view_stmt();
				}
				break;
			case 21:
				{
				setState(243);
				factored_select_stmt();
				}
				break;
			case 22:
				{
				setState(244);
				insert_stmt();
				}
				break;
			case 23:
				{
				setState(245);
				pragma_stmt();
				}
				break;
			case 24:
				{
				setState(246);
				reindex_stmt();
				}
				break;
			case 25:
				{
				setState(247);
				release_stmt();
				}
				break;
			case 26:
				{
				setState(248);
				rollback_stmt();
				}
				break;
			case 27:
				{
				setState(249);
				savepoint_stmt();
				}
				break;
			case 28:
				{
				setState(250);
				simple_select_stmt();
				}
				break;
			case 29:
				{
				setState(251);
				select_stmt();
				}
				break;
			case 30:
				{
				setState(252);
				show_database_stmt();
				}
				break;
			case 31:
				{
				setState(253);
				show_table_stmt();
				}
				break;
			case 32:
				{
				setState(254);
				update_stmt();
				}
				break;
			case 33:
				{
				setState(255);
				update_stmt_limited();
				}
				break;
			case 34:
				{
				setState(256);
				use_database_stmt();
				}
				break;
			case 35:
				{
				setState(257);
				vacuum_stmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_ALTER() { return getToken(SQLiteParser.K_ALTER, 0); }
		public TerminalNode K_TABLE() { return getToken(SQLiteParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_RENAME() { return getToken(SQLiteParser.K_RENAME, 0); }
		public TerminalNode K_TO() { return getToken(SQLiteParser.K_TO, 0); }
		public New_table_nameContext new_table_name() {
			return getRuleContext(New_table_nameContext.class,0);
		}
		public TerminalNode K_ADD() { return getToken(SQLiteParser.K_ADD, 0); }
		public Column_defContext column_def() {
			return getRuleContext(Column_defContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode K_COLUMN() { return getToken(SQLiteParser.K_COLUMN, 0); }
		public Alter_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterAlter_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitAlter_table_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitAlter_table_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Alter_table_stmtContext alter_table_stmt() throws RecognitionException {
		Alter_table_stmtContext _localctx = new Alter_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_alter_table_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(K_ALTER);
			setState(261);
			match(K_TABLE);
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(262);
				database_name();
				setState(263);
				match(DOT);
				}
				break;
			}
			setState(267);
			table_name();
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_RENAME:
				{
				setState(268);
				match(K_RENAME);
				setState(269);
				match(K_TO);
				setState(270);
				new_table_name();
				}
				break;
			case K_ADD:
				{
				setState(271);
				match(K_ADD);
				setState(273);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(272);
					match(K_COLUMN);
					}
					break;
				}
				setState(275);
				column_def();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Analyze_stmtContext extends ParserRuleContext {
		public TerminalNode K_ANALYZE() { return getToken(SQLiteParser.K_ANALYZE, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Table_or_index_nameContext table_or_index_name() {
			return getRuleContext(Table_or_index_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Analyze_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_analyze_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterAnalyze_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitAnalyze_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitAnalyze_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Analyze_stmtContext analyze_stmt() throws RecognitionException {
		Analyze_stmtContext _localctx = new Analyze_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_analyze_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(K_ANALYZE);
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(279);
				database_name();
				}
				break;
			case 2:
				{
				setState(280);
				table_or_index_name();
				}
				break;
			case 3:
				{
				setState(281);
				database_name();
				setState(282);
				match(DOT);
				setState(283);
				table_or_index_name();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attach_stmtContext extends ParserRuleContext {
		public TerminalNode K_ATTACH() { return getToken(SQLiteParser.K_ATTACH, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(SQLiteParser.K_AS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode K_DATABASE() { return getToken(SQLiteParser.K_DATABASE, 0); }
		public Attach_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attach_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterAttach_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitAttach_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitAttach_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attach_stmtContext attach_stmt() throws RecognitionException {
		Attach_stmtContext _localctx = new Attach_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attach_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(K_ATTACH);
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(288);
				match(K_DATABASE);
				}
				break;
			}
			setState(291);
			expr(0);
			setState(292);
			match(K_AS);
			setState(293);
			database_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Begin_stmtContext extends ParserRuleContext {
		public TerminalNode K_BEGIN() { return getToken(SQLiteParser.K_BEGIN, 0); }
		public TerminalNode K_TRANSACTION() { return getToken(SQLiteParser.K_TRANSACTION, 0); }
		public TerminalNode K_DEFERRED() { return getToken(SQLiteParser.K_DEFERRED, 0); }
		public TerminalNode K_IMMEDIATE() { return getToken(SQLiteParser.K_IMMEDIATE, 0); }
		public TerminalNode K_EXCLUSIVE() { return getToken(SQLiteParser.K_EXCLUSIVE, 0); }
		public Transaction_nameContext transaction_name() {
			return getRuleContext(Transaction_nameContext.class,0);
		}
		public Begin_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_begin_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterBegin_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitBegin_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitBegin_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Begin_stmtContext begin_stmt() throws RecognitionException {
		Begin_stmtContext _localctx = new Begin_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_begin_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(K_BEGIN);
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (K_DEFERRED - 59)) | (1L << (K_EXCLUSIVE - 59)) | (1L << (K_IMMEDIATE - 59)))) != 0)) {
				{
				setState(296);
				_la = _input.LA(1);
				if ( !(((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (K_DEFERRED - 59)) | (1L << (K_EXCLUSIVE - 59)) | (1L << (K_IMMEDIATE - 59)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_TRANSACTION) {
				{
				setState(299);
				match(K_TRANSACTION);
				setState(301);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(300);
					transaction_name();
					}
					break;
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Commit_stmtContext extends ParserRuleContext {
		public TerminalNode K_COMMIT() { return getToken(SQLiteParser.K_COMMIT, 0); }
		public TerminalNode K_END() { return getToken(SQLiteParser.K_END, 0); }
		public TerminalNode K_TRANSACTION() { return getToken(SQLiteParser.K_TRANSACTION, 0); }
		public Transaction_nameContext transaction_name() {
			return getRuleContext(Transaction_nameContext.class,0);
		}
		public Commit_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commit_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterCommit_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitCommit_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitCommit_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Commit_stmtContext commit_stmt() throws RecognitionException {
		Commit_stmtContext _localctx = new Commit_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_commit_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_la = _input.LA(1);
			if ( !(_la==K_COMMIT || _la==K_END) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_TRANSACTION) {
				{
				setState(306);
				match(K_TRANSACTION);
				setState(308);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(307);
					transaction_name();
					}
					break;
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_select_stmtContext extends ParserRuleContext {
		public List<Select_coreContext> select_core() {
			return getRuleContexts(Select_coreContext.class);
		}
		public Select_coreContext select_core(int i) {
			return getRuleContext(Select_coreContext.class,i);
		}
		public TerminalNode K_WITH() { return getToken(SQLiteParser.K_WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(SQLiteParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SQLiteParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(SQLiteParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> K_UNION() { return getTokens(SQLiteParser.K_UNION); }
		public TerminalNode K_UNION(int i) {
			return getToken(SQLiteParser.K_UNION, i);
		}
		public List<TerminalNode> K_INTERSECT() { return getTokens(SQLiteParser.K_INTERSECT); }
		public TerminalNode K_INTERSECT(int i) {
			return getToken(SQLiteParser.K_INTERSECT, i);
		}
		public List<TerminalNode> K_EXCEPT() { return getTokens(SQLiteParser.K_EXCEPT); }
		public TerminalNode K_EXCEPT(int i) {
			return getToken(SQLiteParser.K_EXCEPT, i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SQLiteParser.K_RECURSIVE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode K_OFFSET() { return getToken(SQLiteParser.K_OFFSET, 0); }
		public List<TerminalNode> K_ALL() { return getTokens(SQLiteParser.K_ALL); }
		public TerminalNode K_ALL(int i) {
			return getToken(SQLiteParser.K_ALL, i);
		}
		public Compound_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterCompound_select_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitCompound_select_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitCompound_select_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_select_stmtContext compound_select_stmt() throws RecognitionException {
		Compound_select_stmtContext _localctx = new Compound_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_compound_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(312);
				match(K_WITH);
				setState(314);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(313);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(316);
				common_table_expression();
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(317);
					match(COMMA);
					setState(318);
					common_table_expression();
					}
					}
					setState(323);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(326);
			select_core();
			setState(336); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(333);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case K_UNION:
					{
					setState(327);
					match(K_UNION);
					setState(329);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_ALL) {
						{
						setState(328);
						match(K_ALL);
						}
					}

					}
					break;
				case K_INTERSECT:
					{
					setState(331);
					match(K_INTERSECT);
					}
					break;
				case K_EXCEPT:
					{
					setState(332);
					match(K_EXCEPT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(335);
				select_core();
				}
				}
				setState(338); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==K_EXCEPT || _la==K_INTERSECT || _la==K_UNION );
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(340);
				match(K_ORDER);
				setState(341);
				match(K_BY);
				setState(342);
				ordering_term();
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(343);
					match(COMMA);
					setState(344);
					ordering_term();
					}
					}
					setState(349);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(352);
				match(K_LIMIT);
				setState(353);
				expr(0);
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(354);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(355);
					expr(0);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_index_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SQLiteParser.K_CREATE, 0); }
		public TerminalNode K_INDEX() { return getToken(SQLiteParser.K_INDEX, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode K_ON() { return getToken(SQLiteParser.K_ON, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Indexed_columnContext> indexed_column() {
			return getRuleContexts(Indexed_columnContext.class);
		}
		public Indexed_columnContext indexed_column(int i) {
			return getRuleContext(Indexed_columnContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode K_UNIQUE() { return getToken(SQLiteParser.K_UNIQUE, 0); }
		public TerminalNode K_IF() { return getToken(SQLiteParser.K_IF, 0); }
		public TerminalNode K_NOT() { return getToken(SQLiteParser.K_NOT, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLiteParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public Create_index_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_index_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterCreate_index_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitCreate_index_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitCreate_index_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_index_stmtContext create_index_stmt() throws RecognitionException {
		Create_index_stmtContext _localctx = new Create_index_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_create_index_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(K_CREATE);
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_UNIQUE) {
				{
				setState(361);
				match(K_UNIQUE);
				}
			}

			setState(364);
			match(K_INDEX);
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(365);
				match(K_IF);
				setState(366);
				match(K_NOT);
				setState(367);
				match(K_EXISTS);
				}
				break;
			}
			setState(373);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(370);
				database_name();
				setState(371);
				match(DOT);
				}
				break;
			}
			setState(375);
			index_name();
			setState(376);
			match(K_ON);
			setState(377);
			table_name();
			setState(378);
			match(OPEN_PAR);
			setState(379);
			indexed_column();
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(380);
				match(COMMA);
				setState(381);
				indexed_column();
				}
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(387);
			match(CLOSE_PAR);
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(388);
				where_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SQLiteParser.K_CREATE, 0); }
		public TerminalNode K_TABLE() { return getToken(SQLiteParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_defContext> column_def() {
			return getRuleContexts(Column_defContext.class);
		}
		public Column_defContext column_def(int i) {
			return getRuleContext(Column_defContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode K_AS() { return getToken(SQLiteParser.K_AS, 0); }
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SQLiteParser.K_IF, 0); }
		public TerminalNode K_NOT() { return getToken(SQLiteParser.K_NOT, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLiteParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode K_TEMP() { return getToken(SQLiteParser.K_TEMP, 0); }
		public TerminalNode K_TEMPORARY() { return getToken(SQLiteParser.K_TEMPORARY, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public List<Table_constraintContext> table_constraint() {
			return getRuleContexts(Table_constraintContext.class);
		}
		public Table_constraintContext table_constraint(int i) {
			return getRuleContext(Table_constraintContext.class,i);
		}
		public TerminalNode K_WITHOUT() { return getToken(SQLiteParser.K_WITHOUT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SQLiteParser.IDENTIFIER, 0); }
		public Create_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterCreate_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitCreate_table_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitCreate_table_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_table_stmtContext create_table_stmt() throws RecognitionException {
		Create_table_stmtContext _localctx = new Create_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_create_table_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(K_CREATE);
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_TEMP || _la==K_TEMPORARY) {
				{
				setState(392);
				_la = _input.LA(1);
				if ( !(_la==K_TEMP || _la==K_TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(395);
			match(K_TABLE);
			setState(399);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(396);
				match(K_IF);
				setState(397);
				match(K_NOT);
				setState(398);
				match(K_EXISTS);
				}
				break;
			}
			setState(404);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(401);
				database_name();
				setState(402);
				match(DOT);
				}
				break;
			}
			setState(406);
			table_name();
			setState(430);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAR:
				{
				setState(407);
				match(OPEN_PAR);
				setState(408);
				column_def();
				setState(413);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(409);
						match(COMMA);
						setState(410);
						column_def();
						}
						} 
					}
					setState(415);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				}
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(416);
					match(COMMA);
					setState(417);
					table_constraint();
					}
					}
					setState(422);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(423);
				match(CLOSE_PAR);
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_WITHOUT) {
					{
					setState(424);
					match(K_WITHOUT);
					setState(425);
					match(IDENTIFIER);
					}
				}

				}
				break;
			case K_AS:
				{
				setState(428);
				match(K_AS);
				setState(429);
				select_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_database_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SQLiteParser.K_CREATE, 0); }
		public TerminalNode K_DATABASE() { return getToken(SQLiteParser.K_DATABASE, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Create_database_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_database_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterCreate_database_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitCreate_database_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitCreate_database_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_database_stmtContext create_database_stmt() throws RecognitionException {
		Create_database_stmtContext _localctx = new Create_database_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_create_database_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			match(K_CREATE);
			setState(433);
			match(K_DATABASE);
			setState(434);
			database_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_trigger_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SQLiteParser.K_CREATE, 0); }
		public TerminalNode K_TRIGGER() { return getToken(SQLiteParser.K_TRIGGER, 0); }
		public Trigger_nameContext trigger_name() {
			return getRuleContext(Trigger_nameContext.class,0);
		}
		public TerminalNode K_ON() { return getToken(SQLiteParser.K_ON, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_BEGIN() { return getToken(SQLiteParser.K_BEGIN, 0); }
		public TerminalNode K_END() { return getToken(SQLiteParser.K_END, 0); }
		public TerminalNode K_DELETE() { return getToken(SQLiteParser.K_DELETE, 0); }
		public TerminalNode K_INSERT() { return getToken(SQLiteParser.K_INSERT, 0); }
		public TerminalNode K_UPDATE() { return getToken(SQLiteParser.K_UPDATE, 0); }
		public TerminalNode K_IF() { return getToken(SQLiteParser.K_IF, 0); }
		public TerminalNode K_NOT() { return getToken(SQLiteParser.K_NOT, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLiteParser.K_EXISTS, 0); }
		public List<Database_nameContext> database_name() {
			return getRuleContexts(Database_nameContext.class);
		}
		public Database_nameContext database_name(int i) {
			return getRuleContext(Database_nameContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(SQLiteParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SQLiteParser.DOT, i);
		}
		public TerminalNode K_BEFORE() { return getToken(SQLiteParser.K_BEFORE, 0); }
		public TerminalNode K_AFTER() { return getToken(SQLiteParser.K_AFTER, 0); }
		public TerminalNode K_INSTEAD() { return getToken(SQLiteParser.K_INSTEAD, 0); }
		public List<TerminalNode> K_OF() { return getTokens(SQLiteParser.K_OF); }
		public TerminalNode K_OF(int i) {
			return getToken(SQLiteParser.K_OF, i);
		}
		public TerminalNode K_FOR() { return getToken(SQLiteParser.K_FOR, 0); }
		public TerminalNode K_EACH() { return getToken(SQLiteParser.K_EACH, 0); }
		public TerminalNode K_ROW() { return getToken(SQLiteParser.K_ROW, 0); }
		public TerminalNode K_WHEN() { return getToken(SQLiteParser.K_WHEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> SCOL() { return getTokens(SQLiteParser.SCOL); }
		public TerminalNode SCOL(int i) {
			return getToken(SQLiteParser.SCOL, i);
		}
		public TerminalNode K_TEMP() { return getToken(SQLiteParser.K_TEMP, 0); }
		public TerminalNode K_TEMPORARY() { return getToken(SQLiteParser.K_TEMPORARY, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<Update_stmtContext> update_stmt() {
			return getRuleContexts(Update_stmtContext.class);
		}
		public Update_stmtContext update_stmt(int i) {
			return getRuleContext(Update_stmtContext.class,i);
		}
		public List<Insert_stmtContext> insert_stmt() {
			return getRuleContexts(Insert_stmtContext.class);
		}
		public Insert_stmtContext insert_stmt(int i) {
			return getRuleContext(Insert_stmtContext.class,i);
		}
		public List<Delete_stmtContext> delete_stmt() {
			return getRuleContexts(Delete_stmtContext.class);
		}
		public Delete_stmtContext delete_stmt(int i) {
			return getRuleContext(Delete_stmtContext.class,i);
		}
		public List<Select_stmtContext> select_stmt() {
			return getRuleContexts(Select_stmtContext.class);
		}
		public Select_stmtContext select_stmt(int i) {
			return getRuleContext(Select_stmtContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Create_trigger_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_trigger_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterCreate_trigger_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitCreate_trigger_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitCreate_trigger_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_trigger_stmtContext create_trigger_stmt() throws RecognitionException {
		Create_trigger_stmtContext _localctx = new Create_trigger_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_create_trigger_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			match(K_CREATE);
			setState(438);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_TEMP || _la==K_TEMPORARY) {
				{
				setState(437);
				_la = _input.LA(1);
				if ( !(_la==K_TEMP || _la==K_TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(440);
			match(K_TRIGGER);
			setState(444);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(441);
				match(K_IF);
				setState(442);
				match(K_NOT);
				setState(443);
				match(K_EXISTS);
				}
				break;
			}
			setState(449);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(446);
				database_name();
				setState(447);
				match(DOT);
				}
				break;
			}
			setState(451);
			trigger_name();
			setState(456);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_BEFORE:
				{
				setState(452);
				match(K_BEFORE);
				}
				break;
			case K_AFTER:
				{
				setState(453);
				match(K_AFTER);
				}
				break;
			case K_INSTEAD:
				{
				setState(454);
				match(K_INSTEAD);
				setState(455);
				match(K_OF);
				}
				break;
			case K_DELETE:
			case K_INSERT:
			case K_UPDATE:
				break;
			default:
				break;
			}
			setState(472);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_DELETE:
				{
				setState(458);
				match(K_DELETE);
				}
				break;
			case K_INSERT:
				{
				setState(459);
				match(K_INSERT);
				}
				break;
			case K_UPDATE:
				{
				setState(460);
				match(K_UPDATE);
				setState(470);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_OF) {
					{
					setState(461);
					match(K_OF);
					setState(462);
					column_name();
					setState(467);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(463);
						match(COMMA);
						setState(464);
						column_name();
						}
						}
						setState(469);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(474);
			match(K_ON);
			setState(478);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(475);
				database_name();
				setState(476);
				match(DOT);
				}
				break;
			}
			setState(480);
			table_name();
			setState(484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_FOR) {
				{
				setState(481);
				match(K_FOR);
				setState(482);
				match(K_EACH);
				setState(483);
				match(K_ROW);
				}
			}

			setState(488);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHEN) {
				{
				setState(486);
				match(K_WHEN);
				setState(487);
				expr(0);
				}
			}

			setState(490);
			match(K_BEGIN);
			setState(499); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(495);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(491);
					update_stmt();
					}
					break;
				case 2:
					{
					setState(492);
					insert_stmt();
					}
					break;
				case 3:
					{
					setState(493);
					delete_stmt();
					}
					break;
				case 4:
					{
					setState(494);
					select_stmt();
					}
					break;
				}
				setState(497);
				match(SCOL);
				}
				}
				setState(501); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==K_DELETE || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (K_INSERT - 89)) | (1L << (K_REPLACE - 89)) | (1L << (K_SELECT - 89)) | (1L << (K_UPDATE - 89)) | (1L << (K_VALUES - 89)) | (1L << (K_WITH - 89)))) != 0) );
			setState(503);
			match(K_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_view_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SQLiteParser.K_CREATE, 0); }
		public TerminalNode K_VIEW() { return getToken(SQLiteParser.K_VIEW, 0); }
		public View_nameContext view_name() {
			return getRuleContext(View_nameContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(SQLiteParser.K_AS, 0); }
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SQLiteParser.K_IF, 0); }
		public TerminalNode K_NOT() { return getToken(SQLiteParser.K_NOT, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLiteParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode K_TEMP() { return getToken(SQLiteParser.K_TEMP, 0); }
		public TerminalNode K_TEMPORARY() { return getToken(SQLiteParser.K_TEMPORARY, 0); }
		public Create_view_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_view_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterCreate_view_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitCreate_view_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitCreate_view_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_view_stmtContext create_view_stmt() throws RecognitionException {
		Create_view_stmtContext _localctx = new Create_view_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_create_view_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			match(K_CREATE);
			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_TEMP || _la==K_TEMPORARY) {
				{
				setState(506);
				_la = _input.LA(1);
				if ( !(_la==K_TEMP || _la==K_TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(509);
			match(K_VIEW);
			setState(513);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(510);
				match(K_IF);
				setState(511);
				match(K_NOT);
				setState(512);
				match(K_EXISTS);
				}
				break;
			}
			setState(518);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(515);
				database_name();
				setState(516);
				match(DOT);
				}
				break;
			}
			setState(520);
			view_name();
			setState(521);
			match(K_AS);
			setState(522);
			select_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_virtual_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SQLiteParser.K_CREATE, 0); }
		public TerminalNode K_VIRTUAL() { return getToken(SQLiteParser.K_VIRTUAL, 0); }
		public TerminalNode K_TABLE() { return getToken(SQLiteParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_USING() { return getToken(SQLiteParser.K_USING, 0); }
		public Module_nameContext module_name() {
			return getRuleContext(Module_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SQLiteParser.K_IF, 0); }
		public TerminalNode K_NOT() { return getToken(SQLiteParser.K_NOT, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLiteParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Module_argumentContext> module_argument() {
			return getRuleContexts(Module_argumentContext.class);
		}
		public Module_argumentContext module_argument(int i) {
			return getRuleContext(Module_argumentContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Create_virtual_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_virtual_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterCreate_virtual_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitCreate_virtual_table_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitCreate_virtual_table_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_virtual_table_stmtContext create_virtual_table_stmt() throws RecognitionException {
		Create_virtual_table_stmtContext _localctx = new Create_virtual_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_create_virtual_table_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			match(K_CREATE);
			setState(525);
			match(K_VIRTUAL);
			setState(526);
			match(K_TABLE);
			setState(530);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(527);
				match(K_IF);
				setState(528);
				match(K_NOT);
				setState(529);
				match(K_EXISTS);
				}
				break;
			}
			setState(535);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(532);
				database_name();
				setState(533);
				match(DOT);
				}
				break;
			}
			setState(537);
			table_name();
			setState(538);
			match(K_USING);
			setState(539);
			module_name();
			setState(551);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(540);
				match(OPEN_PAR);
				setState(541);
				module_argument();
				setState(546);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(542);
					match(COMMA);
					setState(543);
					module_argument();
					}
					}
					setState(548);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(549);
				match(CLOSE_PAR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_stmtContext extends ParserRuleContext {
		public TerminalNode K_DELETE() { return getToken(SQLiteParser.K_DELETE, 0); }
		public TerminalNode K_FROM() { return getToken(SQLiteParser.K_FROM, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public Delete_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterDelete_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitDelete_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitDelete_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Delete_stmtContext delete_stmt() throws RecognitionException {
		Delete_stmtContext _localctx = new Delete_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_delete_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(553);
				with_clause();
				}
			}

			setState(556);
			match(K_DELETE);
			setState(557);
			match(K_FROM);
			setState(558);
			qualified_table_name();
			setState(560);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(559);
				where_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_stmt_limitedContext extends ParserRuleContext {
		public TerminalNode K_DELETE() { return getToken(SQLiteParser.K_DELETE, 0); }
		public TerminalNode K_FROM() { return getToken(SQLiteParser.K_FROM, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public TerminalNode K_LIMIT() { return getToken(SQLiteParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(SQLiteParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SQLiteParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_OFFSET() { return getToken(SQLiteParser.K_OFFSET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Delete_stmt_limitedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_stmt_limited; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterDelete_stmt_limited(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitDelete_stmt_limited(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitDelete_stmt_limited(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Delete_stmt_limitedContext delete_stmt_limited() throws RecognitionException {
		Delete_stmt_limitedContext _localctx = new Delete_stmt_limitedContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_delete_stmt_limited);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(562);
				with_clause();
				}
			}

			setState(565);
			match(K_DELETE);
			setState(566);
			match(K_FROM);
			setState(567);
			qualified_table_name();
			setState(569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(568);
				where_clause();
				}
			}

			setState(589);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_LIMIT || _la==K_ORDER) {
				{
				setState(581);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_ORDER) {
					{
					setState(571);
					match(K_ORDER);
					setState(572);
					match(K_BY);
					setState(573);
					ordering_term();
					setState(578);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(574);
						match(COMMA);
						setState(575);
						ordering_term();
						}
						}
						setState(580);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(583);
				match(K_LIMIT);
				setState(584);
				expr(0);
				setState(587);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(585);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(586);
					expr(0);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Detach_stmtContext extends ParserRuleContext {
		public TerminalNode K_DETACH() { return getToken(SQLiteParser.K_DETACH, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode K_DATABASE() { return getToken(SQLiteParser.K_DATABASE, 0); }
		public Detach_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_detach_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterDetach_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitDetach_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitDetach_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Detach_stmtContext detach_stmt() throws RecognitionException {
		Detach_stmtContext _localctx = new Detach_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_detach_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			match(K_DETACH);
			setState(593);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(592);
				match(K_DATABASE);
				}
				break;
			}
			setState(595);
			database_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_index_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(SQLiteParser.K_DROP, 0); }
		public TerminalNode K_INDEX() { return getToken(SQLiteParser.K_INDEX, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SQLiteParser.K_IF, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLiteParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Drop_index_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_index_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterDrop_index_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitDrop_index_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitDrop_index_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drop_index_stmtContext drop_index_stmt() throws RecognitionException {
		Drop_index_stmtContext _localctx = new Drop_index_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_drop_index_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
			match(K_DROP);
			setState(598);
			match(K_INDEX);
			setState(601);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(599);
				match(K_IF);
				setState(600);
				match(K_EXISTS);
				}
				break;
			}
			setState(606);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(603);
				database_name();
				setState(604);
				match(DOT);
				}
				break;
			}
			setState(608);
			index_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(SQLiteParser.K_DROP, 0); }
		public TerminalNode K_TABLE() { return getToken(SQLiteParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SQLiteParser.K_IF, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLiteParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Drop_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterDrop_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitDrop_table_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitDrop_table_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drop_table_stmtContext drop_table_stmt() throws RecognitionException {
		Drop_table_stmtContext _localctx = new Drop_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_drop_table_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
			match(K_DROP);
			setState(611);
			match(K_TABLE);
			setState(614);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(612);
				match(K_IF);
				setState(613);
				match(K_EXISTS);
				}
				break;
			}
			setState(619);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				{
				setState(616);
				database_name();
				setState(617);
				match(DOT);
				}
				break;
			}
			setState(621);
			table_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_database_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(SQLiteParser.K_DROP, 0); }
		public TerminalNode K_DATABASE() { return getToken(SQLiteParser.K_DATABASE, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Drop_database_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_database_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterDrop_database_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitDrop_database_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitDrop_database_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drop_database_stmtContext drop_database_stmt() throws RecognitionException {
		Drop_database_stmtContext _localctx = new Drop_database_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_drop_database_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			match(K_DROP);
			setState(624);
			match(K_DATABASE);
			setState(625);
			database_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_trigger_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(SQLiteParser.K_DROP, 0); }
		public TerminalNode K_TRIGGER() { return getToken(SQLiteParser.K_TRIGGER, 0); }
		public Trigger_nameContext trigger_name() {
			return getRuleContext(Trigger_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SQLiteParser.K_IF, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLiteParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Drop_trigger_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_trigger_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterDrop_trigger_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitDrop_trigger_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitDrop_trigger_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drop_trigger_stmtContext drop_trigger_stmt() throws RecognitionException {
		Drop_trigger_stmtContext _localctx = new Drop_trigger_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_drop_trigger_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			match(K_DROP);
			setState(628);
			match(K_TRIGGER);
			setState(631);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(629);
				match(K_IF);
				setState(630);
				match(K_EXISTS);
				}
				break;
			}
			setState(636);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				setState(633);
				database_name();
				setState(634);
				match(DOT);
				}
				break;
			}
			setState(638);
			trigger_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_view_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(SQLiteParser.K_DROP, 0); }
		public TerminalNode K_VIEW() { return getToken(SQLiteParser.K_VIEW, 0); }
		public View_nameContext view_name() {
			return getRuleContext(View_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SQLiteParser.K_IF, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLiteParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Drop_view_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_view_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterDrop_view_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitDrop_view_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitDrop_view_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drop_view_stmtContext drop_view_stmt() throws RecognitionException {
		Drop_view_stmtContext _localctx = new Drop_view_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_drop_view_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			match(K_DROP);
			setState(641);
			match(K_VIEW);
			setState(644);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				setState(642);
				match(K_IF);
				setState(643);
				match(K_EXISTS);
				}
				break;
			}
			setState(649);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				{
				setState(646);
				database_name();
				setState(647);
				match(DOT);
				}
				break;
			}
			setState(651);
			view_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Factored_select_stmtContext extends ParserRuleContext {
		public List<Select_coreContext> select_core() {
			return getRuleContexts(Select_coreContext.class);
		}
		public Select_coreContext select_core(int i) {
			return getRuleContext(Select_coreContext.class,i);
		}
		public TerminalNode K_WITH() { return getToken(SQLiteParser.K_WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public List<Compound_operatorContext> compound_operator() {
			return getRuleContexts(Compound_operatorContext.class);
		}
		public Compound_operatorContext compound_operator(int i) {
			return getRuleContext(Compound_operatorContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(SQLiteParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SQLiteParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(SQLiteParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SQLiteParser.K_RECURSIVE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode K_OFFSET() { return getToken(SQLiteParser.K_OFFSET, 0); }
		public Factored_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factored_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterFactored_select_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitFactored_select_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitFactored_select_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Factored_select_stmtContext factored_select_stmt() throws RecognitionException {
		Factored_select_stmtContext _localctx = new Factored_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_factored_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(653);
				match(K_WITH);
				setState(655);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(654);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(657);
				common_table_expression();
				setState(662);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(658);
					match(COMMA);
					setState(659);
					common_table_expression();
					}
					}
					setState(664);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(667);
			select_core();
			setState(673);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_EXCEPT || _la==K_INTERSECT || _la==K_UNION) {
				{
				{
				setState(668);
				compound_operator();
				setState(669);
				select_core();
				}
				}
				setState(675);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(686);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(676);
				match(K_ORDER);
				setState(677);
				match(K_BY);
				setState(678);
				ordering_term();
				setState(683);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(679);
					match(COMMA);
					setState(680);
					ordering_term();
					}
					}
					setState(685);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(694);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(688);
				match(K_LIMIT);
				setState(689);
				expr(0);
				setState(692);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(690);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(691);
					expr(0);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Insert_stmtContext extends ParserRuleContext {
		public TerminalNode K_INTO() { return getToken(SQLiteParser.K_INTO, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_INSERT() { return getToken(SQLiteParser.K_INSERT, 0); }
		public TerminalNode K_REPLACE() { return getToken(SQLiteParser.K_REPLACE, 0); }
		public TerminalNode K_OR() { return getToken(SQLiteParser.K_OR, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SQLiteParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SQLiteParser.K_ABORT, 0); }
		public TerminalNode K_FAIL() { return getToken(SQLiteParser.K_FAIL, 0); }
		public TerminalNode K_IGNORE() { return getToken(SQLiteParser.K_IGNORE, 0); }
		public TerminalNode K_VALUES() { return getToken(SQLiteParser.K_VALUES, 0); }
		public List<Insert_value_stmtContext> insert_value_stmt() {
			return getRuleContexts(Insert_value_stmtContext.class);
		}
		public Insert_value_stmtContext insert_value_stmt(int i) {
			return getRuleContext(Insert_value_stmtContext.class,i);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode K_DEFAULT() { return getToken(SQLiteParser.K_DEFAULT, 0); }
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Insert_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterInsert_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitInsert_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitInsert_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Insert_stmtContext insert_stmt() throws RecognitionException {
		Insert_stmtContext _localctx = new Insert_stmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_insert_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(696);
				with_clause();
				}
			}

			setState(716);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				{
				setState(699);
				match(K_INSERT);
				}
				break;
			case 2:
				{
				setState(700);
				match(K_REPLACE);
				}
				break;
			case 3:
				{
				setState(701);
				match(K_INSERT);
				setState(702);
				match(K_OR);
				setState(703);
				match(K_REPLACE);
				}
				break;
			case 4:
				{
				setState(704);
				match(K_INSERT);
				setState(705);
				match(K_OR);
				setState(706);
				match(K_ROLLBACK);
				}
				break;
			case 5:
				{
				setState(707);
				match(K_INSERT);
				setState(708);
				match(K_OR);
				setState(709);
				match(K_ABORT);
				}
				break;
			case 6:
				{
				setState(710);
				match(K_INSERT);
				setState(711);
				match(K_OR);
				setState(712);
				match(K_FAIL);
				}
				break;
			case 7:
				{
				setState(713);
				match(K_INSERT);
				setState(714);
				match(K_OR);
				setState(715);
				match(K_IGNORE);
				}
				break;
			}
			setState(718);
			match(K_INTO);
			setState(722);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(719);
				database_name();
				setState(720);
				match(DOT);
				}
				break;
			}
			setState(724);
			table_name();
			setState(736);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(725);
				match(OPEN_PAR);
				setState(726);
				column_name();
				setState(731);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(727);
					match(COMMA);
					setState(728);
					column_name();
					}
					}
					setState(733);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(734);
				match(CLOSE_PAR);
				}
			}

			setState(750);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				{
				setState(738);
				match(K_VALUES);
				setState(739);
				insert_value_stmt();
				setState(744);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(740);
					match(COMMA);
					setState(741);
					insert_value_stmt();
					}
					}
					setState(746);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(747);
				select_stmt();
				}
				break;
			case 3:
				{
				setState(748);
				match(K_DEFAULT);
				setState(749);
				match(K_VALUES);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Insert_value_stmtContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Insert_value_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_value_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterInsert_value_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitInsert_value_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitInsert_value_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Insert_value_stmtContext insert_value_stmt() throws RecognitionException {
		Insert_value_stmtContext _localctx = new Insert_value_stmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_insert_value_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(752);
			match(OPEN_PAR);
			setState(753);
			expr(0);
			setState(758);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(754);
				match(COMMA);
				setState(755);
				expr(0);
				}
				}
				setState(760);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(761);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pragma_stmtContext extends ParserRuleContext {
		public TerminalNode K_PRAGMA() { return getToken(SQLiteParser.K_PRAGMA, 0); }
		public Pragma_nameContext pragma_name() {
			return getRuleContext(Pragma_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode ASSIGN() { return getToken(SQLiteParser.ASSIGN, 0); }
		public Pragma_valueContext pragma_value() {
			return getRuleContext(Pragma_valueContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public Pragma_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterPragma_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitPragma_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitPragma_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pragma_stmtContext pragma_stmt() throws RecognitionException {
		Pragma_stmtContext _localctx = new Pragma_stmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_pragma_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(763);
			match(K_PRAGMA);
			setState(767);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				{
				setState(764);
				database_name();
				setState(765);
				match(DOT);
				}
				break;
			}
			setState(769);
			pragma_name();
			setState(776);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				{
				setState(770);
				match(ASSIGN);
				setState(771);
				pragma_value();
				}
				break;
			case OPEN_PAR:
				{
				setState(772);
				match(OPEN_PAR);
				setState(773);
				pragma_value();
				setState(774);
				match(CLOSE_PAR);
				}
				break;
			case EOF:
			case SCOL:
			case K_ALTER:
			case K_ANALYZE:
			case K_ATTACH:
			case K_BEGIN:
			case K_COMMIT:
			case K_CREATE:
			case K_DELETE:
			case K_DETACH:
			case K_DROP:
			case K_END:
			case K_EXPLAIN:
			case K_INSERT:
			case K_PRAGMA:
			case K_REINDEX:
			case K_RELEASE:
			case K_REPLACE:
			case K_ROLLBACK:
			case K_SAVEPOINT:
			case K_SELECT:
			case K_SHOW:
			case K_UPDATE:
			case K_USE:
			case K_VACUUM:
			case K_VALUES:
			case K_WITH:
			case UNEXPECTED_CHAR:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Reindex_stmtContext extends ParserRuleContext {
		public TerminalNode K_REINDEX() { return getToken(SQLiteParser.K_REINDEX, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Reindex_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reindex_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterReindex_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitReindex_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitReindex_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Reindex_stmtContext reindex_stmt() throws RecognitionException {
		Reindex_stmtContext _localctx = new Reindex_stmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_reindex_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
			match(K_REINDEX);
			setState(789);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				{
				setState(779);
				collation_name();
				}
				break;
			case 2:
				{
				setState(783);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
				case 1:
					{
					setState(780);
					database_name();
					setState(781);
					match(DOT);
					}
					break;
				}
				setState(787);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(785);
					table_name();
					}
					break;
				case 2:
					{
					setState(786);
					index_name();
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Release_stmtContext extends ParserRuleContext {
		public TerminalNode K_RELEASE() { return getToken(SQLiteParser.K_RELEASE, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public TerminalNode K_SAVEPOINT() { return getToken(SQLiteParser.K_SAVEPOINT, 0); }
		public Release_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_release_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterRelease_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitRelease_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitRelease_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Release_stmtContext release_stmt() throws RecognitionException {
		Release_stmtContext _localctx = new Release_stmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_release_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(791);
			match(K_RELEASE);
			setState(793);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				{
				setState(792);
				match(K_SAVEPOINT);
				}
				break;
			}
			setState(795);
			savepoint_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rollback_stmtContext extends ParserRuleContext {
		public TerminalNode K_ROLLBACK() { return getToken(SQLiteParser.K_ROLLBACK, 0); }
		public TerminalNode K_TRANSACTION() { return getToken(SQLiteParser.K_TRANSACTION, 0); }
		public TerminalNode K_TO() { return getToken(SQLiteParser.K_TO, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public Transaction_nameContext transaction_name() {
			return getRuleContext(Transaction_nameContext.class,0);
		}
		public TerminalNode K_SAVEPOINT() { return getToken(SQLiteParser.K_SAVEPOINT, 0); }
		public Rollback_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rollback_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterRollback_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitRollback_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitRollback_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rollback_stmtContext rollback_stmt() throws RecognitionException {
		Rollback_stmtContext _localctx = new Rollback_stmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_rollback_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(797);
			match(K_ROLLBACK);
			setState(802);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_TRANSACTION) {
				{
				setState(798);
				match(K_TRANSACTION);
				setState(800);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
				case 1:
					{
					setState(799);
					transaction_name();
					}
					break;
				}
				}
			}

			setState(809);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_TO) {
				{
				setState(804);
				match(K_TO);
				setState(806);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(805);
					match(K_SAVEPOINT);
					}
					break;
				}
				setState(808);
				savepoint_name();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Savepoint_stmtContext extends ParserRuleContext {
		public TerminalNode K_SAVEPOINT() { return getToken(SQLiteParser.K_SAVEPOINT, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public Savepoint_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_savepoint_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterSavepoint_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitSavepoint_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitSavepoint_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Savepoint_stmtContext savepoint_stmt() throws RecognitionException {
		Savepoint_stmtContext _localctx = new Savepoint_stmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_savepoint_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(811);
			match(K_SAVEPOINT);
			setState(812);
			savepoint_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_select_stmtContext extends ParserRuleContext {
		public Select_coreContext select_core() {
			return getRuleContext(Select_coreContext.class,0);
		}
		public TerminalNode K_WITH() { return getToken(SQLiteParser.K_WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(SQLiteParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SQLiteParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(SQLiteParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SQLiteParser.K_RECURSIVE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode K_OFFSET() { return getToken(SQLiteParser.K_OFFSET, 0); }
		public Simple_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterSimple_select_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitSimple_select_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitSimple_select_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_select_stmtContext simple_select_stmt() throws RecognitionException {
		Simple_select_stmtContext _localctx = new Simple_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_simple_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(826);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(814);
				match(K_WITH);
				setState(816);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
				case 1:
					{
					setState(815);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(818);
				common_table_expression();
				setState(823);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(819);
					match(COMMA);
					setState(820);
					common_table_expression();
					}
					}
					setState(825);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(828);
			select_core();
			setState(839);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(829);
				match(K_ORDER);
				setState(830);
				match(K_BY);
				setState(831);
				ordering_term();
				setState(836);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(832);
					match(COMMA);
					setState(833);
					ordering_term();
					}
					}
					setState(838);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(847);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(841);
				match(K_LIMIT);
				setState(842);
				expr(0);
				setState(845);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(843);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(844);
					expr(0);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_stmtContext extends ParserRuleContext {
		public List<Select_or_valuesContext> select_or_values() {
			return getRuleContexts(Select_or_valuesContext.class);
		}
		public Select_or_valuesContext select_or_values(int i) {
			return getRuleContext(Select_or_valuesContext.class,i);
		}
		public TerminalNode K_WITH() { return getToken(SQLiteParser.K_WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public List<Compound_operatorContext> compound_operator() {
			return getRuleContexts(Compound_operatorContext.class);
		}
		public Compound_operatorContext compound_operator(int i) {
			return getRuleContext(Compound_operatorContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(SQLiteParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SQLiteParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(SQLiteParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SQLiteParser.K_RECURSIVE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode K_OFFSET() { return getToken(SQLiteParser.K_OFFSET, 0); }
		public Select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterSelect_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitSelect_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitSelect_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_stmtContext select_stmt() throws RecognitionException {
		Select_stmtContext _localctx = new Select_stmtContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(861);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(849);
				match(K_WITH);
				setState(851);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
				case 1:
					{
					setState(850);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(853);
				common_table_expression();
				setState(858);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(854);
					match(COMMA);
					setState(855);
					common_table_expression();
					}
					}
					setState(860);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(863);
			select_or_values();
			setState(869);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_EXCEPT || _la==K_INTERSECT || _la==K_UNION) {
				{
				{
				setState(864);
				compound_operator();
				setState(865);
				select_or_values();
				}
				}
				setState(871);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(882);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(872);
				match(K_ORDER);
				setState(873);
				match(K_BY);
				setState(874);
				ordering_term();
				setState(879);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(875);
					match(COMMA);
					setState(876);
					ordering_term();
					}
					}
					setState(881);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(890);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(884);
				match(K_LIMIT);
				setState(885);
				expr(0);
				setState(888);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(886);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(887);
					expr(0);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_or_valuesContext extends ParserRuleContext {
		public TerminalNode K_SELECT() { return getToken(SQLiteParser.K_SELECT, 0); }
		public List<Result_columnContext> result_column() {
			return getRuleContexts(Result_columnContext.class);
		}
		public Result_columnContext result_column(int i) {
			return getRuleContext(Result_columnContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode K_FROM() { return getToken(SQLiteParser.K_FROM, 0); }
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public TerminalNode K_GROUP() { return getToken(SQLiteParser.K_GROUP, 0); }
		public TerminalNode K_BY() { return getToken(SQLiteParser.K_BY, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_DISTINCT() { return getToken(SQLiteParser.K_DISTINCT, 0); }
		public TerminalNode K_ALL() { return getToken(SQLiteParser.K_ALL, 0); }
		public TerminalNode K_HAVING() { return getToken(SQLiteParser.K_HAVING, 0); }
		public TerminalNode K_VALUES() { return getToken(SQLiteParser.K_VALUES, 0); }
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLiteParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLiteParser.OPEN_PAR, i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLiteParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLiteParser.CLOSE_PAR, i);
		}
		public Select_or_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_or_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterSelect_or_values(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitSelect_or_values(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitSelect_or_values(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_or_valuesContext select_or_values() throws RecognitionException {
		Select_or_valuesContext _localctx = new Select_or_valuesContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_select_or_values);
		int _la;
		try {
			setState(955);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(892);
				match(K_SELECT);
				setState(894);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
				case 1:
					{
					setState(893);
					_la = _input.LA(1);
					if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(896);
				result_column();
				setState(901);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(897);
					match(COMMA);
					setState(898);
					result_column();
					}
					}
					setState(903);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(906);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_FROM) {
					{
					setState(904);
					match(K_FROM);
					setState(905);
					join_clause();
					}
				}

				setState(909);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_WHERE) {
					{
					setState(908);
					where_clause();
					}
				}

				setState(925);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_GROUP) {
					{
					setState(911);
					match(K_GROUP);
					setState(912);
					match(K_BY);
					setState(913);
					expr(0);
					setState(918);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(914);
						match(COMMA);
						setState(915);
						expr(0);
						}
						}
						setState(920);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(923);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_HAVING) {
						{
						setState(921);
						match(K_HAVING);
						setState(922);
						expr(0);
						}
					}

					}
				}

				}
				break;
			case K_VALUES:
				enterOuterAlt(_localctx, 2);
				{
				setState(927);
				match(K_VALUES);
				setState(928);
				match(OPEN_PAR);
				setState(929);
				expr(0);
				setState(934);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(930);
					match(COMMA);
					setState(931);
					expr(0);
					}
					}
					setState(936);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(937);
				match(CLOSE_PAR);
				setState(952);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(938);
					match(COMMA);
					setState(939);
					match(OPEN_PAR);
					setState(940);
					expr(0);
					setState(945);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(941);
						match(COMMA);
						setState(942);
						expr(0);
						}
						}
						setState(947);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(948);
					match(CLOSE_PAR);
					}
					}
					setState(954);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Show_database_stmtContext extends ParserRuleContext {
		public TerminalNode K_SHOW() { return getToken(SQLiteParser.K_SHOW, 0); }
		public TerminalNode K_DATABASE() { return getToken(SQLiteParser.K_DATABASE, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode K_DATABASES() { return getToken(SQLiteParser.K_DATABASES, 0); }
		public Show_database_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_database_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterShow_database_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitShow_database_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitShow_database_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_database_stmtContext show_database_stmt() throws RecognitionException {
		Show_database_stmtContext _localctx = new Show_database_stmtContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_show_database_stmt);
		try {
			setState(962);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(957);
				match(K_SHOW);
				setState(958);
				match(K_DATABASE);
				setState(959);
				database_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(960);
				match(K_SHOW);
				setState(961);
				match(K_DATABASES);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Show_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_SHOW() { return getToken(SQLiteParser.K_SHOW, 0); }
		public TerminalNode K_TABLE() { return getToken(SQLiteParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Show_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterShow_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitShow_table_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitShow_table_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_table_stmtContext show_table_stmt() throws RecognitionException {
		Show_table_stmtContext _localctx = new Show_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_show_table_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(964);
			match(K_SHOW);
			setState(965);
			match(K_TABLE);
			setState(969);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				{
				setState(966);
				database_name();
				setState(967);
				match(DOT);
				}
				break;
			}
			setState(971);
			table_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_values_stmtContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SQLiteParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Update_values_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_values_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterUpdate_values_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitUpdate_values_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitUpdate_values_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_values_stmtContext update_values_stmt() throws RecognitionException {
		Update_values_stmtContext _localctx = new Update_values_stmtContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_update_values_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(973);
			column_name();
			setState(974);
			match(ASSIGN);
			setState(975);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_stmtContext extends ParserRuleContext {
		public TerminalNode K_UPDATE() { return getToken(SQLiteParser.K_UPDATE, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public TerminalNode K_SET() { return getToken(SQLiteParser.K_SET, 0); }
		public List<Update_values_stmtContext> update_values_stmt() {
			return getRuleContexts(Update_values_stmtContext.class);
		}
		public Update_values_stmtContext update_values_stmt(int i) {
			return getRuleContext(Update_values_stmtContext.class,i);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode K_OR() { return getToken(SQLiteParser.K_OR, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SQLiteParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SQLiteParser.K_ABORT, 0); }
		public TerminalNode K_REPLACE() { return getToken(SQLiteParser.K_REPLACE, 0); }
		public TerminalNode K_FAIL() { return getToken(SQLiteParser.K_FAIL, 0); }
		public TerminalNode K_IGNORE() { return getToken(SQLiteParser.K_IGNORE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public Update_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterUpdate_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitUpdate_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitUpdate_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_stmtContext update_stmt() throws RecognitionException {
		Update_stmtContext _localctx = new Update_stmtContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_update_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(978);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(977);
				with_clause();
				}
			}

			setState(980);
			match(K_UPDATE);
			setState(991);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
			case 1:
				{
				setState(981);
				match(K_OR);
				setState(982);
				match(K_ROLLBACK);
				}
				break;
			case 2:
				{
				setState(983);
				match(K_OR);
				setState(984);
				match(K_ABORT);
				}
				break;
			case 3:
				{
				setState(985);
				match(K_OR);
				setState(986);
				match(K_REPLACE);
				}
				break;
			case 4:
				{
				setState(987);
				match(K_OR);
				setState(988);
				match(K_FAIL);
				}
				break;
			case 5:
				{
				setState(989);
				match(K_OR);
				setState(990);
				match(K_IGNORE);
				}
				break;
			}
			setState(993);
			qualified_table_name();
			setState(994);
			match(K_SET);
			setState(995);
			update_values_stmt();
			setState(1000);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(996);
				match(COMMA);
				setState(997);
				update_values_stmt();
				}
				}
				setState(1002);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1004);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(1003);
				where_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_stmt_limitedContext extends ParserRuleContext {
		public TerminalNode K_UPDATE() { return getToken(SQLiteParser.K_UPDATE, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public TerminalNode K_SET() { return getToken(SQLiteParser.K_SET, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(SQLiteParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SQLiteParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode K_OR() { return getToken(SQLiteParser.K_OR, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SQLiteParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SQLiteParser.K_ABORT, 0); }
		public TerminalNode K_REPLACE() { return getToken(SQLiteParser.K_REPLACE, 0); }
		public TerminalNode K_FAIL() { return getToken(SQLiteParser.K_FAIL, 0); }
		public TerminalNode K_IGNORE() { return getToken(SQLiteParser.K_IGNORE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public TerminalNode K_LIMIT() { return getToken(SQLiteParser.K_LIMIT, 0); }
		public TerminalNode K_ORDER() { return getToken(SQLiteParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SQLiteParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_OFFSET() { return getToken(SQLiteParser.K_OFFSET, 0); }
		public Update_stmt_limitedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_stmt_limited; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterUpdate_stmt_limited(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitUpdate_stmt_limited(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitUpdate_stmt_limited(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_stmt_limitedContext update_stmt_limited() throws RecognitionException {
		Update_stmt_limitedContext _localctx = new Update_stmt_limitedContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_update_stmt_limited);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1007);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(1006);
				with_clause();
				}
			}

			setState(1009);
			match(K_UPDATE);
			setState(1020);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				{
				setState(1010);
				match(K_OR);
				setState(1011);
				match(K_ROLLBACK);
				}
				break;
			case 2:
				{
				setState(1012);
				match(K_OR);
				setState(1013);
				match(K_ABORT);
				}
				break;
			case 3:
				{
				setState(1014);
				match(K_OR);
				setState(1015);
				match(K_REPLACE);
				}
				break;
			case 4:
				{
				setState(1016);
				match(K_OR);
				setState(1017);
				match(K_FAIL);
				}
				break;
			case 5:
				{
				setState(1018);
				match(K_OR);
				setState(1019);
				match(K_IGNORE);
				}
				break;
			}
			setState(1022);
			qualified_table_name();
			setState(1023);
			match(K_SET);
			setState(1024);
			column_name();
			setState(1025);
			match(ASSIGN);
			setState(1026);
			expr(0);
			setState(1034);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1027);
				match(COMMA);
				setState(1028);
				column_name();
				setState(1029);
				match(ASSIGN);
				setState(1030);
				expr(0);
				}
				}
				setState(1036);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1038);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(1037);
				where_clause();
				}
			}

			setState(1058);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_LIMIT || _la==K_ORDER) {
				{
				setState(1050);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_ORDER) {
					{
					setState(1040);
					match(K_ORDER);
					setState(1041);
					match(K_BY);
					setState(1042);
					ordering_term();
					setState(1047);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1043);
						match(COMMA);
						setState(1044);
						ordering_term();
						}
						}
						setState(1049);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1052);
				match(K_LIMIT);
				setState(1053);
				expr(0);
				setState(1056);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(1054);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1055);
					expr(0);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Use_database_stmtContext extends ParserRuleContext {
		public TerminalNode K_USE() { return getToken(SQLiteParser.K_USE, 0); }
		public TerminalNode K_DATABASE() { return getToken(SQLiteParser.K_DATABASE, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Use_database_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_use_database_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterUse_database_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitUse_database_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitUse_database_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Use_database_stmtContext use_database_stmt() throws RecognitionException {
		Use_database_stmtContext _localctx = new Use_database_stmtContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_use_database_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1060);
			match(K_USE);
			setState(1061);
			match(K_DATABASE);
			setState(1062);
			database_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vacuum_stmtContext extends ParserRuleContext {
		public TerminalNode K_VACUUM() { return getToken(SQLiteParser.K_VACUUM, 0); }
		public Vacuum_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vacuum_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterVacuum_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitVacuum_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitVacuum_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vacuum_stmtContext vacuum_stmt() throws RecognitionException {
		Vacuum_stmtContext _localctx = new Vacuum_stmtContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_vacuum_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1064);
			match(K_VACUUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_defContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public List<Column_constraintContext> column_constraint() {
			return getRuleContexts(Column_constraintContext.class);
		}
		public Column_constraintContext column_constraint(int i) {
			return getRuleContext(Column_constraintContext.class,i);
		}
		public Column_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterColumn_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitColumn_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitColumn_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_defContext column_def() throws RecognitionException {
		Column_defContext _localctx = new Column_defContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_column_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1066);
			column_name();
			setState(1068);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
			case 1:
				{
				setState(1067);
				type_name();
				}
				break;
			}
			setState(1073);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_CHECK) | (1L << K_COLLATE) | (1L << K_CONSTRAINT) | (1L << K_DEFAULT))) != 0) || ((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (K_NOT - 103)) | (1L << (K_NULL - 103)) | (1L << (K_PRIMARY - 103)) | (1L << (K_REFERENCES - 103)) | (1L << (K_UNIQUE - 103)))) != 0)) {
				{
				{
				setState(1070);
				column_constraint();
				}
				}
				setState(1075);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Signed_numberContext> signed_number() {
			return getRuleContexts(Signed_numberContext.class);
		}
		public Signed_numberContext signed_number(int i) {
			return getRuleContext(Signed_numberContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitType_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitType_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_type_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1076);
			name();
			setState(1087);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,145,_ctx) ) {
			case 1:
				{
				setState(1077);
				match(OPEN_PAR);
				setState(1078);
				signed_number();
				setState(1079);
				match(CLOSE_PAR);
				}
				break;
			case 2:
				{
				setState(1081);
				match(OPEN_PAR);
				setState(1082);
				signed_number();
				setState(1083);
				match(COMMA);
				setState(1084);
				signed_number();
				setState(1085);
				match(CLOSE_PAR);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_constraintContext extends ParserRuleContext {
		public TerminalNode K_PRIMARY() { return getToken(SQLiteParser.K_PRIMARY, 0); }
		public TerminalNode K_KEY() { return getToken(SQLiteParser.K_KEY, 0); }
		public Conflict_clauseContext conflict_clause() {
			return getRuleContext(Conflict_clauseContext.class,0);
		}
		public TerminalNode K_NULL() { return getToken(SQLiteParser.K_NULL, 0); }
		public TerminalNode K_UNIQUE() { return getToken(SQLiteParser.K_UNIQUE, 0); }
		public TerminalNode K_CHECK() { return getToken(SQLiteParser.K_CHECK, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode K_DEFAULT() { return getToken(SQLiteParser.K_DEFAULT, 0); }
		public TerminalNode K_COLLATE() { return getToken(SQLiteParser.K_COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Foreign_key_clauseContext foreign_key_clause() {
			return getRuleContext(Foreign_key_clauseContext.class,0);
		}
		public TerminalNode K_CONSTRAINT() { return getToken(SQLiteParser.K_CONSTRAINT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode K_AUTOINCREMENT() { return getToken(SQLiteParser.K_AUTOINCREMENT, 0); }
		public TerminalNode K_NOT() { return getToken(SQLiteParser.K_NOT, 0); }
		public TerminalNode K_ASC() { return getToken(SQLiteParser.K_ASC, 0); }
		public TerminalNode K_DESC() { return getToken(SQLiteParser.K_DESC, 0); }
		public Column_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterColumn_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitColumn_constraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitColumn_constraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_constraintContext column_constraint() throws RecognitionException {
		Column_constraintContext _localctx = new Column_constraintContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1091);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_CONSTRAINT) {
				{
				setState(1089);
				match(K_CONSTRAINT);
				setState(1090);
				name();
				}
			}

			setState(1126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_PRIMARY:
				{
				setState(1093);
				match(K_PRIMARY);
				setState(1094);
				match(K_KEY);
				setState(1096);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_ASC || _la==K_DESC) {
					{
					setState(1095);
					_la = _input.LA(1);
					if ( !(_la==K_ASC || _la==K_DESC) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1098);
				conflict_clause();
				setState(1100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_AUTOINCREMENT) {
					{
					setState(1099);
					match(K_AUTOINCREMENT);
					}
				}

				}
				break;
			case K_NOT:
			case K_NULL:
				{
				setState(1103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(1102);
					match(K_NOT);
					}
				}

				setState(1105);
				match(K_NULL);
				setState(1106);
				conflict_clause();
				}
				break;
			case K_UNIQUE:
				{
				setState(1107);
				match(K_UNIQUE);
				setState(1108);
				conflict_clause();
				}
				break;
			case K_CHECK:
				{
				setState(1109);
				match(K_CHECK);
				setState(1110);
				match(OPEN_PAR);
				setState(1111);
				expr(0);
				setState(1112);
				match(CLOSE_PAR);
				}
				break;
			case K_DEFAULT:
				{
				setState(1114);
				match(K_DEFAULT);
				setState(1121);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
				case 1:
					{
					setState(1115);
					signed_number();
					}
					break;
				case 2:
					{
					setState(1116);
					literal_value();
					}
					break;
				case 3:
					{
					setState(1117);
					match(OPEN_PAR);
					setState(1118);
					expr(0);
					setState(1119);
					match(CLOSE_PAR);
					}
					break;
				}
				}
				break;
			case K_COLLATE:
				{
				setState(1123);
				match(K_COLLATE);
				setState(1124);
				collation_name();
				}
				break;
			case K_REFERENCES:
				{
				setState(1125);
				foreign_key_clause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conflict_clauseContext extends ParserRuleContext {
		public TerminalNode K_ON() { return getToken(SQLiteParser.K_ON, 0); }
		public TerminalNode K_CONFLICT() { return getToken(SQLiteParser.K_CONFLICT, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SQLiteParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SQLiteParser.K_ABORT, 0); }
		public TerminalNode K_FAIL() { return getToken(SQLiteParser.K_FAIL, 0); }
		public TerminalNode K_IGNORE() { return getToken(SQLiteParser.K_IGNORE, 0); }
		public TerminalNode K_REPLACE() { return getToken(SQLiteParser.K_REPLACE, 0); }
		public Conflict_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conflict_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterConflict_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitConflict_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitConflict_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conflict_clauseContext conflict_clause() throws RecognitionException {
		Conflict_clauseContext _localctx = new Conflict_clauseContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_conflict_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ON) {
				{
				setState(1128);
				match(K_ON);
				setState(1129);
				match(K_CONFLICT);
				setState(1130);
				_la = _input.LA(1);
				if ( !(_la==K_ABORT || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (K_FAIL - 73)) | (1L << (K_IGNORE - 73)) | (1L << (K_REPLACE - 73)) | (1L << (K_ROLLBACK - 73)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode BIND_PARAMETER() { return getToken(SQLiteParser.BIND_PARAMETER, 0); }
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(SQLiteParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SQLiteParser.DOT, i);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode STAR() { return getToken(SQLiteParser.STAR, 0); }
		public TerminalNode K_DISTINCT() { return getToken(SQLiteParser.K_DISTINCT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode K_CAST() { return getToken(SQLiteParser.K_CAST, 0); }
		public TerminalNode K_AS() { return getToken(SQLiteParser.K_AS, 0); }
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode K_EXISTS() { return getToken(SQLiteParser.K_EXISTS, 0); }
		public TerminalNode K_NOT() { return getToken(SQLiteParser.K_NOT, 0); }
		public TerminalNode K_CASE() { return getToken(SQLiteParser.K_CASE, 0); }
		public TerminalNode K_END() { return getToken(SQLiteParser.K_END, 0); }
		public List<TerminalNode> K_WHEN() { return getTokens(SQLiteParser.K_WHEN); }
		public TerminalNode K_WHEN(int i) {
			return getToken(SQLiteParser.K_WHEN, i);
		}
		public List<TerminalNode> K_THEN() { return getTokens(SQLiteParser.K_THEN); }
		public TerminalNode K_THEN(int i) {
			return getToken(SQLiteParser.K_THEN, i);
		}
		public TerminalNode K_ELSE() { return getToken(SQLiteParser.K_ELSE, 0); }
		public Raise_functionContext raise_function() {
			return getRuleContext(Raise_functionContext.class,0);
		}
		public TerminalNode PIPE2() { return getToken(SQLiteParser.PIPE2, 0); }
		public TerminalNode DIV() { return getToken(SQLiteParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(SQLiteParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(SQLiteParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SQLiteParser.MINUS, 0); }
		public TerminalNode LT2() { return getToken(SQLiteParser.LT2, 0); }
		public TerminalNode GT2() { return getToken(SQLiteParser.GT2, 0); }
		public TerminalNode AMP() { return getToken(SQLiteParser.AMP, 0); }
		public TerminalNode PIPE() { return getToken(SQLiteParser.PIPE, 0); }
		public TerminalNode LT() { return getToken(SQLiteParser.LT, 0); }
		public TerminalNode LT_EQ() { return getToken(SQLiteParser.LT_EQ, 0); }
		public TerminalNode GT() { return getToken(SQLiteParser.GT, 0); }
		public TerminalNode GT_EQ() { return getToken(SQLiteParser.GT_EQ, 0); }
		public TerminalNode ASSIGN() { return getToken(SQLiteParser.ASSIGN, 0); }
		public TerminalNode EQ() { return getToken(SQLiteParser.EQ, 0); }
		public TerminalNode NOT_EQ1() { return getToken(SQLiteParser.NOT_EQ1, 0); }
		public TerminalNode NOT_EQ2() { return getToken(SQLiteParser.NOT_EQ2, 0); }
		public TerminalNode K_IS() { return getToken(SQLiteParser.K_IS, 0); }
		public TerminalNode K_IN() { return getToken(SQLiteParser.K_IN, 0); }
		public TerminalNode K_LIKE() { return getToken(SQLiteParser.K_LIKE, 0); }
		public TerminalNode K_GLOB() { return getToken(SQLiteParser.K_GLOB, 0); }
		public TerminalNode K_MATCH() { return getToken(SQLiteParser.K_MATCH, 0); }
		public TerminalNode K_REGEXP() { return getToken(SQLiteParser.K_REGEXP, 0); }
		public TerminalNode K_AND() { return getToken(SQLiteParser.K_AND, 0); }
		public TerminalNode K_OR() { return getToken(SQLiteParser.K_OR, 0); }
		public TerminalNode K_BETWEEN() { return getToken(SQLiteParser.K_BETWEEN, 0); }
		public TerminalNode K_COLLATE() { return getToken(SQLiteParser.K_COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public TerminalNode K_ESCAPE() { return getToken(SQLiteParser.K_ESCAPE, 0); }
		public TerminalNode K_ISNULL() { return getToken(SQLiteParser.K_ISNULL, 0); }
		public TerminalNode K_NOTNULL() { return getToken(SQLiteParser.K_NOTNULL, 0); }
		public TerminalNode K_NULL() { return getToken(SQLiteParser.K_NULL, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 92;
		enterRecursionRule(_localctx, 92, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,163,_ctx) ) {
			case 1:
				{
				setState(1134);
				literal_value();
				}
				break;
			case 2:
				{
				setState(1135);
				match(BIND_PARAMETER);
				}
				break;
			case 3:
				{
				setState(1144);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,154,_ctx) ) {
				case 1:
					{
					setState(1139);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
					case 1:
						{
						setState(1136);
						database_name();
						setState(1137);
						match(DOT);
						}
						break;
					}
					setState(1141);
					table_name();
					setState(1142);
					match(DOT);
					}
					break;
				}
				setState(1146);
				column_name();
				}
				break;
			case 4:
				{
				setState(1147);
				unary_operator();
				setState(1148);
				expr(21);
				}
				break;
			case 5:
				{
				setState(1150);
				function_name();
				setState(1151);
				match(OPEN_PAR);
				setState(1164);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPEN_PAR:
				case PLUS:
				case MINUS:
				case TILDE:
				case K_ABORT:
				case K_ACTION:
				case K_ADD:
				case K_AFTER:
				case K_ALL:
				case K_ALTER:
				case K_ANALYZE:
				case K_AND:
				case K_AS:
				case K_ASC:
				case K_ATTACH:
				case K_AUTOINCREMENT:
				case K_BEFORE:
				case K_BEGIN:
				case K_BETWEEN:
				case K_BY:
				case K_CASCADE:
				case K_CASE:
				case K_CAST:
				case K_CHECK:
				case K_COLLATE:
				case K_COLUMN:
				case K_COMMIT:
				case K_CONFLICT:
				case K_CONSTRAINT:
				case K_CREATE:
				case K_CROSS:
				case K_CURRENT_DATE:
				case K_CURRENT_TIME:
				case K_CURRENT_TIMESTAMP:
				case K_DATABASE:
				case K_DEFAULT:
				case K_DEFERRABLE:
				case K_DEFERRED:
				case K_DELETE:
				case K_DESC:
				case K_DETACH:
				case K_DISTINCT:
				case K_DROP:
				case K_EACH:
				case K_ELSE:
				case K_END:
				case K_ESCAPE:
				case K_EXCEPT:
				case K_EXCLUSIVE:
				case K_EXISTS:
				case K_EXPLAIN:
				case K_FAIL:
				case K_FOR:
				case K_FOREIGN:
				case K_FROM:
				case K_FULL:
				case K_GLOB:
				case K_GROUP:
				case K_HAVING:
				case K_IF:
				case K_IGNORE:
				case K_IMMEDIATE:
				case K_IN:
				case K_INDEX:
				case K_INDEXED:
				case K_INITIALLY:
				case K_INNER:
				case K_INSERT:
				case K_INSTEAD:
				case K_INTERSECT:
				case K_INTO:
				case K_IS:
				case K_ISNULL:
				case K_JOIN:
				case K_KEY:
				case K_LEFT:
				case K_LIKE:
				case K_LIMIT:
				case K_MATCH:
				case K_NATURAL:
				case K_NO:
				case K_NOT:
				case K_NOTNULL:
				case K_NULL:
				case K_OF:
				case K_OFFSET:
				case K_ON:
				case K_OR:
				case K_ORDER:
				case K_OUTER:
				case K_PLAN:
				case K_PRAGMA:
				case K_PRIMARY:
				case K_QUERY:
				case K_RAISE:
				case K_RECURSIVE:
				case K_REFERENCES:
				case K_REGEXP:
				case K_REINDEX:
				case K_RELEASE:
				case K_RENAME:
				case K_REPLACE:
				case K_RESTRICT:
				case K_RIGHT:
				case K_ROLLBACK:
				case K_ROW:
				case K_SAVEPOINT:
				case K_SELECT:
				case K_SET:
				case K_SHOW:
				case K_TABLE:
				case K_TEMP:
				case K_TEMPORARY:
				case K_THEN:
				case K_TO:
				case K_TRANSACTION:
				case K_TRIGGER:
				case K_UNION:
				case K_UNIQUE:
				case K_UPDATE:
				case K_USE:
				case K_USING:
				case K_VACUUM:
				case K_VALUES:
				case K_VIEW:
				case K_VIRTUAL:
				case K_WHEN:
				case K_WHERE:
				case K_WITH:
				case K_WITHOUT:
				case IDENTIFIER:
				case NUMERIC_LITERAL:
				case BIND_PARAMETER:
				case STRING_LITERAL:
				case BLOB_LITERAL:
					{
					setState(1153);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
					case 1:
						{
						setState(1152);
						match(K_DISTINCT);
						}
						break;
					}
					setState(1155);
					expr(0);
					setState(1160);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1156);
						match(COMMA);
						setState(1157);
						expr(0);
						}
						}
						setState(1162);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case STAR:
					{
					setState(1163);
					match(STAR);
					}
					break;
				case CLOSE_PAR:
					break;
				default:
					break;
				}
				setState(1166);
				match(CLOSE_PAR);
				}
				break;
			case 6:
				{
				setState(1168);
				match(OPEN_PAR);
				setState(1169);
				expr(0);
				setState(1170);
				match(CLOSE_PAR);
				}
				break;
			case 7:
				{
				setState(1172);
				match(K_CAST);
				setState(1173);
				match(OPEN_PAR);
				setState(1174);
				expr(0);
				setState(1175);
				match(K_AS);
				setState(1176);
				type_name();
				setState(1177);
				match(CLOSE_PAR);
				}
				break;
			case 8:
				{
				setState(1183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_EXISTS || _la==K_NOT) {
					{
					setState(1180);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_NOT) {
						{
						setState(1179);
						match(K_NOT);
						}
					}

					setState(1182);
					match(K_EXISTS);
					}
				}

				setState(1185);
				match(OPEN_PAR);
				setState(1186);
				select_stmt();
				setState(1187);
				match(CLOSE_PAR);
				}
				break;
			case 9:
				{
				setState(1189);
				match(K_CASE);
				setState(1191);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
				case 1:
					{
					setState(1190);
					expr(0);
					}
					break;
				}
				setState(1198); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1193);
					match(K_WHEN);
					setState(1194);
					expr(0);
					setState(1195);
					match(K_THEN);
					setState(1196);
					expr(0);
					}
					}
					setState(1200); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==K_WHEN );
				setState(1204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_ELSE) {
					{
					setState(1202);
					match(K_ELSE);
					setState(1203);
					expr(0);
					}
				}

				setState(1206);
				match(K_END);
				}
				break;
			case 10:
				{
				setState(1208);
				raise_function();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1311);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1309);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,175,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1211);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(1212);
						match(PIPE2);
						setState(1213);
						expr(21);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1214);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(1215);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1216);
						expr(20);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1217);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(1218);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1219);
						expr(19);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1220);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(1221);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT2) | (1L << GT2) | (1L << AMP) | (1L << PIPE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1222);
						expr(18);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1223);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(1224);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LT_EQ) | (1L << GT) | (1L << GT_EQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1225);
						expr(17);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1226);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1239);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
						case 1:
							{
							setState(1227);
							match(ASSIGN);
							}
							break;
						case 2:
							{
							setState(1228);
							match(EQ);
							}
							break;
						case 3:
							{
							setState(1229);
							match(NOT_EQ1);
							}
							break;
						case 4:
							{
							setState(1230);
							match(NOT_EQ2);
							}
							break;
						case 5:
							{
							setState(1231);
							match(K_IS);
							}
							break;
						case 6:
							{
							setState(1232);
							match(K_IS);
							setState(1233);
							match(K_NOT);
							}
							break;
						case 7:
							{
							setState(1234);
							match(K_IN);
							}
							break;
						case 8:
							{
							setState(1235);
							match(K_LIKE);
							}
							break;
						case 9:
							{
							setState(1236);
							match(K_GLOB);
							}
							break;
						case 10:
							{
							setState(1237);
							match(K_MATCH);
							}
							break;
						case 11:
							{
							setState(1238);
							match(K_REGEXP);
							}
							break;
						}
						setState(1241);
						expr(16);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1242);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1243);
						match(K_AND);
						setState(1244);
						expr(15);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1245);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1246);
						match(K_OR);
						setState(1247);
						expr(14);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1248);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1249);
						match(K_IS);
						setState(1251);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
						case 1:
							{
							setState(1250);
							match(K_NOT);
							}
							break;
						}
						setState(1253);
						expr(7);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1254);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1256);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(1255);
							match(K_NOT);
							}
						}

						setState(1258);
						match(K_BETWEEN);
						setState(1259);
						expr(0);
						setState(1260);
						match(K_AND);
						setState(1261);
						expr(6);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1263);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1264);
						match(K_COLLATE);
						setState(1265);
						collation_name();
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1266);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1268);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(1267);
							match(K_NOT);
							}
						}

						setState(1270);
						_la = _input.LA(1);
						if ( !(((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (K_GLOB - 78)) | (1L << (K_LIKE - 78)) | (1L << (K_MATCH - 78)) | (1L << (K_REGEXP - 78)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1271);
						expr(0);
						setState(1274);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
						case 1:
							{
							setState(1272);
							match(K_ESCAPE);
							setState(1273);
							expr(0);
							}
							break;
						}
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1276);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1281);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case K_ISNULL:
							{
							setState(1277);
							match(K_ISNULL);
							}
							break;
						case K_NOTNULL:
							{
							setState(1278);
							match(K_NOTNULL);
							}
							break;
						case K_NOT:
							{
							setState(1279);
							match(K_NOT);
							setState(1280);
							match(K_NULL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 14:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1283);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1285);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(1284);
							match(K_NOT);
							}
						}

						setState(1287);
						match(K_IN);
						setState(1307);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
						case 1:
							{
							setState(1288);
							match(OPEN_PAR);
							setState(1298);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
							case 1:
								{
								setState(1289);
								select_stmt();
								}
								break;
							case 2:
								{
								setState(1290);
								expr(0);
								setState(1295);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==COMMA) {
									{
									{
									setState(1291);
									match(COMMA);
									setState(1292);
									expr(0);
									}
									}
									setState(1297);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
								break;
							}
							setState(1300);
							match(CLOSE_PAR);
							}
							break;
						case 2:
							{
							setState(1304);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
							case 1:
								{
								setState(1301);
								database_name();
								setState(1302);
								match(DOT);
								}
								break;
							}
							setState(1306);
							table_name();
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(1313);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Foreign_key_clauseContext extends ParserRuleContext {
		public TerminalNode K_REFERENCES() { return getToken(SQLiteParser.K_REFERENCES, 0); }
		public Foreign_tableContext foreign_table() {
			return getRuleContext(Foreign_tableContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode K_DEFERRABLE() { return getToken(SQLiteParser.K_DEFERRABLE, 0); }
		public List<TerminalNode> K_ON() { return getTokens(SQLiteParser.K_ON); }
		public TerminalNode K_ON(int i) {
			return getToken(SQLiteParser.K_ON, i);
		}
		public List<TerminalNode> K_MATCH() { return getTokens(SQLiteParser.K_MATCH); }
		public TerminalNode K_MATCH(int i) {
			return getToken(SQLiteParser.K_MATCH, i);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public List<TerminalNode> K_DELETE() { return getTokens(SQLiteParser.K_DELETE); }
		public TerminalNode K_DELETE(int i) {
			return getToken(SQLiteParser.K_DELETE, i);
		}
		public List<TerminalNode> K_UPDATE() { return getTokens(SQLiteParser.K_UPDATE); }
		public TerminalNode K_UPDATE(int i) {
			return getToken(SQLiteParser.K_UPDATE, i);
		}
		public TerminalNode K_NOT() { return getToken(SQLiteParser.K_NOT, 0); }
		public TerminalNode K_INITIALLY() { return getToken(SQLiteParser.K_INITIALLY, 0); }
		public TerminalNode K_DEFERRED() { return getToken(SQLiteParser.K_DEFERRED, 0); }
		public TerminalNode K_IMMEDIATE() { return getToken(SQLiteParser.K_IMMEDIATE, 0); }
		public List<TerminalNode> K_SET() { return getTokens(SQLiteParser.K_SET); }
		public TerminalNode K_SET(int i) {
			return getToken(SQLiteParser.K_SET, i);
		}
		public List<TerminalNode> K_NULL() { return getTokens(SQLiteParser.K_NULL); }
		public TerminalNode K_NULL(int i) {
			return getToken(SQLiteParser.K_NULL, i);
		}
		public List<TerminalNode> K_DEFAULT() { return getTokens(SQLiteParser.K_DEFAULT); }
		public TerminalNode K_DEFAULT(int i) {
			return getToken(SQLiteParser.K_DEFAULT, i);
		}
		public List<TerminalNode> K_CASCADE() { return getTokens(SQLiteParser.K_CASCADE); }
		public TerminalNode K_CASCADE(int i) {
			return getToken(SQLiteParser.K_CASCADE, i);
		}
		public List<TerminalNode> K_RESTRICT() { return getTokens(SQLiteParser.K_RESTRICT); }
		public TerminalNode K_RESTRICT(int i) {
			return getToken(SQLiteParser.K_RESTRICT, i);
		}
		public List<TerminalNode> K_NO() { return getTokens(SQLiteParser.K_NO); }
		public TerminalNode K_NO(int i) {
			return getToken(SQLiteParser.K_NO, i);
		}
		public List<TerminalNode> K_ACTION() { return getTokens(SQLiteParser.K_ACTION); }
		public TerminalNode K_ACTION(int i) {
			return getToken(SQLiteParser.K_ACTION, i);
		}
		public Foreign_key_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreign_key_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterForeign_key_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitForeign_key_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitForeign_key_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Foreign_key_clauseContext foreign_key_clause() throws RecognitionException {
		Foreign_key_clauseContext _localctx = new Foreign_key_clauseContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_foreign_key_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1314);
			match(K_REFERENCES);
			setState(1315);
			foreign_table();
			setState(1327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(1316);
				match(OPEN_PAR);
				setState(1317);
				column_name();
				setState(1322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1318);
					match(COMMA);
					setState(1319);
					column_name();
					}
					}
					setState(1324);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1325);
				match(CLOSE_PAR);
				}
			}

			setState(1347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_MATCH || _la==K_ON) {
				{
				{
				setState(1343);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case K_ON:
					{
					setState(1329);
					match(K_ON);
					setState(1330);
					_la = _input.LA(1);
					if ( !(_la==K_DELETE || _la==K_UPDATE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1339);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
					case 1:
						{
						setState(1331);
						match(K_SET);
						setState(1332);
						match(K_NULL);
						}
						break;
					case 2:
						{
						setState(1333);
						match(K_SET);
						setState(1334);
						match(K_DEFAULT);
						}
						break;
					case 3:
						{
						setState(1335);
						match(K_CASCADE);
						}
						break;
					case 4:
						{
						setState(1336);
						match(K_RESTRICT);
						}
						break;
					case 5:
						{
						setState(1337);
						match(K_NO);
						setState(1338);
						match(K_ACTION);
						}
						break;
					}
					}
					break;
				case K_MATCH:
					{
					setState(1341);
					match(K_MATCH);
					setState(1342);
					name();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(1349);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,184,_ctx) ) {
			case 1:
				{
				setState(1351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(1350);
					match(K_NOT);
					}
				}

				setState(1353);
				match(K_DEFERRABLE);
				setState(1358);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
				case 1:
					{
					setState(1354);
					match(K_INITIALLY);
					setState(1355);
					match(K_DEFERRED);
					}
					break;
				case 2:
					{
					setState(1356);
					match(K_INITIALLY);
					setState(1357);
					match(K_IMMEDIATE);
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Raise_functionContext extends ParserRuleContext {
		public TerminalNode K_RAISE() { return getToken(SQLiteParser.K_RAISE, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public TerminalNode K_IGNORE() { return getToken(SQLiteParser.K_IGNORE, 0); }
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public Error_messageContext error_message() {
			return getRuleContext(Error_messageContext.class,0);
		}
		public TerminalNode K_ROLLBACK() { return getToken(SQLiteParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SQLiteParser.K_ABORT, 0); }
		public TerminalNode K_FAIL() { return getToken(SQLiteParser.K_FAIL, 0); }
		public Raise_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raise_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterRaise_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitRaise_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitRaise_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Raise_functionContext raise_function() throws RecognitionException {
		Raise_functionContext _localctx = new Raise_functionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_raise_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1362);
			match(K_RAISE);
			setState(1363);
			match(OPEN_PAR);
			setState(1368);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_IGNORE:
				{
				setState(1364);
				match(K_IGNORE);
				}
				break;
			case K_ABORT:
			case K_FAIL:
			case K_ROLLBACK:
				{
				setState(1365);
				_la = _input.LA(1);
				if ( !(_la==K_ABORT || _la==K_FAIL || _la==K_ROLLBACK) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1366);
				match(COMMA);
				setState(1367);
				error_message();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1370);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Indexed_columnContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode K_COLLATE() { return getToken(SQLiteParser.K_COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public TerminalNode K_ASC() { return getToken(SQLiteParser.K_ASC, 0); }
		public TerminalNode K_DESC() { return getToken(SQLiteParser.K_DESC, 0); }
		public Indexed_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexed_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterIndexed_column(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitIndexed_column(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitIndexed_column(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Indexed_columnContext indexed_column() throws RecognitionException {
		Indexed_columnContext _localctx = new Indexed_columnContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_indexed_column);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1372);
			column_name();
			setState(1375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_COLLATE) {
				{
				setState(1373);
				match(K_COLLATE);
				setState(1374);
				collation_name();
				}
			}

			setState(1378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(1377);
				_la = _input.LA(1);
				if ( !(_la==K_ASC || _la==K_DESC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_constraintContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Indexed_columnContext> indexed_column() {
			return getRuleContexts(Indexed_columnContext.class);
		}
		public Indexed_columnContext indexed_column(int i) {
			return getRuleContext(Indexed_columnContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public Conflict_clauseContext conflict_clause() {
			return getRuleContext(Conflict_clauseContext.class,0);
		}
		public TerminalNode K_CHECK() { return getToken(SQLiteParser.K_CHECK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_FOREIGN() { return getToken(SQLiteParser.K_FOREIGN, 0); }
		public TerminalNode K_KEY() { return getToken(SQLiteParser.K_KEY, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public Foreign_key_clauseContext foreign_key_clause() {
			return getRuleContext(Foreign_key_clauseContext.class,0);
		}
		public TerminalNode K_CONSTRAINT() { return getToken(SQLiteParser.K_CONSTRAINT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode K_PRIMARY() { return getToken(SQLiteParser.K_PRIMARY, 0); }
		public TerminalNode K_UNIQUE() { return getToken(SQLiteParser.K_UNIQUE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Table_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterTable_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitTable_constraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitTable_constraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_constraintContext table_constraint() throws RecognitionException {
		Table_constraintContext _localctx = new Table_constraintContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_CONSTRAINT) {
				{
				setState(1380);
				match(K_CONSTRAINT);
				setState(1381);
				name();
				}
			}

			setState(1420);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_PRIMARY:
			case K_UNIQUE:
				{
				setState(1387);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case K_PRIMARY:
					{
					setState(1384);
					match(K_PRIMARY);
					setState(1385);
					match(K_KEY);
					}
					break;
				case K_UNIQUE:
					{
					setState(1386);
					match(K_UNIQUE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1389);
				match(OPEN_PAR);
				setState(1390);
				indexed_column();
				setState(1395);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1391);
					match(COMMA);
					setState(1392);
					indexed_column();
					}
					}
					setState(1397);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1398);
				match(CLOSE_PAR);
				setState(1399);
				conflict_clause();
				}
				break;
			case K_CHECK:
				{
				setState(1401);
				match(K_CHECK);
				setState(1402);
				match(OPEN_PAR);
				setState(1403);
				expr(0);
				setState(1404);
				match(CLOSE_PAR);
				}
				break;
			case K_FOREIGN:
				{
				setState(1406);
				match(K_FOREIGN);
				setState(1407);
				match(K_KEY);
				setState(1408);
				match(OPEN_PAR);
				setState(1409);
				column_name();
				setState(1414);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1410);
					match(COMMA);
					setState(1411);
					column_name();
					}
					}
					setState(1416);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1417);
				match(CLOSE_PAR);
				setState(1418);
				foreign_key_clause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class With_clauseContext extends ParserRuleContext {
		public TerminalNode K_WITH() { return getToken(SQLiteParser.K_WITH, 0); }
		public List<Cte_table_nameContext> cte_table_name() {
			return getRuleContexts(Cte_table_nameContext.class);
		}
		public Cte_table_nameContext cte_table_name(int i) {
			return getRuleContext(Cte_table_nameContext.class,i);
		}
		public List<TerminalNode> K_AS() { return getTokens(SQLiteParser.K_AS); }
		public TerminalNode K_AS(int i) {
			return getToken(SQLiteParser.K_AS, i);
		}
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLiteParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLiteParser.OPEN_PAR, i);
		}
		public List<Select_stmtContext> select_stmt() {
			return getRuleContexts(Select_stmtContext.class);
		}
		public Select_stmtContext select_stmt(int i) {
			return getRuleContext(Select_stmtContext.class,i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLiteParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLiteParser.CLOSE_PAR, i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SQLiteParser.K_RECURSIVE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public With_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterWith_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitWith_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitWith_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final With_clauseContext with_clause() throws RecognitionException {
		With_clauseContext _localctx = new With_clauseContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_with_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1422);
			match(K_WITH);
			setState(1424);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
			case 1:
				{
				setState(1423);
				match(K_RECURSIVE);
				}
				break;
			}
			setState(1426);
			cte_table_name();
			setState(1427);
			match(K_AS);
			setState(1428);
			match(OPEN_PAR);
			setState(1429);
			select_stmt();
			setState(1430);
			match(CLOSE_PAR);
			setState(1440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1431);
				match(COMMA);
				setState(1432);
				cte_table_name();
				setState(1433);
				match(K_AS);
				setState(1434);
				match(OPEN_PAR);
				setState(1435);
				select_stmt();
				setState(1436);
				match(CLOSE_PAR);
				}
				}
				setState(1442);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Qualified_table_nameContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public TerminalNode K_INDEXED() { return getToken(SQLiteParser.K_INDEXED, 0); }
		public TerminalNode K_BY() { return getToken(SQLiteParser.K_BY, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode K_NOT() { return getToken(SQLiteParser.K_NOT, 0); }
		public Qualified_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualified_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterQualified_table_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitQualified_table_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitQualified_table_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Qualified_table_nameContext qualified_table_name() throws RecognitionException {
		Qualified_table_nameContext _localctx = new Qualified_table_nameContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_qualified_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1446);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
			case 1:
				{
				setState(1443);
				database_name();
				setState(1444);
				match(DOT);
				}
				break;
			}
			setState(1448);
			table_name();
			setState(1454);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_INDEXED:
				{
				setState(1449);
				match(K_INDEXED);
				setState(1450);
				match(K_BY);
				setState(1451);
				index_name();
				}
				break;
			case K_NOT:
				{
				setState(1452);
				match(K_NOT);
				setState(1453);
				match(K_INDEXED);
				}
				break;
			case EOF:
			case SCOL:
			case K_ALTER:
			case K_ANALYZE:
			case K_ATTACH:
			case K_BEGIN:
			case K_COMMIT:
			case K_CREATE:
			case K_DELETE:
			case K_DETACH:
			case K_DROP:
			case K_END:
			case K_EXPLAIN:
			case K_INSERT:
			case K_LIMIT:
			case K_ORDER:
			case K_PRAGMA:
			case K_REINDEX:
			case K_RELEASE:
			case K_REPLACE:
			case K_ROLLBACK:
			case K_SAVEPOINT:
			case K_SELECT:
			case K_SET:
			case K_SHOW:
			case K_UPDATE:
			case K_USE:
			case K_VACUUM:
			case K_VALUES:
			case K_WHERE:
			case K_WITH:
			case UNEXPECTED_CHAR:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ordering_termContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_COLLATE() { return getToken(SQLiteParser.K_COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public TerminalNode K_ASC() { return getToken(SQLiteParser.K_ASC, 0); }
		public TerminalNode K_DESC() { return getToken(SQLiteParser.K_DESC, 0); }
		public Ordering_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordering_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterOrdering_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitOrdering_term(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitOrdering_term(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ordering_termContext ordering_term() throws RecognitionException {
		Ordering_termContext _localctx = new Ordering_termContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_ordering_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1456);
			expr(0);
			setState(1459);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_COLLATE) {
				{
				setState(1457);
				match(K_COLLATE);
				setState(1458);
				collation_name();
				}
			}

			setState(1462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(1461);
				_la = _input.LA(1);
				if ( !(_la==K_ASC || _la==K_DESC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pragma_valueContext extends ParserRuleContext {
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public Pragma_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterPragma_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitPragma_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitPragma_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pragma_valueContext pragma_value() throws RecognitionException {
		Pragma_valueContext _localctx = new Pragma_valueContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_pragma_value);
		try {
			setState(1467);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1464);
				signed_number();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1465);
				name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1466);
				match(STRING_LITERAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Common_table_expressionContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(SQLiteParser.K_AS, 0); }
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLiteParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLiteParser.OPEN_PAR, i);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLiteParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLiteParser.CLOSE_PAR, i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Common_table_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_common_table_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterCommon_table_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitCommon_table_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitCommon_table_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Common_table_expressionContext common_table_expression() throws RecognitionException {
		Common_table_expressionContext _localctx = new Common_table_expressionContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_common_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1469);
			table_name();
			setState(1481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(1470);
				match(OPEN_PAR);
				setState(1471);
				column_name();
				setState(1476);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1472);
					match(COMMA);
					setState(1473);
					column_name();
					}
					}
					setState(1478);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1479);
				match(CLOSE_PAR);
				}
			}

			setState(1483);
			match(K_AS);
			setState(1484);
			match(OPEN_PAR);
			setState(1485);
			select_stmt();
			setState(1486);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Result_columnContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(SQLiteParser.STAR, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Column_aliasContext column_alias() {
			return getRuleContext(Column_aliasContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(SQLiteParser.K_AS, 0); }
		public Result_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterResult_column(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitResult_column(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitResult_column(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Result_columnContext result_column() throws RecognitionException {
		Result_columnContext _localctx = new Result_columnContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_result_column);
		int _la;
		try {
			setState(1500);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1488);
				match(STAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1489);
				table_name();
				setState(1490);
				match(DOT);
				setState(1491);
				match(STAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1493);
				expr(0);
				setState(1498);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_AS || _la==IDENTIFIER || _la==STRING_LITERAL) {
					{
					setState(1495);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_AS) {
						{
						setState(1494);
						match(K_AS);
						}
					}

					setState(1497);
					column_alias();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_or_subqueryContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLiteParser.DOT, 0); }
		public Table_aliasContext table_alias() {
			return getRuleContext(Table_aliasContext.class,0);
		}
		public TerminalNode K_INDEXED() { return getToken(SQLiteParser.K_INDEXED, 0); }
		public TerminalNode K_BY() { return getToken(SQLiteParser.K_BY, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode K_NOT() { return getToken(SQLiteParser.K_NOT, 0); }
		public TerminalNode K_AS() { return getToken(SQLiteParser.K_AS, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Table_or_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_subquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterTable_or_subquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitTable_or_subquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitTable_or_subquery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_or_subqueryContext table_or_subquery() throws RecognitionException {
		Table_or_subqueryContext _localctx = new Table_or_subqueryContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_table_or_subquery);
		int _la;
		try {
			setState(1549);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,215,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1505);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,205,_ctx) ) {
				case 1:
					{
					setState(1502);
					database_name();
					setState(1503);
					match(DOT);
					}
					break;
				}
				setState(1507);
				table_name();
				setState(1512);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
				case 1:
					{
					setState(1509);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
					case 1:
						{
						setState(1508);
						match(K_AS);
						}
						break;
					}
					setState(1511);
					table_alias();
					}
					break;
				}
				setState(1519);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case K_INDEXED:
					{
					setState(1514);
					match(K_INDEXED);
					setState(1515);
					match(K_BY);
					setState(1516);
					index_name();
					}
					break;
				case K_NOT:
					{
					setState(1517);
					match(K_NOT);
					setState(1518);
					match(K_INDEXED);
					}
					break;
				case EOF:
				case SCOL:
				case CLOSE_PAR:
				case COMMA:
				case K_ALTER:
				case K_ANALYZE:
				case K_ATTACH:
				case K_BEGIN:
				case K_COMMIT:
				case K_CREATE:
				case K_CROSS:
				case K_DELETE:
				case K_DETACH:
				case K_DROP:
				case K_END:
				case K_EXCEPT:
				case K_EXPLAIN:
				case K_GROUP:
				case K_INNER:
				case K_INSERT:
				case K_INTERSECT:
				case K_JOIN:
				case K_LEFT:
				case K_LIMIT:
				case K_NATURAL:
				case K_ON:
				case K_ORDER:
				case K_PRAGMA:
				case K_REINDEX:
				case K_RELEASE:
				case K_REPLACE:
				case K_ROLLBACK:
				case K_SAVEPOINT:
				case K_SELECT:
				case K_SHOW:
				case K_UNION:
				case K_UPDATE:
				case K_USE:
				case K_USING:
				case K_VACUUM:
				case K_VALUES:
				case K_WHERE:
				case K_WITH:
				case UNEXPECTED_CHAR:
					break;
				default:
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1521);
				match(OPEN_PAR);
				setState(1531);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
				case 1:
					{
					setState(1522);
					table_or_subquery();
					setState(1527);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1523);
						match(COMMA);
						setState(1524);
						table_or_subquery();
						}
						}
						setState(1529);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(1530);
					join_clause();
					}
					break;
				}
				setState(1533);
				match(CLOSE_PAR);
				setState(1538);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,212,_ctx) ) {
				case 1:
					{
					setState(1535);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,211,_ctx) ) {
					case 1:
						{
						setState(1534);
						match(K_AS);
						}
						break;
					}
					setState(1537);
					table_alias();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1540);
				match(OPEN_PAR);
				setState(1541);
				select_stmt();
				setState(1542);
				match(CLOSE_PAR);
				setState(1547);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
				case 1:
					{
					setState(1544);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
					case 1:
						{
						setState(1543);
						match(K_AS);
						}
						break;
					}
					setState(1546);
					table_alias();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_clauseContext extends ParserRuleContext {
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public List<Join_operatorContext> join_operator() {
			return getRuleContexts(Join_operatorContext.class);
		}
		public Join_operatorContext join_operator(int i) {
			return getRuleContext(Join_operatorContext.class,i);
		}
		public List<Join_constraintContext> join_constraint() {
			return getRuleContexts(Join_constraintContext.class);
		}
		public Join_constraintContext join_constraint(int i) {
			return getRuleContext(Join_constraintContext.class,i);
		}
		public Join_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterJoin_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitJoin_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitJoin_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Join_clauseContext join_clause() throws RecognitionException {
		Join_clauseContext _localctx = new Join_clauseContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_join_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1551);
			table_or_subquery();
			setState(1558);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA || _la==K_CROSS || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (K_INNER - 88)) | (1L << (K_JOIN - 88)) | (1L << (K_LEFT - 88)) | (1L << (K_NATURAL - 88)))) != 0)) {
				{
				{
				setState(1552);
				join_operator();
				setState(1553);
				table_or_subquery();
				setState(1554);
				join_constraint();
				}
				}
				setState(1560);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_operatorContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(SQLiteParser.COMMA, 0); }
		public TerminalNode K_JOIN() { return getToken(SQLiteParser.K_JOIN, 0); }
		public TerminalNode K_NATURAL() { return getToken(SQLiteParser.K_NATURAL, 0); }
		public TerminalNode K_LEFT() { return getToken(SQLiteParser.K_LEFT, 0); }
		public TerminalNode K_INNER() { return getToken(SQLiteParser.K_INNER, 0); }
		public TerminalNode K_CROSS() { return getToken(SQLiteParser.K_CROSS, 0); }
		public TerminalNode K_OUTER() { return getToken(SQLiteParser.K_OUTER, 0); }
		public Join_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterJoin_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitJoin_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitJoin_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Join_operatorContext join_operator() throws RecognitionException {
		Join_operatorContext _localctx = new Join_operatorContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_join_operator);
		int _la;
		try {
			setState(1574);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(1561);
				match(COMMA);
				}
				break;
			case K_CROSS:
			case K_INNER:
			case K_JOIN:
			case K_LEFT:
			case K_NATURAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1563);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_NATURAL) {
					{
					setState(1562);
					match(K_NATURAL);
					}
				}

				setState(1571);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case K_LEFT:
					{
					setState(1565);
					match(K_LEFT);
					setState(1567);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(1566);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_INNER:
					{
					setState(1569);
					match(K_INNER);
					}
					break;
				case K_CROSS:
					{
					setState(1570);
					match(K_CROSS);
					}
					break;
				case K_JOIN:
					break;
				default:
					break;
				}
				setState(1573);
				match(K_JOIN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Join_constraintContext extends ParserRuleContext {
		public TerminalNode K_ON() { return getToken(SQLiteParser.K_ON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_USING() { return getToken(SQLiteParser.K_USING, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Join_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterJoin_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitJoin_constraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitJoin_constraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Join_constraintContext join_constraint() throws RecognitionException {
		Join_constraintContext _localctx = new Join_constraintContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_join_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1590);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_ON:
				{
				setState(1576);
				match(K_ON);
				setState(1577);
				expr(0);
				}
				break;
			case K_USING:
				{
				setState(1578);
				match(K_USING);
				setState(1579);
				match(OPEN_PAR);
				setState(1580);
				column_name();
				setState(1585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1581);
					match(COMMA);
					setState(1582);
					column_name();
					}
					}
					setState(1587);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1588);
				match(CLOSE_PAR);
				}
				break;
			case EOF:
			case SCOL:
			case CLOSE_PAR:
			case COMMA:
			case K_ALTER:
			case K_ANALYZE:
			case K_ATTACH:
			case K_BEGIN:
			case K_COMMIT:
			case K_CREATE:
			case K_CROSS:
			case K_DELETE:
			case K_DETACH:
			case K_DROP:
			case K_END:
			case K_EXCEPT:
			case K_EXPLAIN:
			case K_GROUP:
			case K_INNER:
			case K_INSERT:
			case K_INTERSECT:
			case K_JOIN:
			case K_LEFT:
			case K_LIMIT:
			case K_NATURAL:
			case K_ORDER:
			case K_PRAGMA:
			case K_REINDEX:
			case K_RELEASE:
			case K_REPLACE:
			case K_ROLLBACK:
			case K_SAVEPOINT:
			case K_SELECT:
			case K_SHOW:
			case K_UNION:
			case K_UPDATE:
			case K_USE:
			case K_VACUUM:
			case K_VALUES:
			case K_WHERE:
			case K_WITH:
			case UNEXPECTED_CHAR:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Where_clauseContext extends ParserRuleContext {
		public TerminalNode K_WHERE() { return getToken(SQLiteParser.K_WHERE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Where_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterWhere_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitWhere_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitWhere_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Where_clauseContext where_clause() throws RecognitionException {
		Where_clauseContext _localctx = new Where_clauseContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1592);
			match(K_WHERE);
			setState(1593);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_coreContext extends ParserRuleContext {
		public TerminalNode K_SELECT() { return getToken(SQLiteParser.K_SELECT, 0); }
		public List<Result_columnContext> result_column() {
			return getRuleContexts(Result_columnContext.class);
		}
		public Result_columnContext result_column(int i) {
			return getRuleContext(Result_columnContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public TerminalNode K_FROM() { return getToken(SQLiteParser.K_FROM, 0); }
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public TerminalNode K_GROUP() { return getToken(SQLiteParser.K_GROUP, 0); }
		public TerminalNode K_BY() { return getToken(SQLiteParser.K_BY, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_DISTINCT() { return getToken(SQLiteParser.K_DISTINCT, 0); }
		public TerminalNode K_ALL() { return getToken(SQLiteParser.K_ALL, 0); }
		public TerminalNode K_HAVING() { return getToken(SQLiteParser.K_HAVING, 0); }
		public TerminalNode K_VALUES() { return getToken(SQLiteParser.K_VALUES, 0); }
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLiteParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLiteParser.OPEN_PAR, i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLiteParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLiteParser.CLOSE_PAR, i);
		}
		public Select_coreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_core; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterSelect_core(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitSelect_core(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitSelect_core(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_coreContext select_core() throws RecognitionException {
		Select_coreContext _localctx = new Select_coreContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_select_core);
		int _la;
		try {
			setState(1658);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1595);
				match(K_SELECT);
				setState(1597);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,223,_ctx) ) {
				case 1:
					{
					setState(1596);
					_la = _input.LA(1);
					if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(1599);
				result_column();
				setState(1604);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1600);
					match(COMMA);
					setState(1601);
					result_column();
					}
					}
					setState(1606);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1609);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_FROM) {
					{
					setState(1607);
					match(K_FROM);
					setState(1608);
					join_clause();
					}
				}

				setState(1612);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_WHERE) {
					{
					setState(1611);
					where_clause();
					}
				}

				setState(1628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_GROUP) {
					{
					setState(1614);
					match(K_GROUP);
					setState(1615);
					match(K_BY);
					setState(1616);
					expr(0);
					setState(1621);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1617);
						match(COMMA);
						setState(1618);
						expr(0);
						}
						}
						setState(1623);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1626);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_HAVING) {
						{
						setState(1624);
						match(K_HAVING);
						setState(1625);
						expr(0);
						}
					}

					}
				}

				}
				break;
			case K_VALUES:
				enterOuterAlt(_localctx, 2);
				{
				setState(1630);
				match(K_VALUES);
				setState(1631);
				match(OPEN_PAR);
				setState(1632);
				expr(0);
				setState(1637);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1633);
					match(COMMA);
					setState(1634);
					expr(0);
					}
					}
					setState(1639);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1640);
				match(CLOSE_PAR);
				setState(1655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1641);
					match(COMMA);
					setState(1642);
					match(OPEN_PAR);
					setState(1643);
					expr(0);
					setState(1648);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1644);
						match(COMMA);
						setState(1645);
						expr(0);
						}
						}
						setState(1650);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1651);
					match(CLOSE_PAR);
					}
					}
					setState(1657);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_operatorContext extends ParserRuleContext {
		public TerminalNode K_UNION() { return getToken(SQLiteParser.K_UNION, 0); }
		public TerminalNode K_ALL() { return getToken(SQLiteParser.K_ALL, 0); }
		public TerminalNode K_INTERSECT() { return getToken(SQLiteParser.K_INTERSECT, 0); }
		public TerminalNode K_EXCEPT() { return getToken(SQLiteParser.K_EXCEPT, 0); }
		public Compound_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterCompound_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitCompound_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitCompound_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_operatorContext compound_operator() throws RecognitionException {
		Compound_operatorContext _localctx = new Compound_operatorContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_compound_operator);
		try {
			setState(1665);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,234,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1660);
				match(K_UNION);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1661);
				match(K_UNION);
				setState(1662);
				match(K_ALL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1663);
				match(K_INTERSECT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1664);
				match(K_EXCEPT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cte_table_nameContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLiteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLiteParser.COMMA, i);
		}
		public Cte_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cte_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterCte_table_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitCte_table_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitCte_table_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cte_table_nameContext cte_table_name() throws RecognitionException {
		Cte_table_nameContext _localctx = new Cte_table_nameContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_cte_table_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1667);
			table_name();
			setState(1679);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(1668);
				match(OPEN_PAR);
				setState(1669);
				column_name();
				setState(1674);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1670);
					match(COMMA);
					setState(1671);
					column_name();
					}
					}
					setState(1676);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1677);
				match(CLOSE_PAR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Signed_numberContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SQLiteParser.NUMERIC_LITERAL, 0); }
		public TerminalNode PLUS() { return getToken(SQLiteParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SQLiteParser.MINUS, 0); }
		public Signed_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterSigned_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitSigned_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitSigned_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Signed_numberContext signed_number() throws RecognitionException {
		Signed_numberContext _localctx = new Signed_numberContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_signed_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1682);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(1681);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(1684);
			match(NUMERIC_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Literal_valueContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SQLiteParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public TerminalNode BLOB_LITERAL() { return getToken(SQLiteParser.BLOB_LITERAL, 0); }
		public TerminalNode K_NULL() { return getToken(SQLiteParser.K_NULL, 0); }
		public TerminalNode K_CURRENT_TIME() { return getToken(SQLiteParser.K_CURRENT_TIME, 0); }
		public TerminalNode K_CURRENT_DATE() { return getToken(SQLiteParser.K_CURRENT_DATE, 0); }
		public TerminalNode K_CURRENT_TIMESTAMP() { return getToken(SQLiteParser.K_CURRENT_TIMESTAMP, 0); }
		public Literal_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterLiteral_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitLiteral_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitLiteral_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_literal_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1686);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_CURRENT_DATE) | (1L << K_CURRENT_TIME) | (1L << K_CURRENT_TIMESTAMP))) != 0) || ((((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & ((1L << (K_NULL - 105)) | (1L << (NUMERIC_LITERAL - 105)) | (1L << (STRING_LITERAL - 105)) | (1L << (BLOB_LITERAL - 105)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_operatorContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(SQLiteParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SQLiteParser.PLUS, 0); }
		public TerminalNode TILDE() { return getToken(SQLiteParser.TILDE, 0); }
		public TerminalNode K_NOT() { return getToken(SQLiteParser.K_NOT, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitUnary_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitUnary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1688);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << TILDE))) != 0) || _la==K_NOT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Error_messageContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public Error_messageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterError_message(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitError_message(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitError_message(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Error_messageContext error_message() throws RecognitionException {
		Error_messageContext _localctx = new Error_messageContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_error_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1690);
			match(STRING_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Module_argumentContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Column_defContext column_def() {
			return getRuleContext(Column_defContext.class,0);
		}
		public Module_argumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterModule_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitModule_argument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitModule_argument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Module_argumentContext module_argument() throws RecognitionException {
		Module_argumentContext _localctx = new Module_argumentContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_module_argument);
		try {
			setState(1694);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,238,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1692);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1693);
				column_def();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_aliasContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SQLiteParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public Column_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterColumn_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitColumn_alias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitColumn_alias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_aliasContext column_alias() throws RecognitionException {
		Column_aliasContext _localctx = new Column_aliasContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_column_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1696);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode K_ABORT() { return getToken(SQLiteParser.K_ABORT, 0); }
		public TerminalNode K_ACTION() { return getToken(SQLiteParser.K_ACTION, 0); }
		public TerminalNode K_ADD() { return getToken(SQLiteParser.K_ADD, 0); }
		public TerminalNode K_AFTER() { return getToken(SQLiteParser.K_AFTER, 0); }
		public TerminalNode K_ALL() { return getToken(SQLiteParser.K_ALL, 0); }
		public TerminalNode K_ALTER() { return getToken(SQLiteParser.K_ALTER, 0); }
		public TerminalNode K_ANALYZE() { return getToken(SQLiteParser.K_ANALYZE, 0); }
		public TerminalNode K_AND() { return getToken(SQLiteParser.K_AND, 0); }
		public TerminalNode K_AS() { return getToken(SQLiteParser.K_AS, 0); }
		public TerminalNode K_ASC() { return getToken(SQLiteParser.K_ASC, 0); }
		public TerminalNode K_ATTACH() { return getToken(SQLiteParser.K_ATTACH, 0); }
		public TerminalNode K_AUTOINCREMENT() { return getToken(SQLiteParser.K_AUTOINCREMENT, 0); }
		public TerminalNode K_BEFORE() { return getToken(SQLiteParser.K_BEFORE, 0); }
		public TerminalNode K_BEGIN() { return getToken(SQLiteParser.K_BEGIN, 0); }
		public TerminalNode K_BETWEEN() { return getToken(SQLiteParser.K_BETWEEN, 0); }
		public TerminalNode K_BY() { return getToken(SQLiteParser.K_BY, 0); }
		public TerminalNode K_CASCADE() { return getToken(SQLiteParser.K_CASCADE, 0); }
		public TerminalNode K_CASE() { return getToken(SQLiteParser.K_CASE, 0); }
		public TerminalNode K_CAST() { return getToken(SQLiteParser.K_CAST, 0); }
		public TerminalNode K_CHECK() { return getToken(SQLiteParser.K_CHECK, 0); }
		public TerminalNode K_COLLATE() { return getToken(SQLiteParser.K_COLLATE, 0); }
		public TerminalNode K_COLUMN() { return getToken(SQLiteParser.K_COLUMN, 0); }
		public TerminalNode K_COMMIT() { return getToken(SQLiteParser.K_COMMIT, 0); }
		public TerminalNode K_CONFLICT() { return getToken(SQLiteParser.K_CONFLICT, 0); }
		public TerminalNode K_CONSTRAINT() { return getToken(SQLiteParser.K_CONSTRAINT, 0); }
		public TerminalNode K_CREATE() { return getToken(SQLiteParser.K_CREATE, 0); }
		public TerminalNode K_CROSS() { return getToken(SQLiteParser.K_CROSS, 0); }
		public TerminalNode K_CURRENT_DATE() { return getToken(SQLiteParser.K_CURRENT_DATE, 0); }
		public TerminalNode K_CURRENT_TIME() { return getToken(SQLiteParser.K_CURRENT_TIME, 0); }
		public TerminalNode K_CURRENT_TIMESTAMP() { return getToken(SQLiteParser.K_CURRENT_TIMESTAMP, 0); }
		public TerminalNode K_DATABASE() { return getToken(SQLiteParser.K_DATABASE, 0); }
		public TerminalNode K_DEFAULT() { return getToken(SQLiteParser.K_DEFAULT, 0); }
		public TerminalNode K_DEFERRABLE() { return getToken(SQLiteParser.K_DEFERRABLE, 0); }
		public TerminalNode K_DEFERRED() { return getToken(SQLiteParser.K_DEFERRED, 0); }
		public TerminalNode K_DELETE() { return getToken(SQLiteParser.K_DELETE, 0); }
		public TerminalNode K_DESC() { return getToken(SQLiteParser.K_DESC, 0); }
		public TerminalNode K_DETACH() { return getToken(SQLiteParser.K_DETACH, 0); }
		public TerminalNode K_DISTINCT() { return getToken(SQLiteParser.K_DISTINCT, 0); }
		public TerminalNode K_DROP() { return getToken(SQLiteParser.K_DROP, 0); }
		public TerminalNode K_EACH() { return getToken(SQLiteParser.K_EACH, 0); }
		public TerminalNode K_ELSE() { return getToken(SQLiteParser.K_ELSE, 0); }
		public TerminalNode K_END() { return getToken(SQLiteParser.K_END, 0); }
		public TerminalNode K_ESCAPE() { return getToken(SQLiteParser.K_ESCAPE, 0); }
		public TerminalNode K_EXCEPT() { return getToken(SQLiteParser.K_EXCEPT, 0); }
		public TerminalNode K_EXCLUSIVE() { return getToken(SQLiteParser.K_EXCLUSIVE, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLiteParser.K_EXISTS, 0); }
		public TerminalNode K_EXPLAIN() { return getToken(SQLiteParser.K_EXPLAIN, 0); }
		public TerminalNode K_FAIL() { return getToken(SQLiteParser.K_FAIL, 0); }
		public TerminalNode K_FOR() { return getToken(SQLiteParser.K_FOR, 0); }
		public TerminalNode K_FOREIGN() { return getToken(SQLiteParser.K_FOREIGN, 0); }
		public TerminalNode K_FROM() { return getToken(SQLiteParser.K_FROM, 0); }
		public TerminalNode K_FULL() { return getToken(SQLiteParser.K_FULL, 0); }
		public TerminalNode K_GLOB() { return getToken(SQLiteParser.K_GLOB, 0); }
		public TerminalNode K_GROUP() { return getToken(SQLiteParser.K_GROUP, 0); }
		public TerminalNode K_HAVING() { return getToken(SQLiteParser.K_HAVING, 0); }
		public TerminalNode K_IF() { return getToken(SQLiteParser.K_IF, 0); }
		public TerminalNode K_IGNORE() { return getToken(SQLiteParser.K_IGNORE, 0); }
		public TerminalNode K_IMMEDIATE() { return getToken(SQLiteParser.K_IMMEDIATE, 0); }
		public TerminalNode K_IN() { return getToken(SQLiteParser.K_IN, 0); }
		public TerminalNode K_INDEX() { return getToken(SQLiteParser.K_INDEX, 0); }
		public TerminalNode K_INDEXED() { return getToken(SQLiteParser.K_INDEXED, 0); }
		public TerminalNode K_INITIALLY() { return getToken(SQLiteParser.K_INITIALLY, 0); }
		public TerminalNode K_INNER() { return getToken(SQLiteParser.K_INNER, 0); }
		public TerminalNode K_INSERT() { return getToken(SQLiteParser.K_INSERT, 0); }
		public TerminalNode K_INSTEAD() { return getToken(SQLiteParser.K_INSTEAD, 0); }
		public TerminalNode K_INTERSECT() { return getToken(SQLiteParser.K_INTERSECT, 0); }
		public TerminalNode K_INTO() { return getToken(SQLiteParser.K_INTO, 0); }
		public TerminalNode K_IS() { return getToken(SQLiteParser.K_IS, 0); }
		public TerminalNode K_ISNULL() { return getToken(SQLiteParser.K_ISNULL, 0); }
		public TerminalNode K_JOIN() { return getToken(SQLiteParser.K_JOIN, 0); }
		public TerminalNode K_KEY() { return getToken(SQLiteParser.K_KEY, 0); }
		public TerminalNode K_LEFT() { return getToken(SQLiteParser.K_LEFT, 0); }
		public TerminalNode K_LIKE() { return getToken(SQLiteParser.K_LIKE, 0); }
		public TerminalNode K_LIMIT() { return getToken(SQLiteParser.K_LIMIT, 0); }
		public TerminalNode K_MATCH() { return getToken(SQLiteParser.K_MATCH, 0); }
		public TerminalNode K_NATURAL() { return getToken(SQLiteParser.K_NATURAL, 0); }
		public TerminalNode K_NO() { return getToken(SQLiteParser.K_NO, 0); }
		public TerminalNode K_NOT() { return getToken(SQLiteParser.K_NOT, 0); }
		public TerminalNode K_NOTNULL() { return getToken(SQLiteParser.K_NOTNULL, 0); }
		public TerminalNode K_NULL() { return getToken(SQLiteParser.K_NULL, 0); }
		public TerminalNode K_OF() { return getToken(SQLiteParser.K_OF, 0); }
		public TerminalNode K_OFFSET() { return getToken(SQLiteParser.K_OFFSET, 0); }
		public TerminalNode K_ON() { return getToken(SQLiteParser.K_ON, 0); }
		public TerminalNode K_OR() { return getToken(SQLiteParser.K_OR, 0); }
		public TerminalNode K_ORDER() { return getToken(SQLiteParser.K_ORDER, 0); }
		public TerminalNode K_OUTER() { return getToken(SQLiteParser.K_OUTER, 0); }
		public TerminalNode K_PLAN() { return getToken(SQLiteParser.K_PLAN, 0); }
		public TerminalNode K_PRAGMA() { return getToken(SQLiteParser.K_PRAGMA, 0); }
		public TerminalNode K_PRIMARY() { return getToken(SQLiteParser.K_PRIMARY, 0); }
		public TerminalNode K_QUERY() { return getToken(SQLiteParser.K_QUERY, 0); }
		public TerminalNode K_RAISE() { return getToken(SQLiteParser.K_RAISE, 0); }
		public TerminalNode K_RECURSIVE() { return getToken(SQLiteParser.K_RECURSIVE, 0); }
		public TerminalNode K_REFERENCES() { return getToken(SQLiteParser.K_REFERENCES, 0); }
		public TerminalNode K_REGEXP() { return getToken(SQLiteParser.K_REGEXP, 0); }
		public TerminalNode K_REINDEX() { return getToken(SQLiteParser.K_REINDEX, 0); }
		public TerminalNode K_RELEASE() { return getToken(SQLiteParser.K_RELEASE, 0); }
		public TerminalNode K_RENAME() { return getToken(SQLiteParser.K_RENAME, 0); }
		public TerminalNode K_REPLACE() { return getToken(SQLiteParser.K_REPLACE, 0); }
		public TerminalNode K_RESTRICT() { return getToken(SQLiteParser.K_RESTRICT, 0); }
		public TerminalNode K_RIGHT() { return getToken(SQLiteParser.K_RIGHT, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SQLiteParser.K_ROLLBACK, 0); }
		public TerminalNode K_ROW() { return getToken(SQLiteParser.K_ROW, 0); }
		public TerminalNode K_SAVEPOINT() { return getToken(SQLiteParser.K_SAVEPOINT, 0); }
		public TerminalNode K_SELECT() { return getToken(SQLiteParser.K_SELECT, 0); }
		public TerminalNode K_SET() { return getToken(SQLiteParser.K_SET, 0); }
		public TerminalNode K_SHOW() { return getToken(SQLiteParser.K_SHOW, 0); }
		public TerminalNode K_TABLE() { return getToken(SQLiteParser.K_TABLE, 0); }
		public TerminalNode K_TEMP() { return getToken(SQLiteParser.K_TEMP, 0); }
		public TerminalNode K_TEMPORARY() { return getToken(SQLiteParser.K_TEMPORARY, 0); }
		public TerminalNode K_THEN() { return getToken(SQLiteParser.K_THEN, 0); }
		public TerminalNode K_TO() { return getToken(SQLiteParser.K_TO, 0); }
		public TerminalNode K_TRANSACTION() { return getToken(SQLiteParser.K_TRANSACTION, 0); }
		public TerminalNode K_TRIGGER() { return getToken(SQLiteParser.K_TRIGGER, 0); }
		public TerminalNode K_UNION() { return getToken(SQLiteParser.K_UNION, 0); }
		public TerminalNode K_UNIQUE() { return getToken(SQLiteParser.K_UNIQUE, 0); }
		public TerminalNode K_UPDATE() { return getToken(SQLiteParser.K_UPDATE, 0); }
		public TerminalNode K_USE() { return getToken(SQLiteParser.K_USE, 0); }
		public TerminalNode K_USING() { return getToken(SQLiteParser.K_USING, 0); }
		public TerminalNode K_VACUUM() { return getToken(SQLiteParser.K_VACUUM, 0); }
		public TerminalNode K_VALUES() { return getToken(SQLiteParser.K_VALUES, 0); }
		public TerminalNode K_VIEW() { return getToken(SQLiteParser.K_VIEW, 0); }
		public TerminalNode K_VIRTUAL() { return getToken(SQLiteParser.K_VIRTUAL, 0); }
		public TerminalNode K_WHEN() { return getToken(SQLiteParser.K_WHEN, 0); }
		public TerminalNode K_WHERE() { return getToken(SQLiteParser.K_WHERE, 0); }
		public TerminalNode K_WITH() { return getToken(SQLiteParser.K_WITH, 0); }
		public TerminalNode K_WITHOUT() { return getToken(SQLiteParser.K_WITHOUT, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1698);
			_la = _input.LA(1);
			if ( !(((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (K_ABORT - 25)) | (1L << (K_ACTION - 25)) | (1L << (K_ADD - 25)) | (1L << (K_AFTER - 25)) | (1L << (K_ALL - 25)) | (1L << (K_ALTER - 25)) | (1L << (K_ANALYZE - 25)) | (1L << (K_AND - 25)) | (1L << (K_AS - 25)) | (1L << (K_ASC - 25)) | (1L << (K_ATTACH - 25)) | (1L << (K_AUTOINCREMENT - 25)) | (1L << (K_BEFORE - 25)) | (1L << (K_BEGIN - 25)) | (1L << (K_BETWEEN - 25)) | (1L << (K_BY - 25)) | (1L << (K_CASCADE - 25)) | (1L << (K_CASE - 25)) | (1L << (K_CAST - 25)) | (1L << (K_CHECK - 25)) | (1L << (K_COLLATE - 25)) | (1L << (K_COLUMN - 25)) | (1L << (K_COMMIT - 25)) | (1L << (K_CONFLICT - 25)) | (1L << (K_CONSTRAINT - 25)) | (1L << (K_CREATE - 25)) | (1L << (K_CROSS - 25)) | (1L << (K_CURRENT_DATE - 25)) | (1L << (K_CURRENT_TIME - 25)) | (1L << (K_CURRENT_TIMESTAMP - 25)) | (1L << (K_DATABASE - 25)) | (1L << (K_DEFAULT - 25)) | (1L << (K_DEFERRABLE - 25)) | (1L << (K_DEFERRED - 25)) | (1L << (K_DELETE - 25)) | (1L << (K_DESC - 25)) | (1L << (K_DETACH - 25)) | (1L << (K_DISTINCT - 25)) | (1L << (K_DROP - 25)) | (1L << (K_EACH - 25)) | (1L << (K_ELSE - 25)) | (1L << (K_END - 25)) | (1L << (K_ESCAPE - 25)) | (1L << (K_EXCEPT - 25)) | (1L << (K_EXCLUSIVE - 25)) | (1L << (K_EXISTS - 25)) | (1L << (K_EXPLAIN - 25)) | (1L << (K_FAIL - 25)) | (1L << (K_FOR - 25)) | (1L << (K_FOREIGN - 25)) | (1L << (K_FROM - 25)) | (1L << (K_FULL - 25)) | (1L << (K_GLOB - 25)) | (1L << (K_GROUP - 25)) | (1L << (K_HAVING - 25)) | (1L << (K_IF - 25)) | (1L << (K_IGNORE - 25)) | (1L << (K_IMMEDIATE - 25)) | (1L << (K_IN - 25)) | (1L << (K_INDEX - 25)) | (1L << (K_INDEXED - 25)) | (1L << (K_INITIALLY - 25)) | (1L << (K_INNER - 25)))) != 0) || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (K_INSERT - 89)) | (1L << (K_INSTEAD - 89)) | (1L << (K_INTERSECT - 89)) | (1L << (K_INTO - 89)) | (1L << (K_IS - 89)) | (1L << (K_ISNULL - 89)) | (1L << (K_JOIN - 89)) | (1L << (K_KEY - 89)) | (1L << (K_LEFT - 89)) | (1L << (K_LIKE - 89)) | (1L << (K_LIMIT - 89)) | (1L << (K_MATCH - 89)) | (1L << (K_NATURAL - 89)) | (1L << (K_NO - 89)) | (1L << (K_NOT - 89)) | (1L << (K_NOTNULL - 89)) | (1L << (K_NULL - 89)) | (1L << (K_OF - 89)) | (1L << (K_OFFSET - 89)) | (1L << (K_ON - 89)) | (1L << (K_OR - 89)) | (1L << (K_ORDER - 89)) | (1L << (K_OUTER - 89)) | (1L << (K_PLAN - 89)) | (1L << (K_PRAGMA - 89)) | (1L << (K_PRIMARY - 89)) | (1L << (K_QUERY - 89)) | (1L << (K_RAISE - 89)) | (1L << (K_RECURSIVE - 89)) | (1L << (K_REFERENCES - 89)) | (1L << (K_REGEXP - 89)) | (1L << (K_REINDEX - 89)) | (1L << (K_RELEASE - 89)) | (1L << (K_RENAME - 89)) | (1L << (K_REPLACE - 89)) | (1L << (K_RESTRICT - 89)) | (1L << (K_RIGHT - 89)) | (1L << (K_ROLLBACK - 89)) | (1L << (K_ROW - 89)) | (1L << (K_SAVEPOINT - 89)) | (1L << (K_SELECT - 89)) | (1L << (K_SET - 89)) | (1L << (K_SHOW - 89)) | (1L << (K_TABLE - 89)) | (1L << (K_TEMP - 89)) | (1L << (K_TEMPORARY - 89)) | (1L << (K_THEN - 89)) | (1L << (K_TO - 89)) | (1L << (K_TRANSACTION - 89)) | (1L << (K_TRIGGER - 89)) | (1L << (K_UNION - 89)) | (1L << (K_UNIQUE - 89)) | (1L << (K_UPDATE - 89)) | (1L << (K_USE - 89)) | (1L << (K_USING - 89)) | (1L << (K_VACUUM - 89)) | (1L << (K_VALUES - 89)) | (1L << (K_VIEW - 89)) | (1L << (K_VIRTUAL - 89)) | (1L << (K_WHEN - 89)) | (1L << (K_WHERE - 89)) | (1L << (K_WITH - 89)) | (1L << (K_WITHOUT - 89)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1700);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitFunction_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitFunction_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1702);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Database_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Database_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterDatabase_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitDatabase_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitDatabase_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Database_nameContext database_name() throws RecognitionException {
		Database_nameContext _localctx = new Database_nameContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_database_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1704);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitTable_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitTable_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1706);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_or_index_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_or_index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_index_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterTable_or_index_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitTable_or_index_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitTable_or_index_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_or_index_nameContext table_or_index_name() throws RecognitionException {
		Table_or_index_nameContext _localctx = new Table_or_index_nameContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_table_or_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1708);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class New_table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public New_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterNew_table_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitNew_table_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitNew_table_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_table_nameContext new_table_name() throws RecognitionException {
		New_table_nameContext _localctx = new New_table_nameContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_new_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1710);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterColumn_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitColumn_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitColumn_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1712);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Collation_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Collation_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collation_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterCollation_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitCollation_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitCollation_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Collation_nameContext collation_name() throws RecognitionException {
		Collation_nameContext _localctx = new Collation_nameContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_collation_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1714);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Foreign_tableContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Foreign_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreign_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterForeign_table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitForeign_table(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitForeign_table(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Foreign_tableContext foreign_table() throws RecognitionException {
		Foreign_tableContext _localctx = new Foreign_tableContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_foreign_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1716);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterIndex_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitIndex_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitIndex_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Index_nameContext index_name() throws RecognitionException {
		Index_nameContext _localctx = new Index_nameContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1718);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Trigger_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Trigger_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterTrigger_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitTrigger_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitTrigger_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Trigger_nameContext trigger_name() throws RecognitionException {
		Trigger_nameContext _localctx = new Trigger_nameContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_trigger_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1720);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class View_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public View_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterView_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitView_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitView_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final View_nameContext view_name() throws RecognitionException {
		View_nameContext _localctx = new View_nameContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_view_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1722);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Module_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Module_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterModule_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitModule_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitModule_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Module_nameContext module_name() throws RecognitionException {
		Module_nameContext _localctx = new Module_nameContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_module_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1724);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pragma_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Pragma_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterPragma_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitPragma_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitPragma_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pragma_nameContext pragma_name() throws RecognitionException {
		Pragma_nameContext _localctx = new Pragma_nameContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_pragma_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1726);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Savepoint_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Savepoint_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_savepoint_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterSavepoint_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitSavepoint_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitSavepoint_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Savepoint_nameContext savepoint_name() throws RecognitionException {
		Savepoint_nameContext _localctx = new Savepoint_nameContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_savepoint_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1728);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_aliasContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterTable_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitTable_alias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitTable_alias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_aliasContext table_alias() throws RecognitionException {
		Table_aliasContext _localctx = new Table_aliasContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_table_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1730);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Transaction_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Transaction_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transaction_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterTransaction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitTransaction_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitTransaction_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Transaction_nameContext transaction_name() throws RecognitionException {
		Transaction_nameContext _localctx = new Transaction_nameContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_transaction_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1732);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Any_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SQLiteParser.IDENTIFIER, 0); }
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SQLiteParser.STRING_LITERAL, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLiteParser.OPEN_PAR, 0); }
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLiteParser.CLOSE_PAR, 0); }
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).enterAny_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLiteListener ) ((SQLiteListener)listener).exitAny_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLiteVisitor ) return ((SQLiteVisitor<? extends T>)visitor).visitAny_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Any_nameContext any_name() throws RecognitionException {
		Any_nameContext _localctx = new Any_nameContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_any_name);
		try {
			setState(1741);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1734);
				match(IDENTIFIER);
				}
				break;
			case K_ABORT:
			case K_ACTION:
			case K_ADD:
			case K_AFTER:
			case K_ALL:
			case K_ALTER:
			case K_ANALYZE:
			case K_AND:
			case K_AS:
			case K_ASC:
			case K_ATTACH:
			case K_AUTOINCREMENT:
			case K_BEFORE:
			case K_BEGIN:
			case K_BETWEEN:
			case K_BY:
			case K_CASCADE:
			case K_CASE:
			case K_CAST:
			case K_CHECK:
			case K_COLLATE:
			case K_COLUMN:
			case K_COMMIT:
			case K_CONFLICT:
			case K_CONSTRAINT:
			case K_CREATE:
			case K_CROSS:
			case K_CURRENT_DATE:
			case K_CURRENT_TIME:
			case K_CURRENT_TIMESTAMP:
			case K_DATABASE:
			case K_DEFAULT:
			case K_DEFERRABLE:
			case K_DEFERRED:
			case K_DELETE:
			case K_DESC:
			case K_DETACH:
			case K_DISTINCT:
			case K_DROP:
			case K_EACH:
			case K_ELSE:
			case K_END:
			case K_ESCAPE:
			case K_EXCEPT:
			case K_EXCLUSIVE:
			case K_EXISTS:
			case K_EXPLAIN:
			case K_FAIL:
			case K_FOR:
			case K_FOREIGN:
			case K_FROM:
			case K_FULL:
			case K_GLOB:
			case K_GROUP:
			case K_HAVING:
			case K_IF:
			case K_IGNORE:
			case K_IMMEDIATE:
			case K_IN:
			case K_INDEX:
			case K_INDEXED:
			case K_INITIALLY:
			case K_INNER:
			case K_INSERT:
			case K_INSTEAD:
			case K_INTERSECT:
			case K_INTO:
			case K_IS:
			case K_ISNULL:
			case K_JOIN:
			case K_KEY:
			case K_LEFT:
			case K_LIKE:
			case K_LIMIT:
			case K_MATCH:
			case K_NATURAL:
			case K_NO:
			case K_NOT:
			case K_NOTNULL:
			case K_NULL:
			case K_OF:
			case K_OFFSET:
			case K_ON:
			case K_OR:
			case K_ORDER:
			case K_OUTER:
			case K_PLAN:
			case K_PRAGMA:
			case K_PRIMARY:
			case K_QUERY:
			case K_RAISE:
			case K_RECURSIVE:
			case K_REFERENCES:
			case K_REGEXP:
			case K_REINDEX:
			case K_RELEASE:
			case K_RENAME:
			case K_REPLACE:
			case K_RESTRICT:
			case K_RIGHT:
			case K_ROLLBACK:
			case K_ROW:
			case K_SAVEPOINT:
			case K_SELECT:
			case K_SET:
			case K_SHOW:
			case K_TABLE:
			case K_TEMP:
			case K_TEMPORARY:
			case K_THEN:
			case K_TO:
			case K_TRANSACTION:
			case K_TRIGGER:
			case K_UNION:
			case K_UNIQUE:
			case K_UPDATE:
			case K_USE:
			case K_USING:
			case K_VACUUM:
			case K_VALUES:
			case K_VIEW:
			case K_VIRTUAL:
			case K_WHEN:
			case K_WHERE:
			case K_WITH:
			case K_WITHOUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1735);
				keyword();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1736);
				match(STRING_LITERAL);
				}
				break;
			case OPEN_PAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(1737);
				match(OPEN_PAR);
				setState(1738);
				any_name();
				setState(1739);
				match(CLOSE_PAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 46:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 20);
		case 1:
			return precpred(_ctx, 19);
		case 2:
			return precpred(_ctx, 18);
		case 3:
			return precpred(_ctx, 17);
		case 4:
			return precpred(_ctx, 16);
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 9);
		case 11:
			return precpred(_ctx, 8);
		case 12:
			return precpred(_ctx, 7);
		case 13:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00a2\u06d2\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\3\2\3\2\7\2\u00b9\n\2\f\2\16"+
		"\2\u00bc\13\2\3\2\3\2\3\3\3\3\3\3\3\4\7\4\u00c4\n\4\f\4\16\4\u00c7\13"+
		"\4\3\4\3\4\6\4\u00cb\n\4\r\4\16\4\u00cc\3\4\7\4\u00d0\n\4\f\4\16\4\u00d3"+
		"\13\4\3\4\7\4\u00d6\n\4\f\4\16\4\u00d9\13\4\3\5\3\5\3\5\5\5\u00de\n\5"+
		"\5\5\u00e0\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5\u0105\n\5\3\6\3\6\3\6\3\6\3\6\5\6\u010c\n\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6\u0114\n\6\3\6\5\6\u0117\n\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u0120\n\7\3\b\3\b\5\b\u0124\n\b\3\b\3\b\3\b\3\b\3\t\3\t\5\t"+
		"\u012c\n\t\3\t\3\t\5\t\u0130\n\t\5\t\u0132\n\t\3\n\3\n\3\n\5\n\u0137\n"+
		"\n\5\n\u0139\n\n\3\13\3\13\5\13\u013d\n\13\3\13\3\13\3\13\7\13\u0142\n"+
		"\13\f\13\16\13\u0145\13\13\5\13\u0147\n\13\3\13\3\13\3\13\5\13\u014c\n"+
		"\13\3\13\3\13\5\13\u0150\n\13\3\13\6\13\u0153\n\13\r\13\16\13\u0154\3"+
		"\13\3\13\3\13\3\13\3\13\7\13\u015c\n\13\f\13\16\13\u015f\13\13\5\13\u0161"+
		"\n\13\3\13\3\13\3\13\3\13\5\13\u0167\n\13\5\13\u0169\n\13\3\f\3\f\5\f"+
		"\u016d\n\f\3\f\3\f\3\f\3\f\5\f\u0173\n\f\3\f\3\f\3\f\5\f\u0178\n\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0181\n\f\f\f\16\f\u0184\13\f\3\f\3\f\5\f"+
		"\u0188\n\f\3\r\3\r\5\r\u018c\n\r\3\r\3\r\3\r\3\r\5\r\u0192\n\r\3\r\3\r"+
		"\3\r\5\r\u0197\n\r\3\r\3\r\3\r\3\r\3\r\7\r\u019e\n\r\f\r\16\r\u01a1\13"+
		"\r\3\r\3\r\7\r\u01a5\n\r\f\r\16\r\u01a8\13\r\3\r\3\r\3\r\5\r\u01ad\n\r"+
		"\3\r\3\r\5\r\u01b1\n\r\3\16\3\16\3\16\3\16\3\17\3\17\5\17\u01b9\n\17\3"+
		"\17\3\17\3\17\3\17\5\17\u01bf\n\17\3\17\3\17\3\17\5\17\u01c4\n\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u01cb\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\7\17\u01d4\n\17\f\17\16\17\u01d7\13\17\5\17\u01d9\n\17\5\17\u01db\n\17"+
		"\3\17\3\17\3\17\3\17\5\17\u01e1\n\17\3\17\3\17\3\17\3\17\5\17\u01e7\n"+
		"\17\3\17\3\17\5\17\u01eb\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u01f2\n\17"+
		"\3\17\3\17\6\17\u01f6\n\17\r\17\16\17\u01f7\3\17\3\17\3\20\3\20\5\20\u01fe"+
		"\n\20\3\20\3\20\3\20\3\20\5\20\u0204\n\20\3\20\3\20\3\20\5\20\u0209\n"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0215\n\21"+
		"\3\21\3\21\3\21\5\21\u021a\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21"+
		"\u0223\n\21\f\21\16\21\u0226\13\21\3\21\3\21\5\21\u022a\n\21\3\22\5\22"+
		"\u022d\n\22\3\22\3\22\3\22\3\22\5\22\u0233\n\22\3\23\5\23\u0236\n\23\3"+
		"\23\3\23\3\23\3\23\5\23\u023c\n\23\3\23\3\23\3\23\3\23\3\23\7\23\u0243"+
		"\n\23\f\23\16\23\u0246\13\23\5\23\u0248\n\23\3\23\3\23\3\23\3\23\5\23"+
		"\u024e\n\23\5\23\u0250\n\23\3\24\3\24\5\24\u0254\n\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\5\25\u025c\n\25\3\25\3\25\3\25\5\25\u0261\n\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\5\26\u0269\n\26\3\26\3\26\3\26\5\26\u026e\n\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\5\30\u027a\n\30\3\30"+
		"\3\30\3\30\5\30\u027f\n\30\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u0287\n"+
		"\31\3\31\3\31\3\31\5\31\u028c\n\31\3\31\3\31\3\32\3\32\5\32\u0292\n\32"+
		"\3\32\3\32\3\32\7\32\u0297\n\32\f\32\16\32\u029a\13\32\5\32\u029c\n\32"+
		"\3\32\3\32\3\32\3\32\7\32\u02a2\n\32\f\32\16\32\u02a5\13\32\3\32\3\32"+
		"\3\32\3\32\3\32\7\32\u02ac\n\32\f\32\16\32\u02af\13\32\5\32\u02b1\n\32"+
		"\3\32\3\32\3\32\3\32\5\32\u02b7\n\32\5\32\u02b9\n\32\3\33\5\33\u02bc\n"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\5\33\u02cf\n\33\3\33\3\33\3\33\3\33\5\33\u02d5\n\33"+
		"\3\33\3\33\3\33\3\33\3\33\7\33\u02dc\n\33\f\33\16\33\u02df\13\33\3\33"+
		"\3\33\5\33\u02e3\n\33\3\33\3\33\3\33\3\33\7\33\u02e9\n\33\f\33\16\33\u02ec"+
		"\13\33\3\33\3\33\3\33\5\33\u02f1\n\33\3\34\3\34\3\34\3\34\7\34\u02f7\n"+
		"\34\f\34\16\34\u02fa\13\34\3\34\3\34\3\35\3\35\3\35\3\35\5\35\u0302\n"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u030b\n\35\3\36\3\36\3\36"+
		"\3\36\3\36\5\36\u0312\n\36\3\36\3\36\5\36\u0316\n\36\5\36\u0318\n\36\3"+
		"\37\3\37\5\37\u031c\n\37\3\37\3\37\3 \3 \3 \5 \u0323\n \5 \u0325\n \3"+
		" \3 \5 \u0329\n \3 \5 \u032c\n \3!\3!\3!\3\"\3\"\5\"\u0333\n\"\3\"\3\""+
		"\3\"\7\"\u0338\n\"\f\"\16\"\u033b\13\"\5\"\u033d\n\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\7\"\u0345\n\"\f\"\16\"\u0348\13\"\5\"\u034a\n\"\3\"\3\"\3\"\3\""+
		"\5\"\u0350\n\"\5\"\u0352\n\"\3#\3#\5#\u0356\n#\3#\3#\3#\7#\u035b\n#\f"+
		"#\16#\u035e\13#\5#\u0360\n#\3#\3#\3#\3#\7#\u0366\n#\f#\16#\u0369\13#\3"+
		"#\3#\3#\3#\3#\7#\u0370\n#\f#\16#\u0373\13#\5#\u0375\n#\3#\3#\3#\3#\5#"+
		"\u037b\n#\5#\u037d\n#\3$\3$\5$\u0381\n$\3$\3$\3$\7$\u0386\n$\f$\16$\u0389"+
		"\13$\3$\3$\5$\u038d\n$\3$\5$\u0390\n$\3$\3$\3$\3$\3$\7$\u0397\n$\f$\16"+
		"$\u039a\13$\3$\3$\5$\u039e\n$\5$\u03a0\n$\3$\3$\3$\3$\3$\7$\u03a7\n$\f"+
		"$\16$\u03aa\13$\3$\3$\3$\3$\3$\3$\7$\u03b2\n$\f$\16$\u03b5\13$\3$\3$\7"+
		"$\u03b9\n$\f$\16$\u03bc\13$\5$\u03be\n$\3%\3%\3%\3%\3%\5%\u03c5\n%\3&"+
		"\3&\3&\3&\3&\5&\u03cc\n&\3&\3&\3\'\3\'\3\'\3\'\3(\5(\u03d5\n(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u03e2\n(\3(\3(\3(\3(\3(\7(\u03e9\n(\f(\16"+
		"(\u03ec\13(\3(\5(\u03ef\n(\3)\5)\u03f2\n)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\5)\u03ff\n)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\7)\u040b\n)\f)\16)\u040e"+
		"\13)\3)\5)\u0411\n)\3)\3)\3)\3)\3)\7)\u0418\n)\f)\16)\u041b\13)\5)\u041d"+
		"\n)\3)\3)\3)\3)\5)\u0423\n)\5)\u0425\n)\3*\3*\3*\3*\3+\3+\3,\3,\5,\u042f"+
		"\n,\3,\7,\u0432\n,\f,\16,\u0435\13,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\5"+
		"-\u0442\n-\3.\3.\5.\u0446\n.\3.\3.\3.\5.\u044b\n.\3.\3.\5.\u044f\n.\3"+
		".\5.\u0452\n.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u0464"+
		"\n.\3.\3.\3.\5.\u0469\n.\3/\3/\3/\5/\u046e\n/\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\5\60\u0476\n\60\3\60\3\60\3\60\5\60\u047b\n\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\5\60\u0484\n\60\3\60\3\60\3\60\7\60\u0489\n\60\f\60"+
		"\16\60\u048c\13\60\3\60\5\60\u048f\n\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u049f\n\60\3\60\5\60\u04a2"+
		"\n\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u04aa\n\60\3\60\3\60\3\60\3\60"+
		"\3\60\6\60\u04b1\n\60\r\60\16\60\u04b2\3\60\3\60\5\60\u04b7\n\60\3\60"+
		"\3\60\3\60\5\60\u04bc\n\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\5\60\u04da\n\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\5\60\u04e6\n\60\3\60\3\60\3\60\5\60\u04eb\n\60\3"+
		"\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u04f7\n\60\3\60"+
		"\3\60\3\60\3\60\5\60\u04fd\n\60\3\60\3\60\3\60\3\60\3\60\5\60\u0504\n"+
		"\60\3\60\3\60\5\60\u0508\n\60\3\60\3\60\3\60\3\60\3\60\3\60\7\60\u0510"+
		"\n\60\f\60\16\60\u0513\13\60\5\60\u0515\n\60\3\60\3\60\3\60\3\60\5\60"+
		"\u051b\n\60\3\60\5\60\u051e\n\60\7\60\u0520\n\60\f\60\16\60\u0523\13\60"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u052b\n\61\f\61\16\61\u052e\13\61"+
		"\3\61\3\61\5\61\u0532\n\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\5\61\u053e\n\61\3\61\3\61\5\61\u0542\n\61\7\61\u0544\n\61\f\61\16"+
		"\61\u0547\13\61\3\61\5\61\u054a\n\61\3\61\3\61\3\61\3\61\3\61\5\61\u0551"+
		"\n\61\5\61\u0553\n\61\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u055b\n\62\3"+
		"\62\3\62\3\63\3\63\3\63\5\63\u0562\n\63\3\63\5\63\u0565\n\63\3\64\3\64"+
		"\5\64\u0569\n\64\3\64\3\64\3\64\5\64\u056e\n\64\3\64\3\64\3\64\3\64\7"+
		"\64\u0574\n\64\f\64\16\64\u0577\13\64\3\64\3\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\7\64\u0587\n\64\f\64\16\64\u058a"+
		"\13\64\3\64\3\64\3\64\5\64\u058f\n\64\3\65\3\65\5\65\u0593\n\65\3\65\3"+
		"\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\7\65\u05a1\n\65"+
		"\f\65\16\65\u05a4\13\65\3\66\3\66\3\66\5\66\u05a9\n\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\5\66\u05b1\n\66\3\67\3\67\3\67\5\67\u05b6\n\67\3\67\5"+
		"\67\u05b9\n\67\38\38\38\58\u05be\n8\39\39\39\39\39\79\u05c5\n9\f9\169"+
		"\u05c8\139\39\39\59\u05cc\n9\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\5:\u05da"+
		"\n:\3:\5:\u05dd\n:\5:\u05df\n:\3;\3;\3;\5;\u05e4\n;\3;\3;\5;\u05e8\n;"+
		"\3;\5;\u05eb\n;\3;\3;\3;\3;\3;\5;\u05f2\n;\3;\3;\3;\3;\7;\u05f8\n;\f;"+
		"\16;\u05fb\13;\3;\5;\u05fe\n;\3;\3;\5;\u0602\n;\3;\5;\u0605\n;\3;\3;\3"+
		";\3;\5;\u060b\n;\3;\5;\u060e\n;\5;\u0610\n;\3<\3<\3<\3<\3<\7<\u0617\n"+
		"<\f<\16<\u061a\13<\3=\3=\5=\u061e\n=\3=\3=\5=\u0622\n=\3=\3=\5=\u0626"+
		"\n=\3=\5=\u0629\n=\3>\3>\3>\3>\3>\3>\3>\7>\u0632\n>\f>\16>\u0635\13>\3"+
		">\3>\5>\u0639\n>\3?\3?\3?\3@\3@\5@\u0640\n@\3@\3@\3@\7@\u0645\n@\f@\16"+
		"@\u0648\13@\3@\3@\5@\u064c\n@\3@\5@\u064f\n@\3@\3@\3@\3@\3@\7@\u0656\n"+
		"@\f@\16@\u0659\13@\3@\3@\5@\u065d\n@\5@\u065f\n@\3@\3@\3@\3@\3@\7@\u0666"+
		"\n@\f@\16@\u0669\13@\3@\3@\3@\3@\3@\3@\7@\u0671\n@\f@\16@\u0674\13@\3"+
		"@\3@\7@\u0678\n@\f@\16@\u067b\13@\5@\u067d\n@\3A\3A\3A\3A\3A\5A\u0684"+
		"\nA\3B\3B\3B\3B\3B\7B\u068b\nB\fB\16B\u068e\13B\3B\3B\5B\u0692\nB\3C\5"+
		"C\u0695\nC\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\5G\u06a1\nG\3H\3H\3I\3I\3J\3"+
		"J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3"+
		"V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3[\3[\3[\3[\3[\5[\u06d0\n[\3[\2\3^"+
		"\\\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD"+
		"FHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c"+
		"\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4"+
		"\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\2\24\5\2==HHUU\4\2\61"+
		"\61EE\4\2\7\7mm\3\2\u0087\u0088\4\2\37\37AA\4\2$$??\7\2\33\33KKTT}}\u0080"+
		"\u0080\4\2\t\t\16\17\3\2\n\13\3\2\20\23\3\2\24\27\6\2PPddffyy\4\2>>\u008f"+
		"\u008f\5\2\33\33KK\u0080\u0080\6\2\668kk\u009b\u009b\u009d\u009e\4\2\n"+
		"\fii\4\2\u009a\u009a\u009d\u009d\4\2\339;\u0099\2\u07d8\2\u00ba\3\2\2"+
		"\2\4\u00bf\3\2\2\2\6\u00c5\3\2\2\2\b\u00df\3\2\2\2\n\u0106\3\2\2\2\f\u0118"+
		"\3\2\2\2\16\u0121\3\2\2\2\20\u0129\3\2\2\2\22\u0133\3\2\2\2\24\u0146\3"+
		"\2\2\2\26\u016a\3\2\2\2\30\u0189\3\2\2\2\32\u01b2\3\2\2\2\34\u01b6\3\2"+
		"\2\2\36\u01fb\3\2\2\2 \u020e\3\2\2\2\"\u022c\3\2\2\2$\u0235\3\2\2\2&\u0251"+
		"\3\2\2\2(\u0257\3\2\2\2*\u0264\3\2\2\2,\u0271\3\2\2\2.\u0275\3\2\2\2\60"+
		"\u0282\3\2\2\2\62\u029b\3\2\2\2\64\u02bb\3\2\2\2\66\u02f2\3\2\2\28\u02fd"+
		"\3\2\2\2:\u030c\3\2\2\2<\u0319\3\2\2\2>\u031f\3\2\2\2@\u032d\3\2\2\2B"+
		"\u033c\3\2\2\2D\u035f\3\2\2\2F\u03bd\3\2\2\2H\u03c4\3\2\2\2J\u03c6\3\2"+
		"\2\2L\u03cf\3\2\2\2N\u03d4\3\2\2\2P\u03f1\3\2\2\2R\u0426\3\2\2\2T\u042a"+
		"\3\2\2\2V\u042c\3\2\2\2X\u0436\3\2\2\2Z\u0445\3\2\2\2\\\u046d\3\2\2\2"+
		"^\u04bb\3\2\2\2`\u0524\3\2\2\2b\u0554\3\2\2\2d\u055e\3\2\2\2f\u0568\3"+
		"\2\2\2h\u0590\3\2\2\2j\u05a8\3\2\2\2l\u05b2\3\2\2\2n\u05bd\3\2\2\2p\u05bf"+
		"\3\2\2\2r\u05de\3\2\2\2t\u060f\3\2\2\2v\u0611\3\2\2\2x\u0628\3\2\2\2z"+
		"\u0638\3\2\2\2|\u063a\3\2\2\2~\u067c\3\2\2\2\u0080\u0683\3\2\2\2\u0082"+
		"\u0685\3\2\2\2\u0084\u0694\3\2\2\2\u0086\u0698\3\2\2\2\u0088\u069a\3\2"+
		"\2\2\u008a\u069c\3\2\2\2\u008c\u06a0\3\2\2\2\u008e\u06a2\3\2\2\2\u0090"+
		"\u06a4\3\2\2\2\u0092\u06a6\3\2\2\2\u0094\u06a8\3\2\2\2\u0096\u06aa\3\2"+
		"\2\2\u0098\u06ac\3\2\2\2\u009a\u06ae\3\2\2\2\u009c\u06b0\3\2\2\2\u009e"+
		"\u06b2\3\2\2\2\u00a0\u06b4\3\2\2\2\u00a2\u06b6\3\2\2\2\u00a4\u06b8\3\2"+
		"\2\2\u00a6\u06ba\3\2\2\2\u00a8\u06bc\3\2\2\2\u00aa\u06be\3\2\2\2\u00ac"+
		"\u06c0\3\2\2\2\u00ae\u06c2\3\2\2\2\u00b0\u06c4\3\2\2\2\u00b2\u06c6\3\2"+
		"\2\2\u00b4\u06cf\3\2\2\2\u00b6\u00b9\5\6\4\2\u00b7\u00b9\5\4\3\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd"+
		"\u00be\7\2\2\3\u00be\3\3\2\2\2\u00bf\u00c0\7\u00a2\2\2\u00c0\u00c1\b\3"+
		"\1\2\u00c1\5\3\2\2\2\u00c2\u00c4\7\3\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7"+
		"\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00d1\5\b\5\2\u00c9\u00cb\7\3\2\2\u00ca\u00c9\3\2"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\u00d0\5\b\5\2\u00cf\u00ca\3\2\2\2\u00d0\u00d3\3\2"+
		"\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d7\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d4\u00d6\7\3\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2"+
		"\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\7\3\2\2\2\u00d9\u00d7"+
		"\3\2\2\2\u00da\u00dd\7J\2\2\u00db\u00dc\7u\2\2\u00dc\u00de\7r\2\2\u00dd"+
		"\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00da\3\2"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0\u0104\3\2\2\2\u00e1\u0105\5\n\6\2\u00e2"+
		"\u0105\5\f\7\2\u00e3\u0105\5\16\b\2\u00e4\u0105\5\20\t\2\u00e5\u0105\5"+
		"\22\n\2\u00e6\u0105\5\24\13\2\u00e7\u0105\5\26\f\2\u00e8\u0105\5\30\r"+
		"\2\u00e9\u0105\5\32\16\2\u00ea\u0105\5\34\17\2\u00eb\u0105\5\36\20\2\u00ec"+
		"\u0105\5 \21\2\u00ed\u0105\5\"\22\2\u00ee\u0105\5$\23\2\u00ef\u0105\5"+
		"&\24\2\u00f0\u0105\5(\25\2\u00f1\u0105\5*\26\2\u00f2\u0105\5,\27\2\u00f3"+
		"\u0105\5.\30\2\u00f4\u0105\5\60\31\2\u00f5\u0105\5\62\32\2\u00f6\u0105"+
		"\5\64\33\2\u00f7\u0105\58\35\2\u00f8\u0105\5:\36\2\u00f9\u0105\5<\37\2"+
		"\u00fa\u0105\5> \2\u00fb\u0105\5@!\2\u00fc\u0105\5B\"\2\u00fd\u0105\5"+
		"D#\2\u00fe\u0105\5H%\2\u00ff\u0105\5J&\2\u0100\u0105\5N(\2\u0101\u0105"+
		"\5P)\2\u0102\u0105\5R*\2\u0103\u0105\5T+\2\u0104\u00e1\3\2\2\2\u0104\u00e2"+
		"\3\2\2\2\u0104\u00e3\3\2\2\2\u0104\u00e4\3\2\2\2\u0104\u00e5\3\2\2\2\u0104"+
		"\u00e6\3\2\2\2\u0104\u00e7\3\2\2\2\u0104\u00e8\3\2\2\2\u0104\u00e9\3\2"+
		"\2\2\u0104\u00ea\3\2\2\2\u0104\u00eb\3\2\2\2\u0104\u00ec\3\2\2\2\u0104"+
		"\u00ed\3\2\2\2\u0104\u00ee\3\2\2\2\u0104\u00ef\3\2\2\2\u0104\u00f0\3\2"+
		"\2\2\u0104\u00f1\3\2\2\2\u0104\u00f2\3\2\2\2\u0104\u00f3\3\2\2\2\u0104"+
		"\u00f4\3\2\2\2\u0104\u00f5\3\2\2\2\u0104\u00f6\3\2\2\2\u0104\u00f7\3\2"+
		"\2\2\u0104\u00f8\3\2\2\2\u0104\u00f9\3\2\2\2\u0104\u00fa\3\2\2\2\u0104"+
		"\u00fb\3\2\2\2\u0104\u00fc\3\2\2\2\u0104\u00fd\3\2\2\2\u0104\u00fe\3\2"+
		"\2\2\u0104\u00ff\3\2\2\2\u0104\u0100\3\2\2\2\u0104\u0101\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0104\u0103\3\2\2\2\u0105\t\3\2\2\2\u0106\u0107\7 \2\2"+
		"\u0107\u010b\7\u0086\2\2\u0108\u0109\5\u0096L\2\u0109\u010a\7\4\2\2\u010a"+
		"\u010c\3\2\2\2\u010b\u0108\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2"+
		"\2\2\u010d\u0116\5\u0098M\2\u010e\u010f\7|\2\2\u010f\u0110\7\u008a\2\2"+
		"\u0110\u0117\5\u009cO\2\u0111\u0113\7\35\2\2\u0112\u0114\7\60\2\2\u0113"+
		"\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117\5V"+
		",\2\u0116\u010e\3\2\2\2\u0116\u0111\3\2\2\2\u0117\13\3\2\2\2\u0118\u011f"+
		"\7!\2\2\u0119\u0120\5\u0096L\2\u011a\u0120\5\u009aN\2\u011b\u011c\5\u0096"+
		"L\2\u011c\u011d\7\4\2\2\u011d\u011e\5\u009aN\2\u011e\u0120\3\2\2\2\u011f"+
		"\u0119\3\2\2\2\u011f\u011a\3\2\2\2\u011f\u011b\3\2\2\2\u011f\u0120\3\2"+
		"\2\2\u0120\r\3\2\2\2\u0121\u0123\7%\2\2\u0122\u0124\79\2\2\u0123\u0122"+
		"\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\5^\60\2\u0126"+
		"\u0127\7#\2\2\u0127\u0128\5\u0096L\2\u0128\17\3\2\2\2\u0129\u012b\7(\2"+
		"\2\u012a\u012c\t\2\2\2\u012b\u012a\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u0131"+
		"\3\2\2\2\u012d\u012f\7\u008b\2\2\u012e\u0130\5\u00b2Z\2\u012f\u012e\3"+
		"\2\2\2\u012f\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012d\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\21\3\2\2\2\u0133\u0138\t\3\2\2\u0134\u0136\7\u008b"+
		"\2\2\u0135\u0137\5\u00b2Z\2\u0136\u0135\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		"\u0139\3\2\2\2\u0138\u0134\3\2\2\2\u0138\u0139\3\2\2\2\u0139\23\3\2\2"+
		"\2\u013a\u013c\7\u0098\2\2\u013b\u013d\7w\2\2\u013c\u013b\3\2\2\2\u013c"+
		"\u013d\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0143\5p9\2\u013f\u0140\7\7\2"+
		"\2\u0140\u0142\5p9\2\u0141\u013f\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141"+
		"\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0146"+
		"\u013a\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0152\5~"+
		"@\2\u0149\u014b\7\u008d\2\2\u014a\u014c\7\37\2\2\u014b\u014a\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u0150\3\2\2\2\u014d\u0150\7]\2\2\u014e\u0150\7G\2"+
		"\2\u014f\u0149\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u014e\3\2\2\2\u0150\u0151"+
		"\3\2\2\2\u0151\u0153\5~@\2\u0152\u014f\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0160\3\2\2\2\u0156\u0157\7p"+
		"\2\2\u0157\u0158\7*\2\2\u0158\u015d\5l\67\2\u0159\u015a\7\7\2\2\u015a"+
		"\u015c\5l\67\2\u015b\u0159\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2"+
		"\2\2\u015d\u015e\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u0160"+
		"\u0156\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0168\3\2\2\2\u0162\u0163\7e"+
		"\2\2\u0163\u0166\5^\60\2\u0164\u0165\t\4\2\2\u0165\u0167\5^\60\2\u0166"+
		"\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0169\3\2\2\2\u0168\u0162\3\2"+
		"\2\2\u0168\u0169\3\2\2\2\u0169\25\3\2\2\2\u016a\u016c\7\64\2\2\u016b\u016d"+
		"\7\u008e\2\2\u016c\u016b\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\3\2\2"+
		"\2\u016e\u0172\7W\2\2\u016f\u0170\7S\2\2\u0170\u0171\7i\2\2\u0171\u0173"+
		"\7I\2\2\u0172\u016f\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0177\3\2\2\2\u0174"+
		"\u0175\5\u0096L\2\u0175\u0176\7\4\2\2\u0176\u0178\3\2\2\2\u0177\u0174"+
		"\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\5\u00a4S"+
		"\2\u017a\u017b\7n\2\2\u017b\u017c\5\u0098M\2\u017c\u017d\7\5\2\2\u017d"+
		"\u0182\5d\63\2\u017e\u017f\7\7\2\2\u017f\u0181\5d\63\2\u0180\u017e\3\2"+
		"\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183"+
		"\u0185\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u0187\7\6\2\2\u0186\u0188\5|"+
		"?\2\u0187\u0186\3\2\2\2\u0187\u0188\3\2\2\2\u0188\27\3\2\2\2\u0189\u018b"+
		"\7\64\2\2\u018a\u018c\t\5\2\2\u018b\u018a\3\2\2\2\u018b\u018c\3\2\2\2"+
		"\u018c\u018d\3\2\2\2\u018d\u0191\7\u0086\2\2\u018e\u018f\7S\2\2\u018f"+
		"\u0190\7i\2\2\u0190\u0192\7I\2\2\u0191\u018e\3\2\2\2\u0191\u0192\3\2\2"+
		"\2\u0192\u0196\3\2\2\2\u0193\u0194\5\u0096L\2\u0194\u0195\7\4\2\2\u0195"+
		"\u0197\3\2\2\2\u0196\u0193\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198\3\2"+
		"\2\2\u0198\u01b0\5\u0098M\2\u0199\u019a\7\5\2\2\u019a\u019f\5V,\2\u019b"+
		"\u019c\7\7\2\2\u019c\u019e\5V,\2\u019d\u019b\3\2\2\2\u019e\u01a1\3\2\2"+
		"\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a6\3\2\2\2\u01a1\u019f"+
		"\3\2\2\2\u01a2\u01a3\7\7\2\2\u01a3\u01a5\5f\64\2\u01a4\u01a2\3\2\2\2\u01a5"+
		"\u01a8\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a9\3\2"+
		"\2\2\u01a8\u01a6\3\2\2\2\u01a9\u01ac\7\6\2\2\u01aa\u01ab\7\u0099\2\2\u01ab"+
		"\u01ad\7\u009a\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01b1"+
		"\3\2\2\2\u01ae\u01af\7#\2\2\u01af\u01b1\5D#\2\u01b0\u0199\3\2\2\2\u01b0"+
		"\u01ae\3\2\2\2\u01b1\31\3\2\2\2\u01b2\u01b3\7\64\2\2\u01b3\u01b4\79\2"+
		"\2\u01b4\u01b5\5\u0096L\2\u01b5\33\3\2\2\2\u01b6\u01b8\7\64\2\2\u01b7"+
		"\u01b9\t\5\2\2\u01b8\u01b7\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\3\2"+
		"\2\2\u01ba\u01be\7\u008c\2\2\u01bb\u01bc\7S\2\2\u01bc\u01bd\7i\2\2\u01bd"+
		"\u01bf\7I\2\2\u01be\u01bb\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c3\3\2"+
		"\2\2\u01c0\u01c1\5\u0096L\2\u01c1\u01c2\7\4\2\2\u01c2\u01c4\3\2\2\2\u01c3"+
		"\u01c0\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01ca\5\u00a6"+
		"T\2\u01c6\u01cb\7\'\2\2\u01c7\u01cb\7\36\2\2\u01c8\u01c9\7\\\2\2\u01c9"+
		"\u01cb\7l\2\2\u01ca\u01c6\3\2\2\2\u01ca\u01c7\3\2\2\2\u01ca\u01c8\3\2"+
		"\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01da\3\2\2\2\u01cc\u01db\7>\2\2\u01cd"+
		"\u01db\7[\2\2\u01ce\u01d8\7\u008f\2\2\u01cf\u01d0\7l\2\2\u01d0\u01d5\5"+
		"\u009eP\2\u01d1\u01d2\7\7\2\2\u01d2\u01d4\5\u009eP\2\u01d3\u01d1\3\2\2"+
		"\2\u01d4\u01d7\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d9"+
		"\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01cf\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01db\3\2\2\2\u01da\u01cc\3\2\2\2\u01da\u01cd\3\2\2\2\u01da\u01ce\3\2"+
		"\2\2\u01db\u01dc\3\2\2\2\u01dc\u01e0\7n\2\2\u01dd\u01de\5\u0096L\2\u01de"+
		"\u01df\7\4\2\2\u01df\u01e1\3\2\2\2\u01e0\u01dd\3\2\2\2\u01e0\u01e1\3\2"+
		"\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e6\5\u0098M\2\u01e3\u01e4\7L\2\2\u01e4"+
		"\u01e5\7C\2\2\u01e5\u01e7\7\u0081\2\2\u01e6\u01e3\3\2\2\2\u01e6\u01e7"+
		"\3\2\2\2\u01e7\u01ea\3\2\2\2\u01e8\u01e9\7\u0096\2\2\u01e9\u01eb\5^\60"+
		"\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01f5"+
		"\7(\2\2\u01ed\u01f2\5N(\2\u01ee\u01f2\5\64\33\2\u01ef\u01f2\5\"\22\2\u01f0"+
		"\u01f2\5D#\2\u01f1\u01ed\3\2\2\2\u01f1\u01ee\3\2\2\2\u01f1\u01ef\3\2\2"+
		"\2\u01f1\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\7\3\2\2\u01f4\u01f6"+
		"\3\2\2\2\u01f5\u01f1\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7"+
		"\u01f8\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fa\7E\2\2\u01fa\35\3\2\2\2"+
		"\u01fb\u01fd\7\64\2\2\u01fc\u01fe\t\5\2\2\u01fd\u01fc\3\2\2\2\u01fd\u01fe"+
		"\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0203\7\u0094\2\2\u0200\u0201\7S\2"+
		"\2\u0201\u0202\7i\2\2\u0202\u0204\7I\2\2\u0203\u0200\3\2\2\2\u0203\u0204"+
		"\3\2\2\2\u0204\u0208\3\2\2\2\u0205\u0206\5\u0096L\2\u0206\u0207\7\4\2"+
		"\2\u0207\u0209\3\2\2\2\u0208\u0205\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020a"+
		"\3\2\2\2\u020a\u020b\5\u00a8U\2\u020b\u020c\7#\2\2\u020c\u020d\5D#\2\u020d"+
		"\37\3\2\2\2\u020e\u020f\7\64\2\2\u020f\u0210\7\u0095\2\2\u0210\u0214\7"+
		"\u0086\2\2\u0211\u0212\7S\2\2\u0212\u0213\7i\2\2\u0213\u0215\7I\2\2\u0214"+
		"\u0211\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0219\3\2\2\2\u0216\u0217\5\u0096"+
		"L\2\u0217\u0218\7\4\2\2\u0218\u021a\3\2\2\2\u0219\u0216\3\2\2\2\u0219"+
		"\u021a\3\2\2\2\u021a\u021b\3\2\2\2\u021b\u021c\5\u0098M\2\u021c\u021d"+
		"\7\u0091\2\2\u021d\u0229\5\u00aaV\2\u021e\u021f\7\5\2\2\u021f\u0224\5"+
		"\u008cG\2\u0220\u0221\7\7\2\2\u0221\u0223\5\u008cG\2\u0222\u0220\3\2\2"+
		"\2\u0223\u0226\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0227"+
		"\3\2\2\2\u0226\u0224\3\2\2\2\u0227\u0228\7\6\2\2\u0228\u022a\3\2\2\2\u0229"+
		"\u021e\3\2\2\2\u0229\u022a\3\2\2\2\u022a!\3\2\2\2\u022b\u022d\5h\65\2"+
		"\u022c\u022b\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022f"+
		"\7>\2\2\u022f\u0230\7N\2\2\u0230\u0232\5j\66\2\u0231\u0233\5|?\2\u0232"+
		"\u0231\3\2\2\2\u0232\u0233\3\2\2\2\u0233#\3\2\2\2\u0234\u0236\5h\65\2"+
		"\u0235\u0234\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u0238"+
		"\7>\2\2\u0238\u0239\7N\2\2\u0239\u023b\5j\66\2\u023a\u023c\5|?\2\u023b"+
		"\u023a\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u024f\3\2\2\2\u023d\u023e\7p"+
		"\2\2\u023e\u023f\7*\2\2\u023f\u0244\5l\67\2\u0240\u0241\7\7\2\2\u0241"+
		"\u0243\5l\67\2\u0242\u0240\3\2\2\2\u0243\u0246\3\2\2\2\u0244\u0242\3\2"+
		"\2\2\u0244\u0245\3\2\2\2\u0245\u0248\3\2\2\2\u0246\u0244\3\2\2\2\u0247"+
		"\u023d\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024a\7e"+
		"\2\2\u024a\u024d\5^\60\2\u024b\u024c\t\4\2\2\u024c\u024e\5^\60\2\u024d"+
		"\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u0250\3\2\2\2\u024f\u0247\3\2"+
		"\2\2\u024f\u0250\3\2\2\2\u0250%\3\2\2\2\u0251\u0253\7@\2\2\u0252\u0254"+
		"\79\2\2\u0253\u0252\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0255\3\2\2\2\u0255"+
		"\u0256\5\u0096L\2\u0256\'\3\2\2\2\u0257\u0258\7B\2\2\u0258\u025b\7W\2"+
		"\2\u0259\u025a\7S\2\2\u025a\u025c\7I\2\2\u025b\u0259\3\2\2\2\u025b\u025c"+
		"\3\2\2\2\u025c\u0260\3\2\2\2\u025d\u025e\5\u0096L\2\u025e\u025f\7\4\2"+
		"\2\u025f\u0261\3\2\2\2\u0260\u025d\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0262"+
		"\3\2\2\2\u0262\u0263\5\u00a4S\2\u0263)\3\2\2\2\u0264\u0265\7B\2\2\u0265"+
		"\u0268\7\u0086\2\2\u0266\u0267\7S\2\2\u0267\u0269\7I\2\2\u0268\u0266\3"+
		"\2\2\2\u0268\u0269\3\2\2\2\u0269\u026d\3\2\2\2\u026a\u026b\5\u0096L\2"+
		"\u026b\u026c\7\4\2\2\u026c\u026e\3\2\2\2\u026d\u026a\3\2\2\2\u026d\u026e"+
		"\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0270\5\u0098M\2\u0270+\3\2\2\2\u0271"+
		"\u0272\7B\2\2\u0272\u0273\79\2\2\u0273\u0274\5\u0096L\2\u0274-\3\2\2\2"+
		"\u0275\u0276\7B\2\2\u0276\u0279\7\u008c\2\2\u0277\u0278\7S\2\2\u0278\u027a"+
		"\7I\2\2\u0279\u0277\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027e\3\2\2\2\u027b"+
		"\u027c\5\u0096L\2\u027c\u027d\7\4\2\2\u027d\u027f\3\2\2\2\u027e\u027b"+
		"\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u0281\5\u00a6T"+
		"\2\u0281/\3\2\2\2\u0282\u0283\7B\2\2\u0283\u0286\7\u0094\2\2\u0284\u0285"+
		"\7S\2\2\u0285\u0287\7I\2\2\u0286\u0284\3\2\2\2\u0286\u0287\3\2\2\2\u0287"+
		"\u028b\3\2\2\2\u0288\u0289\5\u0096L\2\u0289\u028a\7\4\2\2\u028a\u028c"+
		"\3\2\2\2\u028b\u0288\3\2\2\2\u028b\u028c\3\2\2\2\u028c\u028d\3\2\2\2\u028d"+
		"\u028e\5\u00a8U\2\u028e\61\3\2\2\2\u028f\u0291\7\u0098\2\2\u0290\u0292"+
		"\7w\2\2\u0291\u0290\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0293\3\2\2\2\u0293"+
		"\u0298\5p9\2\u0294\u0295\7\7\2\2\u0295\u0297\5p9\2\u0296\u0294\3\2\2\2"+
		"\u0297\u029a\3\2\2\2\u0298\u0296\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u029c"+
		"\3\2\2\2\u029a\u0298\3\2\2\2\u029b\u028f\3\2\2\2\u029b\u029c\3\2\2\2\u029c"+
		"\u029d\3\2\2\2\u029d\u02a3\5~@\2\u029e\u029f\5\u0080A\2\u029f\u02a0\5"+
		"~@\2\u02a0\u02a2\3\2\2\2\u02a1\u029e\3\2\2\2\u02a2\u02a5\3\2\2\2\u02a3"+
		"\u02a1\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4\u02b0\3\2\2\2\u02a5\u02a3\3\2"+
		"\2\2\u02a6\u02a7\7p\2\2\u02a7\u02a8\7*\2\2\u02a8\u02ad\5l\67\2\u02a9\u02aa"+
		"\7\7\2\2\u02aa\u02ac\5l\67\2\u02ab\u02a9\3\2\2\2\u02ac\u02af\3\2\2\2\u02ad"+
		"\u02ab\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02b1\3\2\2\2\u02af\u02ad\3\2"+
		"\2\2\u02b0\u02a6\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1\u02b8\3\2\2\2\u02b2"+
		"\u02b3\7e\2\2\u02b3\u02b6\5^\60\2\u02b4\u02b5\t\4\2\2\u02b5\u02b7\5^\60"+
		"\2\u02b6\u02b4\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b9\3\2\2\2\u02b8\u02b2"+
		"\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9\63\3\2\2\2\u02ba\u02bc\5h\65\2\u02bb"+
		"\u02ba\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02ce\3\2\2\2\u02bd\u02cf\7["+
		"\2\2\u02be\u02cf\7}\2\2\u02bf\u02c0\7[\2\2\u02c0\u02c1\7o\2\2\u02c1\u02cf"+
		"\7}\2\2\u02c2\u02c3\7[\2\2\u02c3\u02c4\7o\2\2\u02c4\u02cf\7\u0080\2\2"+
		"\u02c5\u02c6\7[\2\2\u02c6\u02c7\7o\2\2\u02c7\u02cf\7\33\2\2\u02c8\u02c9"+
		"\7[\2\2\u02c9\u02ca\7o\2\2\u02ca\u02cf\7K\2\2\u02cb\u02cc\7[\2\2\u02cc"+
		"\u02cd\7o\2\2\u02cd\u02cf\7T\2\2\u02ce\u02bd\3\2\2\2\u02ce\u02be\3\2\2"+
		"\2\u02ce\u02bf\3\2\2\2\u02ce\u02c2\3\2\2\2\u02ce\u02c5\3\2\2\2\u02ce\u02c8"+
		"\3\2\2\2\u02ce\u02cb\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0\u02d4\7^\2\2\u02d1"+
		"\u02d2\5\u0096L\2\u02d2\u02d3\7\4\2\2\u02d3\u02d5\3\2\2\2\u02d4\u02d1"+
		"\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02e2\5\u0098M"+
		"\2\u02d7\u02d8\7\5\2\2\u02d8\u02dd\5\u009eP\2\u02d9\u02da\7\7\2\2\u02da"+
		"\u02dc\5\u009eP\2\u02db\u02d9\3\2\2\2\u02dc\u02df\3\2\2\2\u02dd\u02db"+
		"\3\2\2\2\u02dd\u02de\3\2\2\2\u02de\u02e0\3\2\2\2\u02df\u02dd\3\2\2\2\u02e0"+
		"\u02e1\7\6\2\2\u02e1\u02e3\3\2\2\2\u02e2\u02d7\3\2\2\2\u02e2\u02e3\3\2"+
		"\2\2\u02e3\u02f0\3\2\2\2\u02e4\u02e5\7\u0093\2\2\u02e5\u02ea\5\66\34\2"+
		"\u02e6\u02e7\7\7\2\2\u02e7\u02e9\5\66\34\2\u02e8\u02e6\3\2\2\2\u02e9\u02ec"+
		"\3\2\2\2\u02ea\u02e8\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02f1\3\2\2\2\u02ec"+
		"\u02ea\3\2\2\2\u02ed\u02f1\5D#\2\u02ee\u02ef\7;\2\2\u02ef\u02f1\7\u0093"+
		"\2\2\u02f0\u02e4\3\2\2\2\u02f0\u02ed\3\2\2\2\u02f0\u02ee\3\2\2\2\u02f1"+
		"\65\3\2\2\2\u02f2\u02f3\7\5\2\2\u02f3\u02f8\5^\60\2\u02f4\u02f5\7\7\2"+
		"\2\u02f5\u02f7\5^\60\2\u02f6\u02f4\3\2\2\2\u02f7\u02fa\3\2\2\2\u02f8\u02f6"+
		"\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fb\3\2\2\2\u02fa\u02f8\3\2\2\2\u02fb"+
		"\u02fc\7\6\2\2\u02fc\67\3\2\2\2\u02fd\u0301\7s\2\2\u02fe\u02ff\5\u0096"+
		"L\2\u02ff\u0300\7\4\2\2\u0300\u0302\3\2\2\2\u0301\u02fe\3\2\2\2\u0301"+
		"\u0302\3\2\2\2\u0302\u0303\3\2\2\2\u0303\u030a\5\u00acW\2\u0304\u0305"+
		"\7\b\2\2\u0305\u030b\5n8\2\u0306\u0307\7\5\2\2\u0307\u0308\5n8\2\u0308"+
		"\u0309\7\6\2\2\u0309\u030b\3\2\2\2\u030a\u0304\3\2\2\2\u030a\u0306\3\2"+
		"\2\2\u030a\u030b\3\2\2\2\u030b9\3\2\2\2\u030c\u0317\7z\2\2\u030d\u0318"+
		"\5\u00a0Q\2\u030e\u030f\5\u0096L\2\u030f\u0310\7\4\2\2\u0310\u0312\3\2"+
		"\2\2\u0311\u030e\3\2\2\2\u0311\u0312\3\2\2\2\u0312\u0315\3\2\2\2\u0313"+
		"\u0316\5\u0098M\2\u0314\u0316\5\u00a4S\2\u0315\u0313\3\2\2\2\u0315\u0314"+
		"\3\2\2\2\u0316\u0318\3\2\2\2\u0317\u030d\3\2\2\2\u0317\u0311\3\2\2\2\u0317"+
		"\u0318\3\2\2\2\u0318;\3\2\2\2\u0319\u031b\7{\2\2\u031a\u031c\7\u0082\2"+
		"\2\u031b\u031a\3\2\2\2\u031b\u031c\3\2\2\2\u031c\u031d\3\2\2\2\u031d\u031e"+
		"\5\u00aeX\2\u031e=\3\2\2\2\u031f\u0324\7\u0080\2\2\u0320\u0322\7\u008b"+
		"\2\2\u0321\u0323\5\u00b2Z\2\u0322\u0321\3\2\2\2\u0322\u0323\3\2\2\2\u0323"+
		"\u0325\3\2\2\2\u0324\u0320\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u032b\3\2"+
		"\2\2\u0326\u0328\7\u008a\2\2\u0327\u0329\7\u0082\2\2\u0328\u0327\3\2\2"+
		"\2\u0328\u0329\3\2\2\2\u0329\u032a\3\2\2\2\u032a\u032c\5\u00aeX\2\u032b"+
		"\u0326\3\2\2\2\u032b\u032c\3\2\2\2\u032c?\3\2\2\2\u032d\u032e\7\u0082"+
		"\2\2\u032e\u032f\5\u00aeX\2\u032fA\3\2\2\2\u0330\u0332\7\u0098\2\2\u0331"+
		"\u0333\7w\2\2\u0332\u0331\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u0334\3\2"+
		"\2\2\u0334\u0339\5p9\2\u0335\u0336\7\7\2\2\u0336\u0338\5p9\2\u0337\u0335"+
		"\3\2\2\2\u0338\u033b\3\2\2\2\u0339\u0337\3\2\2\2\u0339\u033a\3\2\2\2\u033a"+
		"\u033d\3\2\2\2\u033b\u0339\3\2\2\2\u033c\u0330\3\2\2\2\u033c\u033d\3\2"+
		"\2\2\u033d\u033e\3\2\2\2\u033e\u0349\5~@\2\u033f\u0340\7p\2\2\u0340\u0341"+
		"\7*\2\2\u0341\u0346\5l\67\2\u0342\u0343\7\7\2\2\u0343\u0345\5l\67\2\u0344"+
		"\u0342\3\2\2\2\u0345\u0348\3\2\2\2\u0346\u0344\3\2\2\2\u0346\u0347\3\2"+
		"\2\2\u0347\u034a\3\2\2\2\u0348\u0346\3\2\2\2\u0349\u033f\3\2\2\2\u0349"+
		"\u034a\3\2\2\2\u034a\u0351\3\2\2\2\u034b\u034c\7e\2\2\u034c\u034f\5^\60"+
		"\2\u034d\u034e\t\4\2\2\u034e\u0350\5^\60\2\u034f\u034d\3\2\2\2\u034f\u0350"+
		"\3\2\2\2\u0350\u0352\3\2\2\2\u0351\u034b\3\2\2\2\u0351\u0352\3\2\2\2\u0352"+
		"C\3\2\2\2\u0353\u0355\7\u0098\2\2\u0354\u0356\7w\2\2\u0355\u0354\3\2\2"+
		"\2\u0355\u0356\3\2\2\2\u0356\u0357\3\2\2\2\u0357\u035c\5p9\2\u0358\u0359"+
		"\7\7\2\2\u0359\u035b\5p9\2\u035a\u0358\3\2\2\2\u035b\u035e\3\2\2\2\u035c"+
		"\u035a\3\2\2\2\u035c\u035d\3\2\2\2\u035d\u0360\3\2\2\2\u035e\u035c\3\2"+
		"\2\2\u035f\u0353\3\2\2\2\u035f\u0360\3\2\2\2\u0360\u0361\3\2\2\2\u0361"+
		"\u0367\5F$\2\u0362\u0363\5\u0080A\2\u0363\u0364\5F$\2\u0364\u0366\3\2"+
		"\2\2\u0365\u0362\3\2\2\2\u0366\u0369\3\2\2\2\u0367\u0365\3\2\2\2\u0367"+
		"\u0368\3\2\2\2\u0368\u0374\3\2\2\2\u0369\u0367\3\2\2\2\u036a\u036b\7p"+
		"\2\2\u036b\u036c\7*\2\2\u036c\u0371\5l\67\2\u036d\u036e\7\7\2\2\u036e"+
		"\u0370\5l\67\2\u036f\u036d\3\2\2\2\u0370\u0373\3\2\2\2\u0371\u036f\3\2"+
		"\2\2\u0371\u0372\3\2\2\2\u0372\u0375\3\2\2\2\u0373\u0371\3\2\2\2\u0374"+
		"\u036a\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u037c\3\2\2\2\u0376\u0377\7e"+
		"\2\2\u0377\u037a\5^\60\2\u0378\u0379\t\4\2\2\u0379\u037b\5^\60\2\u037a"+
		"\u0378\3\2\2\2\u037a\u037b\3\2\2\2\u037b\u037d\3\2\2\2\u037c\u0376\3\2"+
		"\2\2\u037c\u037d\3\2\2\2\u037dE\3\2\2\2\u037e\u0380\7\u0083\2\2\u037f"+
		"\u0381\t\6\2\2\u0380\u037f\3\2\2\2\u0380\u0381\3\2\2\2\u0381\u0382\3\2"+
		"\2\2\u0382\u0387\5r:\2\u0383\u0384\7\7\2\2\u0384\u0386\5r:\2\u0385\u0383"+
		"\3\2\2\2\u0386\u0389\3\2\2\2\u0387\u0385\3\2\2\2\u0387\u0388\3\2\2\2\u0388"+
		"\u038c\3\2\2\2\u0389\u0387\3\2\2\2\u038a\u038b\7N\2\2\u038b\u038d\5v<"+
		"\2\u038c\u038a\3\2\2\2\u038c\u038d\3\2\2\2\u038d\u038f\3\2\2\2\u038e\u0390"+
		"\5|?\2\u038f\u038e\3\2\2\2\u038f\u0390\3\2\2\2\u0390\u039f\3\2\2\2\u0391"+
		"\u0392\7Q\2\2\u0392\u0393\7*\2\2\u0393\u0398\5^\60\2\u0394\u0395\7\7\2"+
		"\2\u0395\u0397\5^\60\2\u0396\u0394\3\2\2\2\u0397\u039a\3\2\2\2\u0398\u0396"+
		"\3\2\2\2\u0398\u0399\3\2\2\2\u0399\u039d\3\2\2\2\u039a\u0398\3\2\2\2\u039b"+
		"\u039c\7R\2\2\u039c\u039e\5^\60\2\u039d\u039b\3\2\2\2\u039d\u039e\3\2"+
		"\2\2\u039e\u03a0\3\2\2\2\u039f\u0391\3\2\2\2\u039f\u03a0\3\2\2\2\u03a0"+
		"\u03be\3\2\2\2\u03a1\u03a2\7\u0093\2\2\u03a2\u03a3\7\5\2\2\u03a3\u03a8"+
		"\5^\60\2\u03a4\u03a5\7\7\2\2\u03a5\u03a7\5^\60\2\u03a6\u03a4\3\2\2\2\u03a7"+
		"\u03aa\3\2\2\2\u03a8\u03a6\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03ab\3\2"+
		"\2\2\u03aa\u03a8\3\2\2\2\u03ab\u03ba\7\6\2\2\u03ac\u03ad\7\7\2\2\u03ad"+
		"\u03ae\7\5\2\2\u03ae\u03b3\5^\60\2\u03af\u03b0\7\7\2\2\u03b0\u03b2\5^"+
		"\60\2\u03b1\u03af\3\2\2\2\u03b2\u03b5\3\2\2\2\u03b3\u03b1\3\2\2\2\u03b3"+
		"\u03b4\3\2\2\2\u03b4\u03b6\3\2\2\2\u03b5\u03b3\3\2\2\2\u03b6\u03b7\7\6"+
		"\2\2\u03b7\u03b9\3\2\2\2\u03b8\u03ac\3\2\2\2\u03b9\u03bc\3\2\2\2\u03ba"+
		"\u03b8\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03be\3\2\2\2\u03bc\u03ba\3\2"+
		"\2\2\u03bd\u037e\3\2\2\2\u03bd\u03a1\3\2\2\2\u03beG\3\2\2\2\u03bf\u03c0"+
		"\7\u0085\2\2\u03c0\u03c1\79\2\2\u03c1\u03c5\5\u0096L\2\u03c2\u03c3\7\u0085"+
		"\2\2\u03c3\u03c5\7:\2\2\u03c4\u03bf\3\2\2\2\u03c4\u03c2\3\2\2\2\u03c5"+
		"I\3\2\2\2\u03c6\u03c7\7\u0085\2\2\u03c7\u03cb\7\u0086\2\2\u03c8\u03c9"+
		"\5\u0096L\2\u03c9\u03ca\7\4\2\2\u03ca\u03cc\3\2\2\2\u03cb\u03c8\3\2\2"+
		"\2\u03cb\u03cc\3\2\2\2\u03cc\u03cd\3\2\2\2\u03cd\u03ce\5\u0098M\2\u03ce"+
		"K\3\2\2\2\u03cf\u03d0\5\u009eP\2\u03d0\u03d1\7\b\2\2\u03d1\u03d2\5^\60"+
		"\2\u03d2M\3\2\2\2\u03d3\u03d5\5h\65\2\u03d4\u03d3\3\2\2\2\u03d4\u03d5"+
		"\3\2\2\2\u03d5\u03d6\3\2\2\2\u03d6\u03e1\7\u008f\2\2\u03d7\u03d8\7o\2"+
		"\2\u03d8\u03e2\7\u0080\2\2\u03d9\u03da\7o\2\2\u03da\u03e2\7\33\2\2\u03db"+
		"\u03dc\7o\2\2\u03dc\u03e2\7}\2\2\u03dd\u03de\7o\2\2\u03de\u03e2\7K\2\2"+
		"\u03df\u03e0\7o\2\2\u03e0\u03e2\7T\2\2\u03e1\u03d7\3\2\2\2\u03e1\u03d9"+
		"\3\2\2\2\u03e1\u03db\3\2\2\2\u03e1\u03dd\3\2\2\2\u03e1\u03df\3\2\2\2\u03e1"+
		"\u03e2\3\2\2\2\u03e2\u03e3\3\2\2\2\u03e3\u03e4\5j\66\2\u03e4\u03e5\7\u0084"+
		"\2\2\u03e5\u03ea\5L\'\2\u03e6\u03e7\7\7\2\2\u03e7\u03e9\5L\'\2\u03e8\u03e6"+
		"\3\2\2\2\u03e9\u03ec\3\2\2\2\u03ea\u03e8\3\2\2\2\u03ea\u03eb\3\2\2\2\u03eb"+
		"\u03ee\3\2\2\2\u03ec\u03ea\3\2\2\2\u03ed\u03ef\5|?\2\u03ee\u03ed\3\2\2"+
		"\2\u03ee\u03ef\3\2\2\2\u03efO\3\2\2\2\u03f0\u03f2\5h\65\2\u03f1\u03f0"+
		"\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2\u03f3\3\2\2\2\u03f3\u03fe\7\u008f\2"+
		"\2\u03f4\u03f5\7o\2\2\u03f5\u03ff\7\u0080\2\2\u03f6\u03f7\7o\2\2\u03f7"+
		"\u03ff\7\33\2\2\u03f8\u03f9\7o\2\2\u03f9\u03ff\7}\2\2\u03fa\u03fb\7o\2"+
		"\2\u03fb\u03ff\7K\2\2\u03fc\u03fd\7o\2\2\u03fd\u03ff\7T\2\2\u03fe\u03f4"+
		"\3\2\2\2\u03fe\u03f6\3\2\2\2\u03fe\u03f8\3\2\2\2\u03fe\u03fa\3\2\2\2\u03fe"+
		"\u03fc\3\2\2\2\u03fe\u03ff\3\2\2\2\u03ff\u0400\3\2\2\2\u0400\u0401\5j"+
		"\66\2\u0401\u0402\7\u0084\2\2\u0402\u0403\5\u009eP\2\u0403\u0404\7\b\2"+
		"\2\u0404\u040c\5^\60\2\u0405\u0406\7\7\2\2\u0406\u0407\5\u009eP\2\u0407"+
		"\u0408\7\b\2\2\u0408\u0409\5^\60\2\u0409\u040b\3\2\2\2\u040a\u0405\3\2"+
		"\2\2\u040b\u040e\3\2\2\2\u040c\u040a\3\2\2\2\u040c\u040d\3\2\2\2\u040d"+
		"\u0410\3\2\2\2\u040e\u040c\3\2\2\2\u040f\u0411\5|?\2\u0410\u040f\3\2\2"+
		"\2\u0410\u0411\3\2\2\2\u0411\u0424\3\2\2\2\u0412\u0413\7p\2\2\u0413\u0414"+
		"\7*\2\2\u0414\u0419\5l\67\2\u0415\u0416\7\7\2\2\u0416\u0418\5l\67\2\u0417"+
		"\u0415\3\2\2\2\u0418\u041b\3\2\2\2\u0419\u0417\3\2\2\2\u0419\u041a\3\2"+
		"\2\2\u041a\u041d\3\2\2\2\u041b\u0419\3\2\2\2\u041c\u0412\3\2\2\2\u041c"+
		"\u041d\3\2\2\2\u041d\u041e\3\2\2\2\u041e\u041f\7e\2\2\u041f\u0422\5^\60"+
		"\2\u0420\u0421\t\4\2\2\u0421\u0423\5^\60\2\u0422\u0420\3\2\2\2\u0422\u0423"+
		"\3\2\2\2\u0423\u0425\3\2\2\2\u0424\u041c\3\2\2\2\u0424\u0425\3\2\2\2\u0425"+
		"Q\3\2\2\2\u0426\u0427\7\u0090\2\2\u0427\u0428\79\2\2\u0428\u0429\5\u0096"+
		"L\2\u0429S\3\2\2\2\u042a\u042b\7\u0092\2\2\u042bU\3\2\2\2\u042c\u042e"+
		"\5\u009eP\2\u042d\u042f\5X-\2\u042e\u042d\3\2\2\2\u042e\u042f\3\2\2\2"+
		"\u042f\u0433\3\2\2\2\u0430\u0432\5Z.\2\u0431\u0430\3\2\2\2\u0432\u0435"+
		"\3\2\2\2\u0433\u0431\3\2\2\2\u0433\u0434\3\2\2\2\u0434W\3\2\2\2\u0435"+
		"\u0433\3\2\2\2\u0436\u0441\5\u0092J\2\u0437\u0438\7\5\2\2\u0438\u0439"+
		"\5\u0084C\2\u0439\u043a\7\6\2\2\u043a\u0442\3\2\2\2\u043b\u043c\7\5\2"+
		"\2\u043c\u043d\5\u0084C\2\u043d\u043e\7\7\2\2\u043e\u043f\5\u0084C\2\u043f"+
		"\u0440\7\6\2\2\u0440\u0442\3\2\2\2\u0441\u0437\3\2\2\2\u0441\u043b\3\2"+
		"\2\2\u0441\u0442\3\2\2\2\u0442Y\3\2\2\2\u0443\u0444\7\63\2\2\u0444\u0446"+
		"\5\u0092J\2\u0445\u0443\3\2\2\2\u0445\u0446\3\2\2\2\u0446\u0468\3\2\2"+
		"\2\u0447\u0448\7t\2\2\u0448\u044a\7b\2\2\u0449\u044b\t\7\2\2\u044a\u0449"+
		"\3\2\2\2\u044a\u044b\3\2\2\2\u044b\u044c\3\2\2\2\u044c\u044e\5\\/\2\u044d"+
		"\u044f\7&\2\2\u044e\u044d\3\2\2\2\u044e\u044f\3\2\2\2\u044f\u0469\3\2"+
		"\2\2\u0450\u0452\7i\2\2\u0451\u0450\3\2\2\2\u0451\u0452\3\2\2\2\u0452"+
		"\u0453\3\2\2\2\u0453\u0454\7k\2\2\u0454\u0469\5\\/\2\u0455\u0456\7\u008e"+
		"\2\2\u0456\u0469\5\\/\2\u0457\u0458\7.\2\2\u0458\u0459\7\5\2\2\u0459\u045a"+
		"\5^\60\2\u045a\u045b\7\6\2\2\u045b\u0469\3\2\2\2\u045c\u0463\7;\2\2\u045d"+
		"\u0464\5\u0084C\2\u045e\u0464\5\u0086D\2\u045f\u0460\7\5\2\2\u0460\u0461"+
		"\5^\60\2\u0461\u0462\7\6\2\2\u0462\u0464\3\2\2\2\u0463\u045d\3\2\2\2\u0463"+
		"\u045e\3\2\2\2\u0463\u045f\3\2\2\2\u0464\u0469\3\2\2\2\u0465\u0466\7/"+
		"\2\2\u0466\u0469\5\u00a0Q\2\u0467\u0469\5`\61\2\u0468\u0447\3\2\2\2\u0468"+
		"\u0451\3\2\2\2\u0468\u0455\3\2\2\2\u0468\u0457\3\2\2\2\u0468\u045c\3\2"+
		"\2\2\u0468\u0465\3\2\2\2\u0468\u0467\3\2\2\2\u0469[\3\2\2\2\u046a\u046b"+
		"\7n\2\2\u046b\u046c\7\62\2\2\u046c\u046e\t\b\2\2\u046d\u046a\3\2\2\2\u046d"+
		"\u046e\3\2\2\2\u046e]\3\2\2\2\u046f\u0470\b\60\1\2\u0470\u04bc\5\u0086"+
		"D\2\u0471\u04bc\7\u009c\2\2\u0472\u0473\5\u0096L\2\u0473\u0474\7\4\2\2"+
		"\u0474\u0476\3\2\2\2\u0475\u0472\3\2\2\2\u0475\u0476\3\2\2\2\u0476\u0477"+
		"\3\2\2\2\u0477\u0478\5\u0098M\2\u0478\u0479\7\4\2\2\u0479\u047b\3\2\2"+
		"\2\u047a\u0475\3\2\2\2\u047a\u047b\3\2\2\2\u047b\u047c\3\2\2\2\u047c\u04bc"+
		"\5\u009eP\2\u047d\u047e\5\u0088E\2\u047e\u047f\5^\60\27\u047f\u04bc\3"+
		"\2\2\2\u0480\u0481\5\u0094K\2\u0481\u048e\7\5\2\2\u0482\u0484\7A\2\2\u0483"+
		"\u0482\3\2\2\2\u0483\u0484\3\2\2\2\u0484\u0485\3\2\2\2\u0485\u048a\5^"+
		"\60\2\u0486\u0487\7\7\2\2\u0487\u0489\5^\60\2\u0488\u0486\3\2\2\2\u0489"+
		"\u048c\3\2\2\2\u048a\u0488\3\2\2\2\u048a\u048b\3\2\2\2\u048b\u048f\3\2"+
		"\2\2\u048c\u048a\3\2\2\2\u048d\u048f\7\t\2\2\u048e\u0483\3\2\2\2\u048e"+
		"\u048d\3\2\2\2\u048e\u048f\3\2\2\2\u048f\u0490\3\2\2\2\u0490\u0491\7\6"+
		"\2\2\u0491\u04bc\3\2\2\2\u0492\u0493\7\5\2\2\u0493\u0494\5^\60\2\u0494"+
		"\u0495\7\6\2\2\u0495\u04bc\3\2\2\2\u0496\u0497\7-\2\2\u0497\u0498\7\5"+
		"\2\2\u0498\u0499\5^\60\2\u0499\u049a\7#\2\2\u049a\u049b\5X-\2\u049b\u049c"+
		"\7\6\2\2\u049c\u04bc\3\2\2\2\u049d\u049f\7i\2\2\u049e\u049d\3\2\2\2\u049e"+
		"\u049f\3\2\2\2\u049f\u04a0\3\2\2\2\u04a0\u04a2\7I\2\2\u04a1\u049e\3\2"+
		"\2\2\u04a1\u04a2\3\2\2\2\u04a2\u04a3\3\2\2\2\u04a3\u04a4\7\5\2\2\u04a4"+
		"\u04a5\5D#\2\u04a5\u04a6\7\6\2\2\u04a6\u04bc\3\2\2\2\u04a7\u04a9\7,\2"+
		"\2\u04a8\u04aa\5^\60\2\u04a9\u04a8\3\2\2\2\u04a9\u04aa\3\2\2\2\u04aa\u04b0"+
		"\3\2\2\2\u04ab\u04ac\7\u0096\2\2\u04ac\u04ad\5^\60\2\u04ad\u04ae\7\u0089"+
		"\2\2\u04ae\u04af\5^\60\2\u04af\u04b1\3\2\2\2\u04b0\u04ab\3\2\2\2\u04b1"+
		"\u04b2\3\2\2\2\u04b2\u04b0\3\2\2\2\u04b2\u04b3\3\2\2\2\u04b3\u04b6\3\2"+
		"\2\2\u04b4\u04b5\7D\2\2\u04b5\u04b7\5^\60\2\u04b6\u04b4\3\2\2\2\u04b6"+
		"\u04b7\3\2\2\2\u04b7\u04b8\3\2\2\2\u04b8\u04b9\7E\2\2\u04b9\u04bc\3\2"+
		"\2\2\u04ba\u04bc\5b\62\2\u04bb\u046f\3\2\2\2\u04bb\u0471\3\2\2\2\u04bb"+
		"\u047a\3\2\2\2\u04bb\u047d\3\2\2\2\u04bb\u0480\3\2\2\2\u04bb\u0492\3\2"+
		"\2\2\u04bb\u0496\3\2\2\2\u04bb\u04a1\3\2\2\2\u04bb\u04a7\3\2\2\2\u04bb"+
		"\u04ba\3\2\2\2\u04bc\u0521\3\2\2\2\u04bd\u04be\f\26\2\2\u04be\u04bf\7"+
		"\r\2\2\u04bf\u0520\5^\60\27\u04c0\u04c1\f\25\2\2\u04c1\u04c2\t\t\2\2\u04c2"+
		"\u0520\5^\60\26\u04c3\u04c4\f\24\2\2\u04c4\u04c5\t\n\2\2\u04c5\u0520\5"+
		"^\60\25\u04c6\u04c7\f\23\2\2\u04c7\u04c8\t\13\2\2\u04c8\u0520\5^\60\24"+
		"\u04c9\u04ca\f\22\2\2\u04ca\u04cb\t\f\2\2\u04cb\u0520\5^\60\23\u04cc\u04d9"+
		"\f\21\2\2\u04cd\u04da\7\b\2\2\u04ce\u04da\7\30\2\2\u04cf\u04da\7\31\2"+
		"\2\u04d0\u04da\7\32\2\2\u04d1\u04da\7_\2\2\u04d2\u04d3\7_\2\2\u04d3\u04da"+
		"\7i\2\2\u04d4\u04da\7V\2\2\u04d5\u04da\7d\2\2\u04d6\u04da\7P\2\2\u04d7"+
		"\u04da\7f\2\2\u04d8\u04da\7y\2\2\u04d9\u04cd\3\2\2\2\u04d9\u04ce\3\2\2"+
		"\2\u04d9\u04cf\3\2\2\2\u04d9\u04d0\3\2\2\2\u04d9\u04d1\3\2\2\2\u04d9\u04d2"+
		"\3\2\2\2\u04d9\u04d4\3\2\2\2\u04d9\u04d5\3\2\2\2\u04d9\u04d6\3\2\2\2\u04d9"+
		"\u04d7\3\2\2\2\u04d9\u04d8\3\2\2\2\u04da\u04db\3\2\2\2\u04db\u0520\5^"+
		"\60\22\u04dc\u04dd\f\20\2\2\u04dd\u04de\7\"\2\2\u04de\u0520\5^\60\21\u04df"+
		"\u04e0\f\17\2\2\u04e0\u04e1\7o\2\2\u04e1\u0520\5^\60\20\u04e2\u04e3\f"+
		"\b\2\2\u04e3\u04e5\7_\2\2\u04e4\u04e6\7i\2\2\u04e5\u04e4\3\2\2\2\u04e5"+
		"\u04e6\3\2\2\2\u04e6\u04e7\3\2\2\2\u04e7\u0520\5^\60\t\u04e8\u04ea\f\7"+
		"\2\2\u04e9\u04eb\7i\2\2\u04ea\u04e9\3\2\2\2\u04ea\u04eb\3\2\2\2\u04eb"+
		"\u04ec\3\2\2\2\u04ec\u04ed\7)\2\2\u04ed\u04ee\5^\60\2\u04ee\u04ef\7\""+
		"\2\2\u04ef\u04f0\5^\60\b\u04f0\u0520\3\2\2\2\u04f1\u04f2\f\13\2\2\u04f2"+
		"\u04f3\7/\2\2\u04f3\u0520\5\u00a0Q\2\u04f4\u04f6\f\n\2\2\u04f5\u04f7\7"+
		"i\2\2\u04f6\u04f5\3\2\2\2\u04f6\u04f7\3\2\2\2\u04f7\u04f8\3\2\2\2\u04f8"+
		"\u04f9\t\r\2\2\u04f9\u04fc\5^\60\2\u04fa\u04fb\7F\2\2\u04fb\u04fd\5^\60"+
		"\2\u04fc\u04fa\3\2\2\2\u04fc\u04fd\3\2\2\2\u04fd\u0520\3\2\2\2\u04fe\u0503"+
		"\f\t\2\2\u04ff\u0504\7`\2\2\u0500\u0504\7j\2\2\u0501\u0502\7i\2\2\u0502"+
		"\u0504\7k\2\2\u0503\u04ff\3\2\2\2\u0503\u0500\3\2\2\2\u0503\u0501\3\2"+
		"\2\2\u0504\u0520\3\2\2\2\u0505\u0507\f\6\2\2\u0506\u0508\7i\2\2\u0507"+
		"\u0506\3\2\2\2\u0507\u0508\3\2\2\2\u0508\u0509\3\2\2\2\u0509\u051d\7V"+
		"\2\2\u050a\u0514\7\5\2\2\u050b\u0515\5D#\2\u050c\u0511\5^\60\2\u050d\u050e"+
		"\7\7\2\2\u050e\u0510\5^\60\2\u050f\u050d\3\2\2\2\u0510\u0513\3\2\2\2\u0511"+
		"\u050f\3\2\2\2\u0511\u0512\3\2\2\2\u0512\u0515\3\2\2\2\u0513\u0511\3\2"+
		"\2\2\u0514\u050b\3\2\2\2\u0514\u050c\3\2\2\2\u0514\u0515\3\2\2\2\u0515"+
		"\u0516\3\2\2\2\u0516\u051e\7\6\2\2\u0517\u0518\5\u0096L\2\u0518\u0519"+
		"\7\4\2\2\u0519\u051b\3\2\2\2\u051a\u0517\3\2\2\2\u051a\u051b\3\2\2\2\u051b"+
		"\u051c\3\2\2\2\u051c\u051e\5\u0098M\2\u051d\u050a\3\2\2\2\u051d\u051a"+
		"\3\2\2\2\u051e\u0520\3\2\2\2\u051f\u04bd\3\2\2\2\u051f\u04c0\3\2\2\2\u051f"+
		"\u04c3\3\2\2\2\u051f\u04c6\3\2\2\2\u051f\u04c9\3\2\2\2\u051f\u04cc\3\2"+
		"\2\2\u051f\u04dc\3\2\2\2\u051f\u04df\3\2\2\2\u051f\u04e2\3\2\2\2\u051f"+
		"\u04e8\3\2\2\2\u051f\u04f1\3\2\2\2\u051f\u04f4\3\2\2\2\u051f\u04fe\3\2"+
		"\2\2\u051f\u0505\3\2\2\2\u0520\u0523\3\2\2\2\u0521\u051f\3\2\2\2\u0521"+
		"\u0522\3\2\2\2\u0522_\3\2\2\2\u0523\u0521\3\2\2\2\u0524\u0525\7x\2\2\u0525"+
		"\u0531\5\u00a2R\2\u0526\u0527\7\5\2\2\u0527\u052c\5\u009eP\2\u0528\u0529"+
		"\7\7\2\2\u0529\u052b\5\u009eP\2\u052a\u0528\3\2\2\2\u052b\u052e\3\2\2"+
		"\2\u052c\u052a\3\2\2\2\u052c\u052d\3\2\2\2\u052d\u052f\3\2\2\2\u052e\u052c"+
		"\3\2\2\2\u052f\u0530\7\6\2\2\u0530\u0532\3\2\2\2\u0531\u0526\3\2\2\2\u0531"+
		"\u0532\3\2\2\2\u0532\u0545\3\2\2\2\u0533\u0534\7n\2\2\u0534\u053d\t\16"+
		"\2\2\u0535\u0536\7\u0084\2\2\u0536\u053e\7k\2\2\u0537\u0538\7\u0084\2"+
		"\2\u0538\u053e\7;\2\2\u0539\u053e\7+\2\2\u053a\u053e\7~\2\2\u053b\u053c"+
		"\7h\2\2\u053c\u053e\7\34\2\2\u053d\u0535\3\2\2\2\u053d\u0537\3\2\2\2\u053d"+
		"\u0539\3\2\2\2\u053d\u053a\3\2\2\2\u053d\u053b\3\2\2\2\u053e\u0542\3\2"+
		"\2\2\u053f\u0540\7f\2\2\u0540\u0542\5\u0092J\2\u0541\u0533\3\2\2\2\u0541"+
		"\u053f\3\2\2\2\u0542\u0544\3\2\2\2\u0543\u0541\3\2\2\2\u0544\u0547\3\2"+
		"\2\2\u0545\u0543\3\2\2\2\u0545\u0546\3\2\2\2\u0546\u0552\3\2\2\2\u0547"+
		"\u0545\3\2\2\2\u0548\u054a\7i\2\2\u0549\u0548\3\2\2\2\u0549\u054a\3\2"+
		"\2\2\u054a\u054b\3\2\2\2\u054b\u0550\7<\2\2\u054c\u054d\7Y\2\2\u054d\u0551"+
		"\7=\2\2\u054e\u054f\7Y\2\2\u054f\u0551\7U\2\2\u0550\u054c\3\2\2\2\u0550"+
		"\u054e\3\2\2\2\u0550\u0551\3\2\2\2\u0551\u0553\3\2\2\2\u0552\u0549\3\2"+
		"\2\2\u0552\u0553\3\2\2\2\u0553a\3\2\2\2\u0554\u0555\7v\2\2\u0555\u055a"+
		"\7\5\2\2\u0556\u055b\7T\2\2\u0557\u0558\t\17\2\2\u0558\u0559\7\7\2\2\u0559"+
		"\u055b\5\u008aF\2\u055a\u0556\3\2\2\2\u055a\u0557\3\2\2\2\u055b\u055c"+
		"\3\2\2\2\u055c\u055d\7\6\2\2\u055dc\3\2\2\2\u055e\u0561\5\u009eP\2\u055f"+
		"\u0560\7/\2\2\u0560\u0562\5\u00a0Q\2\u0561\u055f\3\2\2\2\u0561\u0562\3"+
		"\2\2\2\u0562\u0564\3\2\2\2\u0563\u0565\t\7\2\2\u0564\u0563\3\2\2\2\u0564"+
		"\u0565\3\2\2\2\u0565e\3\2\2\2\u0566\u0567\7\63\2\2\u0567\u0569\5\u0092"+
		"J\2\u0568\u0566\3\2\2\2\u0568\u0569\3\2\2\2\u0569\u058e\3\2\2\2\u056a"+
		"\u056b\7t\2\2\u056b\u056e\7b\2\2\u056c\u056e\7\u008e\2\2\u056d\u056a\3"+
		"\2\2\2\u056d\u056c\3\2\2\2\u056e\u056f\3\2\2\2\u056f\u0570\7\5\2\2\u0570"+
		"\u0575\5d\63\2\u0571\u0572\7\7\2\2\u0572\u0574\5d\63\2\u0573\u0571\3\2"+
		"\2\2\u0574\u0577\3\2\2\2\u0575\u0573\3\2\2\2\u0575\u0576\3\2\2\2\u0576"+
		"\u0578\3\2\2\2\u0577\u0575\3\2\2\2\u0578\u0579\7\6\2\2\u0579\u057a\5\\"+
		"/\2\u057a\u058f\3\2\2\2\u057b\u057c\7.\2\2\u057c\u057d\7\5\2\2\u057d\u057e"+
		"\5^\60\2\u057e\u057f\7\6\2\2\u057f\u058f\3\2\2\2\u0580\u0581\7M\2\2\u0581"+
		"\u0582\7b\2\2\u0582\u0583\7\5\2\2\u0583\u0588\5\u009eP\2\u0584\u0585\7"+
		"\7\2\2\u0585\u0587\5\u009eP\2\u0586\u0584\3\2\2\2\u0587\u058a\3\2\2\2"+
		"\u0588\u0586\3\2\2\2\u0588\u0589\3\2\2\2\u0589\u058b\3\2\2\2\u058a\u0588"+
		"\3\2\2\2\u058b\u058c\7\6\2\2\u058c\u058d\5`\61\2\u058d\u058f\3\2\2\2\u058e"+
		"\u056d\3\2\2\2\u058e\u057b\3\2\2\2\u058e\u0580\3\2\2\2\u058fg\3\2\2\2"+
		"\u0590\u0592\7\u0098\2\2\u0591\u0593\7w\2\2\u0592\u0591\3\2\2\2\u0592"+
		"\u0593\3\2\2\2\u0593\u0594\3\2\2\2\u0594\u0595\5\u0082B\2\u0595\u0596"+
		"\7#\2\2\u0596\u0597\7\5\2\2\u0597\u0598\5D#\2\u0598\u05a2\7\6\2\2\u0599"+
		"\u059a\7\7\2\2\u059a\u059b\5\u0082B\2\u059b\u059c\7#\2\2\u059c\u059d\7"+
		"\5\2\2\u059d\u059e\5D#\2\u059e\u059f\7\6\2\2\u059f\u05a1\3\2\2\2\u05a0"+
		"\u0599\3\2\2\2\u05a1\u05a4\3\2\2\2\u05a2\u05a0\3\2\2\2\u05a2\u05a3\3\2"+
		"\2\2\u05a3i\3\2\2\2\u05a4\u05a2\3\2\2\2\u05a5\u05a6\5\u0096L\2\u05a6\u05a7"+
		"\7\4\2\2\u05a7\u05a9\3\2\2\2\u05a8\u05a5\3\2\2\2\u05a8\u05a9\3\2\2\2\u05a9"+
		"\u05aa\3\2\2\2\u05aa\u05b0\5\u0098M\2\u05ab\u05ac\7X\2\2\u05ac\u05ad\7"+
		"*\2\2\u05ad\u05b1\5\u00a4S\2\u05ae\u05af\7i\2\2\u05af\u05b1\7X\2\2\u05b0"+
		"\u05ab\3\2\2\2\u05b0\u05ae\3\2\2\2\u05b0\u05b1\3\2\2\2\u05b1k\3\2\2\2"+
		"\u05b2\u05b5\5^\60\2\u05b3\u05b4\7/\2\2\u05b4\u05b6\5\u00a0Q\2\u05b5\u05b3"+
		"\3\2\2\2\u05b5\u05b6\3\2\2\2\u05b6\u05b8\3\2\2\2\u05b7\u05b9\t\7\2\2\u05b8"+
		"\u05b7\3\2\2\2\u05b8\u05b9\3\2\2\2\u05b9m\3\2\2\2\u05ba\u05be\5\u0084"+
		"C\2\u05bb\u05be\5\u0092J\2\u05bc\u05be\7\u009d\2\2\u05bd\u05ba\3\2\2\2"+
		"\u05bd\u05bb\3\2\2\2\u05bd\u05bc\3\2\2\2\u05beo\3\2\2\2\u05bf\u05cb\5"+
		"\u0098M\2\u05c0\u05c1\7\5\2\2\u05c1\u05c6\5\u009eP\2\u05c2\u05c3\7\7\2"+
		"\2\u05c3\u05c5\5\u009eP\2\u05c4\u05c2\3\2\2\2\u05c5\u05c8\3\2\2\2\u05c6"+
		"\u05c4\3\2\2\2\u05c6\u05c7\3\2\2\2\u05c7\u05c9\3\2\2\2\u05c8\u05c6\3\2"+
		"\2\2\u05c9\u05ca\7\6\2\2\u05ca\u05cc\3\2\2\2\u05cb\u05c0\3\2\2\2\u05cb"+
		"\u05cc\3\2\2\2\u05cc\u05cd\3\2\2\2\u05cd\u05ce\7#\2\2\u05ce\u05cf\7\5"+
		"\2\2\u05cf\u05d0\5D#\2\u05d0\u05d1\7\6\2\2\u05d1q\3\2\2\2\u05d2\u05df"+
		"\7\t\2\2\u05d3\u05d4\5\u0098M\2\u05d4\u05d5\7\4\2\2\u05d5\u05d6\7\t\2"+
		"\2\u05d6\u05df\3\2\2\2\u05d7\u05dc\5^\60\2\u05d8\u05da\7#\2\2\u05d9\u05d8"+
		"\3\2\2\2\u05d9\u05da\3\2\2\2\u05da\u05db\3\2\2\2\u05db\u05dd\5\u008eH"+
		"\2\u05dc\u05d9\3\2\2\2\u05dc\u05dd\3\2\2\2\u05dd\u05df\3\2\2\2\u05de\u05d2"+
		"\3\2\2\2\u05de\u05d3\3\2\2\2\u05de\u05d7\3\2\2\2\u05dfs\3\2\2\2\u05e0"+
		"\u05e1\5\u0096L\2\u05e1\u05e2\7\4\2\2\u05e2\u05e4\3\2\2\2\u05e3\u05e0"+
		"\3\2\2\2\u05e3\u05e4\3\2\2\2\u05e4\u05e5\3\2\2\2\u05e5\u05ea\5\u0098M"+
		"\2\u05e6\u05e8\7#\2\2\u05e7\u05e6\3\2\2\2\u05e7\u05e8\3\2\2\2\u05e8\u05e9"+
		"\3\2\2\2\u05e9\u05eb\5\u00b0Y\2\u05ea\u05e7\3\2\2\2\u05ea\u05eb\3\2\2"+
		"\2\u05eb\u05f1\3\2\2\2\u05ec\u05ed\7X\2\2\u05ed\u05ee\7*\2\2\u05ee\u05f2"+
		"\5\u00a4S\2\u05ef\u05f0\7i\2\2\u05f0\u05f2\7X\2\2\u05f1\u05ec\3\2\2\2"+
		"\u05f1\u05ef\3\2\2\2\u05f1\u05f2\3\2\2\2\u05f2\u0610\3\2\2\2\u05f3\u05fd"+
		"\7\5\2\2\u05f4\u05f9\5t;\2\u05f5\u05f6\7\7\2\2\u05f6\u05f8\5t;\2\u05f7"+
		"\u05f5\3\2\2\2\u05f8\u05fb\3\2\2\2\u05f9\u05f7\3\2\2\2\u05f9\u05fa\3\2"+
		"\2\2\u05fa\u05fe\3\2\2\2\u05fb\u05f9\3\2\2\2\u05fc\u05fe\5v<\2\u05fd\u05f4"+
		"\3\2\2\2\u05fd\u05fc\3\2\2\2\u05fe\u05ff\3\2\2\2\u05ff\u0604\7\6\2\2\u0600"+
		"\u0602\7#\2\2\u0601\u0600\3\2\2\2\u0601\u0602\3\2\2\2\u0602\u0603\3\2"+
		"\2\2\u0603\u0605\5\u00b0Y\2\u0604\u0601\3\2\2\2\u0604\u0605\3\2\2\2\u0605"+
		"\u0610\3\2\2\2\u0606\u0607\7\5\2\2\u0607\u0608\5D#\2\u0608\u060d\7\6\2"+
		"\2\u0609\u060b\7#\2\2\u060a\u0609\3\2\2\2\u060a\u060b\3\2\2\2\u060b\u060c"+
		"\3\2\2\2\u060c\u060e\5\u00b0Y\2\u060d\u060a\3\2\2\2\u060d\u060e\3\2\2"+
		"\2\u060e\u0610\3\2\2\2\u060f\u05e3\3\2\2\2\u060f\u05f3\3\2\2\2\u060f\u0606"+
		"\3\2\2\2\u0610u\3\2\2\2\u0611\u0618\5t;\2\u0612\u0613\5x=\2\u0613\u0614"+
		"\5t;\2\u0614\u0615\5z>\2\u0615\u0617\3\2\2\2\u0616\u0612\3\2\2\2\u0617"+
		"\u061a\3\2\2\2\u0618\u0616\3\2\2\2\u0618\u0619\3\2\2\2\u0619w\3\2\2\2"+
		"\u061a\u0618\3\2\2\2\u061b\u0629\7\7\2\2\u061c\u061e\7g\2\2\u061d\u061c"+
		"\3\2\2\2\u061d\u061e\3\2\2\2\u061e\u0625\3\2\2\2\u061f\u0621\7c\2\2\u0620"+
		"\u0622\7q\2\2\u0621\u0620\3\2\2\2\u0621\u0622\3\2\2\2\u0622\u0626\3\2"+
		"\2\2\u0623\u0626\7Z\2\2\u0624\u0626\7\65\2\2\u0625\u061f\3\2\2\2\u0625"+
		"\u0623\3\2\2\2\u0625\u0624\3\2\2\2\u0625\u0626\3\2\2\2\u0626\u0627\3\2"+
		"\2\2\u0627\u0629\7a\2\2\u0628\u061b\3\2\2\2\u0628\u061d\3\2\2\2\u0629"+
		"y\3\2\2\2\u062a\u062b\7n\2\2\u062b\u0639\5^\60\2\u062c\u062d\7\u0091\2"+
		"\2\u062d\u062e\7\5\2\2\u062e\u0633\5\u009eP\2\u062f\u0630\7\7\2\2\u0630"+
		"\u0632\5\u009eP\2\u0631\u062f\3\2\2\2\u0632\u0635\3\2\2\2\u0633\u0631"+
		"\3\2\2\2\u0633\u0634\3\2\2\2\u0634\u0636\3\2\2\2\u0635\u0633\3\2\2\2\u0636"+
		"\u0637\7\6\2\2\u0637\u0639\3\2\2\2\u0638\u062a\3\2\2\2\u0638\u062c\3\2"+
		"\2\2\u0638\u0639\3\2\2\2\u0639{\3\2\2\2\u063a\u063b\7\u0097\2\2\u063b"+
		"\u063c\5^\60\2\u063c}\3\2\2\2\u063d\u063f\7\u0083\2\2\u063e\u0640\t\6"+
		"\2\2\u063f\u063e\3\2\2\2\u063f\u0640\3\2\2\2\u0640\u0641\3\2\2\2\u0641"+
		"\u0646\5r:\2\u0642\u0643\7\7\2\2\u0643\u0645\5r:\2\u0644\u0642\3\2\2\2"+
		"\u0645\u0648\3\2\2\2\u0646\u0644\3\2\2\2\u0646\u0647\3\2\2\2\u0647\u064b"+
		"\3\2\2\2\u0648\u0646\3\2\2\2\u0649\u064a\7N\2\2\u064a\u064c\5v<\2\u064b"+
		"\u0649\3\2\2\2\u064b\u064c\3\2\2\2\u064c\u064e\3\2\2\2\u064d\u064f\5|"+
		"?\2\u064e\u064d\3\2\2\2\u064e\u064f\3\2\2\2\u064f\u065e\3\2\2\2\u0650"+
		"\u0651\7Q\2\2\u0651\u0652\7*\2\2\u0652\u0657\5^\60\2\u0653\u0654\7\7\2"+
		"\2\u0654\u0656\5^\60\2\u0655\u0653\3\2\2\2\u0656\u0659\3\2\2\2\u0657\u0655"+
		"\3\2\2\2\u0657\u0658\3\2\2\2\u0658\u065c\3\2\2\2\u0659\u0657\3\2\2\2\u065a"+
		"\u065b\7R\2\2\u065b\u065d\5^\60\2\u065c\u065a\3\2\2\2\u065c\u065d\3\2"+
		"\2\2\u065d\u065f\3\2\2\2\u065e\u0650\3\2\2\2\u065e\u065f\3\2\2\2\u065f"+
		"\u067d\3\2\2\2\u0660\u0661\7\u0093\2\2\u0661\u0662\7\5\2\2\u0662\u0667"+
		"\5^\60\2\u0663\u0664\7\7\2\2\u0664\u0666\5^\60\2\u0665\u0663\3\2\2\2\u0666"+
		"\u0669\3\2\2\2\u0667\u0665\3\2\2\2\u0667\u0668\3\2\2\2\u0668\u066a\3\2"+
		"\2\2\u0669\u0667\3\2\2\2\u066a\u0679\7\6\2\2\u066b\u066c\7\7\2\2\u066c"+
		"\u066d\7\5\2\2\u066d\u0672\5^\60\2\u066e\u066f\7\7\2\2\u066f\u0671\5^"+
		"\60\2\u0670\u066e\3\2\2\2\u0671\u0674\3\2\2\2\u0672\u0670\3\2\2\2\u0672"+
		"\u0673\3\2\2\2\u0673\u0675\3\2\2\2\u0674\u0672\3\2\2\2\u0675\u0676\7\6"+
		"\2\2\u0676\u0678\3\2\2\2\u0677\u066b\3\2\2\2\u0678\u067b\3\2\2\2\u0679"+
		"\u0677\3\2\2\2\u0679\u067a\3\2\2\2\u067a\u067d\3\2\2\2\u067b\u0679\3\2"+
		"\2\2\u067c\u063d\3\2\2\2\u067c\u0660\3\2\2\2\u067d\177\3\2\2\2\u067e\u0684"+
		"\7\u008d\2\2\u067f\u0680\7\u008d\2\2\u0680\u0684\7\37\2\2\u0681\u0684"+
		"\7]\2\2\u0682\u0684\7G\2\2\u0683\u067e\3\2\2\2\u0683\u067f\3\2\2\2\u0683"+
		"\u0681\3\2\2\2\u0683\u0682\3\2\2\2\u0684\u0081\3\2\2\2\u0685\u0691\5\u0098"+
		"M\2\u0686\u0687\7\5\2\2\u0687\u068c\5\u009eP\2\u0688\u0689\7\7\2\2\u0689"+
		"\u068b\5\u009eP\2\u068a\u0688\3\2\2\2\u068b\u068e\3\2\2\2\u068c\u068a"+
		"\3\2\2\2\u068c\u068d\3\2\2\2\u068d\u068f\3\2\2\2\u068e\u068c\3\2\2\2\u068f"+
		"\u0690\7\6\2\2\u0690\u0692\3\2\2\2\u0691\u0686\3\2\2\2\u0691\u0692\3\2"+
		"\2\2\u0692\u0083\3\2\2\2\u0693\u0695\t\n\2\2\u0694\u0693\3\2\2\2\u0694"+
		"\u0695\3\2\2\2\u0695\u0696\3\2\2\2\u0696\u0697\7\u009b\2\2\u0697\u0085"+
		"\3\2\2\2\u0698\u0699\t\20\2\2\u0699\u0087\3\2\2\2\u069a\u069b\t\21\2\2"+
		"\u069b\u0089\3\2\2\2\u069c\u069d\7\u009d\2\2\u069d\u008b\3\2\2\2\u069e"+
		"\u06a1\5^\60\2\u069f\u06a1\5V,\2\u06a0\u069e\3\2\2\2\u06a0\u069f\3\2\2"+
		"\2\u06a1\u008d\3\2\2\2\u06a2\u06a3\t\22\2\2\u06a3\u008f\3\2\2\2\u06a4"+
		"\u06a5\t\23\2\2\u06a5\u0091\3\2\2\2\u06a6\u06a7\5\u00b4[\2\u06a7\u0093"+
		"\3\2\2\2\u06a8\u06a9\5\u00b4[\2\u06a9\u0095\3\2\2\2\u06aa\u06ab\5\u00b4"+
		"[\2\u06ab\u0097\3\2\2\2\u06ac\u06ad\5\u00b4[\2\u06ad\u0099\3\2\2\2\u06ae"+
		"\u06af\5\u00b4[\2\u06af\u009b\3\2\2\2\u06b0\u06b1\5\u00b4[\2\u06b1\u009d"+
		"\3\2\2\2\u06b2\u06b3\5\u00b4[\2\u06b3\u009f\3\2\2\2\u06b4\u06b5\5\u00b4"+
		"[\2\u06b5\u00a1\3\2\2\2\u06b6\u06b7\5\u00b4[\2\u06b7\u00a3\3\2\2\2\u06b8"+
		"\u06b9\5\u00b4[\2\u06b9\u00a5\3\2\2\2\u06ba\u06bb\5\u00b4[\2\u06bb\u00a7"+
		"\3\2\2\2\u06bc\u06bd\5\u00b4[\2\u06bd\u00a9\3\2\2\2\u06be\u06bf\5\u00b4"+
		"[\2\u06bf\u00ab\3\2\2\2\u06c0\u06c1\5\u00b4[\2\u06c1\u00ad\3\2\2\2\u06c2"+
		"\u06c3\5\u00b4[\2\u06c3\u00af\3\2\2\2\u06c4\u06c5\5\u00b4[\2\u06c5\u00b1"+
		"\3\2\2\2\u06c6\u06c7\5\u00b4[\2\u06c7\u00b3\3\2\2\2\u06c8\u06d0\7\u009a"+
		"\2\2\u06c9\u06d0\5\u0090I\2\u06ca\u06d0\7\u009d\2\2\u06cb\u06cc\7\5\2"+
		"\2\u06cc\u06cd\5\u00b4[\2\u06cd\u06ce\7\6\2\2\u06ce\u06d0\3\2\2\2\u06cf"+
		"\u06c8\3\2\2\2\u06cf\u06c9\3\2\2\2\u06cf\u06ca\3\2\2\2\u06cf\u06cb\3\2"+
		"\2\2\u06d0\u00b5\3\2\2\2\u00f2\u00b8\u00ba\u00c5\u00cc\u00d1\u00d7\u00dd"+
		"\u00df\u0104\u010b\u0113\u0116\u011f\u0123\u012b\u012f\u0131\u0136\u0138"+
		"\u013c\u0143\u0146\u014b\u014f\u0154\u015d\u0160\u0166\u0168\u016c\u0172"+
		"\u0177\u0182\u0187\u018b\u0191\u0196\u019f\u01a6\u01ac\u01b0\u01b8\u01be"+
		"\u01c3\u01ca\u01d5\u01d8\u01da\u01e0\u01e6\u01ea\u01f1\u01f7\u01fd\u0203"+
		"\u0208\u0214\u0219\u0224\u0229\u022c\u0232\u0235\u023b\u0244\u0247\u024d"+
		"\u024f\u0253\u025b\u0260\u0268\u026d\u0279\u027e\u0286\u028b\u0291\u0298"+
		"\u029b\u02a3\u02ad\u02b0\u02b6\u02b8\u02bb\u02ce\u02d4\u02dd\u02e2\u02ea"+
		"\u02f0\u02f8\u0301\u030a\u0311\u0315\u0317\u031b\u0322\u0324\u0328\u032b"+
		"\u0332\u0339\u033c\u0346\u0349\u034f\u0351\u0355\u035c\u035f\u0367\u0371"+
		"\u0374\u037a\u037c\u0380\u0387\u038c\u038f\u0398\u039d\u039f\u03a8\u03b3"+
		"\u03ba\u03bd\u03c4\u03cb\u03d4\u03e1\u03ea\u03ee\u03f1\u03fe\u040c\u0410"+
		"\u0419\u041c\u0422\u0424\u042e\u0433\u0441\u0445\u044a\u044e\u0451\u0463"+
		"\u0468\u046d\u0475\u047a\u0483\u048a\u048e\u049e\u04a1\u04a9\u04b2\u04b6"+
		"\u04bb\u04d9\u04e5\u04ea\u04f6\u04fc\u0503\u0507\u0511\u0514\u051a\u051d"+
		"\u051f\u0521\u052c\u0531\u053d\u0541\u0545\u0549\u0550\u0552\u055a\u0561"+
		"\u0564\u0568\u056d\u0575\u0588\u058e\u0592\u05a2\u05a8\u05b0\u05b5\u05b8"+
		"\u05bd\u05c6\u05cb\u05d9\u05dc\u05de\u05e3\u05e7\u05ea\u05f1\u05f9\u05fd"+
		"\u0601\u0604\u060a\u060d\u060f\u0618\u061d\u0621\u0625\u0628\u0633\u0638"+
		"\u063f\u0646\u064b\u064e\u0657\u065c\u065e\u0667\u0672\u0679\u067c\u0683"+
		"\u068c\u0691\u0694\u06a0\u06cf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}