
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

import java.util.*;

import javax.swing.*;

/**
 *
 * @author Paul
 */
public class LevelTwo extends Level {
    private int level;

    public LevelTwo() {}

    private void initializeComponents() {
        level = 2;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public void setEnemyPH(EnemyOne infEnemy) {
        throw new UnsupportedOperationException("Not supported yet.");    // To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Point> getPathingPoints() {
        throw new UnsupportedOperationException("Not supported yet.");    // To change body of generated methods, choose Tools | Templates.
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
