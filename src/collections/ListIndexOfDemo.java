package collections;

import java.util.*;

import static collections.DemoUtils.showln;

/**
 * Created by Bext on 07/02/2017.
 */
public class ListIndexOfDemo {

    static <E> int indexOfSinIterator(List<E> list, E e){
        if (e == null) return -1;
        /*for (Iterator<E> iter = list.listIterator(); iter.hasNext()){
            if ( e.equals(iter.next()))
                return iter.???? //No se puede obtener el indice con Iterator
            }
        }
        */
        for( int i = 0; i < list.size(); i++ ){
            if (e.equals(list.get(i)))
                return i;
        }
        return -1;  // no hallado
    }

    static <E> int indexOfListIterator( List<E> list, E e) {
        for (ListIterator<E> iter = list.listIterator(); iter.hasNext();){
/*
            if (e == null) {
                    if (iter.next() == null)  // fin de la lista
                        return iter.previousIndex();
            }else { if (e.equals(iter.next()))
                        return iter.previousIndex();
            }
*/          /*Codigo if con ? : equivalente, simplificado*/
            if (e == null ? iter.next() == null : e.equals(iter.next()))
                return iter.previousIndex();
        }
        return -1; //no hallado
    }

    static <E> void replace(List<E> list, E val, E newVal) {
        for (ListIterator<E> iter = list.listIterator(); iter.hasNext();){
            if ( val == null ? iter.next() == null : val.equals( iter.next())){
                iter.set( newVal);
            }
        }
    }

    /*
    *  Esta funcion debe tener ArrayList como type de parametro, ya que List no soporta remove
    *  la Varaiable que es pasada como parametro list, tambien debe ser declarada como ArrayList
    *  en el tutoria esta como List y asi no funciona.
    * */
    static <E> void replaceConList(ArrayList<E> list, E val, List<E> newVals){
        for(ListIterator<E> iter = list.listIterator(); iter.hasNext();) {
            if ( val == null ? iter.next() == null : val.equals(iter.next())){
                iter.remove();
                for ( E elem: newVals){
                    iter.add(elem);
                }
            }
        }
    }

    static public void main(String[] args) {
        String[] arrSemana = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        Integer[] arrNum = new Integer[]{0,1,2,3,4,5,6,7,8,9,10};

        List<String> listSemana = Arrays.asList(arrSemana);  //arrSemana se vera afectado en sus valores
                                                             //por la funcion replace
        List<Integer> listNum = Arrays.asList( new Integer[]{0,1,2,3,4,5,6,7,8,9,10});
        List<String> listAInsertar = Arrays.asList( new String[]{"ins1","ins2","ins3"});
        List<Integer> listNumAInsertar = Arrays.asList(new Integer[]{33,22,11});

        System.out.println(listNum);
        System.out.println("indexOfSinIterator(listNum, 2):");
        System.out.println(indexOfSinIterator(listNum, 2));

        System.out.println(listSemana);
        System.out.println("indexOfSinIterator(listSemana, \"Miercoles\")");
        System.out.println(indexOfSinIterator(listSemana, "Miercoles"));

        System.out.println("indexOfSinIterator(listSemana, null)");
        System.out.println(indexOfSinIterator(listSemana, null));

        System.out.println(listNum);
        System.out.println("indexOfListIterator(listNum, 2):");
        System.out.println(indexOfListIterator(listNum, 2));

        System.out.println(listSemana);
        System.out.println("indexOfListIterator(listSemana, \"Miercoles\")");
        System.out.println(indexOfListIterator(listSemana, "Miercoles"));

        System.out.println("indexOfListIterator(listSemana, null)");
        System.out.println(indexOfListIterator(listSemana, null));

        System.out.println("========= replace ========");
        System.out.println(listNum);
        System.out.println("replace(listNum, 4, 99);");
        replace(listNum, 4, 99);
        System.out.println(listNum);

        System.out.println(listSemana);
        System.out.println("replace(listSemana, \"lunes\", \"SABADO\");");
        replace(listSemana, "Lunes", "SABADO");
        System.out.println(listSemana);

        List<String> listNuls = Arrays.asList(new String[10]);
        System.out.println(listNuls);
        System.out.println("replace(listSemana, null, \"ALGO\");");
        replace(listSemana, null, "ALGO");
        System.out.println(listNuls);

        System.out.println("========= replaceConList ========");
        listSemana = Arrays.asList(new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"});
        listNum = Arrays.asList(arrNum);

        ArrayList<String> arrListSemana = new ArrayList<>();
        arrListSemana.addAll(listSemana);

        ArrayList<Integer> arrListNum = new ArrayList<>();
        arrListNum.addAll(listNum);

        System.out.println(arrListSemana);
        System.out.println(arrListNum);
        System.out.println(listAInsertar);
        System.out.println("replaceConList(arrListSemana, \"Miercoles\", listAInsertar);");
        replaceConList(arrListSemana, "Miercoles", listAInsertar);
        System.out.println(arrListSemana);
        System.out.println("replaceConList(arrListNum, 5, listNumAInsertar);");
        replaceConList(arrListNum, 5, listNumAInsertar);
        System.out.println(arrListNum);
    }
}
