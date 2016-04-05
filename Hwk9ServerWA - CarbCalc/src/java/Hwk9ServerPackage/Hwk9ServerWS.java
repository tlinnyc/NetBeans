/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hwk9ServerPackage;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Raigeki
 */
@WebService(serviceName = "Hwk9ServerWS")
public class Hwk9ServerWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public String operation(@WebParam(name = "product") String product, @WebParam(name = "sugar") String sugar, @WebParam(name = "carb") String carb) {
        //TODO write your implementation code here:
        product.toLowerCase();
        switch(product){
            case "milk": 
                sugar = "14";
                carb = "11";
                break;
            case "beer":
                sugar = "150";
                carb = "13";
                break;
            case "soda":
                sugar = "39";
                carb = "36";
                break;
            case "bread":
                sugar = "40";
                carb = "24";
                break;
            default:
                return "Invalid entry";
        }
        return "You selected " + product + ", it contains " +
                sugar + " grams of sugar and " + carb + " grams"
                + " of carbs";
    }
}
