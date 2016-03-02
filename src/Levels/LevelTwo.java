
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

//~--- non-JDK imports --------------------------------------------------------
import Enemies.*;
import istower.defense.v1.ISTowerDefenseV1;

//~--- JDK imports ------------------------------------------------------------
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.util.*;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

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
        grass = "Images/rockmountain1.png";
        initWorld();

        try {
            ISTowerDefenseV1.sequence.stop();
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

    private void initWorld() {
        world.add(new Rectangle(0, 0, 350, 250));      // top left
        world.add(new Rectangle(0, 300, 300, 300));    // bottom  left
        world.add(new Rectangle(350, 0, 225, 510));    // top right

    }

    public int getLevel() {
        return level;
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
    public ArrayList<Point> getPathingPoints() {
        return pathingPoints;
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
        Point startingPoint = new Point(0, 250);
        return startingPoint;
    }

    @Override
    public void setStartingPoint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


//~ Formatted by Jindent --- http://www.jindent.com
