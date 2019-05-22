package Meta;

import block.DataFileManager;
import disk.Column;
import disk.Database;
import disk.Table;
import disk.Type;
import index.IndexBase;

import java.util.List;

public class TableInfo {
    public Table table;
    public Database database;
    public Type[] columnTypes;                        // the type array of the columns
    public Column[] columns;                                // the columns array
    public String tableName;                              // name of the table
    public int rowNum;                                              // the number of rows in the table
    public List<IndexInfo> indexInfos;                             //the info of indexes

    public TableInfo(Database database,Table table,Column[] columns,String name,List<IndexInfo> indexInfos){
        this.database = database;
        this.table = table;
        this.columns = columns;
        this.tableName = name;
        this.indexInfos = indexInfos;
        loadTypes();
    }


    /**
     * Init the type array of column
     */
    public void loadTypes() {
        this.columnTypes = new Type[columns.length];
        for (int i = 0; i < columnTypes.length; i++) {
            columnTypes[i] = columns[i].columnType;
        }
    }

    @Override
    public String toString() {
        return "name:" + tableName + ",rowNum:" + rowNum;
    }
}
