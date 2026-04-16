import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class tempVibeCoding extends JFrame {
	public tempVibeCoding() {
		setTitle("Red Ball Follows Mouse");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		add(new GamePanel());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new tempVibeCoding().setVisible(true);
		});
	}
}

class GamePanel extends JPanel implements MouseMotionListener, MouseListener {
	private double ballX = 400;
	private double ballY = 300;
	private int targetX = 400;
	private int targetY = 300;
	private final int RADIUS = 20;
	private int currentRadius = RADIUS;
	private Color ballColor = Color.RED;
	private final int STAR_COUNT = 50;
	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	private Star[] stars;
	private Timer timer;
	private boolean boosting = false;

	public GamePanel() {
		setBackground(Color.BLACK);
		addMouseMotionListener(this);
		addMouseListener(this);
		// 初始化星星
		stars = new Star[STAR_COUNT];
		Random rand = new Random();
		for (int i = 0; i < STAR_COUNT; i++) {
			stars[i] = new Star(rand.nextInt(WIDTH), rand.nextInt(HEIGHT), 1 + rand.nextDouble() * 1.5);
		}
		// 啟動動畫計時器
		timer = new Timer(16, e -> updateGame());
		timer.start();
	}

	private void updateGame() {
		// 慣性移動紅球
		double speed = 0.12; // 越小越慢
		ballX += (targetX - ballX) * speed;
		ballY += (targetY - ballY) * speed;

		// 星星下移
		for (Star s : stars) {
			s.y += s.speed;
			if (s.y > HEIGHT) {
				s.y = 0;
				s.x = (int)(Math.random() * WIDTH);
			}
		}
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// 畫星星
		g.setColor(Color.WHITE);
		for (Star s : stars) {
			g.fillOval((int)s.x, (int)s.y, 2, 2);
		}
		// 畫紅球
		g.setColor(ballColor);
		g.fillOval((int)(ballX - currentRadius), (int)(ballY - currentRadius), currentRadius * 2, currentRadius * 2);
	}
	// 滑鼠點擊觸發引擎加速
	@Override
	public void mousePressed(MouseEvent e) {
		if (!boosting) {
			boosting = true;
			currentRadius = RADIUS * 2;
			ballColor = Color.YELLOW;
			repaint();
			System.out.println("Engine Boost!");
			// 0.2秒後恢復
			new Timer(200, evt -> {
				currentRadius = RADIUS;
				ballColor = Color.RED;
				boosting = false;
				repaint();
				((Timer)evt.getSource()).stop();
			}).start();
		}
	}

	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		targetX = e.getX();
		targetY = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	// 星星內部類別
	static class Star {
		int x;
		double y;
		double speed;
		Star(int x, double y, double speed) {
			this.x = x;
			this.y = y;
			this.speed = speed;
		}
	}
}
