
package istower.defense.v1;

import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.event.KeyListener;

public class PlayGame extends JFrame {

    private static int frameWidth = 800;
    private static int frameHeight = 600;
    private static int frameLocationX = 200;
    private static int frameLocationY = 50;
    private JPanel content = new JPanel();

    public PlayGame() {
        super();
        setContentPane(content);
        
    }



    public JPanel getContentPanel()
    {
        return content;
    }
    

    public static int getFrameLocationX() {
        return frameLocationX;
    }


    public static int getFrameLocationY() {
        return frameLocationY;
    }


    public static int getFrameWidth() {
        return frameWidth;
    }

    public static int getFrameHeight() {
        return frameHeight;
    }

 
}
