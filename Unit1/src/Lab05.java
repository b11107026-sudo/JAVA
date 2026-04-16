import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Lab05 {

	/**
	 * @param args
	 */

	public static void runTheRace(Racer arg){
		arg.move();
		arg.jumpRight();
		arg.shuttle(2, 7);
		arg.turnAround();
		arg.sprint(2);
		arg.jumpLeft();
		arg.sprint(1);
		arg.put(7);
		arg.turnAround();
		arg.move();
		arg.jumpRight();
		arg.shuttle(4, 5);
		arg.turnAround();
		arg.sprint(4);
		arg.jumpLeft();
		arg.sprint(1);
		arg.put(5);
		arg.turnAround();
		arg.move();
		arg.jumpRight();
		arg.shuttle(6, 3);
		arg.turnAround();
		arg.sprint(6);
		arg.jumpLeft();
		arg.sprint(1);
		arg.put(3);
		arg.turnAround();
		arg.move();
	}
    public static void main(String[] args) {
        Display.openWorld("maps/shuttle.map");
		Display.setSize(10, 10);
		Display.setSpeed(10);
		Racer racer1 = new Racer(1);
		Racer racer2 = new Racer(4);
		Racer racer3 = new Racer(7);
		runTheRace(racer1);
		runTheRace(racer2);
		runTheRace(racer3);
    }

}