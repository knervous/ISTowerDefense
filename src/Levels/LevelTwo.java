
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

//~--- non-JDK imports --------------------------------------------------------
import Enemies.*;

//~--- JDK imports ------------------------------------------------------------
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

import java.util.*;

import javax.swing.*;

/**
 *
 *
 */
public class LevelTwo extends Level {

    private int level = 2;
    private ArrayList<Point> pathingPoints;
    private String grass;
    private String path;

    public LevelTwo() {
        super();
        this.setBackground(Color.white);
        setLayout(null);
        path = "Images/snow.jpg";
        grass = "Images/snow_mountain.jpg";
        initWorld();
    }

    private void initWorld() {
        world.add(new Rectangle(0, 0, 350, 250));      // top left
        world.add(new Rectangle(0, 300, 300, 300));    // bottom  left
        world.add(new Rectangle(350, 0, 225, 510));    // top right

    }

    public int getLevel() {
        return level;
    }

    @Override
    public void setPathingPoints() {
        pathingPoints = new ArrayList<>();
    }

    @Override
    public ArrayList<Point> getPathingPoints() {
        return pathingPoints;
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

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


//~ Formatted by Jindent --- http://www.jindent.com
