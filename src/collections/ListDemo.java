package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static collections.DemoUtils.showln;

/**
 * Created by Bext on 06/02/2017.
 */
public class ListDemo {

    static public <E> void swapElements(List<E> list, int i, int j) {
        E temp;
        temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    static public void shuffle(List<?> list, Random rnd) {
        for ( int i = list.size(); i > 1; i--){
            swapElements(list, i - 1 , rnd.nextInt(i));
            System.out.println(list);
        }
    }

    static public void main(String[] args){
        List<String> listSemana = new ArrayList<String>(
                                            Arrays.asList(
                        new String[]{"lunes","martes","miercoles","jueves","viernes","sabado","domingo"}));

        List<Person> listPerson = Person.createRoster();  //static method
        List<String> listNames;
        System.out.println(listPerson.stream().map(Person::getName).collect(Collectors.toList()));
        listNames = listPerson.stream().map(Person::getName).collect(Collectors.toList());

        //SwapElements in List
        Integer[] arrNaturales = new Integer[]{0,1,2,3,4,5,6,7,8,9};
        List<Integer> listNaturales = Arrays.asList(arrNaturales);

        System.out.println(listNaturales);
        showln("===== swapElements(listNaturales, 1, 8 ======");
        swapElements(listNaturales, 1, 8 );
        System.out.println(listNaturales);
        showln("===== swapElements(listNaturales, 0, 9 ======");
        swapElements(listNaturales, 0, 9 );
        System.out.println(listNaturales);

        showln("===== shuffle =========");
        listNaturales = Arrays.asList(arrNaturales);
        shuffle(listNaturales, new Random());
    }
}
