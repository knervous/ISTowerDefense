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
public class SRTower extends Tower{
    private double range;
    private int    damage;



    public SRTower() {
        this.range    = 50;
        this.damage   = 15;
        this.width = new ImageIcon("Images/sr_tower.png").getImage().getWidth(null);
        this.height= new ImageIcon("Images/sr_tower.png").getImage().getHeight(null);
        
        super.image = "Images/sr_tower.png";
    }
}
