package collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bext on 08/02/2017.
 */
public class Department {
    int IdDepartment;
    String NameDep;

    public Department(int idDepartment, String nameDep) {
        IdDepartment = idDepartment;
        NameDep = nameDep;
    }

    public int getIdDepartment() {
        return IdDepartment;
    }

    public String getNameDep() {
        return NameDep;
    }

    public String toString(){return getIdDepartment() + " " + NameDep;}

    public static List<Department> createDepartments() {
        List<Department> departments = new ArrayList<>();
        departments.add( new Department(1,"Recursos Humanos"));
        departments.add( new Department( 2, "Contabilidad"));
        departments.add( new Department( 3, "Ventas"));
        departments.add( new Department( 4, "Sistemas"));
        departments.add( new Department( 5, "Direccion"));
        return departments;
    }
}
