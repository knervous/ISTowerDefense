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
            pathingPoints.add(new Point(300,500));
            pathingPoints.add(new Point(575,500));
            pathingPoints.add(new Point(575,50));
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
        
            for (Point pathingPoint : pathingPoints) {
            
        
        xdif = pathingPoint.x - enemy.x;
        ydif = enemy.y - pathingPoint.y;

        while(Math.abs(xdif)>0 || Math.abs(ydif)>0)
        {
            xdif = pathingPoint.x - LevelOne.enemy.x;
            ydif = enemy.y - pathingPoint.y;
            if(xdif>0)
            enemy.setLocation(enemy.x + 1,enemy.y);
            else if(xdif<0)
                enemy.setLocation(enemy.x - 1,enemy.y);
            if(ydif>0)
            enemy.setLocation(enemy.x ,enemy.y - 1);
            else if(ydif<0)
                enemy.setLocation(enemy.x ,enemy.y + 1);
            
            System.out.println(enemy.x);
            try{
            Thread.sleep(12);
                    }
            catch(Exception e){} 
            repaint();
        }
        
        
        
            }
        
    }

        
    
}
