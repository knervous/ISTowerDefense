
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Animations;

//~--- non-JDK imports --------------------------------------------------------

import Enemies.*;

import Levels.*;

//~--- JDK imports ------------------------------------------------------------

import java.awt.*;

import java.util.*;

/**
 *
 * @author greg
 */
public class EnemyAnimation implements Runnable {
    private int              xdif = 0,
                             ydif = 0;
    public EnemyOne          enemy;
    private ArrayList<Point> pathingPoints;
    private Level            parent;

    public EnemyAnimation(EnemyOne enemy, ArrayList<Point> pathingPoints, Level parent) {
        this.enemy = enemy;
        enemy.setRect(0, 250, 50, 50);
        this.pathingPoints = pathingPoints;
        this.parent        = parent;
    }

    @Override
    public void run() {
        synchronized (parent) {
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


                    try {
                        Thread.sleep(12);
                    } catch (Exception e) {}

                    parent.setEnemyPH(enemy);
                    parent.repaint();
                }
            }
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
