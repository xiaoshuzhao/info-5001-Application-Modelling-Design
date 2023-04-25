/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Clinic;

/**
 *
 * @author kal bugrara
 */
public class Location {
    String locationName;
    LocationList locationList;
    SiteCatalog siteCatalog;

    public Location(String name) {
        locationName = name;
        
    }

    public void setSiteCatalog(SiteCatalog siteCatalog){
        this.siteCatalog = siteCatalog;
    }

    public SiteCatalog getSiteCatalog(){
        return siteCatalog;
    }

    public String getLocationName() {
        return locationName;
    }

    public LocationList getLocationList() {
        return locationList;
    }




}
