package collections;

import javax.print.attribute.standard.MediaSize;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bext on 03/02/2017.
 */
public class Person {
    int id;
    public enum Sex { MALE, FEMALE };
    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    String state;
    String city;

    public Person(int id, String name, LocalDate birthday, Sex gender, String emailAddress,String state, String city) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.state = state;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getAge() {
        return birthday.until(IsoChronology.INSTANCE.dateNow()).getYears();
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getState() { return state;  }

    public String getCity() {  return city;   }

    public void printPerson() {
        System.out.println(name + ", " + getAge());
    }

    public String toString() { return name + " " + getAge();}

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public static List<Person> createRoster() {
        List<Person> roster = new ArrayList<>();
        roster.add( new Person( 1,"Fred",
                IsoChronology.INSTANCE.date(1980,6,20),
                Person.Sex.MALE,
                "fred@example.com", "Texas", "Houston"));
        roster.add( new Person( 2,"Jane",
                IsoChronology.INSTANCE.date(1990, 7, 15),
                Person.Sex.FEMALE,
                "jane@example.com", "California", "San Francisco"));
        roster.add( new Person( 3,"George",
                IsoChronology.INSTANCE.date(1991,8,13),
                Sex.MALE,
                "george@example.com", "Texas" ,"Houston"));
        roster.add( new Person( 4,"Bob",
                IsoChronology.INSTANCE.date(2000,9,12),
                Sex.MALE,
                "bob@example.com","California","Los Angeles"));
        roster.add( new Person( 5,"Pepe",
                IsoChronology.INSTANCE.date(1970,12,2),
                Sex.MALE,
                "pepe@example.com","California","San Francisco"));
        roster.add( new Person( 6,"Gila",
                IsoChronology.INSTANCE.date(1970,5,23),
                Sex.FEMALE,
                "gila@example.com", "Texas", "Brownsville"));
        return roster;
    }
}
