public class Main {
    public static void main(String[] args) {
        FullTimeEmployee fte = new FullTimeEmployee(67, "sigma", 67000, 13, false);
        System.out.println("fte salary: " + fte.calculateMonthlyPay());

        PartTimeEmployee pte = new PartTimeEmployee(12, "broski", 10, 10);
        System.out.println("pte salary: " + pte.calculateMonthlyPay());

        Intern i = new Intern(1, "sigeon", 6, 3000, 3000);
        System.out.println("intern salary: " + i.calculateMonthlyPay());
    }
}
