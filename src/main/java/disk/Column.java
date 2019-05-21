package disk;

public class Column {
    public Type columnType;
    public String columnName;
    public boolean isUnique;
    public  boolean nullable;
    public final static String segment = ",";

    public Column(Type columnType, String name) {
        this.columnType = columnType;
        columnName = name;
        isUnique = false;
        nullable = true;
    }

    public Column(int typeCode, String name) {
        this.columnType = new Type(typeCode);
        columnName = name;
        isUnique = false;
        nullable = true;
    }

    public Column(String columnString) {
        String[] infos = columnString.split(Column.segment);
        columnName = infos[0];
        columnType = new Type(infos[1]);
        isUnique = Integer.parseInt(infos[2]) == 1;
        nullable = Integer.parseInt(infos[3]) == 1;
    }

    @Override
    public String toString() {
        return columnName + Column.segment
                + columnType.toString() + Column.segment
                + ((Integer)(isUnique ? 0:1)).toString() + Column.segment
                + ((Integer)(nullable ? 0:1)).toString();
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
}
