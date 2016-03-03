/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Towers;

import Enemies.Enemy;
import istower.defense.v1.ObjectFrame;
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
 * @author yvc5283
 */

public class TowerPanel extends JPanel{
     private JLabel NameDisplay, RangeDisplay, DamageDisplay, CostDisplay;
     private JButton LRimage, MRimage, SRimage, Displayimage;
     private int Range, Damage, Cost;
     private String Name;
     private GridBagConstraints layoutConst = new GridBagConstraints();
     
    
     public void LRTower() {
         Name = "LRTower";
         Range = 300;
         Damage = 10;
         Cost = 200;
         LRimage = new JButton(new ImageIcon("Images/lr_tower.png"));
     }
     
      public void MRTower() {
         Name = "MRTower";
         Range = 200;
         Damage = 12;
         Cost = 200;
         MRimage = new JButton(new ImageIcon("Images/mr_tower.png"));
     }
      
       public void SRTower() {
         Name = "SRTower";
         Range = 100;
         Damage = 15;
         Cost = 200;
         SRimage = new JButton(new ImageIcon("Images/sr_tower.png"));
     }
     
     
     public void Display() {
  
        this.setLayout(new GridBagLayout());
        layoutConst.insets = new Insets(10, 10, 10, 10);
        ObjectFrame oF = new ObjectFrame(this);
        
        /*Displayimage = new JButton(new ImageIcon(Tower.background));
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        oF.add(DisplayImage, layoutConst);
       */ 
        NameDisplay = new JLabel("Name: " + Name);
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        oF.add(NameDisplay, layoutConst);

        DamageDisplay = new JLabel ("Damage: " + Damage);
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        oF.add(DamageDisplay, layoutConst);

        CostDisplay = new JLabel ("Cost: " + Cost);
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        oF.add(CostDisplay, layoutConst);       
 oF.setTitle("Enemy Info");
        oF.setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("Images/scroll.png").getImage(), 0, 0, super.getWidth(), super.getHeight(), null);
        
    }
}
