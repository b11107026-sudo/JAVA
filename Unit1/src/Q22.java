import edu.fcps.karel2.Display;

public class Q22 {
    public static void main(String[] args){
        Display.openDefaultWorld();
        Display.setSize(32,32);
        Display.setSpeed(10);
        
        // �إߦU�Ӧr��/�Ʀr�������
        Thread t1 = new Thread(() -> new S(2, 29).display());
        Thread t2 = new Thread(() -> new C(10, 29).display());
        Thread t3 = new Thread(() -> new E(18, 29).display());
        Thread t4 = new Thread(() -> new E(26, 29).display());
        Thread t5 = new Thread(() -> new Six(2, 14).display());
        Thread t6 = new Thread(() -> new Two(10, 14).display());
        Thread t7 = new Thread(() -> new Da(18, 14).display());
        
        // �ҰʩҦ������
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        
      
    }
    
}