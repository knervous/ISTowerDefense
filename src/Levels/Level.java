
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Levels;

//~--- non-JDK imports --------------------------------------------------------

import Animations.EnemyAnimation;
import Enemies.*;
import istower.defense.v1.OptionsPanel;

//~--- JDK imports ------------------------------------------------------------

import java.awt.*;

import java.util.*;

import javax.swing.*;

public abstract class Level extends JPanel {
    protected EnemyOne enemy;
    protected ArrayList<Enemy> enemies = new ArrayList<>();
    private OptionsPanel optionsPanel = new OptionsPanel();
    private JLabel waveDisplay;

    public Level() {
        super();
        setLayout(null);
        setSize((800 * (4 / 5)), 600);
    }
    public void displayWaves(){
        waveDisplay = new JLabel("Next Wave!!");
        waveDisplay.setBounds(300, 300, 10, 10);
        
        if (optionsPanel.getWaveTime() % 20 == 0){
            add(waveDisplay);
        }
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){}
        
//            remove(waveDisplay);
    }
    
    public void addPH(Enemy infEnemy)
    {
        enemies.add(infEnemy);
    }
    
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        for (Enemy enemy : enemies) {
            if (enemy instanceof EnemyOne) {
                g2d.drawImage(new ImageIcon("Images/monster1.png").getImage(), enemy.x, enemy.y, enemy.width, enemy.height, null);
            }
            else if(enemy instanceof EnemyTwo) {
                g2d.drawImage(new ImageIcon("Images/Orc_Berserker.gif").getImage(), enemy.x, enemy.y, enemy.width, enemy.height, null);
            }
        }
        g2d.dispose();
    }
    
    
    


    public abstract ArrayList<Point> getPathingPoints();
    public abstract void startWaves();
    //public abstract void addPH(EnemyOne infEnemy);
}


//~ Formatted by Jindent --- http://www.jindent.com
