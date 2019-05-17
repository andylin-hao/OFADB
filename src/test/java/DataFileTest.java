import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import DBDisk.*;
import IO.*;
import Index.*;

public class DataFileTest {
    public static Database database;
    public static void main(String[] args)throws IOException {
        Database.loadSystem();
        Database.createNewDatabase("heyhey");
        Database hey = new Database("heyhey",false);
        hey.loadTables();
//        Object[] data = new Object[2];
//        data[0] = 3;
//        data[1] = "DataFileTest";
//        List<Row> reuslt = hey.tables.get("test1").equivalenceFind(0,hey.tables.get("test1").indexs.get(0).getIndexAccessor(data));
        return;

    }
    private static void BPlusTreeTest() throws IOException{
//            testInsertAndDelete();
//            testTraversing();
//        testIndex();

    }



    private static void testRowIO() throws IOException{
        System.out.println("DataFileTest :rowIO");
        testRowIOWithoutNull();
        testRowIOWithNullField();
        System.out.println("state: OK");
    }

    private static void testRowIOWithoutNull() throws IOException{

        Type[] types = basicTypesData();
        Object[] data = basicRowData();
        Table table = new Table(database,basicColumn(types),"test",null);
        Row a = new Row(table,data);
        byte[] b = RowIO.writeRowData(types,data);
        Row c = new Row(table,b);
        for(int i = 0;i<data.length;i++){
            if(!data[i].equals(c.rowData[i]))
                throw new Error("baisc rowIO has something wrong");
        }

        return;
    }

    private static void testRowIOWithNullField() throws IOException{
        Type[] types = basicTypesData();
        for(int j = 0;j<types.length;j++) {

            Object[] data = basicRowData();
            data[j] = null;
            Table table = new Table(database,basicColumn(types),"test",null);
            Row a = new Row(table, data);
            byte[] b = RowIO.writeRowData(types, data);
            Row c = new Row(table, b);
            for (int i = 0; i < data.length; i++) {
                if (data[i] != null) {
                    if (!data[i].equals(c.rowData[i]))
                        throw new Error("rowIO has something wrong with typeCode:" + (types[i].typeCode));
                } else {
                    if (c.rowData[i] != null)
                        throw new Error("rowIO has something wrong" + (types[i].typeCode));
                }
            }
        }
        return;

    }

    private static Object[] basicRowData(){
        Object[] data = new Object[8];
        Type[] types = new Type[8];
        //int
        data[0] = 1;
        //String
        data[1] = "test";
        //Double
        data[2] = 1.2;
        //char
        data[3] = 'a';
        //boolean
        data[4] = false;
        //smallInt
        data[5] = (short)45;
        //long
        data[6] = (long)45;
        //float
        data[7] = (float)1.2;

        return data;
    }

    private static Type[] basicTypesData(){
        Type[] types = new Type[8];
        //int
        types[0] = new Type(Types.SQL_INTEGER);
        //String
        types[1] = new Type(Types.SQL_VARCHAR,8);
        //Double

        types[2] = new Type(Types.SQL_DOUBLE);
        //char

        types[3] = new Type(Types.SQL_CHAR);
        //boolean

        types[4] = new Type(Types.SQL_BOOLEAN);
        //smallInt

        types[5] = new Type(Types.SQL_SMALLINT);
        //long

        types[6] = new Type(Types.SQL_LONG);
        //float

        types[7] = new Type(Types.SQL_FLOAT);

        return types;
    }

    public static Column[] basicColumn(Type[] types){
        Column[] columns = new Column[types.length];
        for(int i = 0;i<types.length;i++){
            columns[i] = (new Column(types[i],"test" + (char)(i + 'a'),false));
        }
        columns[0].hasIndex = true;
        return columns;
    }

    private static void testBlockIO() throws IOException{
        testEmtpyBlockIO();
        testBlockSingleInsert();
        testBLockMiddleDelete();
        testBLockEmptyDelete();
        testBLockOneDelete();
        testBLockLastDelete();
        testBLockEqualUpdate();
        testBLockLQUpdate();
        testBLockGQUpdate();
        return;
    }

    private static void testEmtpyBlockIO() throws IOException{
        Type[] types = basicTypesData();
        Table table = new Table(database,basicColumn(types),"test",null);
        BlockIO a = new BlockIO(table,128,0);
        byte[] buf = a.content;
        BlockIO b = new BlockIO(table,buf,0);
        if(!a.emptyRecord.equals(b.emptyRecord)
                || (a.blockSize != b.blockSize)
                || (a.emptySize != b.emptySize)
                || (a.emptyPointer != b.emptyPointer)
                || a.rowNum != b.rowNum
        )
            throw new Error("emtpy block IO wrong");
        return;
    }

    private static void testBlockSingleInsert()throws IOException{
        Type[] types = basicTypesData();
        Table table = new Table(database,basicColumn(types),"test",null);
        BlockIO a = new BlockIO(table,128,0);
        byte[] originData = RowIO.writeRowData(basicTypesData(),basicRowData());
        int index = a.insert(originData).rowIndex;
        int index1 = a.insert(originData).rowIndex;
        BlockIO b = new BlockIO(table,a.content,0);
        byte[] data = b.readRowData(index);
        byte[] data2 = b.readRowData(index1);
        if(data.length != originData.length || data2.length != originData.length)
            throw new Error("block insert wrong");
        for(int i = 0;i<data.length;i++)
            if(data[i] != originData[i] || data2[i] != originData[i])
                throw new Error("block insert wrong");
        return ;
    }

    private static void testBLockMiddleDelete()throws IOException{
        Type[] types = basicTypesData();
        Table table = new Table(database,basicColumn(types),"test",null);
        BlockIO a = new BlockIO(table,512,0);
        byte[] originData = RowIO.writeRowData(basicTypesData(),basicRowData());
        int index = a.insert(originData).rowIndex;
        int index1 = a.insert(originData).rowIndex;
        int index2 = a.insert(originData).rowIndex;
        a.delete(index1);
        BlockIO b = new BlockIO(table,a.content,0);
        if(!b.emptyRecord.get(index1) || b.rowNum != a.rowNum)
            throw new Error("block delete wrong:block meta wrong");
        if(b.readRowData(index1) != null)
            throw new Error("block delete wrong:get null data wrong");
        byte[] data2 = b.readRowData(index2);
        for(int i = 0;i<data2.length;i++)
            if( data2[i] != originData[i])
                throw new Error("block delete wrong:other data wrong");
        return;
    }

    private static void testBLockLastDelete()throws IOException{
        Type[] types = basicTypesData();
        Table table = new Table(database,basicColumn(types),"test",null);
        BlockIO a = new BlockIO(table,512,0);
        byte[] originData = RowIO.writeRowData(basicTypesData(),basicRowData());
        int index = a.insert(originData).rowIndex;
        int index1 = a.insert(originData).rowIndex;
        int index2 = a.insert(originData).rowIndex;
        a.delete(index2);
        BlockIO b = new BlockIO(table,a.content,0);
        if(b.rowNum != a.rowNum)
            throw new Error("block delete wrong:block meta wrong");
        if(b.readRowData(index2) != null)
            throw new Error("block delete wrong:get null data wrong");
        byte[] data = b.readRowData(index1);
        byte[] data2 = b.readRowData(index);
        for(int i = 0;i<data2.length;i++)
            if( data2[i] != originData[i] || data[i] != originData[i])
                throw new Error("block delete wrong:other data wrong");
        return;
    }

    private static void testBLockEmptyDelete()throws IOException{
        Type[] types = basicTypesData();
        Table table = new Table(database,basicColumn(types),"test",null);
        BlockIO a = new BlockIO(table,512,0);
        a.delete(28);
        return;
    }

    private static void testBLockOneDelete()throws IOException{
        Type[] types = basicTypesData();
        Table table = new Table(database,basicColumn(types),"test",null);
        BlockIO a = new BlockIO(table,512,0);
        byte[] originData = RowIO.writeRowData(basicTypesData(),basicRowData());
        int index = a.insert(originData).rowIndex;
        a.delete(index);
        BlockIO b = new BlockIO(table,512,0);
        if(a.emptyPointer != b.emptyPointer
                || a.emptySize != b.emptySize
                || a.rowNum != b.rowNum
        )
            throw new Error("block with one row delete wrong");
        return;
    }

    private static void testBLockEqualUpdate()throws IOException{
        Type[] types = basicTypesData();
        Table table = new Table(database,basicColumn(types),"test",null);
        BlockIO a = new BlockIO(table,512,0);
        byte[] originData = RowIO.writeRowData(basicTypesData(),basicRowData());
        int index = a.insert(originData).rowIndex;
        a.update(index,originData);
         BlockIO b = new BlockIO(table,a.content,0);
        if(a.emptyPointer != b.emptyPointer
                || a.emptySize != b.emptySize
                || a.rowNum != b.rowNum
        )
            throw new Error("block equal update wrong");
        byte[] data1 = a.readRowData(index);
        byte[] data2 = b.readRowData(index);
        for(int i = 0;i<data1.length;i++)
            if(data1[i] != data2[i])
                throw new Error("block equal update wrong");
        return;
    }

    private static void testBLockLQUpdate()throws IOException{
        Type[] types = basicTypesData();
        Table table = new Table(database,basicColumn(types),"test",null);
        BlockIO a = new BlockIO(table,512,0);
        byte[] originData = RowIO.writeRowData(basicTypesData(),basicRowData());
        byte[] LQdata = new byte[originData.length/2];
        System.arraycopy(originData,0,LQdata,0,LQdata.length);
        int index = a.insert(originData).rowIndex;
        int index2 = a.insert(originData).rowIndex;
        a.update(index,LQdata);
        BlockIO b = new BlockIO(table,a.content,0);
        if(a.emptyPointer != b.emptyPointer
                || a.emptySize != b.emptySize
                || a.rowNum != b.rowNum
        )
            throw new Error("block equal update wrong");
        byte[] data1 = b.readRowData(index);
        byte[] data2 = b.readRowData(index2);
        for(int i = 0;i<data1.length;i++)
            if(data1[i] != LQdata[i])
                throw new Error("block equal update wrong");
        for(int i = 0;i<data2.length;i++)
            if(data2[i] != originData[i])
                throw new Error("block equal update wrong");
        return;
    }

    private static void testBLockGQUpdate()throws IOException{
        Type[] types = basicTypesData();
        Table table = new Table(database,basicColumn(types),"test",null);
        BlockIO a = new BlockIO(table,512,0);
        byte[] originData = RowIO.writeRowData(basicTypesData(),basicRowData());
        byte[] LQdata = new byte[originData.length*2];
        System.arraycopy(originData,0,LQdata,0,originData.length);
        System.arraycopy(originData,0,LQdata,originData.length,originData.length);
        int index = a.insert(originData).rowIndex;
        int index2 = a.insert(originData).rowIndex;
        a.update(index,LQdata);
        BlockIO b = new BlockIO(table,a.content,0);
        if(a.emptyPointer != b.emptyPointer
                || a.emptySize != b.emptySize
                || a.rowNum != b.rowNum
        )
            throw new Error("block equal update wrong");
        byte[] data1 = b.readRowData(index);
        byte[] data2 = b.readRowData(index2);
        for(int i = 0;i<data1.length;i++)
            if(data1[i] != LQdata[i])
                throw new Error("block equal update wrong");
        for(int i = 0;i<data2.length;i++)
            if(data2[i] != originData[i])
                throw new Error("block equal update wrong");
        return;
    }

    private static  void  testFixedIndex() throws IOException {
        int testSize = 1000;
        for(int i =0;i<20;i++) {


            List<Integer> insertList = prepareInsertList(testSize,i);
            for(int j = 0;j<testSize;j++){
                System.out.print(insertList.get(j));
                System.out.print(',');
            }
            System.out.println();
            createIndex(insertList);
            compareTest(insertList);

            System.out.println(i);
            File file1 = new File("index.txt");
            File file2 = new File("index2.txt");
            if(file1.delete() == false)
                throw  new Error("delete file failed");
            if(file2.delete() == false)
                throw  new Error("delete file failed");
        }
        return;
    }

    static void compareTest(List<Integer> insertList) throws IOException{
        File testIndex = new File("index.txt");
        Type[] types = new Type[1];
        types[0] = new Type(Types.SQL_INTEGER);
        IndexBase index = new IndexBase(null,3,new int[1],testIndex,types);

        File testIndex2 = new File("index2.txt");
        IndexBase index2 = new IndexBase(null,3,new int[1],testIndex2,types);

        int testSize = insertList.size();

        for(int i = 0;i<testSize;i++) {
            Object[] objects = new Object[1];
            objects[0] = insertList.get(i);
            index2.insert(new IndexKey(types,objects), new Row(null, i + 1, i + 1));

        }
        if(!NodeIndex.equal((NodeIndex) index.root,(NodeIndex) index2.root))
            throw new Error("test");

        Random random = new Random(10000);
        for(int i = 0;i<testSize;i++){
            int repeatTime = random.nextInt(3);
            for(int j = 0;j<repeatTime;j++){
                Object[] a = new Object[1];
                a[0] = insertList.get(i);
                index.insert(new IndexKey(types,a),new Row(null,i+1,i+1));
                index2.insert(new IndexKey(types,a),new Row(null,i+1,i+1));
                index.indexChange.saveChange();
                index.indexChange.fileIO.file.close();
                File reload = index.fileIO.info;
                index = new IndexBase(null,3,new int[1],reload,types);
                if(!NodeIndex.equal((NodeIndex) index.root,(NodeIndex) index2.root))
                    throw new Error("test");
            }
        }


        for(int i = 0;i<testSize;i++){
            Object[] objects = new Object[1];
            objects[0] = insertList.get(i);
            IndexKey indexKey = new IndexKey(types,objects);
            index.remove(indexKey,new Row(null,i+1,i+1));
            index.indexChange.saveChange();
            index.fileIO.file.close();
            File reload = index.fileIO.info;
            index = new IndexBase(null,3,new int[1],reload,types);
            index2.remove(indexKey,new Row(null,i+1,i+1));
            if(!NodeIndex.equal((NodeIndex) index.root,(NodeIndex) index2.root))
                throw new Error("test");

        }
        index.fileIO.file.close();
        index2.fileIO.file.close();
    }

    static  void createIndex(List<Integer> insertList)throws IOException{

        File testIndex = new File("index.txt");
        Type[] types = new Type[1];
        types[0] = new Type(Types.SQL_INTEGER);
        IndexBase index = new IndexBase(null,3,new int[1],testIndex,types);
        for(int i = 0;i<insertList.size();i++) {
            Object[] a = new Object[1];
            a[0] = insertList.get(i);
            index.insert(new IndexKey(types,a), new Row(null, i + 1, i + 1));
        }
        index.indexChange.saveChange();
        index.fileIO.file.close();
    }

    static List<Integer> prepareInsertList(int size,int seed){
        List<Integer> insertList = new ArrayList<>();
        Random random = new Random(10000*seed);
        ArrayList<Integer> s = new ArrayList<>();
        for(int i = 0;i<size;i++)
        {
            int rand = random.nextInt(10000);
            if(insertList.contains(rand)) {
                i--;
                continue;
            }
//            rand = a[i];
            insertList.add(rand);
        }
        return insertList;
    }

    private static  void  testStringIndex() throws IOException {
        int testSize = 1000;
        for(int i =0;i<20;i++) {


            List<Integer> insertList = prepareInsertList(testSize,i);
            for(int j = 0;j<testSize;j++){
                System.out.print(insertList.get(j));
                System.out.print(',');
            }
            System.out.println();
            createStringIndex(insertList);
            compareTest_String(insertList);

            System.out.println(i);
            File file1 = new File("index.txt");
            File file2 = new File("index2.txt");
            if(file1.delete() == false)
                throw  new Error("delete file failed");
            if(file2.delete() == false)
                throw  new Error("delete file failed");
        }
        return;
    }

    static void compareTest_String(List<Integer> insertList) throws IOException{
        Type[] types = new Type[1];
        types[0] = new Type(Types.SQL_VARCHAR,10);
        File testIndex = new File("index.txt");
        IndexBase index = new IndexBase(null,3,new int[1],testIndex,types);

        File testIndex2 = new File("index2.txt");
        IndexBase index2 = new IndexBase(null,3,new int[1],testIndex2,types);

        int testSize = insertList.size();

        for(int i = 0;i<testSize;i++) {
            Object[] objects = new Object[1];
            objects[0] = insertList.get(i).toString();
            index2.insert(new IndexKey(types,objects), new Row(null, i + 1, i + 1));
        }
        if(!NodeIndex.equal((NodeIndex) index.root,(NodeIndex) index2.root))
            throw new Error("test");

        Random random = new Random(10000);
        for(int i = 0;i<testSize;i++){
            int repeatTime = random.nextInt(3);
            for(int j = 0;j<repeatTime;j++){
                Object[] objects = new Object[1];
                objects[0] = insertList.get(i).toString();
                IndexKey indexKey = new IndexKey(types,objects);
                index.insert(indexKey,new Row(null,i+1,i+1));
                index2.insert(indexKey,new Row(null,i+1,i+1));
                index.indexChange.saveChange();
                index.indexChange.fileIO.file.close();
                File reload = index.fileIO.info;
                index = new IndexBase(null,3,new int[1],reload,types);
                if(!NodeIndex.equal((NodeIndex) index.root,(NodeIndex) index2.root))
                    throw new Error("test");
            }
        }


        for(int i = 0;i<testSize;i++){
            Object[] objects = new Object[1];
            objects[0] = insertList.get(i).toString();
            IndexKey indexKey = new IndexKey(types,objects);
            index.remove(indexKey,new Row(null,i+1,i+1));
            index.indexChange.saveChange();
            index.fileIO.file.close();
            File reload = index.fileIO.info;
            index = new IndexBase(null,3,new int[1],reload,types);
            index2.remove(indexKey,new Row(null,i+1,i+1));
            if(!NodeIndex.equal((NodeIndex) index.root,(NodeIndex) index2.root))
                throw new Error("test");

        }
        index.fileIO.file.close();
        index2.fileIO.file.close();
    }

    static  void createStringIndex(List<Integer> insertList)throws IOException{

        File testIndex = new File("index.txt");
        Type[] types = new Type[1];
        types[0] = new Type(Types.SQL_VARCHAR,10);
        IndexBase index = new IndexBase(null,3,new int[1],testIndex,types);
        for(int i = 0;i<insertList.size();i++) {
            Object[] objects = new Object[1];
            objects[0] = String.valueOf(insertList.get(i));
            index.insert(new IndexKey(types,objects), new Row(null, i + 1, i + 1));
        }
            index.indexChange.saveChange();
        index.fileIO.file.close();
    }

}
