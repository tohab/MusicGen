import javax.sound.midi.*;
import javax.swing.Timer;


public class Main {
   static MidiChannel[] mc = null;
 public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
  setup();
  start(4,1,200);
 }
public static void setup() throws MidiUnavailableException {
  Synthesizer syn = MidiSystem.getSynthesizer();
  syn.open();   
  mc = syn.getChannels();
  Instrument[] instr = syn.getDefaultSoundbank().getInstruments();
  syn.loadInstrument(instr[91]);
 }
public static void major(int key,int rep, int tempo) throws InterruptedException, MidiUnavailableException{
    for (int i=0; i<rep; i++){   
      mc[5].noteOn(60+key,100);
      new Thread().sleep(tempo);
      mc[5].noteOff(60+key,0);
      mc[5].noteOn(67+key,100);
      new Thread().sleep(tempo);
      mc[5].noteOff(67+key,0);
      mc[5].noteOn(64+key,100);
      new Thread().sleep(tempo);
      mc[5].noteOff(64+key,0);
      mc[5].noteOn(67+key,100);
      new Thread().sleep(tempo);
      mc[5].noteOff(67+key,0);
    }
  }
public static void minor(int key,int rep, int tempo) throws InterruptedException, MidiUnavailableException{
    for (int i=0; i<rep; i++){   
      mc[5].noteOn(60+key,100);
      new Thread().sleep(tempo);
      mc[5].noteOff(60+key,0);
      mc[5].noteOn(67+key,100);
      new Thread().sleep(tempo);
      mc[5].noteOff(67+key,0);
      mc[5].noteOn(63+key,100);
      new Thread().sleep(tempo);
      mc[5].noteOff(63+key,0);
      mc[5].noteOn(67+key,100);
      new Thread().sleep(tempo);
      mc[5].noteOff(67+key,0);
    }
  }
public static void firstinversionmaj(int key,int rep, int tempo) throws InterruptedException, MidiUnavailableException{
    for (int i=0; i<rep; i++){   
      mc[5].noteOn(64+key,100);
      new Thread().sleep(tempo);
      mc[5].noteOff(64+key,0);
      mc[5].noteOn(72+key,100);
      new Thread().sleep(tempo);
      mc[5].noteOff(72+key,0);
      mc[5].noteOn(67+key,100);
      new Thread().sleep(tempo);
      mc[5].noteOff(67+key,0);
      mc[5].noteOn(72+key,100);
      new Thread().sleep(tempo);
      mc[5].noteOff(72+key,0);
    }
  }
public static void start(int key, int tone, int tempo) throws InterruptedException, MidiUnavailableException{
    if (tone == 1){
        while(true){
            major(key,2,tempo);
            if (Math.random()<0.5){
                if (Math.random()<0.4){
                firstinversionmaj(key-5,2,tempo);
                }else{
                major(key+7,2,tempo);
                if (Math.random()<0.45){
                    minor(key+9,2,tempo);
                    minor(key+2,1,tempo);
                    major(key+7,1,tempo);
                }
                }
            }else{
               if (Math.random()<0.4){
                    secondinversionmaj(key-7,2,tempo);
                    if (Math.random()<0.5)
                    firstinversionmaj(key-5,2,tempo);
                   } else{
                  major(key+5,2,tempo);
                   if (Math.random()>0.5)
                     major(key+7,2,tempo);
                   }
           }
        }    
      }else{
         while(true){
            minor(key,2,tempo);
            if (Math.random()<0.5){
                if (Math.random()<0.4){
                firstinversionmaj(key-5,2,tempo);
                }else{
                major(key+7,2,tempo);
                if (Math.random()<0.3){
                    major(key+9,2,tempo);
                    major(key+2,1,tempo);
                    major(key+7,1,tempo);
                }
                }
            }else{
                minor(key+5,2,tempo);
                if (Math.random()>0.5)
                    major(key+7,2,tempo);
                }
        }      
    }
}
}
