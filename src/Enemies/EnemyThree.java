
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemies;

public class EnemyThree extends Enemy {

    public EnemyThree() {
        super();
        
        /*
        LUKE: Change each of these variables to getHitpoints() or getDamage()
        once you change the parent class
        
        ex. instead of hitpoints = 250;   it would be     getHitpoints() = 250;
        
        */
        
        
        hitpoints = 450;
        maxHP = 450;
        damage = 40;
        goldOnKill = 75;
        name = "Orc Raider";
        background = "Images/Orc_Raider.gif";
    }
    



}


//~ Formatted by Jindent --- http://www.jindent.com
