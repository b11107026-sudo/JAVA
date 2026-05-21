package Lab14;

   import javax.swing.JFrame;
    public class Driver14
   {
       public static void main(String[] args)
      { 
         JFrame frame = new JFrame("Unit2, Lab14: Bumper");
         frame.setSize(400, 400);
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	frame.setContentPane(new BumperPanel());
         frame.setVisible(true);
      }
   }
