class DrumKit {
    //declare instance variables
    boolean topHat = true;
    boolean snare = true;
    //declare methods
    void playSnare() {
        System.out.println("bang bang ba-bang");
    }
    void playTopHat() {
        System.out.println("ding ding da-ding");
    }
}

class DrumKitTestDrive {
    public static void main(String [] args){
       //create DrumKit object
       DrumKit d = new DrumKit();
        d.playSnare();
       //assign d snare to false
        d.snare = false;
        //assigning playSnare on object 'd'
        d.playTopHat();

        //condition if d.snare is true, play playSnare
        if (d.snare) {
            d.playSnare();
        }
    }
}