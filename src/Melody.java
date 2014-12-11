import javax.sound.midi.*;
import javax.swing.Timer;

public class Melody {
	// construct a melody based on chords
	// major = 1 minor = 0
	public void melody(int key, int tempo, int[] notesInChord)
			throws InterruptedException, MidiUnavailableException {

		int barlength = tempo * 4;
		int root = notesInChord[0];

		Synthesizer syn = MidiSystem.getSynthesizer();
		syn.open();
		final MidiChannel[] mc = syn.getChannels();
		Instrument[] instr = syn.getDefaultSoundbank().getInstruments();
		syn.loadInstrument(instr[109]);

		mc[5].noteOn(root, 100);
		new Thread().sleep(barlength);
		mc[5].noteOff(root, 100);

	}
}
