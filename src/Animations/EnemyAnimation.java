
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
    public EnemyOne enemy;
    private ArrayList<Point> pathingPoints;
    private Level parent;
    private String input;

    public EnemyAnimation(EnemyOne enemy, ArrayList<Point> pathingPoints, Level parent, String input) {
        this.enemy = enemy;
        enemy.setRect(0, 250, 50, 50);
        this.pathingPoints = pathingPoints;
        this.parent = parent;
        this.input = input;
        parent.addPH(enemy);

    }

    @Override
    public void run() {

        try {

            for (Point pathingPoint : pathingPoints) {
                xdif = pathingPoint.x - enemy.x;
                ydif = enemy.y - pathingPoint.y;
                System.out.println(this.input);

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
                    Thread.sleep(12);
                    parent.repaint();

                }
            }
        } catch (Exception e) {
        }

    }
}


//~ Formatted by Jindent --- http://www.jindent.com
