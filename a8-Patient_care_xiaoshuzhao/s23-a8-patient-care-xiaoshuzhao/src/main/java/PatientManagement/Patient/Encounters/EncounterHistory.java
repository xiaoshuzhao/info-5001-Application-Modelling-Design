/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Patient.Encounters;

import PatientManagement.Clinic.Clinic;
import PatientManagement.Clinic.Event;
import PatientManagement.Clinic.Site;
import PatientManagement.Patient.Patient;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kal bugrara
 */
public class EncounterHistory {
    Clinic clinic;
    ArrayList<Encounter> encounters;
    Patient patient;
    Encounter currentEncounter;
    

    public EncounterHistory(Patient p, Clinic c) {
        patient = p;
        clinic = c;
        encounters = new ArrayList<Encounter>();
    }

    // each encounter must link to the event at the site
    public Encounter newEncounter(String chiefcomplaint, Event ev, Site s, String date) {
        Encounter e = new Encounter(patient, chiefcomplaint, ev, clinic, s, date);
        encounters.add(e);
        return e;
    }


    public ArrayList<Encounter> getEncounterList() {
        return encounters;
    }

    public Patient getPatient(){
        return patient;
    }

    public void printDiagnosis(Encounter e){
        System.out.print(e.getDiagnosis().getCondition().toString());
    }


}
