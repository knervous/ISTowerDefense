
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

//~--- non-JDK imports --------------------------------------------------------
import Animations.*;

import Enemies.*;

//~--- JDK imports ------------------------------------------------------------
import java.awt.*;
import java.awt.Color;

import java.util.ArrayList;

import javax.swing.*;

public class LevelOne extends Level {

    private int level,
            xdif = 0,
            ydif = 0;
    private ArrayList<Rectangle> world = new ArrayList<>();
    private ArrayList<Point> pathingPoints = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Enemy> enemyGroup = new ArrayList<>();
    private ArrayList<Thread> threads = new ArrayList<>();
    private Point startingPoint = new Point(0,250);
    
    public LevelOne() {
        super();
        this.setBackground(Color.black);
        setLayout(null);
        initWorld();
    }

    private void initWorld() {
        world.add(new Rectangle(0, 0, 350, 250));      // top left
        world.add(new Rectangle(0, 300, 300, 300));    // bottom  left
        world.add(new Rectangle(350, 0, 225, 510));    // top right
        pathingPoints.add(new Point(300, 250));
        pathingPoints.add(new Point(300, 520));
        pathingPoints.add(new Point(575, 520));
        pathingPoints.add(new Point(575, 50));
        //startWaves();
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        for (Rectangle world1 : world) {
            g2d.drawImage(new ImageIcon("Images/forestfloor.jpg").getImage(), world1.x, world1.y, world1.width,
                    world1.height, null);
        }

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("Images/dirtpath2.jpg").getImage(), 0, 0, super.getWidth(), super.getHeight(), null);
        doDrawing(g);
        super.draw(g);
    }

    public void startWaves() {
        threads.clear();
        createEnemies(3,1);
        enemies.addAll(enemyGroup);
        
        
        for (Enemy enemy : enemyGroup) {
            threads.add(new Thread(new EnemyAnimation(enemy, pathingPoints, this, new Point((startingPoint.x + enemyGroup.indexOf(enemy)*50),startingPoint.y))));
            threads.get(enemyGroup.indexOf(enemy)).start();

        }
        
    }

    public void createEnemies(int numEnemies, int enemyType) {
        
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
        
        

    }

    public ArrayList<Point> getPathingPoints() {
        return pathingPoints;
    }

}


//~ Formatted by Jindent --- http://www.jindent.com
