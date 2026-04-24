import edu.fcps.Digit;

public class Damirror extends Digitmirror{
    public Damirror(int x, int y) {
        super(x, y);
    }
    public void displaymirror(){
        segment1_Off();
        segment2_Off();
        segment3_Off();
        segment4_Off();
        segment5_Off();
        segment6_Off();
        segment7_On();
    }
}
