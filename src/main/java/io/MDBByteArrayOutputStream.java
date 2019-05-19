package io;

import java.io.*;

/**
 * An outputStream to handle writing work of a byte array.
 **/

public class MDBByteArrayOutputStream {

    protected byte[] buffer;
    protected int count;

    public MDBByteArrayOutputStream(byte[] buffer) {
        this.buffer = buffer;
    }


    // methods that implement dataOutput
    public void writeShort(int v) {

        buffer[count++] = (byte) (v >>> 8);
        buffer[count++] = (byte) v;
    }

    public void writeInt(int v) {

        buffer[count++] = (byte) (v >>> 24);
        buffer[count++] = (byte) (v >>> 16);
        buffer[count++] = (byte) (v >>> 8);
        buffer[count++] = (byte) v;
    }

    public void writeLong(long v) {
        writeInt((int) (v >>> 32));
        writeInt((int) v);
    }

    public void writeBytes(String s) {

        int len = s.length();

        for (int i = 0; i < len; i++) {
            buffer[count++] = (byte) s.charAt(i);
        }
    }

    public final void writeFloat(float v) {
        writeInt(Float.floatToIntBits(v));
    }

    public final void writeDouble(double v) {
        writeLong(Double.doubleToLongBits(v));
    }

    public void writeBoolean(boolean v) {

        buffer[count++] = (byte) (v ? 1
                : 0);
    }

    public void writeByte(int v) {

        buffer[count++] = (byte) v;
    }

    public void writeChar(int v) {

        buffer[count++] = (byte) (v >>> 8);
        buffer[count++] = (byte) v;
    }

    public void writeChars(String s) {

        int len = s.length();

        for (int i = 0; i < len; i++) {
            int v = s.charAt(i);

            buffer[count++] = (byte) (v >>> 8);
            buffer[count++] = (byte) v;
        }
    }

    /**
     * does nothing
     */
    public void flush() throws IOException {
    }

    // methods that extend java.io.OutputStream
    public void write(int b) {

        buffer[count++] = (byte) b;
    }

    public void write(byte[] b) {
        write(b, 0, b.length);
    }

    public void write(byte[] b, int off, int len) {
        System.arraycopy(b, off, buffer, count, len);

        count += len;
    }

    public String toString() {
        return new String(buffer, 0, count);
    }

    public void close() throws IOException {
    }

    // additional public methods not in similar java.util classes
    public void writeNoCheck(int b) {
        buffer[count++] = (byte) b;
    }

    public void writeChars(char[] charArray) {

        int len = charArray.length;

        for (int v : charArray) {
            buffer[count++] = (byte) (v >>> 8);
            buffer[count++] = (byte) v;
        }
    }

    public int write(InputStream input, int countLimit) throws IOException {

        int left = countLimit;

        while (left > 0) {
            int read = input.read(buffer, count, left);

            if (read == -1) {
                break;
            }

            left -= read;
            count += read;
        }

        return countLimit - left;
    }

    public int write(Reader input, int countLimit) throws IOException {

        int left = countLimit;
        while (left > 0) {
            int c = input.read();

            if (c == -1) {
                break;
            }

            writeChar(c);

            left--;
        }

        return countLimit - left;
    }

    public void writeTo(OutputStream out) throws IOException {
        out.write(buffer, 0, count);
    }

    public void reset() {
        count = 0;
    }

    public byte[] toByteArray() {

        byte[] newbuf = new byte[count];

        System.arraycopy(buffer, 0, newbuf, 0, count);

        return newbuf;
    }

    final public int size() {
        return count;
    }

    public void setPosition(int newPos) {

        if (newPos > buffer.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        count = newPos;
    }

    public String toString(String enc) throws UnsupportedEncodingException {
        return new String(buffer, 0, count, enc);
    }

    public void write(char[] c, int off, int len) {

        for (int i = off; i < len; i++) {
            int v = c[i];

            buffer[count++] = (byte) (v >>> 8);
            buffer[count++] = (byte) v;
        }
    }

    public void fill(int b, int len) {

        for (int i = 0; i < len; i++) {
            buffer[count++] = (byte) b;
        }
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public void reset(byte[] buffer) {
        count = 0;
        this.buffer = buffer;
    }

    public void writeObject(Object data) throws IOException {
        if (data instanceof Integer)
            writeInt((int) data);
        else if (data instanceof Character)
            writeChar((char) data);
        else if (data instanceof Short)
            writeShort((short) data);
        else if (data instanceof Float)
            writeFloat((float) data);
        else if (data instanceof Double)
            writeDouble((double) data);
        else if (data instanceof String)
            writeChars((String) data);
        else if (data instanceof Long)
            writeLong((long) data);
        else if (data instanceof Boolean)
            writeBoolean((boolean) data);
        else
            throw new Error("invalid data type");
    }

    public void skip(int walks) {
        count = Math.min(buffer.length, walks + count);
    }

    public void writeObjects(Object[] data) throws IOException {
        for (Object datum : data) writeObject(datum);
    }
}