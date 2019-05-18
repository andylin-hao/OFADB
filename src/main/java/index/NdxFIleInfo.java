package index;

public class NdxFIleInfo {
    /**
     * @Classname : NdxFIleInfo
     * @Description : the indication of a index file space in memory
     **/
    public long offset;
    public int size;
    public NdxFIleInfo(long off,int s){
        offset = off;
        size = s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof NdxFIleInfo){
            return ((NdxFIleInfo) obj).offset == offset && ((NdxFIleInfo) obj).size == size;
        }
        return false;
    }
}
