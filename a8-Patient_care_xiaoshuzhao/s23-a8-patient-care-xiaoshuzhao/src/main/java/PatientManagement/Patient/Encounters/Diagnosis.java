/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Patient.Encounters;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kal bugrara
 */
public class Diagnosis {
    String category; // infectious or Hereditary
    boolean confirmed = false;
    Condition condition;

    public Diagnosis(String cat, Condition con, boolean c) {
        category = cat;
        condition = con;
        confirmed = c; // Assumption: if true then lab tests confirm that it is a diesease
    }

    public boolean isConfirmed() {
        return confirmed; // just return the boolean
    }

    public Condition getCondition(){
        return condition;
    }
    public String getCategory(){
        return category;
    }

    public void printCondition(){
        System.out.println("Disease type: " + this.getCategory());
        System.out.println("Disease name: " + this.getCondition().getDiseaseName());
        if (this.isConfirmed()){
            System.out.println("Confirmed!");
        } else {
            System.out.println("NOT Confirmed!");
        }

        System.out.println(this.getCondition().toString());
    }


}
