package PatientManagement.Persona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {
    ArrayList<Person> personlist;
    ArrayList<Person> familyList;

    public PersonDirectory() {
        personlist = new ArrayList<Person>();
    }

    public Person newPerson(Person person) {
        // Person p = new Person(id, age);
        personlist.add(person);
        return person;
    }

    public Person findPersonById(String id) {

        for (Person p : personlist) {
            if (p.isMatchId(id)) {
                return p;
            }
        }
        return null; // not found after going through the whole list
    }

    public Person findPersonByName(String firstName) {

        for (Person p : personlist) {
            if (p.isMatchName(firstName)) {
                return p;
            }
        }
        return null; 
    }


}
