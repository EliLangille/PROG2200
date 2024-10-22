package SingleResponsibility.Assignment.EmployeeManagementSystem;

public class Main {
    public static void main(String[] args) {

        /*
        In this setup, the EmployeeManager class handles multiple
        responsibilities like adding employees, calculating salaries,
        managing benefits, and generating performance reports. Students
        should refactor this class to align with the Single Responsibility
        Principle, creating separate classes to handle these individual
        responsibilities.
         */

        // Init class objects
        EmployeeManager employeeManager = new EmployeeManager();
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        BenefitsManager benefitsManager = new BenefitsManager();
        PerformanceReportGenerator reportGenerator = new PerformanceReportGenerator();

        // Add new employee
        Employee employee1 = new Employee("John Doe", 50000, 5);
        employeeManager.addNewEmployee(employee1);

        // Calculate salary
        double salary = salaryCalculator.calculateSalary(employee1);
        System.out.println("Salary for " + employee1.getName() + ": " + salary);

        // Manage benefits and generate performance report
        benefitsManager.manageBenefits(employee1);
        reportGenerator.generatePerformanceReport(employee1);
    }
}
