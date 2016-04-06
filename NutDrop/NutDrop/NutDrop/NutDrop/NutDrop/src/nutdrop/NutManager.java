/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nutdrop;

import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


public class NutManager implements Runnable {

    private static final int MAX_MISSES = 10;
    private Image buffer;
    private NutCanvas canvas;
    private Vector nuts;
    private Pan pan;
    private boolean done;
    private int missed,  score;
    private Random r;
    private String cheat1 = "Catch 10 stars to\nfind out cheat!", cheat2 = "\nPress UP, UP, \nDOWN, DOWN, \nLEFT, LEFT, \nRIGHT, RIGHT";
    
    void keyPressed(int keyCode) {
        pan.keyPressed(keyCode);
    }

    void setCanvas(NutCanvas canvas) {
        this.canvas = canvas;
    }

    public void run() {
        r = new Random();
        
        pan = new Pan(canvas);
        nuts = new Vector();
        nuts.addElement(new Nut(canvas));
       
        missed = 0;
        score = 0;
        buffer = canvas.getBuffer();

        done = false;
        while (!done) {
            update();
            draw();
            pause();
        }
    }

    private void clearBuffer(Graphics g) {
        g.setColor(0x00FFFFFF);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void draw() {
        Nut n;
        Graphics g = buffer.getGraphics();
        clearBuffer(g);
        pan.draw(g);
        for (int i = 0; i < nuts.size(); i++) {
            n = (Nut) nuts.elementAt(i);
            n.draw(g);
        }
        g.drawString("Caught: " + score, 0, 0, Graphics.TOP | Graphics.LEFT);
        g.drawString("Missed: " + missed, canvas.getWidth(), 0, Graphics.TOP | Graphics.RIGHT);
        g.drawString(cheat1, 10, 40, Graphics.TOP | Graphics.LEFT);
        canvas.repaint();
        if(score >= 10){
            g.drawString(cheat2, 20, 60, Graphics.TOP | Graphics.LEFT);
        }
        if(pan.getCheat() == true){
            cheat1 = "";
            cheat2 = "";
        }
    }

    private void pause() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException ie) {

        }
    }

    private void update() {
        Nut n;
        // Update pan
        pan.update();
        // for each of the nuts
        for (int i = 0; i < nuts.size();) {
            // Check for collision with pan then update
            n = (Nut) nuts.elementAt(i);
            n.update();
            if (n.hits(pan)) {
                nuts.removeElement(n);
                score = score + 1;
            } else {
                if (n.outOfBounds()) {
                    nuts.removeElement(n);
                    missed = missed + 1;
                } else {
                    i = i + 1;
                }
            }
        }
        // Check for game done
        if (missed == MAX_MISSES) {
            done = true;
        }
        
        // Randomly introduce nuts
        if ( r.nextInt(200) < 10)
            nuts.addElement(new Nut(canvas));
    }
}
