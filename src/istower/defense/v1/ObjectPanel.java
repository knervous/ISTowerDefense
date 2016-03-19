
package istower.defense.v1;

/**
 *
 * @author Paul
 */
import javax.swing.*;
public class ObjectPanel extends JPanel{
    private JButton objectPic;
    
    
    public ObjectPanel()
    {
        super();
    }
    public void addImage(String imgsrc){
     
        objectPic = new JButton(new ImageIcon(imgsrc));
        add(objectPic);
    }
    
}
