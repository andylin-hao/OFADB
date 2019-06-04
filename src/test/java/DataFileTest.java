import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import disk.System;
import disk.*;
import engine.Engine;
import engine.QueryEngine;
import expression.Expression;
import expression.select.SelectExpr;
import index.*;
import meta.ColumnInfo;
import meta.IndexInfo;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.SQLParser;
import parser.SQLiteLexer;
import parser.SQLiteParser;
import result.QueryResult;
import result.Result;
import result.SingleResult;
import types.ColumnTypes;

import javax.print.attribute.standard.NumberUp;

public class DataFileTest {

    static Expression getParseResult(String sql) throws IOException {
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

    public static void main(String[] args) throws IOException {

//        System.loadSystem();
//        System.createNewDatabase("testbase");
//        System.loadDataBase("testbase");
//        Database database = System.getCurDB();
//        Table table = database.getTable("tt2");
//        Object[] data = new Object[2];
//        data[0] = 4;
//        data[1] = "5";
//        table.insert(data);
//        table.save();

        String sql_subSelect = "select t.name1,tt2.name from (select id as id1, name as name1 from tt2) t, tt2 where t.id1 = (5*8)/10 or t.name1 = '5'";
        String sql_simplest = "select * from tt2";
        String sql_where = "select * from tt2 where id = 6-(4-2) and name = '5'";
        String sql_createDatabase = "create database testbase";
        Result result = Engine.expressionExec(sql_createDatabase);
//        String[] names = ((QueryResult)result).getColumnName();
//        while(((QueryResult)result).hasNext()){
//            Object[] data = ((QueryResult)result).next();
//            int a = 1;
//        }
//        SingleResult data = ((QueryResult)result).getValue("3");
        int a = 1;

//                System.removeDatabase(database);
//        database.removeTable(database.tables.get("tt2"));

//        database.loadTables();
//        Object[] d = new Object[2];
//        d[0] = 1;
//        d[1] = "test1";
//        database.tables.get("tt1").insert(d);



//        ColumnInfo[] columns = new ColumnInfo[2];
//        columns[0] = new ColumnInfo("id",Type.intType(),false,false,0);
//        columns[1] = new ColumnInfo("name",Type.stringType(20),false,false,0);
////        columns[2] = new ColumnInfo("age",Type.longType(),false,false,0);
//        database.createNewTable("tt2",columns,new ArrayList<IndexInfo>(){{add(new IndexInfo("0",true));add(new IndexInfo("1",false));}},0);

//        Object[] data = new Object[3];
//        data[0] = 2;
//        data[1] = "jack";
//        data[2] = Long.parseLong("7");
////        database.tables.get("tt2").delete(0,database.tables.get("tt2").indexes.get(0).getIndexAccessor(data));
//        database.tables.get("tt2").insert(data);



        //        Database.loadSystem();
//        Database.createNewDatabase("heyhey");
//        Database hey = new Database("heyhey", false);
//        hey.loadTables();
//        Object[] data = new Object[2];
//        data[0] = 3;
//        data[1] = "DataFileTest";
//        List<Row> result = hey.tables.get("test1").equivalenceFind(0,hey.tables.get("test1").indexes.get(0).getIndexAccessor(data));
    }

    private static void BPlusTreeTest() {
//        testInsertAndDelete();
//        testTraversing();
//        testIndex();
    }


//    private static void testRowIO() throws IOException {
//        System.out.println("DataFileTest :rowIO");
//        testRowIOWithoutNull();
//        testRowIOWithNullField();
//        System.out.println("state: OK");
//    }
//
//    private static void testRowIOWithoutNull() throws IOException {
//
//        Type[] types = basicTypesData();
//        Object[] data = basicRowData();
//        Table table = new Table(database, basicColumn(types), "test", null);
//        Row a = new Row(table, data);
//        byte[] b = RowIO.writeRowData(types, data);
//        Row c = new Row(table, b);
//        for (int i = 0; i < data.length; i++) {
//            if (!data[i].equals(c.rowData[i]))
//                throw new RuntimeException("baisc rowIO has something wrong");
//        }
//    }
//
//    private static void testRowIOWithNullField() throws IOException {
//        Type[] types = basicTypesData();
//        for (int j = 0; j < types.length; j++) {
//
//            Object[] data = basicRowData();
//            data[j] = null;
//            Table table = new Table(database, basicColumn(types), "test", null);
//            Row a = new Row(table, data);
//            byte[] b = RowIO.writeRowData(types, data);
//            Row c = new Row(table, b);
//            for (int i = 0; i < data.length; i++) {
//                if (data[i] != null) {
//                    if (!data[i].equals(c.rowData[i]))
//                        throw new RuntimeException("rowIO has something wrong with typeCode:" + (types[i].typeCode));
//                } else {
//                    if (c.rowData[i] != null)
//                        throw new RuntimeException("rowIO has something wrong" + (types[i].typeCode));
//                }
//            }
//        }
//    }
//
//    private static Object[] basicRowData() {
//        Object[] data = new Object[8];
//        Type[] types = new Type[8];
//        //int
//        data[0] = 1;
//        //String
//        data[1] = "test";
//        //Double
//        data[2] = 1.2;
//        //char
//        data[3] = 'a';
//        //boolean
//        data[4] = false;
//        //smallInt
//        data[5] = (short) 45;
//        //long
//        data[6] = (long) 45;
//        //float
//        data[7] = (float) 1.2;
//
//        return data;
//    }
//
//    private static Type[] basicTypesData() {
//        Type[] types = new Type[8];
//        //int
//        types[0] = new Type(ColumnTypes.COL_INT);
//        //String
//        types[1] = new Type(ColumnTypes.COL_VARCHAR, 8);
//        //Double
//
//        types[2] = new Type(ColumnTypes.COL_DOUBLE);
//        //char
//
//        types[3] = new Type(ColumnTypes.COL_CHAR);
//        //boolean
//
//        types[4] = new Type(ColumnTypes.COL_BOOL);
//        //smallInt
//
//        types[5] = new Type(ColumnTypes.COL_SHORT);
//        //long
//
//        types[6] = new Type(ColumnTypes.COL_LONG);
//        //float
//
//        types[7] = new Type(ColumnTypes.COL_FLOAT);
//
//        return types;
//    }
//
//    private static ColumnInfo[] basicColumn(Type[] types) {
//        ColumnInfo[] columns = new ColumnInfo[types.length];
//        for (int i = 0; i < types.length; i++) {
//            columns[i] = (new ColumnInfo(types[i], "test" + (char) (i + 'a')));
//        }
//        return columns;
//    }
//
//    private static void testBlockIO() throws IOException {
//        testEmtpyBlockIO();
//        testBlockSingleInsert();
//        testBLockMiddleDelete();
//        testBLockEmptyDelete();
//        testBLockOneDelete();
//        testBLockLastDelete();
//        testBLockEqualUpdate();
//        testBLockLQUpdate();
//        testBLockGQUpdate();
//    }
//
//    private static void testEmtpyBlockIO() throws IOException {
//        Type[] types = basicTypesData();
//        Table table = new Table(database, basicColumn(types), "test", null);
//        BlockIO a = new BlockIO(table, 128, 0);
//        byte[] buf = a.content;
//        BlockIO b = new BlockIO(table, buf, 0);
//        if (!a.emptyRecord.equals(b.emptyRecord)
//                || (a.blockSize != b.blockSize)
//                || (a.emptySize != b.emptySize)
//                || (a.emptyPointer != b.emptyPointer)
//                || a.rowNum != b.rowNum
//        )
//            throw new RuntimeException("emtpy block io wrong");
//    }
//
//    private static void testBlockSingleInsert() throws IOException {
//        Type[] types = basicTypesData();
//        Table table = new Table(database, basicColumn(types), "test", null);
//        BlockIO a = new BlockIO(table, 128, 0);
//        byte[] originData = RowIO.writeRowData(basicTypesData(), basicRowData());
//        int index = a.insert(originData).rowIndex;
//        int index1 = a.insert(originData).rowIndex;
//        BlockIO b = new BlockIO(table, a.content, 0);
//        byte[] data = b.readRowData(index);
//        byte[] data2 = b.readRowData(index1);
//        if (data.length != originData.length || data2.length != originData.length)
//            throw new RuntimeException("block insert wrong");
//        for (int i = 0; i < data.length; i++)
//            if (data[i] != originData[i] || data2[i] != originData[i])
//                throw new RuntimeException("block insert wrong");
//    }
//
//    private static void testBLockMiddleDelete() throws IOException {
//        Type[] types = basicTypesData();
//        Table table = new Table(database, basicColumn(types), "test", null);
//        BlockIO a = new BlockIO(table, 512, 0);
//        byte[] originData = RowIO.writeRowData(basicTypesData(), basicRowData());
//        int index = a.insert(originData).rowIndex;
//        int index1 = a.insert(originData).rowIndex;
//        int index2 = a.insert(originData).rowIndex;
//        a.delete(index1);
//        BlockIO b = new BlockIO(table, a.content, 0);
//        if (!b.emptyRecord.get(index1) || b.rowNum != a.rowNum)
//            throw new RuntimeException("block delete wrong:block meta wrong");
//        if (b.readRowData(index1) != null)
//            throw new RuntimeException("block delete wrong:get null data wrong");
//        byte[] data2 = b.readRowData(index2);
//        for (int i = 0; i < data2.length; i++)
//            if (data2[i] != originData[i])
//                throw new RuntimeException("block delete wrong:other data wrong");
//    }
//
//    private static void testBLockLastDelete() throws IOException {
//        Type[] types = basicTypesData();
//        Table table = new Table(database, basicColumn(types), "test", null);
//        BlockIO a = new BlockIO(table, 512, 0);
//        byte[] originData = RowIO.writeRowData(basicTypesData(), basicRowData());
//        int index = a.insert(originData).rowIndex;
//        int index1 = a.insert(originData).rowIndex;
//        int index2 = a.insert(originData).rowIndex;
//        a.delete(index2);
//        BlockIO b = new BlockIO(table, a.content, 0);
//        if (b.rowNum != a.rowNum)
//            throw new RuntimeException("block delete wrong:block meta wrong");
//        if (b.readRowData(index2) != null)
//            throw new RuntimeException("block delete wrong:get null data wrong");
//        byte[] data = b.readRowData(index1);
//        byte[] data2 = b.readRowData(index);
//        for (int i = 0; i < data2.length; i++)
//            if (data2[i] != originData[i] || data[i] != originData[i])
//                throw new RuntimeException("block delete wrong:other data wrong");
//    }
//
//    private static void testBLockEmptyDelete() throws IOException {
//        Type[] types = basicTypesData();
//        Table table = new Table(database, basicColumn(types), "test", null);
//        BlockIO a = new BlockIO(table, 512, 0);
//        a.delete(28);
//    }
//
//    private static void testBLockOneDelete() throws IOException {
//        Type[] types = basicTypesData();
//        Table table = new Table(database, basicColumn(types), "test", null);
//        BlockIO a = new BlockIO(table, 512, 0);
//        byte[] originData = RowIO.writeRowData(basicTypesData(), basicRowData());
//        int index = a.insert(originData).rowIndex;
//        a.delete(index);
//        BlockIO b = new BlockIO(table, 512, 0);
//        if (a.emptyPointer != b.emptyPointer
//                || a.emptySize != b.emptySize
//                || a.rowNum != b.rowNum
//        )
//            throw new RuntimeException("block with one row delete wrong");
//    }
//
//    private static void testBLockEqualUpdate() throws IOException {
//        Type[] types = basicTypesData();
//        Table table = new Table(database, basicColumn(types), "test", null);
//        BlockIO a = new BlockIO(table, 512, 0);
//        byte[] originData = RowIO.writeRowData(basicTypesData(), basicRowData());
//        int index = a.insert(originData).rowIndex;
//        a.update(index, originData);
//        BlockIO b = new BlockIO(table, a.content, 0);
//        if (a.emptyPointer != b.emptyPointer
//                || a.emptySize != b.emptySize
//                || a.rowNum != b.rowNum
//        )
//            throw new RuntimeException("block equal update wrong");
//        byte[] data1 = a.readRowData(index);
//        byte[] data2 = b.readRowData(index);
//        for (int i = 0; i < data1.length; i++)
//            if (data1[i] != data2[i])
//                throw new RuntimeException("block equal update wrong");
//    }
//
//    private static void testBLockLQUpdate() throws IOException {
//        Type[] types = basicTypesData();
//        Table table = new Table(database, basicColumn(types), "test", null);
//        BlockIO a = new BlockIO(table, 512, 0);
//        byte[] originData = RowIO.writeRowData(basicTypesData(), basicRowData());
//        byte[] LQdata = new byte[originData.length / 2];
//        System.arraycopy(originData, 0, LQdata, 0, LQdata.length);
//        int index = a.insert(originData).rowIndex;
//        int index2 = a.insert(originData).rowIndex;
//        a.update(index, LQdata);
//        BlockIO b = new BlockIO(table, a.content, 0);
//        if (a.emptyPointer != b.emptyPointer
//                || a.emptySize != b.emptySize
//                || a.rowNum != b.rowNum
//        )
//            throw new RuntimeException("block equal update wrong");
//        byte[] data1 = b.readRowData(index);
//        byte[] data2 = b.readRowData(index2);
//        for (int i = 0; i < data1.length; i++)
//            if (data1[i] != LQdata[i])
//                throw new RuntimeException("block equal update wrong");
//        for (int i = 0; i < data2.length; i++)
//            if (data2[i] != originData[i])
//                throw new RuntimeException("block equal update wrong");
//    }
//
//    private static void testBLockGQUpdate() throws IOException {
//        Type[] types = basicTypesData();
//        Table table = new Table(database, basicColumn(types), "test", null);
//        BlockIO a = new BlockIO(table, 512, 0);
//        byte[] originData = RowIO.writeRowData(basicTypesData(), basicRowData());
//        byte[] LQdata = new byte[originData.length * 2];
//        System.arraycopy(originData, 0, LQdata, 0, originData.length);
//        System.arraycopy(originData, 0, LQdata, originData.length, originData.length);
//        int index = a.insert(originData).rowIndex;
//        int index2 = a.insert(originData).rowIndex;
//        a.update(index, LQdata);
//        BlockIO b = new BlockIO(table, a.content, 0);
//        if (a.emptyPointer != b.emptyPointer
//                || a.emptySize != b.emptySize
//                || a.rowNum != b.rowNum
//        )
//            throw new RuntimeException("block equal update wrong");
//        byte[] data1 = b.readRowData(index);
//        byte[] data2 = b.readRowData(index2);
//        for (int i = 0; i < data1.length; i++)
//            if (data1[i] != LQdata[i])
//                throw new RuntimeException("block equal update wrong");
//        for (int i = 0; i < data2.length; i++)
//            if (data2[i] != originData[i])
//                throw new RuntimeException("block equal update wrong");
//    }

    private static void testFixedIndex() throws IOException {
        int testSize = 1000;
        for (int i = 0; i < 20; i++) {


            List<Integer> insertList = prepareInsertList(testSize, i);
            for (int j = 0; j < testSize; j++) {
                java.lang.System.out.print(insertList.get(j));
                java.lang.System.out.print(',');
            }
            java.lang.System.out.println();
            createIndex(insertList);
            compareTest(insertList);

            java.lang.System.out.println(i);
            File file1 = new File("index.txt");
            File file2 = new File("index2.txt");
            if (!file1.delete())
                throw new RuntimeException("delete file failed");
            if (!file2.delete())
                throw new RuntimeException("delete file failed");
        }
    }

    private static void compareTest(List<Integer> insertList) throws IOException {
        File testIndex = new File("index.txt");
        Type[] types = new Type[1];
        types[0] = new Type(ColumnTypes.COL_INT);
        IndexBase index = new IndexBase(null, 3, new int[1], testIndex, types,false);

        File testIndex2 = new File("index2.txt");
        IndexBase index2 = new IndexBase(null, 3, new int[1], testIndex2, types,false);

        int testSize = insertList.size();

        for (int i = 0; i < testSize; i++) {
            Object[] objects = new Object[1];
            objects[0] = insertList.get(i);
            index2.insert(new IndexKey(types, objects), new Row(null, i + 1, i + 1));

        }
        if (!NodeIndex.equal((NodeIndex) index.root, (NodeIndex) index2.root))
            throw new RuntimeException("test");

        Random random = new Random(10000);
        for (int i = 0; i < testSize; i++) {
            int repeatTime = random.nextInt(3);
            for (int j = 0; j < repeatTime; j++) {
                Object[] a = new Object[1];
                a[0] = insertList.get(i);
                index.insert(new IndexKey(types, a), new Row(null, i + 1, i + 1));
                index2.insert(new IndexKey(types, a), new Row(null, i + 1, i + 1));
                index.indexChange.saveChange();
                index.indexChange.fileIO.file.close();
                File reload = index.fileIO.info;
                index = new IndexBase(null, 3, new int[1], reload, types,false);
                if (!NodeIndex.equal((NodeIndex) index.root, (NodeIndex) index2.root))
                    throw new RuntimeException("test");
            }
        }


        for (int i = 0; i < testSize; i++) {
            Object[] objects = new Object[1];
            objects[0] = insertList.get(i);
            IndexKey indexKey = new IndexKey(types, objects);
            index.remove(indexKey, new Row(null, i + 1, i + 1));
            index.indexChange.saveChange();
            index.fileIO.file.close();
            File reload = index.fileIO.info;
            index = new IndexBase(null, 3, new int[1], reload, types,false);
            index2.remove(indexKey, new Row(null, i + 1, i + 1));
            if (!NodeIndex.equal((NodeIndex) index.root, (NodeIndex) index2.root))
                throw new RuntimeException("test");

        }
        index.fileIO.file.close();
        index2.fileIO.file.close();
    }

    private static void createIndex(List<Integer> insertList) throws IOException {

        File testIndex = new File("index.txt");
        Type[] types = new Type[1];
        types[0] = new Type(ColumnTypes.COL_INT);
        IndexBase index = new IndexBase(null, 3, new int[1], testIndex, types,false);
        for (int i = 0; i < insertList.size(); i++) {
            Object[] a = new Object[1];
            a[0] = insertList.get(i);
            index.insert(new IndexKey(types, a), new Row(null, i + 1, i + 1));
        }
        index.indexChange.saveChange();
        index.fileIO.file.close();
    }

    private static List<Integer> prepareInsertList(int size, int seed) {
        List<Integer> insertList = new ArrayList<>();
        Random random = new Random(10000 * seed);
        ArrayList<Integer> s = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int rand = random.nextInt(10000);
            if (insertList.contains(rand)) {
                i--;
                continue;
            }
//            rand = a[i];
            insertList.add(rand);
        }
        return insertList;
    }

    private static void testStringIndex() throws IOException {
        int testSize = 1000;
        for (int i = 0; i < 20; i++) {


            List<Integer> insertList = prepareInsertList(testSize, i);
            for (int j = 0; j < testSize; j++) {
                java.lang.System.out.print(insertList.get(j));
                java.lang.System.out.print(',');
            }
            java.lang.System.out.println();
            createStringIndex(insertList);
            compareTest_String(insertList);

            java.lang.System.out.println(i);
            File file1 = new File("index.txt");
            File file2 = new File("index2.txt");
            if (!file1.delete())
                throw new RuntimeException("delete file failed");
            if (!file2.delete())
                throw new RuntimeException("delete file failed");
        }
    }

    private static void compareTest_String(List<Integer> insertList) throws IOException {
        Type[] types = new Type[1];
        types[0] = new Type(ColumnTypes.COL_VARCHAR, 10);
        File testIndex = new File("index.txt");
        IndexBase index = new IndexBase(null, 3, new int[1], testIndex, types,false);

        File testIndex2 = new File("index2.txt");
        IndexBase index2 = new IndexBase(null, 3, new int[1], testIndex2, types,false);

        int testSize = insertList.size();

        for (int i = 0; i < testSize; i++) {
            Object[] objects = new Object[1];
            objects[0] = insertList.get(i).toString();
            index2.insert(new IndexKey(types, objects), new Row(null, i + 1, i + 1));
        }
        if (!NodeIndex.equal((NodeIndex) index.root, (NodeIndex) index2.root))
            throw new RuntimeException("test");

        Random random = new Random(10000);
        for (int i = 0; i < testSize; i++) {
            int repeatTime = random.nextInt(3);
            for (int j = 0; j < repeatTime; j++) {
                Object[] objects = new Object[1];
                objects[0] = insertList.get(i).toString();
                IndexKey indexKey = new IndexKey(types, objects);
                index.insert(indexKey, new Row(null, i + 1, i + 1));
                index2.insert(indexKey, new Row(null, i + 1, i + 1));
                index.indexChange.saveChange();
                index.indexChange.fileIO.file.close();
                File reload = index.fileIO.info;
                index = new IndexBase(null, 3, new int[1], reload, types,false);
                if (!NodeIndex.equal((NodeIndex) index.root, (NodeIndex) index2.root))
                    throw new RuntimeException("test");
            }
        }


        for (int i = 0; i < testSize; i++) {
            Object[] objects = new Object[1];
            objects[0] = insertList.get(i).toString();
            IndexKey indexKey = new IndexKey(types, objects);
            index.remove(indexKey, new Row(null, i + 1, i + 1));
            index.indexChange.saveChange();
            index.fileIO.file.close();
            File reload = index.fileIO.info;
            index = new IndexBase(null, 3, new int[1], reload, types,false);
            index2.remove(indexKey, new Row(null, i + 1, i + 1));
            if (!NodeIndex.equal((NodeIndex) index.root, (NodeIndex) index2.root))
                throw new RuntimeException("test");

        }
        index.fileIO.file.close();
        index2.fileIO.file.close();
    }

    private static void createStringIndex(List<Integer> insertList) throws IOException {

        File testIndex = new File("index.txt");
        Type[] types = new Type[1];
        types[0] = new Type(ColumnTypes.COL_VARCHAR, 10);
        IndexBase index = new IndexBase(null, 3, new int[1], testIndex, types,false);
        for (int i = 0; i < insertList.size(); i++) {
            Object[] objects = new Object[1];
            objects[0] = String.valueOf(insertList.get(i));
            index.insert(new IndexKey(types, objects), new Row(null, i + 1, i + 1));
        }
        index.indexChange.saveChange();
        index.fileIO.file.close();
    }

}
