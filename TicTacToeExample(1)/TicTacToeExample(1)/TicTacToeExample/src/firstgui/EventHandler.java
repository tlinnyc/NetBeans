/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgui;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author douglas moody
 */
public class EventHandler  implements ActionListener{
     // EventBoard is the name of the array containing all the JButton withi teh EventHandler
     // board (in the other program)  is the name of the array containing all the JButton withi the FirstGui program
    JButton[][] EventBoard;
    private static String player = "X";
    private static int tie = 0;
    // this method is called from FirstGui to tell the Eventhandler the board array
    public void setEventBoard (JButton[][] inboard){
        EventBoard = inboard;
    }      
     
    public  void actionPerformed(ActionEvent e) {
        JButton clickedbutton;
        tie++;
        // clickedbutton will now point to the Button actually clicked
        clickedbutton = (JButton) e.getSource();
       
        // player = JOptionPane.showInputDialog("Player");
        if(clickedbutton.getText().equals("")){
            clickedbutton.setText(player);
            // call the routine to check if the player who just moved won
            if(CheckWinner(player)){
                JOptionPane.showMessageDialog(null,"Player: " + player + " won");
            }
            if(player.equals("X")){
                player = "O";
            }else{
                player = "X";
            }
        }else{
            JOptionPane.showMessageDialog(null,"Choose an empty field");
            tie--;
        }
        
        
    }   
     
    private boolean CheckWinner(String inplayer) {
        int count, count2, count3, count4, k, checktie = 0;
       
        // this loop checks the columns on the Board
        for(int i = 0; i <= 2; i++) {
            count = 0;
            count2 = 0;
            count3 = 0;
            count4 = 0;
            k = 3;
            for(int j = 0; j <= 2; j++) {
                if(EventBoard[i][j].getText().equals(inplayer)){
                    count++;
                }
                if(EventBoard[j][i].getText().equals(inplayer)){
                    count2++;
                }
                if(EventBoard[j][j].getText().equals(inplayer)){
                    count3++;
                }
                k--;
                if(EventBoard[j][k].getText().equals(inplayer)){
                    count4++;
                }
            }
            if(count == 3 || count2 == 3 || count3 == 3 || count4 == 3){
                return true;
            }
            if(tie == 9 && (count != 3 || count2 != 3 || count3 != 3 || count4 != 3)){
                checktie++;
            }
        }
        if(checktie != 0){
            JOptionPane.showMessageDialog(null,"Tie");
        }
        return false;
    }
 }