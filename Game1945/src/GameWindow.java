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
    BufferedImage plane4, plane1, bullet1A, bullet1B;
    int xPlane4, yPlane4, xPlane1, yPlane1, xBullet1A, yBullet1A, xBullet1B, yBullet1B;
    int direction=0;
    int directionBullet1=5; //Huong di chuyen cua dan Bullet di len tren: x giu nguyen, y giam

    public GameWindow()
    {
        xPlane4 = 200;
        yPlane4 = 300;

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
            plane4 = ImageIO.read(new File("Resouces/PLANE4.png"));
            plane1 = ImageIO.read(new File("Resouces/PLANE1.png"));
            bullet1A = ImageIO.read(new File("Resouces/DAN.png"));
            bullet1B = ImageIO.read(new File("Resouces/DAN.png"));

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

    @Override
    public void paint(Graphics g)
    {
        g.drawImage(background, 0, 0, null);
        //g.drawLine(0, 0, 100, 100);
        //g.drawImage(plane4, xPlane4, yPlane4, null);
        g.drawImage(plane1, xPlane1, yPlane1, null);
        g.drawImage(bullet1A, xBullet1A, yBullet1A,  null);
        g.drawImage(bullet1B, xBullet1B, yBullet1B, null);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Ban nhan phim: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()=='w') //di chuyen len tren
        {
            //yPlane -= 30;
            //repaint();
            direction = 1;
        }

        if(e.getKeyChar() == 's') //di chuyen xuong duoi
            direction = 2;
        if(e.getKeyChar() == 'd') //di chuyen sang phai
            direction = 3;
        if(e.getKeyChar() == 'a') //di chuyen sang trai
            direction = 4;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        int x = 0;

        while(true)
        {
            //System.out.println(x++);
            //Huong di cua may bay so 4
            if(direction==0){
            }
            else
            if(direction==1){
                yPlane4 -=3;
            }
            else
            if(direction==2)
                yPlane4 +=3;
            else
            if(direction==3)
                xPlane4+=3;
            else
            if (direction==4)
                xPlane4-=3;

            //di chuyen huong di cua dan Bullet1A va Bullet1B theo Plane1
            if(directionBullet1==5){
                yBullet1A -=3;
                yBullet1B -=3;
            }

            repaint();

            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
