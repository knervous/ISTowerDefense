/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istower.defense.v1;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author greg
 */
public class ObjectFrame extends JFrame{
    
    public ObjectFrame(JPanel panel){
        setSize(200,600);
        setLocation(PlayGame.getFrameLocationX() + PlayGame.getFrameWidth(), PlayGame.getFrameLocationY());
        setVisible(true);
        setContentPane(panel);
    }
}
