package disk;

public class Column {
    public Type columnType;
    public String columnName;
    public boolean isUnique;
    public boolean isPrimaryKey;
    public boolean hasIndex;
    public final static String segment = ",";

    public Column(Type columnType, String name, boolean hasIndex){
        this.columnType = columnType;
        columnName = name;
        this.hasIndex = hasIndex;
    }

    public Column(int typeCode,String name,boolean hasIndex){
        this.columnType = new Type(typeCode);
        columnName = name;
        this.hasIndex = hasIndex;
    }
    public Column(Type columnType,String columnName){
        this.columnType = columnType;
        this.columnName = columnName;
        this.hasIndex = false;
    }

    public Column(String columnString){
        String[] infos = columnString.split(Column.segment);
        columnName = infos[0];
        columnType = new Type(infos[1]);
    }

    @Override
    public String toString() {
        return columnName + Column.segment + columnType.toString();
    }

    public static String columnsToString(Column[] columns){
        String str = "";
        for(int i = 0;i<columns.length;i++){
            str +=columns[i].toString();
            if(i != columns.length-1)
                str +=Logger.tableColumnNameSegment;
        }
        return str;
    }

    public static Column[] columnsFromString(String columnsString){
        String[] columnStrings = columnsString.split(Logger.tableColumnNameSegment);
        Column[] columns = new Column[columnStrings.length];
        for(int i = 0;i<columns.length;i++){
            columns[i] = new Column(columnStrings[i]);
        }
        return columns;
    }
}