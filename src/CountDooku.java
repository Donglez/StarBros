
package starbrosgame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CountDooku extends Character
{
    private int f = 0;
    private boolean maalo[] = new boolean[4];
    CountDooku() throws IOException 
    {
        atkType = "melee";
        atkType2 = "shoot";
        bType = "force";
        canDash = true;
        tma = 3;
        name = "CountDooku";
        mdamage = 8;
        brange = 1300;
        ammoCost = 2000;
        meleeCost = 10;
        bdamage = 250;
        bspeed = 5;
        firerate = 132;
        health = 950;
        kHealth = health;
        bsize = 32;
        runspeed = 6;
        cff = 19;
        regenfreq = 80;
        character = (ImageIO.read(new File("pose1.png")));
        width = character.getWidth();
        height = character.getHeight();
        hbox = new Rectangle(x, y, width, height);
        bullet1 = (ImageIO.read(new File("forceb.png")));
        hero = true;
        staminaregen = 42;
    }
    
    @Override
    public void draw(Graphics g) throws IOException
    {
        
        if (health <= 0)
        {
            dead = true;
        }
        if (dead == false)
        {
        runspeed = 6;
        
        if (combo)
        {
         mdamage = 10;
        }
        else
        {
            mdamage = 8;
        }
        regencnt++;
           if(regencnt >= regenfreq)
           {
              health = health + 1;
              health = Math.min(health, kHealth);
              regencnt = 0;
           }
           
           if (maalo[0] == true && maalo[1] == true && maalo[2] == true)
           {
               tma = 4;
           }
        
        if (melee == true && dashing == false)
        { 
            maalo[ma] = true;
            meleecnt++;
            
            if (ma == 0)
            {
                meleefreq = 157;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("large slash1.png")));
        break;
        case 13: character = (ImageIO.read(new File("large slash2.png")));
        break;
        case 26: character = (ImageIO.read(new File("large slash3.png")));
        break;
        case 39: character = (ImageIO.read(new File("large slash4.png")));
        break;
        case 52: character = (ImageIO.read(new File("large slash5.png")));
        break;
        case 65: character = (ImageIO.read(new File("large slash6.png"))); 
        if (right){x = x + 5;} if (left){x = x - 5;}
        break;
        case 78: character = (ImageIO.read(new File("large slash7.png")));
        if (right){x = x + 5;} if (left){x = x - 5;}
        break;
        case 91: character = (ImageIO.read(new File("large slash8.png")));
        if (right){x = x + 5;} if (left){x = x - 5;}
        break;
        case 104: character = (ImageIO.read(new File("large slash9.png")));
        if (right){x = x + 5;} if (left){x = x - 5;}
        break;
        case 117: character = (ImageIO.read(new File("large slash10.png")));
        break;
        case 130: character = (ImageIO.read(new File("large slash11.png")));
        if (right){x = x - 10;} if (left){x = x + 10;}
        break;
        case 143: character = (ImageIO.read(new File("large slash13.png")));
        if (right){x = x - 10;} if (left){x = x + 10;}
        break;
        case 156: character = (ImageIO.read(new File("stand3light8.png")));
                  
        break;
        case 157: meleecnt = 0;
                  melee = false;
                         
        break;
        
        }
            }
            
            if (ma == 1)
            {
                meleefreq = 157;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("slash1.png")));
        break;
        case 13: character = (ImageIO.read(new File("slash2.png")));
        break;
        case 26: character = (ImageIO.read(new File("slash3.png")));
        break;
        case 39: character = (ImageIO.read(new File("slash4.png")));
        break;
        case 52: character = (ImageIO.read(new File("slash5.png")));
        break;
        case 65: character = (ImageIO.read(new File("slash6.png"))); 
        if (right){x = x + 5;} if (left){x = x - 5;}
        break;
        case 78: character = (ImageIO.read(new File("slash7.png")));
        if (right){x = x + 5;} if (left){x = x - 5;}
        break;
        case 91: character = (ImageIO.read(new File("slash8.png")));
        if (right){x = x + 5;} if (left){x = x - 5;}
        break;
        case 104: character = (ImageIO.read(new File("slash9.png")));
        if (right){x = x + 5;} if (left){x = x - 5;}
        break;
        case 117: character = (ImageIO.read(new File("slash10.png")));
        break;
        case 130: character = (ImageIO.read(new File("slash11.png")));
        if (right){x = x - 10;} if (left){x = x + 10;}
        break;
        case 143: character = (ImageIO.read(new File("slash13.png")));
        if (right){x = x - 10;} if (left){x = x + 10;}
        break;
        case 156: character = (ImageIO.read(new File("stand3light8.png")));
                  
        break;
        case 157: meleecnt = 0;
                  melee = false;
                         
        break;
        
        }
            }
            
            if (ma == 2)
            {
                meleefreq = 157;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("strike1.png")));
        break;
        case 13: character = (ImageIO.read(new File("strike2.png")));
        break;
        case 26: character = (ImageIO.read(new File("strike3.png")));
        break;
        case 39: character = (ImageIO.read(new File("strike4.png")));
        break;
        case 52: character = (ImageIO.read(new File("strike5.png")));
        break;
        case 65: character = (ImageIO.read(new File("strike6.png"))); 
        if (right){x = x + 10;} if (left){x = x - 10;}
        break;
        case 78: character = (ImageIO.read(new File("strike7.png")));
        if (right){x = x + 10;} if (left){x = x - 10;}
        break;
        case 91: character = (ImageIO.read(new File("strike8.png")));
        if (right){x = x + 10;} if (left){x = x - 10;}
        break;
        case 104: character = (ImageIO.read(new File("strike9.png")));
        if (right){x = x + 10;} if (left){x = x - 10;}
        break;
        case 117: character = (ImageIO.read(new File("strike10.png")));
        break;
        case 130: character = (ImageIO.read(new File("strike11.png")));
        if (right){x = x - 20;} if (left){x = x + 20;}
        break;
        case 143: character = (ImageIO.read(new File("strike12.png")));
        if (right){x = x - 20;} if (left){x = x + 20;}
        break;
        case 156: character = (ImageIO.read(new File("stand3light8.png")));
                 
        break;
        case 157: meleecnt = 0;
                  melee = false;
                         
        break;
        
        }
            }
            
              if (maalo[0] == true && maalo[1] == true && maalo[2] == true
                      && ma == 3)
            {
                combo = true;
                meleefreq = 346;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("combination1.png")));
        break;
        case 20: character = (ImageIO.read(new File("combination2.png")));
        break;
        case 40: character = (ImageIO.read(new File("combination3.png")));
        break;
        case 60: character = (ImageIO.read(new File("combination4.png")));
        break;
        case 80: character = (ImageIO.read(new File("combination5.png")));
        break;
        case 100: character = (ImageIO.read(new File("combination6.png"))); 
        break;
        case 120: character = (ImageIO.read(new File("combination7.png")));
        break;
        case 140: character = (ImageIO.read(new File("combination8.png")));
        break;
        case 160: character = (ImageIO.read(new File("combination9.png")));
        break;
        case 180: character = (ImageIO.read(new File("combination10.png")));
        break;
        case 200: character = (ImageIO.read(new File("combination11.png")));
        break;
        case 220: character = (ImageIO.read(new File("combination12.png")));
        break;
        case 240: character = (ImageIO.read(new File("combination13.png")));
        if (right){x = x + 20;} if (left){x = x - 20;}
        break;
        case 260: character = (ImageIO.read(new File("combination14.png")));
        if (right){x = x + 20;} if (left){x = x - 20;}
        break;
        case 280: character = (ImageIO.read(new File("combination15.png")));
        if (right){x = x + 20;} if (left){x = x - 20;}
        break;
        case 300: character = (ImageIO.read(new File("combination16.png")));
        break;
        case 315: character = (ImageIO.read(new File("combination17.png")));
        if (right){x = x - 30;} if (left){x = x + 30;}
        break;
        case 330: character = (ImageIO.read(new File("combination18.png")));
        if (right){x = x - 30;} if (left){x = x + 30;}
        break;
        case 345: character = (ImageIO.read(new File("stand3light8.png")));
                 
        break;
        case 346: meleecnt = 0;
                  melee = false;
                  
                  combo = false;
                  for (int i = 0; i < tma; i++)
                  {
                      maalo[i] = false;
                  }
                  tma = 3;
        break;
        
        }
            }
        }

        if (melee == false && dashing == false && block == false && 
                shooting == false)
        {
            
        switch (runcnt)
        {
        case 0: character = (ImageIO.read(new File("Dwalk1.png")));
        break;
        case 14: character = (ImageIO.read(new File("Dwalk2.png")));
        break;
        case 28: character = (ImageIO.read(new File("Dwalk3.png")));
        break;
        case 42: character = (ImageIO.read(new File("Dwalk4.png")));
        break;
        case 56: character = (ImageIO.read(new File("Dwalk5.png")));
        break;
        case 70: character = (ImageIO.read(new File("Dwalk6.png")));
        break;
        case 84: character = (ImageIO.read(new File("Dwalk7.png")));
        break;
        case 98: character = (ImageIO.read(new File("Dwalk8.png")));
        break;
        case 112: character = (ImageIO.read(new File("Dwalk9.png")));
        break;
        case 126: character = (ImageIO.read(new File("walk10.png")));
        break;
        case 140: character = (ImageIO.read(new File("walk11.png")));
        break;
        case 154: character = (ImageIO.read(new File("walk12.png")));
        break;
        
        }
        }
        
        if (block == true && melee == false)
        { 
        runspeed = 2;
        switch (blockcnt)
        {
        case 0: character = (ImageIO.read(new File("block1.png")));
        break;
        case 20: character = (ImageIO.read(new File("block2.png")));
        break;
        case 40: character = (ImageIO.read(new File("block3.png")));
        break;
        case 60: character = (ImageIO.read(new File("block2.png")));
        break;
        case 80: character = (ImageIO.read(new File("block1.png")));
        break;
        case 90: blockcnt = 0;
                 character = (ImageIO.read(new File("stand3light8.png")));
                 block = false;
        }
        blockcnt++;
        }
        
        if (shooting == true)
       {
        
        
           firerate = 132;
       switch (shootcnt)
       {
       case 0: character = (ImageIO.read(new File("force1.png")));
       break;
       case 12: character = (ImageIO.read(new File("force2.png")));
       break;
       case 24: character = (ImageIO.read(new File("force3.png")));
       break;
       case 36: character = (ImageIO.read(new File("force4.png")));
       break;
       case 48: character = (ImageIO.read(new File("force5.png")));
       break;
       case 60: character = (ImageIO.read(new File("force6.png")));
       break;
       case 72: character = (ImageIO.read(new File("force7.png")));
       break;
       case 84: character = (ImageIO.read(new File("force8.png")));
       break;
       case 96: character = (ImageIO.read(new File("force9.png")));
       break;
       case 108: character = (ImageIO.read(new File("force10.png")));
       break;
       case 120: character = (ImageIO.read(new File("force11.png")));
       break;
       case 132: character = (ImageIO.read(new File("force12.png")));
       break;
       }
        

       runspeed = 0;
       shootcnt++;
       }
        if (shootcnt == firerate + 1)
        {
            shootcnt = 0;
            shooting = false;
        }
        
        if (dashing == true)
        {
          verticalVelocity = 0;
          mdamage = 7;
          runspeed = 18;  
        switch (dashcnt)
        {
        case 0: character = (ImageIO.read(new File("glide1.png")));
        break;
        case 10: character = (ImageIO.read(new File("glide2.png")));
        break;
        case 20: character = (ImageIO.read(new File("glide1.png")));
        break;
        case 30: character = (ImageIO.read(new File("glide2.png")));
        break;
        case 100: character = (ImageIO.read(new File("glide1.png")));
        break;
        case 111: dashcnt = -1;
                 dashing = false;
        break;
        }
        dashcnt++;
        
        }
        
        if (runcnt >= 168)
        {
            runcnt = 0;
        }
        height = character.getHeight(); 
        if (right == true)
        {
            width = -character.getWidth();
            if((meleecnt > 80 && meleecnt <= 135) || (dashing == true &&
                    meleecnt > 30 && meleecnt <= 150))
            {
             g.setColor(Color.GREEN);
             meleebox = new Rectangle2(x-width/2-45,y,character.getWidth()
                     +15,height);
            }
            else
            {
             meleebox = new Rectangle2(); 
            }
            if (combo && ((meleecnt > 20 && meleecnt < 140) || (meleecnt > 240
                    && meleecnt < 360)))
            {
              g.setColor(Color.RED);
              meleebox = new Rectangle2(x-width/2-45,y,character.getWidth()+25
                      ,height + 10);  
            }
            else
            {
             if (combo == true)
             {
             meleebox = new Rectangle2();
             }
            }
        g.drawImage(character, x + width/2 - f, y, -width, height, null);
        hbox = new Rectangle(x+width/2,y,character.getWidth() - 5,height);
        gunx = x+width/2 - width - 10;
        guny = y+(int)((2*height)/5) - 23;
        footbox = new Rectangle2(x+width/2,y + height - 15,
                character.getWidth(),16);
        g.setColor(Color.BLUE);
        }
        
        if (left == true)
        {
            width = character.getWidth();
            if(meleecnt > 80 && meleecnt <= 135 && !combo)
            {   
             g.setColor(Color.GREEN);
             meleebox = new Rectangle2(x-width - width/3 + 22 ,y,
                     character.getWidth() + 15,height);
            }
            else
            {
             meleebox = new Rectangle2(); 
            }
            if (combo && ((meleecnt > 20 && meleecnt < 140) || 
                    (meleecnt > 240 && meleecnt < 360)))
            {
              g.setColor(Color.RED);
              meleebox = new Rectangle2(x-width - width/3 + 22 ,
                      y,character.getWidth() + 25,height + 10);  
            }
            else
            {
             if (combo == true)
             {
             meleebox = new Rectangle2();
             }
            }
        g.drawImage(character, x + width/2 + f, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        gunx = x - width + 14;
        guny = y+(int)((2*height)/5) - 23;
        footbox = new Rectangle2(x-width/3,y + height - 15,
                character.getWidth(),16);
        g.setColor(Color.BLUE);

        }
        
        }
        
        else
        {
            
          if (killedcnt <= 390)
          {
              killedcnt++;
             
          switch (killedcnt)
         {
        case 0: character = (ImageIO.read(new File("dieA1.png"))); 
                y = y + 14;
        break;
        case 30: character = (ImageIO.read(new File("dieA2.png"))); 
                 y = y - 5;
        break;
        case 60: character = (ImageIO.read(new File("dieA3.png")));          
        break;
        case 90: character = (ImageIO.read(new File("dieA4.png"))); 
        break;
        case 120: character = (ImageIO.read(new File("dieA5.png"))); 
        break;
        case 150: character = (ImageIO.read(new File("dieA6.png"))); 
                  y = y + 3;
        break;
        case 180: character = (ImageIO.read(new File("dieA7.png")));     
        break;
        case 210: character = (ImageIO.read(new File("dieA8.png")));          
        break;
        case 240: character = (ImageIO.read(new File("dieA9.png")));          
        break;
        case 270: character = (ImageIO.read(new File("dieA10.png")));
                  y = y + 14;
        break;
        case 300: character = (ImageIO.read(new File("dieA11.png")));          
        break;
        
         }
           height = character.getHeight(); 
          if (right == true)
        {
        width = -character.getWidth();
        g.drawImage(character, x + width/2, y, -width, height, null); 
        }
          
          if ((right == false) || (left == true))
        {
        width = character.getWidth();
        g.drawImage(character, x + width/2, y, -width, height, null);
        }
         }
       }
    }
    
    public void Idle() throws IOException
    {
        runcnt = -1;
        character = (ImageIO.read(new File("stand3light8.png")));
        height = character.getHeight();
        shooting = false;
        
    }
    
    public void RunLeft()
    {
        if (dashing == false && shooting == false && dead == false)
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
        
        if (shooting == true)
        {
          left = true;
          right = false; 
        }
       

       
    }
    
    public void RunRight() 
    {
      if (dashing == false && shooting == false && dead == false)
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
      
      if (shooting == true)
        {
          left = false;
          right = true; 
        }
    }
  
    }
    


