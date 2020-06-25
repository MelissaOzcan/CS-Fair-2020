package src.Console;

// Made by Melissa Ozcan
// Last worked: 6/24/20

public class Card {
    
    private String word;
    private String def;
    
    public Card() {
        word = null;
        def = null;
    }
    
    //for testing
    public Card(String w, String d) {
        word = w;
        def = d;
    }
    
    // this is useful for initialization
    public Card(String s) {
        String[] values = s.split(":");
        word = values[0];
        def = values[1];
    }
    
    public String getWord() {
        return word;
    }
    
    public String getDef() {
        return def;
    }
}
