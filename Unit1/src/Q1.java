import javax.swing.JOptionPane;

import edu.fcps.karel2.Display;

public class Q1 {
    public static void main(String[] args) {
        
        String filename = JOptionPane.showInputDialog("What robot world?");
        Display.openWorld("maps/"+filename+".map");
        Display.setSize(15, 15);
        Display.setSpeed(5);
        
        // 建立 4 隻機器人
        Athlete[] athletes = new Athlete[4];
        for(int i = 0; i < 4; i++) {
            athletes[i] = new Athlete(i + 1, 1, Display.NORTH, 0);
        }
        
        // 第一步：掃描每欄，計算高度並撿起beepers
        int[] columnHeights = new int[4];
        
        for(int col = 0; col < 4; col++) { // col: 欄位索引 (0-3)，對應第1到第4欄
            Athlete scanner = athletes[col];
            int height = 0;
            
            // 向北掃描，計算並撿起beepers
            while(scanner.nextToABeeper()) {
                scanner.pickBeeper();
                height++;
                
                if(!scanner.frontIsClear()) {
                    break;
                }
                scanner.move();
            }
            columnHeights[col] = height;
        }
        
        // 第二步：根據倒序規則排列beepers
        // 原高度 h1, h2, h3, h4 轉換後由下往上應為 h4, h3, h2, h1
        
        // 放置beepers：每隻機器人負責特定的 y 層
        int[] yPositions = {4, 3, 2, 1}; // 第1隻 y=4，第2隻 y=3，第3隻 y=2，第4隻 y=1
        
        for(int i = 0; i < 4; i++) {
            Athlete placer = athletes[i];
            int y = yPositions[i];
            int numBeepers = columnHeights[3 - i]; // 該層應放置的 beeper 數量
            
            // 移動到 (1, y)
            placer.turnAround();
            while(placer.frontIsClear()) {
                placer.move();
            }
            placer.turnAround();
            
            for(int step = 1; step < y; step++) {
                placer.move();
            }
            
            // 向右放置連續的 beeper，直到 numBeepers 個
            for(int count = 0; count < numBeepers; count++) {
                placer.putBeeper();
                
                if(count < numBeepers - 1) {
                    placer.turnRight();
                    placer.move();
                    placer.turnLeft();
                }
            }
        }
    }
}
