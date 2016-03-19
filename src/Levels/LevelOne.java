
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

//~--- non-JDK imports --------------------------------------------------------
import java.util.Random;

//~--- JDK imports ------------------------------------------------------------
import java.awt.*;
import java.awt.Color;

import java.util.ArrayList;

public class LevelOne extends Level {

    /*
    Removing crunk
    
    Paul Johnson
    */
    private ArrayList<Point> pathingPoints;
    private Point startingPoint;
    private String grass;
    private String path;

    public LevelOne() {
        super();
        this.setBackground(Color.black);
        setLayout(null);
        path = "Images/dirtpath2.jpg";
        grass = "Images/forestfloor.jpg";
        initWorld();
    }

    private void initWorld() {
        /*
        Encapsulated fields by changing protected to private and using accessor methods instead of accessing parent members
        
        Paul Johnson
        */
        
        getWorld().add(new Rectangle(0, 0, 350, 250));      // top left
        getWorld().add(new Rectangle(0, 300, 300, 300));    // bottom  left
        getWorld().add(new Rectangle(350, 0, 225, 510));    // top right

    }

    public ArrayList<Point> getPathingPoints() {
        return pathingPoints;
    }

    public void setPathingPoints() {
        pathingPoints = new ArrayList<>();
        pathingPoints.add(new Point(300, 250));
        pathingPoints.add(new Point(300, 520));
        pathingPoints.add(new Point(575, 520));
        pathingPoints.add(new Point(575, 90));
    }

    @Override
    public int getNumEnemies() {
        return new Random().nextInt(4) + 1;
    }

    @Override
    public int getEnemyType() {
        int rand = new Random().nextInt(8) + 1;
        if (rand > 3) {
            return 1;
        } else {
            return 2;
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
