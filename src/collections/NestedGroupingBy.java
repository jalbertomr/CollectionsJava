package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Bext on 15/02/2017.
 */
public class NestedGroupingBy {
    static class Person {

        private String name;
        private int age;
        private long salary;
        private String state;
        private String city;

        public Person(String name, int age, long salary, String state, String city) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.state = state;
            this.city = city;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public String getState() {
            return state;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    ", state='" + state + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Stream<Person> people = Stream.of(
                new Person("Paul", 24, 20000,"Texas","Houston"),
                new Person("Mark", 30, 30000,"Texas","Brownsville"),
                new Person("Will", 28, 28000,"California","L.A."),
                new Person("William", 28, 28000,"California","San Fco."),
                new Person("Will", 12, 15000,"California","L.A."),
                new Person("Beto", 46, 300000,"New York","Manhattan"),
                new Person("Will", 12, 28000,"Florida","Miami"),
                new Person("Beto", 28, 28000,"Missouri","San Luis")
        );
        List<Person> personas = new ArrayList<>();
        personas = people.collect(Collectors.toList());
        people = personas.stream();

        Map<Integer, List<Person>> peopleByAge;
        peopleByAge = people
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println(peopleByAge);
        /*
        {24=[Person{name='Paul', age=24, salary=20000}],
        12=[Person{name='Will', age=12, salary=15000}, Person{name='Will', age=12, salary=28000}],
        28=[Person{name='Will', age=28, salary=28000}, Person{name='William', age=28, salary=28000}, Person{name='Beto', age=28, salary=28000}],
        46=[Person{name='Beto', age=46, salary=300000}], 30=[Person{name='Mark', age=30, salary=30000}]}
        */
        people = personas.stream();
        Map<String, Map<Integer, List<Person>>> mapNameAge = people
                .collect(Collectors.groupingBy(Person::getName,     //Si esta mal asignado el Type donde se depositara
                        Collectors.groupingBy(Person::getAge)));    // el groupingBy(algo::algo
        System.out.println(mapNameAge);                             // marca non-static method cannod be referenced ...
/*
        {Beto={28=[Person{name='Beto', age=28, salary=28000}],
               46=[Person{name='Beto', age=46, salary=300000}]},
         Mark={30=[Person{name='Mark', age=30, salary=30000}]},
         Will={12=[Person{name='Will', age=12, salary=15000}, Person{name='Will', age=12, salary=28000}],
               28=[Person{name='Will', age=28, salary=28000}]},
          William={28=[Person{name='William', age=28, salary=28000}]},
             Paul={24=[Person{name='Paul', age=24, salary=20000}]}}
     */
        people = personas.stream();
        Map<Integer, Map<String, List<Person>>> mapAgeName = people
                .collect(Collectors.groupingBy(Person::getAge,
                        Collectors.groupingBy(Person::getName)));
        System.out.println(mapAgeName);
        /*
        {24={Paul=[Person{name='Paul', age=24, salary=20000}]},
         12={Will=[Person{name='Will', age=12, salary=15000}, Person{name='Will', age=12, salary=28000}]},
         28={Beto=[Person{name='Beto', age=28, salary=28000}],
             Will=[Person{name='Will', age=28, salary=28000}],
             William=[Person{name='William', age=28, salary=28000}]},
         46={Beto=[Person{name='Beto', age=46, salary=300000}]},
         30={Mark=[Person{name='Mark', age=30, salary=30000}]}}

         */

        people = personas.stream();
        Map<String, Map<String, List<Person>>> mapStateCity = people
                .collect(Collectors.groupingBy(Person::getState,
                        Collectors.groupingBy(Person::getCity)));
        System.out.println(mapStateCity);

    }
}

