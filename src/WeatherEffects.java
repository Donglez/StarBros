package starbrosgame;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class WeatherEffects 
{
    private int z = 0;
    private int zz = 0;
    private BufferedImage rain1;
    private BufferedImage rain2;
    private BufferedImage rain3;
    private BufferedImage rain4;
    private BufferedImage rain5;
    private BufferedImage rain6;
    private BufferedImage rain7;
    private BufferedImage rain8;
    
    /**
     * Blank Constructor, initializes the raining images.
     * @throws IOException 
     */
    public WeatherEffects() throws IOException
    {
         rain1 = (ImageIO.read(new File("rain1.png")));
         rain2 = (ImageIO.read(new File("rain2.png")));
         rain3 = (ImageIO.read(new File("rain3.png")));
         rain4 = (ImageIO.read(new File("rain4.png")));
         rain5 = (ImageIO.read(new File("rain5.png")));
         rain6 = (ImageIO.read(new File("rain6.png")));
         rain7 = (ImageIO.read(new File("rain7.png")));
         rain8 = (ImageIO.read(new File("rain8.png")));
    }
  
    /**
     * Simulates a raining animation on the screen.
     * <p>
     * Use in the paintComponent.
     * @param g graphics in the paintComponent.
     * @throws IOException 
     */
    public void SimulateRain(Graphics g) throws IOException
    {
        zz++;
        if (zz > 8)
        {
            z++;
            zz = 0;
        }
      switch (z) 
        {
            case 0: g.drawImage(rain1,0,0,null);
                break;
            case 1: g.drawImage(rain2,0,0,null);
                break;
            case 2: g.drawImage(rain3,0,0,null);
                break;
            case 3: g.drawImage(rain4,0,0,null);
                break;
            case 4: g.drawImage(rain5,0,0,null);
                break;
            case 5: g.drawImage(rain6,0,0,null);
                break;
            case 6: g.drawImage(rain7,0,0,null);
                break;
            case 7: g.drawImage(rain8,0,0,null);       
                break;
            case 8: z = 0;      
                break;
                
        } 
    }
        
    }
    
    
    

    

