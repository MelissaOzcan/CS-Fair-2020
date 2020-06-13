import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner extends Frame {
    
    private static final Scanner IN = new Scanner(System.in);
    private static final int MAX = 50;
    
    /**
     * sets up the GUI
     */
    public Runner() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //make sure the program exits when the frame closes
        frame.setTitle("Flash Cards");
        
        //https://alvinalexander.com/blog/post/jfc-swing/how-set-jframe-size-fill-entire-screen-maximize/
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width / 2, screenSize.height / 2);
        
        frame.setLocationRelativeTo(null); //This will center the JFrame in the middle of the screen
    
        JPanel p = new JPanel(new BorderLayout()); //https://examples.javacodegeeks.com/java-swing-layouts-example/
    
        frame.setVisible(true);
    }
    
    /**
     * takes user input to make cards
     *
     * @return the deck of cards
     */
    private static ArrayList<Card> deck() {
        System.out.println("Enter the number of cards as an integer value.");
        int length = IN.nextInt();
        
        while (length > MAX) {
            System.out.println("The max amount of cards is 50. Try a smaller value");
            length = IN.nextInt();
        }
    
        ArrayList<Card> cards = new ArrayList<>();
    
        System.out.printf("Enter %d card values: " +
                "first the word, then the definition, separated by a colon. " +
                "Hit enter for a new card.", length);
    
        for (int i = 0; i < length; i++) {
            cards.add(new Card(IN.next()));
        }
        
        return cards;
    }
    
    public static void main(String[] args) {
        new Runner();
        ArrayList<Card> deck = deck();
    
        System.out.println("You will now begin the study session. " +
                "At any time, type 'quit' to quit.\n");
        
        String input = "";
        int i = 0;
        
        try {
            while (!(input.equals("quit"))) { //TODO: while true?
                System.out.println(deck.get(i).getWord());
                input = IN.next();
                
                if (input.equals(deck.get(i).getDef())) {
                    System.out.println("\nCorrect.\n");
                    i++;
                } else if (input.equals("quit")) {
                    break;
                } else {
                    for (int num = 0; num < 2; num++) {
                        System.out.println("\nIncorrect. Try again.\n");
                        input = IN.next();
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
