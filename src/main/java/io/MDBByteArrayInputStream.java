package io;

import disk.Type;
import disk.Types;

import java.io.EOFException;
import java.io.IOException;

public class MDBByteArrayInputStream{
    /**
     * @Classname : MDBByteArrayInputStream
     * @Description : An inputStream to handle reading work of a byte array.
     **/

    protected byte[] buffer;
    protected int    pos;
    protected int    mark = 0;
    protected int    count;

    public MDBByteArrayInputStream(byte[] buf) {

        this.buffer = buf;
        this.pos    = 0;
        this.count  = buf.length;
    }

    public MDBByteArrayInputStream(byte[] buf, int offset, int length) {

        this.buffer = buf;
        this.pos    = offset;
        this.count  = Math.min(offset + length, buf.length);
        this.mark   = offset;
    }

    public final int getPos() {
        return pos;
    }

    public final void setPos(int pos){
        if(pos<this.buffer.length)
            this.pos = pos;
    }

    // methods that implement java.io.DataInput
    public void readFully(byte[] b) throws IOException {
        readFully(b, 0, b.length);
    }
    //off:file offset len:bytes need to be red
    public final void readFully(byte[] b, int off,
                                int len) throws IOException {

        if (len < 0) {
            throw new IndexOutOfBoundsException();
        }

        int n = 0;

        while (n < len) {
            int count = read(b, off + n, len - n);

            if (count < 0) {
                throw new EOFException();
            }

            n += count;
        }
    }

    public boolean readBoolean() throws IOException {

        int ch = read();

        if (ch < 0) {
            throw new EOFException();
        }

        return ch != 0;
    }

    public byte readByte() throws IOException {

        int ch = read();

        if (ch < 0) {
            throw new EOFException();
        }

        return (byte) ch;
    }

    public final int readUnsignedByte() throws IOException {

        int ch = read();

        if (ch < 0) {
            throw new EOFException();
        }

        return ch;
    }

    public short readShort() throws IOException {

        if (count - pos < 2) {
            pos = count;

            throw new EOFException();
        }

        int ch1 = buffer[pos++] & 0xff;
        int ch2 = buffer[pos++] & 0xff;

        return (short) ((ch1 << 8) + ch2);
    }

    public final int readUnsignedShort() throws IOException {

        int ch1 = read();
        int ch2 = read();

        if ((ch1 | ch2) < 0) {
            throw new EOFException();
        }

        return (ch1 << 8) + ch2;
    }

    public char readChar() throws IOException {

        int ch1 = read();
        int ch2 = read();

        if ((ch1 | ch2) < 0) {
            throw new EOFException();
        }

        return (char) ((ch1 << 8) + ch2);
    }

    public String readString(int length)throws IOException{
        String string = new String();
        for(int i = 0;i<length/2;i++){
            string +=readChar();
        }
        return string;
    }

    public int readInt() throws IOException {

        if (count - pos < 4) {
            pos = count;

            throw new EOFException();
        }

        int ch1 = buffer[pos++] & 0xff;
        int ch2 = buffer[pos++] & 0xff;
        int ch3 = buffer[pos++] & 0xff;
        int ch4 = buffer[pos++] & 0xff;

        return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + ch4);
    }

    public long readLong() throws IOException {
        return (((long) readInt()) << 32) + (((long) readInt()) & 0xffffffffL);
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    public int skipBytes(int n) throws IOException {
        return (int) skip(n);
    }

    public String readLine() throws IOException {

        /** @todo: this will probably be useful */
        throw new UnsupportedOperationException("not implemented");
    }

    // methods that extend java.io.InputStream
    public int read() {
        return (pos < count) ? (buffer[pos++] & 0xff)
                : -1;
    }

    public int read(byte[] b, int off, int len) {

        if (pos >= count) {
            return -1;
        }

        if (pos + len > count) {
            len = count - pos;
        }

        if (len <= 0) {
            return 0;
        }

        System.arraycopy(buffer, pos, b, off, len);

        pos += len;

        return len;
    }

    public long skip(long n) {

        if (pos + n > count) {
            n = count - pos;
        }

        if (n < 0) {
            return 0;
        }

        pos += n;

        return n;
    }

    public int available() {
        return count - pos;
    }

    public boolean markSupported() {
        return true;
    }

    public void mark(int readAheadLimit) {
        mark = pos;
    }

    public void reset() {
        pos = mark;
    }

    public void close() throws IOException {}

    public Object readObject(Type type, int length)throws IOException{
        switch (type.typeCode){
            case Types.SQL_CHAR:
                return readChar();
            case Types.SQL_SMALLINT:
                return readShort();
            case Types.SQL_INTEGER:
                return readInt();
            case Types.SQL_FLOAT:
                return readFloat();
            case Types.SQL_LONG:
                return readLong();
            case Types.SQL_DOUBLE:
                return readDouble();
            case Types.SQL_BOOLEAN:
                return readBoolean();
            case Types.SQL_VARCHAR:
                return readString(length);
        }
        return null;
    }
}