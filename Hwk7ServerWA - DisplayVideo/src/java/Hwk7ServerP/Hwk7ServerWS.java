/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hwk7ServerP;

import java.io.*;
import javafx.scene.media.*;
import javax.jws.*;
import javax.sound.sampled.*;

/**
 *
 * @author Tommy
 */
@WebService(serviceName = "Hwk7ServerWS")
public class Hwk7ServerWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "hwk7op")
    public String hwk7op(@WebParam(name = "animal") String animal) {
        //TODO write your implementation code here:
        File lion = new File("Lion.mp3");
        File tiger = new File("Tiger.mp3");
        File elephant = new File("Elephant.mp3");
        
        return "You have selected: " + animal + "<br>";
    }


}
