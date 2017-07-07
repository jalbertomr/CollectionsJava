package collections;

import java.util.HashSet;
import java.util.Set;

import static collections.DemoUtils.showln;

/**
 * Created by Bext on 06/02/2017.
 */
public class FindDups2 {
    static public void main(String[] args){
        if (args.length == 0) {
            showln("Uso: FindDups2 word word ...");
            System.exit(1);
        }
        Set<String> unico = new HashSet<>();
        Set<String> dups = new HashSet<>();
        for ( String word : args) {
            if (!unico.add(word))
                dups.add(word);
        }
        showln("unicos: " + unico);
        showln("dups: " + dups);
    }
}
