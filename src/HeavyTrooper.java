package starbrosgame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class HeavyTrooper extends Character
{
    int cnt = 0;
    int cnt2 = 0;
     public HeavyTrooper() throws IOException
    {
        ammoCost = 140;
        firerate = 25;
        bdamage = 15;
        bsize = 30;
        bspread = 9;
        brange = 600;
        bspeed = 3;
        health = 420;
        kHealth = health;
        regenfreq = 12;
        runspeed = 5;
        bammount = 3;
        cff = 15;
        bdi = 3;
        character = (ImageIO.read(new File("getup7.png")));
        width = character.getWidth();
        height = character.getHeight();
        hbox = new Rectangle(x, y, width, height);
        bullet1 = (ImageIO.read(new File("purplebolt.png")));
        name = "HeavyTrooper";
        staminaregen = 10;
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
            specialcnt++;
            if (specialcnt == 2)
            {
               health = health + 1;
               health = Math.min(health, kHealth);
               specialcnt = 0;
            }
        runspeed = 3;
        
            cff = 9;
            
        }
        else
        {  
        runspeed = 5;
        cff = 15;
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
  
        switch (runcnt) 
        {
            case 0: character = (ImageIO.read(new File("run1.png")));
                break;
            case 14: character = (ImageIO.read(new File("run2.png")));
                break;
            case 28: character = (ImageIO.read(new File("run3.png")));
                break;
            case 42: character = (ImageIO.read(new File("run4.png")));
                break;
            case 56: character = (ImageIO.read(new File("run5.png")));
                break;
            case 70: character = (ImageIO.read(new File("run6.png")));
                break;
            case 84: character = (ImageIO.read(new File("run7.png")));
                break;
            case 98: character = (ImageIO.read(new File("run8.png")));
                break;
           
        }

        guny = y+(int)((2*height)/5) - 10;
        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        if (right == true)
        {
        g.drawImage(character, x + width/2, y, -width, height, null);
        hbox = new Rectangle(x+width/2,y,character.getWidth(),height);
        gunx = x+width/2 - width - 10;
       
        footbox = new Rectangle2(x+width/2,y + height - 6,
                character.getWidth(),6);
        g.setColor(Color.BLUE);
        }
        
        if (left == true)
        {
        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        gunx = x - width + 12;
        footbox = new Rectangle2(x-width/3,y + height - 6,
                character.getWidth(),6);
        g.setColor(Color.BLUE);

        }
        
        } 
    }
    
}
