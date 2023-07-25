import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
    public int compare(Employee emp1, Employee emp2) {
        double salary1 = emp1.calculateMonthlySalary();
        double salary2 = emp2.calculateMonthlySalary();

        return Double.compare(salary1, salary2);
    }
}
