import java.awt.*;

/**
 * Created by TrungNT on 3/6/2016.
 */
public class PlaneEnemyCircle extends PlaneEnemy{
    private int hinhtron=0;

    //phuong thuc khoi tao cua PlaneEnemyCircle khong tham so
    private PlaneEnemyCircle()
    {
        super();
    }

    //phuong thuc khoi tao cua PlaneEnemyCircle co tham so
    public PlaneEnemyCircle(int x, int y, int speed, int planeType)
    {
        super(x, y, speed, planeType);
    }

    //di chuyen toa do cua may bay bay theo hinh tron
    private void moveCircle()
    {
        hinhtron++;
        this.postionX += (double)(15*Math.sin(hinhtron*0.09));
        this.postionY += (double)(15*Math.cos(hinhtron*0.09));

        System.out.println("X=" + this.postionX);
        System.out.println("Y=" + this.postionY);
    }

    //cap nhat trang thai cua may bay PlaneEnemyCircle
    public void update()
    {
        //goi phuong thuc move
        this.moveCircle();
    }

    //ve may bay PlaneEnnemyCircle
    public void draw(Graphics g)
    {
        super.draw(g);
    }
}
