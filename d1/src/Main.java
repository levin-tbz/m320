import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("Welcome to this bank System, for it to work you need to create an Account");
        bank.addKonto(Main.newKonto());

        while (true) {
            System.out.println("now you can 1. make a new Account 2. Transfer Money between Accounts 3. Add Money to an Account 4. Remove money from an Account 5. list Account infos");

            int userChoice = sc.nextInt();
            sc.nextLine();

            switch (userChoice) {
                case 1 -> bank.addKonto(Main.newKonto());
                case 2 -> Main.transferMoney(bank);
                case 3 -> {
                    System.out.println("Please enter the amount you would like to add to your account");
                    int amount = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Please enter the owner of the Account");
                    String owner = sc.next();
                    bank.getKonto(owner).addMoney(amount);
                }
                case 4 -> {
                    System.out.println("Please enter the amount you would like to remove from your account");
                    int amount = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Please enter the owner of the Account");
                    String owner = sc.next();
                    bank.getKonto(owner).removeMoney(amount);
                }
                case 5 -> {
                    bank.printKontos();
                }
            }
        }
    }
    public static Konto newKonto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("first we need the name of the customer");
        String name = sc.nextLine();
        System.out.println("second we need the amount of Money on the account");
        double money = sc.nextDouble();
        return new Konto(name, money);
    }
    public static void transferMoney(Bank bank) {
        Scanner sc = new Scanner(System.in);
        int accountNum = bank.getKontos().size();
        if (accountNum > 1) {
            System.out.println("Please enter the amount you would like to transfer");
            int transferAmount = sc.nextInt();
            sc.nextLine();
            System.out.println("Who owns the Account where the money comes from?");
            String originalAccountName = sc.nextLine();
            System.out.println("Who owns the Account where the money goes to?");
            String newAccountName = sc.nextLine();

            bank.getKonto(originalAccountName).removeMoney(transferAmount);
            bank.getKonto(newAccountName).addMoney(transferAmount);
        } else {
            System.out.println("You need a minimum of 2 Accounts to continue this process.");
        }
    }
}