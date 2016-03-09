import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by TrungNT on 3/3/2016.
 */
public class PlaneEnemy extends PlaneObject{

    //phuong thuc khoi tao cua PlaneEnemy
    protected PlaneEnemy() //nen de protected va chi cho class ke thua no su dung ham khoi tao khong tham so, dung public cung duoc nhung khong nen
    {
        //tam thoi khong lam gi khi khoi tao khong co tham so
    }


    //phuong thuc khoi tao may bay dich co tham so
    public PlaneEnemy(double x, double y, double speed, int planeType)
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

    //ve may bay dich
    public void draw(Graphics g)
    {
        //ve may bay dich
        g.drawImage(this.sprite, (int)this.postionX, (int)this.postionY, null);
    }


}
