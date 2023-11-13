package TestNewGameImplementation.core;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double lenght() {
        return Math.sqrt(x * x + y * y);
    }

    public void normalize() {
        double lenght = lenght();
        x = x == 0 ? 0 : x / lenght;
        y = y == 0 ? 0 : y / lenght;
    }

    public void multiply(double value) {
        x *= value;
        y *= value;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
