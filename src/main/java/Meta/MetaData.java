package Meta;

import disk.Column;
import disk.Database;
import disk.Table;

import java.io.IOException;

public class MetaData {
    /**
     * check if the database exists
     * @param name name of the database
     */
    public static boolean databaseExistence(String name)throws IOException {
        Database.checkSystemLoaded();
        return Database.databaseExistence(name);
    }

    /**
     * get database by database name
     * @param name name of database
     */
    public static Database getDatabaseByName(String name)throws IOException{
        if(!databaseExistence(name))
            return null;
        return Database.loadDataBase(name);
    }


    /**
     * check if the table exists
     * @param databaseName name of the database which the table belongs to
     * @param tableName name of the table
     */
    public static boolean tableExistence(String databaseName,String tableName)throws IOException{
        if(!databaseExistence(databaseName))
            return false;

        Database database =  Database.loadDataBase(databaseName);


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
        Database database =  Database.loadDataBase(databaseName);
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

        Database database = Database.loadDataBase(databaseName);


        Table table = database.tables.get(tableName);
        Column[] columns = table.info.columns;
        for(Column ele : columns)
            if(ele.columnName.equals(columnName))
                return true;
        return false;
    }



}
