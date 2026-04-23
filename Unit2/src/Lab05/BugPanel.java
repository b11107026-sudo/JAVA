    //Torbert, e-mail: smtorbert@fcps.edu	
	 //version 6.17.2003
	 //version 11.4.09  mlbillington@fcps.edu
   package Lab05;
    import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
    public class BugPanel extends JPanel
   {
      private BufferedImage myImage;  // 緩衝圖像，用於在記憶體中繪製圖形
      final int N = 400;  // 影像大小（400x400 像素）
       public BugPanel()
      {
         // 建立 400x400 的 RGB 緩衝圖像
         myImage = new BufferedImage(N, N, BufferedImage.TYPE_INT_RGB);
         Graphics buffer = myImage.getGraphics();  // 取得 Graphics 物件進行繪圖
         buffer.setColor(Color.BLUE);  // 設定背景為藍色
         buffer.fillRect(0, 0, N, N);  // 填滿整個背景
         buffer.setColor(Color.YELLOW);  // 設定線條為黃色
      
         // 建立四隻蟲物件，初始位置在正方形的四個角落
         Bug a = new Bug(0, 0);      // 左上角 (0, 0)
         Bug b = new Bug(N, 0);      // 右上角 (400, 0)
         Bug c = new Bug(N, N);      // 右下角 (400, 400)
         Bug d = new Bug(0, N);      // 左下角 (0, 400)

         // 當四隻蟲還沒到達同一位置時，持續移動並繪圖
         while (!a.sameSpot(b)){
            // 每隻蟲朝目標蟲移動 10% 的距離
            a.walkTowards(b,0.10);  // a 朝 b 移動
            b.walkTowards(c,0.10);  // b 朝 c 移動
            c.walkTowards(d,0.10);  // c 朝 d 移動
            d.walkTowards(a,0.10);  // d 朝 a 移動

            // 畫出連接四隻蟲的線，形成正方形
            buffer.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
            buffer.drawLine(b.getX(), b.getY(), c.getX(), c.getY());
            buffer.drawLine(c.getX(), c.getY(), d.getX(), d.getY());
            buffer.drawLine(d.getX(), d.getY(), a.getX(), a.getY());
         }
      }
       public void paintComponent(Graphics g)
      {
         // 將緩衝圖像繪製到面板上
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
   }