package index;

public interface NodeBPlus {

    Comparable lastKey();

    NodeBPlus getParent();

    void setParent(NodeBPlus parent);

    NodeBPlus getNext();

    void setNext(NodeBPlus next);

    NodeBPlus getPrevious();

    void setPrevious(NodeBPlus previous);


    Object get(Comparable key);

    void set(Comparable key, Object data);

    void insert(Comparable key, Object data, BPlusTree tree);

    void recursiveUpdate(BPlusTree tree);

    int contains(Comparable key);

    void cutLink();

    void delete(Comparable key);

    void remove(Comparable key, Object data, BPlusTree tree);

    String toString();
}
