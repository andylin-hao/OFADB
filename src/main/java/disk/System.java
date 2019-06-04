package disk;

import block.BlockInfo;
import index.IndexKey;
import meta.IndexInfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class System {
    private static Database system;
    private static Database curDB;

    public static HashMap<String, Database> getDbMap() {
        return dbMap;
    }

    private static HashMap<String,Database> dbMap = new HashMap<>();


    public System()throws IOException{
        dbMap = new HashMap<>();
        disk.System.loadSystem();

    }

    /**
     * get the system database
     */
    public static Database getSystem()throws IOException{
        checkSystemLoaded();
        return system;
    }


    /**
     * get the table which stores metadata of database in the system database
     */
    public static Table getDatabaseTable()throws IOException{
        checkSystemLoaded();
        return system.tables.get(Logger.databaseTableName);
    }

    /**
     * get the table which stores metadata of table in the system database
     */
    public static Table getTablesTable()throws IOException{
        checkSystemLoaded();
        return system.tables.get(Logger.tablesTableName);
    }


    /**
     * get the table which stores metadata of index in the system database
     */
    public static Table getIndexesTable()throws IOException{
        checkSystemLoaded();
        return system.tables.get(Logger.indexesTableName);
    }

    public static ArrayList<String> getAllDatabaseNames()throws IOException{
        checkSystemLoaded();
        ArrayList<String> names = new ArrayList<>();
        for(BlockInfo info:getDatabaseTable().dataFileManager.blockInfos){
            for(int i = 0;i<info.emptyRecord.size();i++)
                if(!info.emptyRecord.get(i))
                {
                    Row row = getDatabaseTable().get(getDatabaseTable().dataFileManager.blockInfos.indexOf(info),i);
                    names.add((String) row.rowData[0]);
                }
        }
        return names;
    }

    /**
     * load the system database
     */
    public static void loadSystem() throws IOException {
        system = new Database(Logger.systemDatabaseName, true);
        Table databases = new Table(system, Logger.datebasesTableType(), Logger.databaseTableName, new ArrayList<>(){{add(new IndexInfo("0",true));}}, system.cache, 0);
        Table tables = new Table(system, Logger.tablesTableType(), Logger.tablesTableName, new ArrayList<>(){{add(new IndexInfo("1,0",true));}}, system.cache, 0);
        Table indexes = new Table(system,Logger.indexesTableType(),Logger.indexesTableName,new ArrayList<>(){{add(new IndexInfo("1,0",false));}},system.cache,-1);
        system.tables.put(databases.info.tableName, databases);
        system.tables.put(tables.info.tableName, tables);
        system.tables.put(indexes.info.tableName,indexes);
        dbMap.put("System",system);
    }


    /**
     * check if the database with input name exists
     * @param name name of the database
     */
    public static boolean isDBExist(String name)throws IOException{
        checkSystemLoaded();

        Table databases = system.tables.get(Logger.databaseTableName);
        List<Row> result = databases.equivalenceFind(0,new IndexKey(Logger.columnTypesOfdatabaseTable,databaseData(name)));
        return result.size() > 0;
    }


    /**
     * load a database to the system and set it as the current database
     * @param name name of the database
     */
    public static void loadDataBase(String name)throws IOException{
        checkSystemLoaded();
        curDB = getDataBase(name);
    }


    /**
     * get a database
     * @param name name of the database
     */
    public static Database getDataBase(String name)throws IOException{
        checkSystemLoaded();
        if(dbMap.containsKey(name))
            return dbMap.get(name);

        if(!isDBExist(name))
            return null;
        Database database = new Database(name,false);
        database.loadTables();
        dbMap.put(name,database);
        return database;
    }


    /**
     * check if the system database is loaded
     */
    public static void checkSystemLoaded() throws IOException {
        if (system == null)
            disk.System.loadSystem();
    }


    /**
     * create a new database
     * @param name name of the database
     */
    public static Database createNewDatabase(String name) throws IOException {
        checkSystemLoaded();

        Object[] databaseData = databaseData(name);

        if(system.tables.get(Logger.databaseTableName).insert(databaseData) != null) {
            Database ndb =  new Database(name, false);
            dbMap.put(ndb.dataBaseName,ndb);
            return ndb;
        }
        else
            throw new RuntimeException("database already exists");
    }


    /**
     * insert a  newindex metadata into the table of index in system database
     * @param databaseName name of database
     * @param tableName name of table
     * @param info info of the index to be inserted
     */
    public static IndexInfo createNewIndex(String databaseName,String tableName,IndexInfo info)throws IOException{
        checkSystemLoaded();
        Object[] indexData =indexData(databaseName,tableName,info);
        if(getIndexesTable().insert(indexData)!=null)
            return info;
        else
            return null;
    }

    public static void removeDatabase(String databaseName)throws IOException{
        checkSystemLoaded();
        Database database = getDataBase(databaseName);
        if(database != null)
            removeDatabase(database);
        else
            throw new RuntimeException("Database does not exist");
    }


    /**
     * delete a database from the  database system
     * @param database the database to be deleted
     */
    public static void removeDatabase(Database database)throws IOException{
        checkSystemLoaded();
        if(database == null)
            return;
        if(database == curDB)
            curDB = null;

        Table databases = getDatabaseTable();
        for(Table table : database.tables.values())
            database.removeTable(table);
        databases.delete(0,databasePK(database.dataBaseName));
        Logger.deleteDir(new File(Logger.databaseDirectoryPath(database)));
        dbMap.remove(database.dataBaseName);
    }

    /**
     * create a row data for the table of database in system database
     * @param name name of database
     */
    public static Object[] databaseData(String name) {
        Object[] data = new Object[1];
        data[0] = name;
        return data;
    }


    /**
     * create a row data for the table of index in system database
     * @param databaseName name of the database
     * @param tableName name of the table
     * @param info info of the index
     */
    public static Object[] indexData(String databaseName,String tableName,IndexInfo info)
    {
        Object[] data = new Object[4];
        data[0] = tableName;
        data[1] = databaseName;
        data[2] = info.columnIndexString();
        data[3] = info.isUnique;
        return data;
    }


    /**
     * create a indexkey for a searching in table table of index table in system databse
     * @param dataBaseName name of the database
     * @param tableName name of the table
     */
    public static IndexKey tablePK(String dataBaseName,String tableName){
        Object[] data = new Object[2];
        data[0] = dataBaseName;
        data[1] = tableName;
        Type[] types = new Type[2];
        types[0] = Logger.columnTypesOftableTable[1];
        types[1] = Logger.columnTypesOftableTable[0];
        return new IndexKey(types,data);
    }

    /**
     * get a indexkey in the table of database in system database
     * @param dataBaseName name of the database
     */
    public static IndexKey databasePK(String dataBaseName){
        Object[] data = new Object[1];
        data[0] = dataBaseName;
        Type[] types = new Type[1];
        types[0] = Logger.columnTypesOfdatabaseTable[0];
        return new IndexKey(types,data);
    }

    /**
     * get the current database
     */
    public static Database getCurDB(){
        return curDB;
    }


    /**
     * remove the current database from memory
     */
    public static void resetCurDB(){
        curDB = null;
    }

    /**
     * switch the current database to the input database
     * @param name name of the database
     */
    public static void switchDatabase(String name)throws IOException{
        resetCurDB();
        loadDataBase(name);
    }


    /**
     * save all the file system to disk
     */
    public static void saveSystem()throws IOException{
        for(Database ele : dbMap.values())
            ele.save();
    }

}
