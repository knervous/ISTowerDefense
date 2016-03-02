package istower.defense.v1;

import Levels.*;
import Towers.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Paul
 */
public class PlayGame extends JFrame {

    protected int frameWidth = 800;
    protected int frameHeight = 600;
    private GridBagConstraints constraints = new GridBagConstraints();
    public static Level level;
    private OptionsPanel optionsPanel;


    public PlayGame() {
        super();

        initUI();
        revalidate();
        level.repaint();
        optionsPanel.repaint();
        setResizable(false);
        addActionListeners();
    }

    public void initUI() {

        setSize(frameWidth, frameHeight);
        setVisible(true);
        optionsPanel = new OptionsPanel(frameWidth, frameHeight);

        level = new LevelOne();
        setLayout(new GridBagLayout());
        setSize(frameWidth, frameHeight);
        constraints.weightx = .9;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        add(level, constraints);
        constraints.weightx = .1;
        constraints.weighty = 1.0;
        add(optionsPanel, constraints);
        setTitle("ISTower Defense");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addActionListeners() {
        optionsPanel.startLevel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.startWaves();
                optionsPanel.getWaveTimer().start();
                optionsPanel.getStart().removeActionListener(this);

            }
        });

        optionsPanel.pauseGame(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Level.pauseGame();
                Level.setIsPaused();
                System.out.println("pausing");

                if (Level.getIsPaused()) {
                    optionsPanel.getWaveTimer().stop();

                } else {
                    optionsPanel.getWaveTimer().start();

                }
               
            }
        });

        
        
        optionsPanel.mouseMrTower(new MouseAdapter() {
            @Override
               public void mousePressed(MouseEvent e) {
                  if (e.getButton() == MouseEvent.BUTTON3) {
                     //pop up jframe with medium range tower information
                  }
                  else if(e.getButton() == MouseEvent.BUTTON1)
                  {
                       if (OptionsPanel.gold >= 200 && !Level.isBuilding) {

                        level.buildTower(new MRTower());
                        OptionsPanel.setGold(200);
                        optionsPanel.repaint();
                       }
                  }
               }
            
        });
        
        optionsPanel.mouseSrTower(new MouseAdapter() {
            @Override
               public void mousePressed(MouseEvent e) {
                  if (e.getButton() == MouseEvent.BUTTON3) {
                     //pop up jframe with short range tower information
                  }
                  else if(e.getButton() == MouseEvent.BUTTON1)
                  {
                       if (OptionsPanel.gold >= 200 && !Level.isBuilding) {

                        level.buildTower(new SRTower());
                        OptionsPanel.setGold(200);
                        optionsPanel.repaint();
                       }
                  }
               }
            
        });
        
        optionsPanel.mouseLrTower(new MouseAdapter() {
            @Override
               public void mousePressed(MouseEvent e) {
                  if (e.getButton() == MouseEvent.BUTTON3) {
                     //pop up jframe with long range tower information
                  }
                  else if(e.getButton() == MouseEvent.BUTTON1)
                  {
                       if (OptionsPanel.gold >= 200 && !Level.isBuilding) {

                        level.buildTower(new LRTower());
                        OptionsPanel.setGold(200);
                        optionsPanel.repaint();
                       }
                  }
               }
            
        });


    }

}
