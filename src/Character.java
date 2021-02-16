package starbrosgame;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.*;
import java.io.*;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 * Polymorphism is used so that there are multiple different types of characters
 *  (Anakin, CountDooku, Droideka, FlameTrooper, GeneralGrievous, HeavyTrooper,
 * JumpTrooper, MeleeDroid, ObiWanKenobi, ShotgunTrooper and finally,
 *  the SniperTrooper)
 * <p>
 * Each different type of character has their own images for different states
 * like running, jumping, etc.
 * <p>
 * Each different type of character has their own different damage 
 * and other stats. 
 * @author dean
 */
public class Character 
{
 protected Rectangle hbox;  
 protected BufferedImage character;
 protected BufferedImage idleImage;
 protected BufferedImage numberImg;
 protected boolean idle;
 protected int number;
 protected int x = -2000;
 protected int y = -2000;
 protected int health = 0;
 protected boolean acceleratingVertically = false;
 protected int fallcnt = 0;
 protected int verticalVelocity = 0;
 protected int runspeed = 0;
 protected int runcnt = -2;
 protected boolean left = false;
 protected boolean right = true;
 protected int width = 0;
 protected int height = 0;
 protected int shootcnt = -1;
 protected int killedcnt = -1;
 protected int gravitycnt = 0;
 protected int jumpheight = 0;
 protected int runtemp = 0;
 protected Rectangle2 footbox = new Rectangle2();
 protected int bdamage = 1;
 protected boolean dead = false;
 protected boolean shooting = false;
 protected int firerate = 20;
 protected Color pColor;
 protected Color sColor;
 protected int bspread = 0;
 protected int gunx = 0;
 protected int guny = 0;
 protected int brange = 400;
 protected int bspeed = 4;
 protected int bsize = 12;
 protected boolean specialactivated = false;
 protected int specialcnt = -1;
 protected int specialcooldown = 5000;
 protected String name = "";
 protected boolean melee = false;
 protected int meleecnt = 0;
 protected int mdamage = 0;
 protected Rectangle2 meleebox = new Rectangle2();
 protected int bammount = 1;
 protected boolean secondaryactivated = false;
 protected int secondarycnt = -1;
 protected double fallfreq;
 protected int cff = 13;
 protected int regencnt = 0;
 protected int regenfreq = 25;
 protected int kHealth = health;
 protected boolean block = false;
 protected int blockcnt = 0;
 protected boolean dashing = false;
 protected int dashcnt = 0;
 protected boolean canDash = false;
 protected String bType = "normal";
 protected int bdi = 3;
 protected int ma = 0;
 protected int tma = 0;
 protected int meleefreq = 0;
 protected boolean maalo[];
 protected boolean combo = false;// melee animation and total melee animations
 protected double bPenVal = 0;
 protected int terminalV = 10;
 protected int jumpV = 10;
 protected double armorVal = 1;
 protected String atkType = "shoot";
 protected String atkType2 = "";
 protected int lds;
 protected int stamina = 11000;
 protected int kStamina = stamina;
 protected int ammoCost = 10;
 protected int jumpCost = 200;
 protected int meleeCost = 10;
 protected int staminaregen = 80;
 protected boolean reloading = false;
 protected int bWidth = 12;
 protected int bHeight = 4;
 protected BufferedImage bullet1;
 protected BufferedImage bullet2;
 protected int bulletnum = 1;
 protected String facing = "right";
 protected int fVIcnt = 0; //fall velocity increaser counter
 protected int fVI = 0; //fall velocity increaser
 protected int idlecnt = 0;
 protected boolean hero = false;
 protected boolean jumping = false;
 protected int jumpcnt = 0;
 protected String ts1 = "";
 protected String ts2 = "";
 protected String ts3 = "";
 protected int totaltauntsounds = 0;
 protected int shield;
 
 
 
 /**
 * Class constructor
 */
    public Character() 
    {
        right = true;
        hero = false;
        atkType = "shoot";
        atkType2 = "";
        x = -2000;
        y = -2000;
        totaltauntsounds = 0;
    }
    
 /**
 * Sets the Character's player number.
 * Assigns the Character a Player Label equal to n.
 * @param  n  the Player Number between 1 and 4.
     * @throws java.io.IOException
 */
    public void setNumber(int n) throws IOException
    {
        number = n;
        
        switch (number)
        {
            case 1: numberImg = ImageIO.read(new File("number1.png"));
            break;
            case 2: numberImg = ImageIO.read(new File("number2.png"));
            break;
            case 3: numberImg = ImageIO.read(new File("number3.png"));
            break;
            case 4: numberImg = ImageIO.read(new File("number4.png"));
            break;
        }
    }
    
 /**
 * Paints the Character on the screen,
 * including ALL animations (running, jumping, etc.).
 * Passively reacts to void method instructions.
 * Includes large amount of switch cases that change the character's image 
 * according to a specific counter. For example: the runcnt (or run counter)
 *  is used in a switch case to change the characters image to
 * animate the character and make the character look like it is running.
 * <p> 
 * Should be implemented into a paintComponent that is looped in a game loop. 
 * @param  g  the Graphics used to paint.
     * @throws java.io.IOException
 */
    public void draw(Graphics g) throws IOException
    {      
    }
    
 /**
 * Paints the Character's Stamina Bar onto the screen.
 * Does not paint if the character is dead.
 * @param  g  the Graphics used to paint.
     * @throws java.io.IOException
 */
    public void drawStaminaBar(Graphics g) throws IOException
    {
      if (!dead)
      {
       Color col = Color.BLUE;
       if (reloading)
       {
           col = Color.WHITE;
       }
       if (right)
       {
       g.setColor(Color.BLACK);    
       g.drawRect(x-width/2,y - 18,kStamina/100,4);
       g.setColor(col);
       g.fillRect(x-width/2,y - 18,stamina/100,4);
       }
       if (left)
       {
       g.setColor(Color.BLACK);    
       g.drawRect(x+width/2,y - 18,kStamina/100,4);
       g.setColor(col);
       g.fillRect(x+width/2,y - 18,stamina/100,4);
       }
      }
    
    }
    
 /**
 * Paints the Character's Health Bar onto the screen.
 * Does not paint if the character is dead.
 * @param  g  the Graphics used to paint.
     * @throws java.io.IOException
 */
    public void drawHealthBar(Graphics g) throws IOException
    {
      if (!dead)
      {
       if (right)
       {
       g.setColor(Color.BLACK);    
       g.drawRect(x-width/2,y - 10,kHealth/4,4);
       g.setColor(Color.RED);
       g.fillRect(x-width/2,y - 10,health/4,4);
       }
       if (left)
       {
       g.setColor(Color.BLACK);    
       g.drawRect(x+width/2,y - 10,kHealth/4,4);
       g.setColor(Color.RED);
       g.fillRect(x+width/2,y - 10,health/4,4);
       }
      }
    }
    
 /**
 * Paints the Character's assigned Player Label 
 * Does not paint if the character is dead.
 * <p>
 * The Player Label is assigned to the 
 * character using the method: "setNumber(int n)".
 * @param  g  the Graphics used to paint.
     * @throws java.io.IOException
 */
    public void drawNumberIndicator(Graphics g) throws IOException
    {
     if (!dead)
     {
       if (right)
       {
       g.drawImage(numberImg, x-width/2 - 20, y - 20, 20, 20, null); 
       }
       if (left)
       {
       g.drawImage(numberImg, x+width/2 - 20, y - 20, 20, 20, null); 
       }
     }
    }
    
    /**
 * @return the Integer value for the Character's
 * horizontal position on the screen.
 */
    public int getX()
    {
        return x;
    }
    
    /**
 * @return the Integer value for the Character's vertical position 
 * on the screen.
 */
    public int getY()
    {
        return y;
    }
    
 /**
 * Replaces the Character's old x-value with a new one, moving the 
 * Character to a new horizontal position.
 * <p>
 * @param  newX  an Integer to serve as the Character's new horizontal position.
 */
    public void setX(int newX)
    {
        x = newX;
    }
    
    /**
 * Replaces the Character's old y-value with a new one, moving the Character 
 * to a new vertical position.
 * <p>
 * @param  newY  an Integer to serve as the Character's new vertical position.
 */
    public void setY(int newY)
    {
       y = newY; 
    }
    
 /**
 * @return false if the Character's y-velocity is constant,
 * else it returns true.
 */
    public boolean isAcceleratingVertically()
    {
        return acceleratingVertically;
    }
    
    /**
 * @return the Integer value for the x-position of the
 * Character's gun on the screen.
 */
    public int getGunX()
    {
       return gunx;  
    }
    
       /**
 * @return the Integer value for the y-position of the Character's 
 * gun on the screen.
 */
    public int getGunY()
    {
       return guny; 
    }
    
 /**
 * @return the Integer value for the vertical length of the Character.
 */
    public int getHeight()
    {
        return character.getHeight();
    }
    
 /**
 * @return the Vector value for the Character's position on the screen.
 */
    public Vector getFootVector()
    {
        Vector fv = new Vector(x, y + character.getHeight());
        return fv;
    }
    
 /**
 * Instructs the character to run left.
 * <p>
 * Decreases the Character's horizontal position by its Run Speed 
 * every 6th time the method is called.
 * Includes a counter that increases each time the method is called.
 * This counter is used
 * in switch cases in the draw method for animation of the Character's
 * movement. 
 */
    public void RunLeft()
    {
        runcnt++;
        left = true;
        right = false;
        if (runcnt > 112)
        {
            runcnt = 0;
        }
        runtemp++;
      if (runtemp >= 6)
        {
           x = x - runspeed; 
           runtemp = 0;
        }

        width = character.getWidth();
    }
    
    /**
 * Instructs the character to run right.
 * <p>
 * Increases the Character's horizontal position by its Run Speed every 
 * 6th time the method is called.
 * Includes a counter that increases each time the method is called. 
 * This counter is used
 * in switch cases in the draw method for animation of the Character's
 * movement. 
 */
    public void RunRight() 
    {
        runcnt++;
        right = true;
        left = false;
        if (runcnt > 112)
        {
            runcnt = 0;
        }
        runtemp++;
        if (runtemp >= 6)
        {
           x = x + runspeed; 
           runtemp = 0;
        }

        width = -character.getWidth();
    }
    
    /**
 * Instructs the Character to run in the direction it is currently facing.
 * <p>
 * Decreases/Increases the Character's horizontal position by its Run Speed 
 * every 6th time the method is called.
 * Includes a counter that increases each time the method is called. This
 * counter is used
 * in switch cases in the draw method for animation of the Character's 
 * movement. 
 */
    public void Run() 
    {
        runcnt++;
        if (runcnt > 112)
        {
            runcnt = 0;
        }
        runtemp++;
        if (runtemp >= 6)
        {
           if (facing.equals("right"))
           {
           x = x + runspeed;
           }
           else
           {
           x = x - runspeed;
           }
           runtemp = 0;
        }

    }
    
 /**
 * Instructs the Character to face a direction.
 * <p>
 * Sets direction booleans to true/false.
 * Sets the direction the Character is facing.
 * @param d horizontal direction as a String. If d is not "left", 
 * the direction facing will automatically be right.
 */
   public void FaceDirection(String d)
    {
        if (d.equals("left"))
        {
          left = true; 
          right = false;
        }
        else
        {
          right = true;
          left = false;
        }
        facing = d;

    }
   
 /**
 * Makes the character dash to the right if the dashing boolean is true 
 * (and the character is a character that can dash).
 */
    public void DashRight() 
    {
        if (canDash == true)
        {
        if (dashing == true)
        {
        runtemp++;
        if (runtemp >= 6)
        {
           x = x + runspeed; 
           runtemp = 0;
        }
        }
        }
    }
    
 /**
 * Makes the character dash to the left if the dashing boolean is true 
 * (and the character is a character that can dash).
 */
    public void DashLeft() 
    {
        if (canDash == true)
        {
        if (dashing == true)
        {
        runtemp++;
        if (runtemp >= 6)
        {
           x = x - runspeed; 
           runtemp = 0;
        }
        }
        }
    }
    
 /**
 * Instructs the Character to fire his/her weapon if they have sufficient
 * stamina.
 */
    public void Shoot()
    {
        if (!reloading && !block && !melee)
        {
         shooting = true;  
        }
    }
    
 /**
 * Instructs the Character to perform a melee attack if they have 
 * sufficient stamina.
 * Generates a random number, ma, between 0 and the Character's total
 * different melee-attack animations.
 * The draw method performs the correct melee animation.
 */
    public void MeleeAttack()
    {  if (!shooting)
       {
        if (melee == false)
        {
         ma = (int)(Math.random()*(tma));
        }
        melee = true;
       }
    }
    
 /**
 * Sets the Character into an Idle state.
 * <p>
 * The Character's current image remains fixed as its default, Idle image 
 * while this method is called.
     * @throws java.io.IOException
 */
    public void Idle() throws IOException
    {
        runcnt = -1;
        character = (ImageIO.read(new File("getup7.png"))); 
    }
    
 /**
 * Returns a boolean depending on whether or not the Character is 
 * firing his/her weapon.
     * @return true if the Character is shooting, false if not. 
 */
    public boolean getShooting()
    {
       return shooting;
    }
    
 /**
 * Instructs the Character to cease fire.
 */
    public void StopShooting()
    {
        shootcnt = -1;
        shooting = false;
    }
    
 /**
 * Returns an Integer for the size of the Character's Bullets.
 * @return the Integer for the Bullet's width. 
 */
    public int getBSize()
    {
        return bsize;
    }
    
 /**
 * Returns a boolean representing the Character's current melee state.
 * @return true if the Character is currently performing a melee attack,
 * false if not. 
 */
    public boolean getMelee()
    {
        return melee;
    }
    
 /**
 *Instantly kills the Character.
 */
    public void Kill()
    {
     killedcnt = 0;  
     dead = true;
    }
    
  /**
  *Lowers the Character's health by the amount inputted.
  *Sets the last damage source to be the player number of the
  * source of the damage taken. 
  * @param damage an Integer as health subtracted.
  * @param damagesource an Integer representing the player number.
  */
    public void Damage(int damage, int damagesource)
    {
        if (!block)
        {
        health = health - damage;
        lds = damagesource;
        }
    }
    
     /**
  *Lowers the Character's health by the quotient of the damage 
  * inputted and the Character's armor value.
  *Sets the last damage source to be the player number of the 
  * source of the damage taken. 
  * <p>
  * The Actual Damage dealt is at minimum 1, but also depends 
  * on the damage type.
  * @param damage an Integer as health subtracted.
  * @param damagetype a String representing the type of damage dealt.
  * @param damagesource an Integer representing the player number.
  */
    public void Damage(int damage, String damagetype, int damagesource)
    {
        if (damagetype.equals("pure"))
        {
         health = health - damage;   
        }
        else
        {
            if (!block)
            {
        damage = (int)(damage/armorVal);
        damage = Math.max(damage, 1);
        health = health - damage;
        lds = damagesource;
            }
        }
        
    }
    
  /**
  * Sets the Character's position on the screen.
  * @param v the Vector Co-ordinates.
  */ 
    public void Respawn(Vector v)
    {
        x = v.x;
        y = v.y;
    }
    
  /**
  * Returns an Integer representing the player number of the last
  * damage source.
  * @return a player number.
  */
    public int getLDS()
    {
        return lds;
    }
    
  /**
  * Sets a new Integer representing the player number of the 
  * last damage source.
  * @param DamageSource a player number.
  */
    public void setLDS(int DamageSource)
    {
        lds = DamageSource;
    }
    
  /**
  * Returns the Integer value of the Character's bullet damage.
  * @return a damage Integer.
  */
    public int getBDamage()
    {
        return bdamage;
    }
    
  /**
  * Returns the hit box of the Character.
  * @return a Rectangle, hit box.
  */
    public Rectangle getHbox()
    {
        return hbox;
    }
    
  /**
  * Returns the foot box of the Character.
  * @return a Rectangle2, foot box.
  */
    public Rectangle2 getFootBox()
    {
        return footbox;
    }
    
  /**
  * Paints the foot box of the Character onto the screen.
  * <p>
  * Primarily used for testing purposes.
  * @param g the graphics used to paint.
  * @throws java.io.IOException
  */
    public void drawFootBox(Graphics g) throws IOException
    {
      footbox.draw(g);
    }
    
  /**
  * Returns the Rate at which the Character fires his/her projectiles.
  * @return an Integer, fire rate.
  */
    public int getFireRate()
    {
        return firerate;
    }
    
  /**
  * Returns the vertical range at which the Character's Bullet can spawn.
  * @return an Integer, Bullet Spread.
  */
    public int getBSpread()
    {
        return bspread;
    }
    
  /**
  * Returns the maximum distance that the Character's Bullet can travel.
  * @return an Integer, Range. Measured as distance.
  */
    public int getBRange()
    {
        return brange;
    }
    
  /**
  * Returns the scalar value of the Character's Bullet velocity.
  * @return a scalar Integer, speed.
  */
    public int getBSpeed()
    {
        return bspeed;
    }
    
  /**
  * Returns the current Health of the Character.
  * @return an Integer, health.
  */
    public int getHealth()
    {
        return health;
    }
    
  /**
  * Returns the current state of the Character's special ability.
  * @return true if the Character has his/her Special Activated, false if not.
  */
    public boolean getSpecialActivated()
    {
        return specialactivated;
    }
 
  /**
  * Switches the state of the Character's special ability.
  * <p>
  * If the special is currently activated, the method sets the
  * boolean to be false.
  * If the special is not currently activated, the method sets 
  * the boolean to be true.
  * This will only be true if reloading is false
  */
    public void ToggleSpecial()
    {
        if (specialactivated == true)
        {
        specialactivated = false;
        }
        else 
        {
        specialactivated = true;
        }
       
    }
    
  /**
  * @return the Integer value of the character's shield.  
  */
    public int getShield()
    {
        return shield;
    }
    
  /**
  * Switches the state of the Character's special ability.
  * <p>
  * @param s A string either "ON" or "OFF"
  * Toggles the character's special ability to be either off or on (default).
  */
    public void ToggleSpecial(String s)
    {
        if (s.equals("OFF"))
        {
        specialactivated = false;
        }
        else 
        {
        specialactivated = true;
        }
    }
    
  /**
  * @return the character's name.
  */
    public String getName()
    {
        return name;
    }
    
  /**
  * @return the value of the character's shoot counter.
  */
    public int getShootCnt()
    {
        return shootcnt;
    }
    
  /**
  * @return the value of the character's melee damage.
  */
    public int getMDamage()
    {
        return mdamage;
    }
    
  /**
  * @return the rectangle representing the characters area of effect for
  * their melee attack.
  */
    public Rectangle getMBox()
    {
        return meleebox;
    }
    
    /**
  * @return the value representing the amount of bullets a character 
  * fires per shot.
  */
    public int getBulletAmmount()
    {
        return bammount;
    }
    
  /**
   * Sets the character's hitbox to (0,0,0,0) if death occurs.
   * <p>
   * Should be run throughout the game loop 
  */
    public void ifDeadDie()
    {
        if (dead)
        {
          hbox = new Rectangle(0, 0, 0, 0);
        }
    }
    
  /**
  * Switches the state of the Character's secondary ability
  * (from true to false or false to true).
  * <p>
  * Can only be done if the character is not reloading.
  */
    public void ToggleSecondary()
    {
       if (!reloading)
       {
        if (secondaryactivated == true)
        {
        secondaryactivated = false;
        }
        else 
        {
        secondaryactivated = true;
        }
       }
       
    }
    
  /**
  * Sets the state of the Character's secondary ability on or off..
  * <p>
  * Can only be done if the character is not reloading.
  * Used
     * @param s a string either "ON" or "OFF"
  */
    public void ToggleSecondary(String s)
    {
        if (!reloading)
        {
        if (s.equals("OFF"))
        {
        secondaryactivated = false;
        }
        else 
        {
        secondaryactivated = true;
        }
        }
       
    }
    
  /**
  * Sets the dashing boolean to be true.
  * Must be used in conjunction with the DashLeft() 
  * or DashRight() method so that the character dashes in the
  * correct direction.
  */
    public void Dash() 
    {
        if(canDash == true && !reloading)
        {
        dashing = true;
        stamina = 0;
        }
    }
    
 /**
 * @return true if the character is dashing (else false).
 */
    public boolean getDash()
    {
        return dashing;
    }
    
 /**
 * @return the specific type of bullet that the character fires.
 */
    public String getBulletType()
    {
        return bType;
    }
    
 /**
 * @return value of the character's melee counter.
 */
    public int getMeleeCnt()
    {
        return meleecnt;
    }
    
 /**
 * @return value of the character's melee frequency.
 */
    public int getMeleeFreq()
    {
        return meleefreq;
    }
    
    /**
     * returns the bullet distance interval.
 * @return a value representing the distance between bullets when 
 * multiple bullets are shot at once.
 */
    public int getBulletDistInterval()
    {
        return bdi;
    }
    
    /**
     * Maintains the dimensions of the character.
     * <p>
     * Use in game loop to ensure that the characters proportions 
     * do not alter throughout the program.
 */
    public void maintainCharacterDimensions()
    {
      height = character.getHeight();
      
      if (left == true)
      {
          width = character.getWidth();
      }
      
      if (right == true)
      {
          width = -character.getWidth();
      }           
    }
    
    /**
     * Maintains the fire rate of the character.
     * <p>
     * Use in game loop to ensure that the characters fire rate 
     * does not become altered throughout the program.
 */
    public void maintainFireRate()
    {
        if (shootcnt > firerate + 1)
        {
            shootcnt = 0;
        }
    }
    
    /**
     * Simulates the stamina of the character.
     * <p>
     * Use in game loop to manage stamina usage.
     * (stamina will be used by shooting, dashing, melee and blocking)
     * (once stamina has reached zero, the character will begin reloading).
 */
    public void manageStamina()
    {
        if (shootcnt == firerate)
        {
            stamina = stamina - ammoCost;
        }
        if (stamina <= 0)
        {
            reloading = true;
        }
        if (stamina == kStamina)
        {
            reloading = false;
        }
        if (reloading && !dashing)
        {
        stamina = stamina + staminaregen;
        }
        if (melee)
        {
            stamina = stamina - meleeCost;
        }
        if (block)
        {
            stamina = stamina - meleeCost*2;
        }
        stamina = Math.min(stamina, kStamina);
        stamina = Math.max(stamina, -100);
    }
    
    
      /**
     * Initializes a jump animation for the character.
 */
      public void Jump()
    {
        jumping = true;
        jumpcnt = 0;
       acceleratingVertically = true; 
       fallcnt = 0;
       verticalVelocity = -jumpV;
       fallfreq = cff; 
    }
    
      /**
     * Sets the vertical velocity of a character to a specific value.
     * @param v a value representing velocity.
 */
    public void setVerticalVelocity(int v)
    {
      verticalVelocity = v;
      fVI = 0;
    }
    
    /**
     * @return a value for the vertical velocity of the character.
 */
    public int getVerticalVelocity()
    {
        return verticalVelocity;
    }
    
    /**
     * @return the maximum vertical velocity (downwards).
 */
    public int getTerminalVelocity()
    {
      return terminalV;
    }
    
    /**
     * @return the string representing the characters primary attack type.
 */
    public String getAttackType()
    {
        return atkType;
    }
    
   /**
     * @return the string representing the characters secondary attack type.
 */ 
    public String getAttackType2()
    {
        return atkType2;
    }
    
    /**
     *Simulates the gravity of the character.
     * Use in game loop to give the character the ability to 
     * jump and fall with 
     * acceleration due to gravity.
     * @param gravityMultiplier a value (double) that is used
     * as a multiplier for the characters falling speed.
 */
    public void simulateGravity(double gravityMultiplier)
    {
         if (!dead)
           {  
            fallcnt++;
            fVIcnt++;
            if (fallcnt >= fallfreq)
            {
            verticalVelocity++; 
            fallcnt = 0;
            }
            if (fVIcnt >= 500)
            {
            fVI++; 
            fVIcnt = 0;
            }
            if (verticalVelocity == (int)(terminalV*gravityMultiplier))
            {
              fallcnt = 0;
              acceleratingVertically = false;
            }
           }
         
         
        verticalVelocity = Math.max(-(int)(jumpV*gravityMultiplier),
                verticalVelocity);
        verticalVelocity = Math.min((int)(terminalV*gravityMultiplier),
                verticalVelocity);
        y = y + verticalVelocity + fVI;
    }
    
 /**
 Reset the variables that are used in simulating gravity.
 * <p>
 * Use when a character's footbox intersects the floor.
 */
    public void Land()
    {
      fVI = 0; 
      fVIcnt = 0;
      jumping = false;
      jumpcnt = 0;
    }
    
 /**
 * @return the image of the character's bullet they are currently using.
 */
    public BufferedImage getBulletImage() 
    {
        if (bulletnum == 1)
        {
        return bullet1;
        }
        else
        {
            return bullet2;
        }
    }
    
    /**
 * @return the co-ordinates of the gun's barrel 
 * (i.e where the bullet will shoot from).
 */
    public Vector getGunVector()
    {
       Vector gv = new Vector(gunx, guny);
       return gv;
    }
    
 /**
 * @return a string representing 
 * the direction the character is facing currently.
 */
    public String getDirectionFacing()
    {
        return facing;
    }
    
    /**
 * @return the maximum health of the character. 
 */
    public int getMaxHealth()
    {
        return kHealth;
    }
    
     /**
     * @param g graphics used in the game loop.
     * Use in the game loop to draw the character's hidden rectangles and
     * rectangle2's in for testing purposes.
     * @throws java.io.IOException
 */
    public void drawTestingBoxes(Graphics g) throws IOException
    {
        g.setColor(Color.GREEN);
        meleebox.draw(g);
        g.setColor(Color.CYAN);
        footbox.draw(g);
        g.setColor(Color.ORANGE);
        Rectangle2 hb = new Rectangle2(hbox);
        hb.draw(g);   
    }
    
    /**
     * @return true if the character is a hero, else false.
 */
    public boolean getHeroStatus()
    {
        return hero;
    }
    
    /**
     * @return true if the character is busy jumping, else false.
 */
    public boolean getJumping()
    {
        return jumping;
    }
    
     /**
      * Initiates a blocking sequence in the draw method
      * by setting the character's boolean "block"
      * to be true.
 */
    public void Block()
    { 
          if(!shooting && !melee && !reloading)
          {
          block = true; 
          blockcnt = 0;
          }
    }
    
     /**
     * @return true if the character is busy blocking, else false.
 */
    public boolean getBlock()
    {
        return block;
    }
    
 /**
 * @param n the number representing which taunt sound you are wanting to get.
 * (from 0 to 2)
 * <p>
 * (Characters have at max 3 taunt sounds.
 * @return a string representing the file path for the 
 * character's taunt sound.
 */
    public String getTauntSound(int n)
    {
        String s = "";
      switch (n)
      {
          case 0: s = ts1;
          break;
          case 1: s = ts2;
          break;
          case 2: s = ts3;
          break;
          default: s = ts1;
      }
      return s;
    }
    
     /**
     * @return the value representing the 
     * total amount of taunt sounds a character has.
 */
    public int getTotalTauntSounds()
    {
        return totaltauntsounds;
    }
    
     /**
     * @return the vector representing the character's co-ordinates.
 */
    public Vector V()
    {
        Vector v = new Vector(x,y);
        return v;
    }
    
     /**
     * @return true if the character is busy reloading, else false.
 */
    public boolean getReloading()
    {
        return reloading;
    }

}
