/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Clinic;

import java.util.HashSet;
import java.util.Set;

import PatientManagement.Patient.Patient;

/**
 *
 * @author kal bugrara
 */
public class Site {
    String siteName;
    SiteCatalog sites;
    Location location;
    Event event;
    Set<Patient> infectedPatients;
    int patientNumber;

    public Site(String name, Location loc, SiteCatalog sites) {
        siteName = name;
        location = loc;
        this.sites = sites;
        patientNumber = 0;
        infectedPatients = new HashSet<Patient>();

    }

    public void addInFectedPatient(Patient patient){
        infectedPatients.add(patient);
    }

    public boolean hasInfectedPatient(Patient patient) {
        return infectedPatients.contains(patient);
    }

    public int getInfectedPatientCount() {
        patientNumber = infectedPatients.size();
        return patientNumber;
    }

    public SiteCatalog getSites(){
        return sites;
    }

    public void setSites(SiteCatalog sites){
        this.sites = sites;
    }

    public String getSitename() {
        return siteName;
    }

    public void setSitename(String sitename) {
        this.siteName = sitename;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Event getEvent() {
        return event;
    }




}
