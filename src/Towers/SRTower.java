/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Towers;

import java.awt.Rectangle;

/**
 *
 * @author greg
 */
public class SRTower extends Tower{
    private double range;
    private int    damage;
    private int    fireRate;
    private int    size;

    public SRTower(double range, int damage, int fireRate, int size) {
        this.range    = range;
        this.damage   = damage;
        this.fireRate = fireRate;
        this.size     = size;
        super.image = "Images/sr_tower.png";
    }
}
