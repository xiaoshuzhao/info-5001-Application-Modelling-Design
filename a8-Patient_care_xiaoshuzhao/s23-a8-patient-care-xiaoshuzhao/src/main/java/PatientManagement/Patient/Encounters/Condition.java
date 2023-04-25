/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Patient.Encounters;

import PatientManagement.Patient.Patient;

/**
 *
 * @author kal bugrara
 */
public class Condition {
    String disease;
    String description;
    String duration;


    public Condition(Patient p, String disease, String description, String duration){
        this.disease = disease;
        this.description = description;
        this.duration = duration;
    }

    public String getDiseaseName(){
        return disease;
    }


    public String toString(){
        return "Description: " +  description + ", " + duration;
    }



}
