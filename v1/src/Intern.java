public class Intern extends Employee {
    private int fixedMonthlyPay;
    private int maxHours;
    private int hoursWorked;

    public Intern(int id, String name, int fixedMonthlyPay, int maxHours, int hoursWorked) {
        super(id, name);
        setFixedMonthlyPay(fixedMonthlyPay);
        setMaxHours(maxHours);
        setHoursWorked(hoursWorked);
    }

    public int calculateMonthlyPay() {
        return fixedMonthlyPay;
    }

    public int getFixedMonthlyPay() {
        return fixedMonthlyPay;
    }

    public void setFixedMonthlyPay(int fixedMonthlyPay) {
        if (fixedMonthlyPay < 0) {
            throw new IllegalArgumentException("fixedMonthlyPay has to be at least 0");
        }
        this.fixedMonthlyPay = fixedMonthlyPay;
    }

    public int getMaxHours() {
        return maxHours;
    }

    public void setMaxHours(int maxHours) {
        if (maxHours <= 0) {
            throw new IllegalArgumentException("maxHours has to be above 0");
        }
        if (maxHours < this.hoursWorked) {
            throw new IllegalArgumentException("maxHours has to be at least hoursWorked");
        }
        this.maxHours = maxHours;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        if (hoursWorked < 0 || hoursWorked > this.maxHours) {
            throw new IllegalArgumentException("hoursWorked has to be between 0 and maxHours");
        }
        this.hoursWorked = hoursWorked;
    }
}
