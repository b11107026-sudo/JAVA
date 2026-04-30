import edu.fcps.karel2.Display;

public class Q22 {
    public static void main(String[] args){
        Display.openDefaultWorld();
        Display.setSize(32,32);
        Display.setSpeed(10);
        
        // �إߦU�Ӧr��/�Ʀr�������
        Thread t1 = new Thread(() -> new Emirror(30, 29).displaymirror());
        Thread t2 = new Thread(() -> new Emirror(23, 29).displaymirror());
        Thread t3 = new Thread(() -> new Cmirror(16, 29).displaymirror());
        Thread t4 = new Thread(() -> new Smirror(8, 29).displaymirror());
        Thread t5 = new Thread(() -> new Damirror(26, 14).displaymirror());
        Thread t6 = new Thread(() -> new Twomirror(18, 14).displaymirror());
        Thread t7 = new Thread(() -> new Sixmirror(8, 14).displaymirror());
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        
      
    }
    
}