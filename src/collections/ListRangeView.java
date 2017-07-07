package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bext on 07/02/2017.
 */
public class ListRangeView {
    static public void main(String[] args) {
        List<String> listSemanaOrig = Arrays.asList( new String[] {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"});
        List<String> listSemana = new ArrayList<>();

        Integer[] arrInt = {0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9};
        List<Integer> listNumerosOrig = Arrays.asList(arrInt);
        List<Integer> listNumeros = new ArrayList<>();


        listSemana.addAll(listSemanaOrig);
        System.out.println("listSemana:" + listSemana);
        listSemana.subList(1,5).clear();
        System.out.println("listSemana.subList(1,5).clear();");
        System.out.println("listSemana:" + listSemana);

        listNumeros.addAll(listNumerosOrig);
        System.out.println("listNumeros: " + listNumeros);
        System.out.println("listNumeros.subList(2, 17).indexOf(4): " +  listNumeros.subList(2, 17).indexOf(4));
        System.out.println("listNumeros.subList(2, 17).lastIndexOf(4): " + listNumeros.subList(2, 17).lastIndexOf(4));
    }
}
