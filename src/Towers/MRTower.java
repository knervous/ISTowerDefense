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

    private double range;
    private int damage;

    public MRTower() {
        this.range = 200;
        this.damage = 12;
        this.width = new ImageIcon("Images/mr_tower.png").getImage().getWidth(null);
        this.height = new ImageIcon("Images/mr_tower.png").getImage().getHeight(null);

        super.image = "Images/mr_tower.png";
    }

    public double getRange() {
        return range;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
