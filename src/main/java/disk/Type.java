package disk;


import types.ColumnTypes;

public class Type {
    public final ColumnTypes typeCode;
    public final int maxLength;
    public final static String nullStringHolder = "empty";

    public Type(ColumnTypes type) {
        typeCode = type;
        maxLength = 0;
    }

    public Type(ColumnTypes type, int length) {
        typeCode = type;
        if(typeCode.equals(ColumnTypes.COL_VARCHAR))
            maxLength = length;
        else
            maxLength = 0;
    }

    public Type(String typeStr) {
        if (typeStr.startsWith("char")) {
            typeCode = ColumnTypes.COL_CHAR;
            maxLength = 0;
        } else if (typeStr.startsWith("short")) {
            typeCode = ColumnTypes.COL_SHORT;
            maxLength = 0;
        } else if (typeStr.startsWith("int")) {
            typeCode = ColumnTypes.COL_INT;
            maxLength = 0;
        } else if (typeStr.startsWith("double")) {
            typeCode = ColumnTypes.COL_DOUBLE;
            maxLength = 0;
        } else if (typeStr.startsWith("float")) {
            typeCode = ColumnTypes.COL_FLOAT;
            maxLength = 0;
        } else if (typeStr.startsWith("bool")) {
            typeCode = ColumnTypes.COL_BOOL;
            maxLength = 0;
        } else if (typeStr.startsWith("long")) {
            typeCode = ColumnTypes.COL_LONG;
            maxLength = 0;
        } else if (typeStr.startsWith("string")) {
            typeCode = ColumnTypes.COL_VARCHAR;
            maxLength = Integer.parseInt(typeStr.substring(6));
        } else {
            typeCode = null;
            maxLength = -1;
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Type))
            return false;
        return typeCode == ((Type) obj).typeCode && maxLength == ((Type) obj).maxLength;
    }

    public boolean isVariable() {
        return typeCode == ColumnTypes.COL_VARCHAR;
    }

    public int variableLength() {
        switch (typeCode) {
            case COL_CHAR:
            case COL_SHORT:
                return 2;
            case COL_INT:
            case COL_FLOAT:
                return 4;
            case COL_VARCHAR:
                return maxLength * 2;
            case COL_DOUBLE:
            case COL_LONG:
                return 8;
            case COL_BOOL:
                return 1;
            default:
                return 0;
        }
    }

    public Object nullHolder() {
        switch (typeCode) {
            case COL_CHAR:
            case COL_SHORT:
                return (char) 0;
            case COL_INT:
                return 0;
            case COL_VARCHAR:
                return nullStringHolder;
            case COL_DOUBLE:
                return (double) 0;
            case COL_FLOAT:
                return (float) 0;
            case COL_BOOL:
                return false;
            case COL_LONG:
                return (long) 0;
            default:
                return null;
        }
    }

    public int getVariableTypeLength(Object data) {
        if (data == null)
            if (typeCode == ColumnTypes.COL_VARCHAR)
                return nullStringHolder.length() * 2;
        if (data instanceof String) {
            return ((String) data).length() * 2;
        }
        return 0;
    }

    @Override
    public String toString() {
        switch (typeCode) {
            case COL_CHAR:
                return "char";
            case COL_SHORT:
                return "short";
            case COL_INT:
                return "int";
            case COL_VARCHAR:
                return "string" + maxLength;
            case COL_DOUBLE:
                return "double";
            case COL_FLOAT:
                return "float";
            case COL_BOOL:
                return "bool";
            case COL_LONG:
                return "long";
            default:
                return "";
        }
    }

    public static Type intType() {
        return new Type(ColumnTypes.COL_INT);
    }

    public static Type stringType(int maxLength) {
        return new Type(ColumnTypes.COL_VARCHAR, maxLength);
    }

    public static Type boolType(){ return new Type(ColumnTypes.COL_BOOL); }

    public static Type longType(){ return new Type(ColumnTypes.COL_LONG); }

    public ColumnTypes getColumnTypes() {return typeCode; }
}
