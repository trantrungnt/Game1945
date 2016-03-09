import java.awt.*;
import java.util.Vector;

/**
 * Created by TrungNT on 3/8/2016.
 */
public class PlaneEnemySin extends PlaneEnemy{
    private Vector<IMove> vecIMove = new Vector<>();
    private int count=0;
    private double angle=0; //goc quay cho ham so dang hinh sin

    private PlaneEnemySin()
    {
        super();
    }

    public PlaneEnemySin(double x, double y, double speed, int planType)
    {
        super(x, y, speed, planType);
    }

    //dinh nghia phuong thuc di chuyen hinh sin
    private void move()
    {
        this.angle += Math.PI / 40;
        //di chuyen dang hinh sin
        this.postionX += this.speed;
        //do thi dang hinh xin: bien do A=50, goc quay PI/40*180 do
        this.postionY = 50 * Math.sin(angle) + 100;
    }

    //phuong thuc cap nhat lai toa do di chuyen cua may bay PlaneEnemySin
    public void update()
    {
        //goi phuong thuc di chuyen move
        this.move();
    }

    //ve may bay PlaneEnemySin
    public void draw(Graphics g)
    {
        super.draw(g);
    }

}
