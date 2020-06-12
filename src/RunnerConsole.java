/**
 * Created by Melissa Ozcan on 6/11/20
 * This version of the program prints out to the console,
 * instead of using a GUI.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class RunnerConsole{
    
    private static Scanner in = new Scanner(System.in);
    private static final int MAX = 50;
    
    
    private static ArrayList<Card> deck() {
        System.out.println("Enter the number of cards as an integer value.");
        int length = in.nextInt();
        
        while (length > MAX) {
            System.out.println("The max amount of cards is 50. Try a smaller value");
            length = in.nextInt();
        }
        
        ArrayList<Card> cards = new ArrayList<>();
        
        System.out.printf("Enter %d card values: " +
                "first the word, then the definition, separated by a colon. " +
                "Hit enter for a new card.", length);
        
        for (int i = 0; i < length; i++) {
            cards.add(new Card(in.next()));
        }
        
        return cards;
    }
    
    public static void main(String[] args) {
        ArrayList<Card> deck = deck();
        
        System.out.println("You will now begin the study session. " +
                "At any time, type 'quit' to quit." +
                "To see the right answer, type in 'right answer'\n");
        
        String input = "";
        int i = 0;
        
        try {
            while (!(input.equals("quit"))) { //TODO: while true?
                System.out.println(deck.get(i).getWord());
                input = in.next();
                
                if (input.equals(deck.get(i).getDef())) {
                    System.out.println("\nCorrect.\n");
                    i++;
                } else if (input.equals("right answer")) {
                    System.out.println(deck.get(i).getDef());
                    i++;
                }else if (input.equals("quit")) {
                    break;
                } else {
                    for (int num = 0; num < 2; num++) {
                        System.out.println("\nIncorrect. Try again.\n");
                        input = in.next();
                        if (input.equals(deck.get(i).getDef())) {
                            break;
                        }
                    }
                    System.out.println("The right answer is %s" + deck.get(i).getDef());
                    deck.add(deck.get(i++));
                }
            }
            System.out.println("You have completed the set.");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("You have completed the set.");
        }
    }
}
