import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class Bagel extends JFrame{
    JPanel pgreeting, pbagel, ptopping, pcoffee, pbutton;
    JButton calc, exit;
    JRadioButton white, wheat, regular, decaf, cap;
    JCheckBox creamcheese, butter, jelly, blueberry;
    ButtonGroup gbagel, gcoffee;
    JLabel lgreeting, lbagel, ltopping, lcoffee;
    public Bagel(){
        pgreeting = new JPanel();
        lgreeting = new JLabel("Welcome to Betty's Bagel House");
        pgreeting.add(lgreeting);
        
        pbagel = new JPanel();
        pbagel.setLayout(new GridLayout(5, 0));
        lbagel = new JLabel("Choose a Bagel");
        gbagel = new ButtonGroup();
        white = new JRadioButton("White");
        wheat = new JRadioButton("Whole Wheat");
        gbagel.add(white);
        gbagel.add(wheat);
        pbagel.add(lbagel);
        pbagel.add(white);
        pbagel.add(wheat);
        
        ptopping = new JPanel();
        ptopping.setLayout(new GridLayout(5, 0));
        ltopping = new JLabel("Choose your Toppings");
        creamcheese = new JCheckBox("Cream Cheese");
        butter = new JCheckBox("Butter");
        jelly = new JCheckBox("Peach Jelly");
        blueberry = new JCheckBox("Blueberry Jam");
        ptopping.add(ltopping);
        ptopping.add(creamcheese);
        ptopping.add(butter);
        ptopping.add(jelly);
        ptopping.add(blueberry);
        
        pcoffee = new JPanel();
        pcoffee.setLayout(new GridLayout(5, 0));
        lcoffee = new JLabel("  Pick your Coffee");
        gcoffee = new ButtonGroup();
        regular = new JRadioButton("Regular");
        decaf = new JRadioButton("Decaf");
        cap = new JRadioButton("Cappuccino");
        gcoffee.add(regular);
        gcoffee.add(decaf);
        gcoffee.add(cap);
        pcoffee.add(lcoffee);
        pcoffee.add(regular);
        pcoffee.add(decaf);
        pcoffee.add(cap);
        
        pbutton = new JPanel();
        calc = new JButton("Calculate");
        exit = new JButton("Exit");
        calc.addActionListener(new buttonListener());
        exit.addActionListener(new buttonListener());
        pbutton.add(calc);
        pbutton.add(exit);
        
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pgreeting, BorderLayout.NORTH);
        add(pbagel, BorderLayout.WEST);
        add(ptopping, BorderLayout.CENTER);
        add(pcoffee, BorderLayout.EAST);
        add(pbutton, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
    
    public class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            DecimalFormat df = new DecimalFormat("#.##");
            double sub = 0;
            double sum = 0;
            double tax = 0;
            if(e.getSource() == exit){
                System.exit(0);
            }
            if(e.getSource() == calc){
                if(white.isSelected()){
                    sub += 1.25;
                }
                if(wheat.isSelected()){
                    sub += 1.50;
                }
                if(creamcheese.isSelected()){
                    sub += .50;
                }
                if(butter.isSelected()){
                    sub += .25;
                }
                if(jelly.isSelected()){
                    sub += .75;
                }
                if(blueberry.isSelected()){
                    sub += .75;
                }
                if(regular.isSelected()){
                    sub += 1.25;
                }
                if(decaf.isSelected()){
                    sub += 1.25;
                }
                if(cap.isSelected()){
                    sub += 2.00;
                }
                tax = sub * .06;
                sum = sub + tax;
                
                JOptionPane.showMessageDialog(null, "Subtotal: $" +
                        String.valueOf(df.format(sub)) + "\nSales Tax: $" + String.valueOf(df.format(tax)) +
                        "\nTotal: $" + String.valueOf(df.format(sum)));
            }
        }
    }
    
    public static void main(String[] args){
        new Bagel();
    }
}
