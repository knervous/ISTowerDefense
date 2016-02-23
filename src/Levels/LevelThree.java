/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import java.awt.Color;

/**
 *
 * @author Paul
 */
public class LevelThree extends Level{
    
        private int level;
        
        public LevelThree()
        {
            super();
            this.setBackground(Color.gray);
            
        }
        
        private void initializeComponents()
        {
            level = 3;
        }
         
        public int getLevel()
        {
            return level;
        }
    
}
