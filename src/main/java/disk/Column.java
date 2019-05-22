package disk;

import types.ColumnTypes;

public class Column {
    public Type columnType;
    public String columnName;
    public boolean autoIncr;
    public Integer incrStart;
    public  boolean nullable;
    public final static String segment = ",";
    public Table table;

    public Column(Type columnType, String name) {
        this.columnType = columnType;
        columnName = name;
        autoIncr = false;
        nullable = true;
        incrStart = 0;
    }

    public Column(String columnName,Type columnType,boolean autoIncr,boolean nullable,Integer incrStart){
        this.columnName = columnName;
        this.columnType = columnType;
        this.incrStart = incrStart;
        this.autoIncr = autoIncr;
        this.nullable = nullable;
    }

    public Column(String columnString) {
        String[] infos = columnString.split(Column.segment);
        columnName = infos[0];
        columnType = new Type(infos[1]);
        autoIncr = Integer.parseInt(infos[2]) == 1;
        nullable = Integer.parseInt(infos[3]) == 1;
        incrStart = Integer.parseInt(infos[4]);
    }

    @Override
    public String toString() {
        return columnName + Column.segment
                + columnType.toString() + Column.segment
                + ((Integer)(autoIncr ? 0:1)).toString() + Column.segment
                + ((Integer)(nullable ? 0:1)).toString() + Column.segment
                + (incrStart).toString();
    }

    public static String columnsToString(Column[] columns) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < columns.length; i++) {
            str.append(columns[i].toString());
            if (i != columns.length - 1)
                str.append(Logger.tableColumnNameSegment);
        }
        return str.toString();
    }

    public static Column[] columnsFromString(String columnsString) {
        String[] columnStrings = columnsString.split(Logger.tableColumnNameSegment);
        Column[] columns = new Column[columnStrings.length];
        for (int i = 0; i < columns.length; i++) {
            columns[i] = new Column(columnStrings[i]);
        }
        return columns;
    }

    public void setTable(Table table){
        this.table = table;
    }
}
