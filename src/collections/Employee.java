package collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bext on 05/02/2017.
 */
public class Employee implements Comparable<Employee> {
    int id;
    Person person;
    Department department;
    LocalDate hireDate;
    double salary;

    public Employee(int id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setPerson(Person person) { this.person = person; }

    public Person getPerson() { return person;}

    public Department getDepartment() { return department; }

    public void setDepartment( Department dep) { department = dep;}

    public LocalDate getHireDate() { return hireDate; }

    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    public void setSalary(double salary) { this.salary = salary; }

    public double getSalary() {
        return salary;
    }

    public String toString() { return id + " " + getPerson().toString() + " " + getSalary();}

    @Override
    public int compareTo(Employee o) {
        return (int) o.getHireDate().toEpochDay();
    }

    public static List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add( new Employee(1,  1000.43));
        employees.add( new Employee( 2, 12322.73));
        employees.add( new Employee( 3,200322.43));
        employees.add( new Employee( 4,503030.23));
        employees.add( new Employee( 5,700342.23));
        employees.add( new Employee( 6,300342.23));
        return employees;
    }
}
