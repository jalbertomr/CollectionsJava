package collections;

import java.util.*;

import static collections.DemoUtils.show;
import static collections.DemoUtils.showln;

/**
 * Created by Bext on 08/02/2017.
 */
public class MapBulkOper {

    //este metodo no modifica el map defaults
    static <K, V> Map<K ,V> newAttributesMap( Map<K ,V> defaults,  Map<K, V> override ){
        Map<K ,V> results = new LinkedHashMap<K, V>(defaults);
        results.putAll( override);
        return results;
    }

    //este metodo modifica el map fuenteyDestino
    static <K,V> void newAttriburtesMapParam( Map<K,V> fuenteyDestino, Map<K,V> override) {
        fuenteyDestino.putAll( override);
    }

    static public void main(String args[]) {
        String[] arrKeys = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        Integer[] arrValues = new Integer[]{0,1,2,3,4,5,6,7};

        String[] arrKeysOver = new String[]{"Domingo","Viernes","Sabado"};
        Integer[] arrValuesOver = new Integer[]{ 7,7,7 };

        String[] arrKeysCaracteristicas = new String[]{
                "color","alto","ancho","largo","temperatura","peso","alto"
        };
        String[] arrValuesCaracteristicas = new String[]{
                "blanco","0","0","0","24c","0","altoREPETIDO"
        };

        String[] arrKeysCaracOver = new String[]{
                "alto","ancho","largo","temperatura"
        };
        String[] arrValuesCaracOver = new String[]{
                "15cm","4cm","4cm","15c"
        };

        //llenado de Maps
        Map<String,String> mapCarac = new HashMap<>();
        for (int i = 0; i < arrKeysCaracteristicas.length; i++){
            mapCarac.put( arrKeysCaracteristicas[i],arrValuesCaracteristicas[i]);
        }

        Map<String,String> mapCaracOver = new HashMap<>();
        for (int i = 0; i < arrKeysCaracOver.length; i++){
            mapCaracOver.put( arrKeysCaracOver[i],arrValuesCaracOver[i]);
        }

        Map<String, Integer> mapHorasSemanaPatron = new LinkedHashMap<String,Integer>();
        for ( int i = 0 ; i < arrKeys.length; i ++ ) {
            mapHorasSemanaPatron.put( arrKeys[i], arrValues[i]);
        }

        Map<String, Integer> mapHorasSemanaOver = new LinkedHashMap<String,Integer>();
        for ( int i = 0; i < arrKeysOver.length; i++){
            mapHorasSemanaOver.put( arrKeysOver[i], arrValuesOver[i]);
        }

        Map<String,Integer> mapHorasSemana =  new LinkedHashMap<>( mapHorasSemanaPatron);

        //Overide de maps key, values
        System.out.println(mapHorasSemana);
        System.out.println(mapHorasSemanaOver);
        System.out.println("mapHorasSemana.putAll(mapHorasSemanaOver);");
        mapHorasSemana.putAll(mapHorasSemanaOver);
        System.out.println(mapHorasSemana); showln();

        mapHorasSemana.putAll(mapHorasSemanaPatron);
        System.out.println(mapHorasSemana);
        System.out.println(mapHorasSemanaOver);
        System.out.println("newAttriburtesMapParam(mapHorasSemana,mapHorasSemanaOver);");
        newAttriburtesMapParam(mapHorasSemana,mapHorasSemanaOver);
        System.out.println(mapHorasSemana); showln();

        mapHorasSemana.putAll(mapHorasSemanaPatron);
        System.out.println(mapHorasSemana);
        System.out.println(mapHorasSemanaOver);
        System.out.println("Map<String,Integer> mapResult = newAttributesMap(mapHorasSemana,mapHorasSemanaOver);");
        Map<String,Integer> mapResult = newAttributesMap(mapHorasSemana,mapHorasSemanaOver);
        System.out.println(mapHorasSemana);
        System.out.println(mapResult); showln();

        System.out.println(mapCarac);
        System.out.println(mapCaracOver);
        System.out.println("mapCarac.putAll(mapCaracOver);");
        mapCarac.putAll(mapCaracOver);
        System.out.println(mapCarac); showln();

    }
}
