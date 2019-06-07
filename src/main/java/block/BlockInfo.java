package block;

import io.MDBByteArrayInputStream;
import disk.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class stored the info of one block in the storage file
 **/


public class BlockInfo {


    public final static int blockHeadSize = 16;                             //length of block head (include blockSize,rowNum,emptyPointer,emptySize)
    public final static int entrySize = 8;                                  //size of an entry of a row data(offset + size)


    public int blockSize;                                                   //the size of the block
    public int rowNum;                                                      //the number of the row stored in the block
    public int emptyPointer;                                                //offset in block of the first empty position
    public int emptySize;                                                   //size of the first empty position
    public int blockIndex;                                                  //the index of this block in the block list
    public List<Boolean> emptyRecord;                                       //the empty flags in the entry list
    public Table table;                                                     //the table this block belongs to
    public boolean isModified;                                              // the modified flag


    /**
     * Get block info from the byte array of a block
     **/
    public BlockInfo(Table t, byte[] buf, int index) throws IOException {
        table = t;
        emptyRecord = new ArrayList<>();
        blockIndex = index;
        getMetaFromBytes(buf);
        setModified(false);
    }

    /**
     * Create a new block
     **/
    public BlockInfo(Table t, int blockSize, int index) {
        table = t;
        emptyRecord = new ArrayList<>();
        blockIndex = index;
        setBLockInfo(blockSize, blockSize, blockSize - blockHeadSize, 0);
        setModified(true);
    }

    public void setModified(boolean modified) {
        isModified = modified;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getEmptyPointer() {
        return emptyPointer;
    }

    public void setEmptyPointer(int emptyPointer) {
        this.emptyPointer = emptyPointer;
    }

    public int getEmptySize() {
        return emptySize;
    }

    public void setEmptySize(int emptySize) {
        this.emptySize = emptySize;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    /**
     * Get block info from an exists bytes array of a block
     **/
    public void getMetaFromBytes(byte[] buf) throws IOException {
        emptyRecord.clear();
        MDBByteArrayInputStream inputStream = new MDBByteArrayInputStream(buf);
        inputStream.setPos(0);

        //get block head
        int blockSize = inputStream.readInt();
        int rowNum = inputStream.readInt();
        int emptyPointer = inputStream.readInt();
        int emptySize = inputStream.readInt();

        //get the empty list
        setBLockInfo(blockSize, emptyPointer, emptySize, rowNum);
        int validEntry = 0;
        while (validEntry < rowNum) {
            int offset = inputStream.readInt();
            int length = inputStream.readInt();
            if (offset == -1 && length == -1)
                emptyRecord.add(true);
            else {
                emptyRecord.add(false);
                validEntry++;
            }
        }
    }


    /**
     * Set the block info
     **/
    public void setBLockInfo(int blockSize, int emptyPointer, int emptySize, int rowNum) {
        setBlockSize(blockSize);
        setEmptyPointer(emptyPointer);
        setEmptySize(emptySize);
        setRowNum(rowNum);
    }

    /**
     * Check the block is insertable or not
     *
     * @param length : the length of the row data to be inserted
     **/
    public boolean insertable(int length) {
        if (emptyRecord.contains(true))
            return emptySize >= length;
        else
            return emptySize >= length + entrySize;
    }


    /**
     * Check the block is big enough to update the row
     *
     * @param length : the length of the new data
     * @param index  : the index in the entry list of the row to be updated
     **/
    public boolean updatable(int index, int length) {
        if (index >= emptyRecord.size())
            return false;
        return emptySize >= length;
    }


    /**
     * Update the block info after delete
     *
     * @param index      : the index of the row deleted
     * @param dataLength : the length of the row data deleted
     **/
    public void updateMetaByDelete(int index, int dataLength) throws IOException {
        rowNum--;
        emptyRecord.set(index, true);

        //if this is the last row in the list, then release the entry space
        if (index == emptyRecord.size() - 1)
            removeLastEntry(index);
        emptyPointer += dataLength;
        emptySize += dataLength;
//        writeMetaToBytes();
    }

    /**
     * Update the block info after insert
     *
     * @param index      : the index of the row inserted
     * @param dataLength : the length of the row inserted
     **/
    public void updateMetaByInsert(int index, int dataLength) throws IOException {
        rowNum++;
        if (index == emptyRecord.size()) {
            addNewEntry();
        }
        emptyRecord.set(index, false);
        emptyPointer -= dataLength;
        emptySize -= dataLength;
//        writeMetaToBytes();
    }

    /**
     * Update the block info after updated
     *
     * @param index       ： the index of the row updated
     * @param deltaLength : the delta length (new length - old length)
     **/
    public void updateMetaByUpdate(int index, int deltaLength) throws IOException {
        emptyPointer -= deltaLength;
        emptySize -= deltaLength;
//        writeMetaToBytes();
    }


    /**
     * Add new entry  into list and update the emptySize
     **/
    public void addNewEntry() {
        this.emptyRecord.add(true);
        emptySize -= entrySize;
    }

    /**
     * Remove the last entry in the list and update emptySize
     **/
    public void removeLastEntry(int index) {
        emptyRecord.remove(index);
        emptySize += entrySize;
    }

}