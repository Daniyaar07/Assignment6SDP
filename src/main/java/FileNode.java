import java.util.List;
public class FileNode implements Element{
    private String name;
    private long size;

    public FileNode(String name , long size){
        if(size < 0){
            throw new IllegalArgumentException("Size cant be negative");
        }
        this.name = name;
        this.size = size;
    }
    public String getName(){
        return name;
    }
    public long getSize(){
        return size;
    }
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
    public List<Element> getChildren(){
        return List.of();
    }
}
