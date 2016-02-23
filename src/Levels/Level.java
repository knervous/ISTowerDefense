/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;
import Enemies.*;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.GridLayout;


public abstract class Level extends JPanel{
    
    protected EnemyOne enemy;
    
    public Level()
    {
        super();
        setLayout(null);
        setSize((800*(4/5)),600);
    }
    
    
        
}
