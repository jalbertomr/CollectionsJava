package collections;

import java.util.*;
import java.util.stream.Collectors;

import static collections.DemoUtils.show;
import static collections.DemoUtils.showln;

/**
 * Created by Bext on 06/02/2017.
 */
public class FindDupsAO {
    static public void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: FindDupsAO word word ...");
            System.exit(1);
        }

        Set<String> setHashSet = new HashSet<>(Arrays.asList(args));
        Set<String> setTreeSet = new TreeSet<>(Arrays.asList(args));
        Set<String> setLinkedHashSet = new LinkedHashSet<>(Arrays.asList(args));
        showln("setHashSet.stream().collect(Collectors.toSet()));");
        showln(setHashSet.size() + " distintas palabras HashSet: " + setHashSet.stream().collect(Collectors.toSet()));
        showln(setTreeSet.size() + " distintas palabras TreeSet: " + setTreeSet.stream().collect(Collectors.toSet()));
        showln(setLinkedHashSet.size() + " distintas palabras LinkedHashSet: " + setLinkedHashSet.stream().collect(Collectors.toSet()));
        showln("set???Set.stream().forEach( e -> show( e + \" \"));");
        show("setHashSet ");setHashSet.stream().forEach( e -> show( e + " ")); showln();
        show("setTreeSet ");setTreeSet.stream().forEach( e -> show( e + " ")); showln();
        show("setLinkedHashSet ");setLinkedHashSet.stream().forEach( e -> show( e + " ")); showln();


    }
}
