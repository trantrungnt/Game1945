import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by TrungNT on 2/29/2016.
 */
public abstract class Bullet extends GameObject implements IMove{
    private int direction;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    protected double speed;

    public void setPostionX(double x)
    {
        this.postionX = x;
    }

    public double getPostionX()
    {
        return postionX;
    }

    public void setPostionY(double y)
    {
        this.postionY = y;
    }

    public double getPostionY()
    {
        return postionY;
    }



    //phuong thuc di chuyen cua dan Bullet: di chuyen cheo sang trai
    private void moveCheoTrai()
    {
        this.postionY -=this.speed;
        this.postionX -=4;
    }

    //phuong thuc di chuyen cua dan Bullet: di chuyen cheo sang phai
    private void moveCheoPhai()
    {
        this.postionY -=this.speed;
        this.postionX +=4;
    }


    //Phuong thuc ve dan bullet
    public void draw(Graphics g)
    {
        g.drawImage(this.sprite, (int) this.postionX, (int)this.postionY, null);
    }

    //phuong thuc khoi tao khong tham so cua dan Bullet
    private Bullet()
    {}

    //phuong thuc khoi tao co tham so cua dan Bullet
    public Bullet(double x, double y,double speed, int planeType) {
        this.postionX = x;
        this.postionY = y;
        this.speed = speed;


        //kiem tra may bay ben ta thi hien thi dan DAN.png
        switch (planeType)
        {
            case 0:
                try {
                    this.sprite = ImageIO.read(new File("Resouces/DAN.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                try {
                    this.sprite = ImageIO.read(new File("Resouces/_DAN.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }


    }
}
