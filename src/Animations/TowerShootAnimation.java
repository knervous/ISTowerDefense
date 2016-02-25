
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animations;

import Enemies.Enemy;
import Levels.Level;
import Towers.*;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author greg
 */
public class TowerShootAnimation implements Runnable {

    private int xdif = 0, ydif = 0;
    private Enemy enemy;
    private Projectile projectile;
    private Level parent;
    private Tower tower;
    

    public TowerShootAnimation(Projectile projectile, Enemy enemy, Level parent, Tower tower) {
        
        this.enemy = enemy;
        this.projectile = projectile;
        this.parent = parent;
        this.tower = tower;
    }

    @Override
    public void run() {

    }
}


//~ Formatted by Jindent --- http://www.jindent.com
