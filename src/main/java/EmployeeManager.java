import java.util.Arrays;
import java.util.Comparator;

public class EmployeeManager {
    private final Employee[] employees;

    public EmployeeManager(Employee[] employees) {
        this.employees = employees;
    }

    public void sortEmployees(Comparator<Employee> comparator) {
        Arrays.sort(employees, comparator);
    }

    public void printEmployees() {
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getName() + ", Salary: "
                    + employee.calculateMonthlySalary());
        }

    }
}
