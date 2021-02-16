package starbrosgame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ShotgunTrooper extends Character
{
    ShotgunTrooper() throws IOException 
    {
        pColor = Color.YELLOW;
        sColor = Color.ORANGE;
        bsize = 32;
        health = 350;
        kHealth = health;
        brange = 500;
        bspeed = 3;
        runspeed = 7;
        cff = 14;
        character = (ImageIO.read(new File("Sgetup7.png")));
        width = character.getWidth();
        height = character.getHeight();
        hbox = new Rectangle(x, y, width, height);
        bullet1 = (ImageIO.read(new File("orangebolt.png")));
        bullet2 = (ImageIO.read(new File("buckshot.png")));
        name = "ShotgunTrooper";
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
            bulletnum = 2;
            pColor = Color.BLACK;
            bammount = 10;
            bspeed = 3;
            bsize = 24;
            bdamage = 70;
            brange = 250;
            staminaregen = 70;
            ammoCost = 20000;
            if (right == true)
            {
             gunx = x+width/2 - width - 10;
             guny = y+(int)((2*height)/5) - 6 - 15 -15;
            }
            else
            {
             gunx = x - width + 7;
             guny = y+(int)((2*height)/5) - 6 - 15 - 15;
            }
            bdi = 6;
            
        }
        else
        { 
            staminaregen = 120;
            firerate = 2;
            bulletnum = 1;
            ammoCost = 20000;
            sColor = Color.ORANGE;
            pColor = new Color(150,60,0);
            bdamage = 60;
            bdi = 2;
            bsize = 48;
            bspeed = 6;
            brange = 600;
            bammount = 3;
            if (right == true)
            {
             gunx = x+width/2 - width - 10 - 1;
             guny = y+(int)((2*height)/5) - 6 -15 + 11;
            }
            else
            {
             gunx = x - width + 10;
             guny = y+(int)((2*height)/5) - 6 - 15 + 11;
            }
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
        case 0: character = (ImageIO.read(new File("Srun1.png")));
        break;
        case 14: character = (ImageIO.read(new File("Srun2.png")));
        break;
        case 28: character = (ImageIO.read(new File("Srun3.png")));
        break;
        case 42: character = (ImageIO.read(new File("Srun4.png")));
        break;
        case 56: character = (ImageIO.read(new File("Srun5.png")));
        break;
        case 70: character = (ImageIO.read(new File("Srun6.png")));
        break;
        case 84: character = (ImageIO.read(new File("Srun7.png")));
        break;
        case 98: character = (ImageIO.read(new File("Srun8.png")));
        break;
        
        }
       

        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        if (right == true)
        {
        g.drawImage(character, x + width/2, y, -width, height, null);
        hbox = new Rectangle(x+width/2,y,character.getWidth(),height);
        footbox = new Rectangle2(x+width/2,y + height - 7,character.getWidth(),
                7);
        g.setColor(Color.BLUE);

        }
        
        if (left == true)
        {
        g.drawImage(character, x + width/2, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        footbox = new Rectangle2(x-width/3,y + height - 7,character.getWidth()
                ,7);
        g.setColor(Color.BLUE);
        }
        
        }
    }
    
    public void Idle() throws IOException
    {
        runcnt = -1;
        character = (ImageIO.read(new File("Sgetup7.png"))); 
    }
    
}
