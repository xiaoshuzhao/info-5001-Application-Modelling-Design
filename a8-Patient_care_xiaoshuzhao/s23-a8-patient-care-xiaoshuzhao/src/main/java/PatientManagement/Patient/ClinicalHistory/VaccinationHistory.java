/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Patient.ClinicalHistory;

import java.util.ArrayList;

import PatientManagement.Patient.Patient;

/**
 *
 * @author kal bugrara
 */
public class VaccinationHistory {
    Patient patient;
    ArrayList<Vaccination> vaccinationRecords;
    Vaccination v;

    public VaccinationHistory(Patient p){
        patient = p;
        vaccinationRecords = new ArrayList<Vaccination>();
    }

    public ArrayList<Vaccination> addVaccination(Vaccination v) {
        vaccinationRecords.add(v);
        return vaccinationRecords;
    }


    public void getVaccinationRecords(Vaccination v) {
        vaccinationRecords.add(v);
    }

    public int getVaccinationRecordsNumber(){
        return vaccinationRecords.size();
    }

    // public void printVaccinationRecords() {
    //     System.out.println("Vaccination records for patient " + patient.getPerson().getPersonName() + ":" );
    //     for (Vaccination va : vaccinationRecords){
    //         String vac = va.getVaccine().getVaccineName();
    //         String vacDate = va.getVaccinationDate();
    //         System.out.println(vac + ',' + vacDate);
    //     }
    // }

}