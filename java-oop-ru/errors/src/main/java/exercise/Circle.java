package exercise;

import static java.lang.Math.PI;
import static java.lang.Math.round;

// BEGIN
public class Circle {
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

    public int getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Radius < 0");
        }

        return (int) round(PI * radius * radius);
    }
}
// END
