
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istower.defense.v1;

//~--- JDK imports ------------------------------------------------------------
import Levels.Level;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Paul
 */
public class OptionsPanel extends JPanel {

    private JLabel levelDisplay, waveDisplay, waveTimerDisplay, goldDisplay;
    private JButton towerOne, towerTwo, towerThree, start, pause, quit;
    private Timer waveTimer;
    private GridBagConstraints constraints;
    private int level, wave, waveTime;
    public static int gold;
    private boolean isPaused = false;

    public OptionsPanel() {
    }

    ;

    public OptionsPanel(int frameWidth, int frameHeight) {
        super();
        setSize((frameWidth * (1 / 5)), frameHeight);
        setPreferredSize(new Dimension(200, 600));
        setBackground(Color.red);
        setLayout(new GridBagLayout());
        initializeComponents();
        setupComponents();
        addComponents();
        System.out.println(this.getHeight());
    }

    public void initializeComponents() {
        level = 1;
        waveTime = 20;
        wave = 1;
        gold = 800;
        constraints = new GridBagConstraints();
        waveTimer = new Timer(1000, new WaveTimer());
        towerOne = new JButton(new ImageIcon("Images/lr_tower.png"));
        towerTwo = new JButton(new ImageIcon("Images/mr_tower.png"));
        towerThree = new JButton(new ImageIcon("Images/sr_tower.png"));
        towerOne.setContentAreaFilled(false);
        towerTwo.setContentAreaFilled(false);
        towerThree.setContentAreaFilled(false);
        start = new JButton("Start");
        pause = new JButton("Pause");
        quit = new JButton("Quit");
        levelDisplay = new JLabel("Level: " + level);
        setWaveDisplay(new JLabel("Wave: " + wave));
        waveTimerDisplay = new JLabel("Ends in: " + getWaveTime() + "s");
        goldDisplay = new JLabel("Gold: " + gold);
    }

    private void setupComponents() {

        // System.out.println(this.getSize());
        System.out.println((Double.valueOf(this.getSize().width * .90).intValue()));
        towerOne.setPreferredSize(new Dimension(75, 75));
        towerTwo.setPreferredSize(new Dimension(75, 75));
        towerThree.setPreferredSize(new Dimension(75, 75));
        levelDisplay.setBackground(Color.white);
    }

    public void addComponents() {
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = .05;
        constraints.insets = new Insets(2, 2, 2, 2);
        add(this.levelDisplay, constraints);
        constraints.gridy = 1;
        add(this.getWaveDisplay(), constraints);
        constraints.gridy = 2;
        add(this.waveTimerDisplay, constraints);
        constraints.gridy = 3;
        add(this.goldDisplay, constraints);
        constraints.weighty = .10;

        // constraints.insets = new Insets(10,0,0,10);
        constraints.gridy = 4;
        add(towerOne, constraints);
        constraints.gridy = 5;
        add(towerTwo, constraints);
        constraints.gridy = 6;
        add(towerThree, constraints);
        constraints.weighty = .05;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.gridy = 7;
        add(start, constraints);
        constraints.gridy = 8;
        add(pause, constraints);
        constraints.gridy = 9;
        add(quit, constraints);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("Images/scroll.png").getImage(), 0, 0, super.getWidth(), super.getHeight(), null);
        goldDisplay.setText("Gold: " + gold);
        
    }

    public void startLevel(ActionListener al) {
        start.addActionListener(al);
    }
    public void pauseGame(ActionListener al){
        pause.addActionListener(al);
    }
    
    public void srTower(ActionListener al) {
        towerThree.addActionListener(al);
    }
    
    public void mrTower(ActionListener al) {
        towerTwo.addActionListener(al);
    }
    
    public void lrTower(ActionListener al) {
        towerOne.addActionListener(al);
    }

    public JButton getStart() {
        return start;
    }
    
    public JButton getSRTower()
    {
        return towerOne;
    }
    
    public JButton getMRTower()
    {
        return towerTwo;
    }
    
    public JButton getLRTower()
    {
        return towerThree;
    }

    public Timer getWaveTimer() {
        return waveTimer;
    }


    public JLabel getWaveDisplay() {
        return waveDisplay;
    }

    public void setWaveDisplay(JLabel waveDisplay) {
        this.waveDisplay = waveDisplay;
    }

    public int getWaveTime() {
        return waveTime;
    }

    public void setIsPaused() {
        this.isPaused = !isPaused;
    }

    public boolean getPause() {
        return isPaused;
    }
    
    public static void setGold(int amount)
    {
        gold -= amount;
    }

    public class WaveTimer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            waveTime--;
            waveTimerDisplay.setText("Ends in: " + waveTime + "s");
            getWaveDisplay().setText("Wave: " + wave);
            if (waveTime == 0) {
                wave++;
                waveTime = 20;

            }

            if (waveTime % 10 == 0) {
                PlayGame.level.startWaves();
            }
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
