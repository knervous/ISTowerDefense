
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Towers;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author greg
 */
public abstract class Tower extends Rectangle{
    protected boolean shouldFire = false; 
    protected String image;
    
    public Tower() {
        this.x = 0;
        this.y = 0;
        this.width = 50;
        this.height = 50;
    }

    public void setRect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(new ImageIcon(image).getImage(), this.x, this.y, this.width, this.height, null);
        g2d.dispose();
        
    }
    public void whenToFire(double range, Rectangle enemy, Rectangle tower) {
        double enemyDistance = Math.sqrt(Math.pow(enemy.getCenterX(), 2) + Math.pow(enemy.getCenterY(), 2));

        while (enemyDistance <= range) {
            shouldFire = true;
            fire(enemy, tower);
        }

        shouldFire = false;
    }

    public void fire(Rectangle enemy, Rectangle tower) {
            while (shouldFire = true) {
        }
    }
    public void pickTarget() {}
}


//~ Formatted by Jindent --- http://www.jindent.com
