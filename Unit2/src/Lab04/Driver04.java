package Lab04;

import javax.swing.JFrame;

import edu.fcps.Bucket;

public class Driver04 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bucket");
        
        frame.setSize(600, 400);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new BucketPanel());
        frame.setVisible(true);
            //implement the algorithm here
        Bucket.setSpeed(5);
        Bucket.useTotal(false);
        Bucket five = new Bucket(5);
        Bucket three = new Bucket(3); 
            three.fill(); // 3(3)
            three.pourInto(five); // 3(0)->5(3)
            three.fill(); // 3(3)
            three.pourInto(five); // 3(1)->5(5)
            five.spill(); // 3(1) 5(0)
            five.fill(); // 3(1) 5(5)
            three.pourInto(five); // 3(0) 5(6)
            three.fill(); // 3(3) 5(6)
            three.pourInto(five); // 3(2) 5(7)
            three.spill(); // 3(0) 5(7)
            five.pourInto(three); // 3(3) 5(4)
            three.spill(); // 3(0) 5(4)
            five.pourInto(three); // 3(3) 5(1)
            three.spill(); // 3(0) 5(1)
            five.pourInto(three); // 3(1) 5(0)
            five.fill(); // 3(1) 5(5)
            three.fill(); // 3(3) 5(5)
            
    }
}
