package Lab09;
import edu.fcps.Turtle;
import java.awt.Color;
import javax.swing.*;

public class Driver09 {
	public static void main(String[] args) {

        JFrame frame = new JFrame("Twisty Turtles");
        frame.setSize(400, 400);
        frame.setLocation(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Lab07.TurtlePanel());
        frame.setVisible(true);
        Turtle.clear(Color.WHITE);

		// TwistyTurtle: begin 5, end 400, increment 10, angle 123
		TwistyTurtle t1 = new TwistyTurtle(5, 400, 10, 123);
		//t1.setPosition(100, 100);
        t1.setColor(Color.BLUE);
		t1.drawShape();

		// TwistyTurtle2: begin 0, end 150, increment 2, angle 30
		TwistyTurtle2 t2 = new TwistyTurtle2(0, 150, 2, -30);
		//t2.setPosition(300, 100);
        t2.setColor(Color.RED);
		t2.drawShape();

		// TwistyTurtle3: begin 25, end 150, increment 5
		TwistyTurtle3 t3 = new TwistyTurtle3(25, 150, 5);
		//t3.setPosition(200, 300);
        t3.setColor(Color.black);
		t3.drawShape();
	}
}
