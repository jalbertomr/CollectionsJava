package collections;

import java.time.temporal.ChronoUnit;
import java.util.*;

import static collections.MapDemo.loadEmployees;

/**
 * Created by Bext on 10/02/2017.
 */
public class EmpSort {

    static final Comparator<Employee> SENIORITY_ORDER =
            new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return o1.getHireDate().compareTo(o2.getHireDate());
                    //return (int) ChronoUnit.DAYS.between(o2.hireDate, o1.hireDate);
                }
            };

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(loadEmployees());

        System.out.println(employees);
        Collections.sort(employees, SENIORITY_ORDER);
        System.out.println(employees);
    }
}
