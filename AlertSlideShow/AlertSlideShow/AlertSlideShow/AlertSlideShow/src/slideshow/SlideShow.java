package slideshow;

import java.io.IOException;
import java.util.Random;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * Glen Jones
 * CSC 285 - Lesson 2
 * 09/19/2009
 */
public class SlideShow extends MIDlet implements CommandListener{

    private Image images[], splash[];
    private String files[] = {"bear.jpg", "elephant.jpg",
        "giraffe.jpg","gryphon.jpg", "lion.jpg", "monkey.jpg", "tiger.jpg"
    };

    private Command exit, next;

    private Alert pic;
    private Alert pic1;

    private Display disp;

    private int count, save, num;
    private Random gen = new Random();
    
    private String splashpic[] = {"splash.jpg"};
    // Constructor
    public SlideShow(){

        //Creating container
        pic = new Alert("Slide Show");
        pic1  = new Alert("Welcome");
        //Setup Commands
        next = new Command ("Next", Command.OK, 2);
          
        exit = new Command("Exit", Command.EXIT, 0);


        pic.addCommand(exit);
        pic.addCommand(next);
 
        pic.setCommandListener(this);
        //init count
        count = 0;
    }

    public void startApp(){
        disp = Display.getDisplay(this);
        //load up the images into the images array
        loadImages();

        //display initial pic and increment to next
        pic.setImage(splash[count++]);
        disp.setCurrent(pic);

    }
    public void pauseApp(){
    }

    public void destroyApp(boolean uc){
    }

    private Image loadImage(String location) {
        try {
            return Image.createImage(location);
        } catch (java.io.IOException e) {
            throw new RuntimeException("Unable to load Image: " + location);
        }
    }

    private void loadImages() {
        images = new Image[files.length];
        splash = new Image[splashpic.length];
        for(int i = 0; i < splashpic.length; i++){
            splash[i] = loadImage("/images/" + splashpic[i]);
        }
        for (int i = 0; i < files.length; i ++){
            System.out.println("Loading " + files[i]);
            images[i] = loadImage("/images/" + files[i]);
            //splash[i] = loadImage("/images/" + files[i]);
        }
    }

    public void commandAction(Command c, Displayable d) {
        save = num;
        for(int i = 0; i < 7; i++){
            if( c == exit ){
            notifyDestroyed();
        } else   {
            // Walk thru the images and reset when you reach the last
            if( i < files.length){
                num = gen.nextInt(7);
                while(save == num){
                    num = gen.nextInt(7);
                }
                pic.setImage(images[num]);
                String name = "";
                name = files[num].substring(0, files[num].indexOf("."));
                name = name.substring(0,1).toUpperCase() + name.substring(1);
                pic.setTitle(name + " (" + (num+1) + " of " + files.length + ")");
            } else {
                count = 0;
                pic.setImage(images[i]);
            }
        }
        }
        disp.setCurrent(pic);
    }
}
