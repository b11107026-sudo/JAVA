public class SquareDancer_Large extends Dancer {
    public SquareDancer_Large(int x, int y, int dir, int beep) {
        super(x, y, dir, beep);
    }

    public SquareDancer_Large() {
    }

    public void danceStep() {
        for(int k = 1; k <= 4; k++)
        {
            move();
            move();
            move();
            move();
            turnLeft();
        }
    }



}