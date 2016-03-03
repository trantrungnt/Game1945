import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by TrungNT on 2/29/2016.
 */
public class Bullet extends GameObject {
    private int direction;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private int speed;

    public void setPostionX(int x)
    {
        this.postionX = x;
    }

    public int getPostionX()
    {
        return postionX;
    }

    public void setPostionY(int y)
    {
        this.postionY = y;
    }

    public int getPostionY()
    {
        return postionY;
    }

    //phuong thuc di chuyen cua dan Bullet
    private void move()
    {
        this.postionY -= this.speed;
    }

    //phuong thuc cap nhat trang thai di chuyen cua dan Bullet
    public void update()
    {
        this.move();
    }

    //Phuong thuc ve dan bullet
    public void draw(Graphics g)
    {
        g.drawImage(this.sprite, this.postionX, this.postionY,  null);
    }

    //phuong thuc khoi tao khong tham so cua dan Bullet
    private Bullet()
    {}

    //phuong thuc khoi tao co tham so cua dan Bullet
    public Bullet(int x, int y,int speed) {
        this.postionX = x;
        this.postionY = y;
        this.speed = speed;
        try {
            this.sprite = ImageIO.read(new File("Resouces/DAN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
