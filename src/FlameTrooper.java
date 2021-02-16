
package starbrosgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FlameTrooper extends Character
{
    FlameTrooper() throws IOException 
    {
        ammoCost = 60;
        staminaregen = 40;
        pColor = Color.ORANGE;
        sColor = Color.RED;
        bdamage = 1;
        firerate = 0;
        health = 330;
        kHealth = health;
        runspeed = 6;
        bspread = 4;
        bType = "flame";
        bspeed = 2;
        cff = 13;
        character = (ImageIO.read(new File("Fgetup7.png")));
        width = character.getWidth();
        height = character.getHeight();
        hbox = new Rectangle(x, y, width, height);
        brange = 250;
        bullet1 = (ImageIO.read(new File("flame.png")));
        name = "FlameTrooper";
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
            if (specialcnt >= 4)
            {
               health = health - 1;
               specialcnt = 0;
            }
            bdamage = 15; 
            pColor = new Color(255, 70, 40);
            bsize =  64 - (int)(health - kHealth)/10 + (int)(Math.random()*16);
            sColor = new Color(255, 255, 255);
            bspeed = 2 - (int)(health - kHealth)/165;
            bammount = 2 - (int)(health - kHealth)/200;
            bspread = 4 - (int)(health - kHealth)/40;
            runspeed = 9;
            cff = 16;
            brange = 150 + (int)(Math.random()*180 - ((health - kHealth)/3));
            firerate = 6;
            regenfreq = 25 + (((int)(health - kHealth))/13);
            regenfreq = Math.max(regenfreq, 5);  
            guny = y+(int)((2*height)/5) - 30;
        }
        else
        {
           regenfreq = 25;
           pColor = Color.ORANGE;
           sColor = Color.RED;
           bdamage = 10;
           bsize = 48 + (int)(Math.random()*4)*4;
           bspeed = 2;
           bspread = 4;
           runspeed = 6;
           bammount = 1;
           cff = 13;
           brange = 200 + (int)(Math.random()*200);
           firerate = 5;
           guny = y+(int)((2*height)/5) - 18;
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
        case 0: character = (ImageIO.read(new File("Frun1.png")));
        break;
        case 14: character = (ImageIO.read(new File("Frun2.png")));
        break;
        case 28: character = (ImageIO.read(new File("Frun3.png")));
        break;
        case 42: character = (ImageIO.read(new File("Frun4.png")));
        break;
        case 56: character = (ImageIO.read(new File("Frun5.png")));
        break;
        case 70: character = (ImageIO.read(new File("Frun6.png")));
        break;
        case 84: character = (ImageIO.read(new File("Frun7.png")));
        break;
        case 98: character = (ImageIO.read(new File("Frun8.png")));
        break;
        
        }
       

        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        if (right == true)
        {
        g.drawImage(character, x + width/2, y, -width, height, null);
        hbox = new Rectangle(x+width/2,y,character.getWidth(),height);
        gunx = x+width/2 - width - 6;
        footbox = new Rectangle2(x+width/2,y + height - 7,
                character.getWidth(),7);
        g.setColor(Color.BLUE);
        }
        
        if (left == true)
        {
        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        gunx = x - width + 30;
        footbox = new Rectangle2(x-width/3,y + height - 7,
                character.getWidth(),7);
        g.setColor(Color.BLUE);
        }
        
        }
    }
    
    public void Idle() throws IOException
    {
        runcnt = -1;
        character = (ImageIO.read(new File("Fgetup7.png"))); 
    }
    
}
