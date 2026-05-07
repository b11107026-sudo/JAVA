   //Torbert, e-mail: smtorbert@fcps.edu
	//version 6.17.2003
   package Lab11;
   import javax.swing.JFrame;
    public class Driver11
   {
       public static void main(String[] args)
      { 
         JFrame frame = new JFrame("Unit2, Lab11");
         frame.setSize(400, 400);
         frame.setLocation(200, 200);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	frame.setContentPane(new PinballPanel());
         frame.setVisible(true);
      }
   }