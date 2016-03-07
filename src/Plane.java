import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by TrungNT on 2/28/2016.
 */
public class Plane extends PlaneObject{
    public void setDirection(int direction) {
        this.direction = direction;
    }
    private int direction;
    private Vector<Bullet> vecBullet = new Vector<Bullet>();

    //de private phuong thuc khoi tao khong tham so, de ko co ai duoc goi ham nay va su dung
    private Plane()
    {
        this.postionX = 300;
        this.postionY = 300;
        this.speed = 4;

        try{
            this.sprite = ImageIO.read(new File("Resouces/PLANE1.png"));
        }catch (Exception e){
            e.toString();
        }
    }

    //Phuong thuc khoi tao co tham so
    public Plane(int postionX, int postionY, int speed, int planeType)
    {
        this.postionX = postionX;
        this.postionY = postionY;
        this.speed = speed;
        this.planeType = planeType;

        //xet Kieu may bay de load Anh may bay
        switch (planeType) {
            case 1:
                try{
                    this.sprite = ImageIO.read(new File("Resouces/PLANE1.png"));
                }catch (Exception e){
                    System.out.println(e.toString());
                }
                break;
            case 2:
                try{
                    this.sprite = ImageIO.read(new File("Resouces/PLANE2.png"));
                }catch (Exception e){
                    System.out.println(e.toString());
                }
                break;
            case 3:
                try{
                    this.sprite = ImageIO.read(new File("Resouces/PLANE3.png"));
                }catch (Exception e){
                    System.out.println(e.toString());
                }
                break;
            case 4:
                try{
                    this.sprite = ImageIO.read(new File("Resouces/PLANE4.png"));
                }catch (Exception e){
                    System.out.println(e.toString());
                }
                break;
        }
    }




    //an tro chuot, sua class Plane sao cho thoa man 2 dieu kien: 1 con chay chuot, 1 con chay phim: them bien kieu dieu khien, ra soat thuoc tinh xem: de access lai quyen truy cap cho no: private + public cho phu hop (get, set cho private)
    private void move() //Phuong thuc move khong tham so cho may bay Plane4 su dung ban phim
    {
        if(this.direction ==0)
        {}
        else
            if(this.direction ==1)
            {
                this.postionY -= this.speed;
            }
                else
                    if(this.direction==2) //di chuyen xuong: phim s
                        this.postionY+=this.speed;
                    else
                        if(direction==3) //di chuyen sang phai: phim d
                            this.postionX+=this.speed;
                        else
                            if (direction==4) //di chuyen sang trai: phim a
                            {
                                this.postionX-=this.speed;
                            }

    }

    //Phuong thuc move cho may bay Plane1 su dung Chuot dieu khien
    public void move(int x, int y)
    {
        this.postionX = x;
        this.postionY = y;
    }

    //cap nhat lai trang thai di chuyen cua may bay
    public void update()
    {
        //goi phuong thuc di chuyen move cua may bay
        this.move();

        //duyet dan va add toa do cua dan
        for (Bullet bullet : vecBullet) {
            //cap nhat trang thai di thang cua dan bullet1
            bullet.update(0);
        }


    }

    //ve may bay va dan Bullet
    public void draw(Graphics g)
    {
        //ve may bay
        g.drawImage(this.sprite, this.postionX, this.postionY, null);

        //ve dan bullet
        for (Bullet bullet : vecBullet) //kieu du lien Bullet trong mang co kieu du lieu Vector la: vecBullet
        {
            //goi phuong thuc draw cua bullet: duyet mang vector va ve
            bullet.draw(g);
        }

    }

    //dinh nghia phuong thuc shot cua May bay
    public void shot()
    {
        //khoi tao doi tuong bullet va nhet no vao mang vecBullet1 co kieu du lieu Vector
        Bullet bul = new Bullet(this.postionX + 30, this.postionY, 10, 0);
        vecBullet.add(bul);

    }
}