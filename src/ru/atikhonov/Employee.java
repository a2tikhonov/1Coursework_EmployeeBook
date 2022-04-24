package ru.atikhonov;

public class Employee {
    public static int counter = 1;
    private String firstName;
    private String middleName;
    private String lastName;
    private int department;
    private int salary;
    private int id;

    Employee(String lastName, String firstName, String middleName, int department, int salary) {
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
