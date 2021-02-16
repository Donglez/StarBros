package starbrosgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JumpTrooper extends Character
{
    JumpTrooper() throws IOException 
    {
        pColor = Color.BLUE;
        sColor = Color.CYAN;
        firerate = 25;
        bdamage = 12;
        brange = 500;
        health = 175;
        kHealth = health;
        bsize = 6;
        runspeed = 7;
        regenfreq = 14;
        bspeed = 4;
        verticalVelocity = 2;
        cff = 30;
        bdi = 1;
        character = (ImageIO.read(new File("Bgetup7.png")));
        width = character.getWidth();
        height = character.getHeight();
        hbox = new Rectangle(x, y, width, height);
        jumpCost = 100;
        stamina = 15000;
        kStamina = stamina;
        bullet2 = (ImageIO.read(new File("shadowbolt.png")));
        bullet1 = (ImageIO.read(new File("bluebolt.png")));
        name = "JumpTrooper";
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
            cff = 9;
            firerate = 3;
            bdamage = 20;
            bsize = 16;
            bspeed = 2;
            brange = (int)(Math.random()*30 + 100);
            bspread = 2;
            bammount = 4;
            bdi = 1;
            bType = "shadow";
            ammoCost = 200;
            bulletnum = 2;
        }
        else
        { 
        cff = 27;
        firerate = 25;
        bdamage = 16;
        bspread = 0;
        bsize = 24;
        bspeed = 3; 
        brange = 500;
        bammount = 3;
        bdi = 6;
        bType = "normal";
        ammoCost = 600;
        bulletnum = 1; 
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
        case 0: character = (ImageIO.read(new File("Brun1.png")));
        break;
        case 14: character = (ImageIO.read(new File("Brun2.png")));
        break;
        case 28: character = (ImageIO.read(new File("Brun3.png")));
        break;
        case 42: character = (ImageIO.read(new File("Brun4.png")));
        break;
        case 56: character = (ImageIO.read(new File("Brun5.png")));
        break;
        case 70: character = (ImageIO.read(new File("Brun6.png")));
        break;
        case 84: character = (ImageIO.read(new File("Brun7.png")));
        break;
        case 98: character = (ImageIO.read(new File("Brun8.png")));
        break;
        
        }
        
       
        guny = y+(int)((2*height)/5) - 7;
        if (specialactivated == false)
        {
         guny = y+(int)((2*height)/5) - 13;
        }
        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        if (right == true)
        {
        g.drawImage(character, x + width/2, y, -width, height, null);
        hbox = new Rectangle(x+width/2,y,character.getWidth(),height);
        gunx = x+width/2 - width - 3;
        footbox = new Rectangle2(x+width/2,y + height - 7,
                character.getWidth(),7);
        g.setColor(Color.BLUE);
        }
        
        if (left == true)
        {
        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        gunx = x - width + 14;
        footbox = new Rectangle2(x-width/3,y + height - 7,
                character.getWidth(),7);
        g.setColor(Color.BLUE);

        }
        
        }
    }
    
    public void Idle() throws IOException
    {
        runcnt = -1;
        character = (ImageIO.read(new File("Bgetup7.png"))); 
    }
    
}
