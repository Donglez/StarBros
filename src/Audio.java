package starbrosgame;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

/**
 * An audio player. Plays sounds and has its own volume and loop specifications.
 * @author dean
 */
public class Audio
{
    private Clip clip;
    private FloatControl gainControl;
    private String fn;
    private float volume;
    private int loop;
    
    /**
     * Blank constructor for an audio player (has a default clip and filename).
     */
    Audio()
    {
        try { 
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
        fn = "RevanTheme.wav";
    }

 /**
  * Plays a sound, looping forever.
  * @param filename the filename of the sound.
  */
 public void play(String filename)
 {
    fn = filename;
    try
    {
        loop = -1;
        clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File(fn)));
        gainControl = (FloatControl) 
                clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(volume);
        clip.loop(loop);
        clip.start();
    }
    catch (Exception exc)
    {
        exc.printStackTrace(System.out);
    }
 }

 /**
  * Closes the clip.
  */
 public void close()
 {
  clip.close();
 }

 /**
  * Stops the clip
  */
 public void stop()
 {
  clip.stop();
 }

 /**
  * starts the clip.
  */
 public void start()
 { 
  clip.loop(loop);
  clip.start();
 }
    
 /**
  * Plays a sound once.
  * @param filename the file name of the sound.
  */
 public void playOnce(String filename)
 {
    fn = filename;
    try
    {
        loop = 0;
        clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File(fn)));
        gainControl = (FloatControl) 
                clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(volume);
        clip.loop(loop);
        clip.start();
    }
    catch (Exception exc)
    {
        exc.printStackTrace(System.out);
    }
 }
 /**
  * 
  * @param vol the float value of the volume (0f = mute, 1f = max volume)
  */
 public void setVolume(float vol)
 {
        try {
        clip.close();
        clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File(fn)));
        gainControl = (FloatControl) 
                clip.getControl(FloatControl.Type.MASTER_GAIN);
        float range = gainControl.getMaximum() - gainControl.getMinimum();
        float gain = (range * vol) + gainControl.getMinimum();
        volume = gain;
        gainControl.setValue(volume);
        }
         catch (Exception exc)
        {
        exc.printStackTrace(System.out);
        }
        
 }
 
 /**
  * 
  * @return the value of the volume of the Audio player.
  * <p>
  * (0f = mute, 1f = max volume)
  */
 public float getVolume()
 {
     return volume;
 }
 
}