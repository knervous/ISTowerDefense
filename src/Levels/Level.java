
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

//~--- non-JDK imports --------------------------------------------------------
import Animations.EnemyAnimation;
import Enemies.*;
import Towers.*;
import istower.defense.v1.OptionsPanel;

//~--- JDK imports ------------------------------------------------------------
import java.awt.*;

import java.util.*;

import javax.swing.*;

public abstract class Level extends JPanel {

    protected ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Enemy> enemyGroup = new ArrayList<>();
    private ArrayList<Tower> towers = new ArrayList<>();
    private ArrayList<Thread> threads = new ArrayList<>();
    private Point startingPoint = new Point(0, 250);
    protected ArrayList<Rectangle> world = new ArrayList<>();


    public Level() {
        super();
        setLayout(null);
        setSize((800 * (4 / 5)), 600);
        setPathingPoints();
        createTowers();
        

    }


    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for (Enemy enemy : enemies) {
            if (enemy instanceof EnemyOne) {
                g2d.drawImage(new ImageIcon("Images/Orc_Berserker.gif").getImage(), enemy.x, enemy.y, enemy.width, enemy.height, null);
            } else if (enemy instanceof EnemyTwo) {
                g2d.drawImage(new ImageIcon("Images/Orc_Marauder.gif").getImage(), enemy.x, enemy.y, enemy.width, enemy.height, null);
            }
        }

        for (Tower tower : towers) {
            if (tower instanceof LRTower) {
                g2d.drawImage(new ImageIcon("Images/lr_tower.png").getImage(), tower.x, tower.y, tower.width, tower.height, null);
            } else if (tower instanceof MRTower) {
                g2d.drawImage(new ImageIcon("Images/mr_tower.png").getImage(), tower.x, tower.y, tower.width, tower.height, null);
            } else if (tower instanceof SRTower) {
                g2d.drawImage(new ImageIcon("Images/sr_tower.png").getImage(), tower.x, tower.y, tower.width, tower.height, null);
            }

        }

        g2d.dispose();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(getPath()).getImage(), 0, 0, super.getWidth(), super.getHeight(), null);
        doDrawing(g);
        draw(g);
        
        
        
        for(Enemy enemy : enemies)
        {
            for(Tower tower : towers)
            {

                if(tower.whenToFire(tower.getRange(),enemy,tower))
                
                {
                    System.out.println("IN RANGE");
                    
                }
            }
        }
    }
    
    
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        for (Rectangle world1 : world) {
            g2d.drawImage(new ImageIcon(getGrass()).getImage(), world1.x, world1.y, world1.width,
                    world1.height, null);
        }

        g2d.dispose();
    }

    public void startWaves() {
        threads.clear();
        createEnemies();
        enemies.addAll(enemyGroup);

        for (Enemy enemy : enemyGroup) {
            threads.add(new Thread(new EnemyAnimation(enemy, getPathingPoints(), this, new Point((startingPoint.x + enemyGroup.indexOf(enemy) * 50), startingPoint.y))));
            threads.get(enemyGroup.indexOf(enemy)).start();

        }

    }

    public void createTowers() {

        towers.add(new SRTower());
        
        
        towers.get(0).setLocation(350,350);
        //towers.add(new MRTower());

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

        System.out.println("Enemy Type: " + enemyType);
        System.out.println("Num Enemies: " + numEnemies);

    }

    public abstract void setPathingPoints();

    public abstract ArrayList<Point> getPathingPoints();

    public abstract int getNumEnemies();

    public abstract int getEnemyType();
    
    public abstract String getGrass();
    
    public abstract String getPath();

    //public abstract void addPH(EnemyOne infEnemy);
}


//~ Formatted by Jindent --- http://www.jindent.com
