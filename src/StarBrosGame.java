package starbrosgame;
import java.io.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import javax.sound.sampled.LineUnavailableException;
import static starbrosgame.IntegerToWord.toWords;

public class StarBrosGame extends JPanel implements MouseListener,
        MouseMotionListener, KeyListener
{
    //ALL THE IMAGES BEING USED FOR THE USER INTERFACE AND BACKGROUND
    ///////////
    private Image backgroundImg;
    private Image menubackground;
    private Image map1menuimg;
    private Image map2menuimg;
    private Image startbutton;
    private Image optionsbutton;
    private Image exitbutton;
    private Image exitbutton2;
    private Image backbutton;
    private Image optionsmenu;
    private Image helpmenu;
    private Image applybutton;
    private Image resetbutton;
    private Image backbutton2;
    private Image statsmenu;
    private Image acceptbutton;
    private Image playbutton;
    private Image infobutton;
    ////////////////
    
    private Character player[] = new Character[4]; 
    private boolean grounded[] = new boolean[player.length]; 
    private int clickcnt = 0; //counts the number of clicks
    private boolean right[] = new boolean[player.length];
    private boolean left[] = new boolean[player.length];
    private Rectangle2[] floor = new Rectangle2[100];
    private Rectangle2[] wall = new Rectangle2[100];
    private String map = new String();
    private int numfloors;
    private Bullet bullet[][] = new Bullet[player.length][50000];
    private int n[] = new int[player.length];
    private int[] playerscore = new int[player.length];
    private JLabel[] scoreLabel = new JLabel[player.length];
    private JLabel winnerLabel = new JLabel();
    private boolean start = false;
    private JLabel dividerLabel[] = new JLabel[player.length];
    private int doubletappedinterval = 55;
    private boolean[][] pressedrecently = new boolean[player.length][2];
    private int presscnt[][] = new int[player.length][2];
    private int pressedrecentlycnt[][] = new int[player.length][2];
    private boolean key[] = new boolean[600];
    private boolean keyreleased[] = new boolean[600];
    private int djint[] = new int[player.length];
    private int totalplayers = 0;
    private double gravityMultiplier = 0.5;
    private WeatherEffects w = new WeatherEffects();
    private boolean raining = false;
    private Color plc[] = new Color[player.length]; //player label colour
    private int ikey[][] = new int[player.length][6]; //the integer
    //representation of a key on the keyboard
    
    //Constants used to represent the key for a characters actions.
    ///////////////
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int JUMP = 2;
    public static final int FIRE = 3;
    public static final int SPECIAL = 4;
    public static final int SECONDARY = 5;
    /////////////////
    
    private int releasedkey = 0;
    private int totaldead = 0;
    private boolean out[] = new boolean[player.length]; 
    // the player is either in the round or out (if they died).
    
    protected boolean roundOver = false;
    private String winm = ""; //win message
    private Color winc; //winning character
    private Font stjedise; //the font being used
    private boolean nextRound = true; //"round" as in "ROUND 1, FIGHT!" 
    private int round = 1; 
    
    int[] stateOfVerticalMotion = new int[player.length]; 
    //does calculations with the jumping and falling of a player.
    //a boolean would not suffice as the character is 
    //either falling down, jumping up, or grounded.
    
    private Vector spawnspot[] = new Vector[player.length];//the spawn location
    
    private AI bot[] = new AI[player.length];
    private int totalbots = 0;
    private boolean mainmenu;
    
    private int totalCharacters = 13; // there are 13 characters in total
    private int totalHeroes = 4; // of which 4 are heroes
    private int characterID[] = new int[totalCharacters];
    private String characterName[] = new String[totalCharacters];
    private String attackType1[] = new String[totalCharacters];
    private int damageRating1[] = new int[totalCharacters];
    private int health[] = new int[totalCharacters];
    private int attackRange1[] = new int[totalCharacters];
    private String specialAbility[] = new String[totalCharacters];
    private String secondaryAbility[] = new String[totalCharacters];
    private String characterImageStr[] = new String[totalCharacters];
    private Image characterImage[] = new Image[totalCharacters];
    private int speed1[] = new int[totalCharacters];
    
    private int menucnt = 0; //menu counter
    private boolean options = false;
    private boolean mapselection = false;
    private boolean characterselection = false;
    private Rectangle2 menubuttonbox[] = new Rectangle2[10];
    private Rectangle2 clickbox = new Rectangle2();
    private int pcnt = 0; //player counter
    private int playercharacterint[] = new int[player.length]; 
    //the integer representing the character the player has chosen to play as
    
    private Rectangle2 cmenubox[] = new Rectangle2[totalCharacters];
    //The Rectangle2s used in the character menu (for character choice).
    private int idlecnt[] = new int [player.length]; //idle counter
    private int mmcnt = 0; //main menu counter
    public Audio audio[] = new Audio[3];

    
    private boolean mbp = false; //menu button pressed
    private boolean bbp = false; // basic button pressed
    
    private Slider slider[] = new Slider[5]; //(the 5th is a temp)
    
    private boolean mousePressed = false;
    
    private Rectangle2 pressbox = new Rectangle2();
    
    private Connection con;
    private float mastervol; //the maservolume
    private boolean selected[] = new boolean[player.length];
    //whether or not the player has chosen a character.
    
    private Rectangle2 statsBar[] = new Rectangle2[4];
    //the bars that are used to display the different characters stats
    //from the database
    
    private boolean help = false;
   
/**
 * Constructor that initializes all necessary variables for the game 
 * loop (and paintComponent)
 * to function properly.
 * @throws IOException
 * @throws SQLException
 * @throws LineUnavailableException 
 */
public StarBrosGame()throws IOException, SQLException, LineUnavailableException
{
      menubackground = new javax.swing.ImageIcon(getClass()
              .getResource("Mission1Map.jpg")).getImage();
      map1menuimg = new javax.swing.ImageIcon(getClass()
              .getResource("mangroveBackground.png")).getImage();
      map2menuimg = new javax.swing.ImageIcon(getClass()
              .getResource("gamebi.jpg")).getImage();
      startbutton = new javax.swing.ImageIcon(getClass()
              .getResource("start.png")).getImage();
      optionsbutton = new javax.swing.ImageIcon(getClass()
              .getResource("options.png")).getImage();
      exitbutton = new javax.swing.ImageIcon(getClass()
              .getResource("exit.png")).getImage();
      exitbutton2 = new javax.swing.ImageIcon(getClass()
              .getResource("exit2.png")).getImage();
      backbutton = new javax.swing.ImageIcon(getClass()
              .getResource("back.png")).getImage();
      optionsmenu = new javax.swing.ImageIcon(getClass()
              .getResource("OptionsMenu.png")).getImage();
      helpmenu = new javax.swing.ImageIcon(getClass()
              .getResource("HelpMenu.png")).getImage();
      backbutton2 = new javax.swing.ImageIcon(getClass()
              .getResource("back2.png")).getImage();
      statsmenu = new javax.swing.ImageIcon(getClass()
              .getResource("stats.png")).getImage();
      acceptbutton = new javax.swing.ImageIcon(getClass()
              .getResource("Accept.png")).getImage();
      playbutton = new javax.swing.ImageIcon(getClass()
              .getResource("play.png")).getImage();
      infobutton = new javax.swing.ImageIcon(getClass()
              .getResource("info.png")).getImage();
      
      for (int i = 0; i < 5; i++)
      {
      slider[i] = new Slider(new javax.swing.ImageIcon(getClass().
      getResource("Slider.png")).getImage(), 685 - 
      (int)(new javax.swing.ImageIcon(getClass()
      .getResource("Slider.png")).getImage()
      .getWidth(null)/2), 276 + i*50
      - (int)(new javax.swing.ImageIcon(getClass()
      .getResource("Slider.png")).getImage().getHeight(null)/2), 590, 780 
      - (int)(new javax.swing.ImageIcon(getClass().getResource("Slider.png"))
      .getImage().getWidth(null)));
      }
      
      resetbutton = new javax.swing.ImageIcon(getClass()
              .getResource("reset.png")).getImage();
      applybutton = new javax.swing.ImageIcon(getClass()
              .getResource("Apply.png")).getImage();
      mainmenu = true;
      
      for (int i = 0; i < 3; i++)
      {
          audio[i] = new Audio();
      }
      for (int i = 0; i < 4; i++)
      {
          selected[i] = false;
      }

    try {
    stjedise = Font.createFont(Font.TRUETYPE_FONT, new File("STJEDISE.ttf"));
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    ge.registerFont(stjedise);
    stjedise = stjedise.deriveFont(48f);
        } catch (FontFormatException ex) {
     Logger.getLogger(StarBrosGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        String URL = "jdbc:derby://localhost:1527/StarBros"; 
        String USER = "waitd"; 
        String PASS = "asdf123";
        con = DriverManager. getConnection(URL, USER, PASS);
        updateVariablesFromTable(con, "CHARACTERS"); 
        positionSlidersFromTable();
        
        for (int i = 0; i < totalCharacters - totalHeroes; i++)
        {
            
            characterImage[i] = 
                    new javax.swing.ImageIcon(getClass()
                            .getResource(characterImageStr[i]))
                            .getImage();
            System.out.println("CharacterID: " + characterID[i] +
                    "\nCharacterName: " + characterName[i] + "\nAttackType1: "
                    + attackType1[i]
                    + "\nDamageRating1: " + damageRating1[i] + "\nHealth: " +
                    health[i] + "\nAttackRange1: " + attackRange1[i] + 
                    "\nSpecialAbility: "+ specialAbility[i] + 
                    "\nSecondaryAbility: " + secondaryAbility[i] + 
                    "\ncharacterImage: " + characterImageStr[i] + "\nspeed1: "
                    + speed1[i]
                    + "\n***");
        }

            map = "";
            player[0] = new Character();
            player[1] = new Character();
            player[2] = new Character();
            player[3] = new Character();
            
            plc[0] = new Color(15,100,255);
            plc[1] = new Color(255,50,50);
            plc[2] = new Color(255,255,15);
            plc[3] = new Color(15,255,60);
            
            ikey[0][0] = KeyEvent.VK_W;
            ikey[0][1] = KeyEvent.VK_R;
            ikey[0][2] = KeyEvent.VK_E;
            ikey[0][3] = KeyEvent.VK_1;
            ikey[0][4] = KeyEvent.VK_2;
            ikey[0][5] = KeyEvent.VK_3;
            
            ikey[1][0] = KeyEvent.VK_U;
            ikey[1][1] = KeyEvent.VK_O;
            ikey[1][2] = KeyEvent.VK_I;
            ikey[1][3] = KeyEvent.VK_OPEN_BRACKET;
            ikey[1][4] = KeyEvent.VK_CLOSE_BRACKET;
            ikey[1][5] = KeyEvent.VK_BACK_SLASH;
            
            ikey[3][0] = KeyEvent.VK_LEFT;
            ikey[3][1] = KeyEvent.VK_RIGHT;
            ikey[3][2] = KeyEvent.VK_UP;
            ikey[3][3] = KeyEvent.VK_COMMA;
            ikey[3][4] = KeyEvent.VK_PERIOD;
            ikey[3][5] = KeyEvent.VK_SLASH;
            
            ikey[2][0] = KeyEvent.VK_NUMPAD4;
            ikey[2][1] = KeyEvent.VK_NUMPAD6;
            ikey[2][2] = KeyEvent.VK_NUMPAD5;
            ikey[2][3] = KeyEvent.VK_NUMPAD8;
            ikey[2][4] = KeyEvent.VK_NUMPAD9;
            ikey[2][5] = KeyEvent.VK_ADD;    
            
            addMouseListener(this);
            addMouseMotionListener(this);
            addKeyListener(this);
    
}

  

  
 /**
 * Simulates the game and its interaction with the user, as well as paints the
 * game's panel.
 */
    @Override
    public void paintComponent(Graphics g) {
       setFocusable(true);
       g.setColor(Color.BLACK);
       
       //Eveything happening before the game has started
       //////////////////////////////
       if (!start)
       {
           try {
               Thread.sleep(1);
           } catch (InterruptedException ex) {
               Logger.getLogger(StarBrosGame.class.getName()).log(Level.SEVERE, null, ex);
           }
           if (mmcnt == 0) //if the menu has just started showing
           {
               
           audio[2].close();
           for (int i = 0; i < 4; i++)
           {
               if (i == 0) //applies the effect of the master volume slider.
               {
                double d1 = slider[i].getX();
                double d2 = slider[i].getMinX();
                double d3 = ((d1 - d2)/119.0);
                mastervol = (float)(((d3)/2) + 0.5);  
                if (d3 == 0)
                {
                    mastervol = 0;
                }
               }
               if (i != 0) // applies the effect of the other volume sliders.
               {
                double d1 = slider[i].getX();
                double d2 = slider[i].getMinX();
                double d3 = ((d1 - d2)/119.0);
                float floaty = (float)(((d3)/2 + 0.5)*mastervol);
                if (d3 == 0)
                {
                    floaty = 0;
                }
                audio[i-1].setVolume(floaty);
               }
           }
           //random chance to play one of these two songs in the menu.
           if ((int)(Math.random()*2) > 0)
           {
           audio[2].play("RevanTheme.wav");
           }
           else
           {
           audio[2].play("VodeAn.wav");   
           }
           mmcnt = 1; //so that this if statement only happens once in menu.
           
           }
           g.drawImage(menubackground, -menucnt, 0, null);
           //makes the background image move across the screen.
               menucnt++;
               if (menucnt >= 8720)
               {
                   menucnt = 0;
               }
       }
       //was a menu button pressed?
       if (mbp)
       {
           audio[0].playOnce("Gungan-Shield2.wav");
           mbp = false;
           clickbox = new Rectangle2(0,0,0,0);
       }
       
       //was a basic button pressed?
       if (bbp)
       {
           audio[0].playOnce("Probe-Gun.wav");
           bbp = false;
           clickbox = new Rectangle2(0,0,0,0);
       }
          
       //are we in the main menu?   
       if (mainmenu && !help)
       {
               menubuttonbox[0] = new Rectangle2(600, 250, 200, 80);
               menubuttonbox[1] = new Rectangle2(600, 375, 200, 80);
               menubuttonbox[2] = new Rectangle2(600, 500, 200, 80);
               menubuttonbox[3] = new Rectangle2(1248, 0, 32, 32);
           try {
               g.setColor(new Color(237, 125, 49));
               menubuttonbox[3].fill(g);
               g.setColor(Color.BLACK);
           } catch (IOException ex) {
               Logger.getLogger(StarBrosGame.class.getName())
                       .log(Level.SEVERE, null, ex);
           }
               g.drawImage(startbutton, 600, 250, 200, 80, null);
               g.drawImage(optionsbutton, 600, 375, 200, 80, null);
               g.drawImage(exitbutton, 600, 500, 200, 80, null);
               g.drawImage(infobutton, 1248, 0, 32, 32, null);
           if (clickbox.intersects(menubuttonbox[0]))
           {
               mapselection = true;
               mainmenu = false;
               mbp = true;
               //System.out.println("PUSHED PLAY");
           }
           if (clickbox.intersects(menubuttonbox[1]))
           {
               mbp = true;
               mainmenu = false;
               options = true;
               //System.out.println("PUSHED OPTIONS");
           }
           if (clickbox.intersects(menubuttonbox[2]))
           {
               mbp = true;
               //System.out.println("PUSHED EXIT");
               System.exit(0);
           }  
               if (clickbox.intersects(menubuttonbox[3]))
               { 
                 help = true;
                 mainmenu = false;
                 bbp = true;
                 //System.out.println("PUSHED HELP");
               }
               

               
       }
       //are we in the help menu?
       if (help)
       {
           g.drawImage(helpmenu, 400, 120, null);
           g.drawImage(backbutton, 0, 0, 100, 100, null); 
           menubuttonbox[0] = new Rectangle2(0, 0, 100, 100);
           if (clickbox.intersects(menubuttonbox[0]))
           {
               help = false;
               mainmenu = true;
               mbp = true;
           }
       }
       //ARE WE IN THE MAP SELECTION MENU?
       if (mapselection)
       {
           g.drawImage(map1menuimg, 300, 200, 300, 300, null);
           g.drawImage(map2menuimg, 800, 200, 300, 300, null);
           menubuttonbox[3] = new Rectangle2(300, 200, 300, 300);
           menubuttonbox[4] = new Rectangle2(800, 200, 300, 300);
           menubuttonbox[5] = new Rectangle2(650, 100, 100, 100);
           g.drawImage(backbutton, 650, 100, 100, 100, null);
           
           //WHICH MAP DO YOU CHOOSE?
           /////////////
           if (clickbox.intersects(menubuttonbox[3]))
           {
              backgroundImg = new javax.swing.ImageIcon(getClass()
                      .getResource("mangroveBackground.png")).getImage();
              map = "MANGROVES";
              mapselection = false;
              characterselection = true;
              mbp = true;
           }
           if (clickbox.intersects(menubuttonbox[4]))
           {
               map = "JUNGLE";
               backgroundImg = new javax.swing.ImageIcon(getClass()
                       .getResource("gamebi.jpg")).getImage();
               mapselection = false;
               characterselection = true;
               mbp = true;
           }
           ///////////////
           
           //or do you want to go back?
           if (clickbox.intersects(menubuttonbox[5]))
           {
               mainmenu = true;
               mapselection = false;
               mbp = true;
           }
       }
       //ARE WE IN THE OPTIONS MENU?
       if (options)
       {
            menubuttonbox[0] = new Rectangle2(725, 470, 150, 57); // apply
            menubuttonbox[1] = new Rectangle2(575, 470, 150, 57); // reset
            menubuttonbox[2] = new Rectangle2(425, 470, 150, 57); // back
           g.drawImage(optionsmenu, 400, 120, null);
           g.drawImage(applybutton, 725, 470, 150, 57, null);
           g.drawImage(resetbutton, 575, 470, 150, 57, null);
           g.drawImage(backbutton2, 425, 470, 150, 57, null);
           for (int i = 0; i < 4; i++)
           {
               slider[i].draw(g);
           }
           if (mousePressed) //did we press the left mouse button?
           { 
           
           for (int i = 0; i < 4; i++)
           {
               if (pressbox.intersects(slider[i].getBox()) 
                       && !slider[i].hasMoved())
               {
                   slider[i].setMoved(true);
               }
               if (pressbox.intersects(slider[i].getBox()) 
                       && slider[i].getApplied())
               {
                   slider[i].saveTempX();
                   slider[i].setApplied(false);
               }
           }
           
           
           for (int i = 0; i < 4; i++)
           {
               if (slider[i].hasMoved())
               {
               slider[i].setX(MouseInfo.getPointerInfo()
                       .getLocation().x - (int)(new javax.swing
                               .ImageIcon(getClass()
                               .getResource("Slider.png")).getImage()
                               .getWidth(null)/2)); 
               }
           }
           } 
           if (!mousePressed)
           {
               for (int i = 0; i < 4; i++)
               {
               slider[i].setMoved(false);
               }
           }

           if (clickbox.intersects(menubuttonbox[0])) //apply
           {
            
            for (int i = 0; i < 4; i++)
           {
               
                mbp = true;
                if (i == 0 && !slider[i].getApplied())
                {
                 double d1 = slider[i].getX();
                 double d2 = slider[i].getMinX();
                 double d3 = ((d1 - d2)/119.0);
                 mastervol = (float)(((d3)/2) + 0.5);
                 if (d3 == 0)
                 {
                    mastervol = 0;
                 }
                 System.out.println(mastervol + "123");
                }
                if (i != 0)
                {
                 double d1 = slider[i].getX();
                 double d2 = slider[i].getMinX();
                 double d3 = ((d1 - d2)/119.0);
                 float floaty = (float)(((d3)/2 + 0.5)*mastervol);
                if (d3 == 0)
                {
                    floaty = 0;
                }
                 if (i == 3)
                 {
                  audio[i-1].stop();
                 }
                 audio[i-1].setVolume(floaty);
                 if (i == 3)
                 {
                  audio[i-1].start();
                 }
                }
                System.out.println(slider[i].getDisplacementMoved());
                slider[i].saveTempX();
                slider[i].setMoved(false);
                slider[i].setApplied(true);
                try {
                    UpdateTable(con, "SLIDERTABLE", "X",
                            slider[i].getX(), "SLIDERID", i+1);
                } catch (SQLException ex) {
                    Logger.getLogger(StarBrosGame.class
                            .getName()).log(Level.SEVERE, null, ex);
                }  
           
           }
           }
           
           if (clickbox.intersects(menubuttonbox[1])) //reset
           {
            mbp = true;
            for (int i = 0; i < 4; i++)
            {
              slider[i].setX(1000);
            }
           }
           
           if (clickbox.intersects(menubuttonbox[2])) //back
           {
                try {
                    positionSlidersFromTable();
                } catch (SQLException ex) {
                    Logger.getLogger(StarBrosGame.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            mainmenu = true;
            options = false;
            mbp = true;
           }
           
       }
       if (characterselection && pcnt < 4) //are we in the character selection?
      {
           g.setColor(plc[pcnt]);
           menubuttonbox[6] = new Rectangle2(0, 0, 70, 70);
           g.drawImage(backbutton, 0, 0, 70, 70, null); 
           g.drawImage(acceptbutton, 1000, 100, 150, 70, null); 
           g.drawImage(playbutton, 1000, 200, 150, 70, null);
           g.drawImage(backgroundImg, 1000, 300, 150, 150, null); 
           menubuttonbox[5] = new Rectangle2(1000, 100, 150, 70);
           menubuttonbox[4] = new Rectangle2(1000, 200, 150, 70);
           g.drawImage(statsmenu, 400, 100, null); 
          
           //do we want to go back to the mapselection?
           if (clickbox.intersects(menubuttonbox[6]))
           {
               characterselection = false;
               mapselection = true;
               mbp = true;
               totalplayers = 0;
               totalbots = 0;
               pcnt = 0;
               for (int i = 0; i < 4; i++)
               {
                   selected[i] = false;
               }
           }
           
           //Are we sure we want to play a character, if so click apply!
           if (clickbox.intersects(menubuttonbox[5]) && selected[pcnt])
           {
               mbp = true;
               totalplayers++; 
               pcnt++;  
           }
           if (pcnt < 4)
           {
           if (selected[pcnt])
           {
                statsBar[0] = new Rectangle2((int)(560/8)*1 + 400 - 20, 
                200, 40 , (int)(damageRating1[playercharacterint[pcnt]]*2.4));
                
                statsBar[1] = new Rectangle2((int)(560/8)*3 + 400 - 20, 
                200, 40, (int)((health[playercharacterint[pcnt]]/4)*2.4));
                
                statsBar[2] = new Rectangle2((int)(560/8)*5 + 400 - 20, 
               200, 40, (int)((attackRange1[playercharacterint[pcnt]]/11)*2.4));
                
                statsBar[3] = new Rectangle2((int)(560/8)*7 + 400 - 20, 
                200, 40, (int)((speed1[playercharacterint[pcnt]]*9)*2.4));
//draws bar graphs to display the characters stats               
                for (int i = 0; i < 4; i++)
                {
                    try {
                        statsBar[i].fill(g);
                    } catch (IOException ex) {
                        Logger.getLogger(StarBrosGame.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }
                }
           }
           
           // a visual display of the different characters to choose from.
           for (int i = 0; i < 2; i++)
           {
              for (int j = 0; j < 5 - i; j++)
              {   
                  cmenubox[j + i*5] = new Rectangle2(100 + i*100,
                          100 + j*60, 50, 50);
                  try {
                      if (j + i*5 == playercharacterint[pcnt] && selected[pcnt])
                      {
                          g.setColor(Color.BLACK);
                      }
                      cmenubox[j + i*5].fill(g);
                      g.drawImage(characterImage[j + i*5],105 + i*100,
                              105 + j*60, 40, 40, null);
                  } catch (IOException ex) {
                      Logger.getLogger(StarBrosGame.class.getName())
                              .log(Level.SEVERE, null, ex);
                  }
                  g.setColor(plc[pcnt]);
              }
           }
           //Let the next player choose a character if the previous player
           //has already chosen one.
           for (int i = 0; i < 9; i++)
           {
               if (clickbox.intersects(cmenubox[i]))
               {
                   playercharacterint[pcnt] = characterID[i] - 1;
                   bbp = true;
                   selected[pcnt] = true;
               }
           }
             }
           //start the game if everyone has chosen their characters
           //or the Play button was pressed.
           if (pcnt == 4 || 
                   clickbox.intersects(menubuttonbox[4]))
           {
            totalbots = 4 - totalplayers; //fill the rest of the player
            //slots with artificial intelligence.
            start = true;
             for (int i = totalplayers; i < totalbots + totalplayers; i++)
             {
              playercharacterint[i] = (int)(Math.random()*9);  
             }
           }
           //If the enter key is pressed, the game starts but with zero bots.
           if (key[KeyEvent.VK_ENTER] && totalplayers > 1)
           {
            totalbots = 0;
            start = true;
           }
           
           //initializes the game and map settings just before the game starts.
      if (start)
      {
           if (map.equals("JUNGLE"))
      {   
       backgroundImg = new javax.swing.ImageIcon(getClass()
               .getResource("gamebi.jpg")).getImage();
       floor[0] = new Rectangle2(-30,500 + 53,390,6);
       floor[1] = new Rectangle2(390,485 + 53,180,6);
       floor[2] = new Rectangle2(570,550 + 53,120,6);
       floor[3] = new Rectangle2(690,485 + 53,30,6);
       floor[4] = new Rectangle2(720,455 +  53,55,30);
       floor[5] = new Rectangle2(775,430 +  53,118,30);
       floor[6] = new Rectangle2(1030,500 +  53,300,6);
       floor[7] = new Rectangle2(475,350 +  53,90,6);
       floor[8] = new Rectangle2(327,325 +  53,55,6);
       floor[9] = new Rectangle2(190,275 + 53 -  53,75,6);
       floor[10] = new Rectangle2(65,335-53 +  53,90,6);
       floor[11] = new Rectangle2(1116,187-53 +  53,100,6);
       floor[12] = new Rectangle2(215,425-53 + 53,50,6);
       floor[13] = new Rectangle2(1240,235-53 +  53 + 1,200,6);
       floor[14] = new Rectangle2(361, 543, 30, 10);
       wall[0] = new Rectangle2(570,585,1,125);
       wall[1] = new Rectangle2(690,585,1,125);
       wall[2] = new Rectangle2(1030,540 + 53,1,200);
       wall[3] = new Rectangle2(893,450 + 53,1,300);
       spawnspot[0] = new Vector(110, 0);
       spawnspot[1] = new Vector(526, 0);
       spawnspot[2] = new Vector(830, 0);
       spawnspot[3] = new Vector(1180, 0);
        numfloors = 15;   
       }
      
      if (map.equals("MANGROVES"))
      {   
       backgroundImg = new javax.swing.ImageIcon(getClass()
               .getResource("mangroveBackground.png")).getImage();
       floor[0] = new Rectangle2(212,240,350,12);
       floor[1] = new Rectangle2(150,390,140,12);
       floor[2] = new Rectangle2(420,424,455,12);
       floor[3] = new Rectangle2(785,195,180,12);
       floor[4] = new Rectangle2(915,355,205,12);
       Vector temp[] = new Vector[4];
        temp[0] = new Vector(180, 330);
        temp[1] = new Vector(440, 200);
        temp[2] = new Vector(685, 370);
        temp[3] = new Vector(1080, 300);
        int a = 0;
        boolean placed[] = new boolean[totalplayers + totalbots];
        boolean taken[] = new boolean[4];
        
        for (int i = 0; i < totalplayers + totalbots; i++)
        {
          while (!placed[i])
          {
              a = (int)(Math.random()*4);
              if (!taken[a])
              {
                  placed[i] = true;
                  spawnspot[i] = temp[a];
                  taken[a] = true;
              }
          }        
        }
        numfloors = 5; 
       }
      for (int i = 0; i < totalplayers + totalbots; i++)
            {
          try { 
              switch (playercharacterint[i])
              {
                  case 0: player[i] = new Droideka();
                  break;
                  case 1: player[i] = new FlameTrooper();
                  break;
                  case 2: player[i] = new HeavyTrooper();
                  break;
                  case 3: player[i] = new JumpTrooper();
                  break;
                  case 4: player[i] = new MeleeDroid();
                  break;
                  case 5: player[i] = new ShotgunTrooper();
                  break;
                  case 6: player[i] = new SniperTrooper();
                  break;
                  case 7: player[i] = new SpecialistTrooper();
                  break;
                  case 8: player[i] = new SuperBattleDroid();
                  break;  
              }
              if ((int)(Math.random()*100) < 15)
                {
                int b = (int)(Math.random()*(totalHeroes));
                
                switch (b)
                {
                    case 0: player[i] = new CountDooku();
                    break;
                    case 1: player[i] = new Anakin();
                    break;
                    case 2: player[i] = new ObiWanKenobi();
                    break;
                    case 3: player[i] = new GeneralGrievous();
                    break;
                    
                }
                }
          } 
          catch (IOException ex) {
              Logger.getLogger(StarBrosGame.class.getName())
                      .log(Level.SEVERE, null, ex);
          }
          
            }

            for (int i = 0; i < totalplayers + totalbots; i++)
            {
               try {
                   player[i].FaceDirection("right");
                   player[i].Run();
                   player[i].setNumber(i+1);
                   scoreLabel[i] = new JLabel();
                   add(scoreLabel[i]);
                   grounded[i] = false;
                   idlecnt[i] = 0;
                   left[i] = false;
                   right[i] = false;
                   n[i] = 0;
                   playerscore[i] = 0;
                   pressedrecently[i][0] = false;
                   pressedrecently[i][1] = false;
                   pressedrecentlycnt[i][1] = 0;
                   pressedrecentlycnt[i][0] = 0;
                   player[i].setLDS(i);
                   presscnt[i][0] = 0;
                   presscnt[i][1] = 0;
                   dividerLabel[i] = new JLabel(":");
                   stateOfVerticalMotion[i] = 0;
                   player[i].Respawn(spawnspot[i]);
                   add(dividerLabel[i]);
               } catch (IOException ex) {
                   Logger.getLogger(StarBrosGame.class.getName())
                           .log(Level.SEVERE, null, ex);
               }
            }
            for (int i = totalplayers; i < totalbots + totalplayers; i++)
            {
                
               try {
                   bot[i] = new AI(player[i]);
               } catch (IOException ex) {
                   Logger.getLogger(StarBrosGame.class.getName())
                           .log(Level.SEVERE, null, ex);
               }
               if (map.equals("MANGROVES"))
                {
                    bot[i].setXRestrictions(150, 1124);
                }
            }
            characterselection = false;
      } 
      }
      ////////////////////////////////// 
    

      //Everything for while the game has started.
      ///////////////////////////////////////
       if (start)
       {
           //plays the game music on a loop.
           if (mmcnt == 1)
           {
            audio[2].close();
            audio[2].play("rebelsthemeremix.wav");
            mmcnt = 2;
           }
        
         g.drawImage(backgroundImg, 0, 0, null);  
      
         //the start of the player loop. (each loop represents the calculations
         //of that specific player.
     for (int x = 0; x < totalplayers + totalbots; x++)
     {
         idlecnt[x]++;
         //does calculations for the bots (i.e. the AI)
          if (x >= totalplayers)
          {
            for (int i = 0; i < totalplayers + totalbots; i++)
            {
              if (x != i && player[i].getHealth() > 0)
              {
                bot[x].Aggro(player[i]);
              }
            }
            for (int i = 0; i < 6; i++)
            {
                key[ikey[x][i]] = bot[x].isThisKeyEntered(i);
                keyreleased[ikey[x][i]] = bot[x].getKeyReleased(i);
            }
                bot[x].SimulatePlayerAI();
          }
          
          updateKeyInputs();//Anti ghosting makes this work a lot better.
          for (int i = 0; i < 2; i++)
          {
          if (pressedrecently[x][i] == true)
          {
            presscnt[x][i]++;
            pressedrecentlycnt[x][i]++;
            if (presscnt[x][i] == doubletappedinterval && 
                    pressedrecentlycnt[x][i] != doubletappedinterval)
            {
                player[x].Dash();
                presscnt[x][i] = 0;
                pressedrecently[x][i] = false;
                pressedrecentlycnt[x][i] = 0;
            }
            if (pressedrecentlycnt[x][i] == doubletappedinterval)
            {
                presscnt[x][i] = 0;
                pressedrecently[x][i] = false;
                pressedrecentlycnt[x][i] = 0;  
            }
          }
          }
          
          //the player dashes a specific direction only if 
          //they are instructed to dash.
           if (player[x].getDirectionFacing().equals("right"))
          {
          player[x].DashRight();
          }
          
          if (player[x].getDirectionFacing().equals("left"))
          {
          player[x].DashLeft();
          }
     
          boolean testing = false; //used in testing mode.
          //draws all the rectangles for purposes of testing the game and 
          //visually checking the rectangles for collisions.
          // For example to check if the characters feet are touching the ground
          //properly
          if (testing == true)
          {
                 for (int i = 0; i < numfloors; i++)
          {
          try {
          floor[i].draw(g);
          } catch (IOException ex) {
          Logger.getLogger(StarBrosGame.class.getName())
                  .log(Level.SEVERE, null, ex);
          }
          }
         try {
             player[x].drawTestingBoxes(g);
         } catch (IOException ex) {
             Logger.getLogger(StarBrosGame.class.getName())
                     .log(Level.SEVERE, null, ex);
         } 
          }
       
       //does calculations dealing with the floor boxes.
       // like landing on the ground, jumping, double jumping and falling.
       for (int i = 0; i < numfloors; i++)
       {
           if (floor[i].intersects(player[x].getFootBox()) 
                   || floor[i].contains(player[x].getFootBox()))
           {
             player[x].setY((int)(Math.min(floor[i].y + 1 -
                     player[x].getHeight() ,player[x].getY()))); 
             grounded[x] = true;
             djint[x] = 0;
             player[x].Land();
           }
           
           if (djint[x] == 1)
           {
               grounded[x] = true;
               djint[x] = 2;
           }
           
           if (floor[i].intersects(player[x].getFootBox()) && 
                   player[x].isAcceleratingVertically() == false)
           {
           stateOfVerticalMotion[x] = 1;
           }
 
            
            if (!floor[i].intersects(player[x].getFootBox()) 
                    && stateOfVerticalMotion[x] == 0)
           {
           player[x].setVerticalVelocity(0);
           stateOfVerticalMotion[x] = 2;
           } 
           if (stateOfVerticalMotion[x] == 1)
           {
           stateOfVerticalMotion[x] = 0;
           }
       }
       
       //stops the player from moving through walls
          if (map.equals("JUNGLE"))
          {
              if (player[x].getHbox().intersects(wall[0].rectangle))
           {
             player[x].setX((int)(Math.max(wall[0].x,player[x].getX())));  
           }
           
           if (player[x].getHbox().intersects(wall[2].rectangle))
           {
             player[x].setX((int)(Math.min(wall[2].x,player[x].getX())));  
           }
           
           if (player[x].getHbox().intersects(wall[1].rectangle))
           {
             player[x].setX((int)(Math.min(wall[1].x,player[x].getX())));  
           }
           
           if (player[x].getHbox().intersects(wall[3].rectangle))
           {
             player[x].setX((int)(Math.max(wall[3].x,player[x].getX())));  
           }
          }
       if (right[x])
       {
           player[x].FaceDirection("right");
           player[x].Run();
       }
       
       if (left[x])
       {
           player[x].FaceDirection("left");
           player[x].Run();
       }
       
      //Creates new bullets whenever a character fires their gun.
      if (player[x].getShooting() && player[x].getHealth() > 0)
      {
          //if the shoot counter is = to their fire rate, shoot a bullet.
          if (player[x].getShootCnt() >= player[x].getFireRate())
          {
      for (int j = 0; j < player[x].getBulletAmmount(); j++)
      {
            n[x]++; 
          for (int i = n[x]-1; i < n[x]; i++)
          {    
            bullet[x][i] = new Bullet
            (player[x].getGunX(), 
            player[x].getGunY() + (int)(Math.random()*
            (player[x].getBSpread()*2) - player[x].getBSpread())
            + j*player[x].getBulletDistInterval(), player[x].getBulletImage(), 
            player[x].getBSize(), player[x].getBRange(),  player[x].getBSpeed(),
            player[x].getBDamage(), player[x].getBulletType(),
            player[x].getDirectionFacing()); 
          }  
       }   
          }
      }
      
      for (int i = 0; i < n[x]; i ++)
          {
            try {
          bullet[x][i].draw(g);
          } catch (IOException ex) {
     Logger.getLogger(StarBrosGame.class.getName()).log(Level.SEVERE, null, ex);
          }
   
          }

      //reset the bullets if the maximum position in the array has been reached.
         if (n[x] >= 10000-1)
      {
          n[x] = 0;
      }
      
      if (map.equals("JUNGLE"))
      {
       if (player[x].getY() > 680)
       {
           player[x].setY(-40);
       }
       if (player[x].getX() > 900 && player[x].getX() < 1030)
       {
       if (player[x].getY() < -40)
       {
           player[x].setY(680);
       }
       }
      }
       
      //if your fall into the water, die. You will lose one point since
      //the last damage source was yourself.
      if (map.equals("MANGROVES"))
      {
       if (player[x].getY() > 680)
       {
           player[x].Damage(player[x].getHealth(),"pure", x);
       }
      }
       
        try {
            player[x].draw(g);
        } catch (IOException ex) {
            Logger.getLogger(StarBrosGame.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
       
       //If the character isnt doing anything, go into idle state.
       if (right[x] == false && left[x] == false && player[x].getHealth() > 0 
               && player[x].getMeleeCnt() == 0 && player[x].getMelee() == false 
               && player[x].getDash() == false && player[x].getShooting() == 
               false && player[x].getJumping() == false && player[x].getBlock()
               == false && idlecnt[x] == 50)
       {
           try {
               player[x].Idle();
           } catch (IOException ex) {
               Logger.getLogger(StarBrosGame.class.getName())
                       .log(Level.SEVERE, null, ex);
           }
       }
       
       //this happens so that the idle state isnt constantly called and
       //therefore prevents lag from occuring as a result.
       if(idlecnt[x] == 50)
       {
         idlecnt[x] = 0;
       }
       
       //make the player teleport to the other side of the screen.
       if (player[x].getX() < -30)
       {
           player[x].setX(1300);
       }
       if (player[x].getX() > 1300)
       {
           player[x].setX(-30);
           
       }
       
       //simulate gravity
       if (player[x].getHealth() > 0)
       {
       player[x].simulateGravity(gravityMultiplier);
       }
       player[x].ifDeadDie();
       player[x].maintainCharacterDimensions();
       player[x].manageStamina();
       player[x].maintainFireRate();
       
       
       //if a player melee's and hits another player,
       //deal damage to that player.
        for(int j = 0; j < totalplayers + totalbots; j++)
        {
           if (player[x].getMBox().intersects(player[j].getHbox()) && j != x)
           {
            player[j].Damage(player[x].getMDamage(),x);
           }   
        }
          
        //does calculations for the bullets.
          for (int i = 0; i < n[x]; i++)
          {
           for (int j = 0; j < totalplayers + totalbots; j++)
           {
            if (bullet[x][i].getBbox().intersects(player[j].getHbox()) 
                    && j != x)
            {
            player[j].Damage(bullet[x][i].getBDamage(), 
                    bullet[x][i].getType(),x);
            bullet[x][i] = new Bullet();
            }
            if (bullet[x][i].V().isWithinHRange(player[j].V(), 60)
                    && bullet[x][i].V().isWithinVRange(player[j].V(), 60)
                    && j != x && j >= totalplayers)
            {
            bot[j].sendBulletAlert();
            }
            if (bullet[x][i].getType().equals("seeking") && j != x)
            {
            
                bullet[x][i].updateTarget(player[j].getX(), player[j].getY()); 
            }
           }
           if (bullet[x][i].getType().equals("seeking"))
           {
           bullet[x][i].seekPlayer();
           }
           
           if (bullet[x][i].getType().equals("teleporting"))
           {
                 bullet[x][i].Teleport(1300, -100);
           }
           
           if (player[x].getName().equals("SniperTrooper"))
           {
            if (bullet[x][i].getBbox().intersects(player[x].getHbox())
                    && bullet[x][i].getType().equals("teleporting"))
            {
          player[x].Damage(bullet[x][i].getBDamage(), bullet[x][i].getType(),x);
             bullet[x][i] = new Bullet();
            }
           } 
          }
          
          //has the player died? then do this only once.
         if(player[x].getHealth() <= 0 && !out[x])
         {
             //if the player killed themself, minus a point.
         if (player[x].getLDS() == x)
         {
         playerscore[player[x].getLDS()]--; 
         }
         else //otherwise award a point to the player who dealt the last damage
             //source just before they died.
         {
         playerscore[player[x].getLDS()]++;
         if (player[player[x].getLDS()].getName().equals("ObiWanKenobi")
                 && player[x].getName().equals("Anakin"))
         {
         audio[1].playOnce("chosenone.wav");    
         }
         if (player[player[x].getLDS()].getName().equals("CountDooku")
                 && (player[x].getName().equals("Anakin") 
                 || player[x].getName().equals("ObiWanKenobi")))
         {
         audio[1].playOnce("YouFailedJedi.wav");    
         }
         if (player[player[x].getLDS()].getName().equals("Anakin")
                 && player[x].getName().equals("ObiWanKenobi"))
         {
         audio[1].playOnce("YUMP.wav");    
         }
         else if (player[player[x].getLDS()].getTotalTauntSounds() > 0)
         {
         audio[1].playOnce(player[player[x].getLDS()].getTauntSound(
        (int)(Math.random()*player[player[x].getLDS()].getTotalTauntSounds())));
         }
         
         }
         totaldead++;
         player[x].setY(-2000);
         out[x] = true;
         }  
   
         
         
           scoreLabel[x].setLocation(474 + x*100, -10);
           scoreLabel[x].setText(Integer.toString(playerscore[x]));
           stjedise = stjedise.deriveFont(48f);
           scoreLabel[x].setFont(stjedise);
           scoreLabel[x].setForeground(plc[x]);
         try {
             player[x].drawStaminaBar(g);
             player[x].drawHealthBar(g);
             player[x].drawNumberIndicator(g);
         } catch (IOException ex) {
     Logger.getLogger(StarBrosGame.class.getName()).log(Level.SEVERE, null, ex);
         }
               
     } 
     try {
     Thread.sleep(2);
     } catch (InterruptedException ex) {
     Logger.getLogger(StarBrosGame.class.getName()).log(Level.SEVERE, null, ex);
     }
     
     
     
     //end of player-loop
     //////////////////////////////////
     
     //if every player has died other you, then the round is over.  
     if (totaldead >= (totalplayers + totalbots - 1))
     {
         roundOver = true;
     }
     
     for (int i = 0; i < totalplayers +  totalbots - 1; i++)
     {
      dividerLabel[i].setLocation(536 + i*100, -12);
      dividerLabel[i].setFont(stjedise);
      dividerLabel[i].setForeground(Color.BLACK);  
     }
       
      //if the round is over and you have clicked enter, then reset stuff.
      if (roundOver && nextRound)
      {
        
            int c = 0;

            //awards 3 points to the winning player.
            while(player[c].getHealth() <= 0 && c 
                    != totalplayers + totalbots - 1)
            {
                c++;
            }
            playerscore[c] = playerscore[c] + 3;
            winm = "Player " + toWords(c+1).toLowerCase() +
                    " Wins round " + round;
            winc = plc[c];

        
        add(winnerLabel);
        nextRound = false;
      }
      
      stjedise = stjedise.deriveFont(64f);
      winnerLabel.setFont(stjedise);
      winnerLabel.setForeground(winc);
      winnerLabel.setText(winm);
      winnerLabel.setLocation(150, 200);
       
       //simulates the rain while raining.
       
       if (raining)
       {
        try {
               w.SimulateRain(g);
           } catch (IOException ex) {
               Logger.getLogger(StarBrosGame.class
                       .getName()).log(Level.SEVERE, null, ex);
           }
     
       }
           
           menubuttonbox[7] = new Rectangle2(0, 0, 50, 50);
           g.drawImage(exitbutton2, 0, 0, 50, 50, null);
           
         //Do you want to exit the round and go back to the main menu?  
         if (clickbox.intersects(menubuttonbox[7]))
         { 
             raining = false;
             audio[0].close();
             mmcnt = 0;
             pcnt = 0;
             round = 1;
             nextRound = true;
             totaldead = 0;
             roundOver = false;
             winm = "";
             start = false;
             mainmenu = true;
             map = "";
             remove(winnerLabel);
             for (int x = 0; x < totalplayers + totalbots; x++)
             {
                 remove(scoreLabel[x]);
                 remove(dividerLabel[x]);
                 out[x] = false;
               for (int i = 0; i < 6; i++)
               {
                key[ikey[x][i]] = false;
                keyreleased[ikey[x][i]] = false;
               } 
               selected[x] = false;
             }
             
             totalplayers = 0;
             totalbots = 0;
         } 
       }
         repaint();
    }
    
    //MOUSE AND KEYBOARD EVENTS USED BY THE KEY AND MOUSE LISTENER
    ///////////////////////////////////////////
    @Override
    public void mousePressed(MouseEvent e) 
    {
         requestFocusInWindow();
         clickcnt++;
         System.out.println("Press " + clickcnt + 
                 " is (" + e.getX() + ", " + e.getY() + ")");
         mousePressed = true;   
         pressbox = new Rectangle2(e.getX()- 1, e.getY() - 1, 2, 2);
    }
    
    @Override
    public void mouseReleased(MouseEvent e) 
    {
        mousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

   
    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    @Override
    public void keyReleased(KeyEvent e) { 
        keyreleased[e.getKeyCode()] = true;
        key[e.getKeyCode()] = false;
        releasedkey = e.getKeyCode();
        
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        clickbox = new Rectangle2(e.getX() - 2, e.getY() - 2, 4, 4);
    }
   

    @Override
    public void mouseDragged(MouseEvent e) {  
    }   

    @Override
    public void mouseMoved(MouseEvent e) {
    }


    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        key[e.getKeyCode()] = true; 
        keyreleased[e.getKeyCode()] = false;
        e.consume();

    }  
    ///////////////////////////////////////
    
    /**
     * Use in the paintComponent so that keys inputted by the players may
     * result in specific actions. (like shooting, blocking, running, etc.)
     */
    public void updateKeyInputs()
    {
          if ((key[KeyEvent.VK_ENTER]) && roundOver && !characterselection)
        {
            
             if ((int)(Math.random()*15) > 13)
            {
                audio[0].close();
                raining = true;
                audio[0].play("rain.wav");
            } 
            else
            {
                audio[0].close();
                raining = false;
            }
            remove(winnerLabel);
            round++;
            nextRound = true;
            totaldead = 0;
            roundOver = false;
            winm = "";
            try {
                for (int i = 0; i < totalplayers + totalbots; i++)
                {
                for (int x = 0; x < n[i]; x++)
                {
                    bullet[i][x] = new Bullet();
                }
                n[i] = 0;
                player[i] = new Character();
                out[i] = false;
                
                switch (playercharacterint[i])
                {
                  case 0: player[i] = new Droideka();
                  break;
                  case 1: player[i] = new FlameTrooper();
                  break;
                  case 2: player[i] = new HeavyTrooper();
                  break;
                  case 3: player[i] = new JumpTrooper();
                  break;
                  case 4: player[i] = new MeleeDroid();
                  break;
                  case 5: player[i] = new ShotgunTrooper();
                  break;
                  case 6: player[i] = new SniperTrooper();
                  break;
                  case 7: player[i] = new SpecialistTrooper();
                  break;
                  case 8: player[i] = new SuperBattleDroid();
                  break;  
                }
                
                if ((int)(Math.random()*100) < 15)
                {
                int b = (int)(Math.random()*(totalHeroes));
                
                switch (b)
                {
                    case 0: player[i] = new CountDooku();
                    break;
                    case 1: player[i] = new Anakin();
                    break;
                    case 2: player[i] = new ObiWanKenobi();
                    break;
                    case 3: player[i] = new GeneralGrievous();
                    break;
                    
                }
                }
                
                
                player[i].Respawn(spawnspot[i]);
                player[i].FaceDirection("right");
                player[i].Run();
                player[i].setNumber(i+1);
                }  
                
                for (int i = totalplayers; i < totalbots + totalplayers; i++)
            {
                
                bot[i] = new AI(player[i]);
                bot[i].Aggro(player[0]);
                if (map.equals("MANGROVES"))
                {
                    bot[i].setXRestrictions(150, 1124);
                }
            }
                
            } catch (IOException ex) {
                Logger.getLogger(StarBrosGame.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
          
          
       for (int x = 0; x < totalplayers + totalbots; x++)
       {
        if (keyreleased[ikey[x][LEFT]] && !player[x].getDash())
        {
        pressedrecently[x][LEFT] = true;
        pressedrecentlycnt[x][LEFT] = 0;
        left[x] = false;
        }
        if (keyreleased[ikey[x][RIGHT]] && !player[x].getDash())
        {
        pressedrecently[x][RIGHT] = true;
        pressedrecentlycnt[x][RIGHT] = 0;
        right[x] = false;
        }
        if (key[ikey[x][LEFT]] && !player[x].getDash())
        {   
          left[x] = true;
          right[x] = false;
        }
        if (key[ikey[x][RIGHT]] && !player[x].getDash())
        {
           right[x] = true;
           left[x] = false;
        }
        if ((key[ikey[x][JUMP]])&& grounded[x] == true)
        {
          player[x].Jump();
          grounded[x] = false;  
        }
        if ((keyreleased[ikey[x][JUMP]]))
        {
          djint[x]++; 
        }
        if (key[ikey[x][FIRE]])
        {
          if (player[x].getAttackType().equals("melee"))
          {
              player[x].MeleeAttack();
          }
          else if (player[x].getAttackType().equals("shoot"))
          {
              player[x].Shoot();
          }
        }
        if (keyreleased[ikey[x][SPECIAL]] && !player[x].getReloading())
        {
          player[x].ToggleSpecial();
        }
        if (keyreleased[ikey[x][SPECIAL]] && player[x].getHeroStatus())
        {
          player[x].Block();
        }
        if ((key[ikey[x][SECONDARY]]) && 
                (player[x].getAttackType2().equals("shoot")))
        {
              player[x].Shoot();
        }
        if ((key[ikey[x][SECONDARY]]) && 
                (player[x].getAttackType2().equals("melee")))
        {
              player[x].MeleeAttack();
        }
        else if (keyreleased[ikey[x][SECONDARY]] && 
                !(player[x].getAttackType2().equals("shoot") 
                || player[x].getAttackType2().equals("melee")))
        {
              player[x].ToggleSecondary(); 
        }
        if (keyreleased[ikey[x][SECONDARY]] &&
                player[x].getName().equals("GeneralGrievous"))
        {
            player[x].Dash();
        }
       }
        
       keyreleased[releasedkey] = false;
    }
    
    /**
     * 
     * @param n the player's number
     * @return the player's character
     */
    public Character getPlayer(int n)
    {
        return player[n];
    }
    
    /**
     * 
     * @return the total amount of players
     */
    public int getTotalPlayers()
    {
      return totalplayers;  
    }
        
    /**
     * Sets the private variables representing the characters stats 
     *  (i.e their health, damage, etc.) in this class to be equal 
     * to that of the database.
     * @param conn
     * @param table
     * @throws SQLException 
     */
    public void updateVariablesFromTable(Connection conn, String table) 
            throws SQLException 
    {
    Statement stmt = null;
    String query = "select * from " + table;
    int cnt = 0;
    try {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            characterID[cnt] = rs.getInt(1);
            characterName[cnt] = rs.getString(2);
            attackType1[cnt] = rs.getString(3);
            damageRating1[cnt] = rs.getInt(4);
            health[cnt] = rs.getInt(5);
            attackRange1[cnt] = rs.getInt(6);
            specialAbility[cnt] = rs.getString(7);
            secondaryAbility[cnt] = rs.getString(8);
            characterImageStr[cnt] = rs.getString(9);
            speed1[cnt] = rs.getInt(10);
            cnt++;
        }
    } catch (SQLException e ) {
    } finally {
        if (stmt != null) { stmt.close(); }
    }
}
    
    /**
     * A method used to position the volume sliders in the options menu in
     * their correct positions from the database.
     * @throws SQLException 
     */
    public void positionSlidersFromTable() throws SQLException 
    {
    Statement stmt = null;
    String query = "select * from SLIDERTABLE";
    int cnt = 0;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) 
        {
            slider[cnt].setInitialX(rs.getInt(2));
            cnt++;
        }
    } catch (SQLException e ) {
    } finally {
        if (stmt != null) { stmt.close(); }
    }
    }
    
    /**
     * A method used to update the position of the volume sliders.
     * @param conn the connection to database
     * @param table the table being updated
     * @param field1 the field being updated
     * @param value1 the value replacing the old value.
     * @param field2 the primary key
     * @param value2 the value of the primary key
     * @throws SQLException 
     */
    public void UpdateTable(Connection conn, String table, String field1,
            int value1, String field2, int value2) throws SQLException 
    {
    String query = "update " + table + " set " + field1 + " = " + value1 +
            " where " + field2 + " = " + value2;   
    PreparedStatement preparedStmt = conn.prepareStatement(query);
    preparedStmt.executeUpdate();
    }
}




