/**
 * Written by Melissa Ozcan in 06/2020
 */

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class FlashCardsRunner {
    private JPanel contentPane;
    private MyPanel panel1;
    private MyPanel2 panel2;
    private MyPanel3 panel3;
    
    private void displayGUI() {
        JFrame frame = new JFrame("Console.Card Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        panel1 = new MyPanel(contentPane);
        panel2 = new MyPanel2(contentPane);
        panel3 = new MyPanel3(contentPane);
        contentPane.add(panel1, "Panel 1");
        contentPane.add(panel2, "Panel 2");
        contentPane.add(panel3, "Panel 3");
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
class MyPanel extends JPanel
{
    private JButton jcomp4;
    private JPanel contentPane;
    private JComboBox cardNum;
    private int numOfCards;
    private JLabel lbl;
    
    public MyPanel(JPanel panel)
    {
        contentPane = panel;
        setOpaque(true);
        setBackground(Color.PINK);
        
        
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
        
        numOfCards = Integer.parseInt((String)Objects.requireNonNull(cardNum.getSelectedItem()));
        
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
        return numOfCards;
    }
}


//inputting card info
class MyPanel2 extends JPanel {
    
    private JButton jcomp1;
    private JPanel contentPane;
    
    public MyPanel2(JPanel panel)
    {
        contentPane = panel;
        
        setOpaque(true);
        setBackground(Color.ORANGE);
        
        for (int i = 0; i < 5; i++) {
            
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
class MyPanel3 extends JPanel
{
    
    private JButton jcomp1;
    private JPanel contentPane;
    
    public MyPanel3(JPanel panel)
    {
        contentPane = panel;
        
        setOpaque(true);
        setBackground(Color.YELLOW);
        
        //construct components
        jcomp1 = new JButton ("Next Console.Card");
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