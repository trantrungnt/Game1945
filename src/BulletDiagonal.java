import java.awt.*;

/**
 * Created by TrungNT on 3/7/2016.
 */
public class BulletDiagonal extends Bullet implements IMove{

    //phuong thcu khoi tao co tham so cua class BulletDiagonal
    public BulletDiagonal(int x, int y, int speed, int planeType) {
        super(x, y, speed, planeType);
    }

    //dinh nghia phuong thuc di chuyen cheo trai phai
    @Override
    public void move() {
        if(this.speed < 0) { //di chuyen cheo trai
            this.postionY -= this.speed;
            this.postionX += this.speed;
        }
        if(this.speed > 0){ //di chuyen cheo phai
            this.postionY += this.speed;
            this.postionX += this.speed;
        }
    }

    //dinh nghia phuong thuc ve hinh draw cua class BulletDiagonal
    public void draw(Graphics g)
    {
        //do ham draw da dinh nghia o class cha Bullet nen va class nay ke thua nen su dung lai duoc
        super.draw(g);
    }

}
