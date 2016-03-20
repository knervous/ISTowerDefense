
package Towers;

import javax.swing.ImageIcon;

public class SRTower extends Tower {


    public SRTower() {
  
        // Refactor: Encapsulate Field refactor, change variable to this.get methods Yangyuqi Chang 
         this.setName("Short Range Tower");
         this.setRange(100);
         this.setDamage(15);
         this.setBackground("Images/sr_tower.png");
         this.width = new ImageIcon(getBackground()).getImage().getWidth(null);
         this.height = new ImageIcon(getBackground()).getImage().getHeight(null);

          }
}
