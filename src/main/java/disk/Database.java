package disk;

import Meta.FileSystem;
import Meta.IndexInfo;
import Meta.MetaData;
import block.Cache;
import index.IndexBase;
import index.IndexKey;
import index.NodeIndex;
import index.NodeLeaf;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
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


    /**
     * create a new table in the current database
     * @param name name of the table
     * @param columns columns of the  table
     * @param indexInfos the list of index info
     * @param pkIndexNum the index of the primary index in index list
     */
    public Table createNewTable(String name, Column[] columns, List<IndexInfo> indexInfos, int pkIndexNum) throws IOException {

        Object[] tableData = Table.tableData(dataBaseName,name, columns, pkIndexNum);

        Row result = FileSystem.getSystem().tables.get(Logger.tablesTableName).insert(tableData);

        if (result != null) {
            for (int i = 0;i<indexInfos.size();i++) {
                FileSystem.createNewIndex(dataBaseName, name, indexInfos.get(i));
            }

            Table newTable = new Table(this, columns, name, indexInfos, this.cache, pkIndexNum);
            this.tables.put(name, newTable);
            return newTable;
        }
        return null;
    }




    public void loadTables() throws IOException {
        Table tables = FileSystem.getTablesTable();
        IndexBase pkIndex = tables.indexes.get(0);
        NodeIndex iterator = (NodeIndex) pkIndex.headLeaf;
        while (iterator != null) {
            for (int i = 0; i < iterator.keys.size(); i++) {
                if (((IndexKey) iterator.keys.get(i).getKey()).values[0].equals(dataBaseName)) {
                    NodeLeaf leaf = (NodeLeaf) (iterator.keys.get(i).getValue());
                    Row meta = tables.dataFileManager.get(leaf.rowInfos.get(0));
                    String tableName = (String) meta.rowData[0];
                    Column[] columns = Column.columnsFromString((String) meta.rowData[2]);
                    List<IndexInfo> indexInfos = MetaData.getIndexesInfo(dataBaseName,tableName);
                    Integer pkIndexNum = (Integer) meta.rowData[4];
                    Table newTable = new Table(this, columns, tableName, indexInfos, cache, pkIndexNum);
                    this.tables.put(tableName, newTable);
                }
            }
            iterator = iterator.next;
        }
    }



}
