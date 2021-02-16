package starbrosgame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Droideka extends Character
{
    private int n = 0;
    private int z = 0;
    private int m = 0;
    Droideka() throws IOException 
    {
        name = "Droideka";
        pColor = Color.RED;
        sColor = new Color(160, 50, 0);
        firerate = 65;
        ammoCost = 6000;
        staminaregen = 140;
        bdamage = 120;
        brange = 300;
        health = 80;
        regenfreq = 12;
        kHealth = health;
        bsize = 32;
        runspeed = 2;
        bspeed = 5;
        verticalVelocity = 2;
        cff = 11;
        specialcooldown = 0;
        character = (ImageIO.read(new File("DDshoot9.png")));
        width = character.getWidth();
        height = character.getHeight();
        hbox = new Rectangle(x, y, width, height);
        bullet1 = (ImageIO.read(new File("redbolt.png")));
        bdi = 2;
        bammount = 2;
    }
    
    public void draw(Graphics g) throws IOException
    {
        
        if (health <= 0)
        {
            dead = true;
        }
        if (dead == false)
        {
        if (n >= 1600)
        {
          specialactivated = false;
        }
        
            
        
        regencnt++;
           if(regencnt >= regenfreq)
           {
              health = health + 1;
              health = Math.min(health, kHealth);
              regencnt = 0;
           }
        if (!specialactivated)
        {
            n--;
            n = Math.max(n, 0);
            
        }
        
        if (specialactivated)
        {
            m++;
            if (m >= 2)
            {
            n++;
            m = 0;
            }
        }
        
        
        if (specialactivated == true && secondaryactivated == false &&
                secondarycnt == -1 )
        {   
            //SHIELD ON
            bdamage = 120;
            brange = 300;
            bsize = 32;
            runspeed = 0;
            firerate = 50;
            cff = 11;
            specialcnt++;
            specialcnt = Math.min(specialcnt, 70);
            bspeed = 4;
            
            g.setColor(Color.CYAN);
            if (left == true)
            {
              g.fillRect(x+width/2,y - 24,160 - n/10,4);          
            }
            else
            {
              g.fillRect(x-width/2,y - 24,160 - n/10,4);
            }
              
        }
        if (specialactivated == false && secondarycnt == -1 && specialcnt >= 0)
        {
            //SHIELD OFF
            cff = 11;
          
           specialcnt--;
           specialcnt = Math.max(specialcnt, -1);
           runspeed = 2;
           stamina = stamina + 5;
           firerate = 50;
           bspeed = 4;
           bdamage = 120;
           brange = 300;
           bsize = 32;
           
        }
        if (secondaryactivated == false && secondarycnt == -1)
        {
            switch (specialcnt)
        {
        case 0: character = (ImageIO.read(new File("DDshoot9.png")));
        break;
        case 1: character = (ImageIO.read(new File("DDshield1.png")));
        break;
        case 14: character = (ImageIO.read(new File("DDshield2.png")));
        break;
        case 28: character = (ImageIO.read(new File("DDshield3.png")));
        break;
        case 42: character = (ImageIO.read(new File("DDshield4.png")));
        break;
        case 56: character = (ImageIO.read(new File("DDshield5.png")));
        break;
        }
        }
            
            
            
            if (secondaryactivated == true && specialactivated == false && 
                    specialcnt == -1 && secondarycnt <= 30)
        {
            //ROLLING UP
            cff = 0;
            runspeed = 0;
            firerate = 10;
            bsize = 0;
            brange = 0;
            secondarycnt++;
            secondarycnt = Math.min(secondarycnt, 31);
            bspeed = 0;
            shootcnt = 0;
   
        }
        if (secondaryactivated == false && specialactivated == false && 
                secondarycnt >= 0 && specialcnt == -1)
        {  
           //UNROLLING
           cff = 0;
           runspeed = 0;
           firerate = 10;
           bsize = 0;
           brange = 0;
           shootcnt = 0;
           
           secondarycnt--;
           secondarycnt = Math.max(secondarycnt, -1); 
           bspeed = 0;

        }
        if (specialactivated == false && specialcnt == -1)
        {
            switch (secondarycnt)
        {
        case 30: character = (ImageIO.read(new File("DDroll1.png")));
        break;        
        case 20: character = (ImageIO.read(new File("DDunroll1.png")));
        break;
        case 10: character = (ImageIO.read(new File("DDunroll2.png")));
        break;
        case 0: character = (ImageIO.read(new File("DDunroll3.png")));
        break;
        }
        }
    
        
        
        if (specialactivated == false && specialcnt == -1 && 
                secondaryactivated == true && secondarycnt >= 30)
        {
         z = 10;
        switch (runcnt)
        {
        case 0: character = (ImageIO.read(new File("DDroll1.png")));
        break;
        case 5: character = (ImageIO.read(new File("DDroll2.png")));
        break;
        case 10: character = (ImageIO.read(new File("DDroll3.png")));
        break;
        }
        if (runcnt >= 15)
        {
            runcnt = 0;
        }
        runspeed = 10;
        cff = 12;
        shootcnt = 0;
        stamina = stamina + 4;
        
        }
        
        if (secondaryactivated == false && secondarycnt == -1 && 
                specialcnt == -1)
        {
           
           specialcnt--;
           specialcnt = Math.max(specialcnt, -1);
           runspeed = 2;
           firerate = 50; 
           bspeed = 4;
           cff = 11;
           bdamage = 120;
           brange = 300;
           bsize = 32;
           
        switch (runcnt)
        {
        case 0: character = (ImageIO.read(new File("DDwalk1.png")));
        break;
        case 14: character = (ImageIO.read(new File("DDwalk2.png")));
        break;
        case 28: character = (ImageIO.read(new File("DDwalk3.png")));
        break;
        case 42: character = (ImageIO.read(new File("DDwalk4.png")));
        break;
        case 56: character = (ImageIO.read(new File("DDwalk5.png")));
        break;
        case 70: character = (ImageIO.read(new File("DDwalk6.png")));
        break;
        }
        if (runcnt >= 84)
        {
            runcnt = 0;
        }
        }
        
        if (shooting)
        {
          shootcnt++;
        }
        if (shootcnt == firerate+1)
        {
            shootcnt = 0;
            shooting = false;
        }
        
       
        height = character.getHeight();
        g.drawImage(character, x + width/2, y, -width, height, null);
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        if (left == true)
        {
            
        width = -character.getWidth();
        g.drawImage(character, x + width/2, y, -width, height, null);
        hbox = new Rectangle(x+width/2,y,character.getWidth(),height);
        gunx = x-width/2 + width;
        guny = y+(int)((2*height)/5) + 3;
        footbox = new Rectangle2(x+width/2,y + height - 8,
                character.getWidth(),12+z);
        g.setColor(Color.BLUE);
        }
        
        if (right == true)
        {
        width = character.getWidth();
        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/2,y,character.getWidth(),height);
        gunx = x + width/3;
        guny = y+(int)((2*height)/5) + 3;
        footbox = new Rectangle2(x-width/2,y + height - 8,
                character.getWidth(),12+z);
        g.setColor(Color.BLUE);
        }
        
        }
        
        else
        {
            
          if (killedcnt <= 162)
          {
              killedcnt++;
          
          switch (killedcnt)
         {
        case 0: character = (ImageIO.read(new File("DDdie1.png"))); 
        break;
        case 15: character = (ImageIO.read(new File("DDdie2.png"))); 
        break;
        case 30: character = (ImageIO.read(new File("DDdie3.png"))); 
        break;
        case 45: character = (ImageIO.read(new File("DDdie4.png"))); 
        break;
        case 60: character = (ImageIO.read(new File("DDdie5.png"))); 
        break;
        case 75: character = (ImageIO.read(new File("DDdie6.png"))); 
        break;
        case 90: character = (ImageIO.read(new File("DDdie7.png"))); 
        break;
        case 98: character = (ImageIO.read(new File("DDdie10.png"))); 
        break;
        case 106: character = (ImageIO.read(new File("DDdie11.png"))); 
        break;
        case 114: character = (ImageIO.read(new File("DDdie12.png"))); 
        break;
        case 122: character = (ImageIO.read(new File("DDdie13.png"))); 
        break;
        case 130: character = (ImageIO.read(new File("DDdie14.png"))); 
        break;
        case 138: character = (ImageIO.read(new File("DDdie15.png"))); 
        break;
        case 146: character = (ImageIO.read(new File("DDdie16.png"))); 
        break;
        case 154: character = (ImageIO.read(new File("DDdie17.png"))); 
        break;
        
         }
          height = character.getHeight();
          if (right == true)
        {
        width = character.getWidth();
        g.drawImage(character, x + width/2, y, -width, height, null); 
        }
          
          if ((right == false) || (left == true))
        {
        width = -character.getWidth();
        g.drawImage(character, x + width/2, y, -width, height, null);
        }
         }
       }
       verticalVelocity = Math.max(-4,verticalVelocity);
       verticalVelocity = Math.min(4,verticalVelocity);
    }
    
    public void Idle() throws IOException
    {
        runcnt = -1;
        if (specialactivated == false && secondaryactivated == false && 
                secondarycnt == -1 && specialcnt == -1)
        {
        character = (ImageIO.read(new File("DDshoot9.png"))); 
        }
    }
    
    public void Damage(int damage, String damagetype, int damagesource)
    {
        if (specialactivated == false)
        {
        health = health - damage;
        }

        n = n + damage;
        
        lds = damagesource;
    }
    
    public void Damage(int damage, int damagesource)
    {
        if (specialactivated == false)
        {
        health = health - damage;
        }
        n = n + damage;
        lds = damagesource;
    }
    
    public void RunLeft()
    {
        runcnt++;
        left = true;
        right = false;
       
        runtemp++;
      if (runtemp >= 6)
        {
           x = x - runspeed; 
           runtemp = 0;
        }

       
    }
    
    public void RunRight() 
    {
        runcnt++;
        right = true;
        left = false;
        
        runtemp++;
        if (runtemp >= 6)
        {
           x = x + runspeed; 
           runtemp = 0;
        }

        
    }
    
    public void ToggleSpecial()
    {
       if(secondaryactivated == false && secondarycnt == -1)
       {
        if (specialactivated == true)
        {
        specialactivated = false;
        }
        else if (n < 800)
        {
        specialactivated = true;
        }
       }
    }
    
    public void ToggleSpecial(String s)
    {
       if(secondaryactivated == false && secondarycnt == -1)
       {
        if (s.equals("OFF"))
        {
        specialactivated = false;
        }
        else if (s.equals("ON") && n < 800)
        {
        specialactivated = true;
        }
       }
    }
    
    public void ToggleSecondary()
    {
       if(specialactivated == false && specialcnt == -1)
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
    
    public int getShield()
    {
        shield = 1600 - n;
        return shield;
    }
    
    public void ToggleSecondary(String s)
    {
       if(specialactivated == false && specialcnt == -1)
       {
        if (s.equals("OFF"))
        {
        secondaryactivated = false;
        }
        else if (s.equals("ON"))
        {
        secondaryactivated = true;
        }
       }
    }
    
     public void maintainCharacterDimensions()
    {
      height = character.getHeight();
      
      if (left == true)
      {
          width = -character.getWidth();
      }
      
      if (right == true)
      {
          width = character.getWidth();
      }
              
    }
     
    
}
