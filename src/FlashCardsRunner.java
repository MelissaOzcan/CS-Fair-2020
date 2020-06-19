package src;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

// Written by Melissa Ozcan in 6/2020

public class FlashCardsRunner {
    private JPanel contentPane;         // each page is its own class
    private MyPanel introPanel;         // asks for # of cards
    private MyPanel2 setUpCards;        // input card info
    private MyPanel3 beginLearning;     // card review
    private JFrame frame;
    
    private void displayGUI() {
        frame = new JFrame("Flash Cards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        introPanel = new MyPanel(contentPane);
        setUpCards = new MyPanel2(contentPane);
        beginLearning = new MyPanel3(contentPane);
        contentPane.add(introPanel, "Panel 1");
        contentPane.add(setUpCards, "Panel 2");
        contentPane.add(beginLearning, "Panel 3");
        
        Component[] components = contentPane.getComponents();
        contentPane.removeAll();
        
        Component temp = components[components.length - 2];
        components[components.length - 2] = components[1];
        components[1] = temp;
        
        temp = components[components.length - 3];
        components[components.length - 3] = components[0];
        components[0] = temp;
        
        
        for (int i = components.length - 1; i > 0; i--) {
            contentPane.add(components[i]);
        }
     
        contentPane.validate();
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new FlashCardsRunner().displayGUI();
            }
        });
    }
}


//asks for # of cards
class MyPanel extends JPanel {
    private JButton jcomp4;
    private JPanel contentPane;
    private JComboBox cardNum;
    private final int[] numOfCards = new int[1];
    private JLabel lbl;
    
    public MyPanel(JPanel panel) {
        contentPane = panel;
        setOpaque(true);
        setBackground(Color.PINK); //the colors serve no purpose, just easier to distinguish
        
        lbl = new JLabel("Select how many cards you would like to work with.");
        add(lbl);
        
        String[] numbers = {"5", "10", "15", "20"};
        cardNum = new JComboBox(numbers);
        cardNum.addActionListener(new ActionListener() {
            @Override       // nothing will appear on the panel unless it has an ActionListener
            public void actionPerformed(ActionEvent e) {
            
            }
        });
        add(cardNum);
        
        numOfCards[0] = Integer.parseInt((String)Objects.requireNonNull(cardNum.getSelectedItem()));
        
        jcomp4 = new JButton ("Next Page");
        jcomp4.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
            }
        });
        add(jcomp4);
    }
    
    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 500));
    }
    
    public int getNumOfCards() {
        return numOfCards[0];
    }
}


//inputting card info
class MyPanel2 extends JPanel {
    
    private int numOfCards = 1;     //ideally, this would be whatever value from the last panel
    private JButton jcomp1;
    private JPanel contentPane;

   
    public MyPanel2(JPanel panel) {
        contentPane = panel;
        
        setOpaque(true);
        setBackground(Color.ORANGE);
        
        MyPanel3[] deck = new MyPanel3[numOfCards];
        
        // the following lines are taken from displayGUI()
        for (int i = 0; i < numOfCards; i++) {
            deck[i] = new MyPanel3(contentPane);
            contentPane.add(deck[i], ("Card " + (i + 1)));
        }
        
        
        //construct components
        jcomp1 = new JButton ("Begin Learning");
        jcomp1.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
            }
        });
        
        add(jcomp1);
    }
    
    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 500));
    }
}


// where the actual cards start
class MyPanel3 extends JPanel {
    
    private JButton jcomp1;
    private JPanel contentPane;
    
    public MyPanel3(JPanel panel) {
        contentPane = panel;
        
        setOpaque(true);
        setBackground(Color.YELLOW);
        
        //construct components
        jcomp1 = new JButton ("Next");
        jcomp1.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
            }
        });
        
        add(jcomp1);
    }
    
    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 500));
    }
}