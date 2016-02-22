/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;


/**
 *
 * @author Paul
 */
public class LevelOne extends Level{
    
        private int level;
        
        public LevelOne()
        {
            this.setBackground(Color.black);
            add(new Surface());
            
            
        }
        
        private void initializeComponents()
        {
            level = 1;
        }
         
        public int getLevel()
        {
            return level;
        }
        
        
        class Surface extends JPanel {    
    
    private void doDrawing(Graphics g) {        
        
        Graphics2D g2d = (Graphics2D) g.create();
        
        
        g2d.setPaint(Color.green);

        for (int i = 1; i <= 10; i++) {
            
            float alpha = i * 0.02f;
            AlphaComposite alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(alcom);
            g2d.fillOval(50 * i, 20, 40, 40);
        }        
        
        g2d.dispose();
    }
        
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
        //this.setBackground(Color.black);
        }
    }
        
    
    
}
