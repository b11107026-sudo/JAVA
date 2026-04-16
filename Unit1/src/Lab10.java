import edu.fcps.karel2.Display;

public class Lab10 {
    public static void main(String[] args){
        Display.openWorld("maps/maze3.map");
        Display.setSize(10, 10);
        Display.setSpeed(10);
        Athlete pete =new Athlete(1,1,Display.NORTH,Display.INFINITY);

        while (!pete.nextToABeeper()) {
            if (pete.rightIsClear()) {
                pete.turnRight();
            }
            if(pete.frontIsClear()) {
                pete.move();
            }
            if(!pete.frontIsClear() && !pete.rightIsClear()) {
                pete.turnLeft();
            }
        }
        

    }
}
