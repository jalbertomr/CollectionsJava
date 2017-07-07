package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bext on 10/02/2017.
 */
public class NameSort {
    public static void main(String[] args) {
        Name nameArray[] = {new Name("John", "Smith"),
                new Name("Karl", "Ng"),
                new Name("Jeff", "Smith"),
                new Name("Tom", "Rich"),
                new Name("Zin", "Abert")
        };

        List<Name> names = Arrays.asList(nameArray);
        Collections.sort(names);
        System.out.println(names);
    }
}
