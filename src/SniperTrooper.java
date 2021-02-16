package starbrosgame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SniperTrooper extends Character
{
    SniperTrooper() throws IOException 
    {
        name = "SniperTrooper";
        pColor = new Color(10, 140, 0);
        sColor = Color.GREEN;
        brange = 8000;
        health = 200;
        kHealth = health;
        runspeed = 9;
        cff = 17;
        bspeed = 6;
        
        character = (ImageIO.read(new File("Ggetup7.png")));
        width = character.getWidth();
        height = character.getHeight();
        hbox = new Rectangle(x, y, width, height);
        bullet1 = (ImageIO.read(new File("greenbolt.png")));
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
            firerate = 2;
            bsize = 80;
            bdamage = 2000;
            bspeed = 3;
            ammoCost = 20000;
            bType = "teleporting";
            staminaregen = 60;
        }
        else
        {
        ammoCost = 20000;  
        firerate = 2;
        bdamage = 200;
        bspeed = 7;
        bsize = 32;
        bType = "normal";
        staminaregen = 100;
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
        case 0: character = (ImageIO.read(new File("Grun1.png")));
        break;
        case 14: character = (ImageIO.read(new File("Grun2.png")));
        break;
        case 28: character = (ImageIO.read(new File("Grun3.png")));
        break;
        case 42: character = (ImageIO.read(new File("Grun4.png")));
        break;
        case 56: character = (ImageIO.read(new File("Grun5.png")));
        break;
        case 70: character = (ImageIO.read(new File("Grun6.png")));
        break;
        case 84: character = (ImageIO.read(new File("Grun7.png")));
        break;
        case 98: character = (ImageIO.read(new File("Grun8.png")));
        break;
        
        }
       

        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        if (right == true)
        {
        g.drawImage(character, x + width/2, y, -width, height, null);
        hbox = new Rectangle(x+width/2,y,character.getWidth(),height);
        gunx = x+width/2 - width - 4;
        if (specialactivated == true)
        {
        gunx = x+width/2 - width + 10;
        }
        guny = y+(int)((2*height)/5) - 6;
        footbox = new Rectangle2(x+width/2,y + height - 7,character.getWidth()
                ,7);
        g.setColor(Color.BLUE);

        }
        
        if (left == true)
        {
        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        gunx = x - width + 7;
        if (specialactivated == true)
        {
        gunx = x - width - 7;
        }
        guny = y+(int)((2*height)/5) - 6;
        footbox = new Rectangle2(x-width/3,y + height - 7,character.getWidth()
                ,7);
        g.setColor(Color.BLUE);
        }
        
        }
        
    }
    
    public void Idle() throws IOException
    {
        runcnt = -1;
        character = (ImageIO.read(new File("Ggetup7.png"))); 
    }
    
}
