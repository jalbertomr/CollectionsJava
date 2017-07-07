package collections;

import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

import static collections.Person.Sex.MALE;

/**
 * Created by Bext on 11/02/2017.
 */
class Averager implements IntConsumer{
    int total = 0;
    int count = 0;

    public double average() {
        return count > 0 ? ((double) total)/count : 0;
    }

    public void accept(int value) {
        total += value; count++;
    }
    public void combine(Averager other){
        total += other.total;
        count += other.count;
    }

    public int finisher() {
        return (total / count);
    }
}

public class ReductionExamples {
    static public void main(String[] args) {
        List<Person> persons = Person.createRoster();

        System.out.println("Persons: ");
        persons.stream()
                .forEach(e -> e.printPerson());

        //Average age of Male members, average operation
        double average = persons.stream()
                .filter(e -> e.getGender() == MALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println("Average: age (Bulk Data Operations): " + average);

        //Sum age with sum operation
        Integer totalAge = persons.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println("Sum of ages (sum operation): " + totalAge);

        //Sum ages with reduce(identity, accumulator
        Integer totalAgeReduce = persons.stream()
                .mapToInt(Person::getAge)
                .reduce(0,
                        (a, b) -> a + b
                );
        System.out.println("Sum of ages with reduce (identity, accumulator): " + totalAgeReduce);

        //Average of age members with collect operation
        Averager averageCollect = persons.stream()
                .filter(e -> e.getGender() == MALE)
                .map(Person::getAge)
                .collect(Averager::new, Averager::accept, Averager::combine);
        //                     Supplier Accumulator            Combiner
        System.out.println("Average age of Males with collect :" + averageCollect.average());

        //Names of male members with collect operation
        List<String> namesMalePersonsCollect = persons.stream()
                .filter(e -> e.getGender() == MALE)
                .map(Person::getName)
                .collect(Collectors.toList());

        namesMalePersonsCollect.stream()
                .forEach(p -> System.out.print(p + " "));

        System.out.println(".stream().collect(Collectors.groupingBy(Person::getGender));");
        Map<Person.Sex, List<Person>> byGender = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        System.out.println(byGender);

        System.out.println("stream().collect(Collectors.groupingBy(Person::getState))");
        Map<String, List<Person>> byState = persons.stream()
                .collect(Collectors.groupingBy(Person::getState));

        System.out.println(byState);

        System.out.println("stream().collect(Collectors.groupingBy(Person::getCity))");
        Map<String, List<Person>> byCity = persons.stream()
                .collect(Collectors.groupingBy(Person::getCity));
        System.out.println(byCity);

        System.out.println("name by gender: Map<Person.Sex,List<String>> nameByGender = persons.stream()\n" +
                "                .collect(Collectors.groupingBy(Person::getGender,\n" +
                "                                                Collectors.mapping(Person::getName,Collectors.toList())));");
        Map<Person.Sex, List<String>> nameByGender = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender,
                        Collectors.mapping(Person::getName, Collectors.toList())));
        //.groupingBy( clasification function, Instance of Collector-downstream collector)
        //two downstram collector is called multilevel reduction
        System.out.println(nameByGender);

        //total age of member of each gender
        System.out.println("Map<Person.Sex,Integer> totalAgeByGender = persons.stream()\n" +
                "                .collect(Collectors.groupingBy(Person::getGender, /*(function classifier, Collector downstream)*/\n" +
                "                        Collectors.summingInt(Person::getAge)));");
        Map<Person.Sex, Integer> totalAgeByGender = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender, /*(function classifier, Collector downstream)*/
                        Collectors.summingInt(Person::getAge)));
        System.out.println("totalAgeByGender: " + totalAgeByGender);

        System.out.println("Map<Person.Sex,Integer> totalAgeByGender2 = persons.stream().\n" +
                "                collect(Collectors.groupingBy(Person::getGender,\n" +
                "                        Collectors.reducing(\n" +
                "                                0,\n" +
                "                                Person::getAge,\n" +
                "                                (a,b) -> a + b\n" +
                "                        )));");
        Map<Person.Sex, Integer> totalAgeByGender2 = persons.stream().
                collect(Collectors.groupingBy(Person::getGender,
                        Collectors.reducing(
                                0,
                                Person::getAge,
                                (a, b) -> a + b
                        )));
        System.out.println("totalAgeByGender: " + totalAgeByGender2);

        System.out.println("        Map<Person.Sex,Integer> totalAgeByGender3 = persons.stream()\n" +
                "                .collect(Collectors.groupingBy(Person::getGender,\n" +
                "                        Collectors.reducing(\n" +
                "                                0,       /*identity*/\n" +
                "                                Person::getAge,  /*mapper*/\n" +
                "                                Integer::sum     /*operation*/\n" +
                "                        )));\n");
        Map<Person.Sex, Integer> totalAgeByGender3 = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender,
                        Collectors.reducing(
                                0,       /*identity*/
                                Person::getAge,  /*mapper*/
                                Integer::sum     /*operation*/
                        )));
        System.out.println("totalAgeByGender3: " + totalAgeByGender3);

        //Average age by Gender
        //No le gusta, asi esta en el tutorial de java8
        // Person::getGender y Person::getAge dice Non-static method cannot be referenced form a static context
        //Map<Person.Sex,Integer> averageAgeByGender = persons.stream()
        //        .collect(Collectors.groupingBy(Person::getGender,
        //                Collectors.averagingInt(Person::getAge)));

        Map<Person.Sex, Double> averageAgeByGender = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender,
                        Collectors.averagingInt(Person::getAge)));
        System.out.println("AvertageAgeByGender: " + averageAgeByGender);

        Map<String, Double> averageAgeByState = persons.stream()
                .collect(Collectors.groupingBy(Person::getState,
                        Collectors.averagingInt(Person::getAge)));
        for(Map.Entry<String, Double> aver : averageAgeByState.entrySet()){
            System.out.println("state: " + aver.getKey() + "average Age:" + aver.getValue());
        }

/*
        Map<Person.Sex,Integer> avereageAgeByGender2 = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender,
                        Collectors.reducing(Averager::new, Averager::accept, Averager::combine)));
*/

        Map<Person.Sex, List<Integer>> agesByGender = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender,
                        Collectors.mapping(Person::getAge, Collectors.toList())));
        System.out.println("ages by Gender: " + agesByGender);
    }
}
