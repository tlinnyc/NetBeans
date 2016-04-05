package joesautomotive;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JoeGUI extends JFrame{
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JLabel l1, l2, l3;
    JTextField tf1, tf2;
    JButton b1;
    JPanel p1, p2, p3;
    public JoeGUI(){
        setTitle("Joe's Automotive");
        setSize(999, 999);
        setLayout(new GridLayout(3, 1));
        l1 = new JLabel("Select routine maintenance services:");
        c1 = new JCheckBox("Oil Change ($26)");
        c2 = new JCheckBox("Lube Job ($18)");
        c3 = new JCheckBox("Radiator Flush ($30)");
        c4 = new JCheckBox("Transmission Flush ($80)");
        c5 = new JCheckBox("Inspection ($15)");
        c6 = new JCheckBox("Muffler Replacement ($100)");
        c7 = new JCheckBox("Tire Rotation ($20)");
        l2 = new JLabel("Enter hours of non-routine services ($20/hr):");
        tf1 = new JTextField(5);
        tf1.setText("0");
        l3 = new JLabel("Total Cost:");
        tf2 = new JTextField(10);
        tf2.setEditable(false);
        b1 = new JButton("Calculate");
        b1.addActionListener(new listener());
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p1.setLayout(new GridLayout(7, 1));
        p1.add(l1);
        p1.add(c1);
        p1.add(new JPanel());
        p1.add(c2);
        p1.add(new JPanel());
        p1.add(c3);
        p1.add(new JPanel());
        p1.add(c4);
        p1.add(new JPanel());
        p1.add(c5);
        p1.add(new JPanel());
        p1.add(c6);
        p1.add(new JPanel());
        p1.add(c7);
        p2.add(l2);
        p2.add(tf1);
        p3.add(l3);
        p3.add(tf2);
        p3.add(b1);
        add(p1);
        add(p2);
        add(p3);
        System.out.println(p1.getSize() + " " + p2.getSize() + " " + p3.getSize());
        System.out.println(p1.getLocation() + " " + p2.getLocation() + " " + p3.getLocation());
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public class listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            double sum, hours;
            sum = 0;
            if(c1.isSelected() == true){
                sum += 26;
            }
            if(c2.isSelected() == true){
                sum += 18;
            }
            if(c3.isSelected() == true){
                sum += 30;
            }
            if(c4.isSelected() == true){
                sum += 80;
            }
            if(c5.isSelected() == true){
                sum += 15;
            }
            if(c6.isSelected() == true){
                sum += 100;
            }
            if(c7.isSelected() == true){
                sum += 20;
            }
            if(Double.parseDouble(tf1.getText()) != 0){
                hours = Double.parseDouble(tf1.getText());
                hours *= 20;
                sum += hours;
            }
            tf2.setText("$" + String.valueOf(sum));
        }
    }
    public static void main(String[] args){
        new JoeGUI();
    }
}
