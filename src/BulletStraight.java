import java.awt.*;

/**
 * Created by TrungNT on 3/7/2016.
 */
public class BulletStraight extends Bullet implements IMove{
    //Phuong thuc khoi tao co tham so cua BulletStraight
    public BulletStraight(int x, int y, int speed, int planeType) {
        super(x, y, speed, planeType);
    }

    //phuong thuc di chuyen cua dan Bullet: di chuyen thang
    @Override
    public void move() {
        //di chuyen thang
        this.postionY -= this.speed;
    }

    public void update()
    {
        move();
    }

    public void draw(Graphics g)
    {
        g.drawImage(sprite, postionX, postionY, null);
    }

}
