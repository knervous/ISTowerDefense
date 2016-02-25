package istower.defense.v1;

import Levels.*;
import java.awt.*;
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
        level = new LevelOne();
        optionsPanel = new OptionsPanel(frameWidth, frameHeight);
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
                if (optionsPanel.getPause() == true) {
                    optionsPanel.getWaveTimer().stop();
                    optionsPanel.setIsPaused();
                } else {
                    optionsPanel.getWaveTimer().start();
                    optionsPanel.setIsPaused();
                }
            }
        });

    }

}
