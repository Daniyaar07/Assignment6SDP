import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
public class VisitorTest {
    @Test
    public void testVisitorMethods() {
        FileNode file = new FileNode("a.txt", 100);
        StatisticsVisitor stats = new StatisticsVisitor();

        file.accept(stats);

        assertEquals(1, stats.getFileCount());
    }
    @Test
    public void testSize() {
        DirectoryNode root = new DirectoryNode("root");
        root.add(new FileNode("a.txt", 100));
        root.add(new FileNode("b.txt", 200));

        TotalSizeVisitor size = new TotalSizeVisitor();
        new TreeWalker().walk(root, size);
        assertEquals(300, size.getTotalSize());
    }
    @Test
    public void testSearch() {
        DirectoryNode root = new DirectoryNode("root");
        root.add(new FileNode("report.txt", 500));
        SearchVisitor search = new SearchVisitor("report", 200);
        new TreeWalker().walk(root, search);
        assertEquals(List.of("report.txt"), search.getResults());
    }
    @Test
    public void testPath() {
        DirectoryNode root = new DirectoryNode("root");
        DirectoryNode folder = new DirectoryNode("docs");
        folder.add(new FileNode("a.txt", 100));
        root.add(folder);

        SearchVisitor search = new SearchVisitor("a.txt", 100);
        new TreeWalker().walk(root, search);
        assertEquals(List.of("docs/a.txt"), search.getResults());
    }
    @Test
    public void testStatistics() {
        DirectoryNode root = new DirectoryNode("root");
        root.add(new FileNode("a.txt", 100));

        StatisticsVisitor stats = new StatisticsVisitor();
        new TreeWalker().walk(root, stats);

        assertEquals(1, stats.getFileCount());
        assertEquals(1, stats.getDirectoryCount());
        assertEquals(1, stats.getMaxDepth());
    }
    @Test
    public void testEmpty() {
        DirectoryNode root = new DirectoryNode("root");
        TotalSizeVisitor size = new TotalSizeVisitor();
        new TreeWalker().walk(root, size);
        assertEquals(0, size.getTotalSize());
    }
    @Test
    public void testRepeat() {
        DirectoryNode root = new DirectoryNode("root");
        root.add(new FileNode("a.txt", 100));

        TotalSizeVisitor size = new TotalSizeVisitor();
        new TreeWalker().walk(root, size);
        assertEquals(100, size.getTotalSize());
    }
    @Test
    public void testDuplicate() {
        DirectoryNode root = new DirectoryNode("root");
        root.add(new FileNode("a.txt", 100));
        assertThrows(IllegalArgumentException.class, () -> {
            root.add(new FileNode("a.txt", 200));
        });
    }
}
