import java.util.ArrayList;
import java.util.List;

public class DirectoryNode implements Element{
    private String name;
    private List<Element> children = new ArrayList<>();
    private DirectoryNode parent;

    public DirectoryNode(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setParent(DirectoryNode parent){
        this.parent = parent;
    }
    public void add(Element element){
        if(element == null){
            throw new IllegalArgumentException("Null element");
        }
        if(element.getParent() != null){
            throw new IllegalArgumentException("Already has parent");
        }
        for(Element child : children){
            if(child.getName().equals(element.getName())){
                throw new IllegalArgumentException("Duplicate name");            }
        }
        DirectoryNode current = this;
        while(current != null){
            if(current == element){
                throw new IllegalArgumentException("Cycle detected");
            }
            current = current.getParent();
        }
        element.setParent(this);
        children.add(element);
    }
    public List<Element> getChildren(){
        return List.copyOf(children);
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public DirectoryNode getParent(){
        return parent;
    }
}
