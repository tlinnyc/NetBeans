/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nutdrop;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


public class NutCanvas extends Canvas {

    private NutManager mgr;
    private Image buffer;

    void setManager(NutManager mgr) {
        this.mgr = mgr;
    }

    protected void paint(Graphics g) {
        if (buffer != null) {
            g.drawImage(buffer, 0, 0, g.TOP | g.LEFT);
        }
    }
    
    public void keyPressed(int keyCode){
        mgr.keyPressed(keyCode);
    }
    
    public Image getBuffer(){
        if ( buffer == null)
            buffer = Image.createImage(getWidth(), getHeight());
        return buffer;
    }
}
