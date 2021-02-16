package starbrosgame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GeneralGrievous extends Character
{
    private boolean maalo[] = new boolean[4];
    private int cnt;
    
    GeneralGrievous() throws IOException 
    {
        atkType = "melee";
        canDash = true;
        tma = 3;
        name = "GeneralGrievous";
        mdamage = 10;
        brange = 5;
        meleeCost = 10;
        bdamage = 250;
        bspeed = 5;
        firerate = 132;
        health = 1200;
        kHealth = health;
        bsize = 32;
        runspeed = 5;
        cff = 20;
        regenfreq = 10;
        character = (ImageIO.read(new File("G (10).png")));
        width = character.getWidth();
        height = character.getHeight();
        hbox = new Rectangle(x, y, width, height);
        bullet1 = (ImageIO.read(new File("forceb.png")));
        hero = true;
        ts1 = "GeneralGrievousAhhYes.wav";
        ts2 = "GeneralGrievousLaugh1.wav";
        ts3 = "ForTheSucc.wav";
        totaltauntsounds = 3;
        staminaregen = 42;
    }
    
    public void draw(Graphics g) throws IOException
    {
        
        if (health > 0)
        {
        runspeed = 5;
        regencnt++;
           if(regencnt >= regenfreq)
           {
              health = health + 1;
              health = Math.min(health, kHealth);
              regencnt = 0;
           }
        
        if (melee == true)
        {
            maalo[ma] = true;
            meleecnt++;
            
            if (ma == 0)
            {
                meleefreq = 150;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("G (11).png"))); 
        break;
        case 15: character = (ImageIO.read(new File("G (12).png"))); 
        break;
        case 30: character = (ImageIO.read(new File("G (13).png"))); 
        break;
        case 45: character = (ImageIO.read(new File("G (14).png"))); 
        break;
        case 60: character = (ImageIO.read(new File("G (15).png"))); 
        break;
        case 75: character = (ImageIO.read(new File("G (16).png"))); 
        break;
        case 90: character = (ImageIO.read(new File("G (17).png"))); 
        break;
        case 105: character = (ImageIO.read(new File("G (18).png"))); 
        break;
        case 120: character = (ImageIO.read(new File("G (19).png"))); 
        break;
        case 135: character = (ImageIO.read(new File("G (20).png"))); 
        y = y - 10;
        break;
        case 150: character = (ImageIO.read(new File("G (21).png"))); 
        break;
        case 165: character = (ImageIO.read(new File("G (22).png"))); 
        break;
        case 180: character = (ImageIO.read(new File("G (23).png"))); 
        break;
        case 195: character = (ImageIO.read(new File("G (24).png"))); 
        y = y - 10;
        break;
        case 210: character = (ImageIO.read(new File("G (11).png"))); 
        break;
        case 225: meleecnt = 0;
                  melee = false;
                         
        break;
        
        }
            }
            
            if (ma == 1)
            {
                meleefreq = 322;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("G (25).png"))); 
        break;
        case 15: character = (ImageIO.read(new File("G (26).png"))); 
        break;
        case 30: character = (ImageIO.read(new File("G (27).png"))); 
        break;
        case 45: character = (ImageIO.read(new File("G (28).png"))); 
        break;
        case 60: character = (ImageIO.read(new File("G (29).png"))); 
        break;
        case 75: character = (ImageIO.read(new File("G (30).png"))); 
        break;
        case 90: character = (ImageIO.read(new File("G (31).png"))); 
        break;
        case 105: character = (ImageIO.read(new File("G (32).png"))); 
        break;
        case 120: character = (ImageIO.read(new File("G (33).png"))); 
        break;
        case 135: character = (ImageIO.read(new File("G (34).png"))); 
        break;
        case 150: character = (ImageIO.read(new File("G (35).png"))); 
        break;
        case 165: character = (ImageIO.read(new File("G (36).png"))); 
        y = y - 10;
        break;
        case 180: character = (ImageIO.read(new File("G (37).png"))); 
        break;
        case 195: character = (ImageIO.read(new File("G (38).png"))); 
        break;
        case 210: character = (ImageIO.read(new File("G (39).png"))); 
        break;
        case 225: character = (ImageIO.read(new File("G (40).png"))); 
        break;
        case 240: character = (ImageIO.read(new File("G (41).png"))); 
        y = y - 10;
        break;
        case 255: character = (ImageIO.read(new File("G (42).png"))); 
        break;
        case 270: character = (ImageIO.read(new File("G (43).png"))); 
        break;
        case 285: character = (ImageIO.read(new File("G (44).png"))); 
        break;
        case 300: character = (ImageIO.read(new File("G (45).png"))); 
        break;
        case 315: character = (ImageIO.read(new File("G (46).png"))); 
        break;
        case 330: character = (ImageIO.read(new File("G (47).png"))); 
        break;
        case 345: meleecnt = 0;
                  melee = false; 
                  break;
        
        
        }
            }
            
            if (ma == 2)
            {
                meleefreq = 200;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("G (59).png")));
        break;
        case 10: character = (ImageIO.read(new File("G (60).png")));
        break;
        case 20: character = (ImageIO.read(new File("G (61).png")));
        break;
        case 30: character = (ImageIO.read(new File("G (62).png")));
        break;
        case 40: character = (ImageIO.read(new File("G (63).png")));
        break;
        case 50: character = (ImageIO.read(new File("G (64).png")));
        break;
        case 60: character = (ImageIO.read(new File("G (65).png")));
        break;
        case 70: character = (ImageIO.read(new File("G (66).png")));
        break;
        case 80: character = (ImageIO.read(new File("G (67).png")));
        break;
        case 90: character = (ImageIO.read(new File("G (68).png")));
        break;
        case 100: character = (ImageIO.read(new File("G (66).png")));
        break;
        case 110: character = (ImageIO.read(new File("G (67).png")));
        break;
        case 120: character = (ImageIO.read(new File("G (68).png")));
        break;
        case 130: character = (ImageIO.read(new File("G (66).png")));
        break;
        case 140: character = (ImageIO.read(new File("G (67).png")));
        break;
        case 150: character = (ImageIO.read(new File("G (68).png")));
        break;
        case 160: character = (ImageIO.read(new File("G (66).png")));
        break;
        case 170: character = (ImageIO.read(new File("G (67).png")));
        break;
        case 180: character = (ImageIO.read(new File("G (68).png")));
        break;
        case 190: character = (ImageIO.read(new File("G (66).png")));
        break;
        case 200: meleecnt = 0;
                  melee = false;            
        break;
        
        }
            }
        }
            
        //jumping effect
        cnt++;
        if (jumping && !dashing && !melee && !block && cnt > 10)
        {
         character = (ImageIO.read(new File("G (50).png")));
         cnt = 0;
        }
        
        
        if (melee == false && block == false && shooting == false && 
                !jumping && !dashing)
        {
            
        switch (runcnt)
        {
        case 1: character = (ImageIO.read(new File("G (71).png")));
        break;
        case 15: character = (ImageIO.read(new File("G (72).png")));
        break;
        case 30: character = (ImageIO.read(new File("G (73).png")));
        break;
        case 45: character = (ImageIO.read(new File("G (74).png")));
        break;
        case 60: character = (ImageIO.read(new File("G (75).png")));
        break;
        case 75: character = (ImageIO.read(new File("G (76).png")));
        break;
        case 90: character = (ImageIO.read(new File("G (77).png")));
        break;
        case 105: character = (ImageIO.read(new File("G (78).png")));
        break;
        }
        }
        
        
        
        if (block == true && melee == false)
        { 
        runspeed = 1;
        switch (blockcnt)
        {
        case 0: character = (ImageIO.read(new File("G (66).png")));
        break;
        case 10: character = (ImageIO.read(new File("G (67).png")));
        break;
        case 20: character = (ImageIO.read(new File("G (68).png")));
        break;
        case 30: character = (ImageIO.read(new File("G (66).png")));
        break;
        case 40: character = (ImageIO.read(new File("G (67).png")));
        break;
        case 50: character = (ImageIO.read(new File("G (68).png")));
        break;
        case 60: character = (ImageIO.read(new File("G (66).png")));
        break;
        case 70: character = (ImageIO.read(new File("G (67).png")));
        break;
        case 80: blockcnt = 0;
                 block = false;
        }
        blockcnt++;
        }
        
        if (dashing == true)
        {
          verticalVelocity = 0;
          runspeed = 15;  
        switch (dashcnt)
        {
        case 0: character = (ImageIO.read(new File("G (93).png")));
        break;
        case 30: character = (ImageIO.read(new File("G (94).png")));
        break;
        case 50: character = (ImageIO.read(new File("G (95).png")));
        break;
        case 80: character = (ImageIO.read(new File("G (96).png")));
        break;
        case 111: dashcnt = -1;
                 dashing = false;
        break;
        }
        dashcnt++;
        
        }
        
        
        
        if (runcnt >= 120)
        {
            runcnt = 0;
        }

        height = character.getHeight(); 
        if (right == true)
        {
            if(((meleecnt > 50 && meleecnt <= 130) && ma == 0) || 
                    (((meleecnt > 45 && meleecnt <= 90) || (meleecnt > 120 && 
                    meleecnt <= 150) || (meleecnt > 255 && meleecnt <= 315)) 
                    && ma == 1) || ((meleecnt > 70 && meleecnt <= 190) 
                    && ma == 2) || dashing)
            {
             g.setColor(Color.GREEN);
              meleebox = new Rectangle2(x-width/2,y,character.getWidth() + 
                      10,height);
            }
            else
            {
             meleebox = new Rectangle2(); 
            }

        g.drawImage(character, x + width/2, y, -width, height, null);
        hbox = new Rectangle(x-width/2,y,character.getWidth(),height);
        gunx = x+width/2 - width - 10;
        guny = y+(int)((2*height)/5) - 15;
        footbox = new Rectangle2(x-width/2,y + height - 30,
                character.getWidth(),30);
        g.setColor(Color.BLUE);
        }
        
        if (left == true)
        {
            if(((meleecnt > 50 && meleecnt <= 130) && ma == 0) || 
                    (((meleecnt > 45 && meleecnt <= 90) || (meleecnt > 120 &&
                    meleecnt <= 150) || (meleecnt > 255 && meleecnt <= 315)) 
                    && ma == 1) || ((meleecnt > 70 && meleecnt <= 190) && 
                    ma == 2) || dashing)
            {   
             g.setColor(Color.GREEN);
             meleebox = new Rectangle2(x+width/2 - 10,y,
                     character.getWidth() + 10,height);
            }
            else
            {
             meleebox = new Rectangle2(); 
            }

        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x+width/2,y,character.getWidth(),height);
        gunx = x - width + 14;
        guny = y+(int)((2*height)/5) - 15;
        footbox = new Rectangle2(x+width/2,y + height - 30,
                character.getWidth(),30);
        g.setColor(Color.BLUE);

        }
        
        }
        
        else
        {
            
          if (killedcnt <= 200)
          {
              killedcnt++;
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
        character = (ImageIO.read(new File("G (10).png"))); 
        height = character.getHeight();
        shooting = false;
    }
    
    public void RunLeft()
    {
        if (shooting == false && dead == false)
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
      if (shooting == false && dead == false)
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
    


