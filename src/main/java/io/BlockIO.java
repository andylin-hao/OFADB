package io;

import block.BlockInfo;
import disk.Row;
import disk.Table;

import java.io.IOException;

/**
 * The manger of io of block
 **/

public class BlockIO extends BlockInfo {
    public byte[] content;                                                                          //byte mode of the block
    public MDBByteArrayInputStream inputStream;                                                     //input stream of the block
    public MDBByteArrayOutputStream outputStream;                                                   //output stream of the block


    /**
     * Init  from an existing block
    **/
    public BlockIO(Table table, byte[] buf, int index)throws IOException{
        super(table,buf,index);
        content = buf;
        inputStream = new MDBByteArrayInputStream(buf);
        outputStream = new MDBByteArrayOutputStream(buf);
        getMetaFromBytes(buf);
    }


    /**
     * Create a new block
    **/
    public BlockIO(Table table, int blockSize, int index)throws IOException{
        super(table,blockSize,index);
        byte[] buf = new byte[blockSize];
        content = buf;
        inputStream = new MDBByteArrayInputStream(buf);
        outputStream = new MDBByteArrayOutputStream(buf);
        setBLockInfo(blockSize,blockSize,blockSize-blockHeadSize,0);
        writeMetaToBytes();
    }


    /**
     * Insert row into position already in the entry list
     * @param index : the index of the position to be inserted
     * @param data : data bytes to be inserted
    **/
    public int insert(int index,byte[] data)throws IOException {
        if(!emptyRecord.get(index))
            return -1;
        int bytesLength = data.length;
        //write the data
        outputStream.setPosition(emptyPointer-bytesLength);
        outputStream.write(data);

        //write the entry
        writeEntry(index,emptyPointer-bytesLength,bytesLength);
        updateMetaByInsert(index,bytesLength);
        return index;
    }

    /**
     * Insert a row into the block
    **/
    public Row insert(byte[] data)throws IOException{
        setModified(true);

        //if the entry list contains some empty element
        if(emptyRecord.contains(true)){
            return new Row(table,data,blockIndex,insert(emptyRecord.indexOf(true),data));
        }
        //create a new entry
        else {
            addNewEntry();
            return new Row(table,data,blockIndex,insert(emptyRecord.size() - 1,data));
        }
    }

    /**
     * Delete the row with the input index
     * @param index : the index to be deleted
    **/
    public Row delete(int index)throws IOException{
        if(emptyRecord.size()<=index || emptyRecord.get(index))
            return null;

        setModified(true);
        int entryOffset = getEntryOff(index);

        byte[] oldData = readRowData(index);

        //get the entry
        inputStream.setPos(entryOffset);
        int dataOff = inputStream.readInt();
        int dataLength = inputStream.readInt();

        //reset the entry of the row
        writeEntry(index,-1,-1);

        //cover the data
        System.arraycopy(content,
                getEmptyPointer(),
                content,
                getEmptyPointer()+dataLength,
                dataOff-getEmptyPointer());

        //update the meta data
        updateMetaByDelete(index,dataLength);

        //update the entries with an offset smaller than deleted
        recordPan(dataOff,dataLength);

        return new Row(table,oldData,-1,-1);
    }

    /**
     * Update the index row
     * @param index : index of the row to be updated
     * @param data :new data
    **/
    public Row update(int index, byte[] data)throws IOException{
        if(index >= emptyRecord.size() ||emptyRecord.get(index))
            return null;
        setModified(true);
        int bytesLength = data.length;

        // get the old entry
        int enrtyOff = getEntryOff(index);
        inputStream.setPos(enrtyOff);
        int dataOff = inputStream.readInt();
        int dataLength = inputStream.readInt();

        //calculate the delta length of the data : oldLength - newLength
        int deltaLength = dataLength - bytesLength;

        Row updatedRow = null;
        //length doesn't change
        if(deltaLength == 0) {
            outputStream.setPosition(dataOff);
            outputStream.write(data);
            updatedRow =  new Row(table,data,blockIndex,index);
        }
        // the new data is smaller than old data
        else if(deltaLength > 0){
            //write new data
            outputStream.setPosition(enrtyOff);
            outputStream.writeInt(dataOff + deltaLength);
            outputStream.writeInt(bytesLength);
            outputStream.setPosition(dataOff + deltaLength);
            outputStream.write(data);

            // pan the data after updated
            System.arraycopy(content,
                    emptyPointer,
                    content,
                    emptyPointer+deltaLength,
                    dataOff-emptyPointer);
            recordPan(dataOff,deltaLength);

            updatedRow =  new Row(table,data,blockIndex,index);
        }
        // new data is bigger than old one
        else{
            //delete old data
            Row oldRow = delete(index);
            //insert new data
            if(index == emptyRecord.size())
                addNewEntry();
            updatedRow = new Row(table,data,blockIndex,insert(index,data));
        }
        updateMetaByUpdate(index,deltaLength);
        return updatedRow;
    }

    //update the entry with offset bigger than updated offset
    public void recordPan(int offset,int length)throws IOException{
        for(int i = 0;i<emptyRecord.size();i++)
                if(!emptyRecord.get(i)){
                int entryOff = getEntryOff(i);
                inputStream.setPos(entryOff);
                int dataOff = inputStream.readInt();
                if(dataOff < offset && dataOff != -1)
                {
                    outputStream.setPosition(entryOff);
                    outputStream.writeInt(dataOff + length);
                }
            }
    }

    public int getEntryOff(int index){
        return blockHeadSize + index * entrySize;
    }

    public void writeEntry(int index,int off,int length){
        outputStream.setPosition(getEntryOff(index));
        outputStream.writeInt(off);
        outputStream.writeInt(length);
    }

    public void updateMetaByInsert(int index,int dataLength) throws IOException{
        super.updateMetaByInsert(index,dataLength);
        writeMetaToBytes();
    }

    public void updateMetaByDelete(int index,int dataLength)throws IOException{
        super.updateMetaByDelete(index,dataLength);
        writeMetaToBytes();
    }

    public void updateMetaByUpdate(int index,int deltaLength)throws IOException{
        super.updateMetaByUpdate(index,-deltaLength);
        writeMetaToBytes();
    }


    /**
     * Read data from bytes
     * @param index: the index of the row to read
    **/
    public byte[] readRowData(int index) throws IOException {
        if(emptyRecord.size() <= index||emptyRecord.get(index))
            return null;
        int entryOff = getEntryOff(index);
        inputStream.setPos(entryOff);
        int dataOff = inputStream.readInt();
        int dataLength = inputStream.readInt();
        inputStream.setPos(dataOff);
        byte[] data = new byte[dataLength];
        System.arraycopy(content,dataOff,data,0,dataLength);
        return data;
    }


    /**
     * Write block info to the head of the block
    **/
    public void writeMetaToBytes() throws IOException{
        outputStream.setPosition(0);
        outputStream.writeInt(blockSize);
        outputStream.writeInt(rowNum);
        outputStream.writeInt(emptyPointer);
        outputStream.writeInt(emptySize);
    }


}
