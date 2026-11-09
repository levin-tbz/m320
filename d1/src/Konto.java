public class Konto {
    double money;
    String customerName;

    public Konto(String customerName, double money) {
        this.customerName = customerName;
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double money) {
        this.money += money;
    }

    public void removeMoney(double money) {
        this.money -= money;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}