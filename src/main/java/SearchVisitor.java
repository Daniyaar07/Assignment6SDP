import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements Visitor{
    private String name;
    private long minSize;
    private String path = "";
    private List<String> results = new ArrayList<>();

    public SearchVisitor(String name , long minSize){
        this.name = name;
        this.minSize = minSize;
    }
    public void visit(FileNode file){
        if(file.getName().contains(name) && file.getSize() >= minSize){
            results.add(path);
        }
    }
    public void visit(DirectoryNode directory){
    }
    public void setDepth(int depth){}
    public List<String> getResults(){
        return results;
    }
    public void setPath(String path){
        this.path = path;
    }
}
