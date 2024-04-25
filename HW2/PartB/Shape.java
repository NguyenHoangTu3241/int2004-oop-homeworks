import java.util.*;
public class Shape {
    public List<Point> points;
    private final Point center;
    private final double radius;
    public Shape(String input) {
        points = new ArrayList<>();
        List<Double> arr = String2Array(input);
        double cx = 0, cy = 0;
        for (int i = 0; i < arr.size(); i += 2) {
            Point p = new Point(arr.get(i), arr.get(i + 1));
            points.add(p);
            cx += arr.get(i);
            cy += arr.get(i + 1);
        }

        cx /= points.size();
        cy /= points.size();
        center = new Point(cx, cy);

        double r = 1000000000;
        for (Point p : points) {
            r = Math.min(r, center.distanceTo(p));
        }
        radius = r;
    }
    public Point getCenter() {
        return center;
    }
    public Double getRadius() {
        return radius;
    }
    public boolean cross(Shape that) {
        boolean inside = false;
        boolean outside = false;
        Point thatCenter = that.getCenter();
        double thatRadius = that.getRadius();
        for (Point p : points) {
            if (thatCenter.distanceTo(p) < thatRadius) inside = true;
            else outside = true;
        }
        return (inside && outside);
    }
    public int encircle(Shape that) {
        Point thatCenter = that.getCenter();
        double thatRadius = that.getRadius();
        if (center.distanceTo(thatCenter) < radius) return 2;
        else if(center.distanceTo(thatCenter) <= radius + thatRadius) return 1;
        return 0;
    }
    private List<Double> String2Array(String input) {
        List<Double> l = new ArrayList<>();
        Scanner sc = new Scanner(input);
        while (sc.hasNextDouble()) {
            l.add(sc.nextDouble());
        }
        if (l.size() % 2 == 1) l.add(0.0);
        return l;
    }
}