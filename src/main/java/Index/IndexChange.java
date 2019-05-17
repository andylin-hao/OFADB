package Index;

import IO.IndexFileIO;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexChange {
    /**
     * @Classname : IndexChange
     * @Description : record of the difference between index in memory and index data
     **/
    public Map<Long, NodeIndex> updateList;                      // the nodes which need to be updated in file
    public List<NodeIndex> insertList;                          // the
    public List<NodeIndex> deleteList;
    public IndexBase index;                                     // the
    public IndexFileIO fileIO;

    public IndexChange(IndexBase index){
        this.index = index;
        this.fileIO = index.fileIO;
        updateList = new HashMap<Long, NodeIndex>();
//        insertList = new ArrayList<NodeIndex>();
//        deleteList = new ArrayList<NodeIndex>();
    }

    /**
     * @Description : get a offset in file for the node
    **/
    public void addNewInsert(NodeIndex node){
        if(node == null)return;

        node.setOffset(index.fileIO.getPreOffset(index.fileIO.getNodeLength(node)));
        index.loadedNodes.put(node.offset.offset,node);
        updateList.put(node.offset.offset,node);
    }

    /**
     * @Description : update the node
    **/
    public void addNewUpdate(NodeIndex node){
        if(node == null)return;
        //new data is bigger than old one
        if(node.offset.size < index.fileIO.getNodeLength(node))
        {
            // remove old node and
            updateList.remove(node.offset.offset);
            index.loadedNodes.remove(node.offset.offset);
            index.fileIO.emptyListInsert(node.offset);

            // get a new offset
            node.setOffset(index.fileIO.getPreOffset(index.fileIO.getNodeLength(node)));
            index.loadedNodes.put(node.offset.offset,node);
            updateList.put(node.offset.offset,node);

            if(node.isLeaf)
            {
                addNewUpdate(node.previous);
                addNewUpdate(node.next);
            }
        }
        else {
            updateList.put(node.offset.offset, node);
        }
    }

    /**
     * @Description : remove tha node from the update list and put the space into empty list
    **/
    public void addNewDelete(NodeIndex node){
        if(node == null)return;

        updateList.remove(node.offset.offset);
        index.loadedNodes.remove(node.offset.offset);
        index.fileIO.emptyListInsert(node.offset);
    }

    /**
     * @Description : put all the change into file,write the empty list first,then rewrite all the node in update list
    **/
    public void saveChange()throws IOException {
        index.fileIO.saveUnique();
        index.fileIO.saveEmptyList();
        index.fileIO.saveRootOffset();
        for(Map.Entry<Long, NodeIndex> entry:updateList.entrySet()){
            index.fileIO.updateNode(entry.getValue());
        }
        updateList.clear();
    }
}
