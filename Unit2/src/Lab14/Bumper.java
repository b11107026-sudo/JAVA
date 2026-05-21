// Name: 				Date:
   package  Lab14;
   import java.awt.*;
   
    public class Bumper
   {
    //private fields, all ints, for a Bumper
    //hint: the "location" of the bumper begins at its top left corner.      
      private int myX;
      private int myY;
      private int myXWidth;
      private int myYWidth;
      private Color myColor;

      // private int x ;
      // private int y ;
      // private int width;

      // private int getWidth(){
      //    return width;
      // }
      // public void setWidth(int width){
      //    this.width = width;
      // }
      // public void setX(int x){
      //    this.x = x;
      // }
      // public void setY(int y){
      //    this.y = y;
      // }
   
    
   
     //constructors
       public Bumper()         //default constructor
      {
         myX = 200;
         myY = 200;
         myXWidth = 10;
         myYWidth = 70;
         myColor = Color.BLUE;
      }
       public Bumper(int x, int y, int xWidth, int yWidth, Color c)
      {
         myX = x;
         myY = y;
         myXWidth = xWidth;
         myYWidth = yWidth;
         myColor = c;
      }
      
         //getters
         public int getX()
         {
            return myX;
         }
         public int getY()
         {
            return myY;
         }
         public int getXWidth()
         {
            return myXWidth;
         }
         public int getYWidth()
         {
            return myYWidth;
         }
         public Color getColor()
         {
            return myColor;
         }
         public void setXWidth(int xWidth)
         {
            this.myXWidth = xWidth;
         }
         public void setYWidth(int yWidth)
         {
            this.myYWidth = yWidth;
         }
         public void setColor(Color myColor){
         this.myColor = myColor;
         }
   
     // instance methods
     // chooses a random (x,y) location.  Bumper stays entirely in the window.
        public void jump(int rightEdge, int bottomEdge)
      {
         // moves location to random (x, y) within the edges
         myX = (int)(Math.random() * (rightEdge - getXWidth())) +myXWidth / 2;
         myY = (int)(Math.random() * (bottomEdge - getYWidth())) +myYWidth / 2;
      }
      
       // draws a rectangular bumper on the buffer
       public void draw(Graphics myBuffer) 
      {
         myBuffer.setColor(getColor());
         myBuffer.fillRect(getX(), getY(), getXWidth(), getYWidth());
      }   
   	// returns true if any part of the polkadot is inside the bumper
       public boolean inBumper(Lab10.Polkadot dot)
      {
         for(int x = getX(); x <= getX() + getXWidth(); x++)   //starts at upper left corner(x,y)
            for(int y = getY(); y <= getY() + getYWidth(); y++)
               if(distance(x, y, dot.getX(), dot.getY()) <= dot.getRadius() ) //checks every point on the bumper
                  return true;            
         return false;
      }  
      // returns distance between (x1, y1) and (x2, y2)
       private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }	
   }
