import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Lab02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Display.openWorld("maps/maze.map");
		Display.setSize(10, 10);
		Display.setSpeed(10);

		Athlete pete = new Athlete(1,1,Display.NORTH,15);
        pete.putBeeper();
        pete.move(); 
        pete.putBeeper();
        pete.turnRight();
		pete.move();
		pete.putBeeper();
		pete.turnRight();
		pete.move();
		pete.putBeeper();
		pete.turnLeft();
		pete.move();
		pete.putBeeper();
		pete.turnLeft();
		pete.move();
		pete.putBeeper();
		pete.turnRight();
		pete.move();
		pete.putBeeper();
		pete.move();
		pete.putBeeper();
		pete.turnRight();
		pete.move();
		pete.putBeeper();
		pete.turnLeft();
		pete.move();
		pete.putBeeper();
		pete.turnLeft();
		pete.move();
		pete.putBeeper();
		pete.move();
		pete.putBeeper();
		pete.move();
		pete.putBeeper();
		pete.move();
		pete.putBeeper();
		pete.turnRight();
		pete.move();
		pete.putBeeper();
		pete.move();
		pete.putBeeper();
		pete.move();
      //test	
	}

}
