package PatientManagement.Catalogs;

import java.sql.Date;

import PatientManagement.Clinic.Clinic;

public class DrugInventory {
    Drug drug;
    Date arrivalDate;
    int quantity;
    Clinic clinic;

    public DrugInventory(Drug drug, Date arrDate, int q, Clinic c){
        this.drug = drug;
        arrivalDate = arrDate;
        quantity = q;
        clinic = c;
    }

    public Drug getDrug(){
        return drug;
    }

    public Date getArrivalDate(){
        return arrivalDate;
    }

    public int getQuantity(){
        return quantity;
    }

    public Clinic getclinic(){
        return clinic;
    }

    public void setQuantity(int q){
        this.quantity = q;
    }
}
