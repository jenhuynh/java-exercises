public class TapeDeck {
    //instance variable
    boolean canRecord = false;

    //methods
    void playTape() {
        System.out.println("tape playing");
    }
    void recordTape(){
        System.out.println("tape recording");
    }
}

class TapeDeckTestDrive {
    public static void main(String [] args){
        //make a TapeDeck object
        TapeDeck t = new TapeDeck();
        //using dot operator to set canRecord to be true
        t.canRecord = true;

        //condition checks if record is true. If it is, call recordTape method
        if (t.canRecord == true) {
            t.playTape();
            t.recordTape();
        }
    }
}
