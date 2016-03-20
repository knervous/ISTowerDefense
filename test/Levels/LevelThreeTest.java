/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import java.awt.Point;
import java.util.ArrayList;
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
public class LevelThreeTest {
    
    public LevelThreeTest() {
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
     * Test of getLevel method, of class LevelThree.
     */
    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        LevelThree instance = new LevelThree();
        int expResult = 3;
        int result = instance.getLevel();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNumEnemies() {
        boolean working = false;
        System.out.println("getNumEnemies");
        LevelThree instance = new LevelThree();
        int result = instance.getNumEnemies();
        for (int i = 0; i < 5; i++){
            if (i + 1 == result){
                working = true;
            }
        }
        assertTrue(working);
    }
    
    @Test
    public void testGetEnemyType() {
        System.out.println("getEnemyType");
        LevelThree instance = new LevelThree();
        int result = instance.getEnemyType();
        int rand = instance.getRand();
        assertTrue((result == 1 && (rand >= 1 && rand <= 3) || 
                  (result == 2 && (rand >= 4 && rand <= 6)) || 
                  (result == 1 && (rand >= 7 && rand <= 8) )));
    }
}
