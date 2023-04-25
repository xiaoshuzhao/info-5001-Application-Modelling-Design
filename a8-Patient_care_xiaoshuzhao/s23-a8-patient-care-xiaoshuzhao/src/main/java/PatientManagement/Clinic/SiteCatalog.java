/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Clinic;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kal bugrara
 */
public class SiteCatalog {
    Clinic clinic;
    Location loc;
    ArrayList<Site> sites;

    public SiteCatalog(){
        this.sites = new ArrayList<>();
    }

    public Site newSite(String siteName, Location loc) {
        Site s = new Site(siteName, loc, this);
        sites.add(s);
        return s;
    }

    public String getSiteName(){
        for (Site s : sites){
            s.getSitename();
            System.out.println(getSiteName());
        }
        return null;
    }

    public int getSitesNumber(){
        return sites.size();
    }

    public void printLocationInfo(){
        
        for (Site s : sites){
            String siteName = s.getSitename();
            int patientNumber = s.getInfectedPatientCount();
            System.out.println(siteName + " : " + patientNumber);
        }
    }
}
