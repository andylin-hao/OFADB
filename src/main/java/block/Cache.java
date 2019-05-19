package block;

import disk.Database;
import io.BlockIO;
import disk.Logger;
import disk.Row;
import disk.Table;

import java.io.IOException;
import java.util.HashMap;

/**
 * The cache of block
 **/

public class Cache {
    public HashMap<CacheKey, BlockIO> blockHashMap;                                        //the storage of block in memory
    public Database database;
    public int cacheSize;                                                           //the hole size of the cache


    public Cache(Database database) {
        this.database = database;
        blockHashMap = new HashMap<>();
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
     * @param blockIndex: index in the blocklist of the target block
     * @param rowIndex    : the index of the row in the block
     **/
    public Row delete(Table table, int blockIndex, int rowIndex) throws IOException {
        //get the block to be deleted
        BlockIO block = loadBlock(getAccessor(table, blockIndex));

        //get the old data
        byte[] data = block.readRowData(rowIndex);

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
    public BlockIO loadBlock(CacheKey accessor) throws IOException {
        //the block is in memory
        if (blockHashMap.containsKey(accessor)) {
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
                throw new Error("try to load block which has over index");
            return loaded;
        }
    }

    public CacheKey getAccessor(Table table, int index) {
        return new CacheKey(table, index);
    }

    /**
     * Put a block into the cache
     *
     * @param accessor : the key of the block in cache
     **/
    public void putIn(BlockIO loaded, CacheKey accessor) {
        //the cache has enough space
        if (cacheSize + loaded.blockSize <= Logger.cacheSizeLimit) {
            blockHashMap.put(accessor, loaded);
        }
        //the cache overflowed
        else {
            blockHashMap.put(accessor, loaded);
        }
    }


    /**
     * Save block to file
     **/
    public void saveBlockToFile(BlockIO blockIO) throws IOException {
        blockIO.table.dataFileManager.writeBlockToDisk(blockIO.blockIndex, blockIO.content);
    }

    /**
     * Remove a block from the cache
     **/
    public void popOut(CacheKey accessor) throws IOException {
        BlockIO blockIO = blockHashMap.get(accessor);
        if (blockIO != null) {
            saveBlockToFile(blockIO);
            blockHashMap.remove(accessor);
        } else {
            throw new Error("try to pop null block from cache");
        }
    }


    public void saveAll() throws IOException {
        for (BlockIO ele : blockHashMap.values()) {
            saveBlockToFile(ele);
        }
    }

}
