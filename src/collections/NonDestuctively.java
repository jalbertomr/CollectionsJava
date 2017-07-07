package collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static collections.DemoUtils.showln;

/**
 * Created by Bext on 06/02/2017.
 */
public class NonDestuctively {
    public static void main(String[] args){
        Set<Integer> setBajos = new HashSet<>(Arrays.asList( new Integer[]{1,2,3,4} ));
        Set<Integer> setMedios = new HashSet<>(Arrays.asList( new Integer[]{4,5,6}));
        Set<Integer> setAltos = new HashSet<>(Arrays.asList( new Integer[]{6,7,8,9}));

        showln("======== Union =======");
        showln("bajos: " + setBajos);
        showln("medios: " +  setMedios);
        Set<Integer> setUnion = new HashSet<>();
        showln("setUnion:" + setUnion);
        showln("setUnion.addAll(setMedios);");
        setUnion.addAll(setBajos);
        setUnion.addAll(setMedios);
        showln("setUnion:" + setUnion);

        showln("======== Intersection =======");
        showln("bajos: " + setBajos);
        showln("medios: " +  setMedios);
        Set<Integer> setIntersection = new HashSet<>();
        showln("setIntersection: " + setIntersection);
        showln("setIntersection.retainAll(setMedios);");
        setIntersection.addAll(setBajos);
        setIntersection.retainAll(setMedios);
        showln("setIntersection: " + setIntersection);

        showln("======== Difference ========");
        showln("bajos: " + setBajos);
        showln("medios: " +  setMedios);
        Set<Integer> setDifference = new HashSet<>(setBajos);
        showln("setDifference: " + setDifference);
        showln("setDifference.retainAll(setMedios);");
        setDifference.removeAll(setMedios);
        showln("setDifference: " + setDifference);

    }
}
