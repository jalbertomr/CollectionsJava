package collections;

import java.util.List;

import static collections.Person.Sex.FEMALE;
import static collections.Person.Sex.MALE;

/**
 * Created by Bext on 11/02/2017.
 */
public class AgregateOperations {

    static public void main(String[] args) {

        List<Person> persons = Person.createRoster();

        System.out.println("for( Person p : persons) {\n" +
                "            System.out.println(p.getName() + \" \");");
        for( Person p : persons) {
            System.out.print(p.getName() + " ");
        }

        System.out.println();
        System.out.println("persons.stream().forEach(e -> System.out.println(e.getName()));");
        persons.stream().forEach(e -> System.out.print(e.getName() + " "));

        System.out.println();
        System.out.println("persons.stream()\n" +
                "                .filter(e -> e.getGender() == Person.Sex.MALE)\n" +
                "                .forEach(e -> System.out.print(e.getName() + \" \"));");
        persons.stream()
                .filter(e -> e.getGender() == MALE)
                .forEach(e -> System.out.print(e.getName() + " "));

        System.out.println();
        System.out.println("persons.stream()\n" +
                "                .filter(e -> e.getGender() == Person.Sex.FEMALE)\n" +
                "                .forEach(e -> System.out.print(e.getName() + \" \"));");
        persons.stream()
                .filter(e -> e.getGender() == FEMALE)
                .forEach(e -> System.out.print(e.getName() + " "));

        System.out.println();
        persons.stream()
                .filter( e -> e.getGender() == MALE)
                .forEach(e -> System.out.print( e.getName() + " " + e.getAge() + " "));
        System.out.println();
        persons.stream()
                .filter( e-> e.getGender() == FEMALE)
                .forEach(e -> System.out.print( e.getName() + " " + e.getAge() + " "));
        System.out.println();

        double average = persons.stream()
                .filter(e -> e.getGender() == MALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println("average of age of MALES : " + average);

        average = persons.stream()
                .filter( e -> e.getGender() == FEMALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println("average of age of FEMALE : " + average);

    }
}
