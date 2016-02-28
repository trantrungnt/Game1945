import java.util.Scanner;

/**
 * Created by TrungNT on 2/27/2016.
 */
public class Main {
    public static void main(String[] args)
    {
        GameWindow oGameWindow = new GameWindow();
        Thread thread = new Thread(oGameWindow);
        thread.start();
    }
}
