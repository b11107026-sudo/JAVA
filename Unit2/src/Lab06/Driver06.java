	//Name______________________________ Date_____________
   package Lab06;
   import edu.fcps.Turtle;
   import java.awt.Color;
   import javax.swing.*;

    public class Driver06
   {
       public static void main(String[] args)
      {
         // 建立視窗與畫布
         JFrame frame = new JFrame("Square Turtles");
         frame.setSize(400, 400); // 設定視窗大小
         frame.setLocation(200, 100); // 設定視窗位置
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 關閉視窗時結束程式
         frame.setContentPane(new TurtlePanel()); // 設定畫布
         frame.setVisible(true); // 顯示視窗

         // 啟用烏龜爬行動畫效果
         Turtle.setCrawl(true);     //a class method

         // 建立一隻藍色、線條粗細為6的方形烏龜，畫出方形
         SquareTurtle smidge = new SquareTurtle();
         smidge.setColor(Color.BLUE);
         smidge.setThickness(6);
         smidge.drawShape();

         // 建立一隻邊長為100的方形烏龜，畫出方形
         smidge = new SquareTurtle(100);
         smidge.drawShape();

         // 建立一隻位置(100,250)、角度45度、邊長20的方形烏龜，顏色紅色，線條粗細4，畫出方形
         smidge = new SquareTurtle(100, 250, 45, 20);
         smidge.setColor(Color.red);
         smidge.setThickness(4);
         smidge.drawShape();

         // 用 for 迴圈畫出多個黃色、不同邊長的方形烏龜
         for(int i = 30; i <= 150; i += 30)
         {
            smidge = new SquareTurtle(500, 250, 45, i); // 位置(500,250)、角度45度、邊長i
            smidge.setColor(Color.yellow); // 設定顏色為黃色
            smidge.setThickness(2); // 線條粗細2
            smidge.drawShape(); // 畫出方形
         }
      

      }
   }