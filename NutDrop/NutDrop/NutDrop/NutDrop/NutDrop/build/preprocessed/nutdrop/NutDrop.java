package nutdrop;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class NutDrop extends MIDlet implements CommandListener{
    private NutCanvas canvas;
    private NutManager mgr;
    private Command exit, start;
    
    public NutDrop(){
        canvas = new NutCanvas();
        mgr = new NutManager();
        canvas.setManager(mgr);
        mgr.setCanvas(canvas);
        
        exit = new Command("Exit", Command.EXIT, 0);
        start = new Command("Start", Command.SCREEN, 0);
        canvas.addCommand(exit);
        canvas.addCommand(start);
        canvas.setCommandListener(this);
    }
    public void startApp() {
        Display d = Display.getDisplay(this);

        d.setCurrent(canvas);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if ( c == exit )
            notifyDestroyed();
        else if ( c == start ){
            Thread t = new Thread(mgr);
            t.start();
        }
    }
}
