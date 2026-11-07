public interface Visitor {
    void visit(FileNode file);
    void visit(DirectoryNode directory);
    void setPath(String path);
    void setDepth(int depth);
}
