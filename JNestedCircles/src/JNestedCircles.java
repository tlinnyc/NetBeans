
import java.awt.*;
import javax.swing.*;



public class JNestedCircles extends JFrame{
    public JNestedCircles(){
        setSize(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void paint(Graphics g){
        for(int i = 0; i < 15; i++){
            g.drawOval(i*5, i*5, 200-(i*10), 200-(i*10));
        }
    }
    public static void main(String[] args){
        new JNestedCircles();
    }
}
