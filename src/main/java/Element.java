import java.util.List;
public interface Element {
    String getName();
    void accept(Visitor visitor);
    List<Element> getChildren();
    DirectoryNode getParent();
    void setParent(DirectoryNode parent);
}
