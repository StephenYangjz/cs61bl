import java.util.ArrayList;

/**
 * Created by 强 on 2016/7/16.
 */
public class QTreeNode {
    private final Point intiULPoint = new Point(-122.2558,37.89219);
    private final Point intiLRPoint = new Point(-122.21191,37.85749);

    private Point ULPoint;
    private Point LRPoint;
    private String filename;
    private ArrayList<QTreeNode> children;

    QTreeNode() {
        this.ULPoint = intiULPoint;
        this.LRPoint = intiLRPoint;
        this.filename = "1";
        this.children = new ArrayList<QTreeNode>();
    }

    QTreeNode(Point ULPoint, Point LRPoint, String filename) {
        this.ULPoint = ULPoint;
        this.LRPoint = LRPoint;
        this.filename = filename;
        this.children = new ArrayList<QTreeNode>();
    }

    QTreeNode(Point ULPoint, Point LRPoint, String filename, ArrayList<QTreeNode> children) {
        this.ULPoint = ULPoint;
        this.LRPoint = LRPoint;
        this.filename = filename;
        this.children = children;
    }

    public Point getULPoint() {
        return ULPoint;
    }

    public Point getLRPoint() {
        return ULPoint;
    }

    public String getFilename() {
        return filename;
    }

    public ArrayList<QTreeNode> getChildren() {
        return children;
    }
}
