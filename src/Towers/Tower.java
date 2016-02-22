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
public abstract class Tower {
    protected boolean shouldFire = false;
    
    public void whenToFire(double range, Rectangle enemy, Rectangle tower){
        double enemyDistance = Math.sqrt(Math.pow(enemy.getCenterX(), 2) + Math.pow(enemy.getCenterY(), 2));
        while(enemyDistance <= range){
            shouldFire = true;
            fire(enemy, tower);
        }
        shouldFire = false;
    }
    
    public abstract void fire(Rectangle enemy, Rectangle tower);
    
    public void pickTarget(){
        
    }
    
}
