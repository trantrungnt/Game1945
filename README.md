# Game1945
+ Học xử lý đồ họa trong ngôn ngữ Java: di chuyển máy bay đơn giản
+ Di chuyển máy bay số 4 bằng bàn phím: w lên trên, a sang trái, d sang phải, s xuống dưới
+ Di chuyển máy bay số 1 bằng chuột (di chuyển chuột đến đâu thì máy bay di chuyển đến vị trí đó của chuột)
+ Bắn được đạn từ máy bay số 1 khi click Chuột (bắn được đạn cả 2 bên cánh Máy bay số 1)
+ Bắn được đạn từ máy bay số 4 khi nhấn phím B để bắn đạn (bắn được cả 2 bên cánh Máy bay số 4)
+ Chọn chế độ điều khiển chuột để điều khiển máy bay: Nhấn phím C để chuyển sang điều khiển máy bay Plane1 bằng Chuột, nhấn phím P để điều khiển máy bay Plane4 bằng bàn phím 

##Yêu cầu thêm (trong quá trình phát triển Game):
+ [Ẩn trỏ chuột hiện tại](http://stackoverflow.com/questions/191592/how-do-i-get-rid-of-the-mouse-cursor-in-full-screen-exclusive-mode)
+ Sửa Class Plane thỏa mãn 2 điều kiện: 1 con máy bay điều khiển bởi chuột và 1 con máy bay điều khiển bởi bàn phím
+ Rà soát lại các thuộc tính và phương thức: chuyển lại quyền truy cập private và public phù hợp (với thuộc tính thì thêm get, set hợp lý)
+  Tạo Class Bullet và phương thức Move để di chuyển đạn cho các máy bay (tạm thời cho máy bay điều khiển bằng chuột hoặc điều khiển bằng bàn phím)
+ Lúc khởi tạo trong Class Window: mặc định sử dụng máy bay Plane4 bằng bàn phím. Sau đó, khi nhấn phím C hoặc phím P đẻ chuyển chế độ điều khiển máy bay (hiện tại: khi ta chuyển chế độ điều khiển chuột thì dùng máy bay Plane1 và điều khiển Bàn phím thì dùng Máy bay Plane4)
+ Sửa lại yêu cầu về bắn đạn và hiển thị máy bay: hiển thị đồng thời 2 máy bay (để 2 người chơi đồng thời), số lần bắn đạn phụ thuộc vào số lần nhấn B để bắn (với điều khiển máy bay bằng tay) hoặc số lần bắn phụ thuộc vào số lần nhấn Chuột
+ Tạo Class GameObject và dùng abstract cho class này (class này là class cha cho các class: PlaneAbstract class, Bullet class kế thừa)
+ Viết class PlaneAbstract (class này chỉ cho Class Plane và Class PlaneEnemy kế thừa và sử dụng)
+ Trong Class Plane, Class Bullet: chuyển chế độ public của phương thức khởi tạo thành private: mục đích để không cho người khác gọi được phương thức này => bắt buộc người khác phải theo cách khởi tạo của ta
 + Tạo 2 máy bay Enemy với 2 cách bắn: 1 loại máy bay đi đường eclip và bắn 2 viên 1 lần + 1 máy bay bay kiểu bình thường và bắn tóe ra 3 hướng
+ Đổi đạn cho Máy bay của bên ta
+ Cho hình máy bay nhỏ lại 
+ Cho 1 đàn máy bay bay dạng hình sin, mỗi 1 máy bay cứ sau 2 giây thì bắn (máy bay thứ 2 đợi máy bay thứ 1 bắn xong thì mới máy bay thứ 2 mới bắn đạn)

##Công cụ phát triển
+ Bộ công cụ IntelliJ IDEA version 15.0.3

##Tham khảo
+ [Xử lý sự kiện liên quan đến Mouse trong Ngôn ngữ Java](http://www.javafaq.nu/java-article716.html)
+ [Tham khảo quyền truy cập trong OOP với ngôn ngữ Java](https://www3.ntu.edu.sg/home/ehchua/programming/java/J3a_OOPBasics.html)
+ Tìm hiểu thêm về cách sử dụng và khai báo: Vector, ArrayList và LinkItem trong ngôn ngũ Java
+ [Xem lại phương trình Elip](https://vi.wikipedia.org/wiki/Elíp) hoặc [xem tại đây](https://toanhoc77.wordpress.com/2012/06/25/bai-3-phuong-trinh-duong-elip/)
+ [Tham khảo Hệ trục tọa độ](http://tusach.thuvienkhoahoc.com/wiki/H%C3%ACnh_h%E1%BB%8Dc_10/Ch%C6%B0%C6%A1ng_I/%C2%A74._H%E1%BB%87_tr%E1%BB%A5c_t%E1%BB%8Da_%C4%91%E1%BB%99)
+ [Tham khảo thuật toán vẽ các đường cơ bản](http://voer.edu.vn/m/gioi-thieu-cac-thuat-toan-ve-va-to-cac-duong-co-ban/6d58afd1)
+ [Tham khảo dùng sin cos với hình tròn, hình elip trong Toán](http://hmath360.blogspot.com/2013/07/su-dung-pt-tham-so-cua-uong-tron-elip.html)

+ Dùng MouseMotionListener để xử lý nhận sự kiện mouseMove và làm theo yêu cầu đề bài
```
//dung MouseMotionListener de move may bay theo tro chuot 
public class GameWindow extends Frame implements MouseMotionListener{
}
```

và đăng ký trong phương thức khởi tạo Contructor: GameWindow của Class GameWindow
```
this.addMouseMotionListener(this);
```

```
 @Override
    public void mouseMoved(MouseEvent e) {
        xPlane1 = e.getX();
        yPlane1 = e.getY();
    }
```

+ Dùng MouseListener để nhận các event khác của Chuột Mouse
```
//dung MouseListener de xu ly cac event khac cua Chuot(Mouse)
public class GameWindow extends Frame implements MouseListener{
}
```

và đăng ký trong phương thức khởi tạo Contructor: GameWindow của Class GameWindow
```
this.addMouseListener(this);
```

+ Phương thức ẩn trỏ chuột hiện tại
```
//dinh nghia phuong thuc an con tro chuot hien tai
    private void setCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point hotSpot = new Point(0,0);
        BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
        Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "InvisibleCursor");
        setCursor(invisibleCursor);
    }
```

và khai báo trong phương thức khởi tạo GameWindow của Class: GameWindow 
```
//an con tro hien tai
        this.setCursor();
```

+ Chú ý lấy được tọa độ đạn bullet4A, bullet4B lấy động theo tọa độ máy bay plane4
```
//trong phuong thuc khoi tao cua Class GameWindow, ta fix cung toa do khi may bay plane4 dung yen
plane4 = new Plane();
        //toa do Plane4 khi khoi tao dau tien
        plane4.setPostionX(200);
        plane4.setPostionY(300);
        plane4.setSpeed(3);
```

+ Khi phím B được nhấn thì ta lấy tọa độ của bullet4A và bullet4B theo tọa độ của máy bay plane4 
```
@Override
    public void keyPressed(KeyEvent e) { //khi nhan phim xuong thi kiem tra trang thai cua direction cua Plane4
        if(e.getKeyChar()=='w') //di chuyen len tren
                plane4.direction = 1;

        if(e.getKeyChar() == 's') //di chuyen xuong duoi
                plane4.direction = 2;

        if(e.getKeyChar() == 'd') //di chuyen sang phai
                plane4.direction = 3;

        if(e.getKeyChar() == 'a') //di chuyen sang trai
        {
            plane4.direction = 4;
        }

        if(e.getKeyChar() == 'b')
        {
            //khi nhan phim B thi xac dinh toa do cua dan Bullet4A theo toa do cua may bay plane4
            bullet4A.setPostionX(plane4.getPostionX());
            bullet4A.setPostionY(plane4.getPostionY());

            //khi nhan phim B thi xac dinh toa do cua dan Bullet4B theo toa do cua may bay plane4
            bullet4B.setPostionX(plane4.getPostionX() + 55);
            bullet4B.setPostionY(plane4.getPostionY());

            bullet4A.direction = 5;
            bullet4B.direction = 5;
        }
    }
```

+ Khi thuộc tính của class Bullet để private, ta muốn dùng get và set thì ta làm như sau:
```
public class Bullet {
    private int postionX;
    private int postionY;
    public int direction;
    public BufferedImage sprite;

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
```
