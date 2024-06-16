package exercise;

// BEGIN
public class Circle {
    private int radius;
    private Point point;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Радиус меньше нуля");
        }

        return Math.PI * radius * radius;
    }
}
// END
