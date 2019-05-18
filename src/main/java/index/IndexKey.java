package index;

import io.MDBByteArrayInputStream;
import io.MDBByteArrayOutputStream;
import disk.Type;
import disk.Types;

import java.io.IOException;

public class IndexKey implements Comparable{
    public Type[] types;                            // types of each column engaged in the index
    public Object[] values;                         // values of the columns

    public IndexKey(Type[] types1,Object[] values1){
        types = types1;
        values = values1;
    }

    public IndexKey(Type[] types1,byte[] buf)throws IOException {
        types = types1;
        values = fromBytes(buf);

    }

    public byte[] toBytes()throws IOException{
        int totalLength = IndexKey.getKeyLength(this.types);
        byte[] bytes = new byte[totalLength];
        MDBByteArrayOutputStream outputStream = new MDBByteArrayOutputStream(bytes);
        for(int i = 0;i<values.length;i++){
            if(types[i].typeCode != Types.SQL_VARCHAR)
                outputStream.writeObject(values[i]);
            else{
                outputStream.writeObject(values[i]);
                int skipLength = types[i].variableLength() - ((String)values[i]).length()*2;
                outputStream.skip(skipLength);
            }
        }
        return bytes;
    }

    public Object[] fromBytes(byte[] buf)throws IOException{
        Object[] objects = new Object[types.length];
        MDBByteArrayInputStream reader = new MDBByteArrayInputStream(buf);
        for(int i = 0;i<types.length;i++)
            if(types[i].typeCode != Types.SQL_VARCHAR)
                objects[i] = reader.readObject(types[i],types[i].variableLength());
            else
                objects[i] = stringFilter((String)reader.readObject(types[i],types[i].variableLength()));
        return objects;
    }

    public static int getKeyLength(Type[] types){
        int totalLength = 0;
        for(int i = 0;i<types.length;i++)
            totalLength += types[i].variableLength();
        return totalLength;
    }

    public String stringFilter(String origin)throws IOException{
        String resultStr = "";
        for(int i = 0;i<origin.length();i++){
            if(origin.charAt(i) != '\0')
                resultStr += origin.charAt(i);
        }
        return resultStr;
    }

    @Override
    public int hashCode() {
        int hashStr = 0;
        for(Object ele : values)
            hashStr +=ele.hashCode();
        return hashStr;
    }

    public boolean equalTypes(Type[] types1){
        if(types1.length != types.length)
            return false;
        for(int i = 0;i<types1.length;i++)
            if(!types1[i].equals(types[i]))
                return false;
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof IndexKey))
            return false;
        if(!equalTypes(((IndexKey) obj).types))
            return false;
        for(int i = 0;i<values.length;i++)
            if(!values[i].equals(((IndexKey) obj).values[i]))
                return false;
        return true;
    }

    @Override
    public int compareTo(Object o) {
        for(int i = 0;i<values.length;i++){
            int compare = ((Comparable)values[i]).compareTo(((IndexKey)o).values[i]);
            if(compare != 0)
                return compare;
            else if(i == values.length-1)
                return compare;
        }
        return 0;
    }

    @Override
    public String toString() {
        String str = "(";
        for(int i = 0;i<values.length;i++) {
            str += values[i].toString();
            if(i != values.length-1) str += ",";
        }
        str += ")";
        return str;
    }
}
