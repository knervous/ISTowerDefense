
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
        I have Change each of these variables to setHitpoints(250), setDamage(250.0) etc
        once I changed the parent class variables
       Luke Owen 
        */
        
        setHitpoints(250);
        setMaxHP(250.0);
        setDamage(20);
        setGoldOnKill(35);
        setIsAlive(true);
        setName("Orc Peon");
        setBackground("Images/Orc_Berserker.gif"); 
    }


    
}


//~ Formatted by Jindent --- http://www.jindent.com
