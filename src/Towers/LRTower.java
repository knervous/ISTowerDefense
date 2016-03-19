
package Towers;

//~--- JDK imports ------------------------------------------------------------
import javax.swing.*;


public class LRTower extends Tower {

    public LRTower() {
        
        
       // Refactor: Encapsulate Field refactor, change variable to this.get methods Yangyuqi Chang 

        this.range = 300;
        this.damage = 10;
        background = "Images/lr_tower.png";
        this.width = new ImageIcon(background).getImage().getWidth(null);
        this.height = new ImageIcon(background).getImage().getHeight(null);
        this.name = "Long Range Tower";
    }

}


