package Lab19;

import javax.swing.JFrame;

public class Driver19 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Unit2, Lab19");
        PrizePanel panel = new PrizePanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
