
package istower.defense;

import Controllers.MainController;
import javax.sound.midi.*;
import java.io.InputStream;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ISTowerDefense {

    static MainController mc;
    
    public static void main(String[] args) throws Exception{
        
        mc = new MainController();
        
        InputStream is;
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        is = new BufferedInputStream(new FileInputStream(new File("src/lady_gaga-bad_romance.mid")));
        sequencer.setSequence(is);
        sequencer.start();


    }
    
}
