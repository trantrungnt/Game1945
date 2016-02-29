# Game1945
+ Học xử lý đồ họa trong ngôn ngữ Java: di chuyển máy bay đơn giản
+ Di chuyển máy bay số 4 bằng bàn phím: w lên trên, a sang trái, d sang phải, s xuống dưới
+ Di chuyển máy bay số 1 bằng chuột (di chuyển chuột đến đâu thì máy bay di chuyển đến vị trí đó của chuột)
+ Bắn được đạn từ máy bay số 1 khi click Chuột (bắn được đạn cả 2 bên cánh Máy bay số 1)
+ Bắn được đạn từ máy bay số 4 khi nhấn phím B để bắn đạn (bắn được cả 2 bên cánh Máy bay số 4)

##Yêu cầu thêm (trong quá trình phát triển Game):
+ [Ẩn trỏ chuột hiện tại](http://stackoverflow.com/questions/191592/how-do-i-get-rid-of-the-mouse-cursor-in-full-screen-exclusive-mode)
+ Sửa Class Plane thỏa mãn 2 điều kiện: 1 con máy bay điều khiển bởi chuột và 1 con máy bay điều khiển bởi bàn phím
+ Rà soát lại các thuộc tính và phương thức: chuyển lại quyền truy cập private và protected phù hợp (với thuộc tính thì thêm get, set hợp lý)
+  Tạo Class Bullet và phương thức Move để di chuyển đạn cho các máy bay (tạm thời cho máy bay điều khiển bằng chuột hoặc điều khiển bằng bàn phím)

##Công cụ phát triển
+ Bộ công cụ IntelliJ IDEA version 15.0.3

##Tham khảo
+ [Xử lý sự kiện liên quan đến Mouse trong Ngôn ngữ Java](http://www.javafaq.nu/java-article716.html)

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

và khai báo trong Class: GameWindow 
```
//an con tro hien tai
        this.setCursor();
```
