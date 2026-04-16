import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseFollowerGame extends JPanel implements MouseMotionListener {

    private int ballX = -20; // 初始位置畫在畫面外
    private int ballY = -20;
    private static final int RADIUS = 20;

    public MouseFollowerGame() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 畫紅色圓球
        g.setColor(Color.RED);
        g.fillOval(ballX - RADIUS, ballY - RADIUS, RADIUS * 2, RADIUS * 2);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        ballX = e.getX();
        ballY = e.getY();
        repaint(); // 重新繪製
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // 也可支援拖曳時跟隨
        mouseMoved(e);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mouse Follower Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setContentPane(new MouseFollowerGame());
            frame.pack();
            frame.setLocationRelativeTo(null); // 視窗置中
            frame.setVisible(true);
        });
    }
}