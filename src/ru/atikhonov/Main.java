package ru.atikhonov;

public class Main {

    public static void main(String[] args) {
        Employee ivanov = new Employee("Иванов", "Иван", "Иванович", 1, 150_150);
        Employee petrov = new Employee("Петров", "Петр", "Петрович", 2, 200_000);
        Employee alekdsandrov = new Employee("Александров", "Александр", "Александрович", 2, 350_000);
        EmployeeBook employeeBook = new EmployeeBook(10);
        employeeBook.addNewEmployee(ivanov);
        employeeBook.addNewEmployee(petrov);
        employeeBook.addNewEmployee(alekdsandrov);
        System.out.println("Сумма затрат на зарплаты в месяц " + employeeBook.formatSalary(employeeBook.calculateSalaryCosts()) + " р.");
        System.out.println("Cотрудник с минимальной зарплатой " + employeeBook.getEmployeeFullNameById(employeeBook.findMinimumSalaryEmployee()));
        System.out.println("Cотрудник с максимальной зарплатой " + employeeBook.getEmployeeFullNameById(employeeBook.findMaximumSalaryEmployee()));
        System.out.println("Среднее значение зарплат " + employeeBook.formatSalary((int) employeeBook.calculateSalariesAverage()) + " р.");
        employeeBook.printAllEmployees();
        employeeBook.raiseAllEmployees(20);
        System.out.println("Cотрудник с минимальной зарплатой 2-го отдела " + employeeBook.getEmployeeFullNameById(employeeBook.findMinimumSalaryEmployee(2)));
        System.out.println("Cотрудник с максимальной зарплатой 2-го отдела " + employeeBook.getEmployeeFullNameById(employeeBook.findMaximumSalaryEmployee(2)));
        System.out.println("Средняя зарплата по отделу " + employeeBook.formatSalary((int)employeeBook.calculateSalariesAverage(2)) + " р.");
        employeeBook.raiseAllEmployees(2, 20);
        employeeBook.printEmployeesOfDepartment(2);
        employeeBook.printEmployeesWithSalaryLessThan(350_000);
        employeeBook.printEmployeesWithSalaryMoreOrEquals(288_000);
        employeeBook.addNewEmployee("Васильев", "Василий", "Васильевич", 3, 440_000);
        employeeBook.printEmployeesOfDepartment(3);
        employeeBook.deleteEmployee("Петров", "Петр", "Петрович");
        employeeBook.printEmployeesOfDepartment(2);
        employeeBook.changeEmployeeSalary("Васильев", "Василий", "Васильевич", 480_000);
        employeeBook.printEmployeesOfDepartment(3);
        employeeBook.changeEmployeeDepartment("Васильев", "Василий", "Васильевич", 1);
        employeeBook.printEmployeesOfDepartment(1);
        employeeBook.printAllEmployeesByDepartments();
    }
}
