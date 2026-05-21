   //Name:    Date:
   package Lab17;
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
    public class PrizePanel_17 extends JPanel
   {
      private static final int FRAME = 400;
      private static final Color BACKGROUND = new Color(204, 204, 204);
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Lab11.Ball ball;
      private Lab10.Polkadot pd;
      private Timer t; 
      private int hits = 0 ;
      private Boolean connected = false;

		//constructor   
       public PrizePanel_17()
      {
         myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME, FRAME);

         // part of ball
         int xPos = (int)(Math.random() * (FRAME - 100)) + 50;
         int yPos = (int)(Math.random() * (FRAME - 100)) + 50;
         ball = new Lab11.Ball(50, 50, 30, Color.RED);

         // part of polkadot
         xPos = (int)(Math.random() * (FRAME - 100)) + 50;
         yPos = (int)(Math.random() * (FRAME - 100)) + 50;
         pd = new Lab10.Polkadot(xPos, yPos, 20, Color.BLUE);

         //part of mouse
         t = new Timer(50, new Listener());
         t.start();   

         addMouseListener(new Mouse());

         addKeyListener(new Key());
         setFocusable(true);
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
            myBuffer.setFont(new Font("Monospaced", Font.BOLD,24));
            myBuffer.drawString("Count: " + hits, FRAME-150, 25);
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
      private class Mouse extends MouseAdapter
      {
         public void mousePressed(MouseEvent e)
         {
            if(e.getButton() == MouseEvent.BUTTON1){
                ball.setX(e.getX());
                ball.setY(e.getY());
            }else if (e.isShiftDown()){
                ball.setdx(Math.random()*12-6);
                ball.setdy(Math.random()*12-6);
            }else{
                pd.setX(e.getX());
                pd.setY(e.getY());
            }
            
         }
      }


      private class Key extends KeyAdapter
      {
         public void keyPressed(KeyEvent e)
         {
            if(e.getKeyCode() == KeyEvent.VK_UP){
                ball.setY(ball.getY() - 20);
                if(ball.getY() < ball.getRadius()){
                   ball.setY(ball.getRadius());
                }
            }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                ball.setY(ball.getY() + 20);
                if(ball.getY() > FRAME - ball.getRadius()){
                   ball.setY(FRAME - ball.getRadius());
                }
            }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                ball.setX(ball.getX() - 20);
                if(ball.getX() < ball.getRadius()){
                   ball.setX(ball.getRadius());
                }
            }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                ball.setX(ball.getX() + 20);
                if(ball.getX() > FRAME - ball.getRadius()){
                   ball.setX(FRAME - ball.getRadius());
                }
            }
         


         if(e.getKeyCode() == KeyEvent.VK_W){
            pd.setY(pd.getY() - 10);
            if(pd.getY() < pd.getRadius()){
               pd.setY(pd.getRadius());
            }
         }  else if(e.getKeyCode() == KeyEvent.VK_S){
            pd.setY(pd.getY() + 10);
            if(pd.getY() > FRAME - pd.getRadius()){
               pd.setY(FRAME - pd.getRadius());
            }
         }  else if(e.getKeyCode() == KeyEvent.VK_D){
            pd.setX(pd.getX() + 10);
            if(pd.getX() > FRAME - pd.getRadius()){
               pd.setX(FRAME - pd.getRadius());
            }
         }
         else if(e.getKeyCode() == KeyEvent.VK_A){
            pd.setX(pd.getX() - 10);
            if(pd.getX() < pd.getRadius()){
               pd.setX(pd.getRadius());
            }
         }
         }
      }



   }