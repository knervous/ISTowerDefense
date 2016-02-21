/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istower.defense.v1;
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
    protected JPanel bgPanel;
    
    public PlayGame()
    {
        super();

        setSize(frameWidth,frameHeight);
        setVisible(true);
        
        GamePanel gamePanel = new GamePanel();
        OptionsPanel optionsPanel = new OptionsPanel();
        
        bgPanel = new JPanel();
        bgPanel.setLayout(new GridBagLayout());
        bgPanel.setSize(frameWidth,frameHeight);
        add(bgPanel);
        
        constraints.weightx = .8;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;

        bgPanel.add(gamePanel, constraints);
        
        constraints.weightx = .2;
        constraints.weighty = 1.0;
        
        bgPanel.add(optionsPanel, constraints);
        

        setContentPane(bgPanel);
        setTitle("ISTower Defense");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public class GamePanel extends JPanel 
    {
        private int level;
        
        public GamePanel()
        {
            super();
            setSize((frameWidth*(4/5)),frameHeight);
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
    
    public class OptionsPanel extends JPanel
    {
        private JTextField levelDisplay, waveDisplay, waveTimerDisplay, goldDisplay;
        private JButton towerOne, towerTwo, towerThree, start, pause, quit;
        private Timer waveTimer;
        private GridBagConstraints constraints;
        private int level, wave, waveTime;
        
        public OptionsPanel()
        {
            super();
            setSize((frameWidth*(1/5)),frameHeight);
            this.setBackground(Color.red);
        }
        
        
        public void initializeComponents()
        {
            level = 1;
            waveTime = 30;
            wave = 1;
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
            
            
        }
        
        public void layoutComponents()
        {
            
        }
    }
    
}
