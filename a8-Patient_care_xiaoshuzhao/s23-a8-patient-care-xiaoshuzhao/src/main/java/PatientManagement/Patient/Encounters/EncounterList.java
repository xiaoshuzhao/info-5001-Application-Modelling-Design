package PatientManagement.Patient.Encounters;

import java.util.ArrayList;

public class EncounterList {
    ArrayList<Encounter> encounters;

    public EncounterList(){
        encounters = new ArrayList<Encounter>();
    }

    public Encounter addEncounter(Encounter en){
        encounters.add(en);
        return en;
    }

    public ArrayList<Encounter> getEncounters(){
        return encounters;
    }
}
