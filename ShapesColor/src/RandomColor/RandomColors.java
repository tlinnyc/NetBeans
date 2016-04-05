package RandomColor;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class RandomColors extends JPanel{
    String[] shapes = {"Triangle", "Square", "Circle"};
    JComboBox combobox;
    JButton select;
    Random ran = new Random();
    int size, height, x, y, colorchooser;
    Color[] colors = { 
        Color.yellow, Color.blue, Color.cyan, Color.darkGray, 
        Color.orange, Color.green, Color.red, Color.lightGray, 
        Color.magenta, Color.black, Color.gray, Color.white, 
        Color.pink};
    public RandomColors(){
        setLayout(null);
        size = 0;
        height = 0;
        x = 0;
        y = 0;
        select = new JButton("Paint!");
        select.setSize(100, 30);
        select.setLocation(170, 469);
        select.addActionListener(new buttonListener());
        combobox = new JComboBox(shapes);
        combobox.setSize(150, 30);
        combobox.setLocation(10, 469);
        add(select);
        add(combobox);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(combobox.getSelectedIndex() == 0){
            for(int i = 0; i < 20; i++){
                colorchooser = ran.nextInt(13);
                size = ran.nextInt(150) + 1;
                x = ran.nextInt(499) + 1;
                y = ran.nextInt(350) + 1;
                g.setColor(colors[colorchooser]);
                int[] xpoints = {x, x - size, x + size};
                int[] ypoints = {y, y + size, y + size};
                g.fillPolygon(xpoints, ypoints, 3);
                System.out.println(i);
            }
        }
        if(combobox.getSelectedIndex() == 1){
            for(int i = 0; i < 20; i++){
                colorchooser = ran.nextInt(13);
                size = ran.nextInt(150) + 1;
                x = ran.nextInt(499) + 1;
                y = ran.nextInt(350) + 1;
                g.setColor(colors[colorchooser]);
                g.fillRect(x, y, size, size);
            }
        }
        if(combobox.getSelectedIndex() == 2){
            for(int i = 0; i < 20; i++){
                colorchooser = ran.nextInt(13);
                size = ran.nextInt(150) + 1;
                x = ran.nextInt(499) + 1;
                y = ran.nextInt(350) + 1;
                g.setColor(colors[colorchooser]);
                g.fillOval(x, y, size, size);
            }
        }
    }
    class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            repaint();
            System.out.println(x);
            System.out.println(y);
            System.out.println(size);
        }
    }
    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setSize(600, 550);
        f.setTitle("Selecting Shapes");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new RandomColors());
        f.setVisible(true);
    }
}
