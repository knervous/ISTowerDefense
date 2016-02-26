
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
        hitpoints = 250;
        maxHP = 250.0;
        damage = 20;
        goldOnKill = 35;
        isAlive = true;
        background = "Images/Orc_Berserker.gif";
    }


    
}


//~ Formatted by Jindent --- http://www.jindent.com
