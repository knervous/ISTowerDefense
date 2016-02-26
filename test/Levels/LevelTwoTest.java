/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yvc5283
 */
public class LevelTwoTest {
    
    public LevelTwoTest() {
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
     * Test of getLevel method, of class LevelTwo.
     */
    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        LevelTwo instance = new LevelTwo();
        int expResult = 2;
        int result = instance.getLevel();
        assertEquals(expResult, result);
    }


    /**
     * Test of getEnemyType method, of class LevelTwo.
     */
    @Test
    public void testGetEnemyType() {
        System.out.println("getEnemyType");
        LevelTwo instance = new LevelTwo();
        int expResult = 2;
        int result = instance.getEnemyType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEnemyType method, of class LevelTwo.
     */
    @Test
    public void getNumEnemies() {
        System.out.println("getNumEnemies");
        LevelTwo instance = new LevelTwo();
        int expResult = 3;
        int result = instance.getNumEnemies();
        assertEquals(expResult, result);

    }    
    
}
