
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class JChangeSizeAndColor extends JFrame{
    JButton click;
    JLabel label;
    Random ran = new Random();
    int horizontal, vertical, red, green, blue, fontsize;
    
    public JChangeSizeAndColor(){
        horizontal = 0;
        vertical = 40;
        red = 0;
        green = 0;
        blue = 0;
        click = new JButton("Click me");
        click.addActionListener(new buttonListener());
        setLayout(new BorderLayout());
        setSize(400, 200);
        add(click, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fontsize = ran.nextInt(75);
            horizontal = ran.nextInt(300);
            vertical = ran.nextInt(172);
            red = ran.nextInt(255);
            green = ran.nextInt(255);
            blue = ran.nextInt(255);
            repaint();
        }
    }
    public void paint(Graphics g){
        g.clearRect(0, 0, 400, 166);
        Font font = new Font("Serif", Font.PLAIN, fontsize);
        g.setFont(font);
        g.setColor(new Color(red, green, blue));
        g.drawString("LOOK", horizontal, vertical);
    }
    public static void main(String[] args){
        new JChangeSizeAndColor();
    }
}
