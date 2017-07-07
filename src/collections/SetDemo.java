package collections;

import java.util.*;
import java.util.stream.Collectors;

import static collections.DemoUtils.show;
import static collections.DemoUtils.showln;
import static collections.Person.createRoster;

/**
 * Created by Bext on 03/02/2017.
 */
public class SetDemo {
    public static void main(String[] args){

        String[] arrDiasRep = {"lunes","martes","miercoles","jueves","viernes","sabado","domingo","lunes"};

        Collection<String> cDiasRep = Arrays.asList(arrDiasRep);

        show("List cDiasRep: "); cDiasRep.stream().forEach(e -> show( e + " ")); showln();
        Collection<String> cDiasNoRep = new HashSet<>(cDiasRep);
        show("HashSet cDiasNoRep:"); cDiasNoRep.stream().forEach(e -> show(e + " ")); showln();
        Collection<String> cDiasNoRepLinkedHashSet = new LinkedHashSet<>(cDiasRep);
        show("LinkedHashSet:"); cDiasNoRepLinkedHashSet.stream().forEach(e -> show(e + " ")); showln();
        show("cDiasRep.stream().collect(Collectors.toSet()).forEach(e -> show( e + \" \")): ");
        cDiasRep.stream().collect(Collectors.toSet()).forEach( e -> show(e + " ")); showln();
        show("List cDiasRep remains ummutable: "); cDiasRep.stream().forEach(e -> show( e + " ")); showln();

        //Person
        List<Person> person = createRoster();
        Set<String> setPerson = person.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));
        setPerson.stream().forEach(e -> show(e + " ")); showln();

        Collection<String> cDiasNoRep2 = removeDups( cDiasRep);
        show("method removeDups cDiasNoRep2: "); cDiasNoRep2.stream().forEach(e -> show(e + " ")); showln();
    }

    public static <E> Set<E> removeDups( Collection<E> c) {
        return new LinkedHashSet<E>(c);
    }
}
