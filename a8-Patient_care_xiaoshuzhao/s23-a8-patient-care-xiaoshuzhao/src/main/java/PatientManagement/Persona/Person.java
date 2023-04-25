package PatientManagement.Persona;

import PatientManagement.Patient.Patient;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kal bugrara
 */
public class Person {

    String id;
    String firstName;
    String lastName;
    String dateOfBirth;
    String gender;
    Person mother;
    Person father;
    ArrayList<Person> siblings;
    ArrayList<Person> familyList;
    Patient patient;
    int age;
    String address;
    String contactInfo;


    public Person(String id, String firstName, String lastName, 
                String dateOfBirth, int a, String gender, String address, String contactInfo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        siblings = new ArrayList<Person>();
        age = a;
        this.gender = gender;
        this.address = address;
        this.contactInfo = contactInfo;
        familyList = new ArrayList<Person>();
    }

    public String getPersonId() {
        return id;
    }

    public String getPersonName() {
        return firstName;
    }

    public String getPersonDoB() {
        return dateOfBirth;
    }

    public void setFather(Person f) {
        father = f;
        updateFamilyList();
    }

    public void setMother(Person m) {
        mother = m;
        updateFamilyList();
    }

    public void addSibling(Person s) {
        if (siblings.contains(s))
            return; // sibling already in the arraylist
        siblings.add(s);
        updateFamilyList();
    }

    public ArrayList<Person> getFamilyList() {
        return familyList;
    }

    private void updateFamilyList() {
        familyList.clear();
        if (father != null) {
            familyList.add(father);
        }
        if (mother != null) {
            familyList.add(mother);
        }
        familyList.addAll(siblings);
    }

    public boolean isMatchId(String id) {
        if (getPersonId().equals(id))
            return true;
        return false;
    }

    public boolean isMatchName(String name) {
        if (getPersonName().equals(name))
            return true;
        return false;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void printPersonFamily(){
        // System.out.println("------------------------");
        System.out.println("Family Information :");
        for (Person p : familyList){
            String name = p.getPersonName();
            System.out.println("father : " + name);
            System.out.println("Contact Infomation : " + p.getContactInfo());
            System.out.println("Address : " + p.getAddress());
        }
    }
}
