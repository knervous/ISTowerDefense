
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Levels;

//~--- non-JDK imports --------------------------------------------------------

import Enemies.EnemyOne;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Paul
 */
public class LevelThree extends Level {
    private int level = 3;
    private ArrayList<Point> pathingPoints; 
    private Point startingPoint;
    private String grass;
    private String path;
    

    public LevelThree() {
        super();
        this.setBackground(Color.orange);
        setLayout(null);
        initWorld();
        path = "Images/lava.png";
        grass = "Images/lava_ground.jpg";
    }

    private void initializeComponents() {
        level = 3;
    }

    public int getLevel() {
        return level;
    }

    private void initWorld() {
      
        world.add(new Rectangle(0, 0, 350, 250));      // top left
        world.add(new Rectangle(0, 300, 300, 300));    // bottom  left
        world.add(new Rectangle(350, 0, 225, 510));    //top right 
    }

//    public void setBackground(Color orange) {
//        throw new UnsupportedOperationException("");  }
//
//    private void setLayout(Object object) {
//        throw new UnsupportedOperationException(""); }
 
    
    public ArrayList<Point> getPathingPoints(){
        return pathingPoints;
    }
    
    public void setPathingPoints(){
        pathingPoints = new ArrayList<>();
        pathingPoints.add(new Point(250, 100));
        pathingPoints.add(new Point(250, 520));
        pathingPoints.add(new Point(675, 400));
        pathingPoints.add(new Point(575, 20));
    }

    @Override
    public int getNumEnemies() {
        return new Random().nextInt(5) + 1;
    }

    @Override
    public int getEnemyType() {
        int rand = new Random().nextInt(8) + 1;
        if(rand >= 1 && rand <= 3)
        {
            return 1;
        }
        else if(rand >= 4 && rand <= 6)
        {
            return 2;
        }
        else
        {
            return 3;
        }
    }

    @Override
    public String getGrass() {
        return grass;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public Point getStartingPoint() {
        return startingPoint;
    }
    @Override
    public void setStartingPoint() {
        startingPoint = new Point(0, 250);
    }

}


//~ Formatted by Jindent --- http://www.jindent.com
