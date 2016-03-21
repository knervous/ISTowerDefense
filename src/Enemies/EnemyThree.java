
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
        I Changed each of these variables to setHitpoints(450), setDamage(40) etc
        once I changed the parent class
        Luke Owen 
        */
        
        
        setHitpoints(450); 
        setMaxHP(450);
        setDamage(40);
        setGoldOnKill(75);
        setName("Orc Raider");
        setBackground("Images/Orc_Raider.gif");
    }
    



}


//~ Formatted by Jindent --- http://www.jindent.com
