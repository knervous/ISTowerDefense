
package Towers;

import javax.swing.ImageIcon;

public class SRTower extends Tower {


    public SRTower() {
        
        /*
        OLIVE: Change each of these this.something to this.getRange() or this.getDamage()
        once you change the parent class
        */
        
        
        this.range = 100;
        this.damage = 15;
        background = "Images/sr_tower.png";
        this.width = new ImageIcon(background).getImage().getWidth(null);
        this.height = new ImageIcon(background).getImage().getHeight(null);
        this.name = "Short Range Tower";
        
        
    }


}
