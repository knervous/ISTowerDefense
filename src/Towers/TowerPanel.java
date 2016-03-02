/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Towers;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author yvc5283
 */
public class TowerPanel {
public class ObjectPanel extends JPanel{
     private JLabel NameDisplay, RangeDisplay, DamageDisplay, CostDisplay;
     private JButton LRimage, MRimage, SRimage;
     private int Range, Damage, Cost;
     private String Name;
     
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
     NameDisplay = new JLabel("Name: " + Name);
     RangeDisplay = new JLabel("Range: " + Range);
     DamageDisplay = new JLabel ("Damage: " + Damage);
     CostDisplay = new JLabel ("Cost: " + Cost);
}
}
}
