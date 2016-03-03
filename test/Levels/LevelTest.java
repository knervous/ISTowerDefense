/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Enemies.*;
import Towers.*;
import istower.defense.v1.OptionsPanel;
import java.awt.event.MouseEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.*;
import junit.framework.Assert;

/**
 *
 * @author Paul
 */
public class LevelTest {
    
    public LevelTest() {
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

    //Testing to see if the enemyGroup has values added multiple times and still keeps a difference of at most 4
    //So that it's shown that the size of enemies grows while enemyGroup is reset each time

    @Test
    public void testStartWaves() {
        
        
        Level instance = new LevelOne();

        
        instance.startWaves();
        instance.startWaves();
        
        int expDifference = (instance.enemies.size()-instance.enemyGroup.size());
        
        boolean isInRange;
        
        if(expDifference > 0 && expDifference <5 )
        {
            isInRange = true;
        }
        else
        {
            isInRange = false;
        }
        
        Assert.assertEquals(isInRange, true);
        
    }

    /**
     * Testing out some static methods to see what happens with thread states
     */
    @Test
    public void testPauseGame() {
        Level instance = new LevelOne();
        Level.isPaused = true;
        instance.startWaves();
        Level.pauseGame();
        
        
        boolean expState = false;
        
        for(Thread thread : Level.allThreads)
        {
            if(thread.getState() == Thread.State.TIMED_WAITING || thread.getState() == Thread.State.RUNNABLE)
            {
                expState = true;
            }
            
            else
            {
                expState = false;
            }
        }
        
        Assert.assertEquals(expState, true);
        
    }

    /**
     * Testing to see if we don't get some weird values
     */
    @Test
    public void testCreateEnemies() {
        System.out.println("createEnemies");
        Level instance = new LevelOne();
        instance.createEnemies();
        
        boolean expResult;
        
        for(Enemy enemy : instance.enemyGroup)
        {
            if (enemy instanceof EnemyThree)
            {
                expResult = false;
            }
            else if(enemy instanceof EnemyOne || enemy instanceof EnemyTwo)
            {
                expResult = true;
            }
        }
        
        if(instance.enemyGroup.size() > 0 && instance.enemyGroup.size() < 5)
        {
            expResult = true;
        }
        else
        {
            expResult = false;
        }
        
        Assert.assertEquals(expResult, true);
        
    }



    /**
     * Test to see if the enemy is damaging the castle correctly
     */
    @Test
    public void testDamageCastle() {
        System.out.println("damageCastle");
        Enemy enemy = new EnemyOne();
        Level instance = new LevelOne();
        
        
        int expDifference = 200 - 40;
        
        instance.damageCastle(enemy);
        
        int infDifference =  (int) instance.castleHealth - enemy.getDamage();
        
        Assert.assertEquals(expDifference, infDifference);
        
    }





    /*
    /     Testing if click is out of bounds if the gold is refunded for a tower trying to be built
    /
    /
    */
    @Test
    public void testMouseClicked() {
        System.out.println("mouseClicked");
        
        Level instance = new LevelOne();
        instance.repaint();
        
        int startGold = OptionsPanel.gold;
        Level.isBuilding = true;
        MouseEvent me = new MouseEvent((Component) instance, 21, 0L, 12, 12, 12, 12, false);
        
        instance.mouseClicked(me);
        
        int expDifference = 200;
        int infResult = OptionsPanel.gold - startGold;
        
        Assert.assertEquals(expDifference, infResult);
        
        
    }


    /**
     * Might as well test a getter
     */
    @Test
    public void testGetGrass() {
        System.out.println("getGrass");
        Level instance = new LevelOne();
        String expResult = "Images/forestfloor.jpg";
        String result = instance.getGrass();
        assertEquals(expResult, result);
       
    }


    
}
