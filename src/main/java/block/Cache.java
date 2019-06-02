package block;

import disk.Database;
import io.BlockIO;
import disk.Logger;
import disk.Row;
import disk.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The cache of block
 **/

public class Cache {
    public HashMap<CacheKey, BlockIO> blockHashMap;                                        //the storage of block in memory
    private ArrayList<CacheKey> keys;
    public Database database;
    private int cacheSize;                                                           //the hole size of the cache


    public Cache(Database database) {
        this.database = database;
        blockHashMap = new HashMap<>();
        keys = new ArrayList<>();
        cacheSize = 0;
    }


    /**
     * Insert row into the block
     *
     * @param blockIndex : index in the blockList of the target block
     **/
    public Row insert(Table table, int blockIndex, byte[] data) throws IOException {
        //get the block to be inserted
        BlockIO block = loadBlock(getAccessor(table, blockIndex));

        //insert
        Row row = block.insert(data);

        saveBlockToFile(block);
        if (row.rowIndex == -1)
            return null;
        return row;
    }

    /**
     * Delete row
     *
     * @param blockIndex: index in the block list of the target block
     * @param rowIndex    : the index of the row in the block
     **/
    public Row delete(Table table, int blockIndex, int rowIndex) throws IOException {
        //get the block to be deleted
        BlockIO block = loadBlock(getAccessor(table, blockIndex));

//        //get the old data
//        byte[] data = block.readRowData(rowIndex);

        //delete
        Row oldRow = block.delete(rowIndex);
        saveBlockToFile(block);
        return oldRow;
    }


    /**
     * Update row
     *
     * @param blockIndex : index in the blocklist of the target block
     * @param rowIndex   : the index of the row in the block
     **/
    public Row update(Table table, int blockIndex, int rowIndex, byte[] data) throws IOException {
        //get the block
        BlockIO block = loadBlock(getAccessor(table, blockIndex));

        //update the block
        Row updatedRow = block.update(rowIndex, data);
        saveBlockToFile(block);
        return updatedRow;
    }

    /**
     * Get the row by the block and row index
     *
     * @param rowIndex   : row index in block
     * @param blockIndex :block index in the block list
     **/
    public byte[] get(Table table, int blockIndex, int rowIndex) throws IOException {
        BlockIO block = loadBlock(getAccessor(table, blockIndex));

        return block.readRowData(rowIndex);
    }

    /**
     * Get a block from the cache key,if the block is not in memory, then it will be loaded
     *
     * @param accessor : the cache key of the block
     **/
    private BlockIO loadBlock(CacheKey accessor) throws IOException {
        //the block is in memory
        if (blockHashMap.containsKey(accessor)) {
            visitBlock(accessor);
            return blockHashMap.get(accessor);
        }
        //the block is not in memory
        else {
            //load block from file
            BlockIO loaded = accessor.table.dataFileManager.getBlockFromFile(accessor.index);

            //put the block into the cache
            if (loaded != null)
                putIn(loaded, accessor);
            else
                throw new RuntimeException("try to load block which has over index");
            return loaded;
        }
    }

    private CacheKey getAccessor(Table table, int index) {
        return new CacheKey(table, index);
    }

    /**
     * Put a block into the cache
     *
     * @param accessor : the key of the block in cache
     **/
    private void putIn(BlockIO loaded, CacheKey accessor) throws IOException{
        //the cache has enough space
        if (cacheSize + loaded.blockSize <= Logger.cacheSizeLimit) {
            blockHashMap.put(accessor, loaded);
            keys.add(accessor);
        }
        //the cache overflowed
        else {
            pop();
            putIn(loaded,accessor);
        }
    }


    /**
     * Save block to file
     **/
    private void saveBlockToFile(BlockIO blockIO) throws IOException {
        blockIO.table.dataFileManager.writeBlockToDisk(blockIO.blockIndex, blockIO.content);
    }

    /**
     * Remove a block from the cache
     **/
    public void pop() throws IOException {
        CacheKey accessor = keys.get(0);
        BlockIO blockIO = blockHashMap.get(accessor);
        if (blockIO != null) {
            saveBlockToFile(blockIO);
            blockHashMap.remove(accessor);
            keys.remove(accessor);
        } else {
            throw new RuntimeException("try to pop null block from cache");
        }
    }

    /**
     * Remove a block from the cache
     **/
    public void popOut(CacheKey accessor) throws IOException {
        BlockIO blockIO = blockHashMap.get(accessor);
        if (blockIO != null) {
            saveBlockToFile(blockIO);
            blockHashMap.remove(accessor);
            keys.remove(accessor);
        } else {
            throw new RuntimeException("try to pop null block from cache");
        }
    }


    public void saveAll() throws IOException {
        for (BlockIO ele : blockHashMap.values()) {
            saveBlockToFile(ele);
        }
    }

    private void visitBlock(CacheKey accessor){
        int pos = keys.indexOf(accessor);
        accessor = keys.get(pos);
        accessor.visited();
        keys.remove(pos);
        keys.add(accessor);
    }

}

