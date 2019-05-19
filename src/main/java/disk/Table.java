package disk;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.*;
import index.*;
import block.*;

/**
 * A table in database
 **/

public class Table {
    public Database database;
    public Type[] columnTypes;                        // the type array of the columns
    public Column[] columns;                                // the columns array
    public DataFileManager dataFileManager;                         // the io manager of the data file
    public String tableName;                              // name of the table
    public IndexBase primaryIndex;                                  // the primary index of this table
    public List<IndexBase> indexes;                                  // the index array of this table
    public int rowNum;                                              // the number of rows in the table

    public Table(Database database, Column[] columns, String name, Cache cache) throws IOException {
        this.columns = columns;
        loadTypes();
        tableName = name;
        this.database = database;
        dataFileManager = new DataFileManager(this, new File(Logger.dataFilePath(this)), cache);
    }

    public Table(Database database, Column[] columns, String name, String indexInfos, Cache cache, int pkIndexNum) throws IOException {
        this.columns = columns;
        loadTypes();
        tableName = name;
        this.database = database;
        dataFileManager = new DataFileManager(this, new File(Logger.dataFilePath(this)), cache);
        loadIndex(indexInfos);
        if (pkIndexNum >= 0)
            setPKIndex(pkIndexNum);

    }

    public void setPKIndex(int indexNum) throws IOException {
        primaryIndex = indexes.get(indexNum);
        if (!primaryIndex.isUnique) {
            primaryIndex.isUnique = true;
            primaryIndex.fileIO.saveUnique();
        }

    }

    /**
     * Init the type array of column
     **/
    public void loadTypes() {
        this.columnTypes = new Type[columns.length];
        for (int i = 0; i < columnTypes.length; i++) {
            columnTypes[i] = columns[i].columnType;
        }
    }

    /**
     * Load the indexes
     **/
    public void loadIndex(String indexInfos) throws IOException {
        List<int[]> infos = getColumnsIndexForIndex(indexInfos);
        indexes = new ArrayList<IndexBase>();
        for (int[] info : infos) {
            File file = new File(Logger.indexFilePath(this, getIndexFileName(info)));
            Type[] types = getIndexTypes(info);
            IndexBase index = new IndexBase(this, Logger.defaultIndexOrder, info, file, types);
            indexes.add(index);
        }
    }

    public List<int[]> getColumnsIndexForIndex(String infos) {
        String[] infosSplited = infos.split(Logger.indexStringSegment);
        List<int[]> columns = new ArrayList<>();
        for (String s : infosSplited) {
            String[] infoSpliced = s.split(Logger.columnIndexStringSegment);
            int[] column = new int[infoSpliced.length];
            for (int j = 0; j < infoSpliced.length; j++) {
                column[j] = (Integer.parseInt(infoSpliced[j]));
            }
            columns.add(column);
        }
        return columns;
    }


    public String getIndexFileName(int[] info) {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < info.length; i++) {
            name.append(columns[info[i]].columnName);
            if (i != info.length - 1)
                name.append('_');
        }
        return name.toString();
    }

    public Type[] getIndexTypes(int[] info) {
        Type[] types = new Type[info.length];
        for (int i = 0; i < info.length; i++)
            types[i] = columnTypes[info[i]];
        return types;
    }


    /**
     * Check the column value of unique key in the data doesn't exist in the unique index
     **/
    public boolean uniqueKeyUnUsed(Object[] data) {
        for (int i = 0; i < indexes.size(); i++)
            if (indexes.get(i).isUnique && indexes.get(i).root.contains(indexes.get(i).getIndexAccessor(data)) >= 0)
                return false;
        return true;
    }

    /**
     * Get the rows having the input key value
     **/
    public List<Row> equivalenceFind(int indexNum, Comparable key) throws IOException {
        IndexBase index = indexes.get(indexNum);
        NodeLeaf leaf = (NodeLeaf) index.get(key);
        List<Row> rowList = new ArrayList<>();
        for (Row ele : leaf.rowInfos) {
            rowList.add(dataFileManager.get(ele));
        }
        return rowList;
    }


    /**
     * Check the unique key, then insert the data into data file and all index trees
     **/
    public Row insert(Object[] data) throws IOException {
        //check the unique keys are unused before
        if (uniqueKeyUnUsed(data)) {

            // insert the data into data file
            Row row = dataFileManager.insert(RowIO.writeRowData(columnTypes, data));
            Row rowInfo = new Row(this, row.blockIndex, row.rowIndex);
            //insert the row into all index trees
            for (IndexBase index : indexes) {
                index.insert(index.getIndexAccessor(row.rowData), rowInfo);
                index.indexChange.saveChange();
            }
            rowNum++;
            return row;
        } else
            return null;
    }

    /**
     * Delete all the row with input key in input index
     **/
    public List<Row> delete(int indexNum, Comparable key) throws IOException {
        //to do
        IndexBase index = indexes.get(indexNum);
        if (index.root.contains(key) < 0)
            return null;
        NodeLeaf rowPos = (NodeLeaf) index.get(key);

        List<Row> deletedRow = new ArrayList<Row>();
        for (int i = 0; i < rowPos.rowInfos.size(); i++) {
            Row row = dataFileManager.get(rowPos.rowInfos.get(i).blockIndex, rowPos.rowInfos.get(i).rowIndex);
            for (IndexBase indexBase : indexes) {
                indexBase.remove(indexes.get(i).getIndexAccessor(row.rowData), rowPos.rowInfos.get(i));
            }
            deletedRow.add(dataFileManager.delete(rowPos.rowInfos.get(i).blockIndex, rowPos.rowInfos.get(i).rowIndex));
        }
        rowNum -= deletedRow.size();
        return deletedRow;
    }


    public Row update(Row oldRow, Object[] data) throws IOException {
        Row old = dataFileManager.get(oldRow);
        Row updated = dataFileManager.update(oldRow.blockIndex, oldRow.rowIndex, RowIO.writeRowData(columnTypes, data));
        for (IndexBase index : indexes) {
            index.update(index.getIndexAccessor(old.rowData),
                    index.getIndexAccessor(data),
                    new Row(old),
                    new Row(updated));
        }
        return updated;
    }

    public void save() throws IOException {
        saveIndex();
        saveData();
    }

    public void saveIndex() throws IOException {
        for (IndexBase index : indexes) {
            index.indexChange.saveChange();
        }
    }

    public void saveData() throws IOException {
        dataFileManager.saveAll();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Table))
            return false;
        return tableName.equals(((Table) obj).tableName) && database.equals(((Table) obj).database);
    }

}
