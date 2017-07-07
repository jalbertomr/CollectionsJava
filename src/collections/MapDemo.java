package collections;

import java.time.chrono.IsoChronology;
import java.time.temporal.ChronoUnit;
import java.util.*;

import java.util.stream.Collectors;
import java.time.LocalDate;

import static collections.DemoUtils.showln;

/**
 * Created by Bext on 08/02/2017.
 */
public class MapDemo {

    public static List<Employee> loadEmployees() {
        LocalDate dateCompanyBirthday = IsoChronology.INSTANCE.date(2004, 6,14);
        LocalDate dateToday = IsoChronology.INSTANCE.dateNow();
        List<Person> persons = Person.createRoster();
        List<Employee> employees = Employee.createEmployees();
        List<Department> departments = Department.createDepartments();

        ListIterator empIter = employees.listIterator();
        System.out.println("========= Fill Employees ============");
        for (ListIterator personIter = persons.listIterator(); personIter.hasNext();){
            Employee emp = (Employee)empIter.next();
            emp.setPerson( (Person)personIter.next());
            emp.setDepartment( departments.get( new Random().nextInt(5)) );
            emp.setHireDate( dateCompanyBirthday.plusDays(
                    new Random().nextInt(((int) ChronoUnit.DAYS.between(dateCompanyBirthday,dateToday) + 1 )
                    )));
            System.out.format("%3d %,10.2f %18s %tY-%tb-%td ",emp.getId(),emp.getSalary(),emp.getDepartment().getNameDep(),emp.getHireDate(),emp.getHireDate(),emp.getHireDate());
            System.out.printf("%1$10s %2$tY-%2$tb-%2$td",emp.getPerson(),emp.getPerson().getBirthday());
            showln();
        }
        return employees;
    }

    public static void main(String[] args){
        List<Employee> employees = loadEmployees();
        List<Person> persons = Person.createRoster();
        List<Department> departments = Department.createDepartments();

        System.out.println("Persons: " + persons.toString());
        System.out.println("Employees: " + employees.toString());
        System.out.println("Departments: " + departments.toString());

        System.out.println("===== Group employees by department =====");
        Map<Department, List<Employee>> byDep = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(byDep);

        System.out.println("===== Compute sum of salaryes by departemnt =====");
        Map<Department, Double> totalByDep = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                                               Collectors.summingDouble(Employee::getSalary)));
        System.out.println(totalByDep);

        System.out.println("===== Classify Person Object by city =====");
        Map<String, List<Person>> peopleByCity = persons.stream()
                .collect(Collectors.groupingBy(Person::getCity));
        System.out.println(peopleByCity);

        System.out.println("===== Classify Person Object by State =====");
        Map<String, List<Person>> peopleByState = persons.stream()
                .collect(Collectors.groupingBy(Person::getState));
        System.out.println(peopleByState);

        System.out.println("===== Cascade Collectors Classify Person Object by State , city =====");
        Map<String, Map<String, List<Person>>> peopleByStateAndCity = persons.stream()
                .collect(Collectors.groupingBy(Person::getState,
                         Collectors.groupingBy(Person::getCity)));
        System.out.println(peopleByStateAndCity);
         //non-static method cannot be referenced from a static context when is bad redacted

        System.out.println("===== Classify Person Object by Name, Age =====");
        Map<String, Map<Integer, List<Person>>> personByNameAndAge = persons.stream()
                .collect(Collectors.groupingBy(Person::getName,
                        Collectors.groupingBy(Person::getAge)));
        System.out.println(personByNameAndAge);


        showln("======== Bulk Data Operations =========");
        persons.stream()
                .filter(e -> e.getGender() == Person.Sex.MALE)
                .forEach(e -> System.out.print(e.getName() + " "));
        showln();

        persons.stream()
                .filter(e -> e.getGender() == Person.Sex.FEMALE)
                .forEach(e -> System.out.print(e.getName() + " "));
        showln();

        System.out.println(
        persons.stream()
                .filter(e -> e.getGender() == Person.Sex.MALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble()
        );
        showln();

        System.out.println(
                persons.stream()
                        .filter(e -> e.getGender() == Person.Sex.FEMALE)
                        .mapToInt(Person::getAge)
                        .average()
                        .getAsDouble()
        );
        showln();

    }
}
