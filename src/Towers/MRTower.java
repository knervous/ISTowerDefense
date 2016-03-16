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
public class MRTower extends Tower {

    public MRTower() {
        this.range = 200;
        this.damage = 12;
        background = "Images/mr_tower.png";
        this.width = new ImageIcon(background).getImage().getWidth(null);
        this.height = new ImageIcon(background).getImage().getHeight(null);
        this.name = "Medium Range Tower";
        
    }

}
