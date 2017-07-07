package collections;

import java.util.*;

import static collections.DemoUtils.show;
import static collections.DemoUtils.showln;

/**
 * Created by Bext on 09/02/2017.
 */
public class CollectsCopys {
    static public void main(String[] args){
        List<String> listSemana = Arrays.asList(
                new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"});
        List<String> listStringDemo = Arrays.asList(new String[]
                {"aaa","abc","abb","b","bbb","baa","bab","bb","cccc","ccba"});
        Set<String> hashsetStringDemo = new HashSet<>();

        showln("===== Set <-- List =====");
        System.out.println("listStringDemo: " + listStringDemo);
        showln("Collections.sort(listStringDemo);");

        Collections.sort(listStringDemo);

        System.out.println("listStringDemo: " + listStringDemo);

        Collections.sort(listStringDemo, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println("listStringDemo: " + listStringDemo);

        listStringDemo.stream().forEach(e -> hashsetStringDemo.add(e));
        System.out.println("hashsetStringDemo: " + hashsetStringDemo);

        Set<String> hashsetSemana = new HashSet<>();
        show("listSemana: ");
        System.out.println("listSemana: " + listSemana);
        listSemana.stream().forEach(e -> hashsetSemana.add(e));
        System.out.println("hashsetSemana" + hashsetSemana);

        //Collections.sort( hashsetSemana);  // Error Tiene que ser List
        showln("====== List <---- Set ======");
        List<String> listString = new ArrayList<String>();
        hashsetSemana.stream().forEach(e -> listString.add(e));
        System.out.println(listString);

    }
}
