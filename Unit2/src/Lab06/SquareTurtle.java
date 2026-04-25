	//Name______________________________ Date_____________
   package Lab06;
   import edu.fcps.Turtle;
  
    public class SquareTurtle extends Turtle
   {
      private double mySize;
   
   	//*************************constructors*************************
       public SquareTurtle()
      {
         super();
         mySize = 50.0;
      }
       public SquareTurtle(double n)
      {
         super();
         mySize = n;
      }
       public SquareTurtle(double x, double y, double h)
      {
         super(x, y, h);
         mySize = 50.0;
      }
       public SquareTurtle(double x, double y, double h, double n)
      {
         super(x, y, h);
         mySize = n;
      }
   
   	//************************methods*****************************
       public void setSize(double n)
      {
         mySize = n;
      }
       public void drawShape()
      {
         
         for (int i = 0; i < 4; i++) {
            forward(mySize);   // 讓烏龜前進一邊長
            turnLeft(90);      // 左轉90度
            // 若有 delay 方法可用，這裡加上 delay
            // 例如: Turtle.delay(100); 或 Thread.sleep(100);
    
         }
        
      
      }
   }