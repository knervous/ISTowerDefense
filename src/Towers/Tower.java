
package Towers;

//~--- JDK imports ------------------------------------------------------------
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public abstract class Tower extends Rectangle {
    
    private boolean isFiring = false;
    private String background;
    private String name;
    private double range;
    private int damage;
    
    // Refactor: Encapsulate Field refactor, change protected members to private, created getTower method. Yangyuqi Chang 

    public Tower() {
        this.x = 0;
        this.y = 0;
        this.width = 50;
        this.height = 50;
    }

    public void setRect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void setTower(String name, double range, int damage, String background){
        this.name = name;
        this.range = range;
        this.damage = damage;
        this.background = background;        
    }

  
    public boolean whenToFire(double range, Rectangle enemy, Rectangle tower) {

        double xdistance = Math.abs(enemy.getCenterX() - tower.getCenterX());
        double ydistance = Math.abs(enemy.getCenterY() - tower.getCenterY());
        double enemyDistance = Math.sqrt(Math.pow(xdistance, 2) + Math.pow(ydistance, 2));

        while (enemyDistance <= range) {
            return true;
        }

        return false;
    }

    public boolean isFiring() {
        return isFiring;
    }

    public void setIsFiring(boolean firing) {
        this.isFiring = firing;
    }
    
    public boolean getIsFiring()
    {
        return isFiring;
    }

    public String getBackground() {
        return background;
    }

    public double getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }
     public String getName()
    {
        return name;
    }


}
