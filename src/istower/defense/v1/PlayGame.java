/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istower.defense.v1;
import Levels.*;
import Enemies.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *
 * @author Paul
 */
public class PlayGame extends JFrame {
    
    
    protected int frameWidth = 800;
    protected int frameHeight = 600;
    private GridBagConstraints constraints = new GridBagConstraints();
    private Level level;
    
    
    public PlayGame()
    {
        super();
        initUI();
        
    }
    
    public void initUI()
    {
        setSize(frameWidth,frameHeight);
        setVisible(true);
        level = new LevelOne();
        OptionsPanel optionsPanel = new OptionsPanel(frameWidth, frameHeight);
        

        setLayout(new GridBagLayout());
        setSize(frameWidth,frameHeight);

        
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
    
    
    
}
