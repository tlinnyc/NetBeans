import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class Calculator extends JFrame{
    JRadioButton b1, b2, b3, b4, b5, b6, b7;
    JLabel l1, l2, l3;
    ButtonGroup bg1, bg2;
    JButton butt1;
    JPanel p1, p2, p3;
    JTextField tf1;
    JComboBox cb1, cb2;
    String[] dorm = {"Allen Hall", "Pike Hall", "Farthing Hall", "University Suites"};
    String[] meal = {"7 meals per week", "14 meals per week", "Unlimited Meals"};
    public Calculator(){
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        l1 = new JLabel("Select your dorm:");
        cb1 = new JComboBox(dorm);
        p1.add(l1);
        p1.add(cb1);
        l2 = new JLabel("Select a meal plan");
        cb2 = new JComboBox(meal);
        p2.add(l2);
        p2.add(cb2);
        l3 = new JLabel("Total Cost:");
        tf1 = new JTextField(20);
        tf1.setEditable(false);
        butt1 = new JButton("Calculate");
        butt1.addActionListener(new buttonListener());
        p3.add(l3);
        p3.add(tf1);
        p3.add(butt1);
        
        setTitle("Dorm and Meal Plan Calculator");
        setSize(500,500);
        setLayout(new GridLayout(3,1));
        add(p1);
        add(p2);
        add(p3);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            double sum = 0;
            DecimalFormat df = new DecimalFormat("#,###.##");
            if(cb1.getSelectedIndex() == 0){
                sum += 1500;
            }
            if(cb1.getSelectedIndex() == 1){
                sum += 1600;
            }
            if(cb1.getSelectedIndex() == 2){
                sum += 1200;
            }
            if(cb1.getSelectedIndex() == 3){
                sum += 1800;
            }
            if(cb2.getSelectedIndex() == 0){
                sum += 560;
            }
            if(cb2.getSelectedIndex() == 1){
                sum += 1095;
            }
            if(cb2.getSelectedIndex() == 2){
                sum += 1500;
            }
            tf1.setText("$" + String.valueOf(df.format(sum)));
        }
    }
    public static void main(String[] args){
        new Calculator();
    }
}
