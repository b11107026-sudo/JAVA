import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Lab03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Display.openWorld("maps/mountain.map");
		Display.setSize(16, 16);
		Display.setSpeed(5);

        Climber tenzing = new Climber(8);
        Climber tenzing2 = new Climber(8);
        tenzing.climbUpRight();
        tenzing2.climbUpRight();
        tenzing.climbUpRight();
        tenzing2.climbUpRight();
        tenzing.climbUpRight();
        tenzing2.climbUpRight();
        tenzing.turnRight();
        tenzing2.turnRight();
        tenzing.move();
        tenzing2.move();
        tenzing.climbDownRight();
        tenzing2.climbDownRight();
        tenzing.climbDownRight();
        tenzing2.climbDownRight();
        tenzing.pickBeeper();
        tenzing.turnLeft();
        tenzing2.turnLeft();
        tenzing.climbUpLeft();
        tenzing2.climbUpLeft();
        tenzing.climbUpLeft();
        tenzing2.climbUpLeft();
        tenzing.turnLeft();
        tenzing2.turnLeft();
        tenzing.climbDownLeft();
        tenzing2.climbDownLeft();
        tenzing.climbDownLeft();
        tenzing2.climbDownLeft();
        tenzing.climbDownLeft();
        tenzing2.climbDownLeft();
        tenzing.move();
        tenzing2.move();
      //test	
	}

}
