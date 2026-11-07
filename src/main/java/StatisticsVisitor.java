public class StatisticsVisitor implements Visitor{
    private int fileCount = 0;
    private int directoryCount = 0;
    private int maxDepth = 0;
    private int depth = 0;

    public void visit(FileNode file){
        fileCount++;
        maxDepth = Math.max(maxDepth , depth);
    }
    public void visit(DirectoryNode directory){
        directoryCount++;
        maxDepth = Math.max(maxDepth , depth);
    }
    public void setDepth(int depth){
        this.depth = depth;
    }
    public int getFileCount(){
        return fileCount;
    }
    public int getDirectoryCount(){
        return directoryCount;
    }
    public int getMaxDepth(){
        return maxDepth;
    }
    public void setPath(String path){}
}
