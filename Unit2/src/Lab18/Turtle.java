// Torbert, 7.20.06
   package Lab18;
   import java.awt.*;
   import java.awt.image.*;

    public class Turtle
   {
      private static BufferedImage img;
      private static int black = 0;
      private static int blue = 255;       // 2^8-1
      private static int green = 65280;    //(2^8-1)*2^8
      private static int red = 16711680;   //(2^8-1)*2^16
      private static int white = 16777215; // 2^24-1
      private double x,y,theta;            // what does a Turtle know?
      static									 	 // a static initializer list
      {
         img = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
      }
       public Turtle()
      {
        // img = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
         x=img.getWidth()/2;           //start at center
         y=img.getHeight()/2;          //start at center
         theta=90;                     //start facing north
      }
       public static Image getImage()
      {
         return img;
      }
       public void turnLeft(double a)
      {
         theta+=a;
      }
      public void turnRight(double a)
      {
         theta-=a;
      }
      public void setPosition(double x, double y)
      {
         this.x = x;
         this.y = y;
      }
      public void forward(double r)
      {
         double rad = Math.toRadians(theta);
         double newX = x + r * Math.cos(rad);
         double newY = y - r * Math.sin(rad);
         Graphics2D g2 = (Graphics2D) img.getGraphics();
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         g2.setColor(new Color(200,200,200));
         g2.setStroke(new BasicStroke(2f));
         g2.drawLine((int)x, (int)y, (int)newX, (int)newY);
         x = newX;
         y = newY;
      }
   }