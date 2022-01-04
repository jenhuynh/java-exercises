import javax.sound.midi.*;

public class MusicTest1 {
    public void play() {
        //Sequencer Object, main part of the MIDI device/instrument that sequences all the MIDI information into a 'spmg' and we ask the MidiSystem to give us one
        //try block: put the risky thing into it
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("We got a sequencer");
            //'catch' block does the exceptional situation happens -- in other words, a MidiUnavailableException is thrown by the call to getSequencer()
        } catch (MidiUnavailableException ex) {
            System.out.println("Bummer");
        }
    }
    // close play
    public static void main(String[] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    } // close main
} // close class