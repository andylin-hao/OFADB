package meta;

import disk.Logger;
import disk.Table;
import disk.Type;

public class IndexInfo {
    public Table table;
    public int[] columnIndex;
    public Type[] types;
    public boolean isUnique;

    public IndexInfo(int[] column,boolean isUnique){
        this.columnIndex = column;
        this.isUnique = isUnique;
    }

    public IndexInfo(int column,boolean isUnique){
        this.columnIndex = new int[1];
        this.columnIndex[0] = column;
        this.isUnique = isUnique;
    }

    public IndexInfo(String columnInfo,boolean isUnique){
        String[] infoSpliced = columnInfo.split(Logger.columnIndexStringSegment);
        columnIndex = new int[infoSpliced.length];
        for (int j = 0; j < infoSpliced.length; j++) {
            columnIndex[j] = (Integer.parseInt(infoSpliced[j]));
        }
        this.isUnique = isUnique;
    }

    public void setTable(Table table){
        this.table = table;
        loadTypes();
    }

    public void loadTypes(){
        types = new Type[columnIndex.length];
        for(int i = 0;i<types.length;i++)
            types[i] = table.info.columnTypes[columnIndex[i]];
    }

    public String columnIndexString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<columnIndex.length;i++) {
            stringBuilder.append(((Integer) columnIndex[i]).toString());
            if(i != columnIndex.length-1)
                stringBuilder.append(Logger.columnIndexStringSegment);
        }
        return stringBuilder.toString();
    }

}
