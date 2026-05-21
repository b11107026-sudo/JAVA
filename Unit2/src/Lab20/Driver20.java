package Lab20;

import javax.swing.JFrame;

public class Driver20 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Unit2, Lab20");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new PrizePanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
