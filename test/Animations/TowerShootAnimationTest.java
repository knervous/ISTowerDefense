/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animations;

import Enemies.Enemy;
import Towers.*;
import Enemies.*;
import Levels.*;
import Enemies.EnemyOne;
import Levels.LevelOne;
import Towers.MRTower;
import java.awt.Point;
import junit.framework.Assert;
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
     * Testing to make sure the angle we are calculating is correct
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
        
    }

    /**
     * Test of run method, of class TowerShootAnimation.
     * Testing to see if the projectile is successfully moved off screen after each use
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Tower tower = new SRTower();
        Level level = new LevelOne();
        Enemy enemy = new EnemyOne();
        Projectile projectile = new Projectile(tower);
        
        Point expectedPoint = new Point(2000,2000);
        
        TowerShootAnimation instance = new TowerShootAnimation(projectile, enemy, tower, level);
        
        instance.run();
        
        Assert.assertEquals(expectedPoint, projectile.getLocation());
        
    }

    /**
     * Test of finishProjectile method, of class TowerShootAnimation.
     * Test to see if the tower successfully resets to no longer firing
     */
    @Test
    public void testFinishProjectile() throws Throwable {
        Tower tower = new SRTower();
        Level level = new LevelOne();
        Enemy enemy = new EnemyOne();
        Projectile projectile = new Projectile(tower);
        
        boolean expected = false;
        
        
        TowerShootAnimation instance = new TowerShootAnimation(projectile, enemy, tower, level);
        instance.finishProjectile();
        
        Assert.assertEquals(expected, tower.getIsFiring());
        
    }

   
}
