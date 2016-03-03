import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by TrungNT on 2/28/2016.
 */
public class Plane {
    //viet class Plane Abstract, tao 2 loai Enemy co cach ban: 1 loai di vong tron  (viet phuong trinh bau duc (ban 2 vien 1 lan)), 1 con di chuyen binh thuong: ban dan toe 3 huong, doi Dan, cho hinh may bay dich nho lai: dealine: toi thu 6
    private int postionX;
    private int postionY;
    private int speed;
    private int heath;
    private int damage; //do sat thuong
    private int planeType;
    public BufferedImage sprite; //hinh anh cua game2D

    public void setDirection(int direction) {
        this.direction = direction;
    }

    private int direction;
    public boolean hidden;

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


    //toa do x
    public void setPostionX(int x)
    {
        this.postionX = x;
    }

    public int getPostionX()
    {
        return postionX;
    }

    //toa do y
    public void setPostionY(int y)
    {
        this.postionY = y;
    }

    public int getPostionY()
    {
        return postionY;
    }

    //toc do speed
    public void setSpeed(int td)
    {
        this.speed = td;
    }

    public int getSpeed()
    {
        return speed;
    }

    //suc manh
    public void setHeath(int healthy)
    {
        this.heath = healthy;
    }

    public int getHeath()
    {
        return heath;
    }

    //do sat thuong
    public void setDamage(int st)
    {
        this.damage = st;
    }

    public int getDamage()
    {
        return damage;
    }

    //an tro chuot, sua class Plane sao cho thoa man 2 dieu kien: 1 con chay chuot, 1 con chay phim: them bien kieu dieu khien, ra soat thuoc tinh xem: de access lai quyen truy cap cho no: private + public cho phu hop (get, set cho private)
    private void move()
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

    //cap nhat lai trang thai di chuyen cua may bay
    public void update()
    {
        move();
    }

    //ve may bay
    public void draw(Graphics g)
    {
        g.drawImage(this.sprite, this.postionX, this.postionY, null);
    }
}
