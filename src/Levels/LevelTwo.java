/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *
 * @author Paul
 */
public class LevelTwo extends Level{
    
        private int level;
        private ArrayList<Rectangle> world = new ArrayList<>();
        
        public LevelTwo()
        {
            super();
            this.setBackground(Color.black);
            setLayout(null);
            world.add(new Rectangle(0,0,350,250)); // top left
            world.add(new Rectangle(0,300,300,300)); // bottom  left
            world.add(new Rectangle(350,0,225,510)); // top right
            
                            
        }
        
        private void doDrawing(Graphics g) {        
        
        Graphics2D g2d = (Graphics2D) g.create();
        
        
        g2d.setPaint(Color.green);

            for (Rectangle world1 : world) {
                
                 g2d.fillRect(world1.x,world1.y,world1.width,world1.height);
            }

        g2d.dispose();
        }
        
        
        @Override
        public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
        //this.setBackground(Color.black);
        }
    
        
        private void initializeComponents()
        {
            level = 2;
        }
         
        public int getLevel()
        {
            return level;
        }
        
        
        
       

    
}
