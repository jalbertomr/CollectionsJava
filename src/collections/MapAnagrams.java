package collections;

import java.io.*;
import java.util.*;

import static collections.DemoUtils.esperaTecladoEnter;

/**
 * Created by Bext on 08/02/2017.
 */
public class MapAnagrams {

    public static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    static public void main(String[] args) {
        int minGroupSize = Integer.parseInt(args[1]);
        System.out.println(args.length);
        if (args.length == 0){
            System.out.println("Uso: MapAnagrams filename length of words");
            System.exit(1);
        }

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        try {
            Scanner s = new Scanner(new File(args[0]));
            while (s.hasNext()) {
                String word = s.next();
                String alpha = alphabetize(word);
                System.out.print(word + " " + alpha + " |");
                List<String> list = map.get(alpha);
                if (list == null)
                    map.put(alpha, list = new ArrayList<String>());
                list.add(word);
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }

        esperaTecladoEnter();

        //imprime todos los grupos de permutaciones arriba del umbral
        for (List<String> list : map.values()) {
            if (list.size() >= minGroupSize)
                System.out.println(list.size() + ": " + list);
        }
    }
}

