import java.awt.image.BufferedImage;

/**
 * Created by TrungNT on 3/2/2016.
 */
public class PlaneObject extends GameObject {
    //ke thua GameObject de dung thuoc tinh toa do va Anh nen
    protected int speed;
    protected int heath;
    protected int damage; //do sat thuong
    protected int planeType;

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
}
