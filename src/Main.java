import javax.sound.midi.*;
import javax.swing.Timer;


public class Main {
	public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
		Synthesizer syn = MidiSystem.getSynthesizer();
		syn.open();   
		final MidiChannel[] mc = syn.getChannels();
		Instrument[] instr = syn.getDefaultSoundbank().getInstruments();
		syn.loadInstrument(instr[91]);
		/*for (int i = 0; i < 100; i++) {
			int ran = (int)(Math.random() * 24) + 48;
			int ran2 = (int)(Math.random() * 10) + 1;
			mc[5].noteOn(ran,60*ran2);
			new Thread().sleep(100*ran2);
		}*/
		int[] major = {0,2,4,5,7,9,11,12};
		for (int i = 0; i < 100; i++) {
			mc[5].noteOn(48 + (int)(Math.random()*3)*12 + major[(int)(Math.random()*8)],100);
			new Thread().sleep(200);
		}
	}
}
