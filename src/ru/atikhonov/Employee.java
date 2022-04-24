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
        if(department == 0) throw new RuntimeException("Номер отдела не может быть меньше 1");
        if(firstName == "") throw new RuntimeException("Вы не ввели имя сотрудника");
        if(lastName == "") throw new RuntimeException("Вы не ввели фамилию сотрудника");
        if(middleName == "") throw new RuntimeException("Вы не ввели отчество сотрудника");
        if(salary < 50_000) throw new RuntimeException("Введите корректное значение зп");
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
        if(department == 0) throw new RuntimeException("Номер отдела не может быть меньше 1");
        this.department = department;
    }

    public void setSalary(int salary) {
        if(salary < 50_000) throw new RuntimeException("Введите корректное значение зп");
        this.salary = salary;
    }

}
