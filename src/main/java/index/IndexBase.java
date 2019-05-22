package index;

import Meta.IndexInfo;
import io.IndexFileIO;
import disk.Table;
import disk.Type;

import java.io.File;
import java.util.HashMap;

/**
 * The base class of index
 **/

public class IndexBase extends BPlusTree {

    public IndexFileIO fileIO;
    public IndexChange indexChange;
    public HashMap<Long, NodeIndex> loadedNodes;
    public IndexInfo info;
    public Table table;

    public IndexBase(Table table, int order, int[] index, File file, Type[] types1,boolean isUnique) {
        super(order, null);
        this.table = table;
        info = new IndexInfo(index,isUnique);
        info.setTable(table);
        this.loadedNodes = new HashMap<Long, NodeIndex>();

        this.fileIO = new IndexFileIO(file, order, this);
        this.indexChange = new IndexChange(this);

    }


    public IndexKey getIndexAccessor(Object[] data) {
        Object[] keyData = new Object[info.types.length];
        for (int i = 0; i < info.columnIndex.length; i++) {
            keyData[i] = data[info.columnIndex[i]];
        }
        return new IndexKey(info.types, keyData);
    }
}
