/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Patient.Orders;

import PatientManagement.Patient.ClinicalHistory.Vaccination;
import PatientManagement.Patient.ClinicalHistory.Vaccine;

import java.sql.Date;

import PatientManagement.Patient.Patient;

/**
 *
 * @author kal bugrara
 */
public class VaccinationOrder extends Order {
    Vaccine vaccine;
    Patient patient;
    Date date;
    Vaccination vaccination;
    String location;

    public VaccinationOrder(Patient p, Vaccine v, Date date, String location) {
        super();
        vaccine = v;
        this.date = date;
        this.location = location;

    }

    // getter & setter 方法

    // public Vaccination newVaccination() {

    //     if (vaccination == null)
    //         vaccination = new Vaccination();
    //     return vaccination;

    // }

}
