/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Patient.ClinicalHistory;

import PatientManagement.Clinic.Clinic;

/**
 *
 * @author kal bugrara
 */
public class Vaccine {
    String vaccineName;
    int stock;
    Clinic clinic;

    public Vaccine(String name, int stock, Clinic c){
        vaccineName = name;
        this.stock = stock;
        clinic = c;
    }

    public String getVaccineName(){
        return vaccineName;
    }

    public int getStock(){
        return stock;
    }

    public Clinic getClinic(){
        return clinic;
    }



}
