/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istower.defense.v1;
import Levels.*;
import javax.swing.*;
import java.awt.*;

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
        level = new LevelTwo();
        OptionsPanel optionsPanel = new OptionsPanel(frameWidth, frameHeight);
        
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
    
}
