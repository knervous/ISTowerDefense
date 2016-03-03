
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Levels;

//~--- non-JDK imports --------------------------------------------------------

import Enemies.EnemyOne;
import istower.defense.v1.ISTowerDefenseV1;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Random;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

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
        
        try {
            LevelTwo.seqTwo.stop();
            InputStream is;
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            is = new BufferedInputStream(new FileInputStream(new File("src/Necrophagist_-_Seven.mid")));
            sequencer.setSequence(is);
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            is.close();
        } catch (Exception e) {
        }
        
    }

    private void initializeComponents() {
        level = 3;
    }

    public int getLevel() {
        return level;
    }

    private void initWorld() {
      
        world.add(new Rectangle(0, 50, 200, 200));      // top left
        world.add(new Rectangle(50, 300, 250, 220));    // bottom  left
        world.add(new Rectangle(350, 50, 225, 235));    //top right
        world.add(new Rectangle(350, 285, 225, 235));    //top right
        world.add(new Rectangle(515, 0, 250, 50));
        world.add(new Rectangle(560, 0, 125, 50));
        world.add(new Rectangle(250, 50, 100, 100));     // top middle
        world.add(new Rectangle(250, 150, 100, 100));
    }

//    public void setBackground(Color orange) {
//        throw new UnsupportedOperationException("");  }
//
//    private void setLayout(Object object) {
//        throw new UnsupportedOperationException(""); }
 
    
    public ArrayList<Point> getPathingPoints(){
        return pathingPoints;
    }
    
    public void setPathingPoints() {
        pathingPoints = new ArrayList<>();
//        pathingPoints.add(new Point(300, 250));
//        pathingPoints.add(new Point(300, 520));
//        pathingPoints.add(new Point(575, 520));
//        pathingPoints.add(new Point(575, 90));
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

        int rand = new Random().nextInt(5) + 1;
        pathingPoints = new ArrayList<>();
        if (rand == 1){
            startingPoint = new Point(0, 0);
            pathingPoints.add(new Point(375, 0));
        }
        else if (rand == 2){
            startingPoint = new Point(0, 0);
            pathingPoints.add(new Point(200, 0));
            pathingPoints.add(new Point(200, 250));
            pathingPoints.add(new Point(300, 250));
            pathingPoints.add(new Point(300, 520));
            pathingPoints.add(new Point(575, 520));
            pathingPoints.add(new Point(575, 90));
            pathingPoints.add(new Point(550, 90));
        }
        else if (rand == 3){
            startingPoint = new Point(0, 0);
            pathingPoints.add(new Point(200, 0));
            pathingPoints.add(new Point(200, 250));
            pathingPoints.add(new Point(0, 250));
            pathingPoints.add(new Point(0, 520));
            pathingPoints.add(new Point(575, 520));
            pathingPoints.add(new Point(575, 90));
            pathingPoints.add(new Point(550, 90));
        }
        else if (rand == 4){
            startingPoint = new Point(0, 250);
            pathingPoints.add(new Point(300, 250));
            pathingPoints.add(new Point(300, 520));
            pathingPoints.add(new Point(575, 520));
            pathingPoints.add(new Point(575, 90));
            pathingPoints.add(new Point(550, 90));
        }
        else if (rand == 5){
            startingPoint = new Point(0, 250);
            pathingPoints.add(new Point(0, 520));
            pathingPoints.add(new Point(575, 520));
            pathingPoints.add(new Point(575, 90));
            pathingPoints.add(new Point(550, 90));
        }
        else {
            startingPoint = new Point(0, 250);
            pathingPoints.add(new Point(200, 250));
            pathingPoints.add(new Point(200, 0));
            pathingPoints.add(new Point(375, 0));
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
