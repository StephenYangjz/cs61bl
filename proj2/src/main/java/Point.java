import java.util.Objects;

/**
 * Created by 强 on 2016/7/16.
 */
public class Point {
    private double x;
    private double y;

    Point(){
        x = 0.0;
        y = 0.0;
    }

    Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public Point getLocation() {
        return new Point(x, y);
    }

    public void setLocation(Point p) {
        setLocation(p.x, p.y);
    }

    public void setLocation(double x, double y) {
        move(x,y);
    }

    public void move(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void translate (double x, double y) {
        this.x += x;
        this.y += y;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point pt = (Point) obj;
            return (this.x == pt.x) && (this.y == pt.y);
        }
        return super.equals(obj);
    }
}
