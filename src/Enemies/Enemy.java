
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Enemies;

//~--- JDK imports ------------------------------------------------------------

import java.awt.*;
import java.awt.image.*;

import java.io.*;
import java.io.File;

import javax.imageio.*;

import javax.swing.*;

/**
 *
 * @author Paul
 */
public abstract class Enemy extends Rectangle {
    public Enemy() {
        super();
        this.x      = 0;
        this.y      = 0;
        this.width  = 50;
        this.height = 50;
    }

    public void setRect(int x, int y, int width, int height) {
        this.x      = x;
        this.y      = y;
        this.width  = width;
        this.height = height;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
