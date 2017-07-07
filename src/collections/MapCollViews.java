package collections;

import java.util.*;

import static collections.DemoUtils.show;
import static collections.DemoUtils.showln;

/**
 * Created by Bext on 08/02/2017.
 */
public class MapCollViews {
    static public void main(String[] args){

        String[] arrKeysCaracteristicas = new String[]{
                "color","alto","ancho","largo","temperatura","peso","alto"
        };
        String[] arrValuesCaracteristicas = new String[]{
                "blanco","0","0","0","24c","0","0"
        };

        String[] arrKeys = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        Integer[] arrValues = new Integer[]{0,1,2,3,4,5,6,7};


        //llenado de Maps
        Map<String,String> mapCarac = new HashMap<>();
        for (int i = 0; i < arrKeysCaracteristicas.length; i++){
            mapCarac.put( arrKeysCaracteristicas[i],arrValuesCaracteristicas[i]);
        }

        Map<String, Integer> mapHorasSemana = new LinkedHashMap<String,Integer>();
        for ( int i = 0 ; i < arrKeys.length; i ++ ) {
            mapHorasSemana.put( arrKeys[i], arrValues[i]);
        }


        System.out.println("=========== Collection Views ===========");
        System.out.println("Set<String> mapCarSetKeys  = mapCarac.keySet();");
        Set<String> mapCarSetKeys  = mapCarac.keySet();
        System.out.println(mapCarSetKeys); showln();

        System.out.println("Collection<String> mapCollValues = mapCarac.values();");
        Collection<String> mapCollValues = mapCarac.values();
        System.out.println(mapCollValues); showln();

        System.out.println("Set<Map.Entry<String,String>> mapCarSetEntry = mapCarac.entrySet();");
        Set<Map.Entry<String,String>> mapCarSetEntry = mapCarac.entrySet();
        System.out.println(mapCarSetEntry); showln();

        System.out.println("for( String key : mapCarac.keySet()){");
        for( String key : mapCarac.keySet()){
            System.out.print(key + " ");
        }   showln();

        System.out.println("for ( String value: mapCarac.values()){");
        for ( String value: mapCarac.values()){
            System.out.print(value + " ");
        }  showln();

        System.out.println("for ( Map.Entry<String,String> entry : mapCarac.entrySet()){");
        for ( Map.Entry<String,String> entry : mapCarac.entrySet()){
            System.out.print("key: " + entry.getKey() + "_value: "+ entry.getValue() + " | ");
        }  showln();

        System.out.println("for (Iterator<String> iter = mapCarac.keySet().iterator(); iter.hasNext();){");
        for (Iterator<String> iter = mapCarac.keySet().iterator(); iter.hasNext();){
            System.out.print(iter.next() + " ");
        } showln();

        System.out.println("for (Iterator<String> iter = mapCarac.values().iterator(); iter.hasNext();){");
        for (Iterator<String> iter = mapCarac.values().iterator(); iter.hasNext();){
            System.out.print(iter.next() + " ");
        } showln();

        System.out.println("for ( Iterator<Map.Entry<String,String>> iter =  mapCarac.entrySet().iterator(); iter.hasNext();){");
        for ( Iterator<Map.Entry<String,String>> iter =  mapCarac.entrySet().iterator(); iter.hasNext();){
            System.out.println("key: " + iter.next().getKey() + "_value: " + iter.next().getValue() + "|");
        } showln();

        System.out.println("for ( Iterator<Map.Entry<String,String>> iter =  mapCarac.entrySet().iterator(); iter.hasNext();){");
        for ( Iterator<Map.Entry<String,String>> iter =  mapCarac.entrySet().iterator(); iter.hasNext();){
            Map.Entry<String,String> current = iter.next();
            System.out.println("key: " + current.getKey() + "_value: " + current.getValue() + "|");
            if (current.getKey().compareTo("alto") == 0) current.setValue("ALTOcambiado");
        } showln();
        System.out.println(mapCarac);

        System.out.println("for (Iterator<String> iter = mapCarac.keySet().iterator(); iter.hasNext();){");
        for (Iterator<String> iter = mapCarac.keySet().iterator(); iter.hasNext();){
            //System.out.print(iter.next() + " ");  //si se deja se brinca uno con iter
            if (iter.next().compareTo("color") == 0) iter.remove();
        } showln();
        System.out.println(mapCarac); showln();

        showln("Set<String> mapSem = mapHorasSemana.keySet();");
        Set<String> mapSem = mapHorasSemana.keySet();
        System.out.println(mapSem);

        showln("Collection<Integer> mapSemCollvalues = mapHorasSemana.values();");
        Collection<Integer> mapSemCollvalues = mapHorasSemana.values();
        System.out.println(mapSemCollvalues);

        showln("Set<Map.Entry<String,Integer>> mapSemEntrySet = mapHorasSemana.entrySet();");
        Set<Map.Entry<String,Integer>> mapSemEntrySet = mapHorasSemana.entrySet();
        System.out.println(mapSemEntrySet);

        showln("for ( String dia: mapHorasSemana.keySet()){");
        for ( String dia: mapHorasSemana.keySet()){
            show(dia + " ");
        }   showln();

        showln("for ( Integer horas: mapHorasSemana.values()){");
        for ( Integer horas: mapHorasSemana.values()){
            show( horas + " ");
        }   showln();

        showln("for ( Map.Entry<String,Integer> entry : mapHorasSemana.entrySet()){");
        for ( Map.Entry<String,Integer> entry : mapHorasSemana.entrySet()){
            show( "key: " + entry.getKey() + "_value: " + entry.getValue() + "|");
        }   showln();

        showln("for( Iterator<String> iter = mapHorasSemana.keySet().iterator(); iter.hasNext();){");
        for( Iterator<String> iter = mapHorasSemana.keySet().iterator(); iter.hasNext();){
            show( iter.next() + " ");
        }   showln();

        showln("for( Iterator<Integer> iter = mapHorasSemana.values().iterator(); iter.hasNext()){");
        for( Iterator<Integer> iter = mapHorasSemana.values().iterator(); iter.hasNext();){
            show( iter.next() + " ");
        }   showln();

        showln("for( Iterator<Map.Entry<String,Integer>> iter = mapHorasSemana.entrySet().iterator(); iter.hasNext();){");
        for( Iterator<Map.Entry<String,Integer>> iter = mapHorasSemana.entrySet().iterator(); iter.hasNext();){
            Map.Entry<String,Integer> entry = iter.next();
            show("key: " + entry.getKey() + "_value: " + entry.getValue() + "|");
        }   showln();

        showln("for( Iterator<Map.Entry<String,Integer>> iter =  mapHorasSemana.entrySet().iterator(); iter.hasNext();){");
        for( Iterator<Map.Entry<String,Integer>> iter =  mapHorasSemana.entrySet().iterator(); iter.hasNext();){
            Map.Entry<String,Integer> current = iter.next();
            show("key: " + current.getKey() + "_value: " + current.getValue() + "|");
            if (current.getKey().endsWith("es")) current.setValue(5);
        }   showln();
        System.out.println(mapHorasSemana);

        showln("for(Iterator<Map.Entry<String,Integer>> iter = mapHorasSemana.entrySet().iterator(); iter.hasNext();){");
        for(Iterator<Map.Entry<String,Integer>> iter = mapHorasSemana.entrySet().iterator(); iter.hasNext();){
            Map.Entry<String,Integer> curr = iter.next();
            show("key: " + curr.getKey() + "_value: " + curr.getValue() + "|");
            if (curr.getKey().contains("M")) iter.remove();
        }   showln();
        System.out.println(mapHorasSemana);

    }
}
