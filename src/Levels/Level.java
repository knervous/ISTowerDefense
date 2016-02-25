
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
    private String grass;
    private String path;


    public Level() {
        super();
        setLayout(null);
        setSize((800 * (4 / 5)), 600);
        setPathingPoints();
        createTowers();
        path = "Images/dirtpath2.jpg";
        grass = "Images/forestfloor.jpg";

    }

    public void addPH(Enemy infEnemy) {
        enemies.add(infEnemy);
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
                g2d.drawImage(new ImageIcon("Images/lr_tower.png").getImage(), 0, 200, tower.width, tower.height, null);
            } else if (tower instanceof MRTower) {
                g2d.drawImage(new ImageIcon("Images/mr_tower.png").getImage(), 250, 250, tower.width, tower.height, null);
            } else if (tower instanceof SRTower) {
                g2d.drawImage(new ImageIcon("Images/sr_tower.png").getImage(), 350, 350, tower.width, tower.height, null);
            }

        }

        g2d.dispose();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(path).getImage(), 0, 0, super.getWidth(), super.getHeight(), null);
        doDrawing(g);
        draw(g);
    }
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        for (Rectangle world1 : world) {
            g2d.drawImage(new ImageIcon(grass).getImage(), world1.x, world1.y, world1.width,
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
        towers.add(new SRTower());
        towers.add(new LRTower());
        towers.add(new MRTower());

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

    //public abstract void addPH(EnemyOne infEnemy);
}


//~ Formatted by Jindent --- http://www.jindent.com
