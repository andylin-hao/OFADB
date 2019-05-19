package block;

import disk.Table;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * The key of the block map in cache
 **/

public class CacheKey {
    public Table table;
    public int index;                                                      // the index of the block in the block list
    public int visited;

    public CacheKey(Table table, int index) {
        this.table = table;
        this.index = index;
        this.visited = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CacheKey)
            return table.database.dataBaseName.equals(((CacheKey) obj).table.database.dataBaseName) && table.tableName.equals(((CacheKey) obj).table.tableName) && index == ((CacheKey) obj).index;
        return false;
    }

    @Override
    public int hashCode() {
        return table.tableName.hashCode() + index;
    }

    public void visited() {
        visited++;
    }


}
