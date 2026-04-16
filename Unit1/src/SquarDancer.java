public class SquarDancer extends Dancer {
    public SquarDancer(int x, int y, int dir, int beep) {
        super(x, y, dir, beep);
    }

    public SquarDancer() {
    }

    public void danceStep(){
        for(int k = 1; k <= 4; k++)
        {
            move();
            move();
            turnLeft();
        }
    }
}
