import java.util.*;

public class ArrayListMagnet {
    //use static and int num will be used/belong to the class
     static int num;
     //letter is an instance variable because static is not there
     String letter;

     public void printLetter(){
         System.out.println(letter);
     }
     //static methods can only access static members
    public static void printAL(ArrayList<String> al) {
        for (String element : al) {
            System.out.print(element + " ");
        }
        System.out.println(" ");
//        System.out.println(letter);
    }
    public static void main (String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        a.add(0,"zero");
        a.add(1,"one");
        a.add(2,"two");
        a.add(3,"three");
        ArrayListMagnet.printAL(a);
        a.remove(2);
        if (a.contains("three")) {
            a.add("four");
        }
        printAL(a);
        if (a.indexOf("four") != 4) {
            a.add(4, "4.2");
        }
        printAL(a);
        if (a.contains("two")) {
            a.add("2.2");
        }
        printAL(a);
    }
}

class Example {
    public static void main (String[] args){
        ArrayListMagnet obj1 = new ArrayListMagnet();
        obj1.letter = "l";
        ArrayListMagnet obj2 = new ArrayListMagnet();
        obj2.letter = "j";
//        System.out.println(obj1.letter);
//        System.out.println(obj2.letter);
        obj1.printLetter();
        obj2.printLetter();

    }
}