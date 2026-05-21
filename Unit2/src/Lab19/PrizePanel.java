package Lab19;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class PrizePanel extends JPanel {

    private static final int FRAME = 400;
    private static final Color BACKGROUND = new Color(204, 204, 204);
    private BufferedImage myImage;
    private Graphics myBuffer;
    private Lab11.Ball ball;
    private Lab10.Polkadot[] myPArray;
    private Timer t;
    private int hits = 0;

    public PrizePanel() {
        myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
        myBuffer = myImage.getGraphics();
        myBuffer.setColor(BACKGROUND);
        myBuffer.fillRect(0, 0, FRAME, FRAME);

        ball = new Lab11.Ball(50, 50, 30, Color.BLACK);
        ball.setdx(Math.random() * 12 - 6);
        ball.setdy(Math.random() * 12 - 6);

        myPArray = new Lab10.Polkadot[50];
        for (int k = 0; k < myPArray.length; k++) {
            int xPos = (int) (Math.random() * (FRAME - 100)) + 50;
            int yPos = (int) (Math.random() * (FRAME - 100)) + 50;
            myPArray[k] = new Lab10.Polkadot(xPos, yPos, 25, Color.RED);
        }

        addMouseListener(new Mouse());
        setPreferredSize(new Dimension(FRAME, FRAME));
        setFocusable(true);

        t = new Timer(20, new Listener());
        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
    }

    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            myBuffer.setColor(BACKGROUND);
            myBuffer.fillRect(0, 0, FRAME, FRAME);

            ball.move(FRAME, FRAME);
            for (Lab10.Polkadot pd : myPArray) {
                collide(ball, pd);
                pd.draw(myBuffer);
            }
            ball.draw(myBuffer);

            myBuffer.setColor(Color.BLACK);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 24));
            myBuffer.drawString("Count: " + hits, FRAME - 150, 25);
            repaint();
        }
    }

    private void collide(Lab11.Ball b, Lab10.Polkadot pd) {
        double d = distance(pd.getX(), pd.getY(), b.getX(), b.getY());
        if (d <= b.getRadius() + pd.getRadius()) {
            hits++;
            pd.jump(FRAME, FRAME);
        }
    }

    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    private class Mouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                ball.setX(e.getX());
                ball.setY(e.getY());
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                ball.setdx(Math.random() * 12 - 6);
                ball.setdy(Math.random() * 12 - 6);
            }
        }
    }
}
