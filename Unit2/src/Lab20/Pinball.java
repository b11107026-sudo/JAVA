package Lab20;

import java.awt.*;

public class Pinball extends Spot {

    private int dx;
    private int dy;
    private int rightEdge;
    private int leftEdge;

    public Pinball(int x, int y, int r, Color c) {
        super(x, y, r, c);
        dx = (Math.random() < 0.5 ? -1 : 1) * littlerandom();
        dy = (Math.random() < 0.5 ? -1 : 1) * littlerandom();
    }

    public void setbound(int rightEdge, int leftEdge) {
        this.rightEdge = rightEdge;
        this.leftEdge = leftEdge;
    }

    public void tick() {
        x += dx;
        y += dy;

        if (x >= rightEdge - r) {
            x = rightEdge - r;
            dx = -littlerandom();
        } else if (x <= r) {
            x = r;
            dx = littlerandom();
        }

        if (y >= leftEdge - r) {
            y = leftEdge - r;
            dy = -littlerandom();
        } else if (y <= r) {
            y = r;
            dy = littlerandom();
        }
    }

    private int littlerandom() {
        return (int) (Math.random() * 8) + 2;
    }
}
