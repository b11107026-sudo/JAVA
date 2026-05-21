package Lab20;

import java.awt.*;

public class Prize extends Spot {

    public Prize(int x, int y, int r) {
        super(x, y, r, Color.RED);
    }

    public void lightup() {
        setColor(Color.YELLOW);
    }
}
