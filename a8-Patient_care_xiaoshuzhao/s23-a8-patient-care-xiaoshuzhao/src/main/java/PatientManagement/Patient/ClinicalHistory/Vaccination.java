/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Patient.ClinicalHistory;

import PatientManagement.Catalogs.VOrderItem;
import PatientManagement.Clinic.Clinic;

/**
 *
 * @author kal bugrara
 */
public class Vaccination {
    // VOrderItem voi;
    Vaccine vaccine;
    String date;


    public Vaccination(Vaccine v, String date) {
        vaccine = v;
        this.date = date;
    }

    public String getVaccineName(){
        return vaccine.getVaccineName();
    }

    public Vaccine getVaccine(){
        return vaccine;
    }

    public String getVaccinationDate(){
        return date;
    }



}
