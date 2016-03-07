import java.awt.*;

/**
 * Created by TrungNT on 3/6/2016.
 */
public class PlaneEnemyHorizontal extends PlaneEnemy {
    private int count=0;

    //phuong thuc khoi tao khong tham so
    private PlaneEnemyHorizontal()
    {
        super();
        //su dung lai phuong thuc cua PlaneEnemy
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
        /*count++;
        if (count>120)
        {
            //goi phuong thuc ban (khoi tao toa do cua dan)
            this.shot();
            count = 0;
        }*/
    }

    //ve may bay dich
    public void draw(Graphics g)
    {
        super.draw(g);
    }
}
