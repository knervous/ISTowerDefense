
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
    
    
    I Change these protected members to private,
    then I created get and set methods for each of them.
    I used the Encapsulate Field refactor
    * Luke Owen 
    
    
    */
    
    private double hitpoints;
    private double maxHP;
    private int damage;
    private int goldOnKill;
    private boolean isAlive;
    private String background;
    private String name;

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
        setHitpoints(getHitpoints() - damage);
        if(getHitpoints() <= 0)
        {
            setIsAlive(false);
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

    public void setHitpoints(double hitpoints) {
        this.hitpoints = hitpoints;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setGoldOnKill(int goldOnKill) {
        this.goldOnKill = goldOnKill;
    }
    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}


//~ Formatted by Jindent --- http://www.jindent.com
