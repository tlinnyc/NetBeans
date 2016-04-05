/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hwk10ServerPackage;

import java.util.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Raigeki
 */
@WebService(serviceName = "Hwk10ServerWS")
public class Hwk10ServerWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public List<String> operation(@WebParam(name = "range") int range) {
        //TODO write your implementation code here:
        List<String> items = new ArrayList<String>();        
        if(range < 50){
            items.add("Microsoft: $47");
            return items;
        }
        if(range >= 50 && range < 100){
            items.add("Shell: $55");
            items.add("Facebook: $93");
            return items;
        }
        if(range >= 100 && range < 200){
            items.add("Apple: $112");
            items.add("Bayer: $126");
            items.add("Boeing: $144");
            return items;
        }
        if(range >= 200){
            items.add("Google: $644");
            return items;
        }
        return null;
    }
}