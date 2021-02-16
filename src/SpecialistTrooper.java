package starbrosgame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class SpecialistTrooper extends Character{

    int evasion = 0;
    int n = 0;
    int f = 0;
 
    public SpecialistTrooper() throws IOException
    {
        pColor = Color.ORANGE;
        sColor = Color.YELLOW;
        bdamage = 40;
        brange = 600;
        firerate = 40;
        runspeed = 8;
        jumpheight = 80;
        health = 190;
        kHealth = health;
        character = (ImageIO.read(new File("Zgetup7.png")));
        width = character.getWidth();
        height = character.getHeight();
        hbox = new Rectangle(x, y, width, height);
        name = "SpecialistTrooper";
        cff = 14;
        bdi = 1;
        bType = "normal";
        bullet1 = (ImageIO.read(new File("yellowbolt.png")));
        bullet2 = (ImageIO.read(new File("seeker.png")));
        
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
            bspeed = 1;
            firerate = 20;
            bdamage = 30;
            brange = 1700;
            bammount = 1;
            bdi = 0;
            bsize = 20;
            bType = "seeking";
            ammoCost = 2200;
            bulletnum = 2;
            runspeed = 5;
            cff = 12;
            staminaregen = 30;
        }
        else
        {
            ammoCost = 900;
            n--;
             n = Math.max(n,0);
            bdamage = 45;
            bammount = 1;
            brange = 600;
           bspeed = 3;
           firerate = 30;
           bspread = 1;
           bsize = 32;
           bdi = 3;
           bType = "normal";
           bulletnum = 1;
           runspeed = 8;
           cff = 16;
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
        case 0: character = (ImageIO.read(new File("Zrun1.png")));
        break;
        case 14: character = (ImageIO.read(new File("Zrun2.png")));
        break;
        case 28: character = (ImageIO.read(new File("Zrun3.png")));
        break;
        case 42: character = (ImageIO.read(new File("Zrun4.png")));
        break;
        case 56: character = (ImageIO.read(new File("Zrun5.png")));
        break;
        case 70: character = (ImageIO.read(new File("Zrun6.png")));
        break;
        case 84: character = (ImageIO.read(new File("Zrun7.png")));
        break;
        case 98: character = (ImageIO.read(new File("Zrun8.png")));
        break;
        
        }

        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        if (right == true)
        {
        g.drawImage(character, x + width/2, y, -width, height, null);
        hbox = new Rectangle(x+width/2,y,character.getWidth(),height);
        gunx = x+width/2 - width - 10;
        guny = y+(int)((2*height)/5) - 6;
        footbox = new Rectangle2(x+width/2,y + height - 7,
                character.getWidth(),7);
        g.setColor(Color.BLUE);
        }
        
        if (left == true)
        {
        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        gunx = x - width+10;
        guny = y+(int)((2*height)/5) - 6;
        footbox = new Rectangle2(x-width/3,y + height - 7,
                character.getWidth(),7);
        g.setColor(Color.BLUE);
        }
        verticalVelocity = Math.max(-4,verticalVelocity);
        verticalVelocity = Math.min(4,verticalVelocity);
        
        }
        
    }
     public void Idle() throws IOException
    {
        runcnt = -1;
        character = (ImageIO.read(new File("Zgetup7.png"))); 
    }

}

