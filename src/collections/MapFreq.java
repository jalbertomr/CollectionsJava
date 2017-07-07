package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Bext on 08/02/2017.
 */
public class MapFreq {
    public static void main(String[] args) {
        Map<String, Integer> mapHashMap = new HashMap<>();

        System.out.println("========= HashMap ========");
        //map.put("if", 1);
        //System.out.println( map.get("ifd"));  //regresaria null
        for( String word: args){
            Integer value = mapHashMap.get(word);

            /*  map.put codigo largo
            if (value == null) {
                map.put( word , 1);
            } else
                map.put( word, value + 1);
            */
            //map.put codigo corto
            mapHashMap.put( word, (value == null) ? 1 : value + 1);
        }

        System.out.println(mapHashMap.size() + " palabras distintas: " );
        System.out.println(mapHashMap);

        System.out.println("========= TreeMap ======== alphabetical ordered");
        //Ordered in alphabetical order use the TreeMap
        Map<String, Integer> mapTreeMap = new TreeMap<>();
        for (String word: args) {
            Integer value = mapTreeMap.get( word);
            mapTreeMap.put( word, value == null ? 1 : value + 1);
        }
        System.out.println(mapTreeMap.size() + " palabras distintas: " );
        System.out.println(mapTreeMap);

        System.out.println("========= LinkedHashMap ========");
        Map<String, Integer> mapLinkedHashMap = new LinkedHashMap<>();
        for ( String word : args){
            Integer value = mapLinkedHashMap.get( word);
            mapLinkedHashMap.put( word, value == null ? 1 : value + 1);
        }

        System.out.println(mapLinkedHashMap.size() + " palabras distintas: " );
        System.out.println(mapLinkedHashMap);

        System.out.println("========= TreeMap ======== alphabetical ordered");
        System.out.println("Map<String,Integer> mapTreeMap2 = new TreeMap<>( mapHashMap);");
        Map<String,Integer> mapTreeMap2 = new TreeMap<>( mapHashMap);
        System.out.println(mapTreeMap2);

        System.out.println("========= LinkedHashMap ========");
        System.out.println("Map<String,Integer> mapLinkedHashMap2 = new LinkedHashMap<>( mapHashMap);");
        Map<String,Integer> mapLinkedHashMap2 = new LinkedHashMap<>( mapHashMap);
        System.out.println(mapLinkedHashMap2 );


    }
}
