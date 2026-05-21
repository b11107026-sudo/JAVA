	// Torbert, 7.20.06
   package Lab18;
   import javax.swing.JFrame;
   import java.awt.*;
   import javax.swing.*;

    public class Driver18 extends JPanel
   {
        public Driver18(){
            super();
        }
       public static void main(String[] args)
      {     
        Turtle t = new Turtle();
        t.turnLeft(5);
        drawSquare(t, 100);

      // Only draw the single tilted square to match the specified output

         JFrame frame = new JFrame("Unit2, Lab18");
         frame.setSize(800, 600);    //makes the mouse location correct
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new Driver18());
         frame.requestFocus();
         frame.setVisible(true);
         
      }

       private static void drawSquare(Turtle t, int length)
       {
          for (int k = 0; k < 4; k++)
          {
             t.forward(length);
             t.turnRight(90);
          }
       }

       @Override
       public void paintComponent(Graphics g)
       {
          super.paintComponent(g);
          g.drawImage(Turtle.getImage(), 0, 0, getWidth(), getHeight(), null);
       }
   }
