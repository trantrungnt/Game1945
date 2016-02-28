import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by TrungNT on 2/27/2016.
 */
public class GameWindow extends Frame implements KeyListener, Runnable{

    BufferedImage background;
    BufferedImage plane4;
    int xPlane, yPlane;
    int direction=0;

    public GameWindow()
    {
        xPlane = 200;
        yPlane = 300;
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

        }catch (Exception e)
        {
            System.out.println(e.toString());
        }

        this.addKeyListener(this);


        repaint();

    }

    @Override
    public void paint(Graphics g)
    {
        g.drawImage(background, 0, 0, null);
        g.drawLine(0, 0, 100, 100);
        g.drawImage(plane4, xPlane, yPlane, null);


    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Ban nhan phim: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()=='w')
        {
            //yPlane -= 30;
            //repaint();
            direction = 1;
        }

        if(e.getKeyChar() == 's')
            direction = 2;
        if(e.getKeyChar() == 'd')
            direction = 3;
        if(e.getKeyChar() == 'a')
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
                yPlane -=3;
            }
            else
            if(direction==2)
                yPlane +=3;
            else
            if(direction==3)
                xPlane+=3;
            else
            if (direction==4)
                xPlane-=3;
            repaint();

            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
