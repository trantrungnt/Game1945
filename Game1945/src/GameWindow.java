import javafx.stage.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by TrungNT on 2/27/2016.
 */
public class GameWindow extends Frame implements MouseListener,MouseMotionListener, KeyListener, Runnable{

    BufferedImage background;
    //BufferedImage plane4, plane1, bullet1A, bullet1B, bullet4A, bullet4B;
    int xPlane1, yPlane1, xBullet1A, yBullet1A, xBullet1B, yBullet1B, yBullet4A, xBullet4B, yBullet4B;
    int directionBullet; //Huong di chuyen cua dan Bullet di len tren: x giu nguyen, y giam

    Plane plane4;  //tham chieu
    Image image;
    Graphics seconds;

    public GameWindow()
    {
        //an con tro hien tai
        this.setCursor();

        plane4 = new Plane();
        plane4.setPostionX(150);
        plane4.setPostionY(300);
        plane4.setSpeed(3);

        //toa do Plane4 khi khoi tao dau tien
        plane4.setPostionX(200);
        plane4.setPostionY(300);

        //toa do Plane1 khi khoi tao dau tien
        xPlane1 = 250;
        yPlane1 = 250;

        this.setTitle("This is Game 1945");
        this.setSize(400,640);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        try {
            background = ImageIO.read(new File("Resouces/Background.png"));
            plane4.sprite = ImageIO.read(new File("Resouces/PLANE4.png"));


        }catch (Exception e)
        {
            System.out.println(e.toString());
        }

        //dang ky su kien nhan ban phim va su kien nhan Chuot
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);

        //ve lai
        repaint();

    }

    //dinh nghia phuong thuc an con tro chuot hien tai
    private void setCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point hotSpot = new Point(0,0);
        BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
        Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "InvisibleCursor");
        setCursor(invisibleCursor);
    }

    @Override
    public void paint(Graphics g)
    {
        g.drawImage(background, 0, 0, null);
        //g.drawImage(plane4.sprite, plane4.getPostionX(), plane4.getPostionY(), null);
        plane4.draw(g); //ve may bay plane4
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Ban nhan phim: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) { //khi nhan phim xuong thi kiem tra trang thai cua direction cua Plane4
        if(e.getKeyChar()=='w') //di chuyen len tren
                plane4.direction = 1;

        if(e.getKeyChar() == 's') //di chuyen xuong duoi
                plane4.direction = 2;

        if(e.getKeyChar() == 'd') //di chuyen sang phai
                plane4.direction = 3;

        if(e.getKeyChar() == 'a') //di chuyen sang trai
                plane4.direction = 4;


        /*if(e.getKeyChar() == 'b')
        {
            directionBullet = 6;
            //khi nhan phim thi xac dinh toa do cua dan Bullet4A khi khoi tao dau tien
            xBullet4A = 200;
            yBullet4A = 312;

            //khi nhan phim thi xac dinh toa do cua dan Bullet4B khi khoi tao dau tien
            xBullet4B = 255;
            yBullet4B = 312;

        }*/
    }

    @Override
    public void keyReleased(KeyEvent e) { //khi tha phim ra thi may bay plane dung yen
        plane4.direction = 0;
    }

    @Override
    public void run() {
        while(true)
        {
            //System.out.println(x++);
            //cap nhat lai trang thai cua may bay so 4
            plane4.update();

            //di chuyen huong di cua dan Bullet1A va Bullet1B theo Plane1
            if(directionBullet==5){ //gia tri 5 cho trang thai dan cua Plane1
                //toa dan 1A
                yBullet1A -=3;
                //toa do dan 1B
                yBullet1B -=3;
            }
            //di chuyen huong di cua dan Bullet4A va bullet4B theo Plane4
            if(directionBullet==6)
            {
                //toa do dan 4A
                yBullet4A -=3;
                //toa do dan 4B
                yBullet4B -=3;
            }

            repaint();

            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Phuong thuc xu ly chong man hinh bi giat
    @Override
    public void update(Graphics g)
    {
        if(image ==null)
        {
            image = createImage(this.getWidth(), this.getHeight());
            seconds = image.getGraphics();
        }

        seconds.setColor(getBackground());
        seconds.fillRect(0, 0, getWidth(), getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image, 0, 0, null);
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //toa do cua Plane so 1 theo tro chuot
        xPlane1 = e.getX();
        yPlane1 = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        directionBullet = 5;
        //toa do cua dan 1A
        xBullet1A = e.getX();
        yBullet1A = e.getY();

        //toa do cua dan 1B
        xBullet1B = e.getX() + 58;
        yBullet1B = e.getY();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
