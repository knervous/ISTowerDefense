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
    
    
    
    public EnemyOne ()
    {
       super();
    }
    
    
    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(new ImageIcon("Images/monster1.png").getImage(), this.x, this.y, this.width, this.height, null);
        g2d.dispose();
    }
    
    
    
    
}
