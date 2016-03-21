/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istower.defense.v1;
import Towers.*;
import Levels.*;
import javax.swing.Action;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class GameController implements KeyListener {
    
    private int frameWidth = 800;
    private int frameHeight = 600;
    private int frameLocationX = 200;
    private int frameLocationY = 50;
    public static Timer waveTimer;
    private final int GOLDAMOUNT = 200;  //Refactoring: replace a magic number with symbolic constant, a constant be used for the starting amount of Gold. Yangyuqi Chang
    private GridBagConstraints constraints = new GridBagConstraints(); 
    private PlayGame playGame;
    private Level level;
    private OptionsPanel optionsPanel;
    
    public GameController()
    {
        initUI();
        addActionListeners();
        waveTimer = new Timer(1000, new WaveTimer());
    }
    
    
    
     public void initUI() {
         
       
        playGame = new PlayGame();
        optionsPanel = new OptionsPanel(frameWidth, frameHeight);
        level = new LevelOne();
        waveTimer = new Timer(1000, new WaveTimer());
        
        playGame.setSize(frameWidth, frameHeight);
        playGame.setVisible(true);
        playGame.getContentPanel().setSize(playGame.getSize());
        playGame.setLayout(new GridLayout());
        playGame.getContentPanel().setLayout(new GridBagLayout());
        playGame.setSize(frameWidth, frameHeight);
        
        
        constraints.weightx = .9;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        playGame.getContentPanel().add(level, constraints);
        constraints.weightx = .1;
        constraints.weighty = 1.0;
        playGame.getContentPanel().add(optionsPanel, constraints);
        playGame.setTitle("ISTower Defense");
        playGame.setContentPane(playGame.getContentPanel());
        playGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
     
     public void addActionListeners() {
        
        playGame.setFocusable(true);
        playGame.addKeyListener(this);
        
        
        
         
         
         optionsPanel.quit(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        optionsPanel.startLevel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.startWaves();
                waveTimer.start();
                optionsPanel.getStart().removeActionListener(this);

            }
        });

        optionsPanel.pauseGame(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                level.pauseGame();
                level.setIsPaused();
                
                /*
                Removed echo
                Paul Johnson
                */

                if (level.getIsPaused()) {
                    waveTimer.stop();

                } else {
                    waveTimer.start();
                }

            }
        });
        

        optionsPanel.mouseMrTower(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    TowerPanel tP = new TowerPanel(new MRTower());
                } else if (e.getButton() == MouseEvent.BUTTON1) {
                    if (optionsPanel.getGold() >= GOLDAMOUNT && !level.getIsBuilding()) {

                        level.buildTower(new MRTower());
                        optionsPanel.setGold(GOLDAMOUNT);
                        optionsPanel.repaint();
                    }
                }
            }

        });

        optionsPanel.mouseSrTower(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    TowerPanel tP = new TowerPanel(new SRTower());
                } else if (e.getButton() == MouseEvent.BUTTON1) {
                    if (optionsPanel.getGold() >= GOLDAMOUNT && !level.getIsBuilding()) {

                        level.buildTower(new SRTower());
                        optionsPanel.setGold(GOLDAMOUNT);
                        optionsPanel.repaint();
                    }
                }
            }

        });

        optionsPanel.mouseLrTower(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    TowerPanel tP = new TowerPanel(new LRTower());
                } else if (e.getButton() == MouseEvent.BUTTON1) {
                    if (optionsPanel.getGold() >= GOLDAMOUNT && !level.getIsBuilding()) {

                        level.buildTower(new LRTower());
                        optionsPanel.setGold(GOLDAMOUNT);
                        optionsPanel.repaint();
                    }
                }
            }

        });

    }
     
     
     
    public void nextLevel(Level infLevel) {
        level = infLevel;
        playGame.getContentPanel().removeAll();
        playGame.getContentPanel().repaint();
        playGame.revalidate();

        constraints.weightx = .9;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        playGame.getContentPanel().add(level, constraints);

        constraints.weightx = .1;
        constraints.weighty = 1.0;
        playGame.getContentPanel().add(optionsPanel, constraints);

        optionsPanel.startLevel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.startWaves();
                waveTimer.start();
                optionsPanel.getStart().removeActionListener(this);

            }
        });
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyChar() == 'g')
        {
            optionsPanel.setupGold(optionsPanel.getGold() + 200);
            optionsPanel.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
    
    
    
    
    public class WaveTimer implements ActionListener {

    

        @Override
        public void actionPerformed(ActionEvent ae) {
            optionsPanel.setWaveTime(optionsPanel.getWaveTime()-1);
            
            if (optionsPanel.getWaveTime() == 0) {
                optionsPanel.setWave(optionsPanel.getWave()+1);
                optionsPanel.setWaveTime(20);

            }

            if (optionsPanel.getWaveTime() % 10 == 0) {
                level.startWaves();
            }
            optionsPanel.repaint();
            
            if(optionsPanel.getWave() % 5 == 0)
            {
                waveTimer.stop();
                optionsPanel.setWave(1);

                

                if(level instanceof LevelOne)
                {
                    optionsPanel.setLevel(optionsPanel.getLevel()+1);
                    optionsPanel.setupGold(1000);
                    for(Thread thread : level.getAllThread())
                    {
                        thread.stop();
                    }
                    level.getAllThread().clear();
                    level = new LevelTwo();
                    nextLevel(level);
                    javax.swing.JOptionPane.showMessageDialog(null, "You made it to the next level!");
                }
                
                else if(level instanceof LevelTwo)
                {
                    optionsPanel.setLevel(optionsPanel.getLevel()+1);
                    optionsPanel.setupGold(1000);
                    for(Thread thread : level.getAllThread())
                    {
                        thread.stop();
                    }
                    level.getAllThread().clear();
                    level = new LevelThree();
                    nextLevel(level);
                    javax.swing.JOptionPane.showMessageDialog(null, "You made it to the next level!");
                }
                
                else if(level instanceof LevelThree)
                {
                    javax.swing.JOptionPane.showMessageDialog(null, "You beat the game! Congratulations!");
                }
            }
        }
        
    }
}
