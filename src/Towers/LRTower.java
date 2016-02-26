
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Towers;

//~--- JDK imports ------------------------------------------------------------
import javax.swing.*;

/**
 *
 * @author greg
 */
public class LRTower extends Tower {

    public LRTower() {
        this.range = 300;
        this.damage = 10;
        background = "Images/lr_tower.png";
        this.width = new ImageIcon(background).getImage().getWidth(null);
        this.height = new ImageIcon(background).getImage().getHeight(null);

    }

}


//~ Formatted by Jindent --- http://www.jindent.com
