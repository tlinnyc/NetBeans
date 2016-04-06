/*
 * KappaPizzaOrder.java
 *
 * Created on January 14, 2007, 2:07 PM
 */

package website;

import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 *
 * @author  Krishnan
 * @version
 */
public class Register extends MIDlet implements Runnable, CommandListener{
    private Alert alert;
    private Form form;
//    private Command complete;
    private ChoiceGroup mm, dd, yy, gender, state, sec, yes, yes2;
    private TextField firstname, lastname, zip, email, email2, user, pass, pass2, secanswer, username;
    private String[] months = {"Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December    "};
    private String[] days = {"Day   ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] years = {"Year   ", "1884", "1885", "1886", "1887", "1888", "1889", "1890", "1891", "1892", "1893", "1894", "1895", "1896", "1897", "1898", "1899", "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014"};
    private String[] gen = {"Male", "Female"};
    private String[] states = {"(Select One)", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
    private String[] quest = {"Select One", "What is your first pet's name?", "What is your favorite cartoon character?", "What is your favorite color?", "What is your father's middle name?", "What is your favorite snack food?", "What was the street you grew up?"};
    private String[] aa = {"Yes! I'd like to receive the Weight Watchers email newsletter with helpful tips, recipes and more, as well as special offers for Weight Watchers products and services."};
    private String[] aaa = {"By checking this box, you acknowledge that you have read and agree to be bound by our Subscription Agreement."};
    
    private Image logo = loadImage("/logo.png");
    private Image check = loadImage("/check.png");
    private Image complete = loadImage("/complete.png");
    private StringItem st1 = new StringItem("", "Review & accept the Subscription Agreement");
    private StringItem st2 = new StringItem("", "Terms and Conditions of Use\nPLEASE READ THE FOLLOWING TERMS AND CONDITIONS RELATING TO YOUR USE OF OUR WEBSITE CAREFULLY.\nBy using our Website, you agree to these Terms and Conditions of Use......................................................................................................Terms & Conditions, or to exercise any right under the Terms & Conditions, will not be construed as a waiver or relinquishment to any extent of such party's right to assert or rely upon any such provision or right in that or any other instance; rather, the same will be and remain in full force and effect.(Last modified as of March 05, 2012) ");
    private StringItem st3 = new StringItem("© 2014 Weight Watchers International, Inc. © 2014 WeightWatchers.com, Inc. All rights reserved.", "WEIGHT WATCHERS and PointsPlus are registered trademarks of Weight Watchers International, Inc. and are used under license by WeightWatchers.com, Inc.");
    
    private Display disp;
    
    public Register(){
        alert = new Alert("Sign-up");
//        complete = new Command("Complete Sign-up", Command.OK, 0);
        form = new Form("Weight Watchers");
        firstname = new TextField("First Name:", "", 10, TextField.ANY);
        lastname = new TextField("Last Name:", "", 10, TextField.ANY);
        mm = new ChoiceGroup("Your birthdate:          ", Choice.POPUP, months, null);
        dd = new ChoiceGroup("", Choice.POPUP, days, null);
        yy = new ChoiceGroup("", Choice.POPUP, years, null);
        gender = new ChoiceGroup("Your gender:", Choice.EXCLUSIVE, gen, null);
        state = new ChoiceGroup("State:", Choice.POPUP, states, null);
        zip = new TextField("Zip Code", "", 5, TextField.NUMERIC);
        email = new TextField("E-mail:", "", 20, TextField.ANY);
        email2 = new TextField("Re-enter e-mail:", "", 20, TextField.ANY);
        username = new TextField("Username", "", 10, TextField.ANY);
        pass = new TextField("Password      ", "", 10, TextField.PASSWORD);
        pass2 = new TextField("Confirm Password", "", 10, TextField.PASSWORD);
        sec = new ChoiceGroup("Security Question", Choice.POPUP, quest, null);
        secanswer = new TextField("Security Answer", "", 10, TextField.ANY);
        yes = new ChoiceGroup("", Choice.MULTIPLE, aa, null);
        yes2 = new ChoiceGroup("", Choice.MULTIPLE, aaa, null);
        st1.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        st2.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_ITALIC, Font.SIZE_MEDIUM));
        form.append(logo);
        form.append("Create Your Registered User Account Login");
        form.append(firstname);
        form.append(lastname);
        form.append(mm);
        form.append(dd);
        form.append(yy);
        form.append(gender);
        form.append(state);
        form.append(zip);
        form.append(email);
        form.append(email2);
        form.append(username);
        form.append(check);
        form.append(pass);
        form.append(pass2);
        form.append(sec);
        form.append(secanswer);
        form.append(yes);
        form.append(st1);
        form.append(st2);
        form.append(yes2);
        form.append(complete);
        form.append(st3);
//        form.addCommand(complete);
        form.setCommandListener(this);        
    }
    
    public void startApp() {
        Thread t = new Thread(this);
        disp = Display.getDisplay(this);
        t.start();
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    private Image loadImage(String location){
        try {
            return Image.createImage(location);
        } catch (java.io.IOException e) {
            throw new RuntimeException("Unable to load Image: " + location);
        }
    }
    
    public void run() {
        disp.setCurrent(form);
    }
    
    public void commandAction(Command command, Displayable displayable) {
 
    }
}

