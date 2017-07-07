package collections;

import java.util.*;
import java.util.stream.Collector;

import static collections.DemoUtils.show;
import static collections.DemoUtils.showln;

/**
 * Created by Bext on 07/02/2017.
 */
public class ListAlgoritms {

    //static final Integer[] arrNum = new Integer[]{0,1,2,3,4,5,6,7,8,9,10};
    // Curioso: aunque sea static y final el arrNum si se modifica con las Collections operations

    public static void main(String[] args){
        String[] arrSemana = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        Integer[] arrNumOrig = new Integer[]{0,1,2,3,4,5,6,7,8,9,10};
        Integer[] arrNum = new Integer[]{0,1,2,3,4,5,6,7,8,9,10};

        List<String> listSemana = Arrays.asList(arrSemana);  //arrSemana se vera afectado en sus valores
        //por la funcion replace
        List<Integer> listNum = Arrays.asList(arrNum);
        List<Integer> listNumNum = new ArrayList<>();
        listNumNum.addAll(listNum);
        listNumNum.addAll(listNum);listNumNum.addAll(listNum);

        List<String> listAInsertar = Arrays.asList( new String[]{"ins1","ins2","ins3"});
        List<Integer> listABuscar = Arrays.asList(new Integer[]{3,4,5});

        System.out.println("======= List shuffle ========");
        System.out.println(listNum);
        Collections.shuffle(listNum);
        System.out.println(listNum);

        System.out.println("======= List sort ========");
        System.out.println(listNum);
        showln("Collections.sort(listNum);");
        Collections.sort(listNum);
        System.out.println(listNum);
        showln("Collections.sort(listNum, new Comparator<Integer>() {\n" +
                "            @Override\n" +
                "            public int compare(Integer o1, Integer o2) {\n" +
                "                return o2 - o1;\n" +
                "            }\n" +
                "        });");
        Collections.sort(listNum, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(listNum);
        showln("Collections.sort( listNum, new Comparator<Integer>(){\n" +
                "            public int compare(Integer o1, Integer o2) {\n" +
                "                return o1 - o2;\n" +
                "            } \n" +
                "        });");
        Collections.sort( listNum, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(listNum);

        System.out.println(listSemana);
        showln("Collections.sort(listSemana);");
        Collections.sort(listSemana);
        System.out.println(listSemana);
        showln("Collections.sort(listSemana, new Comparator<String>() {\n" +
                "            @Override\n" +
                "            public int compare(String o1, String o2) {\n" +
                "                return o1.length() - o2.length();\n" +
                "            }\n" +
                "        });");
        Collections.sort(listSemana, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(listSemana);

        System.out.println("======= List reverse ========");
        System.out.println(listNum);
        Collections.reverse(listNum);
        System.out.println(listNum);

        System.out.println("======= List rotate ========");
        System.out.println(listNum);
        System.out.println("Collections.rotate(listNum, 1);");
        for (int i = 0; i < listNum.size(); i++) {
            Collections.rotate(listNum, 1);
            System.out.println(listNum);
        }

        System.out.println("Collections.rotate(listNum, 3);");
        for (int i = 0; i < listNum.size(); i++) {
            Collections.rotate(listNum, 3);
            System.out.println(listNum);
        }

        System.out.println("======= List swap ========");
        System.out.println(listNum);
        System.out.println("Collections.swap(listNum, 0,10);");
        Collections.swap(listNum, 0,10);
        System.out.println(listNum);

        System.out.println("======= List replaceAll ========");
        Collections.sort(listNum);
        System.out.println(listNum);
        System.out.println("Collections.replaceAll(listNum, 2, 9);");
        Collections.replaceAll(listNum, 2, 9);
        System.out.println(listNum);
        System.out.println("Collections.replaceAll(listNum, 9, 3);");
        Collections.replaceAll(listNum, 9, 3);
        System.out.println(listNum);
        System.out.println("Collections.replaceAll(listNum, 3,7);");
        Collections.replaceAll(listNum, 3,7);
        System.out.println(listNum);

        System.out.println("======= List copy ========");
        List<Integer> listCopied = Arrays.asList( arrNumOrig );
        System.out.println("listCopied: " + listCopied);
        System.out.println("listNum:" + listNum);
        System.out.println("Collections.copy( listCopied, listNum);");
        Collections.copy( listCopied, listNum);

        System.out.println("listCopied: " + listCopied);
        System.out.println("listNum:" + listNum);

        System.out.println("======= List fill ========");
        System.out.println("listNum:" + listNum);
        System.out.println("Collections.fill( listCopied, 1);");
        Collections.fill( listNum, 1);
        System.out.println("listNum:" + listNum);

        System.out.println("======= List indexOfSubList ========");
        System.out.println("listNumNum:" + listNumNum);
        System.out.println("listABuscar:" + listABuscar);
        System.out.print("Collections.indexOfSubList(listNumNum, listABuscar): ");
        System.out.println(Collections.indexOfSubList(listNumNum, listABuscar));
        System.out.print("Collections.lastIndexOfSubList(listNumNum, listABuscar): ");
        System.out.println(Collections.lastIndexOfSubList(listNumNum, listABuscar));

        System.out.println("======= List binarySearch ========");
        System.out.println("Collections.binarySearch(listNumNum, 3): " +
                Collections.binarySearch(listNumNum, 3));

        System.out.println("Collections.frequency(listNumNum, 4): " + Collections.frequency(listNumNum,4));
        System.out.println("Collections.frequency(listNum, 1): " + Collections.frequency(listNum,1));

        System.out.println("listNum:" + listNum);
        System.out.println("listNumNum:" + listNumNum);
        System.out.println("listNumNum.addAll(10, listNum);");
        listNumNum.addAll(10, listNum);
        System.out.println("listNum:" + listNum);
        System.out.println("listNumNum:" + listNumNum);
        System.out.println("Collections.disjoint(listNumNum,listNum): " + Collections.disjoint(listNumNum,listNum));
        System.out.println("Collections.disjoint(listNum,listNumNum): " + Collections.disjoint(listNum,listNumNum));

        List<Integer> listArrNum = new ArrayList<>();
        System.out.println(listNumNum.subList(0,10));
        //listNum.addAll(listNumNum.subList(0,10));  //UnsupportedOperationException: es List no ArrayList
        listNumNum.subList(0,10).stream().forEach(e -> listArrNum.add(e));
        System.out.println("listArrNum: "+ listArrNum);
        listArrNum.clear();
        listArrNum.addAll(listNumNum.subList(0,10));
        System.out.println("listArrNum: "+ listArrNum);

        listNumNum.clear();
        listNumNum.addAll( listArrNum);
        listNumNum.addAll( listArrNum);
        listNumNum.addAll( listArrNum);
        System.out.println("listArrNum:" + listArrNum);
        System.out.println("listNumNum:" + listNumNum);
        System.out.println("Collections.disjoint(listNumNum,listNum): " + Collections.disjoint(listNumNum,listArrNum));
        System.out.println("Collections.disjoint(listNum,listNumNum): " + Collections.disjoint(listArrNum,listNumNum));
        List<Integer> listOtrosNumeros = Arrays.asList(new Integer[]{234,53,544,999});
        System.out.println("listOtrosNumeros:" + listOtrosNumeros);
        System.out.println("Collections.disjoint(listOtrosNumeros,listNumNum): " + Collections.disjoint(listOtrosNumeros,listNumNum));

        listNumNum.add(23);
        listNumNum.removeAll(Collections.singleton(0));

        System.out.println("Collections.max(listNumNum): " + Collections.max(listNumNum));
        System.out.println("Collections.min(listNumNum): " + Collections.min(listNumNum));

        List<Integer> listNumABorrar = Arrays.asList(new Integer[]{3,4,5,6,7});
        listNumNum.removeAll(listNumABorrar);
        System.out.println("listNumABorrar: " + listNumABorrar);
        System.out.println("listNumNum.removeAll(listNumABorrar);");
        System.out.println("listNumNum: " + listNumNum);
    }
}
