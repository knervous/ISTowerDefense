
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

import java.util.ArrayList;

/**
 *
 * @author Paul
 */
public class LevelThree extends Level {
    private int level;

    public LevelThree() {
        super();
        this.setBackground(Color.gray);
    }

    private void initializeComponents() {
        level = 3;
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
