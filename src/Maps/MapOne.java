/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author lmo5113
 */
public class MapOne extends Maps {
    private String firstMap;
    
        private final ArrayList<Rectangle> world = new ArrayList<>();
        private final ArrayList<Point> pathingPoints = new ArrayList<>();

        
public MapOne() {
        super();
        this.setBackground(Color.red);
        setLayout(null);
        initWorld();
    }

    private void setBackground(Color red) {
        throw new UnsupportedOperationException(""); 
    }

    private void setLayout(Object object) {
        throw new UnsupportedOperationException(""); 
    }

    private void initWorld() {
        
        world.add(new Rectangle(0, 0, 350, 250));      // top left
        world.add(new Rectangle(0, 300, 300, 300));    // bottom  left
        world.add(new Rectangle(350, 0, 225, 510));    // top right
        pathingPoints.add(new Point(300, 250));
        pathingPoints.add(new Point(300, 520));
        pathingPoints.add(new Point(575, 520));
        pathingPoints.add(new Point(575, 50));
    }
    
}