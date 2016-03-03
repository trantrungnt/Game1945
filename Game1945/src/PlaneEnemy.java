import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by TrungNT on 3/3/2016.
 */
public class PlaneEnemy extends PlaneObject{

    //Khai bao thuoc tinh cua PlaneEnemy
    private int count=0;
    private Vector<Bullet> vecBullet = new Vector<Bullet>();

    private PlaneEnemy()
    {
        //tam thoi khong lam gi khi khoi tao khong co tham so
    }


    //phuong thuc khoi tao may bay dich co tham so
    public PlaneEnemy(int x, int y, int speed)
    {
        //khoi tao toa do va toc do bay
        this.postionX = x;
        this.postionY = y;
        this.speed = speed;

        //load anh may bay dich
        try {
            this.sprite = ImageIO.read(new File("Resouces/PLANE3.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //dinh nghia phuong thuc di chuyen cua may bay dich
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

    //dinh nghia phuong thuc cap nhat trang thai cua may bay dich
    public void update()
    {
        //goi phuong thuc move cua may bay dich
        move();

        //60 lan/ 1 giay
        count++;
        if (count>120)
        {
            //goi phuong thuc ban (khoi tao toa do cua dan)
            this.shot();
            count = 0;
        }

        for (Bullet bul : vecBullet)
            bul.update();;

    }


    //ve may bay dich
    public void draw(Graphics g)
    {
        //ve may bay dich
        g.drawImage(this.sprite, this.postionX, this.postionY, null);

        //ve dan
        for (Bullet bul : vecBullet)
            bul.draw(g);
    }

    //dinh nghia phuong thuc shot de may bay dich ban
    public void shot()
    {
        //xac dinh toa do cua dan o day
        Bullet bullet = new Bullet(this.postionX+30, this.postionY+59, -5);
        vecBullet.add(bullet);
    }

}
