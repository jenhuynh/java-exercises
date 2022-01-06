import java.util.*;

public class TestGenerics1 {
    public static void main (String[] args) {
        new TestGenerics1().go();
    }

//    public void go() {
//        //declare and create an Animal array, that holds both dogs and cats
//        Animal[] animals = {new Dog(), new Cat(), new Dog()};
//        //declare and create a Dog array, that holds only Dogs (the compiler won't let you put a Cat in)
//        Dog[] dogs = {new Dog(), new Dog(), new Dog()};
//        //call takeAnimals() using both array types as arguments
//        takeAnimals(animals);
//        takeAnimals(dogs);
//    }
//
//    //the takeAnimals() method can take an Animal[] or a Dog[], since Dog IS-A Animal. Polymorphism in action
//    public void takeAnimals(Animal[] animals) {
//        for(Animal a: animals) {
//            //we can call ONLY the methods declared in type animal, since the animals parameter is of type Animal array and we didn't do any casting
//                //if we were to cast it to, the array might hold both Dogs and Cats
//            a.eat();
//        }
//    }


//Same solution instead with ArrayList<Animal>
    public void go() {
        //change from Animal[] to ArrayList<Animal>
        ArrayList<Animal> animals = new ArrayList<Animal>();
        //use add method one at a time since there's no shortcut syntax like there is for array creation
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());
        //same code except now the "animals" variable refers to an ArrayList instead of array
        takeAnimals(animals);
    }

    //method now takes an ArrayList instead of an array but everything else is the same. The for loop syntax works for both arrays and collections
    public void takeAnimals(ArrayList<Animal> animals) {
        for (Animal a : animals) {
            a.eat();
        }
    }
}


//simplified Animal class hierarchy
abstract class Animal {
    void eat() {
        System.out.println("animal eating");
    }
}
class Dog extends Animal {
    void bark() { }
}
class Cat extends Animal {
    void meow() { }
}

