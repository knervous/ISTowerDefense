
package Towers;

//~--- JDK imports ------------------------------------------------------------
import javax.swing.*;


public class LRTower extends Tower {

    public LRTower() {   
        
       // Refactor: Encapsulate Field refactor, change variable to this.get methods Yangyuqi Chang 
        this.setTower("Long Range Tower", 200, 10,"Images/lr_tower.png" );
        this.width = new ImageIcon(this.getBackground()).getImage().getWidth(null);
        this.height = new ImageIcon(this.getBackground()).getImage().getHeight(null);
      
    }
}


