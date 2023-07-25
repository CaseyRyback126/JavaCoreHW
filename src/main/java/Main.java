public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];

        employees[0] = new HourlyEmployee("John", 10.0);
        employees[1] = new FixedSalaryEmployee("Jane", 2000.0);
        employees[2] = new HourlyEmployee("Bob", 12.5);
        employees[3] = new FixedSalaryEmployee("Jabba", 1750.1);

        EmployeeManager manager = new EmployeeManager(employees);

        manager.sortEmployees(new SalaryComparator().reversed());
        manager.printEmployees();
    }
}
