
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

import java.util.*;

import javax.swing.*;

public abstract class Level extends JPanel {
    protected EnemyOne enemy;

    public Level() {
        super();
        setLayout(null);
        setSize((800 * (4 / 5)), 600);
    }

    public abstract void setEnemyPH(EnemyOne infEnemy);

    public abstract ArrayList<Point> getPathingPoints();
}


//~ Formatted by Jindent --- http://www.jindent.com
