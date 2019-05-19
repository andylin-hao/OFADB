package index;

import disk.Row;
import io.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The leaf of an index tree,including the row infos which belongs to the same key
 **/

public class NodeLeaf {
    public List<Row> rowInfos;
    public NdxFIleInfo storageInfo;
    public NodeLeaf(Row row){
        this.rowInfos = new ArrayList<>();
        this.rowInfos.add(row);
        this.storageInfo = null;
    }
    public NodeLeaf(){
        this.rowInfos = new ArrayList<>();
        this.storageInfo = null;
    }

    public void setStorageInfo(NdxFIleInfo storageInfo) {
        this.storageInfo = storageInfo;
    }

    public NdxFIleInfo getStorageInfo() {
        return storageInfo;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof NodeLeaf)
        {
            if(((NodeLeaf) other).storageInfo != this.storageInfo || (((NodeLeaf) other).rowInfos.size() != ((NodeLeaf) other).rowInfos.size()))
                return false;
            for(int i = 0;i<rowInfos.size();i++){
                if(!rowInfos.get(i).equals(((NodeLeaf) other).rowInfos.get(i)))
                    return false;
            }
            return true;
        }
        return false;
    }

    public int length(){
        return IndexFileIO.keyNumLength + IndexFileIO.offsetLength * rowInfos.size();
    }

}
