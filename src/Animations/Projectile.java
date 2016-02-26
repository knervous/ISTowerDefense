/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animations;
import Towers.*;
import java.awt.*;


public class Projectile extends Rectangle{
    
    
    private String background;
    
    public Projectile(Tower tower)
    {
        super();
        this.width = 20;
        this.height = 20;
        if(tower instanceof SRTower)
        {
            background = "Images/energyball.png";
        }
        else if(tower instanceof MRTower)
        {
            background = "Images/energyball1.png";
        }
        else
        {
            background = "Images/energyball2.png";
        }
    }
    
    public String getBackground()
    {
        return background;
    }
    
    
}
