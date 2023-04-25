
import java.nio.channels.NetworkChannel;
import java.util.ArrayList;

import PatientManagement.Catalogs.AgeGroup;
import PatientManagement.Catalogs.VitalSignLimits;
import PatientManagement.Catalogs.VitalSignsCatalog;
import PatientManagement.Clinic.Clinic;
import PatientManagement.Clinic.Event;
import PatientManagement.Clinic.EventSchedule;
import PatientManagement.Clinic.Location;
import PatientManagement.Clinic.LocationList;
import PatientManagement.Clinic.PatientDirectory;
import PatientManagement.Clinic.Site;
import PatientManagement.Clinic.SiteCatalog;
import PatientManagement.Patient.Patient;
import PatientManagement.Patient.ClinicalHistory.Vaccination;
import PatientManagement.Patient.ClinicalHistory.VaccinationHistory;
import PatientManagement.Patient.ClinicalHistory.Vaccine;
import PatientManagement.Patient.Encounters.Condition;
import PatientManagement.Patient.Encounters.Diagnosis;
import PatientManagement.Patient.Encounters.Encounter;
import PatientManagement.Patient.Encounters.EncounterList;
import PatientManagement.Patient.Encounters.VitalSignMetric;
import PatientManagement.Persona.Person;
import PatientManagement.Persona.PersonDirectory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kal bugrara
 */

public class ClinicalCareMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Clinic clinic = new Clinic("seattle");
        
        // add vital signs
        VitalSignsCatalog vsc = clinic.getVitalSignsCatalog();
        AgeGroup adults41_60 = vsc.newAgeGroup("Middle Adult",80, 41); 
        AgeGroup adults21_40 = vsc.newAgeGroup("Adult",40, 20);   // bug
        AgeGroup Adolescence13_20 = vsc.newAgeGroup("Adolescence",21, 12); 
        AgeGroup children6_12 = vsc.newAgeGroup("Adult",13, 5); 
        VitalSignLimits heartRateLimits = vsc.newVitalSignLimits("Heart Rate");
        VitalSignLimits bloodPressureLimits = vsc.newVitalSignLimits("Blood Pressure");
        VitalSignLimits respiratoryLimits = vsc.newVitalSignLimits("Respiratory Rate");
        VitalSignLimits temperatureLimits = vsc.newVitalSignLimits("Temperature");
        heartRateLimits.addLimits(adults41_60, 105, 55);
        heartRateLimits.addLimits(adults21_40, 105, 55);
        heartRateLimits.addLimits(Adolescence13_20, 110, 70);
        heartRateLimits.addLimits(children6_12, 130, 80);
        bloodPressureLimits.addLimits(adults41_60, 120, 80);
        bloodPressureLimits.addLimits(adults21_40, 120, 80);
        bloodPressureLimits.addLimits(Adolescence13_20, 120, 100);
        bloodPressureLimits.addLimits(children6_12, 120, 80);
        respiratoryLimits.addLimits(adults41_60, 20, 16);
        respiratoryLimits.addLimits(adults21_40, 20, 16);
        respiratoryLimits.addLimits(Adolescence13_20, 20, 12);
        respiratoryLimits.addLimits(children6_12, 30, 20);
        temperatureLimits.addLimits(adults41_60, 99, 98);
        temperatureLimits.addLimits(adults21_40, 99, 98);
        temperatureLimits.addLimits(Adolescence13_20, 99, 98);
        temperatureLimits.addLimits(children6_12, 99, 96);



        PersonDirectory pd = clinic.getPersonDirectory();
        Person christopher = new Person("156", "Christopher", "Reynolds", "5-12-1998", 21, "Male", "westLake", "206-000-5582");
        Person emma = new Person("015", "Emma", "Davis", "6-14-2008", 13, "Female", "westLake", "206-555-5555");
        Person michael = new Person("016", "Michael", "Perez", "10-5-2004", 17, "Male", "gatewood", "206-666-6666");
        Person samantha = new Person("017", "Samantha", "Rodriguez", "3-21-2001", 20, "Female", "Gatewood", "206-777-7777");
        Person jennifer = new Person("019", "Jennifer", "Kim", "8-25-1979", 42, "Female", "Lake City", "206-999-9999");
        Person richard = new Person("020", "Richard", "Wong", "4-6-1961", 60, "Male", "Magnolia", "206-000-0000");
        Person margaret = new Person("021", "Margaret", "Scott", "1-23-1976", 45, "Female", "Phinney Ridge", "206-111-1111");
        Person joseph = new Person("022", "Joseph", "Allen", "12-16-1969", 51, "Male", "Bellevue", "206-222-2222");
        Person olivia = new Person("011", "Olivia", "Jones", "9-3-2015", 6, "Female", "Madison Park", "206-111-1111");
        Person noah = new Person("012", "Noah", "Smith", "1-10-2010", 11, "Male", "Kirkland", "206-222-2222");
        Person isabella = new Person("013", "Isabella", "Hernandez", "7-18-2012", 9, "Female", "Leschi", "206-333-3333");
        Person sugar = new Person("123", "Lucia", "zhao", "01-01-2000", 23, "Female", "Kirkland", "206-000-0000");
        Person sugardaddy = new Person("124", "David", "zhang", "02-15-1980", 433, "Male", "Kirkland", "206-000-5482");
        pd.newPerson(sugar);
        pd.newPerson(christopher);
        sugar.setFather(sugardaddy);

        PatientDirectory patientDirectory = clinic.getPatientDirectory();
        Patient sugarPatient = patientDirectory.newPatient(sugar);
        Patient christopherPatient = patientDirectory.newPatient(christopher);
        Patient emmaPatient = patientDirectory.newPatient(emma);
        Patient michaelPatient = patientDirectory.newPatient(michael);
        Patient samanthaPatient = patientDirectory.newPatient(samantha);
        Patient jenniferPatient = patientDirectory.newPatient(jennifer);
        Patient richardPatient = patientDirectory.newPatient(richard);
        Patient margaretPatient = patientDirectory.newPatient(margaret);
        Patient josephPatient = patientDirectory.newPatient(joseph);
        Patient oliviaPatient = patientDirectory.newPatient(olivia);
        Patient noahPatient = patientDirectory.newPatient(noah);
        Patient isabellaPatient = patientDirectory.newPatient(isabella);

        


        // create a new Location - "Seattle"
        LocationList seattleList = clinic.getLocationList();
        
        Location middleSeattleLLoc = new Location("SeattleCenter");
        Location westSeattleLoc = new Location("West of Seattle");
        Location eastSeattleLoc = new Location("East of Seattle");
        seattleList.newLocation(middleSeattleLLoc);
        seattleList.newLocation(westSeattleLoc);
        seattleList.newLocation(eastSeattleLoc);



        // Seattle includes a seattleSits catalog
        SiteCatalog midSeattleSites = new SiteCatalog();
        middleSeattleLLoc.setSiteCatalog(midSeattleSites);
        Site downtownSite = midSeattleSites.newSite("downtown", middleSeattleLLoc);
        Site westLakeSite = midSeattleSites.newSite("westLake", middleSeattleLLoc);
        downtownSite.addInFectedPatient(sugarPatient);
        westLakeSite.addInFectedPatient(christopherPatient);
        
        SiteCatalog westSeattleSites = new SiteCatalog();
        westSeattleLoc.setSiteCatalog(westSeattleSites);
        Site gatewoodSite = westSeattleSites.newSite("Gatewood", westSeattleLoc);
        gatewoodSite.addInFectedPatient(emmaPatient);
        gatewoodSite.addInFectedPatient(michaelPatient);
        gatewoodSite.addInFectedPatient(samanthaPatient);
        
        SiteCatalog eastSeattleSites = new SiteCatalog();
        eastSeattleLoc.setSiteCatalog(eastSeattleSites);
        Site bellevueSite = eastSeattleSites.newSite("Bellevue", eastSeattleLoc);
        Site kirklandSite = eastSeattleSites.newSite("Kirkland ", eastSeattleLoc);
        bellevueSite.addInFectedPatient(jenniferPatient);
        bellevueSite.addInFectedPatient(richardPatient);
        kirklandSite.addInFectedPatient(margaretPatient);
        kirklandSite.addInFectedPatient(josephPatient);
        kirklandSite.addInFectedPatient(oliviaPatient);
        kirklandSite.addInFectedPatient(noahPatient);
        kirklandSite.addInFectedPatient(isabellaPatient);

        
        // add a covidEvent in downtownSite
        EventSchedule covidEventSchedule = new EventSchedule();
        EventSchedule dailyEventSchedule = new EventSchedule();
        Event communityEvent = new Event(downtownSite, "Community2023", "CommunityService");
        Event supportEvent01 = new Event(westLakeSite, "Support2023", "localSupport");
        Event supportEvent02 = new Event(gatewoodSite, "Support2023", "localSupport");
        Event supportEvent03 = new Event(bellevueSite, "Support2023", "localSupport");
        Event supportEvent04 = new Event(kirklandSite, "Support2023", "localSupport");
        covidEventSchedule.newEvent(communityEvent);
        dailyEventSchedule.newEvent(supportEvent01);
        dailyEventSchedule.newEvent(supportEvent02);
        dailyEventSchedule.newEvent(supportEvent03);
        dailyEventSchedule.newEvent(supportEvent04);

        //
        EncounterList encounterList = new EncounterList();
        Condition sugarCovidCondition = new Condition(sugarPatient, "Covid", "have a faver", "a week");
        Encounter sugarVisitToDoctor = sugarPatient.newEncounter("Covid", communityEvent, downtownSite, "4-23-2023");
        encounterList.addEncounter(sugarVisitToDoctor);
        Diagnosis sugarDiagnosis = sugarVisitToDoctor.newDiagnosis("infectious", sugarCovidCondition, true);

        Condition chirstopherCondition = new Condition(christopherPatient, "Influenza", "cough, sore throat, runny or stuffy nose", "last for 5-7 days");
        Encounter chirstopherVisitToDoctor = christopherPatient.newEncounter("Influenza", supportEvent01, westLakeSite, "4-01-2023");
        encounterList.addEncounter(chirstopherVisitToDoctor);
        Diagnosis chirstopherDiagnosis = chirstopherVisitToDoctor.newDiagnosis("seasonal", chirstopherCondition, true);

        Condition emmaCondition = new Condition(emmaPatient, "Covid", "fever, cough, loss of taste or smell", "last for 3 days");
        Encounter emmaVisitToDoctor = emmaPatient.newEncounter("Covid", supportEvent02, gatewoodSite, "2-10-2023");
        encounterList.addEncounter(emmaVisitToDoctor);
        Diagnosis emmaDiagnosis = emmaVisitToDoctor.newDiagnosis("infectious", emmaCondition, true);

        Condition michaelCondition = new Condition(michaelPatient, "Tuberculosis", "a long-lasting cough, chest pain, difficulty breathing", "last for 3 days");
        Encounter michaelVisitToDoctor = michaelPatient.newEncounter("Tuberculosis", supportEvent02, gatewoodSite, "2-05-2023");
        encounterList.addEncounter(michaelVisitToDoctor);
        Diagnosis michaelDiagnosis = michaelVisitToDoctor.newDiagnosis("infectious", michaelCondition, true);
        
        Condition samanthaCondition = new Condition(samanthaPatient, "Headache", "aching pain or pressure in the head", "vary often");
        Encounter samanthaVisitToDoctor = samanthaPatient.newEncounter("Headache", supportEvent02, gatewoodSite, "3-6-2023");
        encounterList.addEncounter(samanthaVisitToDoctor);
        Diagnosis samanthaDiagnosis = samanthaVisitToDoctor.newDiagnosis("common", samanthaCondition, true);

        Condition jenniferCondition = new Condition(jenniferPatient, "Asthma", "wheezing, coughing, chest tightness, and difficulty breathing", "last for minutes to hours");
        Encounter jenniferVisitToDoctor = jenniferPatient.newEncounter("Asthma", supportEvent03, bellevueSite, "2-18-2023");
        encounterList.addEncounter(jenniferVisitToDoctor);
        Diagnosis jenniferDiagnosis = jenniferVisitToDoctor.newDiagnosis("hereditary", jenniferCondition, true);

        Condition richardCondition = new Condition(richardPatient, "Covid", "wheezing, coughing, chest tightness, and difficulty breathing", "last for two weeks");
        Encounter richardVisitToDoctor = richardPatient.newEncounter("Covid", supportEvent03, bellevueSite, "2-25-2023");
        encounterList.addEncounter(richardVisitToDoctor);
        Diagnosis richardDiagnosis = richardVisitToDoctor.newDiagnosis("infectious", richardCondition, true);
        
        Condition margaretCondition = new Condition(margaretPatient, "Tuberculosis", "difficulty breathing, fever, and night sweats", "last for several months");
        Encounter margaretVisitToDoctor = margaretPatient.newEncounter("Tuberculosis", supportEvent04, kirklandSite, "4-13-2023");
        encounterList.addEncounter(margaretVisitToDoctor);
        Diagnosis margaretDiagnosis = margaretVisitToDoctor.newDiagnosis("infectious", margaretCondition, true);

        Condition josephCondition = new Condition(josephPatient, "Influenza", "runny or stuffy nose, body aches", "last for 5 weeks");
        Encounter josephVisitToDoctor = josephPatient.newEncounter("Influenza", supportEvent04, kirklandSite, "3-16-2023");
        encounterList.addEncounter(josephVisitToDoctor);
        Diagnosis josephDiagnosis = josephVisitToDoctor.newDiagnosis("seasonal", josephCondition, true);

        Condition oliviaCondition = new Condition(oliviaPatient, "Influenza", "fatigue", "last for 2 days");
        Encounter oliviaVisitToDoctor = oliviaPatient.newEncounter("Influenza", supportEvent04, kirklandSite, "3-9-2023");
        encounterList.addEncounter(oliviaVisitToDoctor);
        Diagnosis oliviaDiagnosis = oliviaVisitToDoctor.newDiagnosis("seasonal", oliviaCondition, true);

        Condition noahCondition = new Condition(noahPatient, "Covid", "body aches, sore throat", "last for 7 hours");
        Encounter noahVisitToDoctor = noahPatient.newEncounter("Covid", supportEvent04, kirklandSite, "4-14-2023");
        encounterList.addEncounter(noahVisitToDoctor);
        Diagnosis noahDiagnosis = noahVisitToDoctor.newDiagnosis("infectious", noahCondition, true);

        Condition isabellaCondition = new Condition(isabellaPatient, "Covid", "shortness of breath, fatigue, muscle", "last for one night");
        Encounter isabellaVisitToDoctor = isabellaPatient.newEncounter("Covid", supportEvent04, kirklandSite, "4-3-2023");
        encounterList.addEncounter(isabellaVisitToDoctor);
        Diagnosis isabellaDiagnosis = isabellaVisitToDoctor.newDiagnosis("infectious", isabellaCondition, true);


        Vaccine covidVaccine01 = new Vaccine("Comirnaty", 100, clinic);
        sugarVisitToDoctor.addNewVaccination(covidVaccine01, "2-10-2023");
        emmaVisitToDoctor.addNewVaccination(covidVaccine01, "2-10-2023");
        richardVisitToDoctor.addNewVaccination(covidVaccine01, "2-10-2023");
        noahVisitToDoctor.addNewVaccination(covidVaccine01, "2-10-2023");
        isabellaVisitToDoctor.addNewVaccination(covidVaccine01, "2-10-2023");

        Vaccine influenzaVaccine01 = new Vaccine("trivalent influenza vaccine", 50, clinic);
        chirstopherVisitToDoctor.addNewVaccination(influenzaVaccine01, "4-02-2023");
        josephVisitToDoctor.addNewVaccination(influenzaVaccine01, "2-10-2023");
        oliviaVisitToDoctor.addNewVaccination(influenzaVaccine01, "2-10-2023");

        Vaccine tuberculosisVaccine01 = new Vaccine("BCG vaccine", 20, clinic);
        michaelVisitToDoctor.addNewVaccination(tuberculosisVaccine01, "2-05-2023");
        margaretVisitToDoctor.addNewVaccination(tuberculosisVaccine01, "2-10-2023");


        VitalSignMetric sugarHeartVitals = sugarVisitToDoctor.addNewVitals("Heart Rate", 100);
        VitalSignMetric sugarLatestVitalsBlood = sugarVisitToDoctor.addNewVitals("Blood Pressure", 90);
        VitalSignMetric sugarLatestVitalsRespiratory = sugarVisitToDoctor.addNewVitals("Respiratory Rate", 16);

        VitalSignMetric chHeartVitals = chirstopherVisitToDoctor.addNewVitals("Heart Rate", 100);
        VitalSignMetric chLatestVitalsBlood = chirstopherVisitToDoctor.addNewVitals("Blood Pressure", 90);
        VitalSignMetric chTemperature = chirstopherVisitToDoctor.addNewVitals("Temporature", 99);

        VitalSignMetric emmaHeartVitals = emmaVisitToDoctor.addNewVitals("Heart Rate", 110);
        VitalSignMetric emmaLatestVitalsBlood = emmaVisitToDoctor.addNewVitals("Blood Pressure", 80);
        VitalSignMetric emmaVitalsRespiratory = emmaVisitToDoctor.addNewVitals("Respiratory Rate", 96);

        VitalSignMetric miHeartVitals = michaelVisitToDoctor.addNewVitals("Heart Rate", 112);
        VitalSignMetric miBlood = michaelVisitToDoctor.addNewVitals("Blood Pressure", 86);
        VitalSignMetric miVitalsRespiratory = michaelVisitToDoctor.addNewVitals("Respiratory Rate", 15);
        VitalSignMetric miTemperature = michaelVisitToDoctor.addNewVitals("Temporature", 98);

        VitalSignMetric saHeartVitals = samanthaVisitToDoctor.addNewVitals("Heart Rate", 102);
        VitalSignMetric saBlood = samanthaVisitToDoctor.addNewVitals("Blood Pressure", 80);
        VitalSignMetric saVitalsRespiratory = samanthaVisitToDoctor.addNewVitals("Respiratory Rate", 15);
        VitalSignMetric saTemperature = samanthaVisitToDoctor.addNewVitals("Temporature", 99);
        
        VitalSignMetric jeHeartVitals = jenniferVisitToDoctor.addNewVitals("Heart Rate", 102);
        VitalSignMetric jeBlood = jenniferVisitToDoctor.addNewVitals("Blood Pressure", 80);
        VitalSignMetric jeVitalsRespiratory = jenniferVisitToDoctor.addNewVitals("Respiratory Rate", 11);
        VitalSignMetric jeTemperature = jenniferVisitToDoctor.addNewVitals("Temporature", 98);

        VitalSignMetric riHeartVitals = richardVisitToDoctor.addNewVitals("Heart Rate", 120);
        VitalSignMetric riBlood = richardVisitToDoctor.addNewVitals("Blood Pressure",90);
        VitalSignMetric riVitalsRespiratory = richardVisitToDoctor.addNewVitals("Respiratory Rate", 13);
        VitalSignMetric riTemperature = richardVisitToDoctor.addNewVitals("Temporature", 99);

        VitalSignMetric maHeartVitals = margaretVisitToDoctor.addNewVitals("Heart Rate", 77);
        VitalSignMetric maBlood = margaretVisitToDoctor.addNewVitals("Blood Pressure", 78);
        VitalSignMetric maVitalsRespiratory = margaretVisitToDoctor.addNewVitals("Respiratory Rate", 12);
        VitalSignMetric maTemperature = margaretVisitToDoctor.addNewVitals("Temporature", 97);

        VitalSignMetric joHeartVitals = josephVisitToDoctor.addNewVitals("Heart Rate", 113);
        VitalSignMetric joBlood = josephVisitToDoctor.addNewVitals("Blood Pressure", 89);
        VitalSignMetric joVitalsRespiratory = josephVisitToDoctor.addNewVitals("Respiratory Rate", 10);
        VitalSignMetric joTemperature = josephVisitToDoctor.addNewVitals("Temporature", 99);

        VitalSignMetric olHeartVitals = oliviaVisitToDoctor.addNewVitals("Heart Rate", 128);
        VitalSignMetric olBlood = oliviaVisitToDoctor.addNewVitals("Blood Pressure", 70);
        VitalSignMetric olVitalsRespiratory = oliviaVisitToDoctor.addNewVitals("Respiratory Rate", 15);
        VitalSignMetric olTemperature = oliviaVisitToDoctor.addNewVitals("Temporature", 98);

        VitalSignMetric noHeartVitals = noahVisitToDoctor.addNewVitals("Heart Rate", 130);
        VitalSignMetric noBlood = noahVisitToDoctor.addNewVitals("Blood Pressure", 60);
        VitalSignMetric noVitalsRespiratory = noahVisitToDoctor.addNewVitals("Respiratory Rate", 9);
        VitalSignMetric noTemperature = noahVisitToDoctor.addNewVitals("Temporature", 100);

        VitalSignMetric isaHeartVitals = isabellaVisitToDoctor.addNewVitals("Heart Rate", 131);
        VitalSignMetric isaHlood = isabellaVisitToDoctor.addNewVitals("Blood Pressure", 80);
        VitalSignMetric isaVitalsRespiratory = isabellaVisitToDoctor.addNewVitals("Respiratory Rate", 15);
        VitalSignMetric isaTemperature = isabellaVisitToDoctor.addNewVitals("Temporature", 103);
        




///////////////////////////////////////////////-----PRINT------//////////////////////////////////////////////////////////////////

        // print patient information 
        ArrayList<Encounter> encounters = encounterList.getEncounters();
        int covidSum = 0, influenzaSum = 0, tuberculosisSum = 0, asthmaSum = 0, headacheSum = 0;
        int index = 1;
        for (Encounter en : encounters){
            System.out.println("                                         ");
            System.out.println("-------------- Patient " + index + " --------------");
            index++;
            en.getPatient().printPatientInfo();
            en.getDiagnosis().printCondition();

            // print vaccination
            if (en.getChiefComplaint() == "Covid"){
                covidSum += 1;
                System.out.println("Vaccination name: " + covidVaccine01.getVaccineName());
            } else if (en.getChiefComplaint() == "Tuberculosis"){
                tuberculosisSum += 1;
                System.out.println("Vaccination name: " + tuberculosisVaccine01.getVaccineName());
            } else if (en.getChiefComplaint() == "Influenza"){
                influenzaSum += 1;
                System.out.println("Vaccination name: " + influenzaVaccine01.getVaccineName());
            } else if (en.getChiefComplaint() == "Asthma"){
                asthmaSum += 1;
                System.out.println("It's commen symptem, You don't have to take vaccination.");
            } else if (en.getChiefComplaint() == "Headache"){
                headacheSum += 1;
                System.out.println("It's commen symptem, You don't have to take vaccination.");
            }

            // patient visit info
            en.printVisitInfo();
            if (en.getDiagnosis().getCategory() == "infectious" && en.getDiagnosis().isConfirmed() == true){
                System.out.println("Warnning:  This patient needs immediate treatment, please check the contagious range.");
            }
            // patient address
            if (en.getPatient().getPerson().getAddress() != en.getSiteName()){
                System.out.println("This patient is from " + " ' " + en.getPatient().getPerson().getAddress() + " '");
            }

        }

        // print patient number in different catagory
        System.out.println("                                         ");
        System.out.println("-------------- Patient Number --------------");
        System.out.println("Total patient number: " + index);
        System.out.println("Number of patients for each disease: ");
        System.out.println("Covid: " + covidSum);
        System.out.println("Tuberculosis: " + tuberculosisSum);
        System.out.println("Influenza: " + influenzaSum);
        System.out.println("Asthma: " + asthmaSum);
        System.out.println("Headache: " + headacheSum);

        // print patient number in different sites
        ArrayList<Location> locations = seattleList.getLocation();
        System.out.println("                                         ");
        System.out.println("---------- Patient Number in each site ----------");
        for (Location l : locations){
            // System.out.println("                                         ");
            System.out.println("Location name --->  " + l.getLocationName());
            // System.out.println("Patient Number in each site: ");
            l.getSiteCatalog().printLocationInfo();
        }


    }

}
