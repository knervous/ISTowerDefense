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
public class EnemyOne extends Enemy{
    
    private Rectangle base;
    
    public EnemyOne()
    {
        super();
        setSize(50,50);
        base = new Rectangle(0,0,50,50);
        BufferedImage img = null;
        try {
        img = ImageIO.read(new File("Images/monster.png"));
        } catch (IOException e) {
        }
        
        
        
        Graphics2D g2 = img.createGraphics();
        //g2.fill(new Rectangle(1,2,50,50));
        g2.drawImage(img, base.x, base.y, null);
        g2.dispose();
        
        
    }
    
    
    /*
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("Images/monster.png").getImage(), 0, 0, super.getWidth(), super.getHeight(), null);
    }
    
    */
    
}
