package block;

import disk.Table;

public class CacheKey {
    /**
     * @Classname : CacheKey
     * @Description : the key of the block map in cache
     **/
    Table table;
    int index;                                                      //the index of the block in the block list
    int visited;
    public CacheKey(Table table, int index){
        this.table = table;
        this.index = index;
        this.visited = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CacheKey)
            return table.database.dataBaseName == ((CacheKey)obj).table.database.dataBaseName && table.tableName == ((CacheKey) obj).table.tableName && index == ((CacheKey) obj).index;
        return false;
    }

    @Override
    public int hashCode() {
        return table.tableName.hashCode() + index;
    }

    public void visited()
    {
        visited++;
    }




}
