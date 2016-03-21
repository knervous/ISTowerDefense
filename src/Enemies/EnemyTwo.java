
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
        I Changed each of these variables to setHitpoints(350), setDamage(30)
        once I changed the parent class
        Luke Owen 
        */
        
        
        setHitpoints(350);
        setMaxHP(350);
        setDamage(30);
        setGoldOnKill(50);
        setName("Orc Shaman");
        setBackground("Images/Orc_Marauder.gif");
    }
    



}


//~ Formatted by Jindent --- http://www.jindent.com
