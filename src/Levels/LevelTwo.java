
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
        grass = "Images/rockmountain.png";
        initWorld();
        
        try{
        InputStream is;
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        is = new BufferedInputStream(new FileInputStream(new File("src/Necrophagist_-_Seven.mid")));
        sequencer.setSequence(is);
        sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        sequencer.start();
        is.close();
        }
        catch(Exception e){}
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



}


//~ Formatted by Jindent --- http://www.jindent.com
