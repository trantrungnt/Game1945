import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by TrungNT on 2/28/2016.
 */
public class Plane {
    public int postionX;
    public int postionY;
    public int speed;
    public int heath;
    public int damage; //do sat thuong
    public int planeType;
    public BufferedImage sprite; //hinh anh cua game2D
    public int direction;

    public void move()
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

    public void update()
    {
        move();
    }

    public void draw(Graphics g)
    {
        g.drawImage(this.sprite, this.postionX, this.postionY, null);
    }
}
