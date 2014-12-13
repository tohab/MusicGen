import javax.sound.midi.*;
import javax.swing.Timer;

public class Chords extends Thread {
	static MidiChannel[] mc = null;
	int key = 0;
	int tone = 0;
	int tempo = 0;
	int volume = 0;
	static boolean playing = true;
	static int currentnote = 0;

	private Thread t;

	public Chords(int key1, int tone1, int tempo1, int volume1) {

		try {
			key = key1;
			tone = tone1;
			tempo = tempo1;
			volume = volume1;
			
			setup();

		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void start() {
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}

	public void run() {
		try {
			start(key, tone, tempo, volume);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setup() throws MidiUnavailableException {
		Synthesizer syn = MidiSystem.getSynthesizer();
		syn.open();
		mc = syn.getChannels();
		Instrument[] instr = syn.getDefaultSoundbank().getInstruments();
		syn.loadInstrument(instr[91]);
	}

	public static void major(int key, int rep, int tempo, int volume)
			throws InterruptedException, MidiUnavailableException {
		for (int i = 0; i < rep; i++) {
			mc[5].noteOn(60 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(60 + key, 0);
			mc[5].noteOn(67 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(67 + key, 0);
			mc[5].noteOn(64 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(64 + key, 0);
			mc[5].noteOn(67 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(67 + key, 0);
		}
	}

	public static void minor(int key, int rep, int tempo, int volume)
			throws InterruptedException, MidiUnavailableException {
		for (int i = 0; i < rep; i++) {
			mc[5].noteOn(60 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(60 + key, 0);
			mc[5].noteOn(67 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(67 + key, 0);
			mc[5].noteOn(63 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(63 + key, 0);
			mc[5].noteOn(67 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(67 + key, 0);
		}
	}

	public static void firstinversionmaj(int key, int rep, int tempo, int volume)
			throws InterruptedException, MidiUnavailableException {
		for (int i = 0; i < rep; i++) {
			mc[5].noteOn(64 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(64 + key, 0);
			mc[5].noteOn(72 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(72 + key, 0);
			mc[5].noteOn(67 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(67 + key, 0);
			mc[5].noteOn(72 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(72 + key, 0);
		}
	}

	public static void secondinversionmaj(int key, int rep, int tempo, int volume)
			throws InterruptedException, MidiUnavailableException {
		for (int i = 0; i < rep; i++) {
			mc[5].noteOn(67 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(67 + key, 0);
			mc[5].noteOn(76 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(76 + key, 0);
			mc[5].noteOn(72 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(72 + key, 0);
			mc[5].noteOn(76 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(76 + key, 0);
		}
	}

	public static void secondinversionmin(int key, int rep, int tempo, int volume)
			throws InterruptedException, MidiUnavailableException {
		for (int i = 0; i < rep; i++) {
			mc[5].noteOn(67 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(67 + key, 0);
			mc[5].noteOn(75 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(75 + key, 0);
			mc[5].noteOn(72 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(72 + key, 0);
			mc[5].noteOn(75 + key, volume);
			new Thread().sleep(tempo);
			mc[5].noteOff(75 + key, 0);
		}
	}

	public static void start(int key, int tone, int tempo, int volume)
			throws InterruptedException, MidiUnavailableException {
		if (tone == 1) {
			while (playing) {
				if (Math.random() < .9 && playing == true) {
					major(key, 2, tempo, volume);
					currentnote = key;
				} else {
					firstinversionmaj(key - 5, 2, tempo, volume);
					currentnote = key - 5;
				}
				if (Math.random() < 0.25 && playing == true) {
					major(key + 4, 2, tempo, volume);
					currentnote = key + 4;
					secondinversionmin(key - 3, 2, tempo, volume);
					currentnote = key -3;
					major(key + 2, 2, tempo, volume);
					currentnote = key + 2;
					secondinversionmaj(key - 5, 2, tempo, volume);
					currentnote = key - 5;
					firstinversionmaj(key - 5, 2, tempo, volume);
					currentnote = key - 5;
				}
				if (Math.random() < 0.5 && playing == true) {
					if (Math.random() < 0.4 && playing == true) {
						if (Math.random() < 0.55 && playing == true) {
							firstinversionmaj(key - 5, 2, tempo, volume);
							currentnote = key - 5;
						} else {
							major(key + 2, 2, tempo, volume);
							currentnote = key +2;
							secondinversionmaj(key - 5, 2, tempo, volume);
							currentnote = key - 5;
							firstinversionmaj(key - 5, 2, tempo, volume);
							currentnote = key - 5;
						}
					} else {
						major(key + 7, 2, tempo, volume);
						currentnote = key + 7;
						if (Math.random() < 0.4) {
							minor(key + 9, 2, tempo, volume);
							currentnote = key + 9;
							minor(key + 2, 1, tempo, volume);
							currentnote = key + 2;
							major(key + 7, 1, tempo, volume);
							currentnote = key + 7;
						}
					}
				} else {
					if (Math.random() < 0.4 && playing == true) {
						secondinversionmaj(key - 7, 2, tempo, volume);
						currentnote = key - 7;
						if (Math.random() < 0.5 && playing == true)
							firstinversionmaj(key - 5, 2, tempo, volume);
							currentnote = key - 5;
					} else {
						major(key + 5, 2, tempo, volume);
						currentnote = key + 5;
						if (Math.random() < 0.5)
							major(key + 7, 2, tempo, volume);
						 currentnote = key + 7;
					}
				}
			}
		} else {
			while (playing) {
				if (Math.random() < .9 && playing == true) {
					minor(key, 2, tempo, volume);
					currentnote = key;
				} else {
					firstinversionmaj(key - 5, 2, tempo, volume);
					currentnote = key - 5;
				}
				if (Math.random() < 0.25 && playing == true) {
					minor(key + 4, 2, tempo,volume);
					currentnote = key +4;
					secondinversionmaj(key - 3, 2, tempo, volume);
					currentnote = key -3;
					minor(key + 2, 2, tempo, volume);
					currentnote = key +2;
					secondinversionmaj(key - 5, 2, tempo, volume);
					currentnote = key - 5;
					firstinversionmaj(key - 5, 2, tempo, volume);
					currentnote = key - 5;
				}
				if (Math.random() < 0.5 && playing == true) {
					if (Math.random() < 0.4) {
						if (Math.random() < 0.55) {
							firstinversionmaj(key - 5, 2, tempo, volume);
							currentnote = key - 5;
						} else {
							minor(key + 2, 2, tempo, volume);
							currentnote = key +2;
							secondinversionmaj(key - 5, 2, tempo, volume);
							currentnote = key -5;
							firstinversionmaj(key - 5, 2, tempo, volume);
							currentnote = key - 5;
						}
					} else {
						minor(key + 7, 2, tempo, volume);
						currentnote = key + 7;
						if (Math.random() < 0.4 && playing == true) {
							major(key + 9, 2, tempo, volume);
							currentnote = key + 9;
							major(key + 2, 1, tempo, volume);
							currentnote = key + 2;
							major(key + 7, 1, tempo, volume);
							currentnote = key + 7;
						}
					}
				} else {
					if (Math.random() < 0.4 && playing == true) {
						secondinversionmaj(key - 7, 2, tempo, volume);
						currentnote = key - 7;
						if (Math.random() < 0.5 && playing == true)
							firstinversionmaj(key - 5, 2, tempo, volume);
						     currentnote = key - 5;
					} else {
						minor(key + 5, 2, tempo, volume);
						currentnote = key +5;
						if (Math.random() < 0.5 && playing == true)
							major(key + 7, 2, tempo, volume);
							currentnote = key + 7;
					}
				}
			}
		}

	}
	public static void stopMusic(){
		playing = false;
	}
	public static void startMusic(){
		playing = true;
	}

}
