package collections;

import java.util.*;

import static collections.DemoUtils.show;
import static collections.DemoUtils.showln;

/**
 * Created by Bext on 06/02/2017.
 */
public class ListIteratorDemo {


    public static void main(String[] args) {
        List<String> listSemana =
                Arrays.asList( new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"} );
        List<Integer> listNaturales = Arrays.asList( new Integer[]{0,1,2,3,4,5,6,7,8,9});

        show("for(Iterator<Integer> it = listNaturales.iterator(); it.hasNext();){\n" +
                "            show( it.next() + \" \");   --->");
        for(Iterator<Integer> it = listNaturales.iterator(); it.hasNext();){
            show( it.next() + " ");
        }   showln();

        show("for (ListIterator<Integer> it = listNaturales.listIterator(); it.hasNext();) {\n" +
                "            show( it.next() + \" \");   --->");
        for (ListIterator<Integer> it = listNaturales.listIterator(); it.hasNext();) {
            show( it.next() + " ");
        }   showln();

        show("for (ListIterator<Integer> it = listNaturales.listIterator(listNaturales.size()); it.hasNext();) {\n" +
                "            show( it.next() + \" \");  --->");
        for (ListIterator<Integer> it = listNaturales.listIterator(listNaturales.size()); it.hasNext();) {
            show( it.next() + " ");
        }   showln();

        show("for (ListIterator<Integer> it = listNaturales.listIterator( listNaturales.size()); it.hasPrevious();) {\n" +
                "            show( it.next() + \" \");  --->");
        for (ListIterator<Integer> it = listNaturales.listIterator( listNaturales.size()); it.hasPrevious();) {
            show( it.previous() + " ");
        }   showln();
    }
}
