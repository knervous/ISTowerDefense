
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package istower.defense.v1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

/**
 *
 * @author Paul
 */
public class ISTowerDefenseV1 {

    /**
     * @param args the command line arguments
     */
    
    public static Sequencer sequence; 
    
    public static void main(String[] args) throws Exception{
        
        GameController gameController = new GameController();
        
        
//        PlayGame playGame = new PlayGame();
//        playGame.getLevel().setPlayGame(playGame);
//        playGame.getOptionsPanel().setPlayGame(playGame);
        // Is there a way to restructure this without a class instance taking a parameter of itself?
        // This might go some distance toward future readability.
        
        InputStream is;
        sequence = MidiSystem.getSequencer();
        sequence.open();
        is = new BufferedInputStream(new FileInputStream(new File("src/GwenStefani_Hollaback-girl.mid")));
        sequence.setSequence(is);
        sequence.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        sequence.start();
        is.close();
      
        
        
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
