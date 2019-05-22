package disk;

import index.IndexKey;
import meta.IndexInfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class System {
    private static Database System;

    public System()throws IOException{
        disk.System.loadSystem();
    }

    public static Database getSystem()throws IOException{
        checkSystemLoaded();
        return System;
    }

    public static Table getDatabaseTable()throws IOException{
        checkSystemLoaded();
        return System.tables.get(Logger.databaseTableName);
    }

    public static Table getTablesTable()throws IOException{
        checkSystemLoaded();
        return System.tables.get(Logger.tablesTableName);
    }


    public static Table getIndexesTable()throws IOException{
        checkSystemLoaded();
        return System.tables.get(Logger.indexesTableName);
    }

    /**
     * load the file system
     */
    public static void loadSystem() throws IOException {
        System = new Database(Logger.systemDatabaseName, true);
        Table databases = new Table(System, Logger.datebasesTableType(), Logger.databaseTableName, new ArrayList<IndexInfo>(){{add(new IndexInfo("0",true));}}, System.cache, 0);
        Table tables = new Table(System, Logger.tablesTableType(), Logger.tablesTableName, new ArrayList<IndexInfo>(){{add(new IndexInfo("1,0",true));}}, System.cache, 0);
        Table indexes = new Table(System,Logger.indexesTableType(),Logger.indexesTableName,new ArrayList<IndexInfo>(){{add(new IndexInfo("1,0",false));}},System.cache,-1);
        System.tables.put(databases.info.tableName, databases);
        System.tables.put(tables.info.tableName, tables);
        System.tables.put(indexes.info.tableName,indexes);
    }


    /**
     * check if the database with input name exists
     * @param name name of the database
     */
    public static boolean databaseExistence(String name)throws IOException{
        checkSystemLoaded();

        Table databases = System.tables.get(Logger.databaseTableName);
        List<Row> result = databases.equivalenceFind(0,new IndexKey(Logger.columnTypesOfdatabaseTable,databaseData(name)));
        return result.size() > 0;
    }

    public static Database loadDataBase(String name)throws IOException{
        checkSystemLoaded();

        if(!databaseExistence(name))
            return null;
        Database database = new Database(name,false);
        database.loadTables();
        return database;
    }

    public static void checkSystemLoaded() throws IOException {
        if (System == null)
            disk.System.loadSystem();
    }

    public static Database createNewDatabase(String name) throws IOException {
        checkSystemLoaded();

        Object[] databaseData = databaseData(name);

        if(System.tables.get(Logger.databaseTableName).insert(databaseData) != null)
            return new Database(name,false);
        return null;
    }


    public static IndexInfo createNewIndex(String databaseName,String tableName,IndexInfo info)throws IOException{
        Object[] indexData =indexData(databaseName,tableName,info);
        if(getIndexesTable().insert(indexData)!=null)
            return info;
        else
            return null;
    }

    public static void removeDatabase(Database database)throws IOException{
        if(database == null)
            return;

        Table databases = getDatabaseTable();
        for(Table table : database.tables.values())
            database.removeTable(table);
        databases.delete(0,databasePK(database.dataBaseName));
        Logger.deleteDir(new File(Logger.databaseDirectoryPath(database)));
    }


    public static Object[] databaseData(String name) {
        Object[] data = new Object[1];
        data[0] = name;
        return data;
    }

    public static Object[] indexData(String databaseName,String tableName,IndexInfo info)
    {
        Object[] data = new Object[4];
        data[0] = tableName;
        data[1] = databaseName;
        data[2] = info.columnIndexString();
        data[3] = info.isUnique;
        return data;
    }

    public static IndexKey tablePK(String dataBaseName,String tableName){
        Object[] data = new Object[2];
        data[0] = dataBaseName;
        data[1] = tableName;
        Type[] types = new Type[2];
        types[0] = Logger.columnTypesOftableTable[1];
        types[1] = Logger.columnTypesOftableTable[0];
        return new IndexKey(types,data);
    }

    public static IndexKey databasePK(String dataBaseName){
        Object[] data = new Object[1];
        data[0] = dataBaseName;
        Type[] types = new Type[1];
        types[0] = Logger.columnTypesOfdatabaseTable[0];
        return new IndexKey(types,data);
    }

}
