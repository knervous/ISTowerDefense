/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istower.defense.v1;
import Levels.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Paul
 */
public class PlayGame extends JFrame {
    
    
    protected int frameWidth = 800;
    protected int frameHeight = 600;
    private GridBagConstraints constraints = new GridBagConstraints();
    private JPanel bgPanel;
    private Level level;
    
    public PlayGame()
    {
        super();

        setSize(frameWidth,frameHeight);
        setVisible(true);
        level = new LevelOne();
        OptionsPanel optionsPanel = new OptionsPanel();
        
        bgPanel = new JPanel();
        bgPanel.setLayout(new GridBagLayout());
        bgPanel.setSize(frameWidth,frameHeight);
        add(bgPanel);
        
        constraints.weightx = .95;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;

        bgPanel.add(level, constraints);
        
        constraints.weightx = .1;
        constraints.weighty = 1.0;
        
        bgPanel.add(optionsPanel, constraints);
        

        setContentPane(bgPanel);
        setTitle("ISTower Defense");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public class OptionsPanel extends JPanel
    {
        private JLabel levelDisplay, waveDisplay, waveTimerDisplay, goldDisplay;
        private JButton towerOne, towerTwo, towerThree, start, pause, quit;
        private Timer waveTimer;
        private GridBagConstraints constraints;
        private int level, wave, waveTime, gold;
        
        public OptionsPanel()
        {
            super();
            setSize((frameWidth*(1/5)),frameHeight);
            setBackground(Color.red);
            setLayout(new GridBagLayout());
            initializeComponents();
            setupComponents();
            addComponents();
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
        
        private void setupComponents() {
            towerOne.setPreferredSize(new Dimension(75,75));
            towerTwo.setPreferredSize(new Dimension(75,75));
            towerThree.setPreferredSize(new Dimension(75,75));
            
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
    
}
