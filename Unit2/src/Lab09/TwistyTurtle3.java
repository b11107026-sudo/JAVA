// TwistyTurtle3.java
package Lab09;
import edu.fcps.Turtle;
import java.awt.Color;
public class TwistyTurtle3 extends Turtle {
    private int beginLength, endLength, increment;

    public TwistyTurtle3(int beginLength, int endLength, int increment) {
        this.beginLength = beginLength;
        this.endLength = endLength;
        this.increment = increment;
    }

    public void drawShape() {
        for (int len = beginLength; len <= endLength; len += increment) {
            square(len);
            turnRight(45);
        }
    }

    private void square(int side) {
        for (int i = 0; i < 4; i++) {
            forward(side);
            turnRight(90);
        }
    }
}
