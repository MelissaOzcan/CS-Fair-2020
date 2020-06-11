public class CardTest {
    public static void main(String[] args) {
        /*
        String s = "Hi:Hello";
        String[] s2 = s.split(":");
        Arrays.stream(s2).forEach(System.out::println);
    
        System.out.println("\n\n\n\n\n");
        */
        Card c = new Card("word", "def");
        
        if ("word".equals(c.getWord()))
            System.out.println("Test 1: passed");
        else
            System.out.println("Test 1: failed");
        
        if ("def".equals(c.getDef()))
            System.out.println("Test 2: passed");
        else
            System.out.println("Test 2: failed");
    
    
        Card c2 = new Card("word:def");
    
        if ("word".equals(c2.getWord()))
            System.out.println("Test 3: passed");
        else
            System.out.println("Test 3: failed");
    
        if ("def".equals(c2.getDef()))
            System.out.println("Test 4: passed");
        else
            System.out.println("Test 4: failed");
    }
    
}
