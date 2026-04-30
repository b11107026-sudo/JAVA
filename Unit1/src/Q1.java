import javax.swing.JOptionPane;

import edu.fcps.karel2.Display;

public class Q1 {
    public static void main(String[] args) {
        
        String filename = JOptionPane.showInputDialog("What robot world?");
        Display.openWorld("maps/"+filename+".map");
        Display.setSize(15, 15);
        Display.setSpeed(7);
        
        Athlete[] athletes = new Athlete[4];
        for(int i = 0; i < 4; i++) {
            athletes[i] = new Athlete(i + 1, 1, Display.NORTH, 0);
        }
        
        int[] columnHeights = new int[4];
        
        for(int col = 0; col < 4; col++) { 
            Athlete scanner = athletes[col];
            int height = 0;
            
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
        
        
        int[] yPositions = {4, 3, 2, 1}; 
        
        for(int i = 0; i < 4; i++) {
            Athlete placer = athletes[i];
            int y = yPositions[i];
            int numBeepers = columnHeights[3 - i]; 
            
            placer.turnAround();
            while(placer.frontIsClear()) {
                placer.move();
            }
            if(placer.rightIsClear()){
                placer.turnRight();
                while (placer.frontIsClear()) {
                    placer.move();
                }
                placer.turnRight();
            }else {
                placer.turnAround();
            }//done for setting yPosition
            for(int step = 1; step < y; step++) {
                placer.move();
            }
            placer.turnRight();
            
            for(int count = 0; count < y; count++) {
                placer.putBeeper();
                if(count < y - 3) {
                    placer.move();
                    placer.putBeeper();

                }
            }
        }
    }
}
