package index;

import disk.Row;
import meta.IndexInfo;
import io.IndexFileIO;
import disk.Table;
import disk.Type;
import types.IndexQueryType;

import java.io.File;
import java.util.*;

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
        this.loadedNodes = new HashMap<>();

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

    public HashSet<Row> strictRangeQuery(Comparable key, IndexQueryType queryDir){
        NodeIndex splitNode = ((NodeIndex)root).insertPlace(key);
        HashSet<Row> rowHashSet = new HashSet<>();
        if(splitNode != null) {
            if (queryDir.equals(IndexQueryType.QUERY_LT)) {
                for (int i = 0; i < splitNode.keys.size(); i++)
                    if (key.compareTo(splitNode.keys.get(i).getKey()) > 0)
                        rowHashSet.addAll(((NodeLeaf) (splitNode.keys.get(i).getValue())).rowInfos);
                while (splitNode.previous != null) {
                    splitNode = splitNode.previous;
                    for (int i = 0; i < splitNode.keys.size(); i++)
                        rowHashSet.addAll(((NodeLeaf) (splitNode.keys.get(i).getValue())).rowInfos);
                }
            } else if (queryDir.equals(IndexQueryType.QUERY_GT)) {
                for (int i = 0; i < splitNode.keys.size(); i++)
                    if (key.compareTo(splitNode.keys.get(i).getKey()) < 0)
                        rowHashSet.addAll(((NodeLeaf) (splitNode.keys.get(i).getValue())).rowInfos);
                while (splitNode.next != null) {
                    splitNode = splitNode.next;
                    for (int i = 0; i < splitNode.keys.size(); i++)
                        rowHashSet.addAll(((NodeLeaf) (splitNode.keys.get(i).getValue())).rowInfos);
                }
            }
        }
        return rowHashSet;
    }

    private HashSet<Row> laxRangeQuery(Comparable key,IndexQueryType queryDir)
    {
        HashSet<Row> result = strictRangeQuery(key,queryDir);
        result.addAll(equivalenceFind(key));
        return result;
    }

    public HashSet<Row> rangeQuery(Comparable key,IndexQueryType queryType)
    {
        switch (queryType){
            case QUERY_LT:
            case QUERY_GT:
                return strictRangeQuery(key,queryType);
            case QUERY_LET:
            case QUERY_GET:
                return laxRangeQuery(key,queryType);
            case QUERY_EQ:
                return equivalenceFind(key);
            case QUERY_NEQ:
                return negEquivalenceFind(key);
            default:
                throw new RuntimeException("no such index query type");
        }
    }

    public HashSet<Row> equivalenceFind(Comparable key){
        NodeLeaf leaf = (NodeLeaf) get(key);
        HashSet<Row> rowSet = new HashSet<>();
        if(leaf != null)
            rowSet.addAll(leaf.rowInfos);
        return rowSet;
    }

    public HashSet<Row> negEquivalenceFind(Comparable key){
        NodeIndex node = (NodeIndex) headLeaf;
        HashSet<Row> rowSet = new HashSet<>();
        while (node != null) {
            for(Map.Entry<Comparable,Object>leafEntry:node.keys)
                if(leafEntry.getKey().compareTo(key) != 0)
                    rowSet.addAll(((NodeLeaf)leafEntry.getValue()).rowInfos);
            node = node.next;
        }
        return rowSet;
    }
}
