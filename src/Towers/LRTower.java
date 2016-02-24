
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Towers;

//~--- JDK imports ------------------------------------------------------------
import java.awt.*;

import java.util.*;

import javax.swing.*;
import javax.swing.*;
/**
 *
 * @author greg
 */
public class LRTower extends Tower {
    private final double range;
    private final int    damage;



    public LRTower() {
        this.range    = 100;
        this.damage   = 10;
        this.width = new ImageIcon("Images/lr_tower.png").getImage().getWidth(null);
        this.height= new ImageIcon("Images/lr_tower.png").getImage().getHeight(null);
        super.image = "Images/lr_tower.png";
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
