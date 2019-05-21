package disk;

import block.Cache;
import index.IndexBase;
import index.IndexKey;
import index.NodeIndex;
import index.NodeLeaf;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    public static Database System;
    public String dataBaseName;                        // name of the database
    public Logger eventLogger;
    public Cache cache;
    public boolean isSystem;
    public HashMap<String, Table> tables;


    public Database(String name, boolean isSystemDataBase) {
        dataBaseName = name;
        eventLogger = new Logger();
        cache = new Cache(this);
        isSystem = isSystemDataBase;
        tables = new HashMap<>();
    }

    public static void loadSystem() throws IOException {
        System = new Database(Logger.systemDatabaseName, true);
        Table databases = new Table(System, Logger.datebasesTableType(), Logger.databaseTableName, "0", System.cache, 0);
        Table tables = new Table(System, Logger.tablesTableType(), Logger.tablesTableName, "1,0", System.cache, 0);
        System.tables.put(databases.info.tableName, databases);
        System.tables.put(tables.info.tableName, tables);
    }

    public static boolean databaseExistence(String name)throws IOException{
        Table databases = System.tables.get(Logger.databaseTableName);
        List<Row> result = databases.equivalenceFind(0,new IndexKey(Logger.columnTypesOfdatabaseTable,databaseData(name)));
        return result.size() > 0;
    }

    public static Database loadDataBase(String name)throws IOException{
        if(!databaseExistence(name))
            return null;
        Database database = new Database(name,false);
        database.loadTables();
        return database;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Database))
            return false;
        return dataBaseName.equals(((Database) obj).dataBaseName);
    }

    public void save() throws IOException {
        for (Map.Entry<String, Table> ele : tables.entrySet()) {
            ele.getValue().save();
        }
    }

    public static void checkSystemLoaded() throws IOException {
        if (System == null)
            Database.loadSystem();
    }

    public static Database createNewDatabase(String name) throws IOException {
        checkSystemLoaded();

        Object[] databaseData = databaseData(name);

        if(System.tables.get(Logger.databaseTableName).insert(databaseData) != null)
            return new Database(name,false);
        return null;
    }

    public Table createNewTable(String name, Column[] columns, String indexInfos, int pkIndexNum) throws IOException {
        checkSystemLoaded();

        Object[] tableData = Table.tableData(dataBaseName,name, columns, indexInfos, pkIndexNum);

        Row result = System.tables.get(Logger.tablesTableName).insert(tableData);
        if (result != null) {
            Table newTable = new Table(this, columns, name, indexInfos, this.cache, pkIndexNum);
            this.tables.put(name, newTable);
            return newTable;
        }
        return null;
    }



    public static Object[] databaseData(String name) {
        Object[] data = new Object[1];
        data[0] = name;
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

    public void loadTables() throws IOException {
        checkSystemLoaded();
        Table tables = System.tables.get(Logger.tablesTableName);
        IndexBase pkIndex = tables.indexes.get(0);
        NodeIndex iterator = (NodeIndex) pkIndex.headLeaf;
        while (iterator != null) {
            for (int i = 0; i < iterator.keys.size(); i++) {
                if (((IndexKey) iterator.keys.get(i).getKey()).values[0].equals(dataBaseName)) {
                    NodeLeaf leaf = (NodeLeaf) (iterator.keys.get(i).getValue());
                    Row meta = System.tables.get(Logger.tablesTableName).dataFileManager.get(leaf.rowInfos.get(0));
                    String tableName = (String) meta.rowData[0];
                    Column[] columns = Column.columnsFromString((String) meta.rowData[2]);
                    String indexInfos = (String) meta.rowData[3];
                    Integer pkIndexNum = (Integer) meta.rowData[4];
                    Table newTable = new Table(this, columns, tableName, indexInfos, cache, pkIndexNum);
                    this.tables.put(tableName, newTable);
                }
            }
            iterator = iterator.next;
        }
    }
}
