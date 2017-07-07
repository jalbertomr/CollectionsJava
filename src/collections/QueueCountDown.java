package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Bext on 09/02/2017.
 */
public class QueueCountDown {
    public static void main(String[] args) throws InterruptedException {
        int cuenta;
        if (args.length == 0) { cuenta = 5;} else {
          cuenta = Integer.parseInt(args[0]);}

        Queue<Integer> queue = new LinkedList<Integer>();  //Error new ArrayList<Integer>();
        for ( int i = 0; i < cuenta; i++)
            queue.add(i);

        while( !queue.isEmpty()){
            System.out.print(queue.remove() + " ");
            Thread.sleep(500);
        }
    }
}
