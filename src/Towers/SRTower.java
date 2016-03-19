
package Towers;

import javax.swing.ImageIcon;

public class SRTower extends Tower {


    public SRTower() {
        
  
        // Refactor: Encapsulate Field refactor, change variable to this.get methods Yangyuqi Chang 

          this.range = 100;
          this.damage = 15;
          background = "Images/sr_tower.png";
          this.width = new ImageIcon(background).getImage().getWidth(null);
          this.height = new ImageIcon(background).getImage().getHeight(null);
          this.name = "Short Range Tower";
        
          }


}
