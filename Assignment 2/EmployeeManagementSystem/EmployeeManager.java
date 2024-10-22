package SingleResponsibility.Assignment.EmployeeManagementSystem;


import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addNewEmployee(Employee employee) {
        employees.add(employee);
    }
}
