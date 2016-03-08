import java.util.Vector;

/**
 * Created by TrungNT on 3/8/2016.
 */
public class PlaneEnemySin extends PlaneEnemy {
    private Vector<IMove> vecIMove = new Vector<>();
    private int count=0;
    private int angle=0; //goc quay cho ham so dang hinh sin

    private PlaneEnemySin()
    {
        super();
    }

    public PlaneEnemySin(int x, int y, int speed, int planType)
    {
        super(x, y, speed, planType);
    }

    private void move()
    {
        this.angle += Math.PI/40;
        //di chuyen dang hinh sin
        //(double) this.postionX = 50*Math.sin(angle) + 120; //do thi dang hinh xin
    }

    public void update()
    {
        this.move();
    }

}
