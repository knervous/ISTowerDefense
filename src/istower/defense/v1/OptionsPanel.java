/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istower.defense.v1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Paul
 */
public class OptionsPanel extends JPanel
    {
        private JLabel levelDisplay, waveDisplay, waveTimerDisplay, goldDisplay;
        private JButton towerOne, towerTwo, towerThree, start, pause, quit;
        private Timer waveTimer;
        private GridBagConstraints constraints;
        private int level, wave, waveTime, gold;
        
        public OptionsPanel(int frameWidth, int frameHeight)
        {
            super();
            setSize((frameWidth*(1/5)),frameHeight);
            setPreferredSize(new Dimension(200,600));
            setBackground(Color.red);
            setLayout(new GridBagLayout());
            initializeComponents();
            setupComponents();
            addComponents();
            System.out.println(this.getHeight());
        }
        
        
        public void initializeComponents()
        {
            level = 1;
            waveTime = 30;
            wave = 1;
            gold = 800;
            constraints = new GridBagConstraints();
            waveTimer = new Timer(1000, new ActionListener() // setting up wave timer
            {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    waveTime --;
                    if(waveTime==0)
                        waveTimer.removeActionListener(this);
                }
                
            });
            towerOne = new JButton("Tower 1");
            towerTwo = new JButton("Tower 2");
            towerThree = new JButton("Tower 3");
            start = new JButton("Start");
            pause = new JButton("Pause");
            quit = new JButton("Quit");
            
            levelDisplay = new JLabel("Level: "+level);
            waveDisplay = new JLabel("Wave: "+wave);
            waveTimerDisplay = new JLabel(waveTime+" secs");
            goldDisplay = new JLabel("Gold: "+gold);
            
            
        }
        /*
        @Override
        public void paintComponent(Graphics g)
        {
            setupComponents();
            System.out.println();
            
            
            getParent().setPreferredSize(new Dimension(getParent().getParent().getSize().width / 5, getParent().getParent().getSize().height));
            
            
        }
        */
        private void setupComponents() 
        {
            //System.out.println(this.getSize());
            System.out.println((Double.valueOf(this.getSize().width*.90).intValue()));
            
            
            towerOne.setPreferredSize(new Dimension(75,75));
            
            towerTwo.setPreferredSize(new Dimension(75,75));
            towerThree.setPreferredSize(new Dimension(75,75));
            
            levelDisplay.setBackground(Color.white);
            
        }
        
        public void addComponents()
        {
            
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.weightx = 1.0;
            constraints.weighty = .05;
            constraints.insets = new Insets(3,3,3,3);
            add(this.levelDisplay, constraints);
            constraints.gridy = 1;
            add(this.waveDisplay, constraints);
            constraints.gridy = 2;
            add(this.waveTimerDisplay, constraints);
            constraints.gridy = 3;
            add(this.goldDisplay, constraints);
            constraints.weighty = .10;
            //constraints.insets = new Insets(10,0,0,10);
            constraints.gridy = 4;
            add(towerOne, constraints);
            constraints.gridy = 5;
            add(towerTwo, constraints);
            constraints.gridy = 6;
            add(towerThree, constraints);
            constraints.weighty = .05;
            constraints.insets = new Insets(3,3,3,3);
            constraints.gridy = 7;
            add(start, constraints);
            constraints.gridy = 8;
            add(pause, constraints);
            constraints.gridy = 9;
            add(quit, constraints);
            
        }

        
    }
