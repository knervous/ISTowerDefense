
package Animations;
import Enemies.*;

import Levels.*;
import java.awt.*;
import java.util.*;

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


    public EnemyAnimation(Enemy enemy, ArrayList<Point> pathingPoints, Level parent, Point start) {
        this.enemy = enemy;
        enemy.setLocation(start);
        this.pathingPoints = pathingPoints;
        this.parent = parent;

    }

    @Override
    public void run() {

        try{
            for (Point pathingPoint : pathingPoints) {
                xdif = pathingPoint.x - enemy.x;
                ydif = enemy.y - pathingPoint.y;

                while ((Math.abs(xdif) > 0) || (Math.abs(ydif) > 0)) {
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
                
                
                
            }
        } catch (Exception e) {
        }

        enemy.setLocation(1000,1000);
    }
    
    
    public void killedEnemy()
    {
        
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
