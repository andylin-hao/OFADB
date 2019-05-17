package IO;

import DBDisk.Type;

import java.io.IOException;


/** 
* @Description: the methods to load rowData from bytes and write rowData to Bytes.
**/
public  class RowIO {

    public final static int                 rowHeadSize = 4;                //the number of bytes before entry field
    public final static int                 variableFieldEntry  = 8;        //the size of an entry (int off,int length)
    
    
    /** 
    * @Description:  load rowData from bytes
     * @param dataBytes : the bytes arrays
     * @param types : the array of column types
    **/
    public static Object[] getRowData(Type[] types, byte[] dataBytes) throws IOException {
        MDBByteArrayInputStream dataLoader = new MDBByteArrayInputStream(dataBytes);
        Object[] data = new Object[types.length];
        boolean[] nullList = nullBitMap(dataBytes,types,dataLoader);
        int fixedFieldOff = loadvariableField(types,data,dataLoader);
        loadFixedField(types,data,dataLoader,fixedFieldOff);
        checkDataByNullBitMap(data,nullList);
        return data;
    }

    /**
    * @Description: get the BitMap of null value from the data bytes, 0 = null
     * @param types : the array of column types
     * @param data : the bytes arrays
     * @param dataLoader : the input stream with the data bytes as buffer
    **/
    public static boolean[] nullBitMap(byte[] data, Type[] types, MDBByteArrayInputStream dataLoader){
        int bytesNum = (types.length/4) + ((types.length % 4) == 0 ? 0:1);
        byte[] nullBitMap = new byte[bytesNum];
        boolean[] nullList = new boolean[types.length];
        System.arraycopy(data,0,nullBitMap,0,bytesNum);
        for(int i = 0;i<types.length;i++){
            nullList[i] = (((nullBitMap[i/4] & (1<< (3-i%4))) != 0));
        }
        dataLoader.setPos(bytesNum);
        return nullList;
    }

    /**
    * @Description: set data of column which has 0 in null Bitmap to null
     * @param data : the bytes arrays
     * @param nullBitMap :the null flag of column data
    **/
    public static void checkDataByNullBitMap(Object[] data,boolean[] nullBitMap){
        for(int i = 0;i<data.length;i++)
            if(!nullBitMap[i])
                data[i] = null;
    }

    /**
    * @Description: load the data of column which has variable length from bytes
     * @param types : the array of column types
     * @param data : the bytes arrays
     * @param dataLoader : the input stream with the data bytes as buffer
    **/
    public static int loadvariableField(Type[] types, Object[] data, MDBByteArrayInputStream dataLoader)throws IOException{
        int originPointer = dataLoader.getPos();
        for(int i = 0;i<types.length;i++){
            if(types[i].isVariable()) {
                int off = dataLoader.readInt();
                int length = dataLoader.readInt();
                originPointer = dataLoader.getPos();
                dataLoader.setPos(off);
                data[i] = dataLoader.readObject(types[i],length);
                dataLoader.setPos(originPointer);
            }
        }
        return originPointer;
    }

    /**
    * @Description: load the data of column which has fixed length from bytes* @param types : the array of column types
     * @param types : the array of column types
     * @param data : the bytes arrays
     * @param dataLoader : the input stream with the data bytes as buffer
    **/
    public static void loadFixedField(Type[] types, Object[] data, MDBByteArrayInputStream dataLoader, int off)throws IOException{
        dataLoader.setPos(off);
        for(int i = 0;i<types.length;i++){
            if(!types[i].isVariable())
                data[i] = dataLoader.readObject(types[i],types[i].variableLength());
        }
    }

    /**
    * @Description: write row data to bytes
     * @param data : array of object data
     * @param types : type array
    **/
    public static byte[] writeRowData(Type[] types, Object[] data)throws IOException{
        byte[] nullBitMap = writeNullBitMap(types,data);
        byte[] fields = writeFields(types,data,nullBitMap.length);
        byte[] dataBytes = new byte[nullBitMap.length + fields.length];
        System.arraycopy(nullBitMap,0,dataBytes,0,nullBitMap.length);
        System.arraycopy(fields,0,dataBytes,nullBitMap.length,fields.length);
        return dataBytes;
    }

    /**
    * @Description:  write the null BitMap to bytes,0 = null
     * @param data : array of object data
     * @param types : type array
    **/
    public static byte[] writeNullBitMap(Type[] types, Object[] data){
        int bytesNum = (types.length/4) + ((types.length % 4) == 0 ? 0:1);
        byte[] nullBitMap = new byte[bytesNum];
        for(int i = 0;i<types.length;i++){
            if(data[i] == null)
                nullBitMap[i/4]  = (byte)(nullBitMap[i/4] | (1<< (3-i%4)));
        }
        for(int i = 0;i<bytesNum;i++)
            nullBitMap[i] = (byte)(nullBitMap[i] ^ 15);
        return nullBitMap;
    }


    /**
    * @Description: write Columns data to bytes
     * @param data : array of object data
     * @param types : type array
     * @param nullBitMapSize :the size (byte) of nullBitMap
    **/
    public static byte[] writeFields(Type[] types, Object[] data, int nullBitMapSize)throws IOException{
        int fixedFieldsLength = 0;
        int variableFieldsLength = 0;
        int variableFieldNum = 0;

        //calculate the length of entry,fixedField,variableField
        for(int i = 0;i<types.length;i++) {
            if (!types[i].isVariable())
                fixedFieldsLength += types[i].variableLength();
            else{
                variableFieldNum++;
                variableFieldsLength +=types[i].getVariableTypeLength(data[i]);
            }
        }


        byte[] fileds = new byte[fixedFieldsLength + variableFieldsLength + variableFieldNum * variableFieldEntry];
        MDBByteArrayOutputStream dataWriter = new MDBByteArrayOutputStream(fileds);

        //record the pointers of different parts
        int fixedPointer = variableFieldNum * variableFieldEntry;
        int variablePointer = variableFieldNum * variableFieldEntry + fixedFieldsLength;
        int entryPointer = 0;

        //write fields
        for(int i = 0;i<types.length;i++){
            if(types[i].isVariable()){
                entryPointer = writeEntry(entryPointer,variablePointer + nullBitMapSize,types[i].getVariableTypeLength(data[i]),dataWriter);
                variablePointer = writeObject(variablePointer,data[i],types[i],dataWriter);
            }
            else{
                fixedPointer = writeObject(fixedPointer,data[i],types[i],dataWriter);
            }
        }
        return fileds;
    }

    /**
    * @Description: write column data
     * @param data :data to write
     * @param off :pointer to start writing
     * @param type:data type
     * @param dataWriter :the output stream with the result bytes as buffer
     **/
    public static int writeObject(int off, Object data, Type type, MDBByteArrayOutputStream dataWriter)throws IOException{
        dataWriter.setPosition(off);
        if(data != null)
            dataWriter.writeObject(data);
        else
            dataWriter.writeObject(type.nullHolder());
        return dataWriter.count;
    }

    /**
    * @Description: write the entry of (offset,length) for the variable column
     * @param off : offset of the data
     * @param length :length of the data
     * @param dataWriter :the output stream with the result bytes as buffer
     * @param entryOff :the pointer to start writing the entry
    **/
    public static int writeEntry(int entryOff, int off, int length, MDBByteArrayOutputStream dataWriter) throws  IOException{
        dataWriter.setPosition(entryOff);
        dataWriter.writeInt(off);
        dataWriter.writeInt(length);
        return dataWriter.count;
    }

}
