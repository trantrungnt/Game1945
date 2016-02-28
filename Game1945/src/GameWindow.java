import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by TrungNT on 2/27/2016.
 */
public class GameWindow extends Frame implements MouseListener, KeyListener, Runnable{

    BufferedImage background;
    BufferedImage plane4, plane1;
    int xPlane4, yPlane4, xPlane1, yPlane1;
    int direction=0;

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

        }catch (Exception e)
        {
            System.out.println(e.toString());
        }

        this.addKeyListener(this);
        this.addMouseListener(this);

        repaint();

    }

    @Override
    public void paint(Graphics g)
    {
        g.drawImage(background, 0, 0, null);
        g.drawLine(0, 0, 100, 100);
        //g.drawImage(plane4, xPlane4, yPlane4, null);
        g.drawImage(plane1, xPlane1, yPlane1, null);

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


            repaint();

            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        xPlane1 = e.getX();
        yPlane1 = e.getY();
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
