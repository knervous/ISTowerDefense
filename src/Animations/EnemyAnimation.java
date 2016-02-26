package Animations;

import Enemies.*;

import Levels.*;
import istower.defense.v1.OptionsPanel;
import java.awt.*;
import java.util.*;
import java.util.logging.Logger;

/**
 *
 * @author greg
 */
public class EnemyAnimation implements Runnable {

    private int xdif = 0,
            ydif = 0;
    public Enemy enemy;
    private ArrayList<Point> pathingPoints;
    private Level parent;
    private boolean gotGold = false;

    public EnemyAnimation(Enemy enemy, ArrayList<Point> pathingPoints, Level parent, Point start) {
        this.enemy = enemy;
        enemy.setLocation(start);
        this.pathingPoints = pathingPoints;
        this.parent = parent;

    }

    @Override
    public void run() {

        try {

            for (Point pathingPoint : pathingPoints) {
                xdif = pathingPoint.x - enemy.x;
                ydif = enemy.y - pathingPoint.y;

                while ((Math.abs(xdif) > 0) || (Math.abs(ydif) > 0)) {
                    if (!(enemy.getHP() > 0)) {
                        
                        killedEnemy();
                        break;
                    }
                    
                    xdif = pathingPoint.x - enemy.x;
                    ydif = enemy.y - pathingPoint.y;

                    if (xdif > 0) {
                        enemy.setLocation(enemy.x + 1, enemy.y);
                    } else if (xdif < 0) {
                        enemy.setLocation(enemy.x - 1, enemy.y);
                    }

                    if (ydif > 0) {
                        enemy.setLocation(enemy.x, enemy.y - 1);
                    } else if (ydif < 0) {
                        enemy.setLocation(enemy.x, enemy.y + 1);
                    }
                    Thread.sleep(25);
                    parent.repaint();

                }
                
                if(!gotGold && !(enemy.getHP() > 0))
                {
                    OptionsPanel.setGold(-1*enemy.getGoldOnKill());
                    gotGold = true;
                }
                
            }
            if(enemy.getHP() > 0)
            {
            parent.damageCastle(enemy);
            
            }
            enemy.setLocation(1000, 1000);
            
            this.finalize();

        } catch (Exception e) {

        } catch (Throwable ex) {

        }

    }

    public void killedEnemy() throws Throwable {
        enemy.setBackground("Images/coin1.gif");
        enemy.setRect(enemy.x-12.5, enemy.y-12.5, 75, 75);
        Thread.sleep(700);
        enemy.setLocation(1000, 1000);
        
        parent.repaint();
        this.finalize();
    }

    public void setPause() throws InterruptedException {
        this.wait();
        
    }

}


//~ Formatted by Jindent --- http://www.jindent.com
