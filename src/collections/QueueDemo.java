package collections;

import java.util.*;

/**
 * Created by Bext on 09/02/2017.
 *                  Throws Exception                          Return special value
 *   Insert         add(e)        IllegalStateException       offer(e)    failure insert return false
 *   Remove         remove()      NoSuchElementException      poll()      return null
 *   Examine        element()     NoSuchElementException      peek()      return null
 */
public class QueueDemo {


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();


        System.out.println("queue.add(0)  : " + queue.add(0));
        System.out.println("queue.offer(1): " + queue.offer(1));

        System.out.println(queue);

        try {
            System.out.print("queue.remove(): " + queue.remove()); System.out.println(queue);
            System.out.print("queue.remove(): " + queue.remove()); System.out.println(queue);
            System.out.print("queue.remove(): " + queue.remove()); System.out.println(queue);
        } catch( NoSuchElementException e) {
            System.err.println("queue.remove() y ya estaba vacio: " + e);
        }

        System.out.println("queue.add(0)  : " + queue.add(0));
        System.out.println("queue.offer(1): " + queue.offer(1));

        System.out.println(queue);

        System.out.print("queue.poll(): " + queue.poll()); System.out.println(queue);
        System.out.print("queue.poll(): " + queue.poll()); System.out.println(queue);
        System.out.print("queue.poll(): " + queue.poll()); System.out.println(queue);

        System.out.print("queue.peek()   : " + queue.peek()); System.out.println(queue);
        try {
            System.out.print("queue.element(): " + queue.element()); System.out.println(queue);
        } catch (NoSuchElementException e){
            System.err.println("queue.element() y ya estaba vacio: " + e);
        }

        for ( int i = 1; i <= 15; i++) {
            System.out.print("queue.offer(" + i + ")  : " + queue.add(i));
            System.out.println(queue);
        }

        System.out.print("queue.peek(): " + queue.peek()); System.out.println(" " + queue);
        System.out.print("queue.poll() : " + queue.poll()); System.out.println(" " + queue);
        System.out.print("queue.poll() : " + queue.poll()); System.out.println(" " + queue);
        System.out.print("queue.peek(): " + queue.peek()); System.out.println(" " + queue);
        System.out.print("queue.peek(): " + queue.peek()); System.out.println(" " + queue);
        System.out.print("queue.peek(): " + queue.peek()); System.out.println(" " + queue);
        System.out.print("queue.peek(): " + queue.peek()); System.out.println(" " + queue);
        System.out.print("queue.poll() : " + queue.poll()); System.out.println(" " + queue);
        System.out.print("queue.poll() : " + queue.poll()); System.out.println(" " + queue);
        System.out.print("queue.poll() : " + queue.poll()); System.out.println(" " + queue);
        System.out.print("queue.poll() : " + queue.poll()); System.out.println(" " + queue);
        System.out.print("queue.poll() : " + queue.poll()); System.out.println(" " + queue);
        System.out.print("queue.peek(): " + queue.peek()); System.out.println(" " + queue);
        System.out.print("queue.poll() : " + queue.poll()); System.out.println(" " + queue);

        // operaciones que tiran exceptions
        for ( int i = 1; i <= 15; i++) {
            System.out.print("queue.add(" + i + ")  : " + queue.add(i));
            System.out.println(queue);
        }

        System.out.print("queue.element(): " + queue.element()); System.out.println(" " + queue);
        System.out.print("queue.remove() : " + queue.remove()); System.out.println(" " + queue);
        System.out.print("queue.remove() : " + queue.remove()); System.out.println(" " + queue);
        System.out.print("queue.element(): " + queue.element()); System.out.println(" " + queue);
        System.out.print("queue.element(): " + queue.element()); System.out.println(" " + queue);
        System.out.print("queue.element(): " + queue.element()); System.out.println(" " + queue);
        System.out.print("queue.element(): " + queue.element()); System.out.println(" " + queue);
        System.out.print("queue.remove() : " + queue.remove()); System.out.println(" " + queue);
        System.out.print("queue.remove() : " + queue.remove()); System.out.println(" " + queue);
        System.out.print("queue.remove() : " + queue.remove()); System.out.println(" " + queue);
        System.out.print("queue.remove() : " + queue.remove()); System.out.println(" " + queue);
        System.out.print("queue.remove() : " + queue.remove()); System.out.println(" " + queue);
        System.out.print("queue.element(): " + queue.element()); System.out.println(" " + queue);
        System.out.print("queue.remove() : " + queue.remove()); System.out.println(" " + queue);

    }
}
