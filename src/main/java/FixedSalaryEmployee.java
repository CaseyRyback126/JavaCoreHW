public class FixedSalaryEmployee extends Employee{
    private final double fixedMonthlySalary;

    public FixedSalaryEmployee(String name, double fixedMonthlySalary) {
        super(name);
        this.fixedMonthlySalary = fixedMonthlySalary;
    }


    @Override
    public double calculateMonthlySalary() {
        return fixedMonthlySalary;
    }
}
