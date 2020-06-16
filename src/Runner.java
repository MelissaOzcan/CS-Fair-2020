/**
* THIS IS AN OLD VERSION OF THE PROGRAM
* NO LONGER IN USE
**/

import org.w3c.dom.ls.LSOutput;

import javax.print.attribute.IntegerSyntax;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner extends Frame implements ActionListener {
    
    private static final Scanner IN = new Scanner(System.in);
    private static final int MAX = 50;
    private static final JFrame frame = new JFrame();
    
    public void actionPerformed(ActionEvent event) {
    
    }
    
    /**
     * Sets up the GUI.
     */
    public Runner() {
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //make sure the program exits when the frame closes
        frame.setTitle("Flash Cards");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); ////https://alvinalexander.com/blog/post/jfc-swing/how-set-jframe-size-fill-entire-screen-maximize/
        frame.setSize(screenSize.width / 2, screenSize.height / 2);
        frame.setLocationRelativeTo(null); //This will center the JFrame in the middle of the screen
        frame.setVisible(true);
    }
    
    static String s;
    static int len;
    
    /**
     * Takes user input to make cards.
     * @return the deck of cards.
     */
    private static ArrayList<Card> deck() {
        JPanel panelNumOfCards = new JPanel(new BorderLayout());
        
        Label label = new Label("Enter the number of cards as an integer value.");
        panelNumOfCards.add(label, BorderLayout.NORTH);
        
        JTextField input = new JTextField(); //this is where the user inputs the number
        panelNumOfCards.add(input);
    
        //https://stackoverflow.com/questions/4419667/detect-enter-press-in-jtextfield
        input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    s = input.getText();
                    try {
                        len = Integer.parseInt(s);
                    } catch (NumberFormatException ex) {
                        frame.dispose();
                        System.out.println("You gave an invalid input, so the program exited.");
                    }
                }
            }
        });
        frame.setVisible(true);
        
        
              
        
        
        
        /*
        JButton enterButton = new JButton("submit");
        enterButton.addActionListener(e -> {
            s = input.getText();
        });
        panelNumOfCards.add(enterButton, BorderLayout.SOUTH);
    */
        
        
        /////
        
        
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
