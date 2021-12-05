 class Dog {
    // real class
    // instance variables
    int size;
    String breed;
    String name;

    // method
    void bark() {
        System.out.println("Woof! Woof!");
    }
}
// tester class
class DogTestDrive {
    public static void main(String[] args) {
        // make new Dog object
        Dog d = new Dog();
        // use dot operator to set the size of the dog
        d.name = "Clifford";
        d.size = 40;
        // call the bark method
        d.bark();
    }
}