// TwistyTurtle.java
package Lab09;
import edu.fcps.Turtle;
import java.awt.Color;

public class TwistyTurtle extends Turtle {
    private int beginLength, endLength, increment, angle;

    public TwistyTurtle(int beginLength, int endLength, int increment, int angle) {
        this.beginLength = beginLength;
        this.endLength = endLength;
        this.increment = increment;
        this.angle = angle;
    }

    public void drawShape() {
        for (int len = beginLength; len <= endLength; len += increment) {
            forward(len);
            turnRight(angle);
        }
    }
}
