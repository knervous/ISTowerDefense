package Levels;

import Animations.*;
import Enemies.*;
import Towers.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import istower.defense.v1.*;

public abstract class Level extends JPanel implements MouseListener {

    /*
     I changed all the members here to private and used proper encapsulation in order to fit this into the MVC model
    
    
     Paul Johnson
    
    
     */
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Enemy> enemyGroup = new ArrayList<>();
    private ArrayList<Tower> towers = new ArrayList<>();
    private ArrayList<Projectile> projectiles = new ArrayList<>();
    private ArrayList<Thread> threads = new ArrayList<>();
    private ArrayList<Thread> allThreads = new ArrayList<>();
    private ArrayList<Rectangle> world = new ArrayList<>();
    private boolean isPaused = false;
    private boolean isBuilding = false;
    private double castleHealth;
    private Tower towerPH;
    private Graphics g2dObj;
    private PlayGame playGame;
    private final int XPADLEFT = 10;
    private final int XPADRIGHT = 10;
    private final int YPADBOTTOM = 15;
    private final int YPADTOP = 35;

    public Level() {
        super();
        setLayout(null);
        setSize((800 * (4 / 5)), 600);
        castleHealth = 200;
        setPathingPoints();
        this.addMouseListener(this);

    }

    public void drawObjects(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for (Tower tower : towers) {

            g2d.drawImage(new ImageIcon(tower.getBackground()).getImage(), tower.x, tower.y, tower.width, tower.height, null);

        }

        for (Enemy enemy : enemies) {

            if (!(enemy.getBackground().equals("Images/coin1.gif"))) {

                g2d.setColor(Color.black);
                g2d.fillRect(enemy.x + 2, enemy.y - 17, enemy.width - 10, 10);
                g2d.setColor(new Color((int) ((enemy.getHitpoints() / enemy.getMaxHP()) * 100) + 30, 0, 40));
                g2d.fillRect(enemy.x + 2, enemy.y - 17, (int) (((enemy.getHitpoints() / enemy.getMaxHP()) * (enemy.width - 10))), 10);

            }
            g2d.drawImage(new ImageIcon(enemy.getBackground()).getImage(), enemy.x, enemy.y, enemy.width, enemy.height, null);

        }

        for (Projectile projectile : projectiles) {
            g2d.drawImage(new ImageIcon(projectile.getBackground()).getImage(), projectile.x, projectile.y, projectile.width, projectile.height, null);

        }

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g2dObj = g.create();
        g.drawImage(new ImageIcon(getPath()).getImage(), 0, 0, super.getWidth(), super.getHeight(), null);
        drawWorld(g);
        drawObjects(g);
        startProjectile(g);
        
        /*
        Instead of having a huge paintComponent method, I split up each part of the drawing and passed along the graphics object
        This would be considered extract method according to Martin L. Fowler
        
        Paul Johnson
        */
    }

    private void drawWorld(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        for (Rectangle world1 : world) {
            g2d.drawImage(new ImageIcon(getGrass()).getImage(), world1.x, world1.y, world1.width,
                    world1.height, null);
        }
        if (this instanceof LevelOne) {
            g2d.drawImage(new ImageIcon("Images/castle3.png").getImage(), 432, 0, 200, 147, null);
        } else if (this instanceof LevelTwo) {
            g2d.drawImage(new ImageIcon("Images/castle4.png").getImage(), 380, 0, 200, 147, null);
        } else if (this instanceof LevelThree) {
            g2d.drawImage(new ImageIcon("Images/castle4.png").getImage(), 380, 0, 200, 147, null);
        }
        g2d.fillRect(432, 167, 140, 30);
        g2d.setColor(new Color(100, 20, 20));
        g2d.fillRect(436, 171, (int) ((castleHealth / 200) * 130), 22);

        g2d.setColor(Color.white);
        g2d.drawString("HEALTH: " + (int) castleHealth, 464, 186);

        g2d.dispose();
    }
    // This method (among others in this class that I can't remember) was originally
    // found in each of the child tower classes. It was moved to the parent and
    // reconfigured to apply to every instance of a tower. This fits with the Fowler's
    // move method refactoring suggestion along with DRY. - George

    public void startWaves() {
        threads.clear();
        createEnemies();
        enemies.addAll(enemyGroup);

        for (Enemy enemy : enemyGroup) {
            setStartingPoint();
            threads.add(new Thread(new EnemyAnimation(enemy, getPathingPoints(), this, new Point((getStartingPoint().x + enemyGroup.indexOf(enemy) * 50), getStartingPoint().y))));

            if ((threads.get(enemyGroup.indexOf(enemy)).getState() == Thread.State.NEW)) {
                threads.get(enemyGroup.indexOf(enemy)).start();
            } else {
                threads.add(new Thread(new EnemyAnimation(enemy, getPathingPoints(), this, new Point((getStartingPoint().x + enemyGroup.indexOf(enemy) * 50), getStartingPoint().y))));
                threads.get(enemyGroup.indexOf(enemy) + 1).start();
                break;
            }
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

    public void pauseGame() {

        try {
            for (Thread thread : allThreads) {
                if (!isPaused) {
                    thread.suspend();
                } else if (isPaused) {
                    thread.resume();
                }
                // use non-deprecated methods here if possible
            }
        } catch (Exception e) {
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
        } else if (enemyType == 3) {
            for (int i = 0; i < numEnemies; i++) {
                enemyGroup.add(new EnemyThree());
            }
        }

        /*
         Removed echo
         Paul Johnson
         */
    }

    public void buildTower(Tower infTower) {

        isBuilding = true;
        towerPH = infTower;

    }

    public void damageCastle(Enemy enemy) {
        castleHealth -= enemy.getDamage();
        if (castleHealth <= 0) {

            JOptionPane.showMessageDialog(this,
                    "Gameover.");
            playGame.dispose();
            System.exit(0);

        }
    }

    public void setIsPaused() {
        isPaused = !isPaused;
    }

    public boolean getIsPaused() {
        return isPaused;
    }

    public boolean getIsBuilding() {
        return isBuilding;
    }

    public ArrayList<Rectangle> getWorld() {
        return world;
    }

    public void setCastleHealth(int set) {
        castleHealth = set;
    }

    public ArrayList<Thread> getAllThread() {
        return allThreads;
    }

    public ArrayList<Enemy> getEnemyGroup() {
        return enemyGroup;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public double getCastleHealth() {
        return castleHealth;
    }

    public void setIsBuilding(boolean set) {
        isBuilding = set;
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        for (Enemy enemy : enemies) {
            if (enemy.contains(me.getPoint())) {
                //Refactor: jframe pops up  Yangyuqi Chang
                Component eFound = null;
                JOptionPane.showMessageDialog(eFound, "Enemy Found.");

                EnemyPanel eP = new EnemyPanel(enemy);

            }
        }

        for (Tower tower : towers) {
            if (tower.contains(me.getPoint())) {
                //Refactor: jframe pops up  Yangyuqi Chang
                Component tFound = null;
                JOptionPane.showMessageDialog(tFound, "Tower Found.");

                TowerPanel tP = new TowerPanel(tower);

            }
        }

        boolean isBuilt = false;
        /*
         Removed echo
         Paul Johnson
         */
        for (Rectangle worldPiece : world) {
            if (isBuilding && me.getX() >= worldPiece.getMinX() + XPADRIGHT
                    && me.getX() <= worldPiece.getMaxX() - XPADLEFT
                    && me.getY() >= worldPiece.getMinY() + YPADBOTTOM
                    && me.getY() <= worldPiece.getMaxY() - YPADTOP) {
                towers.add(towerPH);
                towers.get(towers.size() - 1).setLocation((int) (me.getX() - (towers.get(towers.size() - 1).width) * .5),
                        (int) (me.getY() - (towers.get(towers.size() - 1).height) * .666));
                isBuilt = true;
//                 Added equations here that take into account towers of different 
//                 sizes instead of using hardcoded values. This allows for expansion of the program
//                 as towers of different dimension could be created in the future
//                 and this method would factor in their proper map placement without
//                 needing magic numbers. Additionally, constants relating to enemy trail
//                 padding have been assigned meaningful constants. 
//                 Replace Magic Number with Symbolic Constant - George
            }
        }
        if (isBuilt) {
            isBuilding = false;

        }
        repaint();
    }

    public void setPlayGame(PlayGame infPlayGame) {
        playGame = infPlayGame;
    }

    /*
    
     All these abstract methods were implemented instead of having unique methods in every subclass. This helped OO and organization
    
     Paul Johnson
    
    
     */
    public abstract void setPathingPoints();

    public abstract ArrayList<Point> getPathingPoints();

    public abstract int getNumEnemies();

    public abstract int getEnemyType();

    public abstract String getGrass();

    public abstract String getPath();

    public abstract Point getStartingPoint();

    public abstract void setStartingPoint();

}


//~ Formatted by Jindent --- http://www.jindent.com
