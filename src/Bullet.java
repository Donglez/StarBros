package starbrosgame;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

/**
 * A bullet (or projectile) that a character will shoot. 
 * Each bullet has its own damage that should be set in the constructor and
 * taken from the character's getMethods.
 * @author dean
 */
public class Bullet 
{
    protected int x = 0;
    protected int y = 0;
    protected int distance = 0;
    protected int velocity = 4;
    protected int xStart = 0;
    protected BufferedImage bullet;
    protected Rectangle bb = new Rectangle();
    protected int bRange = 450;
    protected String direction = "";
    protected Color primaryColor;
    protected Color secondaryColor;
    protected int width = 12;
    protected int height = 4;
    protected int bDamage = 0;
    protected int speed = 0;
    protected boolean seeking = false;
    protected int n = 0;
    protected String type = "normal";
    protected int targetX = 20000;
    protected int targetY = 20000;
    protected int m = 0;
    protected int size = 24;
    protected double w = 0;
    protected double h = 0;
    
    /**
     * Blank constructor for a bullet.
     */
    Bullet()
    {
        x = -2000;
        y = -2000;
        bb = new Rectangle(x,y,0,0);
    }
    /**
     * Parameterized constructor for a bullet.
     * @param X horizontal position.
     * @param Y vertical position.
     * @param b the bullet's image.
     * @param s size of the bullet.
     * @param r range (maximum distance the bullet can travel).
     * @param sp an integer representing speed.
     * @param d the value of the damage the bullet will deal.
     * @param t the type of bullet. (eg. Seeking)
     * @param dir the direction that the bullet was initially fired.
     */
    Bullet(int X, int Y, BufferedImage b, int s, int r, int sp,
            int d, String t, String dir)
    {
        x = X;
        y = Y; 
        size = s;
        bullet = b;
        w = bullet.getWidth();
        h = bullet.getHeight();
        distance = 0;
        bRange = r;
        velocity = sp;
        bDamage = d;
        type = t;
        direction = dir;
        speed = sp;
        if (direction.equals("left"))
        {
            velocity = -sp;
        }
    }
    
    /**
     * Draws the bullet on the screen as well as managing its movement and
     * disappearance due to reaching its maximum range.
     * @param g the graphics of the paintComponent method();
     * @throws IOException 
     */
    public void draw(Graphics g) throws IOException
    {
        if (distance < bRange)
        {
     if(seeking == false) 
     {
     x = x + velocity;
     }
     distance = distance + speed;

     double dub = (h/w)*size;
     if (direction.equals("right"))
     {
     g.drawImage(bullet, x, y, size, (int)(dub), null);
     bb = new Rectangle (x, y, size, (int)(dub));
     }
     else
     {
      g.drawImage(bullet, x, y, -size, (int)(dub), null);
      bb = new Rectangle (x-size, y, size, (int)(dub));   
     }
        }
     if (distance >= bRange)
     { 
       x = -2000;
       y = -2000;
       bb = new Rectangle(x, y, 0, 0); 
       bullet = null;
     }
    }
    
    
    /**
     * 
     * @return the absolute value of the bullets velocity.
     */
    public int getSpeed()
    {
        return speed;
    }
    
    
     /**
      * 
      * @return the bullets velocity that it travels at. 
      * (take negative to be left)
      */
    public int getVelocity()
    {
        return velocity;
    }
    
    /**
     * 
     * @return the rectangle representing a box surrounding the bullet.
     * <p>
     * Used in decisions relating to collisions between a character 
     * and a bullet.
     */
    public Rectangle getBbox()
    {
        return bb;
    }

    /**
     * 
     * @return the bullet's horizontal position.
     */
    public int getX() 
    {
        return x; 
    }
    
    /**
     * 
     * @return the bullet's vertical position. 
     */
    public int getY() 
    {
        return y; 
    }
    
    /**
     * 
     * @return the damage that the bullet does.
     */
     public int getBDamage() 
    {
        return bDamage; 
    }
     
     /**
     * sets the bullet's x value.
     * @param X a horizontal position.
     */
    public void setX(int X) 
    {
        x = X;
    }
    
    /**
     * sets the bullet's y value.
     * @param Y a vertical position.
     */
    public void setY(int Y) 
    {
        y = Y;
    }
    
    /**
     * Used if the bullet is a seeking bullet.
     * Causes the bullet to seek out the closest player to kill.
     * (fairly advanced)
     */
    public void seekPlayer()
    {
     n++;
        if (targetX > x)
      {
          x = x+speed;
      }
      if (targetX < x)
      {
          x = x-speed;
      }
     
      if (n >= 3)
      {
      if (targetY > y)
      {
          y = y + (int)(speed);
      }
      if (targetY < y)
      {
          y = y - (int)(speed);
      }
      n = 0;
      }
      seeking = true;
      targetX = 20000;
      targetY = 20000;
      
    }

    
    public void updateTarget(int ax, int ay)
    {
        double diag1 = Math.hypot(Math.abs(x - targetX), Math.abs(y - targetY));
        double diag2 = Math.hypot(Math.abs(x - ax), Math.abs(y - ay));
        
     
        if (diag2 < diag1)
        {
            targetX = ax;
            targetY = ay;
        } 
    }
    
    /**
     * Teleports the bullet from one point to another.
     * @param max the maximum x value the bullet will reach before teleporting 
     * back to the minimum x value.
     * @param min the minimum x value the bullet will reach before teleporting
     * back to the maximum x value
     */
    public void Teleport(int max, int min)
    {
      if (x > max)
      {
          x = min;
      }
      if (x < min)
      {
          x = max;
      }
    }
    /**
     * 
     * @return the type of bullet (eg. force)
     */
    public String getType()
    {
      return type;  
    }
    
    /**
     * 
     * @return the vector value of the bullets co-ordinates. (X, Y) 
     */
    public Vector V()
    {
        Vector v = new Vector(x,y);
        return v;
    }
}
