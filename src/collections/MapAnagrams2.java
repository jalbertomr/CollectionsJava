package collections;

import java.io.*;
import java.util.*;

import static collections.DemoUtils.esperaTecladoEnter;

/**
 * Created by Bext on 09/02/2017.
 */
public class MapAnagrams2 {

    static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    public static void main(String[] args) {
        //Uso: MapAnagram2 dictionary.txt 2
        int minGroupSize =  Integer.parseInt(args[1]);

        Map<String,List<String>> map = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File( args[0]));
            while(scanner.hasNext()){
                String word = scanner.next();
                String alpha = alphabetize( word);  //System.out.print(word + " " + alpha + " |");
                List<String> list = map.get(alpha);
                if (list == null )
                    map.put( alpha, list = new ArrayList<String>());
                list.add(word);

            }
        }catch (IOException e){
            System.err.println(e);
            System.exit(1);
        }

        //esperaTecladoEnter();

        //Has una lista de listas de grupos de permutaciones arriba de umbral de palabras
        List<List<String>> listListPermuta = new ArrayList<List<String>>();
        for ( List<String> list: map.values()) {
            if ( list.size() >= minGroupSize )
              listListPermuta.add(list);
        }

        System.out.println(listListPermuta);

        Collections.sort(listListPermuta, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.size() - o2.size();
            }
        });

        for(List<String> list : listListPermuta) {
            System.out.println(list.size() + ": " + list);
        }

    }
}
