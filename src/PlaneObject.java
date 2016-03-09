import java.awt.image.BufferedImage;

/**
 * Created by TrungNT on 3/2/2016.
 */
public abstract class PlaneObject extends GameObject {
    //ke thua GameObject de dung thuoc tinh toa do va Anh nen
    protected double speed;
    protected double heath;
    protected double damage; //do sat thuong
    protected double planeType;

    //toa do x
    public void setPostionX(double x)
    {
        this.postionX = x;
    }

    public double getPostionX()
    {
        return postionX;
    }

    //toa do y
    public void setPostionY(double y)
    {
        this.postionY = y;
    }

    public double getPostionY()
    {
        return postionY;
    }

    //toc do speed
    public void setSpeed(double td)
    {
        this.speed = td;
    }

    public double getSpeed()
    {
        return speed;
    }

    //suc manh
    public void setHeath(double healthy)
    {
        this.heath = healthy;
    }

    public double getHeath()
    {
        return heath;
    }

    //do sat thuong
    public void setDamage(double st)
    {
        this.damage = st;
    }

    public double getDamage()
    {
        return damage;
    }
}
