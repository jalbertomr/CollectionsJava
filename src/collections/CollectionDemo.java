package collections;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static collections.DemoUtils.show;
import static collections.DemoUtils.showln;

/**
 * Created by Bext on 02/02/2017.
 */
public class CollectionDemo {

    public static <T> boolean cond(T t) {
        String o = (String)t;
        return (o.length() > 6);
    }

    public static void filter(Collection<?> c ) {
        for (Iterator<?> iter =  c.iterator(); iter.hasNext();) {
            if (!cond(iter.next())){
                iter.remove();
            }
        }
    }

    public static void main(String[] args){
        String[] arrStr = {"lunes","martes","miercoles","jueves","viernes","sabado","domingo","lunes"};
        String diaCachirul = "Cachirul";
        String[] arrStr20 = new String[20];

        List<String> listArr = Arrays.asList(arrStr);
        HashSet<String> setArr = new HashSet<String>(listArr);
        TreeSet<String> treeSetArr = new TreeSet<>(listArr);
        LinkedHashSet<String> linkedHashSetArr = new LinkedHashSet<>(listArr);

        showln("listArr.indexOf(\"miercoles\"):" + listArr.indexOf("miercoles"));

        Collection<String> c = Arrays.asList(arrStr);
        Collection<String> c20 = Arrays.asList(arrStr20);
        Collection<String> cVacia = Arrays.asList();
        Collection<String> noDup = new HashSet<String>(c);
        Collection<String> c20NoDup = new HashSet<String>(c20);
        Collection<String> cList = new ArrayList<>(c);

        String joinedToString = c.stream().map(Object::toString).collect(Collectors.joining("_"));
        showln(joinedToString);
        System.out.println( cVacia.size() );
        System.out.println( c.size() );
        System.out.println( c.isEmpty() ? "collecion esta vacia" : "colleccion no vacia");
        System.out.println( c.contains("lunes" ) ? "si contiene lunes" : "no contiene lunes");
        //System.out.println( c.add( diaCachirul ) ? "OK add(\"lunes\")" : "NO add(\"lunes\")");
        noDup.add("cachirul");

        //for-each
        for ( String elem :  c){
            System.out.print(elem + " ");
        }   System.out.println();

        // Iterator
        for ( Iterator<?> iter = c.iterator(); iter.hasNext(); ){
            System.out.print(iter.next() + " ");
        }   System.out.println();

        //filter method
        showln("======= Filtrar Collecction con method ========");
        Collection<String> cAFiltrar = new HashSet<>();
        cAFiltrar.addAll(c);
        show("cAFiltrar:");cAFiltrar.stream().forEach(e -> show( e + " ")); showln();
        show("filter..."); filter(cAFiltrar); showln("OK");
        show("cAFiltrar:");cAFiltrar.stream().forEach(e -> show( e + " ")); showln();

        //aggregate operations
        c.stream().forEach( e -> System.out.print(e + " "));  System.out.println();

        showln("=========== Employee ==========");
        Collection<Employee> cEmployee = Employee.createEmployees();
        List<Person> cPerson = Person.createRoster();
        double total = cEmployee.stream().collect(Collectors.summingDouble(Employee::getSalary));
        cEmployee.stream().forEach( e -> show(
                 " employeeId: " + e.getId() +
                        " personId: " + e.getPerson().toString() +
                        " name:" + e.getPerson().getName() +
                        " salary: " + e.getSalary() + " \n" ));showln();
        showln(" total salaries: " +Double.toString(total));
        showln("===============================");
        System.out.println(cEmployee);

        noDup.stream().forEach(e -> System.out.print(e + " "));    System.out.println();
        //System.out.println( c.remove(arrStr[0]) ? "removido lunes" : "No removido lunes");
        //c.clear();
        System.out.print("c20 :");
        c20.stream().forEach(e -> System.out.print(e + " "));  System.out.println();
        //c20.removeAll(Collections.singleton(null));   //AbstractList.remove

        System.out.println("c20NoDup size: " + c20NoDup.size());
        c20NoDup.stream().forEach(e -> System.out.print(e + " ")); System.out.println();
        c20NoDup.add("unoMas");
        System.out.println("c20NoDup size: " + c20NoDup.size());
        c20NoDup.stream().forEach(e -> System.out.print(e + " ")); System.out.println();
        c20NoDup.remove("unoMas");
        c20NoDup.stream().forEach(e -> System.out.print(e + " ")); System.out.println();
        c20NoDup.addAll(c);
        c20NoDup.stream().forEach(e -> System.out.print(e + " ")); System.out.println();
        c20NoDup.removeAll(Collections.singleton(null));
        c20NoDup.stream().forEach(e -> System.out.print(e + " ")); System.out.println();

        System.out.println("cList:");
        cList.stream().forEach(e -> System.out.print(e + " ")); System.out.println();
        cList.addAll(c);
        cList.stream().forEach(e -> System.out.print(e + " ")); System.out.println();
        cList.remove("lunes");
        cList.stream().forEach(e -> System.out.print(e + " ")); System.out.println();
        cList.remove("lunes");
        cList.stream().forEach(e -> System.out.print(e + " ")); System.out.println();
        cList.removeAll(Collections.singleton("miercoles"));
        cList.stream().forEach(e -> System.out.print(e + " ")); System.out.println();

        //Arrays Creacion Asignacion
        String[] semana = new String[]{"lunes","martes","miercoles","jueves","viernes","sabado","domingo"};
        String[] semanaduplicada = semana.clone();
        String[] laborables = new String[]{"lunes","martes","miercoles","jueves","viernes"};
        String[] noLaborables = new String[]{"sabado","domingo"};
        String[] viernesFinSemana = new String[]{"viernes","sabado","domingo"};
        int[] naturales = new int[]{0,1,2,3,4,5,6,7,8,9};

        //Collections Creacion Asignacion
        System.out.println("== Collections Creacion Asignacion ==");
        Collection<String> cSemana = new HashSet<String>(Arrays.asList(semana));
        Collection<String> cLaborables = new HashSet<String>(Arrays.asList(laborables));
        Collection<String> cNoLaborables = new HashSet<String>(Arrays.asList(noLaborables));
        Collection<String> cViernesFinSemana = Arrays.asList(viernesFinSemana);
        Collection<String> cSemanaDuplicada = new ArrayList<String>(cSemana);
        cSemanaDuplicada.addAll(cSemana);
        //Despliegue de contenido Cargado de Collections
        cSemana.stream().forEach(e -> System.out.print(e + " ")); System.out.println();
        cLaborables.stream().forEach(e -> System.out.print( e + " ")); System.out.println();
        cNoLaborables.stream().forEach(e -> System.out.print( e + " ")); System.out.println();
        cSemanaDuplicada.stream().forEach(e -> System.out.print( e + " ")); System.out.println();

        //containsAll
        System.out.println("== Collections containsAll method ==");
        System.out.println(cSemana.containsAll(cLaborables) ? "cSemana.containsAll(claborables) : true" : "cSemana.containsAll(claborables) : false");
        System.out.println(cLaborables.containsAll(cSemana) ? "cLaborables.containsAll(cSemana) : true" : "cLaborables.containsAll(cSemana) : false");
        System.out.println(cLaborables.containsAll(cNoLaborables) ? "cLaborables.containsAll(cNoLaborables) : true" : "cLaborables.containsAll(cNoLaborables) : false");
        //removeAll
        System.out.println("== Collections removeAll method ==");
        Collection<String> cSemanaTemp = new HashSet<>();
        Collection<String> cLaborablesTemp = new HashSet<>();

        cSemanaTemp.addAll(cSemana);
        show("cSemanaTemp: "); cSemanaTemp.stream().forEach( e -> show(e + " ")); System.out.println();
        showln(cNoLaborables.removeAll(cLaborables) ? "cNoLaborables.removeAll(cLaborables): true" : "cNoLaborables.removeAll(cLaborables): false");
        showln(cSemanaTemp.removeAll(cNoLaborables) ? "cSemanaTemp.removeAll(cNoLaborables): true " : "cSemanaTemp.removeAll(cNoLaborables): false");
        show("cSemanaTemp: "); cSemanaTemp.stream().forEach( e -> show(e + " ")); System.out.println();

        cLaborablesTemp.addAll(cLaborables);
        show("cLaborablesTemp: "); cLaborablesTemp.stream().forEach( e -> show(e + " ")); System.out.println();
        showln(cLaborablesTemp.removeAll(cViernesFinSemana) ? "cLaborablesTemp.removeAll(cViernesFinSemana):true" : "cLaborablesTemp.removeAll(cViernesFinSemana):false");
        show("cLaborablesTemp: "); cLaborablesTemp.stream().forEach( e -> show(e + " ")); System.out.println();
        /* cTemp es un apuntador a cSemana, todo lo que se le haga a cTemp se le esta haciendo a cSemana
        Collection<String> cTemp = cSemana;
        cTemp.removeAll(cLaborables);
        cTemp.stream().forEach(e -> System.out.print(e + " ")); System.out.println();
        cSemana.stream().forEach(e -> System.out.print(e + " ")); System.out.println();
        */

        //retainAll
        System.out.println("== Collections retainAll method ==");
        Collection<String> cNoLaborablesTemp = new HashSet<>();
        cSemanaTemp.addAll(cSemana);
        cNoLaborablesTemp.addAll(cNoLaborables);

        show("cSemanaTemp: "); cSemanaTemp.stream().forEach( e -> show(e + " ")); System.out.println();
        show("cNoLaborables: "); cNoLaborables.stream().forEach( e -> show( e + " ")); System.out.println();
        showln(cNoLaborables.retainAll(cLaborables) ? "cNoLaborables.retainAll(cLaborables): true" : "cNoLaborables.retainAll(cLaborables): false");
        show("cNoLaborables: "); cNoLaborables.stream().forEach( e -> show( e + " ")); System.out.println();

        cNoLaborables.addAll(cNoLaborablesTemp);
        show("cNoLaborables: "); cNoLaborables.stream().forEach( e -> show( e + " ")); System.out.println();
        showln(cSemanaTemp.retainAll(cNoLaborables) ? "cSemanaTemp.retainAll(cNoLaborables): true " : "cSemanaTemp.retainAll(cNoLaborables): false");
        show("cSemanaTemp: "); cSemanaTemp.stream().forEach( e -> show(e + " ")); System.out.println();

        cLaborablesTemp.addAll(cLaborables);
        show("cLaborablesTemp: "); cLaborablesTemp.stream().forEach( e -> show(e + " ")); System.out.println();
        showln(cLaborablesTemp.retainAll(cViernesFinSemana) ? "cLaborablesTemp.retainAll(cViernesFinSemana):true" : "cLaborablesTemp.retainAll(cViernesFinSemana):false");
        show("cLaborablesTemp: "); cLaborablesTemp.stream().forEach( e -> show(e + " ")); System.out.println();

        //Collection Interface Array Operations
        System.out.println("== Collection Interface Array Operations ==");
        String[] lengthIdenticaltoColl = c.toArray(new String[c.size()]);
        System.out.format("collection size: %d array.length %d%n", c.size(), lengthIdenticaltoColl.length);

        String[] lengthIdenticaltoCollwith0 = c.toArray(new String[0]);
        System.out.format("collection size: %d array.length %d%n", c.size(), lengthIdenticaltoCollwith0.length);


    }
}
