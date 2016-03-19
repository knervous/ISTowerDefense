
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemies;

public class EnemyTwo extends Enemy {

    public EnemyTwo() {
        super();
        
        /*
        LUKE: Change each of these variables to getHitpoints() or getDamage()
        once you change the parent class
        
        ex. instead of hitpoints = 250;   it would be     getHitpoints() = 250;
        
        */
        
        
        hitpoints = 350;
        maxHP = 350;
        damage = 30;
        goldOnKill = 50;
        name = "Orc Shaman";
        background = "Images/Orc_Marauder.gif";
    }
    



}


//~ Formatted by Jindent --- http://www.jindent.com
