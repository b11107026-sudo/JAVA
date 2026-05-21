package Lab20;

import java.awt.*;

public class Spot {
    protected int x;
    protected int y;
    protected int r;
    protected Color c;

    public Spot(int x, int y, int r, Color c) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
    }

    public boolean intersect(Spot s) {
        double dx = x - s.x;
        double dy = y - s.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance <= r + s.r;
    }

    public void drawme(Graphics g) {
        g.setColor(c);
        g.fillOval(x - r, y - r, 2 * r, 2 * r);
    }

    public void setColor(Color c) {
        this.c = c;
    }

    public int getRadius() {
        return r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
