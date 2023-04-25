/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Patient.Encounters;

import java.sql.Date;
import java.util.ArrayList;

import PatientManagement.Catalogs.Limits;
import PatientManagement.Catalogs.VitalSignsCatalog;
import PatientManagement.Clinic.Clinic;
import PatientManagement.Clinic.Event;
import PatientManagement.Clinic.Site;
import PatientManagement.Patient.Patient;
import PatientManagement.Patient.ClinicalHistory.Vaccination;
import PatientManagement.Patient.ClinicalHistory.VaccinationHistory;
import PatientManagement.Patient.ClinicalHistory.Vaccine;

/**
 *
 * @author kal bugrara
 * 
 */
// vorder = encounter.newVaccinationOrder();
// vacorder.newVaccination();

public class Encounter {
    Clinic clinic;
    Patient patient;
    String chiefComplaint;
    Diagnosis diagnosis;
    Event event;
    VitalSigns vitalSigns;
    EncounterHistory encounterHistory;
    Vaccination vaccination;
    VaccinationHistory vaccinationHistory;
    String visitDate;
    Site site;
    // vital signs
    // orders: assessmentorders, ....

    public Encounter(Patient p, String cc, Event ev, Clinic c, Site s, String date) { // event is the date when the check was made
        chiefComplaint = cc;
        event = ev;
        patient = p;
        clinic = c;
        site = s;
        visitDate = date;
        vitalSigns = new VitalSigns(patient, this);
        encounterHistory = new EncounterHistory(p, c);
        vaccinationHistory = new VaccinationHistory(p);

    }

    public String getChiefComplaint(){
        return chiefComplaint;
    }

    public Diagnosis newDiagnosis(String diseasetype, Condition con, boolean confirmed) {
        diagnosis = new Diagnosis(diseasetype, con, confirmed);
        return diagnosis;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }


    public Patient getPatient() {
        return patient;
    }

    public Limits getVitalSignLimits(int age, String name) {
        Clinic clinic = encounterHistory.getPatient().getClinic(); // 上边encounterHistory若没有初始化，则会报错
        VitalSignsCatalog vsc = clinic.getVitalSignsCatalog();
        return vsc.findVitalSignLimits(age, name);
    }


    public VitalSignMetric addNewVitals(String name, int value) {
        return vitalSigns.addNewVitals(name, value);
    }

    public EncounterHistory getEncounterHistory(){
        return encounterHistory;
    }

    public Vaccination addNewVaccination(Vaccine v, String date){
        return vaccination;
    }

    public VaccinationHistory getVaccinationHistory(){
        return vaccinationHistory;
    }

    public String getSiteName(){
        return site.getSitename();
    }

    public boolean areVitalsNormal(){
        return vitalSigns.areNormal();
    }

    public String getVisitDate(){
        return visitDate;
    }

    public VitalSigns getVitalSigns(){
        return vitalSigns;
    }

    public ArrayList<Encounter> getEncounters(){
        return encounterHistory.getEncounterList();
    }

    public void printVisitInfo() {
        // System.out.println("------------------------");
        System.out.println("Visit Details: ");
        System.out.println("   --> Visit Date: " + this.getVisitDate());
        System.out.println("   --> Visit Site: " + this.getSiteName());
        System.out.println("Vital Signs: ");
        this.getVitalSigns().printVitalSignsDetail();
    }


}