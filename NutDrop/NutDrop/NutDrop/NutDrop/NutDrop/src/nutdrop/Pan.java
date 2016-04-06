package nutdrop;

import javax.microedition.lcdui.Graphics;

public class Pan {

    private NutCanvas canvas;
    private int x,  y,  width,  height;
    private boolean userLeft;
    private boolean userRight;
    private boolean userUp;
    private boolean userDown;
    private boolean cheat = false;
    private int dx, dy, up = 0, down = 0, left = 0, right = 0, count = 0;

    Pan(NutCanvas c) {
        this.canvas = c;
        width = c.getWidth() / 5;
        height = c.getHeight() / 40;
        x = c.getWidth() / 2 - width / 2;
        y = c.getHeight() - height;
        dx = width;
        dy = height;
    }
    boolean getCheat(){
        return cheat;
    }
    void draw(Graphics g) {
        if(cheat == true){
            g.setColor(0x00FF0000);
            g.fillRect(x, y, canvas.getWidth(), 5);
            g.fillRect(x, y - 5, 5, 5);
            g.fillRect(canvas.getWidth() - 5, y - 5, 5, 5);
            x = 0;
            width = canvas.getWidth();
            height = canvas.getHeight();
        }else{
            g.setColor(0x00FF0000);
            g.fillRect(x, y, width, height);
            g.fillRect(x, y - height, height, height);
            g.fillRect(x + width - height, y - height, height, height);
            
        }
    }

    void keyPressed(int keyCode) {
        int action = canvas.getGameAction(keyCode);
        if (action == NutCanvas.LEFT) {
            userLeft = true;
            left++;
        } else if (action == NutCanvas.RIGHT) {
            userRight = true;
            right++;
        } else if (action == NutCanvas.UP){
            userUp = true;
            up++;
        } else if (action == NutCanvas.DOWN){
            userDown = true;
            down++;
        }
        if(count == 0 && userUp){
            count++;
        }else
            if(count == 1 && userUp){
                count++;
            }else
                if(count == 2 && userDown){
                    count++;
                }else
                    if(count == 3 && userDown){
                        count++;
                    }else
                        if(count == 4 && userLeft){
                            count++;
                        }else
                            if(count == 5 && userLeft){
                                count++;
                            }else
                                if(count == 6 && userRight){
                                    count++;
                                }else
                                    if(count == 7 && userRight){
                                        cheat = true;
                                    }else
                                        count = 0;
    }

    void update() {
        if(cheat == false){
            if (userLeft) {
                userLeft = false;
                if (x - dx >= 0) {
                    x = x - dx;
                } else {
                    x = 0;
                }
            }
            if (userRight) {
                userRight = false;
                if (x + dx <= canvas.getWidth() - width) {
                    x = x + dx;
                } else {
                    x = canvas.getWidth() - width;
                }
            }
            if (userUp){
                userUp = false;
                if (y + dy > 23){
                    y = y - dy * 2;
                } else {
                    y = 17;
                }
            }
            if(userDown){
                userDown = false;
                if (y + dy <= canvas.getHeight() - height){
                    y = y + dy * 2;
                } else {
                    y = canvas.getHeight() - 5;
                }
            }
        }
        if(cheat == true){
            if (userUp){
                userUp = false;
                if (y + dy > 23){
                    y = y - dy * 2;
                } else {
                    y = 17;
                }
            }
            if(userDown){
                userDown = false;
                if (y + dy <= canvas.getHeight() - 5){
                    y = y + dy * 2;
                } else {
                    y = canvas.getHeight() - 5;
                }
            }
        }
    }

    int top() {
        return y;
    }

    int bot() {
        return y + height;
    }

    int left() {
        return x;
    }

    int right() {
        return x + width;
    }
}
