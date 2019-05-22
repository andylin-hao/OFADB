package index;

import disk.Row;

import java.util.*;

/**
 * Node of index tree
 **/

public class NodeIndex implements NodeBPlus {
    public boolean isRoot;
    public boolean isLeaf;

    public NodeIndex parent;
    public NodeIndex next;
    public NodeIndex previous;

    public void setOffset(NdxFIleInfo offset) {
        this.offset = offset;
    }

    public NdxFIleInfo offset;

    public ArrayList<Map.Entry<Comparable, Object>> keys;
    public ArrayList<NodeIndex> children;

    public NodeIndex(boolean isRoot, boolean isLeaf) {
        this.isLeaf = isLeaf;
        this.isRoot = isRoot;
        this.keys = new ArrayList<Map.Entry<Comparable, Object>>();
        this.offset = null;

        if (!this.isLeaf)
            this.children = new ArrayList<NodeIndex>();
    }

    /**
     * Get the offset of previous node
     **/
    public long getPreviousOffset() {
        if (getPrevious() != null)
            return getPrevious().offset.offset;
        else
            return 0;
    }

    /**
     * Get the offset of next node
     **/
    public long getNextsOffset() {
        if (getNext() != null)
            return getNext().offset.offset;
        else
            return 0;
    }

    public ArrayList<NodeIndex> getChildren() {
        return this.children;
    }


    public void setNodeLeaf() {
        this.isLeaf = true;
        this.children = null;
    }

    public void setNodeMiddle() {
        this.isLeaf = false;
        if (this.getChildren() == null)
            this.children = new ArrayList<NodeIndex>();
    }

    @Override
    public Comparable lastKey() {
        return keys.get(keys.size() - 1).getKey();
    }

    @Override
    public NodeIndex getParent() {
        return parent;
    }

    @Override
    public void setParent(NodeBPlus parent) {
        this.parent = (NodeIndex) parent;
    }

    /**
     * Get the next node having the same parent node
     **/
    @Override
    public NodeIndex getNext() {
        if (isLeaf || isRoot)
            return next;
        int indexPos = parent.getChildren().indexOf(this);
        if (indexPos + 1 >= parent.getChildren().size())
            return null;
        else
            return parent.getChildren().get(indexPos + 1);
    }


    @Override
    public void setNext(NodeBPlus next) {
        this.next = (NodeIndex) next;
    }

    /**
     * Get the previous node having the same parent
     **/
    @Override
    public NodeIndex getPrevious() {
        if (isLeaf || isRoot)
            return previous;
        int indexPos = parent.getChildren().indexOf(this);
        if (indexPos - 1 < 0)
            return null;
        else
            return parent.getChildren().get(indexPos - 1);
    }

    @Override
    public void setPrevious(NodeBPlus previous) {
        this.previous = (NodeIndex) previous;
    }


    /**
     * Get the node leaf of input key
     **/
    @Override
    public Object get(Comparable key) {
        if (this.isLeaf) {
            for (Map.Entry<Comparable, Object> ele : this.keys) {
                if (ele.getKey().compareTo(key) == 0)
                    return ele.getValue();
            }
            return null;
        } else {
            if (key.compareTo(this.keys.get(0).getKey()) <= 0)
                return this.getChildren().get(0).get(key);
            else if (key.compareTo(this.keys.get(this.keys.size() - 1).getKey()) > 0)
                return null;
            else {
                for (int i = 1; i < this.keys.size(); i++) {
                    if (key.compareTo(this.keys.get(i).getKey()) <= 0) {
                        return this.getChildren().get(i).get(key);
                    }
                }
            }
        }
        return null;
    }

    /**
     * Add a new key  into a leaf node
     **/
    @Override
    public void set(Comparable key, Object data) {
        Map.Entry<Comparable, Object> entry = new AbstractMap.SimpleEntry<>(key, data);
        for (int i = 0; i < this.keys.size(); i++) {
            if (key.compareTo(this.keys.get(i).getKey()) <= 0) {
                if (key.compareTo(this.keys.get(i).getKey()) == 0)
                    this.keys.set(i, entry);
                else
                    this.keys.add(i, entry);
                return;
            }
        }
        this.keys.add(entry);
    }


    /**
     * Insert row into index
     *
     * @param data : row info
     * @param key  : the key to be inserted
     **/
    @Override
    public void insert(Comparable key, Object data, BPlusTree tree) {
        if (contains(key) >= 0 && ((IndexBase) tree).info.isUnique)
            return;
        //leaf node
        if (this.isLeaf) {
            // size <= m after inserted
            if (this.keys.size() < tree.getOrder() || (contains(key) >= 0 && this.keys.size() <= tree.getOrder())) {
                //if the key doesn't exists
                if (contains(key) < 0) {
                    NodeLeaf leaf = new NodeLeaf();
                    leaf.rowInfos.add((Row) data);
                    set(key, leaf);
                    ((IndexBase) tree).indexChange.addNewUpdate(this);
                } else {
                    NodeLeaf leaf = (NodeLeaf) get(key);
                    leaf.rowInfos.add((Row) data);
                    ((IndexBase) tree).indexChange.addNewUpdate(this);
                }
                if (parent != null)
                    recursiveUpdate(tree);

            }
            //need split
            else {
                NodeLeaf leaf = new NodeLeaf();
                leaf.rowInfos.add((Row) data);
                set(key, leaf);
                NodeIndex left = new NodeIndex(false, true);
                NodeIndex right = new NodeIndex(false, true);
                for (int i = 0; i < keys.size(); i++) {
                    if (i < (tree.getOrder() + 1) / 2)
                        left.keys.add(keys.get(i));
                    else
                        right.keys.add(keys.get(i));
                }

                if (previous != null) {
                    previous.setNext(left);
                    ((IndexBase) tree).indexChange.addNewUpdate(previous);
                } else
                    tree.setHeadLeaf(left);
                if (next != null) {
                    next.setPrevious(right);
                    ((IndexBase) tree).indexChange.addNewUpdate(next);
                }

                left.setPrevious(previous);
                left.setNext(right);
                right.setPrevious(left);
                right.setNext(next);

                //current node is root
                if (isRoot) {
                    NodeIndex newRoot = new NodeIndex(true, false);
                    tree.setRoot(newRoot);
                    left.setParent(newRoot);
                    right.setParent(newRoot);
                    newRoot.getChildren().add(left);
                    newRoot.getChildren().add(right);
                    newRoot.keys.add(new AbstractMap.SimpleEntry<Comparable, Object>(left.lastKey(), null));
                    newRoot.keys.add(new AbstractMap.SimpleEntry<Comparable, Object>(right.lastKey(), null));

                    newRoot.offset = offset;
                    ((IndexBase) tree).indexChange.addNewUpdate(newRoot);
                    ((IndexBase) tree).indexChange.addNewInsert(left);
                    ((IndexBase) tree).indexChange.addNewInsert(right);

                }
                //current node is not root
                else {
                    int insertPos = this.parent.getChildren().indexOf(this);
                    this.parent.getChildren().remove(insertPos);
                    this.parent.keys.remove(insertPos);
                    left.setParent(this.parent);
                    right.setParent(this.parent);
                    this.parent.getChildren().add(insertPos, left);
                    this.parent.getChildren().add(insertPos + 1, right);
                    this.parent.keys.add(insertPos, new AbstractMap.SimpleEntry<Comparable, Object>(left.lastKey(), null));
                    this.parent.keys.add(insertPos + 1, new AbstractMap.SimpleEntry<Comparable, Object>(right.lastKey(), null));
                    parent.recursiveUpdate(tree);

                    left.offset = offset;
                    ((IndexBase) tree).indexChange.addNewUpdate(left);
                    ((IndexBase) tree).indexChange.addNewInsert(right);
                }


                cutLink();
            }
        }
        //middle leaf
        else {
            if (key.compareTo(keys.get(0).getKey()) <= 0)
                children.get(0).insert(key, data, tree);
            else if (key.compareTo(keys.get(keys.size() - 1).getKey()) > 0)
                children.get(children.size() - 1).insert(key, data, tree);
            else {
                for (int i = 0; i < children.size(); i++) {
                    if (key.compareTo(keys.get(i).getKey()) <= 0) {
                        children.get(i).insert(key, data, tree);
                        break;
                    }
                }
            }
        }
    }

    /**
     * From the current node recursively upwards the tree
     **/
    @Override
    public void recursiveUpdate(BPlusTree tree) {
        //size of key is in scope
        if (!isRoot && keys.size() <= tree.getOrder() && keys.size() >= tree.getOrder() / 2 && keys.size() >= 2) {
            ((IndexBase) tree).indexChange.addNewUpdate(this);

            int indexPos = parent.getChildren().indexOf(this);
            if (!this.lastKey().equals(parent.keys.get(indexPos))) {
                parent.keys.set(indexPos, new AbstractMap.SimpleEntry<Comparable, Object>(this.lastKey(), null));
                ((IndexBase) tree).indexChange.addNewUpdate(parent);
                parent.recursiveUpdate(tree);
            }
        }
        //size of key > m
        else if (keys.size() > tree.getOrder()) {
            NodeIndex left = new NodeIndex(false, false);
            NodeIndex right = new NodeIndex(false, false);
            for (int i = 0; i < keys.size(); i++) {
                if (i < (tree.getOrder() + 1) / 2) {
                    left.getChildren().add(children.get(i));
                    left.keys.add(new AbstractMap.SimpleEntry<Comparable, Object>(children.get(i).lastKey(), null));
                    children.get(i).setParent(left);
                } else {
                    right.getChildren().add(children.get(i));
                    right.keys.add(new AbstractMap.SimpleEntry<Comparable, Object>(children.get(i).lastKey(), null));
                    children.get(i).setParent(right);
                }
            }
            //current node is root
            if (isRoot) {
                NodeIndex newRoot = new NodeIndex(true, false);
                newRoot.getChildren().add(left);
                newRoot.getChildren().add(right);
                newRoot.keys.add(new AbstractMap.SimpleEntry<>(left.lastKey(), null));
                newRoot.keys.add(new AbstractMap.SimpleEntry<>(right.lastKey(), null));
                tree.setRoot(newRoot);
                left.setParent(newRoot);
                right.setParent(newRoot);

                newRoot.offset = offset;
                ((IndexBase) tree).indexChange.addNewUpdate(newRoot);
                ((IndexBase) tree).indexChange.addNewInsert(left);
                ((IndexBase) tree).indexChange.addNewInsert(right);

                cutLink();
            }
            //current node is not root
            else {
                int indexPos = parent.getChildren().indexOf(this);
                parent.getChildren().remove(indexPos);
                parent.keys.remove(indexPos);
                parent.getChildren().add(indexPos, left);
                parent.getChildren().add(indexPos + 1, right);
                parent.keys.add(indexPos, new AbstractMap.SimpleEntry<Comparable, Object>(left.lastKey(), null));
                parent.keys.add(indexPos + 1, new AbstractMap.SimpleEntry<Comparable, Object>(right.lastKey(), null));
                left.setParent(parent);
                right.setParent(parent);
                parent.recursiveUpdate(tree);

                left.offset = offset;
                ((IndexBase) tree).indexChange.addNewUpdate(left);
                ((IndexBase) tree).indexChange.addNewInsert(right);

                cutLink();
            }

        }
        //size of key < m/2
        else if ((!isRoot) && (keys.size() < tree.getOrder() / 2 || keys.size() < 2)) {
            previous = getPrevious();
            next = getNext();
            //previous node has extra node
            if (previous != null
                    && previous.keys.size() > tree.getOrder() / 2
                    && previous.keys.size() > 2
                    && previous.parent == parent) {
                Map.Entry<Comparable, Object> entry = new AbstractMap.SimpleEntry<Comparable, Object>(previous.lastKey(), null);
                NodeIndex lastChild = previous.getChildren().get(previous.getChildren().size() - 1);
                int prevPos = parent.keys.indexOf(entry);
                int indexPos = prevPos + 1;

                previous.keys.remove(previous.keys.size() - 1);
                previous.getChildren().remove(previous.getChildren().size() - 1);
                keys.add(0, entry);
                children.add(0, lastChild);
                lastChild.setParent(this);

                parent.keys.set(prevPos, new AbstractMap.SimpleEntry<Comparable, Object>(previous.lastKey(), null));
                parent.keys.set(indexPos, new AbstractMap.SimpleEntry<Comparable, Object>(lastKey(), null));

                ((IndexBase) tree).indexChange.addNewUpdate(previous);
                ((IndexBase) tree).indexChange.addNewUpdate(this);

                parent.recursiveUpdate(tree);
            }
            //next node has extra node
            else if (next != null
                    && next.keys.size() > tree.getOrder() / 2
                    && next.keys.size() > 2
                    && next.parent == parent) {
                Map.Entry<Comparable, Object> entry = new AbstractMap.SimpleEntry<Comparable, Object>(next.keys.get(0).getKey(), null);
                NodeIndex firstChild = next.getChildren().get(0);
                int nextPos = parent.keys.indexOf(new AbstractMap.SimpleEntry<Comparable, Object>(next.lastKey(), null));
                int indexPos = nextPos - 1;
                next.keys.remove(0);
                next.getChildren().remove(0);
                keys.add(entry);
                children.add(firstChild);
                firstChild.setParent(this);

                parent.keys.set(nextPos, new AbstractMap.SimpleEntry<Comparable, Object>(next.lastKey(), null));
                parent.keys.set(indexPos, new AbstractMap.SimpleEntry<Comparable, Object>(lastKey(), null));

                ((IndexBase) tree).indexChange.addNewUpdate(next);
                ((IndexBase) tree).indexChange.addNewUpdate(this);

                parent.recursiveUpdate(tree);
            }
            //need to merge
            else {
                //merge with previous node
                if (previous != null) {
                    if (previous.keys.size() == tree.getOrder() / 2
                            || previous.keys.size() <= 2
                            && previous.parent == parent) {
                        int prevPos = parent.keys.indexOf(new AbstractMap.SimpleEntry<Comparable, Object>(previous.lastKey(), null));
                        int indexPos = prevPos + 1;

                        for (int i = 0; i < keys.size(); i++) {
                            previous.keys.add(keys.get(i));
                            children.get(i).setParent(previous);
                            previous.getChildren().add(children.get(i));
                        }
                        parent.keys.remove(indexPos);
                        parent.getChildren().remove(indexPos);
                        parent.keys.set(prevPos, new AbstractMap.SimpleEntry<Comparable, Object>(previous.lastKey(), null));


                        ((IndexBase) tree).indexChange.addNewUpdate(previous);
                        ((IndexBase) tree).indexChange.addNewDelete(this);

                        parent.recursiveUpdate(tree);
                        cutLink();
                    }
                }
                //merge with next node
                else if (next != null) {
                    if (next.keys.size() == tree.getOrder() / 2
                            || next.keys.size() <= 2
                            && next.parent == parent) {
                        int nextPos = parent.keys.indexOf(new AbstractMap.SimpleEntry<Comparable, Object>(next.lastKey(), null));
                        int indexPos = nextPos - 1;

                        for (int i = keys.size() - 1; i >= 0; i--) {
                            next.keys.add(0, keys.get(i));
                            children.get(i).setParent(next);
                            next.getChildren().add(0, children.get(i));
                        }
                        parent.keys.remove(indexPos);
                        parent.getChildren().remove(indexPos);

                        ((IndexBase) tree).indexChange.addNewUpdate(next);
                        ((IndexBase) tree).indexChange.addNewDelete(this);

                        parent.recursiveUpdate(tree);
                        cutLink();
                    }
                }
            }

        }
        //root node has less than two children
        else if (isRoot) {

            if (keys.size() == 1) {
                NodeIndex newRoot = children.get(0);
                tree.root = newRoot;
                NdxFIleInfo newRootOffset = newRoot.offset;
                newRoot.offset = this.offset;
                this.offset = newRootOffset;
                newRoot.parent = null;
                newRoot.isRoot = true;

                ((IndexBase) tree).indexChange.addNewDelete(this);
                ((IndexBase) tree).indexChange.addNewUpdate(newRoot);
            } else {
                ((IndexBase) tree).indexChange.addNewUpdate(this);
            }
        }
    }

    /**
     * Find one key is stored in the tree or not.if exits ,return the its index in leaf node,or return -1;
     **/
    @Override
    public int contains(Comparable key) {
        for (int i = 0; i < keys.size(); i++)
            if (key.equals(keys.get(i).getKey()))
                return i;

        if (!isLeaf) {
            if (key.compareTo(this.keys.get(0).getKey()) <= 0)
                return this.getChildren().get(0).contains(key);
            else if (key.compareTo(this.keys.get(this.keys.size() - 1).getKey()) > 0)
                return -1;
            else {
                for (int i = 1; i < this.keys.size(); i++) {
                    if (key.compareTo(this.keys.get(i).getKey()) <= 0) {
                        return this.getChildren().get(i).contains(key);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Cut connect with other things
     **/
    @Override
    public void cutLink() {
        setParent(null);
        setPrevious(null);
        setNext(null);
        children = null;
        keys = null;
    }

    /**
     * Delete one key from a leaf node
     **/
    @SuppressWarnings("SuspiciousListRemoveInLoop")
    @Override
    public void delete(Comparable key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).getKey().equals(key)) {
                keys.remove(i);
            }
        }
    }

    /**
     * Remove one row info from the node leaf having key
     **/
    @Override
    public void remove(Comparable key, Object data, BPlusTree tree) {
        //leaf node
        if (isLeaf) {
            if (contains(key) < 0)
                return;
            else {
                NodeLeaf leaf = (NodeLeaf) get(key);
                if (!leaf.rowInfos.contains(data))
                    return;
                if (leaf.rowInfos.size() > 1) {
                    leaf.rowInfos.remove(data);
                    ((IndexBase) tree).indexChange.addNewUpdate(this);
                    return;
                }

                //current node is root
                if (isRoot) {
                    delete(key);
                    ((IndexBase) tree).indexChange.addNewUpdate(this);
                } else {
                    //size of key >= m/2
                    if (keys.size() > tree.getOrder() / 2 && keys.size() > 2) {
                        delete(key);

                        ((IndexBase) tree).indexChange.addNewUpdate(this);

                        recursiveUpdate(tree);
                    }
                    //size of key < m/2
                    else {
                        //previous node has extra node
                        if (previous != null
                                && previous.keys.size() > tree.getOrder() / 2
                                && previous.keys.size() > 2
                                && previous.parent == parent) {
                            Map.Entry<Comparable, Object> entry = new AbstractMap.SimpleEntry<Comparable, Object>(previous.lastKey(), null);
                            int prevPos = parent.keys.indexOf(entry);
                            int indexPos = parent.keys.indexOf(new AbstractMap.SimpleEntry<>(lastKey(), null));


                            keys.add(0, previous.keys.remove(previous.keys.size() - 1));
                            delete(key);

                            parent.keys.set(prevPos, new AbstractMap.SimpleEntry<Comparable, Object>(previous.lastKey(), null));
                            parent.keys.set(indexPos, new AbstractMap.SimpleEntry<Comparable, Object>(lastKey(), null));


                            ((IndexBase) tree).indexChange.addNewUpdate(previous);
                            ((IndexBase) tree).indexChange.addNewUpdate(this);

                            parent.recursiveUpdate(tree);

                        }
                        //next node ha extra node
                        else if (next != null
                                && next.keys.size() > tree.getOrder() / 2
                                && next.keys.size() > 2
                                && next.parent == parent) {
                            Map.Entry<Comparable, Object> entry = new AbstractMap.SimpleEntry<Comparable, Object>(next.keys.get(0).getKey(), null);
                            int nextPos = parent.keys.indexOf(new AbstractMap.SimpleEntry<Comparable, Object>(next.lastKey(), null));
                            int indexPos = parent.keys.indexOf(new AbstractMap.SimpleEntry<>(lastKey(), null));


                            keys.add(next.keys.remove(0));
                            delete(key);

                            parent.keys.set(nextPos, new AbstractMap.SimpleEntry<Comparable, Object>(next.lastKey(), null));
                            parent.keys.set(indexPos, new AbstractMap.SimpleEntry<Comparable, Object>(lastKey(), null));


                            ((IndexBase) tree).indexChange.addNewUpdate(next);
                            ((IndexBase) tree).indexChange.addNewUpdate(this);

                            parent.recursiveUpdate(tree);
                        }
                        //need to merge
                        else {
                            //merge with previous node
                            if ((previous != null) &&
                                    (previous.keys.size() == tree.getOrder() / 2
                                            || previous.keys.size() <= 2) && previous.parent == parent) {
                                int prevPos = parent.keys.indexOf(new AbstractMap.SimpleEntry<Comparable, Object>(previous.lastKey(), null));
                                int indexPos = parent.keys.indexOf(new AbstractMap.SimpleEntry<Comparable, Object>(lastKey(), null));
                                delete(key);

                                for (int i = 0; i < keys.size(); i++) {
                                    previous.keys.add(keys.get(i));
                                }
                                parent.keys.remove(indexPos);
                                parent.getChildren().remove(indexPos);
                                parent.keys.set(prevPos, new AbstractMap.SimpleEntry<Comparable, Object>(previous.lastKey(), null));
                                previous.setNext(next);
                                if (next != null)
                                    next.setPrevious(previous);

                                ((IndexBase) tree).indexChange.addNewUpdate(previous);
                                ((IndexBase) tree).indexChange.addNewUpdate(previous.getNext());


                            }
                            //merge with next node
                            else {
                                if (next != null) {
                                    if ((next.keys.size() == tree.getOrder() / 2
                                            || next.keys.size() <= 2)
                                            && next.parent == parent) {
                                        int nextPos = parent.keys.indexOf(new AbstractMap.SimpleEntry<Comparable, Object>(next.lastKey(), null));
                                        int indexPos = parent.keys.indexOf(new AbstractMap.SimpleEntry<Comparable, Object>(lastKey(), null));
                                        delete(key);
                                        for (int i = keys.size() - 1; i >= 0; i--) {
                                            next.keys.add(0, keys.get(i));
                                        }
                                        parent.keys.remove(indexPos);
                                        parent.getChildren().remove(indexPos);
                                        if (previous != null) previous.setNext(next);
                                        else
                                            tree.headLeaf = next;
                                        next.setPrevious(previous);

                                        ((IndexBase) tree).indexChange.addNewUpdate(next);
                                        ((IndexBase) tree).indexChange.addNewUpdate(next.previous);

                                    }
                                }
                            }

                            ((IndexBase) tree).indexChange.addNewDelete(this);
                            parent.recursiveUpdate(tree);
                            cutLink();

                        }
                    }
                }
            }
        }
        //middle leaf
        else {
            if (key.compareTo(keys.get(0).getKey()) <= 0)
                children.get(0).remove(key, data, tree);
            else if (key.compareTo(keys.get(keys.size() - 1).getKey()) > 0)
                children.get(children.size() - 1).remove(key, data, tree);
            else {
                for (int i = 0; i < children.size(); i++) {
                    if (key.compareTo(keys.get(i).getKey()) <= 0) {
                        children.get(i).remove(key, data, tree);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("isRoot: ");
        sb.append(isRoot);
        sb.append(", ");
        sb.append("isLeaf: ");
        sb.append(isLeaf);
        sb.append(", ");
        sb.append("keys:[ ");
        for (Map.Entry<Comparable, Object> entry : keys) {
            sb.append(entry.getKey());
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("]");
        return sb.toString();

    }

    public static boolean equal(NodeIndex a, NodeIndex b) {
        List<NodeIndex> alist = new LinkedList<>();
        List<NodeIndex> blist = new LinkedList<>();
        alist.add(a);
        blist.add(b);
        while (alist.size() > 0) {
            NodeIndex a1 = alist.remove(0);
            NodeIndex b1 = blist.remove(0);
            if (a1.keys.size() != b1.keys.size())
                return false;
            for (int i = 0; i < a1.keys.size(); i++) {
                if (!a1.keys.get(i).getKey().equals(b1.keys.get(i).getKey()))
                    return false;
                if (a1.isLeaf != b1.isLeaf)
                    return false;
                if (a1.isLeaf) {
                    for (int j = 0; j < a1.keys.size(); j++)
                        if (a1.keys.get(j).getValue() == null)
                            return false;
                    if (!((NodeLeaf) a1.keys.get(i).getValue()).equals((NodeLeaf) b1.keys.get(i).getValue()))
                        return false;
                    continue;
                }
                alist.add(a1.children.get(i));
                blist.add(b1.children.get(i));
            }
        }
        return true;
    }
}
