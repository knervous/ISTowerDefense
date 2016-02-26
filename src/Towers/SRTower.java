/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Towers;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author greg
 */
public class SRTower extends Tower {


    public SRTower() {
        this.range = 100;
        this.damage = 15;
        background = "Images/sr_tower.png";
        this.width = new ImageIcon(background).getImage().getWidth(null);
        this.height = new ImageIcon(background).getImage().getHeight(null);
        
        
    }


}
