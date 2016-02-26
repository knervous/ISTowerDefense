/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animations;

import Enemies.Enemy;
import Enemies.EnemyOne;
import Levels.LevelOne;
import Towers.MRTower;
import java.awt.Point;
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
public class TowerShootAnimationTest {
    
    public TowerShootAnimationTest() {
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
     * Test of getAngle method, of class TowerShootAnimation.
     */
    @Test
    public void testGetAngle() {
        System.out.println("getAngle");
        Point center = new Point(25, 25);
        Point target = new Point(75, 75);
        EnemyOne enemy = new EnemyOne();
        MRTower mrTower = new MRTower();
        Projectile projectile = new Projectile(mrTower);
        LevelOne levelOne = new LevelOne();
        TowerShootAnimation instance = new TowerShootAnimation(projectile, enemy, mrTower, levelOne);
        double expResult = 179.2328896042546;
        double result = instance.getAngle(center, target);
        assertEquals(expResult, result, 179.2328896042546);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
    }

   
}
