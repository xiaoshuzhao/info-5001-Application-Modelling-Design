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
public class LocationList {
    ArrayList<Location> locations;
    Clinic clinic;
    SiteCatalog siteCatalog;

    public LocationList(Clinic c) {
        clinic = c;
        locations = new ArrayList<Location>();
    }

    public ArrayList<Location> getLocation(){
        return locations;
    }

    public Location newLocation(Location l){
        locations.add(l);
        return l;
    }

    public Location getLocation(String locname) {
        // search for a location object by locname;
        for (Location l : locations){
            if (locname.equals(l.getLocationName())){
                return l;
            }
        }
        return null;
    }

}
