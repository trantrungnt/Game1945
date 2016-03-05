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
    private Vector<Bullet> vecBullet1 = new Vector<Bullet>();
    private Vector<Bullet> vecBullet2 = new Vector<Bullet>();
    private Vector<Bullet> vecBullet3 = new Vector<Bullet>();

    private PlaneEnemy()
    {
        //tam thoi khong lam gi khi khoi tao khong co tham so
    }


    //phuong thuc khoi tao may bay dich co tham so
    public PlaneEnemy(int x, int y, int speed, int planeType)
    {
        //khoi tao toa do va toc do bay
        this.postionX = x;
        this.postionY = y;
        this.speed = speed;
        this.planeType = planeType;

        //load anh may bay dich
        switch (planeType)
        {
            case 3:
                try {
                    this.sprite = ImageIO.read(new File("Resouces/PLANE3.PNG"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    this.sprite = ImageIO.read(new File("Resouces/PLANE2.PNG"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
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

        //cap nhat trang thai cua tap cac vien dan di thang
        for (Bullet bul1 : vecBullet1)
            bul1.update(0);

        //cap nhat tap trang thai cua tap cac vien dan di cheo sang trai
        for (Bullet bul2 : vecBullet2) {
            bul2.update(1);
        }

        //cap nhat tap trang thai cua tap cac vien dan di cheo sang phai
        for (Bullet bul3 :vecBullet3)
            bul3.update(2);
    }


    //ve may bay dich
    public void draw(Graphics g)
    {
        //ve may bay dich
        g.drawImage(this.sprite, this.postionX, this.postionY, null);

        //ve dan
        for (Bullet bul1 : vecBullet1)
            bul1.draw(g);

        //ve dan bullet 2
        for (Bullet bul2 : vecBullet2)
            bul2.draw(g);

        //ve dan bullet 3
        for (Bullet bul3 : vecBullet3)
            bul3.draw(g);
    }

    //dinh nghia phuong thuc shot de may bay dich ban
    public void shot()
    {
        //xac dinh toa do cua dan bullet 1 o day
        Bullet bullet1 = new Bullet(this.postionX+30, this.postionY+59, -5, 1);
        vecBullet1.add(bullet1);

        //xac dinh toa do cua dan bullet 2 o day
        Bullet bullet2 = new Bullet(this.postionX+30, this.postionY+59, -5, 1);
        vecBullet2.add(bullet2);

        //xac dinh toa do cua dan bullet 3 tai day
        Bullet bullet3 = new Bullet(this.postionX+30, this.postionY+59, -5, 1);
        vecBullet3.add(bullet3);
    }

}
