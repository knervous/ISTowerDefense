
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemies;

//~--- JDK imports ------------------------------------------------------------
import java.awt.*;

/**
 *
 * @author Paul
 */
public abstract class Enemy extends Rectangle {
    
    /*
    
    LUKE:
    
    Change these protected members to private,
    then create get and set methods for them.
    Document all these changes as "Encapsulate Field refactor"
    
    
    */
    
    protected double hitpoints;
    protected double maxHP;
    protected int damage;
    protected int goldOnKill;
    protected boolean isAlive;
    protected String background;
    protected String name;

    public Enemy() {
        super();
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
    
    public void setHP(int damage) {
        hitpoints = hitpoints - damage;
        if(hitpoints <= 0)
        {
            isAlive = false;
        }
    }
    
    public double getHitpoints() {
        return hitpoints;
    }
    
    public double getMaxHP()
    {
        return maxHP;
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public String getBackground()
    {
        return background;
    }
    
    public int getGoldOnKill()
    {
        return goldOnKill;
    }
    
    public void setBackground(String background)
    {
        this.background = background;
    }
    
    public String getName()
    {
        return name;
    }

    
    

    
}


//~ Formatted by Jindent --- http://www.jindent.com
