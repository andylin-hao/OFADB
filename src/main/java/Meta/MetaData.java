package Meta;

import com.sun.org.apache.xpath.internal.operations.Bool;
import disk.*;
import index.IndexKey;
import index.NodeLeaf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MetaData {
    /**
     * check if the database exists
     * @param name name of the database
     */
    public static boolean databaseExistence(String name)throws IOException {
        return FileSystem.databaseExistence(name);
    }

    /**
     * get database by database name
     * @param name name of database
     */
    public static DatabaseInfo getDatabaseByName(String name)throws IOException{
        if(!databaseExistence(name))
            return null;
        return new DatabaseInfo(FileSystem.loadDataBase(name));
    }


    /**
     * check if the table exists
     * @param databaseName name of the database which the table belongs to
     * @param tableName name of the table
     */
    public static boolean tableExistence(String databaseName,String tableName)throws IOException{
        if(!databaseExistence(databaseName))
            return false;

        Database database =  FileSystem.loadDataBase(databaseName);


        return database.tables.containsKey(tableName);
    }

    /**
     * get the metadata of the table
     * @param databaseName name of the database which the table belongs to
     * @param tableName name of the table
     */
    public static TableInfo getTableInfoByName(String databaseName,String tableName)throws IOException {
        if(!tableExistence(databaseName,tableName))
            return null;
        Database database =  FileSystem.loadDataBase(databaseName);
        return database.tables.get(tableName).info;
    }


    /**
     * check if the column exists
     * @param databaseName name of the database which the table belongs to
     * @param tableName name of the table to be checked
     * @param columnName name of the column
     */
    public static boolean columnExistence(String databaseName,String tableName,String columnName)throws IOException{
        if(!databaseExistence(databaseName) || ! tableExistence(databaseName,tableName))
            return false;

        Database database = FileSystem.loadDataBase(databaseName);


        Table table = database.tables.get(tableName);
        Column[] columns = table.info.columns;
        for(Column ele : columns)
            if(ele.columnName.equals(columnName))
                return true;
        return false;
    }


    public static Column getColumnType(String databaseName,String tableName,String columnName)throws IOException{
        if(!databaseExistence(databaseName) || ! tableExistence(databaseName,tableName))
            return null;

        Database database = FileSystem.loadDataBase(databaseName);


        Table table = database.tables.get(tableName);
        Column[] columns = table.info.columns;
        for(Column ele : columns)
            if(ele.columnName.equals(columnName))
                return ele;
        return null;
    }


    public static List<IndexInfo> getIndexesInfo(String databaseName,String tableName)throws IOException{
        Table tables = FileSystem.getTablesTable();
        Table indexes = FileSystem.getIndexesTable();

        Type[] types = new Type[indexes.indexes.get(0).info.columnIndex.length];
        Object[] data = new Object[indexes.indexes.get(0).info.columnIndex.length];
        data[0] = databaseName;
        data[1] = tableName;

        List<IndexInfo> infos = new ArrayList<>();
        List<Row> rows = indexes.equivalenceFind(0,new IndexKey(types,data));
        for(int i = 0;i<rows.size();i++)
            infos.add(new IndexInfo((String) rows.get(i).rowData[2],(Boolean) rows.get(i).rowData[3]));
        return infos;
    }
}
