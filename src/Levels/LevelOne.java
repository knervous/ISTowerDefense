/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Enemies.*;
import Animations.*;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;


public class LevelOne extends Level implements Runnable{
    
        private int level,xdif=0,ydif=0;
        private ArrayList<Rectangle> world = new ArrayList<>();
        private ArrayList<Point> pathingPoints = new ArrayList<>();
        public static EnemyOne enemy;
        
        
        
        
        public LevelOne()
        {
            super();
            this.setBackground(Color.black);
            setLayout(null);
            initWorld();
            enemy = new EnemyOne();
            enemy.setRect(0,250,50,50);
            
            Thread thread = new Thread(this);
            thread.start();
            
        }
        
        private void initWorld() {
  
            world.add(new Rectangle(0,0,350,250)); // top left
            world.add(new Rectangle(0,300,300,300)); // bottom  left
            world.add(new Rectangle(350,0,225,510)); // top right
            pathingPoints.add(new Point(300,250));
            pathingPoints.add(new Point(300,550));
            pathingPoints.add(new Point(550,550));
            pathingPoints.add(new Point(550,50));
        }
        
        private void doDrawing(Graphics g) {        
        
        Graphics2D g2d = (Graphics2D) g.create();
        for (Rectangle world1 : world) 
            {
                 g2d.drawImage(new ImageIcon("Images/forestfloor.jpg").getImage(), world1.x,world1.y,world1.width,world1.height, null);
            }
        g2d.dispose();
        
        }
        
        
        @Override
        public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(new ImageIcon("Images/dirtpath2.jpg").getImage(), 0, 0, super.getWidth(), super.getHeight(), null);
        doDrawing(g);
        enemy.draw(g);
        
        
        }

    @Override
    public void run() {
        
        
        xdif = pathingPoints.get(0).x - LevelOne.enemy.x;
        ydif = LevelOne.enemy.y - pathingPoints.get(0).y;
        
        
        
        while(xdif>5)
        {
            xdif = pathingPoints.get(0).x - LevelOne.enemy.x;
            
            enemy.setLocation(LevelOne.enemy.x + 1,LevelOne.enemy.y);
            System.out.println(LevelOne.enemy.x);
            try{
            Thread.sleep(100);
                    }
            catch(Exception e){} 
            repaint();
        }
        
        xdif = pathingPoints.get(1).x - LevelOne.enemy.x;
        ydif = LevelOne.enemy.y - pathingPoints.get(1).y;
        
        
        
    }

        
    
}
