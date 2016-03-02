/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemies;

import istower.defense.v1.ObjectFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author lmo5113
 */
public class EnemyPanel extends JPanel{
    private String enemyName; 
    
    private JLabel damage; 
    private JLabel goldOnKill; 
    private JLabel isAlive; 
    private JLabel maxHP; 
    private JLabel Hitpoints; 
    private JLabel backgorund; 
    
    private JButton Damage; 
    private JButton GoldOnKill; 
    private JButton Alive;
    private JButton MaximumHP;
    private JButton HitPoints; 
    private JButton Background; 
    
    
    public EnemyPanel(Enemy enemy){
    JPanel JPanel = null;
    ObjectFrame objectFrame = new ObjectFrame(JPanel);
    setSize(200, 600);
    enemy.damage();
    enemy.background();
    enemy.goldOnKill();
    enemy.isAlive();
    enemy.maxHP();
    enemy.hitpoints();
    }
    
    public void Display(JLabel Hitpoints) {
        
     Damage = new JButton("Damage: " + damage);
     GoldOnKill = new JButton("Gold on Kill: " + goldOnKill);
     Alive = new JButton ("Alive?: " + isAlive);
     MaximumHP = new JButton ("Maximum HP: " + maxHP);
     Hitpoints = new JLabel("Hit Points:" + Hitpoints);
    
    }
     
    
    
}



