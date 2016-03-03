import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by TrungNT on 2/29/2016.
 */
public class Bullet extends GameObject {
    private int direction;

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


    public void move()
    {
        this.postionY -=3;
    }

    public void draw(Graphics g)
    {
        g.drawImage(this.sprite, this.postionX, this.postionY,  null);
    }
}
