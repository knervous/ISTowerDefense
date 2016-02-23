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
import Enemies.*;

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
            EnemyOne enemy = new EnemyOne();
            
            add(enemy);
            //enemy.setBounds(null);
            world.add(new Rectangle(0,0,350,250)); // top left
            world.add(new Rectangle(0,300,300,300)); // bottom  left
            world.add(new Rectangle(350,0,225,510)); // top right
            
                            
        }
        
        private void doDrawing(Graphics g) {        
        
        Graphics2D g2d = (Graphics2D) g.create();
        
        
        g2d.setPaint(Color.green);

            for (Rectangle world1 : world) {

                 g2d.drawImage(new ImageIcon("Images/forestfloor.jpg").getImage(), world1.x,world1.y,world1.width,world1.height, null);
            }

        g2d.dispose();
        }
        
        
        @Override
        public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(new ImageIcon("Images/dirtpath2.jpg").getImage(), 0, 0, super.getWidth(), super.getHeight(), null);
        doDrawing(g);
        
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
