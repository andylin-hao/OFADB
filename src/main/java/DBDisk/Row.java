package DBDisk;

import java.io.IOException;
import IO.*;

public class Row {
    /**
     * @Description : the indication of a row in memory
    **/
    public Object[] rowData;                                        // data in object form
    public Table table;
    public int blockIndex;                                          //the block index of the block where this row stored in
    public int rowIndex;                                            //the index of this row in the block

    public Row(Table table, byte[] dataBytes, int bindex, int rindex) throws IOException {
        this.table = table;
        rowData = RowIO.getRowData(table.columnTypes,dataBytes);
        blockIndex = bindex;
        rowIndex = rindex;
    }
    public Row(Table table, byte[] dataBytes) throws IOException {
        this.table = table;
        rowData = RowIO.getRowData(table.columnTypes,dataBytes);
        blockIndex = -1;
        rowIndex = -1;
    }

    public Row(Table table, Object[] data){
        this.table = table;
        this.rowData = data;
        blockIndex = -1;
        rowIndex = -1;
    }

    public Row(Table table, int blockIndex, int rowIndex){
        this.table = table;
        this.blockIndex = blockIndex;
        this.rowIndex = rowIndex;
        this.rowData = null;
    }

    public Row(Row row){
        this.blockIndex = row.blockIndex;
        this.rowIndex = row.rowIndex;
        this.rowData = null;
        this.table = row.table;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Row){
            return ((Row) obj).blockIndex == blockIndex && ((Row) obj).rowIndex == rowIndex;
        }
        return false;
    }
}
