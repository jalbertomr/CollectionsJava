package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bext on 07/02/2017.
 */
public class ListDeal {
    static <E> List<E> dealHand(List<E> deck, int n ) {
        int deckSize = deck.size();
        System.out.println(deckSize);
        List<E> handView = deck.subList(deckSize - n, deckSize );
        List<E> hand = new ArrayList<E>(handView);
        handView.clear();
        return hand;
    }

    public static void main(String[] args) {
        if ( args.length != 2){
            System.out.println("Uso: ListDeal numeroDeManos cartasPorMano");
            System.exit(1);
        }

        int numManos = Integer.parseInt(args[0]);
        int cartasPorMano = Integer.parseInt(args[1]);

        String[] suit = new String[]{"♦","♣","♥","♠"};
        String[] rank = new String[]{"2","3", "4", "5" , "6", "7", "8", "9", "10", "☺", "♀", "♂", "A"};

        ArrayList<String> deck = new ArrayList<>();
        for (int i = 0; i < suit.length; i++){
            for (int j = 0; j < rank.length; j++){
                deck.add( suit[i] + rank[j]);
            }
        }

        System.out.println(deck);
        Collections.shuffle(deck);
        System.out.println(deck);

        if (numManos * cartasPorMano > deck.size()){
            System.out.println("No alcanzan las cartas");
            System.exit(1);
        }

        for( int i = 0; i < numManos; i++){
            System.out.println( dealHand( deck, cartasPorMano));
        }
    }
}
