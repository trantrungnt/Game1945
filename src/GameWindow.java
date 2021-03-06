import javafx.stage.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;

/**
 * Created by TrungNT on 2/27/2016.
 */
public class GameWindow extends Frame implements MouseListener,MouseMotionListener, KeyListener, Runnable{

    BufferedImage background;
    Plane plane4, plane1, plane2;  //tham chieu
    PlaneEnemyHorizontal planeEnemyHorizonal1;
    PlaneEnemyCircle planeEnemyCircle1;
    PlaneEnemySin planeEnemySin1;
    Image image;
    Graphics seconds;
    Vector<PlaneEnemy> vecPlaneEnemy = new Vector<PlaneEnemy>();

    public GameWindow()
    {
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

        //an con tro hien tai
        this.setCursor();

        //load anh tu thu muc Resources
        try{
            background = ImageIO.read(new File("Resouces/Background.png"));
        }catch (Exception e){
            System.out.println(e.toString());
        }

        //goi phuong thuc khoi tao may bay
        initPlane();

        //dang ky su kien nhan ban phim va su kien nhan Chuot
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);

        //ve lai
        repaint();

    }

    //Phuont thuc khoi tao May bay Plane
    private void initPlane()
    {
        //su dung phuong thuc khoi tao co htam so de hien thi toa do lan dau tien cua May bay Plane1 va Plane4
        plane1 = new Plane(200, 450, 3, 1);
        plane4 = new Plane(90, 450, 4, 4);

        //khoi tao toa do may bay dich
        planeEnemyHorizonal1 = new PlaneEnemyHorizontal(100, 50, 3, 2);
        planeEnemyCircle1 = new PlaneEnemyCircle(100, 150, 3, 3);
        planeEnemySin1 = new PlaneEnemySin(100,50, 3, 2);

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
        //ve may bay plane1
        plane1.draw(g);

        //ve may bay plane4
        plane4.draw(g);

        //duyet tung vector may bay dich ve may bay dich planeEnemy
        /*for (PlaneEnemy oplaneEnemy : vecPlaneEnemy)
            oplaneEnemy.draw(g);*/
        planeEnemyHorizonal1.draw(g);
        planeEnemyCircle1.draw(g);
        planeEnemySin1.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Ban nhan phim: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) { //khi nhan phim xuong thi kiem tra trang thai cua direction cua Plane4
        if(e.getKeyChar()=='w') //di chuyen len tren
                plane4.setDirection(1);

        if(e.getKeyChar() == 's') //di chuyen xuong duoi
                plane4.setDirection(2);

        if(e.getKeyChar() == 'd') //di chuyen sang phai
                plane4.setDirection(3);

        if(e.getKeyChar() == 'a') //di chuyen sang trai
        {
            plane4.setDirection(4);
        }

        if(e.getKeyChar() == 'b')
        {
            //goi phuong thuc ban cho may bay so 4: Plane4
            plane4.shot();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { //khi tha phim ra thi may bay plane dung yen
        plane4.setDirection(0);
    }

    @Override
    public void run() {
        while(true)
        {
            //bullet1A = new Bullet();
            //System.out.println(x++);
            //cap nhat lai trang thai cua may bay so 4
            plane4.update();
            //cap nhat lai trang thai cua may bay so 1
            plane1.update();

            //cap nhat lai trang thai cua may bay dich
            //dung vector de them may bay dich (vi may bay dich ta chua biet truoc so luong)
            /*for (PlaneEnemy oplaneEnemy : vecPlaneEnemy)
              oplaneEnemy.update();*/

            planeEnemyHorizonal1.update();
            planeEnemyCircle1.update();
            planeEnemySin1.update();

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
        /*plane1.setPostionX(e.getX());
        plane1.setPostionY(e.getY());*/
        //goi phuong thuc move co tham so trong class Plane de lay toa do chuot
        plane1.move(e.getX(), e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        /*bullet1A.direction = 5;
        bullet1B.direction = 5;
        //toa do cua dan 1A
        bullet1A.setPostionX(e.getX());
        bullet1A.setPostionY(e.getY());

        //toa do cua dan 1B
        bullet1B.setPostionX(e.getX() + 58);
        bullet1B.setPostionY(e.getY());*/
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //goi phuong thuc ban shod method cua may bay so 1
        plane1.shot();
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
