import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class game extends JFrame{
    Random ran = new Random();
    int random = ran.nextInt(1000) + 1;
    int count = 0;
    JLabel l1, l2, result1, result2, result3;
    JTextField tf1;
    JButton b1;
    public game(){
        
        setLayout(null);
        setTitle("Guessing Game");
        l1 = new JLabel("I have a number between 1 and 1000. Can you guess my number?");
        l1.setSize(400, 20);
        l1.setLocation(0, 0);
        l2 = new JLabel("Please enter your first guess:");
        l2.setSize(200, 20);
        l2.setLocation(0, 20);
        tf1 = new JTextField(10);
        tf1.setSize(100, 20);
        tf1.setLocation(175, 20);
        b1 = new JButton("Click");
        b1.setSize(80, 30);
        b1.setLocation(150, 80);
        b1.addActionListener(new buttonListener());
        result1 = new JLabel("Too high, try a lower number");
        result1.setSize(400, 20);
        result1.setLocation(100, 50);
        result2 = new JLabel("Too low, try a higher number");
        result2.setSize(400, 20);
        result2.setLocation(100, 50);
        result3 = new JLabel("You got it right! Click the button to play again");
        result3.setSize(400, 20);
        result3.setLocation(50, 50);
        setSize(400,150);
        add(l1);
        add(l2);
        add(tf1);
        add(b1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Container c = getContentPane();
            int input;
            input = Integer.parseInt(tf1.getText());
            if(count != 1){
                if(input > random){
                    remove(result2);
                    c.setBackground(Color.BLUE);
                    add(result1);
                    repaint();
                }
                if(input < random){
                    remove(result1);
                    c.setBackground(Color.red);
                    add(result2);
                    repaint();
                }
                if(input == random){
                    count++;
                    c.setBackground(Color.white);
                    remove(result1);
                    remove(result2);
                    add(result3);
                    b1.setText("Restart");
                    repaint();
                }
            }else{
                count = 0;
                random = ran.nextInt(1000) + 1;
                remove(result3);
                b1.setText("Click");
                tf1.setText("");
                repaint();
            }
            System.out.println(random + tf1.getText());
        }
    }
    public static void main(String[] args){
        new game();
        
    }
}
