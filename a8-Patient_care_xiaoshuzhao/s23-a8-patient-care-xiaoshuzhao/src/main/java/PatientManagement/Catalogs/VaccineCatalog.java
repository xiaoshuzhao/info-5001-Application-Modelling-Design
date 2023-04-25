/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Catalogs;

import java.util.ArrayList;

import PatientManagement.Patient.ClinicalHistory.Vaccine;

/**
 *
 * @author kal bugrara
 */
public class VaccineCatalog {
    ArrayList<Vaccine> vaccineCatalog;

    public VaccineCatalog(){
        vaccineCatalog = new ArrayList<Vaccine>();
    }

    public void addNewVaccine(Vaccine v){
        vaccineCatalog.add(v);
    }

    public Vaccine findVaccineByName(String name) {
        for (Vaccine v : vaccineCatalog) {
            if (v.getVaccineName().equals(name))
                return v;
        }
        return null;
    }

}
