
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
    
    private int level,
            xdif = 0,
            ydif = 0;
    private ArrayList<Rectangle> world = new ArrayList<>();
    private ArrayList<Point> pathingPoints = new ArrayList<>();
    private ArrayList<Enemy> enemyGroup = new ArrayList<>();
    private ArrayList<Thread> threads = new ArrayList<>();
    private Point startingPoint = new Point(0,250);

    public Level() {
        super();
        setLayout(null);
        setSize((800 * (4 / 5)), 600);
        setPathingPoints();
        pathingPoints = getPathingPoints();
        
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
    
    
    public void startWaves() {
        threads.clear();
        createEnemies();
        enemies.addAll(enemyGroup);
        
        for (Enemy enemy : enemyGroup) {
            threads.add(new Thread(new EnemyAnimation(enemy, pathingPoints, this, new Point((startingPoint.x + enemyGroup.indexOf(enemy)*50),startingPoint.y))));
            threads.get(enemyGroup.indexOf(enemy)).start();

        }
        
    }

    public void createEnemies() {
        
        int numEnemies = getNumEnemies();
        int enemyType = getEnemyType();
        
        enemyGroup.clear();
        if (enemyType == 1) {
            for (int i = 0; i < numEnemies; i++) {
                enemyGroup.add(new EnemyOne());
            }
        } else if (enemyType == 2) {
            for (int i = 0; i < numEnemies; i++) {
                enemyGroup.add(new EnemyTwo());
            }
        }
        
        System.out.println("Enemy Type: "+enemyType);
        System.out.println("Num Enemies: "+numEnemies);
        
        

    }
    
    
    

    public abstract void setPathingPoints();
    public abstract ArrayList<Point> getPathingPoints();
    public abstract int getNumEnemies();
    public abstract int getEnemyType();
    
    //public abstract void addPH(EnemyOne infEnemy);
}


//~ Formatted by Jindent --- http://www.jindent.com
