
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
    private int                  level,
                                 xdif          = 0,
                                 ydif          = 0;
    private ArrayList<Rectangle> world         = new ArrayList<>();
    private ArrayList<Point>     pathingPoints = new ArrayList<>();
    private EnemyOne             enemyPH       = new EnemyOne();

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
        pathingPoints.add(new Point(300, 500));
        pathingPoints.add(new Point(575, 500));
        pathingPoints.add(new Point(575, 50));
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
        enemyPH.draw(g);
    }
    
    @Override
    public void update(Graphics g){
           paint(g);
    }
    
    public void setEnemyPH(EnemyOne infEnemy) {
        enemyPH = infEnemy;
    }

    public ArrayList<Point> getPathingPoints() {
        return pathingPoints;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
