import java.util.*;
import java.util.stream.Collectors;

public class People {

    public static void main(String[] args) {

        //create list that takes in type person and add 4 people to list
        List<Person> people = new ArrayList<>();

        people.add(new Person("Warren Buffett", 120));
        people.add(new Person("Jeff Bezos", 150));
        people.add(new Person("Bill Gates", 100));
        people.add(new Person("Mark Zuckerberg", 50));

        //filtering out everyone that has a hundred or more billions of dollars
//        List<Person> hundredClub = new ArrayList<>();

        //Stream version with filter, people is the list we want to filter by looping through each person and filter on person who
        // is greater than or equal to 100 bil
//        List<Person> hundredClub = people.stream()
//                .filter(person -> person.billions >= 100)
//                //return a new list
//                .collect(Collectors.toList());

        //Stream with Sort all the names alphabetically
            List<Person> sortedList = people.stream()
                    //use Comparator when sorting on an object
                    .sorted(Comparator.comparing(person -> person.name))
                            .collect(Collectors.toList());
            //print everything in the sorted list
            sortedList.forEach(person -> System.out.println(person.name));

        //Manual way: loop through eat person in that list
//        for(Person p : people){
//            if(p.billions >= 100){
//                hundredClub.add(p);
//            }
//        }


        //print out people in the hundredClub list
//        hundredClub.forEach(person -> System.out.println(person.name));
    }
}

class Person {
    String name;
    int billions;

    //Person constructor so we can easily create objects
    public Person (String name, int billions) {
        this.name = name;
        this.billions = billions;
    }
}
