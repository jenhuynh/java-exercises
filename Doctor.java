//inheritance example
public class Doctor {
   //declare instance variables
    boolean worksAtHospital;
    //declare method
    void treatPatient() {
        //perform a checkup
        System.out.println("Perform Checkup");
    }
}

//subclass FamilyDoctor inherits Doctor superclass
class FamilyDoctor extends Doctor {
    boolean makeHouseCalls;
    void giveAdvice() {
        //give homespun advice
        System.out.println("Give advice!");
    }
}

//subclass Surgeon inherits Doctor superclass
class Surgeon extends Doctor {
    void treatPatient() {
        //perform surgery
        System.out.println("Perform Surgery!");
    }
    void makeIncision() {
        //make incision (yikes)
        System.out.println("Make incision!");
    }
}
class DoctorTestDrive {
    public static void main(String[] args){
        FamilyDoctor Bob = new FamilyDoctor();
        Bob.giveAdvice();
        Surgeon Sally = new Surgeon();
        Sally.makeIncision();
        Doctor[] office = new Doctor[2];
        office[0] = Bob;
        office[1] = Sally;
        for(int i=0; i < office.length; i++){
            office[i].treatPatient();
        }
        //Animal is like int i and pet can be any variable name, zoo the array we loop through
        for (Doctor doc : office
        ) {
            doc.treatPatient();
        }
    }
}