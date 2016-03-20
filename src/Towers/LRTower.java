
package Towers;

//~--- JDK imports ------------------------------------------------------------
import javax.swing.*;


public class LRTower extends Tower {

    public LRTower() {   
        
       // Refactor: Encapsulate Field refactor, change variable to this.get methods Yangyuqi Chang 
        this.setName("Long Range Tower");
        this.setRange(200);
        this.setDamage(10);
        this.setBackground("Images/lr_tower.png");
        this.width = new ImageIcon(this.getBackground()).getImage().getWidth(null);
        this.height = new ImageIcon(this.getBackground()).getImage().getHeight(null);
      
    }
}


