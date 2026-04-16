package Lab00;

import javax.swing.*;
import java.awt.*;

public class Panel00 extends JPanel {
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);//設定畫筆顏色
        g.fillRect(75, 50, 300, 125);
        g.setFont(new Font("serif",Font.BOLD,50));//設定(字型，粗體，大小)
        g.setColor(new Color(150, 150, 0));//設定畫筆顏色(紅，綠，藍)
        g.drawString("Hello World", 100, 150);
    }
}
