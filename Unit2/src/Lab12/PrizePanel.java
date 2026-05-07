   //Name:    Date:
   package Lab12;
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
    public class PrizePanel extends JPanel
   {
      private static final int FRAME = 400;
      private static final Color BACKGROUND = new Color(204, 204, 204);
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Lab11.Ball ball;
      private Lab10.Polkadot pd;
      private Timer t; 
      private int hits = 0 ;

		//constructor   
       public PrizePanel()
      {
         myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME, FRAME);
         ball = new Lab11.Ball(200, 200, 30, Color.RED);
         pd = new Lab10.Polkadot(100, 100, 40, Color.BLUE);
         t = new Timer(5, new Listener());
         t.start();   
      }
       public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
       private class Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            myBuffer.setColor(BACKGROUND);
            myBuffer.fillRect(0, 0, FRAME, FRAME);

            ball.move(FRAME, FRAME);
            collide(ball, pd);

            ball.draw(myBuffer);
            pd.draw(myBuffer);

            myBuffer.setColor(Color.BLACK);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD,25));
            myBuffer.drawString("Count: " + hits, FRAME-150, 30);
            repaint();
         }
      }   
       private void collide(Lab11.Ball b, Lab10.Polkadot pd)
      {
        double d = distance(pd.getX(), pd.getY(), b.getX(), b.getY());
         if (d <= b.getRadius() + pd.getRadius())
         {
            hits++;
            pd.jump(FRAME, FRAME);
         }
		
		  
      }
       private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); // enter the calculation here.
      }
   }