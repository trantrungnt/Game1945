import java.awt.*;
import java.util.Vector;

/**
 * Created by TrungNT on 3/6/2016.
 */
public class PlaneEnemyCircle extends PlaneEnemy{
    private int hinhtron=0; //dung de tang goc cho hinh tron
    private int count=0;
    private Vector<IMove> vecBul = new Vector<>();

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
        this.postionX += (double)(5*Math.sin(hinhtron*0.09));
        this.postionY += (double)(5*Math.cos(hinhtron*0.09));

        System.out.println("X=" + this.postionX);
        System.out.println("Y=" + this.postionY);
    }

    //cap nhat trang thai cua may bay PlaneEnemyCircle
    public void update()
    {
        //goi phuong thuc move
        this.moveCircle();

        count++;
        if (count>120) {
            //goi phuong thuc di chuyen cua dan
            this.shot();

            count=0;
        }

        //cap nhat lai trang thai: toa do cua dan
        for (IMove typebullet : vecBul)
         if (typebullet instanceof BulletStraight)
            typebullet.move();
    }

    //ve may bay PlaneEnnemyCircle
    public void draw(Graphics g)
    {
        //goi phuong thuc ve cua lop PlaneEnemy
        super.draw(g);

        //ve dan cho may bay PlaneEnemyCircle
        for (IMove typebullet : vecBul)
            if (typebullet instanceof BulletStraight)
               typebullet.draw(g);
    }

    //Xac dinh toa do cua dan may bay dich bay
    public void shot()
    {
        //khoi tao toa do cua Bullet
        BulletStraight bullet = new BulletStraight(postionX + 30, postionY +59, -5, 1);

        //for (IMove bulMove : vecBul)
          //  if (bulMove instanceof BulletStraight)
                    vecBul.add(bullet);
    }

}
