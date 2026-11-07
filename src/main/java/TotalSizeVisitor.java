public class TotalSizeVisitor implements Visitor{
    private long totalSize = 0;

    public void visit(FileNode file){
        totalSize+= file.getSize();
    }
    public void visit(DirectoryNode directory){
    }
    public long getTotalSize(){
        return totalSize;
    }
    public void setPath(String path){}
    public void setDepth(int depth){}
}
