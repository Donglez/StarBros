package starbrosgame;

import java.io.IOException;
import static starbrosgame.StarBrosGame.*;

/**
*Artificial intelligence to control a character.
     */
public class AI 
{
    private Character ai = new Character(); //the character being controlled 
    private Character target = new Character();//the character being targeted 
    private boolean key[] = new boolean[6]; // the key that the ai is pressing
    private boolean rkey[] = new boolean[6];// the key that the ai is releasing
    private boolean ba = false; // a boolean representing a bullet alert
    private boolean retreating = false; // whether or not the ai is retreating
    private boolean meleeing = false; // whether or not the ai is meleeing
    private boolean hero = false; // whether or not the ai is a hero
    private int xMin = - 10000; 
    private int xMax = 200000; 
    
    
    /**
     * Blank constructor for an Artificial intelligence
     */
    AI()
    {
    }
    
    /**
     * Blank constructor for an Artificial intelligence
     */
    AI(Character c) throws IOException 
    {
      ai = c; 
      hero = ai.getHeroStatus();
    }
    
    /**
     * Attempts to select a new target for the ai.
     * <p>
     * If the character 
     * that is being
     * inputted is closer to the ai than the 
     * original target, 
     * the new target will become the inputted target
     * @param nc a character that could possibly become the new 
     * target for the ai.
     */
    public void Aggro(Character nc)
    {
          if (Math.hypot(Math.abs(ai.getX() - nc.getX()),Math.abs(ai.getY() 
              - nc.getY())) < Math.hypot(Math.abs(ai.getX() - 
              target.getX()),Math.abs(ai.getY() - target.getY())))
          {
            target = nc; 
          }
    }
    
    /**
     * Sends an alert to the ai that a bullet is coming their way by 
     * setting the
     * bullet alert boolean to be true.
     */
    public void sendBulletAlert()
    {
      ba = true;
    }
    
    /**
     *Simulates the brain of the ai.
     * <p>
     * Use in game loop.
     */
    public void SimulatePlayerAI()
    {   
      for (int i = 0; i < 6; i++)
      {
          key[i] = false;
          rkey[i] = false;
      }
      //if the character is reloading it should run away (with exception 
      //to characters like the shotgun trooper).
      if (ai.getReloading() && !hero && !(ai.getName().equals("Droideka") 
              || ai.getName().equals("ShotgunTrooper") 
              || ai.getName().equals("SniperTrooper")))
      {
          retreating = true;
      }
      //otherwise it should not retreat
      else
      {
          retreating = false;
      }
      
      ////Special cases depending on what type of character the ai is using.///
      /////////////////////////////////////////////////////////////////////////
      if (ai.getName().equals("Anakin"))
      {
         if (ai.getGunVector().isWithinVRange(target.V(), 30) && 
                 !ai.V().isWithinHRange(target.V(), 400) )
         {
            key[SECONDARY] = true;
            
            rkey[RIGHT] = true;
            rkey[LEFT] = true;
            key[LEFT] = false;
            key[RIGHT] = false;
         }
         if (!ai.getGunVector().isWithinVRange(target.V(), 30) 
                 || ai.V().isWithinHRange(target.V(), 400) && 
                 !ai.V().isWithinHRange(target.V(), 20))
         {
         if (target.getX() <= ai.getX())
         {
          ai.FaceDirection("left");
         }
         else
         {
          ai.FaceDirection("right");
         } 
      
         if (target.getX() < ai.getX())
         {
          key[LEFT] = true;
         }
         if (target.getX() > ai.getX())
         {
          key[RIGHT] = true;
         }
         } else
          {
            key[RIGHT] = false;
            key[LEFT] = false;
            rkey[RIGHT] = true;
            rkey[LEFT] = true;
          }
          if (ai.V().isWithinHRange(target.V(), 90))
         {
             key[FIRE] = true;
         }
          if (ba)
         {
             ai.Block();
         }
      }
      
      if (ai.getName().equals("CountDooku"))
      {
         if (ai.getGunVector().isWithinVRange(target.V(), 30) 
                 && !ai.V().isWithinHRange(target.V(), 400) )
         {
            key[SECONDARY] = true;
            
            rkey[RIGHT] = true;
            rkey[LEFT] = true;
            key[LEFT] = false;
            key[RIGHT] = false;
         }
         if (!ai.getGunVector().isWithinVRange(target.V(), 30) || 
                 ai.V().isWithinHRange(target.V(), 400) && 
                 !ai.V().isWithinHRange(target.V(), 20))
         {
         if (target.getX() <= ai.getX() - 20)
         {
          ai.FaceDirection("left");
         }
         else if (target.getX() >= ai.getX() + 20)
         {
          ai.FaceDirection("right");
         } 
      
         if (target.getX() < ai.getX())
         {
          key[LEFT] = true;
         }
         if (target.getX() > ai.getX())
         {
          key[RIGHT] = true;
         }
         } else
          {
            key[RIGHT] = false;
            key[LEFT] = false;
            rkey[RIGHT] = true;
            rkey[LEFT] = true;
          }
          if (ai.V().isWithinHRange(target.V(), 90))
         {
             key[FIRE] = true;
         }
          if (ba)
         {
             ai.Block();
         }
      }
      
      if (ai.getName().equals("Droideka"))
      {
          if (ai.V().isWithinHRange(target.V(), ai.getBRange()) || ba)
          {
              ai.ToggleSpecial("ON");
          }
          else if(!ai.V().isWithinHRange(target.V(), ai.getBRange()))
          {
              ai.ToggleSpecial("OFF"); 
          }
          
          if (!ai.V().isWithinHRange(target.V(), 500))
          {
              ai.ToggleSecondary("ON");
          }
          else
          {
              ai.ToggleSecondary("OFF");
          }
      }
      
      if (ai.getName().equals("FlameTrooper"))
      {
         if (ai.getHealth() > 75)
         {
            ai.ToggleSpecial("ON"); 
         }
         else
         {
             ai.ToggleSpecial("OFF");
         }
      }
      
      if (ai.getName().equals("GeneralGrievous"))
      {
         
         if (!ai.V().isWithinHRange(target.V(), 20))
         {
         if (target.getX() <= ai.getX())
         {
          ai.FaceDirection("left");
         }
         else
         {
          ai.FaceDirection("right");
         } 
      
         if (target.getX() < ai.getX())
         {
          key[LEFT] = true;
         }
         if (target.getX() > ai.getX())
         {
          key[RIGHT] = true;
         }
         } else
          {
            key[RIGHT] = false;
            key[LEFT] = false;
            rkey[RIGHT] = true;
            rkey[LEFT] = true;
          }
          if (ai.V().isWithinHRange(target.V(), 90))
         {
             key[FIRE] = true;
         }
          if (ba)
         {
             ai.Block();
         }
      }
      
      if (ai.getName().equals("HeavyTrooper"))
      {
        if (ai.getHealth() < ai.getMaxHealth())
        {
            ai.ToggleSpecial("ON"); 
        }
        else
        {
            ai.ToggleSpecial("OFF"); 
        }
      }
      
      if (ai.getName().equals("JumpTrooper"))
      {
          if (ai.V().isWithinHRange(target.V(), 150))
          {
              ai.ToggleSpecial("ON"); 
          }
          else
          {
              ai.ToggleSpecial("OFF");
          }
      }
      
      if (ai.getName().equals("MeleeDroid"))
      {
         if (ai.V().isWithinHRange(target.V(), 80))
         {
             ai.ToggleSpecial("OFF");
         }
         else
         {
             ai.ToggleSpecial("ON");
         }
      }
      
      if (ai.getName().equals("ObiWanKenobi"))
      {
         if (!ai.V().isWithinHRange(target.V(), 20))
         {
         if (target.getX() <= ai.getX())
         {
          ai.FaceDirection("left");
         }
         else
         {
          ai.FaceDirection("right");
         } 
      
         if (target.getX() < ai.getX())
         {
          key[LEFT] = true;
         }
         if (target.getX() > ai.getX())
         {
          key[RIGHT] = true;
         }
         } else
          {
            key[RIGHT] = false;
            key[LEFT] = false;
            rkey[RIGHT] = true;
            rkey[LEFT] = true;
          }
          if (ai.V().isWithinHRange(target.V(), 50))
         {
             key[FIRE] = true;
         }
          if (ba)
         {
             ai.Block();
         }
      }
      
      if (ai.getName().equals("ShotgunTrooper"))
      {
          if (ai.V().isWithinHRange(target.V(), 280))
          {
              ai.ToggleSpecial("ON");
          }
          else
          {
              ai.ToggleSpecial("OFF");
          }
      }
      
      if (ai.getName().equals("SniperTrooper"))
      {
          ai.ToggleSpecial("ON");
          if (ba)
          {
              retreating = true;
          }
      }
      
      if (ai.getName().equals("SpecialistTrooper"))
      {
          if (target.getHealth() < 70 && !target.getName().equals("Droideka") 
                  && ai.getHealth() > ai.getMaxHealth()/2)
          {
              ai.ToggleSpecial("OFF");
              retreating = false;
          }
          else
          {
              ai.ToggleSpecial("ON");
          }
          
          if (target.V().isWithinHRange(ai.V(), 250))
          {
              retreating = true;
              ai.ToggleSpecial("ON");
          }
      }
      
      if (ai.getName().equals("SuperBattleDroid"))
      {
          if (ai.V().isWithinHRange(target.V(), ai.getBRange() + 50) && 
                  ai.V().isWithinVRange(target.V(), 40))
          {
              ai.ToggleSpecial("ON");
          }
          else
          {
              ai.ToggleSpecial("OFF"); 
          }
          if (ai.V().isWithinHRange(target.V(), 40) &&
                  ai.V().isWithinVRange(target.V(), 40))
          {
              meleeing = true;
              key[SECONDARY] = true;
          }
          else
          {
              meleeing = false;
          }
      }
      //END OF SPECIAL CASES
      /////////////////////////////////////////////////////
      
      //if the target is higher up than the ai, the ai should 
      //jump to reach the target.
      if (target.getFootBox().y < ai.getGunY() && !hero)
      {
          key[JUMP] = true;
          rkey[JUMP] = true;
      }
      
   //if the target is a melee character, the ai should run away from the target
      //if they get too close.
      if(target.V().isWithinHRange(ai.V(), 100) && !hero && 
              !ai.getAttackType().equals("melee") && 
              !ai.getName().equals("JumpTrooper") && 
              target.getAttackType().equals("melee"))
      {
          retreating = true;
      }
      
      //if the target is higher up than the ai, the ai should 
      //jump to reach the target.
      if (target.getFootBox().y < ai.getFootBox().y - 20 && hero)
      {
          key[JUMP] = true;
          rkey[JUMP] = true;
      }
      
      //Calculations done in the brain of the ai if the ai is not retreating.
      //////////////////////////
      if (!retreating && !hero)
      {
      if (target.getX() <= ai.getX())
      {
          ai.FaceDirection("left");
      }
      else
      {
          ai.FaceDirection("right");
      } 
      if (ai.getX() > xMin && ai.getX() < xMax)
      {
      if (target.getX() < ai.getX() - ai.getBRange())
      {
          key[LEFT] = true;
      }
      if (target.getX() > ai.getX() + ai.getBRange())
      {
          key[RIGHT] = true;
      }
      }
      }
      //////////////////////////
      
      //A droideka should only retreat if its shield is down.
      if (ai.getName().equals("Droideka"))
      {
          retreating = false;
      }
      
      //A droideka should only retreat if its shield is down.
      if (ai.getName().equals("Droideka") && ai.getShield() < 700 && 
              ai.getShield() > 50 && !ai.getSpecialActivated())
      {
          retreating = true;
          ai.ToggleSecondary("ON");
      }
      
      //Calculations done in the brain of the ai if the ai is retreating.
      //(the ai can't retreat past certain points on the map)
      //////////////////////////
      if (retreating && ai.getX() > 20 && 
          ai.getX() > xMin && ai.getX() < xMax)
      {
      if (target.getX() <= ai.getX())
      {
          ai.FaceDirection("right");
          key[RIGHT] = true;
      }
      else
      {
          key[LEFT] = true;
          ai.FaceDirection("left");
      } 
      }
      ///////////////////////////
      
      //More calculations done in the brain of the ai if the ai is retreating.
      //However, this ensures that the character does not jump off the edges 
      //of the map.
      ////////////////////
      if (retreating && ai.getX() > xMin && ai.getX() < xMax)
      {
      if (ai.getX() <= 20 && target.V().isWithinHRange(ai.V(), 20))
      {
          key[RIGHT] = true;
      }
      
      if (ai.getX() >= 1270 && target.V().isWithinHRange(ai.V(), 20))
      {
          key[LEFT] = true;
      }
      }
      ///////////////////
      
      //If the target is almost or completely within range of the 
      //ai's projectiles
      // the ai should fire at the target.
      if (target.getX() >= ai.getX() - ai.getBRange() - 80 && target.getX()
              <= ai.getX() + ai.getBRange() + 80 && !meleeing && !hero)
      {
         key[FIRE] = true; 
      }
      
      //if the target is within range of the ai, the ai 
      //should have no reason to carry on running
      if (!(target.getX() < ai.getX() - ai.getBRange() || target.getX() 
              > ai.getX() + ai.getBRange()) && !hero && !retreating)
      {
          rkey[RIGHT] = true;
          rkey[LEFT] = true;
          key[LEFT] = false;
          key[RIGHT] = false;
      }
      
      //if the ai somehow ends up beyond the boundaries set for it, it should 
      //return back to avoid falling off the edges of the map
      //////////
      if (ai.getX() <= xMin)
      {
          key[RIGHT] = true;
          key[LEFT] = false;
      }
      
      if (ai.getX() >= xMax)
      {
          key[RIGHT] = false;
          key[LEFT] = true;
      }
      ///////////
        target = new Character(); //reseting the target 
        ba = false; //reseting the bullet alert
    }
    
    /**
     * 
     * @param i the specific key (from 1 to 6).
     * @return true if that specific key is being pressed, else false.
     */
    public boolean isThisKeyEntered(int i)
    {
     return key[i];
    }
    
    /**
     * 
     * @param i the specific key (from 1 to 6)
     * @return true if that specific key is released, else false.
     */
    public boolean getKeyReleased(int i)
    {
     return rkey[i];
    }
    
    /**
     * Sets the boundaries for the ai based on the map.
     * <p>
     * The ai will avoid moving beyond these boundaries.
     * <p>
     * @param min the minimum x boundary.
     * @param max the maximum x boundary.
     */
    public void setXRestrictions(int min, int max)
    {
        xMin = min;
        xMax = max;
    }

}
