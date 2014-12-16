

import javax.sound.midi.*;
import javax.swing.Timer;
//60 = middle c
//have a method to return the note

public class Melody {
  // construct a melody based on chords
  // major = 1 minor = 0
	private int barlength;
	private int root;
	private MidiChannel mc;
	private int thirdMaj;
	private int thirdMin;
  public Melody(int key, int tempo, int quality) throws InterruptedException, MidiUnavailableException {
  
       barlength = tempo*4; 
       root = 72 + key;
      thirdMaj = 76 + key; 
      thirdMin = 75 + key;
       
       Synthesizer syn = MidiSystem.getSynthesizer();
       syn.open();
       mc = syn.getChannels()[5];
       Instrument[] instr = syn.getDefaultSoundbank().getInstruments();
       syn.loadInstrument(instr[109]);
  }
  
  public void playRoot () {
      mc.noteOn(root, 100);
      Main.updateCanvas(root);
   
  
  }
  
  public void stopRoot() {
	  mc.noteOff(root, 100);
  }
  
  public void playThirdMaj () {
      mc.noteOn(thirdMaj, 100);
   
  
  }
  
  public void stopThirdMaj() {
	  mc.noteOff(thirdMaj, 100);
  }
  public void playThirdMin () {
	  mc.noteOn(thirdMin, 100);
  }
  
  public void stopThirdMin() {
	  mc.noteOff(thirdMin, 100);
  }
  
}
