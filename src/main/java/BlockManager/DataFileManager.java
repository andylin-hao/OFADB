package BlockManager;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import IO.*;
import DBDisk.Logger;
import DBDisk.Row;
import DBDisk.Table;

public class DataFileManager {
    /**
     * @Classname : DataFileManager
     * @Description : the manager of data file io
     **/
    public RandomAccessFile file;                                                   //io interface of the data file
    public List<BlockInfo> blockInfos;                                              //block infos of the blocks in the data file
    public Cache cache;                                                             //cache
    public Table table;
    public int blockNum;                                                            // number of blocks of table
    public int blockSize;                                                           // size of block
    public  final static int firstOff = 8;                                          // start offset of the first block

    public DataFileManager(Table table, File file, Cache cache)throws IOException {
        this.file = new RandomAccessFile(file,"rw");
        this.table = table;
        this.cache = cache;
        blockInfos = new ArrayList<>();
        if(file.length() == 0) {
            blockSize = Logger.defaultBlockSize;
            initDataFile(file);
        }
        loadMetaData();
        loadBlockInfos();
    }


    /**
     * @Description : init file head and the first block of a new data file of a table
    **/
    public void initDataFile(File file)throws IOException{
        createNewBlock();
        this.file.close();
        this.file = new RandomAccessFile(file,"rw");
    }

    /**
     * @Description : read meta data from the file head
    **/
    public void loadMetaData() throws IOException{
        file.seek(0);
        blockNum = file.readInt();
        blockSize = file.readInt();
    }

    /**
     * @Description : load the list of the block info by traversing
    **/
    public void loadBlockInfos() throws IOException{
        int rowNum = 0;
        blockInfos.clear();
        int blockOff = firstOff;
        file.seek(blockOff);
        byte[] buf = new byte[blockSize];
        for(int i = 0;i<blockNum;i++){
            if(file.read(buf,0,buf.length)<blockSize)
                break;
            BlockInfo blockInfo = new BlockInfo(table,buf,i);
            blockInfos.add(blockInfo);
            rowNum += blockInfo.rowNum;
        }
        this.table.rowNum = rowNum;
    }


    /**
     * @Description : create a new block and save it to the file
    **/
    public int createNewBlock()throws IOException{
        BlockIO newBlock = new BlockIO(table,blockSize,blockInfos.size());
        writeBlockToDisk(blockInfos.size(),newBlock.content);
        BlockInfo info = new BlockInfo(table,blockSize,blockInfos.size());
        updateMetaByCreateBlock(info);
        return info.blockIndex;
    }

    /**
     * @Description : update the file info by creating a new block
    **/
    public void updateMetaByCreateBlock(BlockInfo info)throws IOException{
        blockNum++;
        blockInfos.add(info);
        writeMetaToFile();
    }

    /**
     * @Description : save file head to data file
    **/
    public void writeMetaToFile()throws IOException{
        file.seek(0);
        file.writeInt(blockNum);
        file.writeInt(blockSize);
    }

    /**
     * @Description : save block to file
    **/
    public void writeBlockToDisk(int index,byte[] data) throws IOException{
        file.seek(getBlockOff(index));
        file.write(data,0,data.length);
    }
    public long getBlockOff(int index){
        return firstOff + (index) * blockSize;
    }

    /**
     * @Description : find a appropriate block to insert a row
     * @param dataLength : the length of the data
    **/
    public int findBlockToInsert(int dataLength)throws IOException{
        //some existing block is insertable
        for(int i = 0;i<blockInfos.size();i++){
            if(blockInfos.get(i).insertable(dataLength))
                return i;
        }
        //need to create a new block
        return createNewBlock();
    }

    /**
     * @Description : insert row to the file
    **/
    public Row insert(byte[] data)throws IOException{
        // find a block to insert
        int blockIndex = findBlockToInsert(data.length);
        //insert into the block
        Row row = cache.insert(table,blockIndex,data);
        //update the block info in memory
        blockInfos.get(blockIndex).updateMetaByInsert(row.rowIndex,data.length);
        return row;
    }


    /**
     * @Description : delete a row from the table
    **/
    public Row delete(int blockIndex, int rowIndex)throws IOException{
        if(rowIndex >= blockInfos.size())
            return null;
        //get the old data
        byte[] databyte = cache.get(table,blockIndex,rowIndex);
        if(databyte == null)
            return null;
        int dataLength = databyte.length;

        //delete row
        Row oldRow = cache.delete(table,blockIndex,rowIndex);

        //update the block info in memory
        blockInfos.get(blockIndex).updateMetaByDelete(rowIndex,dataLength);
        return oldRow;
    }

    /**
     * @Description : update row
    **/
    public Row update(int blockIndex, int rowIndex, byte[] data)throws IOException{
        if(blockIndex >= blockInfos.size())
            return null;
        Row updatedRow = null;
        // the block is updatable
        if(blockInfos.get(blockIndex).updatable(rowIndex,data.length)) {
            int oldLength = cache.get(table,blockIndex,rowIndex).length;
            updatedRow = cache.update(table, blockIndex, rowIndex, data);
            blockInfos.get(blockIndex).updateMetaByUpdate(rowIndex,data.length-oldLength);
        }
        // delete the old row and insert new data
        else{
            Row oldRow = delete(blockIndex,rowIndex);
            updatedRow = insert(data);
        }
        return updatedRow;
    }

    public byte[] getData(int blockIndex,int rowIndex)throws IOException{
        return cache.get(table,blockIndex,rowIndex);
    }

    /**
     * @Description : get row
    **/
    public Row get(int blockIndex, int rowIndex)throws IOException{
        return new Row(table,getData(blockIndex,rowIndex),blockIndex,rowIndex);
    }

    public Row get(Row info)throws IOException{
        return new Row(table,getData(info.blockIndex,info.rowIndex),info.blockIndex,info.rowIndex);
    }

    /**
     * @Description : get a block from file
    **/
    public BlockIO getBlockFromFile(int index)throws IOException{
        if(index>=blockInfos.size())
            return null;
        byte[] blockData = new byte[blockSize];
        file.seek(getBlockOff(index));
        file.read(blockData,0,blockSize);
        return new BlockIO(table,blockData,index);
    }

    public void saveAll()throws IOException{
        for(Map.Entry<CacheKey,BlockIO> ele:cache.blockHashMap.entrySet()){
            if(ele.getKey().table.equals(this)){
                cache.popOut(ele.getKey());
            }
        }
    }


}
