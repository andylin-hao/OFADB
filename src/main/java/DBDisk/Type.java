package DBDisk;


public class Type {
    public final int typeCode;
    public final int maxLength;
    public final static String nullStringHolder = "empty";

    public Type(int type){
        typeCode  = type;
        maxLength = 0;
    }
    public Type(int type,int length){
        typeCode  = type;
        maxLength = length;
    }

    public Type(String typeStr){
        if(typeStr.startsWith("char")) {
            typeCode = Types.SQL_CHAR;
            maxLength = 0;
        }
        else if(typeStr.startsWith("short")){
            typeCode = Types.SQL_SMALLINT;
            maxLength = 0;
        }
        else if(typeStr.startsWith("int")) {
            typeCode = Types.SQL_INTEGER;
            maxLength = 0;
        }
        else if(typeStr.startsWith("double")){
            typeCode = Types.SQL_DOUBLE;
            maxLength = 0;
        }
        else if(typeStr.startsWith("float")) {
            typeCode = Types.SQL_FLOAT;
            maxLength = 0;
        }
        else if(typeStr.startsWith("bool")) {
            typeCode = Types.SQL_BOOLEAN;
            maxLength = 0;
        }
        else if(typeStr.startsWith("long")) {
            typeCode = Types.SQL_LONG;
            maxLength = 0;
        }
        else if(typeStr.startsWith("string")){
            typeCode = Types.SQL_VARCHAR;
            maxLength = Integer.parseInt(typeStr.substring(6));
        }
        else{
            typeCode = -1;
            maxLength = -1;
        }

    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  Type))
            return false;
        return typeCode == ((Type) obj).typeCode && maxLength == ((Type) obj).maxLength;
    }

    public boolean isVariable(){
        return typeCode == Types.SQL_VARCHAR;
    }

    public int variableLength(){
        switch (typeCode){
            case Types.SQL_CHAR:
            case Types.SQL_SMALLINT:
                return 2;
            case Types.SQL_INTEGER:
                return 4;
            case Types.SQL_VARCHAR:
                return maxLength*2;
            case Types.SQL_DOUBLE:
                return 8;
            case Types.SQL_FLOAT:
                return 4;
            case Types.SQL_BOOLEAN:
                return 1;
            case Types.SQL_LONG:
                return 8;
            default:
                return 0;
        }
    }

    public Object nullHolder(){
        switch (typeCode){
            case Types.SQL_CHAR:
            case Types.SQL_SMALLINT:
                return (char)0;
            case Types.SQL_INTEGER:
                return (int)0;
            case Types.SQL_VARCHAR:
                return nullStringHolder;
            case Types.SQL_DOUBLE:
                return (double)0;
            case Types.SQL_FLOAT:
                return (float)0;
            case Types.SQL_BOOLEAN:
                return false;
            case Types.SQL_LONG:
                return (long)0;
            default:
                return null;
        }
    }

    public int getVariableTypeLength(Object data){
        if (data == null)
            if(typeCode == Types.SQL_VARCHAR)
                return nullStringHolder.length()*2;
        if (data instanceof String) {
                return ((String) data).length() * 2;
        }
        return 0;
    }

    @Override
    public String toString() {
        switch (typeCode){
            case Types.SQL_CHAR:
                return "char";
            case Types.SQL_SMALLINT:
                return "short";
            case Types.SQL_INTEGER:
                return "int";
            case Types.SQL_VARCHAR:
                return "string"+maxLength;
            case Types.SQL_DOUBLE:
                return "double";
            case Types.SQL_FLOAT:
                return "float";
            case Types.SQL_BOOLEAN:
                return "bool";
            case Types.SQL_LONG:
                return "long";
            default:
                return "";
        }
    }

    public static Type intType(){
        return new Type(Types.SQL_INTEGER);
    }

    public static Type stringType(int maxLength){
        return new Type(Types.SQL_VARCHAR,maxLength);
    }
}
