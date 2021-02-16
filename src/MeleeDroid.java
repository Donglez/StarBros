package starbrosgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MeleeDroid extends Character
{
    int n = 0;
    MeleeDroid() throws IOException 
    {
        atkType = "melee";
        pColor = new Color(200, 80, 30);
        sColor = Color.RED;
        name = "MeleeDroid";
        mdamage = 12;
        brange = 5;
        health = 400;
        kHealth = health;
        bsize = 6;
        runspeed = 3;
        cff = 12;
        bspeed = 2;
        verticalVelocity = 2;
        regenfreq = 30;
        character = (ImageIO.read(new File("walk1stand1.png")));
        width = character.getWidth();
        height = character.getHeight();
        hbox = new Rectangle(x, y, width, height);
        meleeCost = 8;
    }
    
    public void draw(Graphics g) throws IOException
    {
        
        if (health <= 0)
        {
            dead = true;
        }
        if (dead == false)
        {
        
        if (specialactivated == true)
        {
            runspeed = 11;
            cff = 18;
            armorVal = 1;
            
        }
        else
        {
          runspeed = 3;
          cff = 12;
          armorVal = 3;
          
          
        }
        
        regencnt++;
           if(regencnt >= regenfreq)
           {
              health = health + 1;
              health = Math.min(health, kHealth);
              regencnt = 0;
           }
        
        if (melee == true)
        {
            meleecnt++;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("MDwham1.png")));
        break;
        case 9: character = (ImageIO.read(new File("MDwham2.png")));
        break;
        case 18: character = (ImageIO.read(new File("MDwham3.png")));
        break;
        case 27: character = (ImageIO.read(new File("MDwham4.png")));
        break;
        case 36: character = (ImageIO.read(new File("MDwham5.png")));
        break;
        case 45: character = (ImageIO.read(new File("MDwham6.png")));        
        break;
        case 54: character = (ImageIO.read(new File("MDwham7.png")));
        break;
        case 64: character = (ImageIO.read(new File("MDwham8.png")));
        break;
        case 72: character = (ImageIO.read(new File("MDwham9.png")));
        break;
        case 81: character = (ImageIO.read(new File("MDwham10.png")));
        break;
        case 99: character = (ImageIO.read(new File("MDwham12.png")));
        break;
        case 108: character = (ImageIO.read(new File("MDwham13.png")));
        break;
        case 111: meleecnt = 0;
                  melee = false;
        break;
        
        }
             height = character.getHeight();
            
        }

        
        if (melee == false)
        {
            if (!specialactivated)
            {
        switch (runcnt)
        {
        case 0: character = (ImageIO.read(new File("walk1stand1.png")));
        break;
        case 14: character = (ImageIO.read(new File("MDwalk2.png")));
        break;
        case 28: character = (ImageIO.read(new File("MDwalk3.png")));
        break;
        case 42: character = (ImageIO.read(new File("MDwalk4.png")));
        break;
        case 56: character = (ImageIO.read(new File("MDwalk5.png")));
        break;
        case 70: character = (ImageIO.read(new File("MDwalk6.png")));
        break;
        case 84: character = (ImageIO.read(new File("MDwalk7.png")));
        break;
        case 98: character = (ImageIO.read(new File("MDwalk8.png")));
        break;
        case 112: character = (ImageIO.read(new File("MDwalk9.png")));
        break;
        }
            }
            
            if (specialactivated)
            {
        switch (runcnt)
        {
        case 0: character = (ImageIO.read(new File("MDrun1.png")));
        break;
        case 14: character = (ImageIO.read(new File("MDrun2.png")));
        break;
        case 28: character = (ImageIO.read(new File("MDrun3.png")));
        break;
        case 42: character = (ImageIO.read(new File("MDrun4.png")));
        break;
        case 56: character = (ImageIO.read(new File("MDrun5.png")));
        break;
        case 70: character = (ImageIO.read(new File("MDrun6.png")));
        break;
        case 84: runcnt = 0;
        }
            }
        height = character.getHeight();
        }
        
        if (runcnt >= 126)
        {
            runcnt = 0;
        }
        if (right == true)
        {
            width = -character.getWidth();
            if(meleecnt > 36 && meleecnt <= 81)
         {

             meleebox = new Rectangle2(x-width/2-15,y,
                     character.getWidth()+5,height);
         }
            else
            {
             meleebox = new Rectangle2(); 
            }
        g.drawImage(character, x + width/2, y, -width, height, null);
        hbox = new Rectangle(x+width/2,y,character.getWidth(),height);
        gunx = x+width/2 - width - 10;
        guny = y+(int)((2*height)/5) - 6;
        footbox = new Rectangle2(x+width/2,y + height - 22,
                character.getWidth(),22);
        g.setColor(Color.BLUE);
        }
        
        if (left == true)
        {
            width = character.getWidth();
            if(meleecnt > 36 && meleecnt <= 81)
         {   
             g.setColor(Color.GREEN);
             meleebox = new Rectangle2(x-width - width/3 + 15,
                     y,character.getWidth() + 15,height);
         }
            
            else
            {
             meleebox = new Rectangle2(); 
            }
        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        gunx = x - width + 14;
        guny = y+(int)((2*height)/5) - 6;
        footbox = new Rectangle2(x-width/3,y + height - 22,
                character.getWidth(),22);
        g.setColor(Color.BLUE);
        }
        
        }
        
        else
        {
          if (killedcnt <= 145)
          {
              meleebox = new Rectangle2(0,0,0,0);
              killedcnt++;
          
          switch (killedcnt)
         {
        case 0: character = (ImageIO.read(new File("MDdie1.png"))); 
        break;
        case 15: character = (ImageIO.read(new File("MDdie2.png"))); 
        break;
        case 30: character = (ImageIO.read(new File("MDdie3.png"))); 
        break;
        case 45: character = (ImageIO.read(new File("MDdie4.png"))); 
        break;
        case 60: character = (ImageIO.read(new File("MDdie5.png"))); 
        break;
        case 75: character = (ImageIO.read(new File("MDdie6.png"))); 
        break;
        case 90: character = (ImageIO.read(new File("MDdie7.png"))); 
        break;
        case 105: character = (ImageIO.read(new File("MDdie8.png"))); 
        break;
        case 115: character = (ImageIO.read(new File("MDdie9.png"))); 
        break;
        case 125: character = (ImageIO.read(new File("MDdie10.png"))); 
        break;
        case 135: character = (ImageIO.read(new File("MDdie11.png"))); 
        break;
        
         }
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
        character = (ImageIO.read(new File("walk1stand1.png"))); 
        
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
    
}
