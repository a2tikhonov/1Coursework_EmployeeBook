package ru.atikhonov;

import java.text.DecimalFormat;
import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees;

    EmployeeBook(int maxNumberOfEmployees) {
        this.employees = new Employee[maxNumberOfEmployees];
    }

    public void addNewEmployee(String lastname, String fisrtName, String middleName, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(lastname, fisrtName, middleName, department, salary);
                break;
            }
        }
    }

    public void addNewEmployee(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                break;
            }
        }
    }

    public void deleteEmployee(String lastName, String firstName, String middleName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getLastName().equals(lastName) && employees[i].getFirstName().equals(firstName)
                    && employees[i].getMiddleName().equals(middleName)) employees[i] = null;
        }
    }

    public void deleteEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == employee.getId()) employees[i] = null;
        }
    }

    public void changeEmployeeSalary(String lastName, String firstName, String middleName, int newSalary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getLastName().equals(lastName) && employees[i].getFirstName().equals(firstName)
                    && employees[i].getMiddleName().equals(middleName)) employees[i].setSalary(newSalary);
        }
    }

    public void changeEmployeeDepartment(String lastName, String firstName, String middleName, int newDepartment) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getLastName().equals(lastName) && employees[i].getFirstName().equals(firstName)
                    && employees[i].getMiddleName().equals(middleName)) employees[i].setDepartment(newDepartment);
        }
    }

    public int calculateSalaryCosts() {
        int sumOfSalaries = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) sumOfSalaries += employees[i].getSalary();
        }
        return sumOfSalaries;
    }

    public int calculateSalaryCosts(int department) {
        int sumOfSalaries = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) sumOfSalaries += employees[i].getSalary();
        }
        return sumOfSalaries;
    }

    public int findMinimumSalaryEmployee() {
        int minimumSalary = 0;
        int id = 0;
        for (int i = 0; i < employees.length && minimumSalary == 0; i++) {
            if (employees[i] != null) {
                minimumSalary = employees[i].getSalary();
                id = employees[i].getId();
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && minimumSalary > employees[i].getSalary()) {
                minimumSalary = employees[i].getSalary();
                id = employees[i].getId();
            }
        }
        return id;
    }

    public int findMinimumSalaryEmployee(int department) {
        int minimumSalary = 0;
        int id = 0;
        for (int i = 0; i < employees.length && minimumSalary == 0; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                minimumSalary = employees[i].getSalary();
                id = employees[i].getId();
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && minimumSalary > employees[i].getSalary()) {
                minimumSalary = employees[i].getSalary();
                id = employees[i].getId();
            }
        }
        return id;
    }

    public int findMaximumSalaryEmployee() {
        int maximumSalary = 0;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && maximumSalary < employees[i].getSalary()) {
                maximumSalary = employees[i].getSalary();
                id = employees[i].getId();
            }
        }
        return id;
    }

    public int findMaximumSalaryEmployee(int department) {
        int maximumSalary = 0;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && maximumSalary < employees[i].getSalary()) {
                maximumSalary = employees[i].getSalary();
                id = employees[i].getId();
            }
        }
        return id;
    }

    public float calculateSalariesAverage() {
        return (float) calculateSalaryCosts()/employees.length;
    }

    public float calculateSalariesAverage(int department) {
        int sumOfSalaries = 0;
        int numberOfEmployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                sumOfSalaries += employees[i].getSalary();
                numberOfEmployees++;
            }
        }
        return (float) sumOfSalaries/numberOfEmployees;
    }

    public void raiseAllEmployees(int percentage) {
        float indexation = (float) percentage / 100;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) employees[i].setSalary(employees[i].getSalary() + (int) (employees[i].getSalary() * indexation));
        }
    }

    public void raiseAllEmployees(int department, int percentage) {
        float indexation = (float) percentage / 100;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null  && employees[i].getDepartment() == department)
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
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null && employees[i].getId() == id) fullName = employees[i].getLastName() + " " + employees[i].getFirstName() +
                    " "  + employees[i].getMiddleName();
        }
        return fullName;
    }

    public void printAllEmployees() {
        printDelimiter();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                printEmployeeData(i, true, true, true, true);
            }
        }
        printDelimiter();
    }

    public void printEmployeesOfDepartment(int department) {
        printDelimiter();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                printEmployeeData(i, true, true, false, true);
            }
        }
        printDelimiter();
    }

    public void printEmployeesWithSalaryLessThan(int salary) {
        int minimumSalary = 0;
        printDelimiter();
        for (int i = 0; i < employees.length && minimumSalary == 0; i++) {
            if (employees[i] != null && employees[i].getSalary() < salary) {
                printEmployeeData(i, true, true, false, true);
            }
        }
        printDelimiter();
    }

    public void printEmployeesWithSalaryMoreOrEquals(int salary) {
        int maximumSalary = 0;
        printDelimiter();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && salary <= employees[i].getSalary()) {
                printEmployeeData(i, true, true, false, true);
            }
        }
        printDelimiter();
    }

    public void printAllEmployeesNames() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) System.out.println(employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName());
        }
    }

    public void printAllEmployeesByDepartments() {
        int[] departments = new int[employees.length];
        for (int i = 0; i < departments.length; i++) {
            if(employees[i] != null) departments[i] = employees[i].getDepartment();
        }
        int[] array = getArrayWithoutDuplicates(departments);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Отдел № " + array[i]);
            for (int i1 = 0; i1 < employees.length; i1++) {
                if(employees[i1] != null && array[i] == employees[i1].getDepartment())
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
        //System.out.println(Arrays.toString(outcomingArray));
        return outcomingArray;
    }

}
