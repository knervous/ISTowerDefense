/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemies;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.File;
import java.io.*;
import java.awt.Image;



/**
 *
 * @author Paul
 */
public class EnemyOne extends Enemy {
    
    private Rectangle base;
    
    public EnemyOne ()
    {

        base = new Rectangle(0,0,50,50);
  
    }
    
    
    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(new ImageIcon("Images/monster.png").getImage(), base.x, base.y, base.width, base.height, null);
    }
    
    
    public void setRect(int x, int y, int width, int height)
    {
        base.x = x;
        base.y = y;
        base.width = width;
        base.height = height;
    }
    
}
