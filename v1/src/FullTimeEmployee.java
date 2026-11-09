public class FullTimeEmployee extends Employee {
    private int monthlySalary;
    private int bonusAmount;
    private boolean bonusEligible;

    public FullTimeEmployee(int id, String name, int monthlySalary, int bonusAmount, boolean bonusEligible) {
        super(id, name);
        setMonthlySalary(monthlySalary);
        setBonusAmount(bonusAmount);
        setBonusEligible(bonusEligible);
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        if (monthlySalary <= 0) {
            throw new IllegalArgumentException("monthlySalary has to be above 0");
        }
        this.monthlySalary = monthlySalary;
    }

    public int getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(int bonusAmount) {
        if (bonusAmount < 0) {
            throw new IllegalArgumentException("bonusAmount has to be at least 0");
        }
        this.bonusAmount = bonusAmount;
    }

    public boolean isBonusEligible() {
        return bonusEligible;
    }

    public void setBonusEligible(boolean bonusEligible) {
        this.bonusEligible = bonusEligible;
    }
}
