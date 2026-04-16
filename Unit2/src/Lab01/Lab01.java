package Lab01;
import javax.swing.JFrame;

public class Lab01 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab01");
        frame.setSize(400, 400);
        frame.setLocation(100, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Panel01());
        frame.setVisible(true);
    }
}
