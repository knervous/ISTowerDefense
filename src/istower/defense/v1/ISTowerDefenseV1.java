
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
    public static void main(String[] args) throws Exception{
        PlayGame playGame = new PlayGame();
        playGame.getLevel().setPlayGame(playGame);
        
        InputStream is;
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        is = new BufferedInputStream(new FileInputStream(new File("src/GwenStefani_Hollaback-girl.mid")));
        sequencer.setSequence(is);
        sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        sequencer.start();
      
        
        
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
