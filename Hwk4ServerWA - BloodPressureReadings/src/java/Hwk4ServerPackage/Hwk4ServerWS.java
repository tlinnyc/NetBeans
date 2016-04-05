/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hwk4ServerPackage;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Raigeki
 */
@WebService(serviceName = "Hwk4ServerWS")
public class Hwk4ServerWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Hwk4BloodPressure")
    public String Hwk4BloodPressure(@WebParam(name = "Systolic") int Systolic, @WebParam(name = "Diastolic") int Diastolic) {
        //TODO write your implementation code here:
        if(Systolic >= 70 && Systolic <= 90 && Diastolic >= 40 && Diastolic <= 60){
            return "Low Blood Pressure";
        }
        if(Systolic > 90 && Systolic <= 120 && Diastolic > 60 && Diastolic <= 80){
            return "Ideal Blood Pressure";
        }
        if(Systolic > 120 && Systolic <= 140 && Diastolic > 80 && Diastolic <= 90){
            return "Pre-High Blood Pressure";
        }
        if(Systolic > 140 && Diastolic > 90){
            return "High Blood Pressure";
        }
        return "No Reading";
    }
}
