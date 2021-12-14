public class Animal {
    private String name;
    //constructor needs to be exactly the same as the name of the class, does not need a return type
    public Animal(String name){
        //name on this.name is the variable defined in line 2
        //name on the right side is the parameter passed in the animal constructor in line 3
        this.name = name;
    }
    //sayName method
    public void sayName(){
        System.out.println(name);
    }

}
//create subclass of class Animal, subclass any instance of the subclass is an instance of the superclass
class Doggie extends Animal{
    //when a Dog gets created by passing it a name, just do the exact same thing when we created an animal
    public Doggie(String name) {
        //super stands for superclass
        super(name);
    }
    public void bark(){
        System.out.println("Woof");
    }
}

//create subclass of class Animal, subclass any instance of the subclass is an instance of the superclass
class Cat extends Animal{
    //when a Dog gets created by passing it a name, just do the exact same thing when we created an animal
    public Cat(String name) {
        //super stands for superclass
        super(name);
    }
    public void meow(){
        System.out.println("Meow");
    }
}

class AnimalTestDrive {
    public static void main(String[] args){
        Doggie firstDog = new Doggie("Clifford");
        firstDog.bark();
        Cat secondCat = new Cat("Boots");
        secondCat.meow();
        Animal[] zoo = new Animal[2];
        zoo[0] = firstDog;
        zoo[1] = secondCat;
        for(int i=0; i < zoo.length; i++){
            zoo[i].sayName();
        }
        //Animal is like int i and pet can be any variable name, zoo the array we loop through
        for (Animal pet : zoo
             ) {
            pet.sayName();
        }
    }
}
