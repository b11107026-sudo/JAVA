import edu.fcps.Digit;

public class Da extends Digit {
    public Da(int x,int y) {
        super(x,y);
    }
    public void display() {
        segment1_Off();
        segment2_Off();
        segment3_Off();
        segment4_Off();
        segment5_Off();
        segment6_Off();
        segment7_On();
    }
}
