
import java.awt.*;
import javax.swing.*;

public class JNestedBoxes extends JFrame{
    public JNestedBoxes(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 518, 640);
        getContentPane().add(new Rectangle());
        setVisible(true);
    }
    public static void main(String[] args){
        new JNestedBoxes();
    }
}
class Rectangle extends JComponent{
    public void paint(Graphics g){
        for(int i = 0; i < 4; i++){
            g.drawRect(i*50, i*50, 500-(i*100), 600-(i*100));
        }
    }
}
