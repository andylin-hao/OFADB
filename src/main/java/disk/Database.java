package disk;

import block.Cache;
import index.IndexBase;
import index.IndexKey;
import index.NodeIndex;
import index.NodeLeaf;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Database {
    public static Database System;
    public String           dataBaseName;                        // name of the database
    public Logger           eventLogger;
    public Cache            cache;
    public boolean          isSystem;
    public HashMap<String,Table> tables;


    public Database(String name,boolean isSystemDataBase){
        dataBaseName = name;
        eventLogger = new Logger();
        cache = new Cache(this);
        isSystem = isSystemDataBase;
        tables = new HashMap<>();
    }

    public static void loadSystem()throws IOException {
        System = new Database(Logger.systemDatabaseName,true);
        Table databases = new Table(System,Logger.datebasesTableType(),Logger.databaseTableName,"0",System.cache,0);
        Table tables = new Table(System,Logger.tablesTableType(),Logger.tablesTableName,"1,0",System.cache,0);
        System.tables.put(databases.tableName,databases);
        System.tables.put(tables.tableName,tables);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Database))
            return false;
        return dataBaseName == ((Database) obj).dataBaseName;
    }

    public void save()throws IOException{
        for(Map.Entry<String,Table> ele:tables.entrySet()){
            ele.getValue().save();
        }
    }

    public static void checkSystemLoaded()throws IOException{
        if(System == null)
            Database.loadSystem();
    }

    public static Row createNewDatabase(String name)throws IOException{
        checkSystemLoaded();

        Object[] databaseData = databaseData(name);
        Row result = System.tables.get(Logger.databaseTableName).insert(databaseData);
        return result;
    }

    public Row createNewTable(String name,Column[] columns,String indexInfos,int pkIndexNum)throws IOException{
        checkSystemLoaded();

        Object[] tableData = tableData(name,columns,indexInfos,pkIndexNum);

        Row result = System.tables.get(Logger.tablesTableName).insert(tableData);
        if(result != null) {
            Table newTable = new Table(this, columns, name, indexInfos, this.cache, pkIndexNum);
            this.tables.put(name, newTable);
        }
        return result;
    }

    public Object[] tableData(String tableName,Column[] columns,String indexInfos,int pkIndexNum){
        Object[] data = new Object[Logger.columnNamesOftableTable.length];
        data[0] = tableName;
        data[1] = dataBaseName;
        data[2] = Column.columnsToString(columns);
        data[3] = indexInfos;
        data[4] = pkIndexNum;
        return data;
    }

    public static Object[] databaseData(String name){
        Object[] data = new Object[1];
        data[0] = name;
        return data;
    }

    public void loadTables()throws IOException{
        checkSystemLoaded();
        Table tables = System.tables.get(Logger.tablesTableName);
        IndexBase pkIndex = tables.indexs.get(0);
        NodeIndex iterator = (NodeIndex) pkIndex.headLeaf;
        while(iterator != null){
            for(int i = 0;i<iterator.keys.size();i++) {
                if(((IndexKey)iterator.keys.get(i).getKey()).values[0].equals(dataBaseName)) {
                    NodeLeaf leaf = (NodeLeaf) (iterator.keys.get(i).getValue());
                    Row meta = System.tables.get(Logger.tablesTableName).dataFileManager.get(leaf.rowInfos.get(0));
                    String tableName = (String)meta.rowData[0];
                    Column[] columns = Column.columnsFromString((String)meta.rowData[2]);
                    String indexInfos = (String)meta.rowData[3];
                    Integer pkIndexNum = (Integer)meta.rowData[4];
                    Table newTable = new Table(this,columns,tableName,indexInfos,cache,pkIndexNum);
                    this.tables.put(tableName,newTable);
                }
            }
            iterator = iterator.next;
        }
    }
}
