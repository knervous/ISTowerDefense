
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animations;

import Enemies.Enemy;
import Levels.Level;
import Towers.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author greg
 */
public class TowerShootAnimation implements Runnable {

    private double xscale = 0, yscale = 0;
    private double angle;
    private Enemy enemy;
    private Projectile projectile;
    private Level parent;
    private Tower tower;
    private ArrayList<Enemy> infEnemies;

    public TowerShootAnimation(Projectile projectile, Enemy enemy, Tower tower, Level parent) {

        this.enemy = enemy;
        this.projectile = projectile;
        this.parent = parent;
        this.tower = tower;
        this.infEnemies = infEnemies;
        projectile.setLocation((int) tower.getCenterX(), (int) tower.getCenterY() - 20);
    }

    @Override
    public void run() {

        try {

            Point p = new Point(projectile.x, projectile.y);

            while (enemy.getHP() >= 0 && tower.whenToFire(tower.getRange(), enemy, tower)) {

                angle = getAngle(new Point((int) tower.getCenterX(), (int) tower.getCenterY()), new Point((int) enemy.getCenterX(), (int) enemy.getCenterY()));
                yscale = Math.cos(Math.toRadians(angle));
                xscale = Math.sin(Math.toRadians(angle));
                p.setLocation(projectile.x + xscale * 2, projectile.y - yscale * 3.5);

                projectile.setLocation(p);

                Thread.sleep(15);

                if (projectile.getCenterX() - enemy.getCenterX() < 20 && projectile.getCenterY() - enemy.getCenterY() < 20) {
                    projectile.setLocation(1000, 1000);
                    enemy.setHP(tower.getDamage());
                    Thread.sleep(400);
                    projectile.setLocation((int) tower.getCenterX(), (int) tower.getCenterY() - 20);
                }

                if (projectile.getCenterX() > 600 || projectile.getCenterX() < 0 || projectile.getCenterY() > 600 || projectile.getCenterY() < 0) {
                    finishProjectile();
                    break;
                }

                parent.repaint();
            }
            projectile.setLocation(2000, 2000);

            finishProjectile();

        } catch (Exception e) {
        } catch (Throwable ex) {
        }
        // Are two catch statements necessary here?
    }

    public double getAngle(Point center, Point target) {
        double theta = Math.atan2(target.y - center.y, target.x - center.x);
        theta += Math.PI / 2.0;
        double angle = Math.toDegrees(theta);
        if (angle < 0) {
            angle += 360;
        }
        return angle;
    }

    public void finishProjectile() throws Throwable {
        tower.setIsFiring(false);
        this.finalize();
    }
    

}


//~ Formatted by Jindent --- http://www.jindent.com
