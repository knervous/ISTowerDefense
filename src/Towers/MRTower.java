/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Towers;

import javax.swing.ImageIcon;


public class MRTower extends Tower {

    public MRTower() {
        
       // Refactor: Encapsulate Field refactor, change variable to this.get methods Yangyuqi Chang 

          this.range = 200;
          this.damage = 12;
          background = "Images/mr_tower.png";
          this.width = new ImageIcon(background).getImage().getWidth(null);
          this.height = new ImageIcon(background).getImage().getHeight(null);
          this.name = "Medium Range Tower";
        
        
    }

}
