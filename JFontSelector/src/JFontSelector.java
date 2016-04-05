import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class JFontSelector extends JFrame{
    int fontsize = 12;
    Font helvetica, timesroman, courier, algerian, arial;
    JButton b1, b2, b3, b4, b5, big, small;
    JLabel tf1;
    public JFontSelector(){
        setLayout(null);
        setTitle("Font Selector");
        helvetica = new Font("Helvetica", Font.PLAIN, fontsize);
        timesroman = new Font("Times New Roman", Font.PLAIN, fontsize);
        courier = new Font("Courier New", Font.PLAIN, fontsize);
        algerian = new Font("Algerian", Font.PLAIN, fontsize);
        arial = new Font("Arial Black", Font.PLAIN, fontsize);
        b1 = new JButton("Helvetica");
        b1.setSize(125,25);
        b1.setLocation(25,25);
        b2 = new JButton("Times Roman");
        b2.setSize(125,25);
        b2.setLocation(25,60);
        b3 = new JButton("Courier");
        b3.setSize(125,25);
        b3.setLocation(25,95);
        b4 = new JButton("Algerian");
        b4.setSize(125,25);
        b4.setLocation(25,130);
        b5 = new JButton("Arial");
        b5.setSize(125,25);
        b5.setLocation(25,165);
        big = new JButton("Bigger");
        big.setSize(125,25);
        big.setLocation(25,200);
        small = new JButton("Smaller");
        small.setSize(125,25);
        small.setLocation(25,235);
        tf1 = new JLabel("FONT");
        tf1.setSize(200, 150);
        tf1.setLocation(175, 25);
        b1.addActionListener(new buttonListener());
        b2.addActionListener(new buttonListener());
        b3.addActionListener(new buttonListener());
        b4.addActionListener(new buttonListener());
        b5.addActionListener(new buttonListener());
        big.addActionListener(new buttonListener());
        small.addActionListener(new buttonListener());
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(big);
        add(small);
        add(tf1);
        setSize(410, 325);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int counter = 12;
            Font temp;
            if(e.getSource() == b1){
                tf1.setFont(helvetica);
                temp = new Font(tf1.getFont().getName(), Font.PLAIN, fontsize);
                tf1.setFont(temp);
                repaint();
            }
            if(e.getSource() == b2){
                tf1.setFont(timesroman);
                temp = new Font(tf1.getFont().getName(), Font.PLAIN, fontsize);
                tf1.setFont(temp);
                repaint();
            }
            if(e.getSource() == b3){
                tf1.setFont(courier);
                temp = new Font(tf1.getFont().getName(), Font.PLAIN, fontsize);
                tf1.setFont(temp);
                repaint();
            }
            if(e.getSource() == b4){
                tf1.setFont(algerian);
                temp = new Font(tf1.getFont().getName(), Font.PLAIN, fontsize);
                tf1.setFont(temp);
                repaint();
            }
            if(e.getSource() == b5){
                tf1.setFont(arial);
                temp = new Font(tf1.getFont().getName(), Font.PLAIN, fontsize);
                tf1.setFont(temp);
                repaint();
            }
            if(e.getSource() == big){
                fontsize+=2;
                temp = new Font(tf1.getFont().getName(), Font.PLAIN, fontsize);
                tf1.setFont(temp);
                repaint();
            }
            if(e.getSource() == small){
                fontsize-=2;
                temp = new Font(tf1.getFont().getName(), Font.PLAIN, fontsize);
                tf1.setFont(temp);
                repaint();
            }
        }
    }
    public static void main(String[] args){
        new JFontSelector();
    }
}
