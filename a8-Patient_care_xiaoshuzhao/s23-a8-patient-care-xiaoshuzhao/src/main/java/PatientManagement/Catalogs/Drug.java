/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagement.Catalogs;

/**
 *
 * @author kal bugrara
 */
public class Drug {
    String name;
    String dosage;
    String usage;


    public Drug(String n, String dos, String usage) {
        name = n;
        dosage = dos;
        this.usage = usage;
    }

    public String getName(){
        return name;
    }

    public String getDosage(){
        return dosage;
    }

    public String getUsage(){
        return dosage;
    }

}
