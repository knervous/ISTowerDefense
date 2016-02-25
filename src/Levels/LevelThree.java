
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

/**
 *
 * @author Paul
 */
public abstract class LevelThree extends Level {
    private int level = 3;
    private ArrayList<Point> pathingPoints; 
    private String grass;
    private String path;
    

    public LevelThree() {
        super();
        this.setBackground(Color.blue);
        setLayout(null);
        initWorld();
        path = "Images/dirtpath2.jpg";
        grass = "Images/forestfloor.jpg";
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

    public void setBackground(Color blue) {
        throw new UnsupportedOperationException("");  }

    private void setLayout(Object object) {
        throw new UnsupportedOperationException(""); }
 
    private  ArrayList<Rectangle> world = new ArrayList<>();
        
    
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
        return 3;
    }

    @Override
    public int getEnemyType() {
        return 2;
    }

    @Override
    public String getGrass() {
        return grass;
    }

    @Override
    public String getPath() {
        return path;
    }
    
    


}


//~ Formatted by Jindent --- http://www.jindent.com
