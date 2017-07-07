package collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bext on 03/02/2017.
 */
public class DemoUtils {
    public static void show(String s){
        System.out.print(s);
    }

    static void showln() {
        System.out.println();
    }

    public static void showln(String s){
        System.out.print(s); System.out.println();
    }

    public static void esperaTecladoEnter() {
        try{
            int i;
            System.out.println("Esperando Enter...");
            while ( (i = new BufferedReader( new InputStreamReader( System.in )).read()) != 10 ) {}
        } catch(IOException e){
            System.err.print("error en esperaTecladoEnter");
            System.exit(1);
        }
    }
}
