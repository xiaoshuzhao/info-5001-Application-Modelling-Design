package PatientManagement.Employee;

import PatientManagement.Persona.Person;

public class Employee {
    Person person;
    String role;
    EmployeeDirectory employeeDirectory;

    public Employee(Person person, String role, EmployeeDirectory ed) {
        this.person = person;
        this.role = role;
        employeeDirectory = ed;
    }

    public Person getPerson() {
        return person;
    }

    public String getRole() {
        return role;
    }
}
