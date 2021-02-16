package starbrosgame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Anakin extends Character
{
    private int f = 0;
    private boolean maalo[] = new boolean[4];
    Anakin() throws IOException 
    {
        atkType = "melee";
        atkType2 = "shoot";
        bType = "force";
        tma = 3;
        name = "Anakin";
        mdamage = 8;
        brange = 1350;
        ammoCost = 2000;
        meleeCost = 5;
        bdamage = 250;
        bspeed = 5;
        firerate = 132;
        health = 850;
        kHealth = health;
        bsize = 32;
        runspeed = 6;
        cff = 22;
        regenfreq = 80;
        character = (ImageIO.read(new File("Anakin (11).png")));
        idleImage = (ImageIO.read(new File("Anakin (11).png")));
        width = character.getWidth();
        height = character.getHeight();
        hbox = new Rectangle(x, y, width, height);
        bullet1 = (ImageIO.read(new File("forceb.png")));
        hero = true;
    }
    
    public void draw(Graphics g) throws IOException
    {
        
        if (health > 0)
        {
        runspeed = 6;
        if (combo)
        {
         mdamage = 12;
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
        
        if (melee == true)
        {
            maalo[ma] = true;
            meleecnt++;
            
            if (ma == 0)
            {
                meleefreq = 160;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("Anakin (13).png")));
        break;
        case 20: character = (ImageIO.read(new File("Anakin (14).png")));
        break;
        case 40: character = (ImageIO.read(new File("Anakin (15).png")));
        break;
        case 60: character = (ImageIO.read(new File("Anakin (16).png")));
        break;
        case 80: character = (ImageIO.read(new File("Anakin (17).png")));
        break;
        case 100: character = (ImageIO.read(new File("Anakin (18).png"))); 
        break;
        case 120: character = (ImageIO.read(new File("Anakin (19).png")));
        break;
        case 140: character = (ImageIO.read(new File("Anakin (21).png")));
        break;
        case 160: meleecnt = 0;
                  melee = false;
                         
        break;
        
        }
            }
            
            if (ma == 1)
            {
                meleefreq = 140;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("Anakin (13).png")));
        break;
        case 20: character = (ImageIO.read(new File("Anakin (28).png")));
        break;
        case 40: character = (ImageIO.read(new File("Anakin (29).png")));
        break;
        case 60: character = (ImageIO.read(new File("Anakin (30).png")));
        break;
        case 80: character = (ImageIO.read(new File("Anakin (31).png")));
        break;
        case 100: character = (ImageIO.read(new File("Anakin (32).png"))); 
        break;
        case 120: character = (ImageIO.read(new File("Anakin (33).png")));
        break;
        case 140: meleecnt = 0;
        melee = false;
        break;
        
        }
            }
            
            if (ma == 2)
            {
                meleefreq = 200;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("Anakin (108).png")));
        break;
        case 20: character = (ImageIO.read(new File("Anakin (109).png")));
        break;
        case 40: character = (ImageIO.read(new File("Anakin (110).png")));
        break;
        case 60: character = (ImageIO.read(new File("Anakin (111).png")));
        break;
        case 80: character = (ImageIO.read(new File("Anakin (112).png")));
        break;
        case 100: character = (ImageIO.read(new File("Anakin (113).png"))); 
        break;
        case 120: character = (ImageIO.read(new File("Anakin (114).png")));
        break;
        case 140: character = (ImageIO.read(new File("Anakin (115).png")));
        break;
        case 160: character = (ImageIO.read(new File("Anakin (116).png")));
        break;
        case 180: character = (ImageIO.read(new File("Anakin (117).png")));
        break;
        case 200: meleecnt = 0;
                  melee = false;
                         
        break;
        
        }
            }
            
              if (maalo[0] == true && maalo[1] == true 
                      && maalo[2] == true && ma == 3)
            {

                combo = true;
                meleefreq = 500;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("Anakin (44).png")));
        break;
        case 20: character = (ImageIO.read(new File("Anakin (45).png")));
        break;
        case 40: character = (ImageIO.read(new File("Anakin (46).png")));
        break;
        case 60: character = (ImageIO.read(new File("Anakin (47).png")));
        break;
        case 80: character = (ImageIO.read(new File("Anakin (48).png")));
        break;
        case 100: character = (ImageIO.read(new File("Anakin (49).png"))); 
        break;
        case 120: character = (ImageIO.read(new File("Anakin (50).png")));
        break;
        case 140: character = (ImageIO.read(new File("Anakin (51).png")));
        break;
        case 160: character = (ImageIO.read(new File("Anakin (52).png")));
                  y = y - 20;
        break;
        case 180: character = (ImageIO.read(new File("Anakin (53).png")));
        break;
        case 200: character = (ImageIO.read(new File("Anakin (54).png")));
        break;
        case 220: character = (ImageIO.read(new File("Anakin (55).png")));
        break;
        case 240: character = (ImageIO.read(new File("Anakin (56).png")));
        break;
        case 260: character = (ImageIO.read(new File("Anakin (57).png")));
        break;
        case 280: character = (ImageIO.read(new File("Anakin (58).png")));
        break;
        case 300: character = (ImageIO.read(new File("Anakin (59).png")));
        break;
        case 320: character = (ImageIO.read(new File("Anakin (60).png")));
        break;
        case 340: character = (ImageIO.read(new File("Anakin (61).png")));
        break;
        case 360: character = (ImageIO.read(new File("Anakin (62).png"))); 
        break;
        case 380: character = (ImageIO.read(new File("Anakin (63).png")));     
        break;
        case 400: character = (ImageIO.read(new File("Anakin (64).png")));      
        break;
        case 420: character = (ImageIO.read(new File("Anakin (65).png")));     
        break;
        case 440: character = (ImageIO.read(new File("Anakin (66).png")));   
        break;
        case 460: character = (ImageIO.read(new File("Anakin (67).png")));   
        break;
        case 480: character = (ImageIO.read(new File("Anakin (68).png")));   
        break;
        case 500: meleecnt = 0;
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
        
        if (melee == false && block == false && shooting == false)
        {
            
        switch (runcnt)
        {
        case 0: character = (ImageIO.read(new File("Anakin (172).png")));
        break;
        case 14: character = (ImageIO.read(new File("Anakin (173).png")));
        break;
        case 28: character = (ImageIO.read(new File("Anakin (174).png")));
        break;
        case 42: character = (ImageIO.read(new File("Anakin (175).png")));
        break;
        case 56: character = (ImageIO.read(new File("Anakin (176).png")));
        break;
        case 70: character = (ImageIO.read(new File("Anakin (177).png")));
        break;
        case 84: character = (ImageIO.read(new File("Anakin (178).png")));
        break;
        case 98: character = (ImageIO.read(new File("Anakin (179).png")));
        break;
        case 112: character = (ImageIO.read(new File("Anakin (180).png")));
        break;
        case 126: character = (ImageIO.read(new File("Anakin (181).png")));
        break;
        case 140: character = (ImageIO.read(new File("Anakin (182).png")));
        break;
        case 154: character = (ImageIO.read(new File("Anakin (183).png")));
        break;
        
        }
        }
        
        if (block == true && melee == false)
        { 
        runspeed = 2;
        switch (blockcnt)
        {
        case 0: character = (ImageIO.read(new File("Anakin (131).png")));
        break;
        case 20: character = (ImageIO.read(new File("Anakin (132).png")));
        break;
        case 40: character = (ImageIO.read(new File("Anakin (133).png")));
        break;
        case 60: character = (ImageIO.read(new File("Anakin (132).png")));
        break;
        case 80: character = (ImageIO.read(new File("Anakin (131).png")));
        break;
        case 100: blockcnt = 0;
                  character = (ImageIO.read(new File("Anakin (12).png")));
                  block = false;
        }
        blockcnt++;
        }
        
        if (shooting == true)
       {
           firerate = 135;
       switch (shootcnt)
       {
       case 0: character = (ImageIO.read(new File("Anakin (145).png")));
       break;
       case 15: character = (ImageIO.read(new File("Anakin (146).png")));
       break;
       case 30: character = (ImageIO.read(new File("Anakin (147).png")));
       break;
       case 45: character = (ImageIO.read(new File("Anakin (148).png")));
       break;
       case 60: character = (ImageIO.read(new File("Anakin (149).png")));
       break;
       case 75: character = (ImageIO.read(new File("Anakin (150).png")));
       break;
       case 90: character = (ImageIO.read(new File("Anakin (151).png")));
       break;
       case 105: character = (ImageIO.read(new File("Anakin (152).png")));
       break;
       case 120: character = (ImageIO.read(new File("Anakin (153).png")));
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
        
        
        if (runcnt >= 168)
        {
            runcnt = 0;
        }

        height = character.getHeight(); 
        if (right == true)
        {
            width = -character.getWidth();
            if((meleecnt > 80 && meleecnt <= 135) || (dashing == true
                    && meleecnt > 30 && meleecnt <= 150))
            {
             g.setColor(Color.GREEN);
             meleebox = new Rectangle2(x-width/2-45,y,
                     character.getWidth()+15,height);
            }
            else
            {
             meleebox = new Rectangle2(); 
            }
            if (combo && ((meleecnt > 20 && meleecnt < 140) ||
                    (meleecnt > 240 && meleecnt < 360)))
            {
              g.setColor(Color.RED);
              meleebox = new Rectangle2(x-width/2-45,y,
                      character.getWidth()+25,height + 10);  
            }
            else
            {
             if (combo == true)
             {
             meleebox = new Rectangle2();
             }
            }
        g.drawImage(character, x + width/2 - f, y, -width, height, null);
        hbox = new Rectangle(x+width/2,y,character.getWidth(),height);
        gunx = x+width/2 - width - 10;
        guny = y+(int)((2*height)/5) - 15;
        footbox = new Rectangle2(x+width/2,y + height - 25,
                character.getWidth(),25);
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
        guny = y+(int)((2*height)/5) - 15;
        footbox = new Rectangle2(x-width/3,y + height - 25,
                character.getWidth(),25);
        g.setColor(Color.BLUE);

        }
        
        }
        
        else
        {
            
          if (killedcnt <= 200)
          {
              killedcnt++;
             
          switch (killedcnt)
         {
        case 0: character = (ImageIO.read(new File("Anakin (284).png"))); 
        break;
        case 15: character = (ImageIO.read(new File("Anakin (285).png"))); 
        break;
        case 30: character = (ImageIO.read(new File("Anakin (286).png")));          
        break;
        case 45: character = (ImageIO.read(new File("Anakin (287).png"))); 
        break;
        case 60: character = (ImageIO.read(new File("Anakin (288).png"))); 
        break;
        case 75: character = (ImageIO.read(new File("Anakin (289).png"))); 
        break;
        case 90: character = (ImageIO.read(new File("Anakin (290).png")));     
        break;
        case 105: character = (ImageIO.read(new File("Anakin (291).png")));          
        break;
        case 120: character = (ImageIO.read(new File("Anakin (300).png")));          
        break;
        case 135: character = (ImageIO.read(new File("Anakin (305).png")));
        break;
        case 150: character = (ImageIO.read(new File("Anakin (306).png")));          
        break;
        case 165: character = (ImageIO.read(new File("Anakin (307).png")));
        break;
        case 180: character = (ImageIO.read(new File("Anakin (308).png")));
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
          else
          {
              dead = true;
          }
       }
    }
    
    public void Idle() throws IOException
    {
        runcnt = -1;
        character = (ImageIO.read(new File("Anakin (11).png"))); 
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
    


