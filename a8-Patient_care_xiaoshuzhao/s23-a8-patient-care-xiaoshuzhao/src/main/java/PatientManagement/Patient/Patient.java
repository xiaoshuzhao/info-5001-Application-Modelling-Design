/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Patient;

import PatientManagement.Catalogs.Limits;
import PatientManagement.Catalogs.VitalSignsCatalog;
import PatientManagement.Clinic.Clinic;
import PatientManagement.Clinic.Event;
import PatientManagement.Clinic.PatientDirectory;
import PatientManagement.Clinic.Site;
import PatientManagement.Patient.ClinicalHistory.AlergyHistory;
import PatientManagement.Patient.ClinicalHistory.MedicationHistory;
import PatientManagement.Patient.ClinicalHistory.VaccinationHistory;
import PatientManagement.Patient.Encounters.Condition;
import PatientManagement.Patient.Encounters.Diagnosis;
import PatientManagement.Patient.Encounters.Encounter;
import PatientManagement.Patient.Encounters.EncounterHistory;
import PatientManagement.Persona.Person;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Patient {
    Clinic clinic;
    EncounterHistory encounterhistory;
    VaccinationHistory vachistory;
    Person person;
    AlergyHistory alergyhistory;
    MedicationHistory medications;
    Condition condition;

    public Patient(Person p, Clinic clinic) {
        encounterhistory = new EncounterHistory(this, clinic); // link this patient object back
        person = p;
        this.clinic = clinic;
        medications = new MedicationHistory();
    }

    public EncounterHistory getEncounterHistory() {
        return encounterhistory;
    }
    // the below method will return the encounter where the infection occured
    // from the returned encounter you pull the event, the site, etc.

    public Encounter getConfirmedEncounter() {
        ArrayList<Encounter> patientencounterlist = encounterhistory.getEncounterList();

        for (Encounter currentencounter : patientencounterlist) {
            Diagnosis diag = currentencounter.getDiagnosis();
            if (diag.isConfirmed()) {
                return currentencounter;// send back the whole encounter so we extract event and site
            }
        }
        return null;
    }



    public boolean isConfirmedPositive() {

        ArrayList<Encounter> patientencounterlist = encounterhistory.getEncounterList();

        for (Encounter currentencounter : patientencounterlist) {
            Diagnosis diag = currentencounter.getDiagnosis();
            return diag.isConfirmed();

        }
        return false;
    }

    public Person getPerson(){
        return person;
    }

    public Clinic getClinic(){
        return clinic;
    }

    public Encounter newEncounter(String chiefcomplaint, Event ev, Site s, String date){
        return encounterhistory.newEncounter(chiefcomplaint, ev, s, date);
    }


    public void printPatientInfo(){
        System.out.println("Patient name: " + person.getPersonName());
        System.out.println("Patient Date of Birth: " + person.getPersonDoB());
        System.out.println("Patient age: " + person.getAge());
    }




}
