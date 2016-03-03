/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemies;

import istower.defense.v1.ObjectFrame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author lmo5113
 */
public class EnemyPanel extends JPanel{
    private JButton EnemyImage;
    private JLabel Damage; 
    private JLabel GoldOnKill; 
    private JLabel isLiving; 
    private JLabel MaxHP; 
    private JLabel Hitpoints; 
    private GridBagConstraints layoutConst = new GridBagConstraints();
    
    public EnemyPanel(Enemy enemy){
        this.setLayout(new GridBagLayout());
        layoutConst.insets = new Insets(10, 10, 10, 10);
        ObjectFrame oF = new ObjectFrame(this);
        
        EnemyImage = new JButton(new ImageIcon(enemy.background));
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        oF.add(EnemyImage, layoutConst);

        Damage = new JLabel("Damage: " + enemy.damage);
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        oF.add(Damage, layoutConst);

        GoldOnKill = new JLabel("Gold on Kill: " + enemy.goldOnKill);
        oF.add(GoldOnKill);
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        oF.add(GoldOnKill, layoutConst);

        isLiving = new JLabel("Alive?: " + enemy.isAlive);
        oF.add(isLiving);
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        oF.add(isLiving, layoutConst);

        MaxHP = new JLabel("Maximum HP: " + enemy.maxHP);
        oF.add(MaxHP);
        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        oF.add(MaxHP, layoutConst);

        Hitpoints = new JLabel("Hit Points:" + enemy.hitpoints);
        oF.add(Hitpoints);
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        oF.add(Hitpoints, layoutConst);

        oF.setTitle("Enemy Info");
        oF.setVisible(true);
    }
}



