
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;



public class JDiagonalLines extends JFrame{
    public JDiagonalLines(){
        setSize(225, 225);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void paint(Graphics g){
        g.drawRect(10, 10, 200, 200);
        g.drawLine(10, 10, 210, 210);
    }
    public static void main(String[] args){
        new JDiagonalLines();
    }
}
