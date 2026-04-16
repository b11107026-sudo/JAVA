import edu.fcps.karel2.Display;

public class Q22 {
    public static void main(String[] args){
        Display.openDefaultWorld();
        Display.setSize(36,32);
        Display.setSpeed(10);
        
        new E(2, 29).display();
        new E(10, 29).display();
        new C(18, 29).display();
        new S(26, 29).display();
        new Da(10, 14).display();
        new Two(18, 14).display();
        new Six(26, 14).display();
    }
    
}