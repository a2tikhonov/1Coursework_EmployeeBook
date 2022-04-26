package ru.atikhonov;

import java.text.DecimalFormat;
import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees;
    private int size;

    EmployeeBook(int maxNumberOfEmployees) {
        this.employees = new Employee[maxNumberOfEmployees];
    }

    public void addNewEmployee(String lastname, String firstName, String middleName, int department, int salary) {
        if (size >= employees.length) {
            System.out.println("Книга сотрудников заполнена. Сотрудник не добавлен");
            return;
        }
        employees[size++] = new Employee(lastname, firstName, middleName, department, salary);
    }

    public void addNewEmployee(Employee newEmployee) {
        if (size >= employees.length) {
            System.out.println("Книга сотрудников заполнена. Сотрудник не добавлен");
            return;
        }
        employees[size++] = newEmployee;
    }

    public void deleteEmployee(String lastName, String firstName, String middleName) {
        for (int i = 1; i <= size; i++) {
            if (employees[i - 1].getLastName().equals(lastName) && employees[i - 1].getFirstName().equals(firstName)
                    && employees[i - 1].getMiddleName().equals(middleName)) {
                Employee employeeToDelete;
                employeeToDelete = employees[i - 1];
                employees[i - 1] = null;
                if (i != employees.length)  System.arraycopy(employees, i , employees, i - 1, size - i);
                employees[size - 1] = null;
                size--;
                System.out.println(Arrays.toString(employees));
                System.out.println(employeeToDelete.toString() + " удален из книги");
                return;
            }
        }
        System.out.println(lastName + " " + firstName + " не найден в книге");
    }

    public void deleteEmployee(Employee employee) {
        for (int i = 1; i <= size; i++) {
            if (employee.equals(employees[i - 1])) {
                Employee employeeToDelete;
                employeeToDelete = employees[i - 1];
                employees[i - 1] = null;
                if (i != employees.length)  System.arraycopy(employees, i, employees, i - 1, size - i);
                employees[size - 1] = null;
                size--;
                System.out.println(Arrays.toString(employees));
                System.out.println(employeeToDelete.toString() + " удален из книги");
                return;
            }
        }
        System.out.println(employee.toString() + " не найден в книге");
    }

    public void changeEmployeeSalary(String lastName, String firstName, String middleName, int newSalary) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getLastName().equals(lastName) && employees[i].getFirstName().equals(firstName)
                    && employees[i].getMiddleName().equals(middleName)) employees[i].setSalary(newSalary);
        }
    }

    public void changeEmployeeDepartment(String lastName, String firstName, String middleName, int newDepartment) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getLastName().equals(lastName) && employees[i].getFirstName().equals(firstName)
                    && employees[i].getMiddleName().equals(middleName)) employees[i].setDepartment(newDepartment);
        }
    }

    public int calculateSalaryCosts() {
        int sumOfSalaries = 0;
        for (int i = 0; i < size; i++) {
            sumOfSalaries += employees[i].getSalary();
        }
        return sumOfSalaries;
    }

    public int calculateSalaryCosts(int department) {
        int sumOfSalaries = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == department) sumOfSalaries += employees[i].getSalary();
        }
        return sumOfSalaries;
    }

    public int findMinimumSalaryEmployee() {
        int minimumSalary = 0;
        int id = 0;
        for (int i = 0; i < size && minimumSalary == 0; i++) {
                minimumSalary = employees[i].getSalary();
                id = employees[i].getId();
        }
        for (int i = 0; i < size; i++) {
            if (minimumSalary > employees[i].getSalary()) {
                minimumSalary = employees[i].getSalary();
                id = employees[i].getId();
            }
        }
        return id;
    }

    public int findMinimumSalaryEmployee(int department) {
        int minimumSalary = 0;
        int id = 0;
        for (int i = 0; i < size && minimumSalary == 0; i++) {
            if (employees[i].getDepartment() == department) {
                minimumSalary = employees[i].getSalary();
                id = employees[i].getId();
            }
        }
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == department && minimumSalary > employees[i].getSalary()) {
                minimumSalary = employees[i].getSalary();
                id = employees[i].getId();
            }
        }
        return id;
    }

    public int findMaximumSalaryEmployee() {
        int maximumSalary = 0;
        int id = 0;
        for (int i = 0; i < size; i++) {
            if (maximumSalary < employees[i].getSalary()) {
                maximumSalary = employees[i].getSalary();
                id = employees[i].getId();
            }
        }
        return id;
    }

    public int findMaximumSalaryEmployee(int department) {
        int maximumSalary = 0;
        int id = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == department && maximumSalary < employees[i].getSalary()) {
                maximumSalary = employees[i].getSalary();
                id = employees[i].getId();
            }
        }
        return id;
    }

    public float calculateSalariesAverage() {
        return (float) calculateSalaryCosts()/size;
    }

    public float calculateSalariesAverage(int department) {
        int sumOfSalaries = 0;
        int numberOfEmployees = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == department) {
                sumOfSalaries += employees[i].getSalary();
                numberOfEmployees++;
            }
        }
        return (float) sumOfSalaries/numberOfEmployees;
    }

    public void raiseAllEmployees(int percentage) {
        float indexation = (float) percentage / 100;
        for (int i = 0; i < size; i++) {
            employees[i].setSalary(employees[i].getSalary() + (int) (employees[i].getSalary() * indexation));
        }
    }

    public void raiseAllEmployees(int department, int percentage) {
        float indexation = (float) percentage / 100;
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == department)
                employees[i].setSalary(employees[i].getSalary() + (int) (employees[i].getSalary() * indexation));
        }
    }

    private void printEmployeeData(int employeeArrayIndex, boolean id, boolean name, boolean department, boolean salary) {
        if(id) System.out.println("ID сотрудника: " + employees[employeeArrayIndex].getId());
        if(name) System.out.println("Ф.И.О. сотрудника: " + employees[employeeArrayIndex].getLastName() + " " + employees[employeeArrayIndex].getFirstName()
                + " " + employees[employeeArrayIndex].getMiddleName());
        if(department) System.out.println("Работает в отделе № " + employees[employeeArrayIndex].getDepartment());
        if(salary) System.out.println("Зарпалата в размере " + new DecimalFormat("###,###").format(employees[employeeArrayIndex].getSalary()) + " рублей");
        System.out.println();
    }

    private void printDelimiter() {System.out.println("############################");}

    public String formatSalary(int salary) {
        return new DecimalFormat("###,###").format(salary);
    }

    public String getEmployeeFullNameById(int id) {
        String fullName = null;
        for (int i = 0; i < size; i++) {
            if(employees[i].getId() == id) fullName = employees[i].toString();
        }
        return fullName;
    }

    public void printAllEmployees() {
        printDelimiter();
        for (int i = 0; i < size; i++) {
                printEmployeeData(i, true, true, true, true);
        }
        printDelimiter();
    }

    public void printEmployeesOfDepartment(int department) {
        printDelimiter();
        for (int i = 0; i < size; i++) {
            if (employees[i].getDepartment() == department) {
                printEmployeeData(i, true, true, false, true);
            }
        }
        printDelimiter();
    }

    public void printEmployeesWithSalaryLessThan(int salary) {
        printDelimiter();
        for (int i = 0; i < size; i++) {
            if (employees[i].getSalary() < salary) {
                printEmployeeData(i, true, true, false, true);
            }
        }
        printDelimiter();
    }

    public void printEmployeesWithSalaryMoreOrEquals(int salary) {
        printDelimiter();
        for (int i = 0; i < size; i++) {
            if (salary <= employees[i].getSalary()) {
                printEmployeeData(i, true, true, false, true);
            }
        }
        printDelimiter();
    }

    public void printAllEmployeesNames() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].toString());
        }
    }

    public void printAllEmployeesByDepartments() {
        int[] departments = new int[size];
        for (int i = 0; i < departments.length; i++) {
            departments[i] = employees[i].getDepartment();
        }
        int[] array = getArrayWithoutDuplicates(departments);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Отдел № " + array[i]);
            for (int i1 = 0; i1 < size; i1++) {
                if(array[i] == employees[i1].getDepartment())
                    printEmployeeData(i1, false, true, false, false);
            }
            printDelimiter();
        }
    }

    private int[] getArrayWithoutDuplicates(int[] incomingArray) {
        Arrays.sort(incomingArray);
        int[] tempArray = new int[incomingArray.length];
        int outcomingArrayLength = 0;
        boolean isAllDuplicate = true;
        for (int i = 1; i < incomingArray.length; i++) {
            if(incomingArray[i - 1] != 0 && incomingArray[i] != 0 && incomingArray[i - 1] != incomingArray[i]) {
                isAllDuplicate = false;
                tempArray[outcomingArrayLength] = incomingArray[i - 1];
                tempArray[outcomingArrayLength + 1] = incomingArray[i];
                outcomingArrayLength++;
            }
        }
        if(isAllDuplicate) {
            tempArray[0] = incomingArray[0];
            outcomingArrayLength = 0;
        }
        int[] outcomingArray = new int[outcomingArrayLength + 1];
        for (int i = 0; i < outcomingArray.length; i++) {
            outcomingArray[i] = tempArray[i];
        }
        return outcomingArray;
    }

}
