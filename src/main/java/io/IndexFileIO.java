package io;

import disk.Row;
import index.*;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;

/**
 * The io manager of index file
 **/

public class IndexFileIO {
    final static char middleNodeLabel = 'm';                //byte to label the type middle node of node
    final static char leafNodeLabel = 'l';                  //byte to label the type leaf node
    final static int emtpyHeadOffset = 17 - 8;                   //the offset of the head of empty list
    final static int prevLength = 8;                        //bytes of the offset of previous node (0 with middle node)
    final static int nextLength = 8;                        //bytes of the offset of next node （0 with middle node)
    final static int labelLength = 1;                       //length of lable of node type
    public final static int offsetLength = 8;                      //64bits length of blockIndex and rowIndex of a row
    final static int sizeLength = 4;                        //byte of the length of the node
    public final static int keyNumLength = 4;                      //byte of the num of the keys
    final static int uniqueLength = 1;
    final static int uniqueOffset = 0;
    final static int rootOffset = 9 - 8;                        //offset of the root
    final static int rootOffsetLength = 8;                  //bytes of offset of the root
    public RandomAccessFile file;
    public File info;
    protected int order;

    public IndexBase index;                          //the index of this file

    protected List<NdxFIleInfo> emptyList;                     //empty offset in file


    public IndexFileIO(File file, int order, IndexBase indexBase) {
        try {
            this.file = new RandomAccessFile(file, "rw");
            this.order = order;
            this.info = file;
            this.index = indexBase;

            emptyList = new LinkedList<>();
//            setLength();
            load(file);
        } catch (Exception e) {
            throw new Error("can't access file:" + file.getName());
        }
    }

    /**
     * Build empty List from file
     **/
    public void loadEmptyList() throws IOException {

        file.seek(emtpyHeadOffset);
        while (true) {
            long offset = file.readLong();
            int size = file.readInt();
            emptyListInsert(new NdxFIleInfo(offset, size));
            if (offset >= file.length())
                break;
            file.seek(offset);
        }
    }

    /**
     * Insert a space into the empty list. the empty list is ascending
     **/
    public void emptyListInsert(NdxFIleInfo empty) {
        //empty
        if (emptyList.size() == 0) {
            emptyList.add(empty);
            return;
        }
        //not empty
        for (int i = 0; i < emptyList.size(); i++)
            if (emptyList.get(i).size >= empty.size) {
                emptyList.add(i, empty);
                return;
            }
        emptyList.add(empty);
    }

    /**
     * Write the head of the empty list to file head
     **/
    public void setEmptyHead(NdxFIleInfo head) throws IOException {
        file.seek(emtpyHeadOffset);
        file.writeLong(head.offset);
        file.writeInt(head.size);
    }

    /**
     * Save the empty list to the file:cover the offsets which exist in the list
     **/
    public void saveEmptyList() throws IOException {
        if (emptyList.size() == 0)
            throw new Error("empty List is empty");

        setEmptyHead(this.emptyList.get(0));

        //set the list left
        if (emptyList.size() > 1) {
            for (int i = 0; i < emptyList.size() - 1; i++) {
                file.seek(emptyList.get(i).offset);
                file.writeLong(emptyList.get(i + 1).offset);
                file.writeInt(emptyList.get(i + 1).size);
            }
        }
    }

    public void saveUnique() throws IOException {
        file.seek(uniqueOffset);
        file.writeBoolean(index.info.isUnique);
    }

    /**
     * Save the offset of the root node to file head
     **/
    public void saveRootOffset() throws IOException {
        file.seek(rootOffset);
        file.writeLong(((NodeIndex) index.root).offset.offset);
    }


    /**
     * Get an empty offset in file
     **/
    public NdxFIleInfo getPreOffset(int size) {
        NdxFIleInfo preOffset = null;

        //if there's no gap in the file
        if (emptyList.size() == 1) {
            preOffset = emptyList.get(0);
            preOffset.size = size;
            emptyList.set(0, new NdxFIleInfo(preOffset.offset + size, Integer.MAX_VALUE));
            return preOffset;
        }
        //return the first gap in the list
        else {
            return getPreStoreInfo(size);
        }
    }

    /**
     * Get an space from a empty list with more than one pieces
     **/
    public NdxFIleInfo getPreStoreInfo(int size) {
        for (int i = 0; i < emptyList.size(); i++) {
            if (emptyList.get(i).size >= size && emptyList.get(i).size != Integer.MAX_VALUE)
                return emptyList.remove(i);
        }
        NdxFIleInfo preOffset = emptyList.get(emptyList.size() - 1);
        preOffset.size = size;
        emptyList.set(emptyList.size() - 1, new NdxFIleInfo(preOffset.offset + size, Integer.MAX_VALUE));
        return preOffset;
    }


    /**
     * Get the length of one node
     **/
    public int getNodeLength(NodeIndex node) {
        int nodeLength = 0;
        nodeLength += sizeLength;
        nodeLength += labelLength;
        nodeLength += prevLength;
        nodeLength += nextLength;
        nodeLength += keyNumLength;
        if (node.isLeaf) {
            for (int i = 0; i < node.keys.size(); i++) {
                nodeLength += IndexKey.getKeyLength(index.info.types);
                nodeLength += ((NodeLeaf) (node.keys.get(i).getValue())).length();
            }
        } else {
            for (int i = 0; i < node.keys.size(); i++) {
                nodeLength += IndexKey.getKeyLength(index.info.types);
                nodeLength += offsetLength;
            }
        }
        return nodeLength;
    }

    public void load(File file) throws IOException {
        if (file.length() == 0) {
            initNewFile(file);
        } else {
            loadEmptyList();
            setRoot();
            setHead();
        }
    }

    /**
     * Return the length of the head of file include (indexType,emptyHead)
     **/
    protected long getHeadLength() {
        return uniqueLength + rootOffsetLength + offsetLength + sizeLength;
    }

    /**
     * Prepare a file for a new index
     **/
    protected void initNewFile(File indexFile) throws IOException {
        file.seek(0);

        //write isUnique
        file.writeBoolean(this.index.info.isUnique);

        NodeIndex root = new NodeIndex(true, true);
        int rootLength = getNodeLength(root);
        file.writeLong(0);
        //init emptyList Head
        file.writeLong(getHeadLength() + rootLength);
        file.writeInt(Integer.MAX_VALUE);


        //set the empty list
        emptyList.add(new NdxFIleInfo(getHeadLength(), Integer.MAX_VALUE));
        // init root node

        root.setOffset(getPreOffset(rootLength));

        index.root = root;
        writeNode(root);
        file.seek(rootOffset);
        file.writeLong(root.offset.offset);

        index.loadedNodes.put(root.offset.offset, root);

    }


    /**
     * Get root from the file
     **/
    void setRoot() throws IOException {
        file.seek(rootOffset);
        long off = file.readLong();
        index.root = readNode(off, true);
    }

    /**
     * Get the head of the leaf nodes
     **/
    public void setHead() {
        NodeIndex start = (NodeIndex) index.root;
        while (!start.isLeaf) {
            start = start.getChildren().get(0);
        }
        index.headLeaf = start;
    }

    /**
     * DeleteNodes which exist in the emptyList
     **/
    public void deleteNodes(NodeIndex node) throws IOException {
        saveEmptyList();
    }


    /**
     * Cover the value on the offset
     *
     * @param node : the value to cover with
     **/
    public void updateNode(NodeIndex node) throws IOException {
        file.seek(node.offset.offset);
        writeNode(node);
    }


    public void writeNode(NodeIndex node) throws IOException {
        if (!node.isLeaf)
            writeMiddleNode(node);
        else
            writeLeafNode(node);
    }

    /**
     * Write a middle to file
     *
     * @param node : the node to be written
     **/
    public void writeMiddleNode(NodeIndex node) throws IOException {
        //node length
        file.writeInt(node.offset.size);
        //node type
        file.writeByte(middleNodeLabel);
        //previous
        file.writeLong(0);
        //next
        file.writeLong(0);

        //key num
        file.writeInt(node.keys.size());


        //children List
        int i = 0;
        for (i = 0; i < node.keys.size(); i++) {
            //key of the child
            writeObject(node.keys.get(i).getKey());
            //offset of the child
            file.writeLong(node.children.get(i).offset.offset);
        }

    }

    /**
     * Write a leaf node to file
     *
     * @param node : node to be written
     **/
    public void writeLeafNode(NodeIndex node) throws IOException {
        //node length
        file.writeInt(node.offset.size);
        //node type
        file.writeByte(leafNodeLabel);
        //previous
        file.writeLong(node.getPreviousOffset());
        //next
        file.writeLong(node.getNextsOffset());

        //key num
        file.writeInt(node.keys.size());


        //child list
        int i = 0;
        for (i = 0; i < node.keys.size(); i++) {
            //key
            writeObject(node.keys.get(i).getKey());

            NodeLeaf leaf = (NodeLeaf) node.keys.get(i).getValue();
            if (leaf == null)
                throw new Error("leaf is null");

            file.writeInt(leaf.rowInfos.size());
            for (int j = 0; j < leaf.rowInfos.size(); j++) {
                file.writeInt(leaf.rowInfos.get(j).blockIndex);
                file.writeInt(leaf.rowInfos.get(j).rowIndex);
            }

        }

    }

    /**
     * Write different type of data to index file
     *
     * @param data :data to be written
     **/
    public void writeObject(Object data) throws IOException {
        if (data instanceof IndexKey) {
            file.write(((IndexKey) data).toBytes());
        }
    }

    /**
     * Create a empty byte array to fill the left space of the key(string type)
     **/
    public byte[] emptyHolderForString(int length) {
        if (length < 0)
            throw new Error("key size overflow");
        return new byte[length];
    }

    public long nullOffset() {
        return (long) (-1);
    }

    /**
     * Recursively read the node on the offset and its children
     **/
    public NodeIndex readNode(long pos, boolean isRoot) throws IOException {
        //if the node is already load then skip
        if (index.loadedNodes.containsKey(pos))
            return index.loadedNodes.get(pos);

        //check the node is root or not and set the offset
        NodeIndex nodeIndex;
        if (isRoot)
            nodeIndex = new NodeIndex(true, true);
        else
            nodeIndex = new NodeIndex(false, true);

        file.seek(pos);


        //get node size
        int nodeSize = file.readInt();
        nodeIndex.offset = new NdxFIleInfo(pos, nodeSize);


        //get node type
        char nodeType = (char) file.readByte();


        //leaf node
        if (nodeType == 'l') {
            nodeIndex.setNodeLeaf();
            //read previous and next
            long prevOffset = file.readLong();
            long nextOffset = file.readLong();
            //key num
            int keyNum = file.readInt();

            for (int i = 0; i < keyNum; i++) {
                Comparable key = (Comparable) readKey();

                //row of this key
                int rowNum = file.readInt();
                NodeLeaf nodeLeaf = new NodeLeaf();
                for (int j = 0; j < rowNum; j++) {
                    //get block num
                    int block = readBlock();
                    //get index in block
                    int blockIndex = readBlockIndex();
                    nodeLeaf.rowInfos.add(new Row(index.table, block, blockIndex));
                }
                nodeIndex.keys.add(new AbstractMap.SimpleEntry<Comparable, Object>(key, nodeLeaf));
            }
            index.loadedNodes.put(pos, nodeIndex);

            //set previous and next pointers
            if (prevOffset != 0) nodeIndex.previous = readNode(prevOffset, false);
            if (nextOffset != 0) nodeIndex.next = readNode(nextOffset, false);
        }
        // middle node
        else {
            nodeIndex.setNodeMiddle();
            long prevOffset = readOffset();
            long nextOffset = readOffset();

            //key num
            int keyNum = file.readInt();


            long lastKey = 0;
            for (int i = 0; i < keyNum; i++) {
                //readkey
                Comparable key = (Comparable) readKey();
                //read child offset
                long offset = file.readLong();

                //keep the read position
                lastKey = file.getFilePointer();

                if (offset == nullOffset())
                    break;
                nodeIndex.keys.add(new AbstractMap.SimpleEntry<Comparable, Object>(key, null));
                NodeIndex child = readNode(offset, false);
                child.parent = nodeIndex;
                nodeIndex.children.add(child);
                file.seek(lastKey);
            }
            index.loadedNodes.put(pos, nodeIndex);
        }
        return nodeIndex;
    }

    public int readBlock() throws IOException {
        return file.readInt();
    }

    public int readBlockIndex() throws IOException {
        return file.readInt();
    }

    public long readOffset() throws IOException {
        return file.readLong();
    }

    public Object readKey() throws IOException {
        int keyLength = IndexKey.getKeyLength(index.info.types);
        byte[] buf = new byte[keyLength];
        file.read(buf, 0, keyLength);
        return new IndexKey(index.info.types, buf);
    }

}
