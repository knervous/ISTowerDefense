
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
public abstract class Tower extends Rectangle {

    protected String background;
    protected double range;
    protected int damage;

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

    public boolean whenToFire(double range, Rectangle enemy, Rectangle tower) {

        double xdistance = enemy.getCenterX() - tower.getCenterX();
        double ydistance = enemy.getCenterY() - tower.getCenterY();
        double enemyDistance = Math.sqrt(Math.pow(xdistance, 2) + Math.pow(ydistance, 2));

        while (enemyDistance <= range) {
            return true;
        }

        return false;
    }

    public String getBackground() {
        return background;
    }

    public double getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }

}


//~ Formatted by Jindent --- http://www.jindent.com
