package Meta;

import disk.Database;
import disk.Table;

import java.util.HashMap;
import java.util.Map;

public class DatabaseInfo {
    public Database database;
    public String databaseName;
    public Map<String,TableInfo> tableInfos;

    public DatabaseInfo(Database database){
        this.database = database;
        this.databaseName = database.dataBaseName;
        tableInfos = new HashMap<>();
        for(Map.Entry<String, Table> tableEntry : database.tables.entrySet()){
            tableInfos.put(tableEntry.getKey(),tableEntry.getValue().info);
        }
    }
}
