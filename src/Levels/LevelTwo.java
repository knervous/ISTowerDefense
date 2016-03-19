
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

//~--- non-JDK imports --------------------------------------------------------
import istower.defense.v1.ISTowerDefenseV1;

//~--- JDK imports ------------------------------------------------------------
import java.awt.*;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.util.*;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

/**
 *
 *
 */
public class LevelTwo extends Level {

    private int level = 2;
    private ArrayList<Point> pathingPoints;
    private Point startingPoint;
    private String grass;
    private String path;
    /*
    Removed krungus
    
    Paul Johnson
    */
    public static Sequencer seqTwo;

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
            seqTwo = MidiSystem.getSequencer();
            seqTwo.open();
            is = new BufferedInputStream(new FileInputStream(new File("src/Phil_Collins_-_In_the_Air_Tonight.mid")));
            seqTwo.setSequence(is);
            seqTwo.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            seqTwo.start();
            is.close();
        } catch (Exception e) {
        }
    }

    private void initWorld() {
        getWorld().add(new Rectangle(0, 50, 300, 470));      // top left
        getWorld().add(new Rectangle(350, 0, 225, 220));    // top right
        getWorld().add(new Rectangle(350, 270, 225, 250)); // mid right

    }

    public int getLevel() {
        return level;
    }

    public void setPathingPoints() {
        pathingPoints = new ArrayList<>();

    }

    @Override
    public int getNumEnemies() {
        return new Random().nextInt(4) + 1;
    }

    @Override
    public int getEnemyType() {
        int rand = new Random().nextInt(4) + 1;
        if(rand == 1 || rand == 2)
        {
            return 1;
        }
        else if(rand == 3)
        {
            return 2;
        }
        else if(rand == 4)
        {
            return 3;
        }
        
        return 1;
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
        return startingPoint;
    }

    @Override
    public void setStartingPoint() {
        int rand = new Random().nextInt(2) + 1;
        if (rand == 1) {
            startingPoint = new Point(0, 0);
            pathingPoints = new ArrayList<>();
            pathingPoints.add(new Point(300, 0));

            int rand1 = new Random().nextInt(2) + 1;
            if (rand1 == 1) {
                pathingPoints.add(new Point(300, 520));
                pathingPoints.add(new Point(575, 520));
                pathingPoints.add(new Point(575, 90));
                pathingPoints.add(new Point(525, 90));
            } else if (rand1 == 2) {
                pathingPoints.add(new Point(300, 220));
                pathingPoints.add(new Point(575, 220));
                pathingPoints.add(new Point(575, 90));
                pathingPoints.add(new Point(525, 90));
            }

        } else if (rand == 2) {
            startingPoint = new Point(0, 520);
            pathingPoints = new ArrayList<>();
            pathingPoints.add(new Point(575, 520));
            pathingPoints.add(new Point(575, 90));
            pathingPoints.add(new Point(525, 90));

        }
    }

}


//~ Formatted by Jindent --- http://www.jindent.com
