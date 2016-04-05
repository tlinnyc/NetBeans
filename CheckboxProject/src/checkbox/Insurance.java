package checkbox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Insurance extends JFrame {
    JCheckBox c1, c2, c3, c4;
    JTextField tf1;
    JFrame frame;
    JPanel p1, p2, p3;
    JLabel l1, l2, l3;
    ButtonGroup bg1;
    public Insurance(){
        frame = new JFrame();
        l1 = new JLabel("Select Insurance Type:");
        l2 = new JLabel("Select Additional Options:");
        c1 = new JCheckBox("HMO");
        c2 = new JCheckBox("PPO");
        bg1 = new ButtonGroup();
        bg1.add(c1);
        bg1.add(c2);
        c3 = new JCheckBox("Dental Insurance");
        c4 = new JCheckBox("Vision Insurance");
        tf1 = new JTextField(20);
        tf1.setEditable(false);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        c1.addActionListener(new listener());
        c2.addActionListener(new listener());
        c3.addActionListener(new listener());
        c4.addActionListener(new listener());
        p1.add(l1);
        p1.add(c1);
        p1.add(c2);
        p2.add(l2);
        p2.add(c3);
        p2.add(c4);
        p3.add(tf1);
        
        frame.setTitle("Insurance");
        frame.setSize(500, 150);
        frame.setLayout(new GridLayout(5, 2));
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public class listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            double sum, hmo, ppo, dental, vision;
            sum = 0;
            hmo = 200;
            ppo = 600;
            dental = 75;
            vision = 20;
            if(c1.isSelected() == true){
                sum += hmo;
                tf1.setText("HMO: $" + String.valueOf(sum));
            }
            if(c2.isSelected() == true){
                sum += ppo;
                tf1.setText("PPO: $" + String.valueOf(sum));
            }
            if(c3.isSelected() == true){
                sum += dental;
                tf1.setText("Dental: $" + String.valueOf(sum));
                
                if(c1.isSelected() == true){
                    tf1.setText("HMO + Dental: $" + String.valueOf(sum));
                }
                if(c2.isSelected() == true){
                    tf1.setText("PPO + Dental: $" + String.valueOf(sum));
                }
                if(c2.isSelected() == true && c4.isSelected() == true){
                    tf1.setText("PPO + Vision + Dental: $" + String.valueOf(sum));
                }
                if(c1.isSelected() == true && c4.isSelected() == true){
                    tf1.setText("HMO + Vision + Dental: $" + String.valueOf(sum));
                }
            }
            if(c4.isSelected() == true){
                sum += vision;
                tf1.setText("Vision: $" + String.valueOf(sum));
                if(c3.isSelected() == true){
                    tf1.setText("Vision + Dental: $" + String.valueOf(sum));
                }
                if(c1.isSelected() == true){
                    tf1.setText("HMO + Vision: $" + String.valueOf(sum));
                }
                if(c2.isSelected() == true){
                    tf1.setText("PPO + Vision: $" + String.valueOf(sum));
                }
                if(c2.isSelected() == true && c3.isSelected() == true){
                    tf1.setText("PPO + Vision + Dental: $" + String.valueOf(sum));
                }
                if(c1.isSelected() == true && c3.isSelected() == true){
                    tf1.setText("HMO + Vision + Dental: $" + String.valueOf(sum));
                }
            }
            if(c3.isSelected() == false && c4.isSelected() == false &&
                    c1.isSelected() == false && c2.isSelected() == false){
                tf1.setText("");
            }
        }
    }
    public static void main(String[] args){
        new Insurance();
    }
}
