
package starbrosgame;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JApplet;


public class AApplet extends JApplet {

    
    @Override
    public void init() {
      
        StarBrosGame panel;
        System.out.println(1);
        try {
            panel = new StarBrosGame();
            add(panel);
        } catch (IOException | SQLException | LineUnavailableException ex) {
            Logger.getLogger(AApplet.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
       
    }


}
