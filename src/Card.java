import java.util.Scanner;

public class Card {
    
    private String word;
    private String def;
    
    public Card() {
        word = null;
        def = null;
    }
    
    public Card(String w, String d) {
        word = w;
        def = d;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of cards as an integer value.");
        int length = in.nextInt();
    }
}
