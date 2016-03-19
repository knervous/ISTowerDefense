
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemies;

//~--- JDK imports ------------------------------------------------------------

/**
 *
 * @author Paul
 */
public class EnemyOne extends Enemy {

    public EnemyOne() {
        super();
        
        /*
        LUKE: Change each of these variables to getHitpoints() or getDamage()
        once you change the parent class
        
        ex. instead of hitpoints = 250;   it would be     getHitpoints() = 250;
        
        */
        
        hitpoints = 250;
        maxHP = 250.0;
        damage = 20;
        goldOnKill = 35;
        isAlive = true;
        name = "Orc Peon";
        background = "Images/Orc_Berserker.gif";
    }


    
}


//~ Formatted by Jindent --- http://www.jindent.com
