import edu.fcps.Digit;

public class Smirror extends Digitmirror{
    public Smirror(int x, int y) {
        super(x, y);
    }
    public void displaymirror(){
        segment1_On();
        segment2_Off();
        segment3_On();
        segment4_On();
        segment5_Off();
        segment6_On();
        segment7_On();
    }
}
