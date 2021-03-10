import java.util.*;

public class NagelPoint {
    private Point x, y, z;

    public NagelPoint(Point a, Point b, Point c) {
        x = a;
        y = b;
        z = c;
    }

    private double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    public double getPerimeter() {
        return distance(x, y) + distance(y, z) + distance(x, z);
    }

    public Point getBisectedPerimeterPoint(Point v, Point w, Point t) {
        var dist = getPerimeter() / 2;
        var firstDist = distance(v, w);
        if (firstDist > dist) {
            var deltaVector = new Point(w.getX() - v.getX(), w.getY() - v.getY());
            var norm = dist / firstDist;
            return new Point(v.getX() + deltaVector.getX() * norm, v.getY() + deltaVector.getY() * norm);
        }
        dist -= firstDist;
        var deltaVector = new Point(t.getX() - w.getX(), t.getY() - w.getY());
        var norm = dist / distance(w, t);
        return new Point(w.getX() + deltaVector.getX() * norm, w.getY() + deltaVector.getY() * norm);
    }

    /*
     * return Point of interesection between the line containning the points x1 and x2 and
     *                                       the line containning the points y1 and y1
     */
    public Point getIntersection(Point x1, Point x2, Point y1, Point y2) {
        var mx = (x2.getY() - x1.getY())/(x2.getX() - x1.getX());
        var my = (y2.getY() - y1.getY())/(y2.getX() - y1.getX());
        var ans = Determinants.cramer(new double[][] {
                { mx, -1.0, mx * x1.getX() - x1.getY() },
                { my, -1.0, my * y1.getX() - y1.getY() }
        });
        if (ans == null)
            return null;
        return new Point(ans[0][0], ans[1][0]);
    }

    public Point getNagelPoint() {
        var bisX = getBisectedPerimeterPoint(x, y, z);
        var bisY = getBisectedPerimeterPoint(y, z, x);
        return getIntersection(x, bisX, y, bisY);
    }
}