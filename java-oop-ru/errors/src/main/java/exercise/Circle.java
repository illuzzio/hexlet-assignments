package exercise;

// BEGIN
public class Circle {
    public final double PI = 3.1415;

    private Point point;
    private int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public Point getPoint() {
        return point;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Radius < 0");
        }

        return Math.PI * Math.pow(radius, 2);
    }
}
// END
