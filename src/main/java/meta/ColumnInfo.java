package meta;

import disk.Logger;
import disk.Table;
import disk.Type;
import index.IndexBase;


public class ColumnInfo {
    public Type columnType;
    public String columnName;
    public boolean autoIncr;
    public Integer incrStart;
    public  boolean nullable;
    public final static String segment = ",";
    public Table table;

    public ColumnInfo(Type columnType, String name) {
        this.columnType = columnType;
        columnName = name;
        autoIncr = false;
        nullable = true;
        incrStart = 0;
    }

    public ColumnInfo(String columnName, Type columnType, boolean autoIncr, boolean nullable, Integer incrStart){
        this.columnName = columnName;
        this.columnType = columnType;
        this.incrStart = incrStart;
        this.autoIncr = autoIncr;
        this.nullable = nullable;
    }

    public ColumnInfo(String columnString) {
        String[] infos = columnString.split(ColumnInfo.segment);
        columnName = infos[0];
        columnType = new Type(infos[1]);
        autoIncr = Integer.parseInt(infos[2]) == 1;
        nullable = Integer.parseInt(infos[3]) == 1;
        incrStart = Integer.parseInt(infos[4]);
    }

    @Override
    public String toString() {
        return columnName + ColumnInfo.segment
                + columnType.toString() + ColumnInfo.segment
                + ((Integer)(autoIncr ? 0:1)).toString() + ColumnInfo.segment
                + ((Integer)(nullable ? 0:1)).toString() + ColumnInfo.segment
                + (incrStart).toString();
    }

    public static String columnsToString(ColumnInfo[] columns) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < columns.length; i++) {
            str.append(columns[i].toString());
            if (i != columns.length - 1)
                str.append(Logger.tableColumnNameSegment);
        }
        return str.toString();
    }

    public static ColumnInfo[] columnsFromString(String columnsString) {
        String[] columnStrings = columnsString.split(Logger.tableColumnNameSegment);
        ColumnInfo[] columns = new ColumnInfo[columnStrings.length];
        for (int i = 0; i < columns.length; i++) {
            columns[i] = new ColumnInfo(columnStrings[i]);
        }
        return columns;
    }

    public void setTable(Table table){
        this.table = table;
    }

    public IndexBase hasIndex(){
        int index = 0;
        for(int i = 0;i<table.info.columns.length;i++) {
            if (table.info.columns[i].equals(this)) {
                index = i;
                break;
            }
            if(i == table.info.columns.length-1)
                throw new RuntimeException("Error in check index of column");
        }
        int[] columnIndexs = new int[1];
        columnIndexs[0] = index;
        return table.getIndexByColumns(columnIndexs);
    }

    public Integer getAutoIncrValue(){
        return incrStart++;
    }
}
