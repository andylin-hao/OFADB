package meta;

import disk.*;
import disk.System;
import index.IndexKey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MetaData {
    /**
     * check if the database exists
     * @param name name of the database
     */
    public static boolean isDBNotExist(String name)throws IOException {
        return !System.isDBExist(name);
    }

    /**
     * get database by database name
     * @param name name of database
     */
    public static DatabaseInfo getDatabaseByName(String name)throws IOException{
        if(isDBNotExist(name))
            return null;
        return new DatabaseInfo(Objects.requireNonNull(System.loadDataBase(name)));
    }


    /**
     * check if the table exists
     * @param databaseName name of the database which the table belongs to
     * @param tableName name of the table
     */
    public static boolean istableNotExist(String databaseName, String tableName)throws IOException{
        if(isDBNotExist(databaseName))
            return true;

        Database database =  System.loadDataBase(databaseName);


        assert database != null;
        return !database.tables.containsKey(tableName);
    }

    /**
     * get the metadata of the table
     * @param databaseName name of the database which the table belongs to
     * @param tableName name of the table
     */
    public static TableInfo getTableInfoByName(String databaseName,String tableName)throws IOException {
        if(istableNotExist(databaseName, tableName))
            return null;
        Database database =  System.loadDataBase(databaseName);
        assert database != null;
        return database.tables.get(tableName).info;
    }


    /**
     * check if the column exists
     * @param databaseName name of the database which the table belongs to
     * @param tableName name of the table to be checked
     * @param columnName name of the column
     */
    public static boolean columnExistence(String databaseName,String tableName,String columnName)throws IOException{
        if(isDBNotExist(databaseName) || istableNotExist(databaseName, tableName))
            return false;

        Database database = System.loadDataBase(databaseName);


        assert database != null;
        Table table = database.tables.get(tableName);
        ColumnInfo[] columns = table.info.columns;
        for(ColumnInfo ele : columns)
            if(ele.columnName.equals(columnName))
                return true;
        return false;
    }


    public static ColumnInfo getColumnType(String databaseName, String tableName, String columnName)throws IOException{
        if(isDBNotExist(databaseName) || istableNotExist(databaseName, tableName))
            return null;

        Database database = System.loadDataBase(databaseName);


        assert database != null;
        Table table = database.tables.get(tableName);
        ColumnInfo[] columns = table.info.columns;
        for(ColumnInfo ele : columns)
            if(ele.columnName.equals(columnName))
                return ele;
        return null;
    }


    public static List<IndexInfo> getIndexesInfo(String databaseName,String tableName)throws IOException{
        Table tables = System.getTablesTable();
        Table indexes = System.getIndexesTable();

        Type[] types = new Type[indexes.indexes.get(0).info.columnIndex.length];
        Object[] data = new Object[indexes.indexes.get(0).info.columnIndex.length];
        data[0] = databaseName;
        data[1] = tableName;

        List<IndexInfo> infos = new ArrayList<>();
        List<Row> rows = indexes.equivalenceFind(0,new IndexKey(types,data));
        for (Row row : rows) infos.add(new IndexInfo((String) row.rowData[2], (Boolean) row.rowData[3]));
        return infos;
    }
}
