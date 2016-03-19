
package Towers;

import javax.swing.ImageIcon;

public class SRTower extends Tower {


    public SRTower() {
        
  
        // Refactor: Encapsulate Field refactor, change variable to this.get methods Yangyuqi Chang 

        this.getRange();
        this.getDamage();
        this.getBackground();
        this.width = new ImageIcon(this.getBackground()).getImage().getWidth(null);
        this.height = new ImageIcon(this.getBackground()).getImage().getHeight(null);
        this.getName();
        
          }


}
