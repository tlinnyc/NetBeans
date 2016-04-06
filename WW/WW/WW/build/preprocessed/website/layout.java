/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package website;

import javax.microedition.lcdui.CustomItem;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author Administrator
 */
public class layout extends CustomItem{
    int width, height;
    public layout(String title){
        super(title);
    }
    public layout(String title, int w, int h){
        super(title);
        width = w;
        height = h;
    }
    protected int getMinContentHeight() {
        return height;
    }

    protected int getMinContentWidth() {
        return width;
    }

    protected int getPrefContentHeight(int width) {
        return width;
    }

    protected int getPrefContentWidth(int height) {
        return height;
    }

    protected void paint(Graphics g, int w, int h) {
        g.drawRect(0, 0, width, height);
    }
    
}
