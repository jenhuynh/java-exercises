public class DogBark {
    //instance variable name
    String name;
    public static void main (String[] args){
        //make a Dog object and access it
        DogBark dog1 = new DogBark();
        dog1.bark();
        dog1.name = "Bart";

        //now make a Dog array
        DogBark[] myDogs = new DogBark[3];
        //and put some dogs in it
        myDogs[0] = new DogBark();
        myDogs[1] = new DogBark();
        myDogs[2] = dog1;

        //now access the Dogs using the array references
        myDogs[0].name = "Fred";
        myDogs[1].name = "Marge";
        myDogs[2].name = "Sally";

        //Hmm...what is myDogs[2] name?
        System.out.println(myDogs.length);
        System.out.print("last dog's name is ");
        System.out.println(myDogs[2].name);

        //now loop through the array
        //and tell all dogs to bark
        int x = 0;
        while(x < myDogs.length){
            myDogs[x].bark();
            x = x + 1;
        }
    }
    public void bark() {
        System.out.println(name + " says Ruff!");
    }
    public void eat() { }
    public void chaseCat() { }
}
