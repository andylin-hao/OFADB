package DBDisk;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import IO.*;
import Index.*;
import BlockManager.*;

public class Table {
    /**
     * @Classname : Table
     *
     * @Description : a table in database
     **/
    public Database database;
    public Type[]               columnTypes;                        // the type array of the columns
    public Column[]         columns;                                // the columns array
    public DataFileManager dataFileManager;                         // the io manager of the data file
    public String           tableName;                              // name of the table
    public IndexBase primaryIndex;                                  // the primary index of this table
    public List<IndexBase> indexs;                                  // the index array of this table
    public int rowNum;                                              // the number of rows in the table

    public Table(Database database, Column[] columns, String name, Cache cache)throws IOException {
        this.columns = columns;
        loadTypes();
        tableName = name;
        this.database = database;
        dataFileManager = new DataFileManager(this,new File(  Logger.dataFilePath(this)),cache);
    }

    public Table(Database database, Column[] columns, String name,String indexInfos, Cache cache,int pkIndexNum)throws IOException {
        this.columns = columns;
        loadTypes();
        tableName = name;
        this.database = database;
        dataFileManager = new DataFileManager(this,new File(  Logger.dataFilePath(this)),cache);
        loadIndex(indexInfos);
        if(pkIndexNum>=0)
            setPKIndex(pkIndexNum);

    }

    public void setPKIndex(int indexNum)throws IOException{
        primaryIndex = indexs.get(indexNum);
        if(!primaryIndex.isUnique){
            primaryIndex.isUnique = true;
            primaryIndex.fileIO.saveUnique();
        }

    }


    /**
     * @Description : init the type array of column
    **/
    public void loadTypes(){
        this.columnTypes = new Type[columns.length];
        for(int i =0;i<columnTypes.length;i++){
            columnTypes[i] = columns[i].columnType;
        }
    }



    /**
     * @Description :load the indexs
    **/
    public void loadIndex(String indexInfos)throws IOException{
        List<int[]> infos = getColumnsIndexForIndex(indexInfos);
        indexs = new ArrayList<IndexBase>();
        for(int i = 0;i<infos.size();i++){
                File file = new File(Logger.indexFilePath(this, getIndexFileName(infos.get(i))));
                Type[] types = getIndexTypes(infos.get(i));
                IndexBase index = new IndexBase(this, Logger.defaultIndexOrder,infos.get(i),file,types);
                indexs.add(index);
        }
    }

    public List<int[]> getColumnsIndexForIndex(String infos){
        String[] infosSplited = infos.split(Logger.indexStringSegment);
        List<int[]> columns = new ArrayList<>();
        for(int i = 0;i<infosSplited.length;i++){
            String[] infoSplited = infosSplited[i].split(Logger.columnIndexStringSegment);
            int[] column = new int[infoSplited.length];
            for(int j = 0;j<infoSplited.length;j++){
                column[j]=(Integer.parseInt(infoSplited[j]));
            }
            columns.add(column);
        }
        return columns;
    }


    public String getIndexFileName(int[] info){
        String name = "";
        for(int i = 0;i<info.length;i++)
        {
            name += columns[info[i]].columnName;
            if(i != info.length-1)
                name += '_';
        }
        return name;
    }

    public Type[] getIndexTypes(int[] info){
        Type[] types = new Type[info.length];
        for(int i = 0;i<info.length;i++)
            types[i] = columnTypes[info[i]];
        return types;
    }




    /**
     * @Description : check the column value of unique key in the data doesn't exist in the unique Index
    **/
    public boolean uniqueKeyUnUsed(Object[] data){
        for(int i = 0;i<indexs.size();i++)
            if(indexs.get(i).isUnique && indexs.get(i).root.contains(indexs.get(i).getIndexAccessor(data))>=0)
                return false;
        return true;
    }

    /**
     * @Description : get the rows having the input key value
    **/
    public List<Row> equivalenceFind(int indexNum,Comparable key)throws IOException{
        IndexBase index = indexs.get(indexNum);
        NodeLeaf leaf = (NodeLeaf) index.get(key);
        List<Row> rowList = new ArrayList<>();
        for(Row ele : leaf.rowInfos){
            rowList.add(dataFileManager.get(ele));
        }
        return rowList;
    }




    /**
     * @Description : check the unique key, then insert the data into data file and all index trees
    **/
    public Row insert(Object[] data)throws IOException{
        //check the unique keys are unused before
        if(uniqueKeyUnUsed(data)) {

            // insert the data into data file
            Row row = dataFileManager.insert(RowIO.writeRowData(columnTypes, data));
            Row rowInfo = new Row(this,row.blockIndex,row.rowIndex);
            //insert the row into all index trees
            if (row != null) {
                for (int i = 0; i < indexs.size(); i++) {
                    indexs.get(i).insert(indexs.get(i).getIndexAccessor(row.rowData), rowInfo);
                    indexs.get(i).indexChange.saveChange();
                }
            }
            rowNum++;
            return row;
        }
        else
            return null;
    }



    /**
     * @Description : delete all the row with input key in input index
    **/
    public List<Row> delete(int indexNum, Comparable key)throws IOException{
        //to do
        IndexBase index = indexs.get(indexNum);
        if(index.root.contains(key)<0)
            return null;
        NodeLeaf rowPos = (NodeLeaf) index.get(key);

        List<Row> deletedRow = new ArrayList<Row>();
        for(int i = 0;i<rowPos.rowInfos.size();i++) {
            Row row = dataFileManager.get(rowPos.rowInfos.get(i).blockIndex, rowPos.rowInfos.get(i).rowIndex);
            for (int j = 0; j < indexs.size(); j++) {
                indexs.get(j).remove(indexs.get(i).getIndexAccessor(row.rowData),rowPos.rowInfos.get(i));
            }
            deletedRow.add(dataFileManager.delete(rowPos.rowInfos.get(i).blockIndex, rowPos.rowInfos.get(i).rowIndex));
        }
        rowNum -= deletedRow.size();
        return deletedRow;
    }


    public Row update(Row oldRow,Object[] data)throws IOException{
        Row old = dataFileManager.get(oldRow);
        Row updated = dataFileManager.update(oldRow.blockIndex,oldRow.rowIndex,RowIO.writeRowData(columnTypes,data));
        for(int i = 0;i<indexs.size();i++){
            indexs.get(i).update(indexs.get(i).getIndexAccessor(old.rowData),
                                    indexs.get(i).getIndexAccessor(data),
                                    new Row(old),
                                    new Row(updated));
        }
        return updated;
    }

    public void save()throws IOException{
        saveIndex();
        saveData();
    }
    public void saveIndex()throws IOException{
        for(int i = 0;i<indexs.size();i++){
            indexs.get(i).indexChange.saveChange();
        }
    }

    public void saveData()throws IOException{
        dataFileManager.saveAll();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Table))
            return false;
        return tableName == ((Table)obj).tableName && database.equals(((Table) obj).database);
    }

}
