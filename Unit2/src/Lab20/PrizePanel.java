package Lab20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class PrizePanel extends JPanel {

    private static final int FRAME = 800;
    private static final Color BACKGROUND = Color.WHITE;
    private static final int NUM_PRIZES = 300;

    private BufferedImage myImage;
    private Graphics myBuffer;
    private Prize[] array;
    private Pinball pb;
    private Timer t;

    public PrizePanel() {
        myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
        myBuffer = myImage.getGraphics();
        myBuffer.setColor(BACKGROUND);
        myBuffer.fillRect(0, 0, FRAME, FRAME);

        array = new Prize[NUM_PRIZES];
        for (int k = 0; k < array.length; k++) {
            int x = (int) (Math.random() * (FRAME - 50)) + 25;
            int y = (int) (Math.random() * (FRAME - 50)) + 25;
            array[k] = new Prize(x, y, 10);
        }

        pb = new Pinball(FRAME / 2, FRAME / 2, 10, Color.BLACK);
        pb.setbound(FRAME, FRAME);

        t = new Timer(20, new Listener());
        t.start();

        setPreferredSize(new Dimension(FRAME, FRAME));
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

            for (int k = 0; k < array.length; k++) {
                if (pb.intersect(array[k])) {
                    array[k].lightup();
                }
                array[k].drawme(myBuffer);
            }

            pb.tick();
            pb.drawme(myBuffer);
            repaint();
        }
    }
}
