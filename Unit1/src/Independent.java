public class Independent extends MazeEscaper{
    public void walkDownCurrentSegment()
    {
        if(frontIsClear())
            move();
    }

    public void turnToTheNextSegment()
    {
        if(rightIsClear()){
            turnRight();
            move();
        }
        else {
            turnLeft();
        }
    }

}
