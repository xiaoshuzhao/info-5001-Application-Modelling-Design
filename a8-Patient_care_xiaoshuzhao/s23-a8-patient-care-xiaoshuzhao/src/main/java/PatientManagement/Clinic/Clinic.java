/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Clinic;

import java.sql.Date;
import java.util.ArrayList;

import PatientManagement.Catalogs.Drug;
import PatientManagement.Catalogs.DrugCatalog;
import PatientManagement.Catalogs.DrugInventory;
import PatientManagement.Catalogs.VitalSignsCatalog;
import PatientManagement.Patient.Patient;
import PatientManagement.Patient.Encounters.Encounter;
import PatientManagement.Patient.Encounters.EncounterHistory;
import PatientManagement.Persona.Person;
import PatientManagement.Persona.PersonDirectory;

/**
 *
 * @author kal bugrara
 */
public class Clinic {
    PatientDirectory patientdirectory;
    PersonDirectory persondirectory;
    EncounterHistory encounterHistory;
    Encounter encounter;
    SiteCatalog sitelist;
    LocationList locationlist;
    DrugCatalog drugcatalog;
    EventSchedule eventschedule;
    VitalSignsCatalog vitalSignsCatalog;
    String name; // name of the clinic
    ArrayList<DrugInventory> drugInventories;

    public Clinic(String n) {
        eventschedule = new EventSchedule();
        locationlist = new LocationList(this);
        persondirectory = new PersonDirectory();
        patientdirectory = new PatientDirectory(this);
        vitalSignsCatalog = new VitalSignsCatalog();
        name = n;
        drugInventories = new ArrayList<DrugInventory>();
    }

    public SiteCatalog getSiteCatalog() {
        return sitelist;
    }

    public LocationList getLocationList() {
        return locationlist;
    }

    public ArrayList<Encounter> getEncounterList() {
        return encounterHistory.getEncounterList();
    }

    public Site newSite(Location location) {

        Site s = sitelist.newSite(name, location);
        return s;
    }

    public VitalSignsCatalog getVitalSignsCatalog() {
        return vitalSignsCatalog;
    }

    public void addDrugToInventory(Drug drug, Date arrivalDate, int quantity) {
        DrugInventory drugInventory = new DrugInventory(drug, arrivalDate, quantity, this);
        drugInventories.add(drugInventory);
    }

    public ArrayList<DrugInventory> getDrugInventories() {
        return drugInventories;
    }


    public PersonDirectory getPersonDirectory(){
        return persondirectory;
    }

    public PatientDirectory getPatientDirectory(){
        return patientdirectory;
    }

    public Patient searchPatientByName(String name){
        Patient p = patientdirectory.searchPatientByName(name);
        return p;
    }

    public EventSchedule getEventSchedule() {
        return eventschedule;
    }

}
