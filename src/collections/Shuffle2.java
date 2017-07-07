package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Bext on 06/02/2017.
 */
public class Shuffle2 {
    static public void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: Shuffle2 word word ...");
            System.exit(1);
        }

        List<String> list = Arrays.asList( args);
        Collections.shuffle(list, new Random());
        System.out.println(list);
    }
}
