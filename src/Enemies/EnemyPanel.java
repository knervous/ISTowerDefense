/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemies;

import istower.defense.v1.ObjectFrame;
import static istower.defense.v1.OptionsPanel.gold;
import java.awt.Graphics;
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
    private JLabel name;
    private GridBagConstraints layoutConst = new GridBagConstraints();
    
    public EnemyPanel(Enemy enemy){
        this.setLayout(new GridBagLayout());
        layoutConst.insets = new Insets(10, 10, 10, 10);
        ObjectFrame oF = new ObjectFrame(this);
        
        EnemyImage = new JButton(new ImageIcon(enemy.background));
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        oF.add(EnemyImage, layoutConst);
        
        name = new JLabel("Name: "+enemy.name);
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        oF.add(name, layoutConst);

        Damage = new JLabel("Damage: " + enemy.damage);
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        oF.add(Damage, layoutConst);

        GoldOnKill = new JLabel("Gold on Kill: " + enemy.goldOnKill);
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        oF.add(GoldOnKill, layoutConst);

        isLiving = new JLabel("Alive?: " + enemy.isAlive);
        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        oF.add(isLiving, layoutConst);

        MaxHP = new JLabel("Maximum HP: " + enemy.maxHP);
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        oF.add(MaxHP, layoutConst);

        Hitpoints = new JLabel("Hit Points:" + enemy.hitpoints);
        layoutConst.gridx = 0;
        layoutConst.gridy = 6;
        oF.add(Hitpoints, layoutConst);

        oF.setTitle("Enemy Info");
        oF.setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("Images/scroll.png").getImage(), 0, 0, super.getWidth(), super.getHeight(), null);
        
    }
}



