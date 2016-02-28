# Game1945
+ Học xử lý đồ họa trong ngôn ngữ Java: di chuyển máy bay đơn giản
+ Di chuyển máy bay số 4 bằng bàn phím: w lên trên, a sang trái, d sang phải, s xuống dưới
+ Di chuyển máy bay số 1 bằng chuột (di chuyển chuột đến đâu thì máy bay di chuyển đến vị trí đó của chuột)
+ Bắn được đạn từ máy bay số 1 khi click Chuột (bắn được cả 2 bên cánh Máy bay số 1)
+ Bắn được đạn từ máy bay số 4 khi click Chuột (bắn được cả 2 bên cánh Máy bay số 4)

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