public class TreeWalker {
    public void walk(Element element, Visitor visitor) {
        walk(element, visitor, "" , 0);
    }
    public void walk(Element element , Visitor visitor , String path , int depth){
        String currentPath = path;
        if(!path.isEmpty()){
            currentPath += "/";
        }
        currentPath += element.getName();
        visitor.setPath(currentPath.substring(currentPath.indexOf("/") + 1));
        visitor.setDepth(depth);
        element.accept(visitor);

        for(int i = 0; i < element.getChildren().size(); i++) {
            Element child = element.getChildren().get(i);
            walk(child, visitor, currentPath , depth + 1);
        }
    }
}