/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animations;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Levels.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import Enemies.*;
import junit.framework.Assert;
import static org.junit.Assert.*;

/**
 *
 * @author Paul
 */
public class EnemyAnimationTest {
    
    public EnemyAnimationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class EnemyAnimation.
     */
    @Test
    public void testRun() {
        
        Level level = new LevelOne();
        ArrayList<Point> pathing = level.getPathingPoints();
        Enemy enemy = new EnemyOne();
        Point startingPoint = new Point(0,0);
        
        Point expectedLoc = new Point(1000,1000);
        
        EnemyAnimation instance = new EnemyAnimation(enemy, pathing, level, startingPoint);
        instance.run();
        System.out.println(enemy.getLocation());
        
        Assert.assertEquals(expectedLoc, enemy.getLocation());
    }

    /**
     * Test of killedEnemy method, of class EnemyAnimation.
     */
    @Test
    public void testKilledEnemy() throws Throwable{
        Level level = new LevelOne();
        ArrayList<Point> pathing = level.getPathingPoints();
        Enemy enemy = new EnemyOne();
        Point startingPoint = new Point(0,0);
        
        Point expectedLoc = new Point(1000,1000);
        String expectedBG = "Images/coin1.gif";
        
        EnemyAnimation instance = new EnemyAnimation(enemy, pathing, level, startingPoint);
        
        instance.killedEnemy();
        
        System.out.println(enemy.getBackground());
        System.out.println("test");
        
        
        
        assertEquals(expectedBG,enemy.getBackground());
        assertEquals(expectedLoc,enemy.getLocation());
        assertEquals(new Dimension(76,76),enemy.getSize());
        
        
    }

    /**
     * Test of setPause method, of class EnemyAnimation.
     */
    @Test
    public void testSetPause() throws Exception {
        //CANNOT TEST

    }
    
}
