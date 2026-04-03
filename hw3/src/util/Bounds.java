package util;

public class Bounds {
    private Point p;
    private int width;
    private int height;

    public Bounds(Point p, int width, int height) {
        this.p = p;
        this.width = width;
        this.height = height;
    }

    public Point getPoint() {
        return p;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public void setPoint(Point p) {
        this.p = p;
    }
    public void setPoint(int X, int Y) {
        this.p.setX(X);
        this.p.setY(Y);
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}

