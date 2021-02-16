package starbrosgame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ObiWanKenobi extends Character
{
    private int f = 0;
    private boolean maalo[] = new boolean[4];
    
    ObiWanKenobi() throws IOException 
    {
        atkType = "melee";
        tma = 3;
        name = "ObiWanKenobi";
        mdamage = 10;
        brange = 5;
        meleeCost = 5;
        health = 980;
        kHealth = health;
        runspeed = 8;
        cff = 23;
        regenfreq = 80;
        character = (ImageIO.read(new File("ObiWan (34).png")));
        width = character.getWidth();
        height = character.getHeight();
        hbox = new Rectangle(x, y, width, height);
        hero = true;
        totaltauntsounds = 1;
        ts1 = "HelloThere.wav";
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
                meleefreq = 287;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("Obi-Wan (64).png"))); 
        break;
        case 7: character = (ImageIO.read(new File("Obi-Wan (65).png"))); 
        break;
        case 14: character = (ImageIO.read(new File("Obi-Wan (66).png"))); 
        break;
        case 21: character = (ImageIO.read(new File("Obi-Wan (67).png"))); 
        break;
        case 28: character = (ImageIO.read(new File("Obi-Wan (68).png"))); 
        break;
        case 35: character = (ImageIO.read(new File("Obi-Wan (69).png"))); 
        break;
        case 42: character = (ImageIO.read(new File("Obi-Wan (70).png"))); 
        break;
        case 49: character = (ImageIO.read(new File("Obi-Wan (71).png"))); 
        break;
        case 56: character = (ImageIO.read(new File("Obi-Wan (72).png"))); 
        break;
        case 63: character = (ImageIO.read(new File("Obi-Wan (73).png"))); 
        break;
        case 70: character = (ImageIO.read(new File("Obi-Wan (74).png"))); 
        break;
        case 77: character = (ImageIO.read(new File("Obi-Wan (75).png"))); 
        break;
        case 84: character = (ImageIO.read(new File("Obi-Wan (76).png"))); 
        break;
        case 91: character = (ImageIO.read(new File("Obi-Wan (77).png"))); 
        break;
        case 98: character = (ImageIO.read(new File("Obi-Wan (78).png"))); 
        break;
        case 105: character = (ImageIO.read(new File("Obi-Wan (79).png"))); 
        break;
        case 112: character = (ImageIO.read(new File("Obi-Wan (80).png"))); 
        break;
        case 119: character = (ImageIO.read(new File("Obi-Wan (81).png"))); 
        break;
        case 126: character = (ImageIO.read(new File("Obi-Wan (82).png"))); 
        break;
        case 133: character = (ImageIO.read(new File("Obi-Wan (83).png"))); 
        break;
        case 140: character = (ImageIO.read(new File("Obi-Wan (84).png"))); 
        break;
        case 147: character = (ImageIO.read(new File("Obi-Wan (85).png"))); 
        break;
        case 154: character = (ImageIO.read(new File("Obi-Wan (86).png"))); 
        break;
        case 161: character = (ImageIO.read(new File("Obi-Wan (87).png"))); 
        break;
        case 168: character = (ImageIO.read(new File("Obi-Wan (88).png"))); 
        break;
        case 175: character = (ImageIO.read(new File("Obi-Wan (89).png"))); 
        break;
        case 182: character = (ImageIO.read(new File("Obi-Wan (90).png"))); 
        break;
        case 189: character = (ImageIO.read(new File("Obi-Wan (91).png"))); 
        break;
        case 196: character = (ImageIO.read(new File("Obi-Wan (92).png"))); 
        break;
        case 203: character = (ImageIO.read(new File("Obi-Wan (93).png"))); 
        break;
        case 210: character = (ImageIO.read(new File("Obi-Wan (94).png"))); 
        break;
        case 217: character = (ImageIO.read(new File("Obi-Wan (95).png"))); 
        break;
        case 224: character = (ImageIO.read(new File("Obi-Wan (96).png"))); 
        break;
        case 231: character = (ImageIO.read(new File("Obi-Wan (97).png"))); 
        break;
        case 238: character = (ImageIO.read(new File("Obi-Wan (98).png"))); 
        break;
        case 245: character = (ImageIO.read(new File("Obi-Wan (99).png"))); 
        break;
        case 252: character = (ImageIO.read(new File("Obi-Wan (100).png"))); 
        break;
        case 259: character = (ImageIO.read(new File("Obi-Wan (101).png"))); 
        break;
        case 266: character = (ImageIO.read(new File("Obi-Wan (102).png"))); 
        break;
        case 273: character = (ImageIO.read(new File("Obi-Wan (103).png"))); 
        break;
        case 280: character = (ImageIO.read(new File("Obi-Wan (104).png"))); 
        break;
        case 287: meleecnt = 0;
                  melee = false;
                         
        break;
        
        }
            }
            
            if (ma == 1)
            {
                meleefreq = 322;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("Obi-Wan (104).png"))); 
        break;
        case 7: character = (ImageIO.read(new File("Obi-Wan (105).png"))); 
        break;
        case 14: character = (ImageIO.read(new File("Obi-Wan (106).png"))); 
        break;
        case 21: character = (ImageIO.read(new File("Obi-Wan (107).png"))); 
        break;
        case 28: character = (ImageIO.read(new File("Obi-Wan (108).png"))); 
        break;
        case 35: character = (ImageIO.read(new File("Obi-Wan (109).png"))); 
        break;
        case 42: character = (ImageIO.read(new File("Obi-Wan (110).png"))); 
        break;
        case 49: character = (ImageIO.read(new File("Obi-Wan (111).png"))); 
        break;
        case 56: character = (ImageIO.read(new File("Obi-Wan (112).png"))); 
        break;
        case 63: character = (ImageIO.read(new File("Obi-Wan (113).png"))); 
        break;
        case 70: character = (ImageIO.read(new File("Obi-Wan (114).png"))); 
        break;
        case 77: character = (ImageIO.read(new File("Obi-Wan (115).png"))); 
        break;
        case 84: character = (ImageIO.read(new File("Obi-Wan (116).png"))); 
        break;
        case 91: character = (ImageIO.read(new File("Obi-Wan (117).png"))); 
        break;
        case 98: character = (ImageIO.read(new File("Obi-Wan (118).png"))); 
        break;
        case 105: character = (ImageIO.read(new File("Obi-Wan (119).png"))); 
        break;
        case 112: character = (ImageIO.read(new File("Obi-Wan (120).png"))); 
        break;
        case 119: character = (ImageIO.read(new File("Obi-Wan (121).png"))); 
        break;
        case 126: character = (ImageIO.read(new File("Obi-Wan (122).png"))); 
        break;
        case 133: character = (ImageIO.read(new File("Obi-Wan (123).png"))); 
        break;
        case 140: character = (ImageIO.read(new File("Obi-Wan (124).png"))); 
        break;
        case 147: character = (ImageIO.read(new File("Obi-Wan (125).png"))); 
        break;
        case 154: character = (ImageIO.read(new File("Obi-Wan (126).png"))); 
        break;
        case 161: character = (ImageIO.read(new File("Obi-Wan (127).png"))); 
        break;
        case 168: character = (ImageIO.read(new File("Obi-Wan (128).png"))); 
        break;
        case 175: character = (ImageIO.read(new File("Obi-Wan (129).png"))); 
        break;
        case 182: character = (ImageIO.read(new File("Obi-Wan (130).png"))); 
        break;
        case 189: character = (ImageIO.read(new File("Obi-Wan (131).png"))); 
        break;
        case 196: character = (ImageIO.read(new File("Obi-Wan (132).png"))); 
        break;
        case 203: character = (ImageIO.read(new File("Obi-Wan (133).png"))); 
        break;
        case 210: character = (ImageIO.read(new File("Obi-Wan (134).png"))); 
        break;
        case 217: character = (ImageIO.read(new File("Obi-Wan (135).png"))); 
        break;
        case 224: character = (ImageIO.read(new File("Obi-Wan (136).png"))); 
        break;
        case 231: character = (ImageIO.read(new File("Obi-Wan (137).png"))); 
        break;
        case 238: character = (ImageIO.read(new File("Obi-Wan (138).png"))); 
        break;
        case 245: character = (ImageIO.read(new File("Obi-Wan (139).png"))); 
        break;
        case 252: character = (ImageIO.read(new File("Obi-Wan (140).png"))); 
        break;
        case 259: character = (ImageIO.read(new File("Obi-Wan (141).png"))); 
        break;
        case 266: character = (ImageIO.read(new File("Obi-Wan (142).png"))); 
        break;
        case 273: character = (ImageIO.read(new File("Obi-Wan (143).png"))); 
        break;
        case 280: character = (ImageIO.read(new File("Obi-Wan (144).png"))); 
        break;
        case 287: character = (ImageIO.read(new File("Obi-Wan (145).png"))); 
        break;
        case 294: character = (ImageIO.read(new File("Obi-Wan (146).png"))); 
        break;
        case 301: character = (ImageIO.read(new File("Obi-Wan (147).png"))); 
        break;
        case 308: character = (ImageIO.read(new File("Obi-Wan (148).png"))); 
        break;
        case 315: character = (ImageIO.read(new File("Obi-Wan (149).png"))); 
        break;
        case 322: meleecnt = 0;
                  melee = false; 
                  break;
        
        
        }
            }
            
            if (ma == 2)
            {
                meleefreq = 175;
            switch (meleecnt)
        {
        case 1: character = (ImageIO.read(new File("Obi-Wan (150).png")));
        break;
        case 7: character = (ImageIO.read(new File("Obi-Wan (151).png")));
        break;
        case 14: character = (ImageIO.read(new File("Obi-Wan (152).png")));
        break;
        case 21: character = (ImageIO.read(new File("Obi-Wan (153).png")));
        break;
        case 28: character = (ImageIO.read(new File("Obi-Wan (154).png")));
        break;
        case 35: character = (ImageIO.read(new File("Obi-Wan (155).png")));
        break;
        case 42: character = (ImageIO.read(new File("Obi-Wan (156).png")));
        break;
        case 49: character = (ImageIO.read(new File("Obi-Wan (157).png")));
        break;
        case 56: character = (ImageIO.read(new File("Obi-Wan (158).png")));
        break;
        case 63: character = (ImageIO.read(new File("Obi-Wan (159).png")));
        break;
        case 70: character = (ImageIO.read(new File("Obi-Wan (160).png")));
        break;
        case 77: character = (ImageIO.read(new File("Obi-Wan (161).png")));
        break;
        case 84: character = (ImageIO.read(new File("Obi-Wan (162).png")));
        break;
        case 91: character = (ImageIO.read(new File("Obi-Wan (163).png")));
        break;
        case 98: character = (ImageIO.read(new File("Obi-Wan (164).png")));
        y = y - 20;
        break;
        case 105: character = (ImageIO.read(new File("Obi-Wan (165).png")));
        break;
        case 112: character = (ImageIO.read(new File("Obi-Wan (166).png")));
        break;
        case 119: character = (ImageIO.read(new File("Obi-Wan (167).png")));
        break;
        case 126: character = (ImageIO.read(new File("Obi-Wan (168).png")));
        break;
        case 133: character = (ImageIO.read(new File("Obi-Wan (169).png")));
        break;
        case 140: character = (ImageIO.read(new File("Obi-Wan (170).png")));
        break;
        case 147: character = (ImageIO.read(new File("Obi-Wan (171).png")));
        break;
        case 154: character = (ImageIO.read(new File("Obi-Wan (172).png")));
        break;
        case 161: character = (ImageIO.read(new File("Obi-Wan (173).png")));
        break;
        case 168: character = (ImageIO.read(new File("Obi-Wan (174).png")));
        break;
        case 175: meleecnt = 0;
                  melee = false;            
        break;
        
        }
            }
        }
            
        //jumping effect
        if (jumping && !melee)
        {
            jumpcnt++;
        switch (jumpcnt)
        {
        case 1: character = (ImageIO.read(new File("Obi-Wan (341).png")));
        break;
        case 8: character = (ImageIO.read(new File("Obi-Wan (342).png")));
        break;
        case 16: character = (ImageIO.read(new File("Obi-Wan (343).png")));
        break;
        case 24: character = (ImageIO.read(new File("Obi-Wan (344).png")));
        break;
        case 32: character = (ImageIO.read(new File("Obi-Wan (345).png")));
        break;
        case 40: character = (ImageIO.read(new File("Obi-Wan (342).png"))); 
        break;
        case 48: character = (ImageIO.read(new File("Obi-Wan (343).png")));
        break;
        case 56: character = (ImageIO.read(new File("Obi-Wan (344).png")));
        break;
        case 64: character = (ImageIO.read(new File("Obi-Wan (345).png")));
        break;
        case 72: character = (ImageIO.read(new File("Obi-Wan (342).png")));
        break;
        case 80: character = (ImageIO.read(new File("Obi-Wan (343).png")));
        break;
        case 88: character = (ImageIO.read(new File("Obi-Wan (344).png")));
        break;
        case 96: character = (ImageIO.read(new File("Obi-Wan (345).png"))); 
        break;
        case 104: character = (ImageIO.read(new File("Obi-Wan (342).png")));
        break;
        case 112: character = (ImageIO.read(new File("Obi-Wan (343).png")));
        break;
        case 120: character = (ImageIO.read(new File("Obi-Wan (344).png")));
        break;
        case 128: character = (ImageIO.read(new File("Obi-Wan (345).png"))); 
        break;
        case 136: character = (ImageIO.read(new File("Obi-Wan (346).png")));
        break;
        case 144: character = (ImageIO.read(new File("Obi-Wan (347).png")));
        break;
        }
        }
        
        
        if (melee == false && block == false && shooting == false && !jumping)
        {
            
        switch (runcnt)
        {
        case 0: character = (ImageIO.read(new File("Obi-Wan (354).png")));
        break;
        case 10: character = (ImageIO.read(new File("Obi-Wan (355).png")));
        break;
        case 20: character = (ImageIO.read(new File("Obi-Wan (356).png")));
        break;
        case 30: character = (ImageIO.read(new File("Obi-Wan (357).png")));
        break;
        case 40: character = (ImageIO.read(new File("Obi-Wan (358).png")));
        break;
        case 50: character = (ImageIO.read(new File("Obi-Wan (359).png")));
        break;
        case 60: character = (ImageIO.read(new File("Obi-Wan (360).png")));
        break;
        case 70: character = (ImageIO.read(new File("Obi-Wan (361).png")));
        break;
        case 80: character = (ImageIO.read(new File("Obi-Wan (362).png")));
        break;
        case 90: character = (ImageIO.read(new File("Obi-Wan (363).png")));
        break;
        case 100: character = (ImageIO.read(new File("Obi-Wan (364).png")));
        break;
        case 110: character = (ImageIO.read(new File("Obi-Wan (365).png")));
        break;
        case 120: character = (ImageIO.read(new File("Obi-Wan (366).png")));
        break;
        case 130: character = (ImageIO.read(new File("Obi-Wan (367).png")));
        break;
        case 140: character = (ImageIO.read(new File("Obi-Wan (368).png")));
        break;
        case 150: character = (ImageIO.read(new File("Obi-Wan (369).png")));
        break;
        case 160: character = (ImageIO.read(new File("Obi-Wan (370).png")));
        break;
        case 170: character = (ImageIO.read(new File("Obi-Wan (371).png")));
        break;
        case 180: character = (ImageIO.read(new File("Obi-Wan (372).png")));
        break;
        case 190: character = (ImageIO.read(new File("Obi-Wan (373).png")));
        break;
        case 200: character = (ImageIO.read(new File("Obi-Wan (374).png")));
        break;
        case 210: character = (ImageIO.read(new File("Obi-Wan (375).png")));
        break;
        case 220: character = (ImageIO.read(new File("Obi-Wan (376).png")));
        break;
        case 230: character = (ImageIO.read(new File("Obi-Wan (377).png")));
        break;
        case 240: character = (ImageIO.read(new File("Obi-Wan (378).png")));
        break;
        case 250: character = (ImageIO.read(new File("Obi-Wan (379).png")));
        break;
        case 260: character = (ImageIO.read(new File("Obi-Wan (380).png")));
        break;
        case 270: character = (ImageIO.read(new File("Obi-Wan (381).png")));
        break;
        case 280: character = (ImageIO.read(new File("Obi-Wan (382).png")));
        break;
        case 290: character = (ImageIO.read(new File("Obi-Wan (383).png")));
        break;
        case 300: character = (ImageIO.read(new File("Obi-Wan (384).png")));
        break;
        case 310: character = (ImageIO.read(new File("Obi-Wan (385).png")));
        break;
        case 320: character = (ImageIO.read(new File("Obi-Wan (386).png")));
        break;
        case 330: character = (ImageIO.read(new File("Obi-Wan (387).png")));
        break;
        case 340: character = (ImageIO.read(new File("Obi-Wan (388).png")));
        break;
        }
        }
        
        
        
        if (block == true && melee == false && !jumping)
        { 
        runspeed = 2;
        switch (blockcnt)
        {
        case 0: character = (ImageIO.read(new File("Obi-Wan (96).png")));
        break;
        case 10: character = (ImageIO.read(new File("Obi-Wan (97).png")));
        break;
        case 20: character = (ImageIO.read(new File("Obi-Wan (98).png")));
        break;
        case 30: character = (ImageIO.read(new File("Obi-Wan (99).png")));
        break;
        case 40: character = (ImageIO.read(new File("Obi-Wan (100).png")));
        break;
        case 50: character = (ImageIO.read(new File("Obi-Wan (101).png")));
        break;
        case 60: character = (ImageIO.read(new File("Obi-Wan (102).png")));
        break;
        case 70: character = (ImageIO.read(new File("Obi-Wan (103).png")));
        break;
        case 80: blockcnt = 0;
                  character = (ImageIO.read(new File("Obi-Wan (34).png")));
                  block = false;
        }
        blockcnt++;
        }
        
        
        
        if (runcnt >= 340)
        {
            runcnt = 0;
        }

        height = character.getHeight(); 
        if (right == true)
        {
            width = -character.getWidth();
            if((((meleecnt > 42 && meleecnt <= 105) || (meleecnt > 133 &&
                    meleecnt <= 203)) && ma == 0) || (((meleecnt > 35 && 
                    meleecnt <= 119) || (meleecnt > 189 && meleecnt <= 252))
                    && ma == 1) || ((meleecnt > 56 && meleecnt <= 133)
                    && ma == 2))
            {
             g.setColor(Color.GREEN);
             meleebox = new Rectangle2(x-width/2-45,
                     y,character.getWidth()+15,height);
            }
            else
            {
             meleebox = new Rectangle2(); 
            }

        g.drawImage(character, x + width/2 - f, y, -width, height, null);
        hbox = new Rectangle(x+width/2,y,character.getWidth(),height);
        gunx = x+width/2 - width - 10;
        guny = y+(int)((2*height)/5) - 15;
        footbox = new Rectangle2(x+width/2,y + height - 15,
                character.getWidth(),15);
        g.setColor(Color.BLUE);

        }
        
        if (left == true)
        {
            width = character.getWidth();
            if((((meleecnt > 42 && meleecnt <= 105) || 
                    (meleecnt > 133 && meleecnt <= 203)) && ma == 0) || 
                    (((meleecnt > 35 && meleecnt <= 119) || (meleecnt > 189 
                    && meleecnt <= 252)) && ma == 1) || ((meleecnt > 56 && 
                    meleecnt <= 133) && ma == 2))
            {   
             g.setColor(Color.GREEN);
             meleebox = new Rectangle2(x-width - width/3 + 22 ,
                     y,character.getWidth() + 15,height);
            }
            else
            {
             meleebox = new Rectangle2(); 
            }

        g.drawImage(character, x + width/2 + f, y, -width, height, null); 
        hbox = new Rectangle(x-width/3,y,character.getWidth(),height);
        gunx = x - width + 14;
        guny = y+(int)((2*height)/5) - 15;
        footbox = new Rectangle2(x-width/3,y + height - 15,
                character.getWidth(),15);
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
        character = (ImageIO.read(new File("Obi-Wan (34).png"))); 
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
        
    }
    


