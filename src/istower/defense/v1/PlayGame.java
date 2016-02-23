
package istower.defense.v1;

//~--- non-JDK imports --------------------------------------------------------

import Animations.EnemyAnimation;

import Enemies.*;

import Levels.*;

//~--- JDK imports ------------------------------------------------------------

import java.awt.*;

import java.util.*;

import javax.swing.*;

/**
 *
 * @author Paul
 */
public class PlayGame extends JFrame {
    protected int              frameWidth  = 800;
    protected int              frameHeight = 600;
    private GridBagConstraints constraints = new GridBagConstraints();
    private LevelOne           level;
    private ArrayList<Thread> threads = new ArrayList<>();
    private ArrayList<EnemyOne> enemies = new ArrayList<>();

    public PlayGame() {
        super();
        initUI();
        
        enemies.add(new EnemyOne());
        enemies.add(new EnemyOne());
        enemies.add(new EnemyOne());
        enemies.add(new EnemyOne());
        
        for(EnemyOne enemy : enemies)
        {
            threads.add(new Thread(new EnemyAnimation(enemy, level.getPathingPoints(), level, "test")));
            threads.get(enemies.indexOf(enemy)).start();
            
            System.out.println("done");
            try{
            Thread.sleep(2000);
            
            }catch(Exception e){}
        }
        /*
        Thread thread = new Thread(new EnemyAnimation(new EnemyOne(), level.getPathingPoints(), level, "first thread"));

        thread.start();
        System.out.println("done");
        try{
            Thread.sleep(2000);
            
        }catch(Exception e){}
        
        Thread thread1 = new Thread(new EnemyAnimation(new EnemyOne(), level.getPathingPoints(), level, "second thread"));

        thread1.start();
        
        try{
            Thread.sleep(2000);
            
        }catch(Exception e){}
        
        Thread thread2 = new Thread(new EnemyAnimation(new EnemyOne(), level.getPathingPoints(), level, "second thread"));

        thread2.start();
                
                */
    }

    public void initUI() {
        setSize(frameWidth, frameHeight);
        setVisible(true);
        level = new LevelOne();

        OptionsPanel optionsPanel = new OptionsPanel(frameWidth, frameHeight);

        setLayout(new GridBagLayout());
        setSize(frameWidth, frameHeight);
        constraints.weightx = .9;
        constraints.weighty = 1.0;
        constraints.fill    = GridBagConstraints.BOTH;
        add(level, constraints);
        constraints.weightx = .1;
        constraints.weighty = 1.0;
        add(optionsPanel, constraints);
        setTitle("ISTower Defense");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

