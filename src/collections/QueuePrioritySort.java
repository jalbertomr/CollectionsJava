package collections;

import java.util.*;

/**
 * Created by Bext on 09/02/2017.
 */
public class QueuePrioritySort {

    static <E> List<E> heapSort(Collection<E> c) {
        Queue<E> queue = new PriorityQueue<E>(c);
        List<E> list = new ArrayList<E>();

        while( !queue.isEmpty()) {
            list.add(queue.remove());
            System.out.println("list  :" + list);
            System.out.println("queue :" + queue);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> listResult = new ArrayList<Integer>();

        for( int i = 0; i < 15; i++)
            list.add(i);

        Collections.shuffle(list);

        System.out.println("list :" + list);

        listResult = heapSort(list);

        System.out.println("listResult :" + listResult);

    }
}
