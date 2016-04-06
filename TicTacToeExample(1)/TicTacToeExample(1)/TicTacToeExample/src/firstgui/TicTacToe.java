/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package firstgui;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Raigeki
 */
public class TicTacToe  {
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // variable declarations:  format:  class  objectname;
        JFrame myframe;
        JPanel mypanel;
        JButton mybutton;
        JButton[][] board;
        
        // creates the array to store the buttons created
        board = new JButton[3][3];
       
       
        myframe = new JFrame();
        myframe.setTitle("Tic Tac Toe");
        myframe.setSize(300,400);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mypanel = new JPanel();
        myframe.add(mypanel);
        mypanel.setLayout(null);
        
       // instantiate an instance of the EventHandler class
       // this statement brings in a copy of the EventHandler class we made
        EventHandler  eh = new EventHandler( );
        
        // the two loops create a 
        for (int j = 1; j <= 3; j++){
            for (int i = 1; i <= 3; i++){
           mybutton = new JButton();
           mypanel.add(mybutton);
            mybutton.setBounds(i*50,j*50,50,50);
           
            board[i-1][j-1] = mybutton;
           mybutton.addActionListener(eh);
        }
        }
        eh.setEventBoard(board);
     mypanel.setVisible(true);
               myframe.setVisible(true);
    }
     
}
 
             

 