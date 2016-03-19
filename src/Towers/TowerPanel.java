/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Towers;
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
     private JButton  Displayimage;
     private int Cost = 200;
     private GridBagConstraints layoutConst = new GridBagConstraints();

    public TowerPanel(Tower tower) {
        this.setLayout(new GridBagLayout());
        layoutConst.insets = new Insets(10, 10, 10, 10);
        ObjectFrame oF = new ObjectFrame(this);
        
        
       
        //Refactoring: Encapsulate Field refactor, Yangyuqi Chang
        
        
        Displayimage = new JButton(new ImageIcon(tower.getBackground()));
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        oF.add(Displayimage, layoutConst);
       
        NameDisplay = new JLabel("Name: " + tower.getName());
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        oF.add(NameDisplay, layoutConst);
        
        RangeDisplay = new JLabel ("Range: " + tower.getRange());
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        oF.add(RangeDisplay, layoutConst);

        DamageDisplay = new JLabel ("Damage: " + tower.getDamage());
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        oF.add(DamageDisplay, layoutConst);

        CostDisplay = new JLabel ("Cost: " + Cost);
        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        oF.add(CostDisplay, layoutConst);       
        
        oF.setTitle("Tower Info");
        oF.setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("Images/scroll.png").getImage(), 0, 0, super.getWidth(), super.getHeight(), null);
        
    }
}
