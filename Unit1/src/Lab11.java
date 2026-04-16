import edu.fcps.karel2.Display;

public class Lab11 {
    public static void main(String[] args){
        Display.openDefaultWorld();
        Display.setSize(36,32);
        Display.setSpeed(10);
        
        Zero zero = new Zero(1,18);
        zero.display();
        new One(9, 18).display();
        new Two(17, 18).display();
        new Three(25, 18).display();
        new Four(33, 18).display();
        new Five(1, 9).display();
        new Six(9, 9).display();
        new Seven(17, 9).display();
        new Eight(25, 9).display();
        new Nine(33, 9).display();
    }
    
}