import javax.swing.JOptionPane;

import edu.fcps.karel2.Display;

public class Q3 {
    private static int stepCount = 0;
    private static int turnCount = 0;
    
    public static void escape_the_maze(MazeEscaper arg) {
        arg.walkDownCurrentSegment(); //you are not at the end at the start
        while(!arg.nextToABeeper()) {
            arg.turnToTheNextSegment();
            arg.walkDownCurrentSegment();
        }
    }
    
    public static void main(String[] args) {
        
        String filename = JOptionPane.showInputDialog("What robot world?");
        Display.openWorld("maps/"+filename+".map");
        Display.setSize(10, 10);
        Display.setSpeed(5);
        
        // 使用自定義的 MazeEscaper 子類別來記錄步數和轉向
        MazeEscaperWithCounter escaper = new MazeEscaperWithCounter(1, 6, Display.SOUTH, 0);
        
        escape_the_maze(escaper);
        
        // 最後輸出總數
        System.out.println("stepCount 總數: " + stepCount);
        System.out.println("turnCount 總數: " + turnCount);
    }
    
    // 自定義 MazeEscaper 子類別，添加計數和輸出
    static class MazeEscaperWithCounter extends MazeEscaper {
        public MazeEscaperWithCounter(int x, int y, int dir, int beep) {
            super(x, y, dir, beep);
        }
        
        @Override
        public void walkDownCurrentSegment() {
            if(!leftIsClear() && frontIsClear() && !nextToABeeper()) {
                move();
            }
        }
        
        @Override
        public void turnToTheNextSegment() {
            turnCount++;
            System.out.println("目前是第" + turnCount + "次轉向判斷，當下所在的 (x, y): (" + getAvenue() + ", " + getStreet() + ")");
            
            if(leftIsClear()) {
                turnLeft();
                move();
            } else {
                turnRight();
            }
        }
        
        @Override
        public void move() {
            super.move();
            stepCount++;
            System.out.println("目前是第" + stepCount + "步，該步到達的 (x, y): (" + getAvenue() + ", " + getStreet() + ")");
        }
    }
}
