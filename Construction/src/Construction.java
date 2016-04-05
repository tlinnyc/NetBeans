import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Construction extends JFrame{
    ButtonGroup bg1, bg2, bg3;
    JButton b1;
    JLabel l1, l2, l3, l4;
    JRadioButton model1, model2, model3, model4, bed2, bed3, bed4, g0, g1, g2, g3;
    JFrame frame;
    JTextField tf1;
    JPanel p1, p2, p3, p4;
    public Construction(){
        frame = new JFrame();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        bg1 = new ButtonGroup();
        bg2 = new ButtonGroup();
        bg3 = new ButtonGroup();
        l1 = new JLabel("Select a model:");
        model1 = new JRadioButton("Aspen $100,000");
        model2 = new JRadioButton("Brittany $120,000");
        model3 = new JRadioButton("Colonial $180,000");
        model4 = new JRadioButton("Dartmoor $250,000");
        bg1.add(model1);
        bg1.add(model2);
        bg1.add(model3);
        bg1.add(model4);
        p1.add(l1);
        p1.add(model1);
        p1.add(model2);
        p1.add(model3);
        p1.add(model4);
        l2 = new JLabel("Select number of bedrooms:");
        bed2 = new JRadioButton("Two $21,000");
        bed3 = new JRadioButton("Three $31,500");
        bed4 = new JRadioButton("Four $42,000");
        bg2.add(bed2);
        bg2.add(bed3);
        bg2.add(bed4);
        p2.add(l2);
        p2.add(bed2);
        p2.add(bed3);
        p2.add(bed4);
        l3 = new JLabel("Select garage size:");
        g0 = new JRadioButton("Zero-car $0");
        g1 = new JRadioButton("One-car $7,775");
        g2 = new JRadioButton("Two-car $15,550");
        g3 = new JRadioButton("Three-car $23,325");
        bg3.add(g0);
        bg3.add(g1);
        bg3.add(g2);
        bg3.add(g3);
        p3.add(l3);
        p3.add(g0);
        p3.add(g1);
        p3.add(g2);
        p3.add(g3);
        tf1 = new JTextField(10);
        tf1.setEditable(false);
        b1 = new JButton("Calculate");
        b1.addActionListener(new buttonListener());
        l4 = new JLabel("Total Cost: ");
        p4.add(l4);
        p4.add(tf1);
        p4.add(b1);
        
        frame.setTitle("New Home");
        frame.setLayout(new GridLayout(4, 1));
        frame.setSize(750, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        frame.pack();
        frame.setVisible(true);
    }
    public class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double sum;
            sum = 0;
            if(model1.isSelected() == true){
                sum += 100000;
            }else if(model2.isSelected() == true){
                sum += 120000;
            }else if(model3.isSelected() == true){
                sum += 180000;
            }else if(model4.isSelected() == true){
                sum += 250000;
            }
            if(bed2.isSelected() == true){
                sum += 21000;
            }else if(bed3.isSelected() == true){
                sum += 31500;
            }else if(bed4.isSelected() == true){
                sum += 42000;
            }
            if(g0.isSelected() == true){
                sum += 0;
            }else if(g1.isSelected() == true){
                sum += 7775;
            }else if(g2.isSelected() == true){
                sum += 15550;
            }else if(g3.isSelected() == true){
                sum += 23325;
            }
            tf1.setText("$" + String.valueOf(sum));
        }
    }
    public static void main(String[] args){
        new Construction();
    }
}
