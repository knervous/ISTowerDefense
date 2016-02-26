/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Towers;

import java.awt.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author greg
 */
public class TowerTest {
    
    public TowerTest() {
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
     * Test of whenToFire method, of class Tower.
     */
    @Test
    public void testWhenToFire() {
        Rectangle enemy = new Rectangle(0,0,4,4);
        Rectangle tower = new Rectangle(4,4,4,4);
        double xdistance = enemy.getCenterX() - tower.getCenterX();
        double ydistance = enemy.getCenterY() - tower.getCenterY();
        double enemyDistance = Math.sqrt(Math.pow(xdistance, 2) + Math.pow(ydistance, 2));
        System.out.println(enemyDistance);
        assertTrue(enemyDistance == 5.656854249492381);        
    }    
}
