import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Portraits extends JFrame{
    JFrame frame = new JFrame();
    JLabel l1, l2, l3;
    JCheckBox c1, c2, c3, c4, c5;
    JLabel l6 = new JLabel();
    JPanel p1, p2, p3, p4;
    JTextField tf1;
    JButton b1;
    CheckboxGroup cbg1, cbg2;
    
    public Portraits(){
        cbg1 = new CheckboxGroup();
        cbg2 = new CheckboxGroup();
        tf1 = new JTextField(20);
        tf1.setEditable(false);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        l1 = new JLabel("Select a Session:");
        l2 = new JLabel("Select a Location:");
        l3 = new JLabel("Paula's Portrait's Fee:");
        c1 = new JCheckBox("One Person");
        c2 = new JCheckBox("Two or More Subjects");
        c3 = new JCheckBox("Session with Pet");
        c4 = new JCheckBox("In Studio");
        c5 = new JCheckBox("On Location");
        p1.add(l1);
        p1.add(new Checkbox("One Person", cbg1, false));
        p1.add(new Checkbox("Two or More Subjects", cbg1, false));
        p1.add(new Checkbox("Session with Pet", cbg1, false));
        p2.add(l2);
        p2.add(new Checkbox("In Studio", cbg2, false));
        p2.add(new Checkbox("On Location", cbg2, false));
        b1 = new JButton("Calculate");
        b1.addActionListener(new buttonListener());
        p3.add(b1);
        p4.add(l3);
        p4.add(tf1);
        
        setTitle("Portrait Option Selection");
        frame.setSize(600, 180);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4,1));
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        frame.setVisible(true);
        
    }
    public class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double sum, session, location, oneperson, twoperson, pet, offstudio;
            oneperson = 40;
            twoperson = 75;
            pet = 95;
            offstudio = 90;
            sum = 0;
            if(cbg1.getSelectedCheckbox().getLabel().equals(c1.getText())){
                sum += oneperson;
            }
            if(cbg1.getSelectedCheckbox().getLabel().equals(c2.getText())){
                sum += twoperson;
            }
            if(cbg1.getSelectedCheckbox().getLabel().equals(c3.getText())){
                sum += pet;
            }
            if(cbg2.getSelectedCheckbox().getLabel().equals(c4.getText())){
                sum += offstudio;
            }
            tf1.setText(String.valueOf(sum));
        }
    }
    public static void main(String[] args){
        Portraits test = new Portraits();
    }
}
