package starbrosgame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class SuperBattleDroid extends Character
{
    int cnt = 0;
    int cnt2 = 0;
     public SuperBattleDroid() throws IOException
    {
        ammoCost = 700;
        pColor = new Color(100, 10, 100);
        sColor = new Color(255, 0, 200);
        firerate = 25;
        mdamage = 20;
        bsize = 32;
        bdamage = 40;
        bspread = 1;
        bspeed = 5;
        health = 400;
        kHealth = health;
        regenfreq = 12;
        runspeed = 5;
        bammount = 2;
        cff = 14;
        bdi = 2;
        character = (ImageIO.read(new File("SBDshoot1stand.png")));
        width = character.getWidth();
        height = character.getHeight();
        hbox = new Rectangle(x, y, width, height);
        bullet1 = (ImageIO.read(new File("redbolt.png")));
        name = "SuperBattleDroid";
        atkType2 = "melee";
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

            ammoCost = 0;
            bdamage = 60;
            firerate = 15;
            runspeed = 1;
            cff = 0;
            bsize = 62;
            staminaregen = 120;
            brange = 340;
            jumpV = 0;
            
        }
        else
        {
        ammoCost = 3000;
        bdamage = 55;
        firerate = 16;    
        runspeed = 5;
        cff = 14;
        bsize = 42;
        staminaregen = 120;
        brange = 550;
        jumpV = 10;
        } 
         regencnt++;
           if(regencnt >= regenfreq)
           {
              health = health + 1;
              health = Math.min(health, kHealth);
              regencnt = 0;
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
        
       if (!melee)
       {
       if (!specialactivated)
       {
        switch (runcnt) 
        {
            case 0: character = (ImageIO.read(new File("SBDwalk1.png")));
                break;
            case 11: character = (ImageIO.read(new File("SBDwalk2.png")));
                break;
            case 22: character = (ImageIO.read(new File("SBDwalk3.png")));
                break;
            case 33: character = (ImageIO.read(new File("SBDwalk4.png")));
                break;
            case 44: character = (ImageIO.read(new File("SBDwalk5.png")));
                break;
            case 55: character = (ImageIO.read(new File("SBDwalk6.png")));
                break;
            case 66: character = (ImageIO.read(new File("SBDwalk7.png")));
                break;
            case 77: character = (ImageIO.read(new File("SBDwalk8.png")));
                break;
           
        }
       }
        else
       {
        switch (runcnt) 
        {
            case 0: character = (ImageIO.read(new File("SBDwalk1.png")));
                break;
            case 20: character = (ImageIO.read(new File("SBDwalk2.png")));
                break;
            case 40: character = (ImageIO.read(new File("SBDwalk3.png")));
                break;
            case 80: character = (ImageIO.read(new File("SBDwalk4.png")));
                break;
            case 100: character = (ImageIO.read(new File("SBDwalk5.png")));
                break;
            case 120: character = (ImageIO.read(new File("SBDwalk6.png")));
                break;
            case 140: character = (ImageIO.read(new File("SBDwalk7.png")));
                break;
            case 160: character = (ImageIO.read(new File("SBDwalk8.png")));
                break;
           
        }
       }
       }
       
       if (melee && !shooting)
        {
            meleecnt++;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("SBDswipe1.png")));
        break;
        case 15: character = (ImageIO.read(new File("SBDswipe2.png")));
        break;
        case 30: character = (ImageIO.read(new File("SBDswipe3.png")));
        break;
        case 45: character = (ImageIO.read(new File("SBDswipe4.png")));
        break;
        case 60: character = (ImageIO.read(new File("SBDswipe5.png")));
        break;
        case 75: character = (ImageIO.read(new File("SBDswipe6.png")));        
        break;
        case 90: character = (ImageIO.read(new File("SBDswipe7.png")));
        break;
        case 105: character = (ImageIO.read(new File("SBDswipe8.png")));
        break;
        case 120: character = (ImageIO.read(new File("SBDswipe9.png")));
        break;
        case 135: meleecnt = 0;
                  melee = false;
        break;
        
        }
             height = character.getHeight();
            
        }
       
        
    
        guny = y+(int)((2*height)/5) - 15;
        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        if (right == true)
        {
          
            if(meleecnt > 30 && meleecnt <= 120)
         {   
             g.setColor(Color.GREEN);
             meleebox = new Rectangle2(x-width/2,y,
                     character.getWidth() + 10,height);
         }
            
         else
         {
           meleebox = new Rectangle2(); 
         }   
        g.drawImage(character, x + width/2, y, -width, height, null);
        hbox = new Rectangle(x-width/2,y,character.getWidth(),height);
        gunx = x + width/3;
       
        footbox = new Rectangle2(x-width/2,y + height - 8,
                character.getWidth(),12);
        g.setColor(Color.BLUE);


        
        }
        
        if (left == true)
        {
            
             if(meleecnt > 30 && meleecnt <= 120)
         {
             meleebox = new Rectangle2(x+width/2 - 10,y,
                     character.getWidth() + 10,height);
         }
            else
            {
             meleebox = new Rectangle2(); 
            }   
        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x+width/2,y,character.getWidth(),height);
        gunx = x-width/2 + width;
        
        footbox = new Rectangle2(x+width/2,y + height - 8,
                character.getWidth(),12);
        g.setColor(Color.BLUE);
        
        
        }
        
        } 
    }
     
    public void Idle() throws IOException
    {
        runcnt = -1;
        character = (ImageIO.read(new File("SBDshoot1stand.png"))); 
        
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
