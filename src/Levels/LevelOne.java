
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

//~--- non-JDK imports --------------------------------------------------------
import Animations.*;
import java.util.Random;
import Enemies.*;

//~--- JDK imports ------------------------------------------------------------
import java.awt.*;
import java.awt.Color;

import java.util.ArrayList;

import javax.swing.*;

public class LevelOne extends Level {

    private int level=1;
    private ArrayList<Rectangle> world = new ArrayList<>();
    private ArrayList<Point> pathingPoints;

    
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

    

    public ArrayList<Point> getPathingPoints() {
        return pathingPoints;
    }
    
    public void setPathingPoints()
    {
        pathingPoints = new ArrayList<>();
        pathingPoints.add(new Point(300, 250));
        pathingPoints.add(new Point(300, 520));
        pathingPoints.add(new Point(575, 520));
        pathingPoints.add(new Point(575, 50));
    }

    @Override
    public int getNumEnemies() {
        return new Random().nextInt(3)+1;
    }

    @Override
    public int getEnemyType() {
        int rand = new Random().nextInt(8)+1;
        if(rand>2) return 1;
        else return 2;
    }

}


//~ Formatted by Jindent --- http://www.jindent.com
