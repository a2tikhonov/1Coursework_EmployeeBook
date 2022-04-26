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
//        if(department == 0) throw new IllegalArgumentException("Номер отдела не может быть меньше 1");
//        if(firstName == "") throw new IllegalArgumentException("Вы не ввели имя сотрудника");
//        if(lastName == "") throw new IllegalArgumentException("Вы не ввели фамилию сотрудника");
//        if(middleName == "") throw new IllegalArgumentException("Вы не ввели отчество сотрудника");
//        if(salary < 50_000) throw new IllegalArgumentException("Введите корректное значение зп");
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName;
    }

    @Override
    public boolean equals(Object object) {
        if (this.getClass() != object.getClass()) return false;
        return lastName.equals(((Employee) object).lastName) && firstName.equals(((Employee) object).firstName) && middleName.equals(((Employee) object).middleName);
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
        if(department == 0) throw new IllegalArgumentException("Номер отдела не может быть меньше 1");
        this.department = department;
    }

    public void setSalary(int salary) {
        if(salary < 50_000) throw new IllegalArgumentException("Введите корректное значение зп");
        this.salary = salary;
    }

}
