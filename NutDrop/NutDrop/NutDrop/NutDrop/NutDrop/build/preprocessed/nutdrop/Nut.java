/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nutdrop;

import java.util.Random;
import javax.microedition.lcdui.Graphics;


public class Nut {

    private int x,  y,  rad,  dx,  dy,  width,  height, one, two, three;
    private static Random r = new Random();

    public Nut(NutCanvas c) {
        width = c.getWidth();
        height = c.getHeight();
        x = width / 40 + r.nextInt(width - width / 20);
        y = 0;
        dx = 0;
        dy = (2 + r.nextInt(5));
        rad = width / 20;
    }

    boolean outOfBounds() {
        if (y > height) {
            return true;
        } else {
            return false;
        }
    }

    void update() {
        y = y + dy;
    }

    boolean hits(Pan p) {
        int left = x - rad,
                right = x + rad,
                top = y - rad,
                bot = y + rad;
        if (dy > 0 && ((p.left() <= left && left <= p.right()) ||
                (p.left() <= right && right <= p.right())) &&
                (p.top() <= bot - dy && bot - dy <= p.bot())) {
            return true;
        } else {
            return false;
        }
    }

    void draw(Graphics g) {
        one = r.nextInt(255);
        two = r.nextInt(255);
        three = r.nextInt(255);
//        g.fillArc(x - rad, y - rad, rad*2, rad*2, 0, 360);
        g.setColor(one, two, three);
        g.fillArc(x - rad*2 + 5, y - rad*2 - 5, rad*2, rad*2, 252, 36);
        g.fillArc(x - rad + 5, y - rad - 5, rad*2, rad*2, 180, 36);
        g.fillArc(x - rad + 5 - rad/2, y - rad - 5 + rad, rad*2, rad*2, 108, 36);
        g.fillArc(x - rad + 5 - rad*2 + 1, y - rad - 5 + rad, rad*2, rad*2, 36, 36);
        g.fillArc(x - rad + 5 - rad*2, y - rad - 5, rad*2, rad*2, 324, 36);
        g.setColor(0x000000FF);
    }
}
