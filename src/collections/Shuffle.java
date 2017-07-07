package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Bext on 06/02/2017.
 */
public class Shuffle {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: Shuffle word word ...");
            System.exit(1);
        }

        List<String> list = new ArrayList<>();
        for ( String s : args)
            list.add(s);
        Collections.shuffle( list, new Random());
        System.out.println( list);
    }
}
