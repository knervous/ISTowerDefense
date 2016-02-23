/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animations;
import Enemies.*;
import java.awt.*;
import java.util.*;
import Levels.*;
import javax.swing.*;
/**
 *
 * @author greg
 */
public class EnemyAnimation extends JPanel implements Runnable{
    
    private EnemyOne rect;
    private ArrayList<Point> points;
    private int xdif;
    private int ydif;
    
    
    
    public EnemyAnimation(EnemyOne rect, ArrayList<Point> points)
    {
        this.rect = rect;
        this.points = points;
        xdif = 0;
        ydif = 0;
        
        int size = points.size();
    }

    @Override
    public void run() {
        
        xdif = points.get(0).x - LevelOne.enemy.x;
        ydif = LevelOne.enemy.y - points.get(0).y;
        
        
        System.out.println(xdif);
        while(xdif>5)
        {
            
            LevelOne.enemy.setLocation(LevelOne.enemy.x + 1,LevelOne.enemy.y);
            System.out.println(LevelOne.enemy.x);
            try{
            Thread.sleep(200);
                    }
            catch(Exception e){} 
            
        }
        
        
        
    }
    
    
    @Override
        public void paintComponent(Graphics g)
        {
            LevelOne.enemy.draw(g);
        }
    
}
