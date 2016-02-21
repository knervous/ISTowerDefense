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
public class LevelOne extends Level{
    
        private int level;
        
        public LevelOne()
        {
            super();
            setSize((800*(4/5)),600);
            this.setBackground(Color.yellow);
        }
        
        private void initializeComponents()
        {
            level = 0;
        }
         
        public int getLevel()
        {
            return level;
        }
    
}
