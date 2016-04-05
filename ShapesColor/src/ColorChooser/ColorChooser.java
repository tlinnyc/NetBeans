package ColorChooser;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ColorChooser extends JPanel{
    String[] shapes = {"Triangle", "Square", "Circle"};
    JComboBox combobox, colorcombo;
    JButton select, selectcolor;
    Random ran = new Random();
    int size, height, x, y, colorchooser;
    Color newColor = Color.red;
    Color initialColor = Color.red;
    public ColorChooser(){
        setLayout(null);
        size = 0;
        x = 0;
        y = 0;
        select = new JButton("Paint!");
        select.setSize(100, 30);
        select.setLocation(170, 469);
        select.addActionListener(new buttonListener());
        combobox = new JComboBox(shapes);
        combobox.setSize(150, 30);
        combobox.setLocation(10, 469);
        selectcolor = new JButton("Choose color");
        selectcolor.setSize(150, 30);
        selectcolor.setLocation(290, 469);
        selectcolor.addActionListener(new buttonListener());
        add(select);
        add(combobox);
        add(selectcolor);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(combobox.getSelectedIndex() == 0){
            for(int i = 0; i < 20; i++){
                size = ran.nextInt(150) + 1;
                x = ran.nextInt(499) + 1;
                y = ran.nextInt(350) + 1;
                g.setColor(new Color(newColor.getRGB()));
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
                g.setColor(new Color(newColor.getRGB()));
                g.fillRect(x, y, size, size);
            }
        }
        if(combobox.getSelectedIndex() == 2){
            for(int i = 0; i < 20; i++){
                colorchooser = ran.nextInt(13);
                size = ran.nextInt(150) + 1;
                x = ran.nextInt(499) + 1;
                y = ran.nextInt(350) + 1;
                g.setColor(new Color(newColor.getRGB()));
                g.fillOval(x, y, size, size);
            }
        }
    }
    class buttonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == select){
                repaint();
                System.out.println(x);
                System.out.println(y);
                System.out.println(size);
            }
            if(e.getSource() == selectcolor){
                newColor = JColorChooser.showDialog(null, "Dialog Title", initialColor);
            }
        }
    }
    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setSize(600, 550);
        f.setTitle("Selecting Shapes");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new ColorChooser());
        f.setVisible(true);
    }
}
