
package Towers;

//~--- JDK imports ------------------------------------------------------------
import javax.swing.*;


public class LRTower extends Tower {

    public LRTower() {
        
        
        /*
        OLIVE: Change each of these this.something to this.getRange() or this.getDamage()
        once you change the parent class
        */
        
        
        this.range = 300;
        this.damage = 10;
        background = "Images/lr_tower.png";
        this.width = new ImageIcon(background).getImage().getWidth(null);
        this.height = new ImageIcon(background).getImage().getHeight(null);
        this.name = "Long Range Tower";
    }

}


