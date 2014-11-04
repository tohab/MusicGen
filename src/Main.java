import javax.sound.midi.*;
import javax.swing.Timer;


public class Main {
	static MidiChannel[] mc = null;
	
	public static void main(String[] args) throws InterruptedException, MidiUnavailableException {
		setup();
		play(60,500);
		/*for (int i = 0; i < 25; i++) {
			int ran = (int)(Math.random() * 24) + 48;
			int ran2 = (int)(Math.random() * 10) + 1;
			mc[5].noteOn(ran,60*ran2);
			new Thread().sleep(100*ran2);
		}
		int[] major = {0,2,4,5,7,9,11,12};
		int[] minor = {0,2,3,5,7,8,11,12};
		for (int i = 0; i < 150; i++) {
			mc[5].noteOn(48 + (int)(Math.random()*3)*12 + minor[(int)(Math.random()*8)],100);
			new Thread().sleep(200);
		}
		mc[5].noteOff(0);*/
		
	}
	public static void setup() throws MidiUnavailableException {
		Synthesizer syn = MidiSystem.getSynthesizer();
		syn.open();   
		mc = syn.getChannels();
		Instrument[] instr = syn.getDefaultSoundbank().getInstruments();
		syn.loadInstrument(instr[91]);
	}
	public static void play(int note, int velocity) {
		mc[5].noteOn(note,velocity);
	}
	public static void major(int key,int rep) throws InterruptedException, MidiUnavailableException{
		 for (int i=0; i<rep; i++){   
			mc[5].noteOn(60+key,100);
			new Thread().sleep(200);
			mc[5].noteOff(60+key,0);
      			mc[5].noteOn(67+key,100);
      			new Thread().sleep(200);
      			mc[5].noteOff(67+key,0);
			mc[5].noteOn(64+key,100);
      			new Thread().sleep(200);
      			mc[5].noteOff(64+key,0);
      			mc[5].noteOn(67+key,100);
      			new Thread().sleep(200);
			mc[5].noteOff(67+key,0);
    			}
	 }
	public static void minor(int key) throws InterruptedException, MidiUnavailableException{
		 for (int i=0; i<4; i++){   
			mc[5].noteOn(60+key,100);
      			new Thread().sleep(200);
      			mc[5].noteOff(60+key,0);
      			mc[5].noteOn(67+key,100);
      			new Thread().sleep(200);
      			mc[5].noteOff(67+key,0);
      			mc[5].noteOn(63+key,100);
			new Thread().sleep(200);
      			mc[5].noteOff(63+key,0);
      			mc[5].noteOn(67+key,100);
      			new Thread().sleep(200);
      			mc[5].noteOff(67+key,0);
    			}
  	}
	public static void firstinversionmaj(int key,int rep) throws InterruptedException, MidiUnavailableException{
    			for (int i=0; i<rep; i++){   
      			mc[5].noteOn(64+key,100);
      			new Thread().sleep(200);
      			mc[5].noteOff(64+key,0);
      			mc[5].noteOn(72+key,100);
      			new Thread().sleep(200);
      			mc[5].noteOff(72+key,0);
			mc[5].noteOn(67+key,100);
      			new Thread().sleep(200);
      			mc[5].noteOff(67+key,0);
      			mc[5].noteOn(72+key,100);
      			new Thread().sleep(200);
      			mc[5].noteOff(72+key,0);
			 }
	}
}
