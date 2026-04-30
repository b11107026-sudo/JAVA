	//Name______________________________ Date_____________
   package Lab08;
   import edu.fcps.Turtle;
   import java.awt.Color;
   import javax.swing.*;
   public class Driver08
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("Flower Turtles");
         frame.setSize(700, 700);
         frame.setLocation(200, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new Lab07.TurtlePanel());
         frame.setVisible(true);
         Turtle.clear(Color.WHITE);
      
         FlowerTurtle flowerTurtle1 = new FlowerTurtle(100.0, 45.0, Color.RED);
         FlowerTurtle flowerTurtle2 = new FlowerTurtle(250.0, 45.0, Color.yellow);
         FlowerTurtle flowerTurtle3 = new FlowerTurtle(400.0, 45.0, Color.blue);
         FlowerTurtle flowerTurtle4 = new FlowerTurtle(550.0, 45.0, Color.black);
  
         flowerTurtle1.drawShape();
         flowerTurtle2.drawShape();
         flowerTurtle3.drawShape();
         flowerTurtle4.drawShape();
      }
   }