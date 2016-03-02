/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istower.defense.v1;

import javax.swing.JFrame;

/**
 *
 * @author greg
 */
public class ObjectFrame{
    JFrame objectFrame = new JFrame();
    
    public ObjectFrame(){
        objectFrame.setSize(200,600);
        objectFrame.setLocation(1000, 100);
        objectFrame.setDefaultCloseOperation(objectFrame.EXIT_ON_CLOSE);
        objectFrame.setVisible(true);
    }
}
