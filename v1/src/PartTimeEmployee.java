public class PartTimeEmployee extends Employee {
    private int hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(int id, String name, int hourlyRate, int hoursWorked) {
        super(id, name);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    public int calculateMonthlyPay() {
        return hourlyRate * hoursWorked;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        if (hourlyRate <= 0) {
            throw new IllegalArgumentException("hourlyRate has to be above 0");
        }
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        if (hoursWorked < 0 || hoursWorked > 180) {
            throw new IllegalArgumentException("hoursWorked has to be between 0 and 180");
        }
        this.hoursWorked = hoursWorked;
    }
}
