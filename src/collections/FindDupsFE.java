package collections;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Bext on 06/02/2017.
 */
public class FindDupsFE {
    static public void main(String args[]) {
        if (args.length == 0){
            System.out.println("Uso: FindDupsAO word word ...");
            System.exit(1);
        }

        Set<String> setHashSet = new HashSet<String>();
        Set<String> setTreeSet = new TreeSet<String>();
        Set<String> setLinkedHashSet = new LinkedHashSet<>();
        for ( String word : args) {
            setHashSet.add(word);
            setTreeSet.add(word);
            setLinkedHashSet.add(word);
        }
        System.out.println( setHashSet.size() + " palabras distintas HashSet" + setHashSet.toString());
        System.out.println( setTreeSet.size() + " palabras distintas TreeSet" + setTreeSet.toString());
        System.out.println( setLinkedHashSet.size() + " palabras distintas LinkedHashSet" + setLinkedHashSet.toString());
    }
}
