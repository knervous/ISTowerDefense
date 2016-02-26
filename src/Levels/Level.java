
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

//~--- non-JDK imports --------------------------------------------------------
import Animations.*;
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
    private ArrayList<Projectile> projectiles = new ArrayList<>();
    private static ArrayList<Thread> threads = new ArrayList<>();
    private static ArrayList<Thread> allThreads = new ArrayList<>();
    private Point startingPoint = new Point(0, 250);
    protected ArrayList<Rectangle> world = new ArrayList<>();
    private static boolean isPaused = false;
    private double castleHealth = 200;

    public Level() {
        super();
        setLayout(null);
        setSize((800 * (4 / 5)), 600);
        setPathingPoints();
        createTowers();

    }

    public void drawObjects(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        
        
        for (Enemy enemy : enemies) {
            
            
            
            g2d.setColor(Color.black);
            g2d.fillRect(enemy.x+2, enemy.y-17, enemy.width-10, 10);
            g2d.setColor(new Color(100,20,20));
            g2d.fillRect(enemy.x+2, enemy.y-17, (int)(((enemy.getHP()/enemy.getMaxHP())*(enemy.width-10))), 10);
            g2d.drawImage(new ImageIcon(enemy.getBackground()).getImage(), enemy.x, enemy.y, enemy.width, enemy.height, null);
            
            
        }

        for (Tower tower : towers) {

            g2d.drawImage(new ImageIcon(tower.getBackground()).getImage(), tower.x, tower.y, tower.width, tower.height, null);

        }

        for (Projectile projectile : projectiles) {
            g2d.drawImage(new ImageIcon(projectile.getBackground()).getImage(), projectile.x, projectile.y, projectile.width, projectile.height, null);

        }

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(getPath()).getImage(), 0, 0, super.getWidth(), super.getHeight(), null);
        drawWorld(g);
        drawObjects(g);
        startProjectile(g);

    }

    private void drawWorld(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        for (Rectangle world1 : world) {
            g2d.drawImage(new ImageIcon(getGrass()).getImage(), world1.x, world1.y, world1.width,
                    world1.height, null);
        }
        
        g2d.drawImage(new ImageIcon("Images/castle3.png").getImage(), 432, 0, 200, 147, null);
        g2d.fillRect(432, 167, 140, 30);
        g2d.setColor(new Color(100,20,20));
        g2d.fillRect(436, 171, (int)((castleHealth/200)*130), 22);
        
        g2d.setColor(Color.white);
        g2d.drawString("HEALTH: "+(int)castleHealth, 464, 186);

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

        allThreads.addAll(threads);

    }

    private void startProjectile(Graphics g) {
        for (Enemy enemy : enemies) {
            for (Tower tower : towers) {

                if (tower.whenToFire(tower.getRange(), enemy, tower) && !tower.isFiring()) {

                    if ((enemies.indexOf(enemy) == (enemies.indexOf(enemies.size() - 1)))) {
                        break;
                    }
                    tower.setIsFiring(true);

                    projectiles.add(new Projectile(tower));
                    threads.add(new Thread(new TowerShootAnimation(projectiles.get(projectiles.size() - 1), enemy, tower, this)));
                    threads.get(threads.size() - 1).start();

                }
            }
        }
    }

    public static void pauseGame() {

        try {
            for (Thread thread : allThreads) {
                if (!isPaused) {
                    thread.suspend();
                } else if (isPaused) {
                    thread.resume();
                }
            }
        } catch (Exception e) {
        }
    }

    public void createTowers() {

        towers.add(new SRTower());

        towers.get(0).setLocation(350, 390);

        towers.add(new MRTower());

        towers.get(1).setLocation(350, 230);

        towers.add(new LRTower());

        towers.get(2).setLocation(520, 380);
        
        towers.add(new LRTower());

        towers.get(3).setLocation(520, 230);
        
        towers.add(new SRTower());

        towers.get(4).setLocation(150, 300);

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
    
    public void damageCastle(Enemy enemy)
    {
        castleHealth -= enemy.getDamage();
        if(castleHealth <= 0)
        {
            castleHealth = 200;
        }
    }

    public static void setIsPaused() {
        isPaused = !isPaused;
    }

    public static boolean getIsPaused() {
        return isPaused;
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
