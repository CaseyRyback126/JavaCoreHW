public class HourlyEmployee extends Employee {
    private final double hourlyRate;

    public HourlyEmployee(String name, double hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateMonthlySalary() {
        return 20.8 * 8 * hourlyRate;
    }
}
