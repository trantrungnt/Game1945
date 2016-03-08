import java.awt.*;
import java.util.Vector;

/**
 * Created by TrungNT on 3/6/2016.
 */
public class PlaneEnemyHorizontal extends PlaneEnemy {
    private int count=0;
    private Vector<IMove> vecIMove = new Vector<>();

    //phuong thuc khoi tao khong tham so
    private PlaneEnemyHorizontal()
    {
        //su dung lai phuong thuc cua PlaneEnemy
        super();
    }

    //phuong thuc khoi tao cua PlaneEnemyHorizontal
    public PlaneEnemyHorizontal(int x, int y, int speed, int planeType) {
        //goi phuong thuc khoi tao cua PlaneEnemy
        super(x, y, speed, planeType);
    }

    //Phuong thuc di chuyen cua may bay PlaneEnemy di chuyen sang ngang
    private void move()
    {
        //may bay dich di chuyen sang ngang
        this.postionX += this.speed;

        //may bay dich di chuyen ra khoi man hinh ben trai --> ra ngoai truc tung Oy
        if(this.postionX <= 0)
            this.speed =- this.speed;

        //may bay dich di chuyen ra khoi man hinh ben phai --> ra ngoai va lon hon man hinh x = 400
        if (this.postionX >= 400)
            this.speed =-this.speed;
    }

    //cap nhat lai trang thai cua PlaneEnemyHorizontal
    public void update()
    {
        //cap nhat lai toa do cua PlaneEnemyHorizontal
        this.move();
        //60 lan/ 1 giay
        count++;
        if (count>120)
        {
            //goi phuong thuc ban (khoi tao toa do cua dan)
            this.shot();
            count = 0;
        }

        //cap nhat lai trang thai cua BulletDiagonal va BulletStraight
        for (IMove bulMove : vecIMove) {
            if (bulMove instanceof BulletDiagonal)
                bulMove.move();
            if (bulMove instanceof BulletStraight)
                bulMove.move();
        }
    }

    //ve may bay dich
    public void draw(Graphics g)
    {
        super.draw(g);
        for (IMove bulMove : vecIMove) {
            if (bulMove instanceof BulletDiagonal)
                bulMove.draw(g);
            if (bulMove instanceof BulletStraight)
                bulMove.draw(g);
        }
    }

    //khoi tao toa do cho dan
    public void shot()
    {
        BulletDiagonal bulletDiagonalLeft = new BulletDiagonal(postionX +30, postionY + 59, 5, 1);
        BulletDiagonal bulletDiagonalRight = new BulletDiagonal(postionX +30, postionY + 59, -5, 1);
        BulletStraight bulletStraight = new BulletStraight(postionX + 30, postionY + 59, -5, 1);

        vecIMove.add(bulletDiagonalLeft);
        vecIMove.add(bulletDiagonalRight);
        vecIMove.add(bulletStraight);
    }
}
