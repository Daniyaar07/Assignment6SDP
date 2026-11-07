public class Main {
    public static void main(String[] args){
        DirectoryNode root = new DirectoryNode("root");
        DirectoryNode documents = new DirectoryNode("documents");

        FileNode file1 = new FileNode("report.txt" , 500);
        FileNode file2 = new FileNode("notes.txt" , 200);
        FileNode file3 = new FileNode("photo.jpg" , 1000);

        documents.add(file1);
        documents.add(file2);

        root.add(documents);
        root.add(file3);

        TreeWalker walker = new TreeWalker();
        TotalSizeVisitor size = new TotalSizeVisitor();

        walker.walk(root , size);
        System.out.println("Total size: " + size.getTotalSize());

        SearchVisitor search = new SearchVisitor("report" , 100);
        walker.walk(root , search);
        System.out.println("Found files: " + search.getResults());

        StatisticsVisitor stats = new StatisticsVisitor();
        walker.walk(root , stats);
        System.out.println("Files: " + stats.getFileCount());
        System.out.println("Directories: " + stats.getDirectoryCount());
        System.out.println("Max depth: " + stats.getMaxDepth());
    }
}
