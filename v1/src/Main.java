import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FullTimeEmployee fte = new FullTimeEmployee(67, "sigma", 67000, 13, false);
        System.out.println("fte salary: " + fte.calculateMonthlyPay());

        PartTimeEmployee pte = new PartTimeEmployee(12, "broski", 10, 10);
        System.out.println("pte salary: " + pte.calculateMonthlyPay());

        Intern i = new Intern(1, "sigeon", 6, 3000, 3000);
        System.out.println("intern salary: " + i.calculateMonthlyPay());

        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(fte);
        manager.addEmployee(pte);
        manager.addEmployee(i);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printHelp();
            System.out.print("-> ");
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                continue;
            }
            char option = line.charAt(0);

            switch (option) {
                case 'a':
                    System.out.print("Category (f/p/i): ");
                    String typeStr = scanner.nextLine();
                    if (typeStr.isEmpty()) {
                        continue;
                    }
                    char type = Character.toLowerCase(typeStr.charAt(0));
                    if (type != 'f' && type != 'p' && type != 'i') {
                        continue;
                    }

                    System.out.print("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    if (type == 'f') {
                        System.out.print("Monthly salary: ");
                        int salary = Integer.parseInt(scanner.nextLine());
                        System.out.print("Bonus amount: ");
                        int bonus = Integer.parseInt(scanner.nextLine());
                        System.out.print("Bonus eligible (true/false): ");
                        boolean eligible = Boolean.parseBoolean(scanner.nextLine());
                        manager.addEmployee(new FullTimeEmployee(id, name, salary, bonus, eligible));
                    } else if (type == 'p') {
                        System.out.print("Hourly rate: ");
                        int rate = Integer.parseInt(scanner.nextLine());
                        System.out.print("Hours worked: ");
                        int hours = Integer.parseInt(scanner.nextLine());
                        manager.addEmployee(new PartTimeEmployee(id, name, rate, hours));
                    } else if (type == 'i') {
                        System.out.print("Fixed monthly pay: ");
                        int pay = Integer.parseInt(scanner.nextLine());
                        System.out.print("Max hours: ");
                        int maxHours = Integer.parseInt(scanner.nextLine());
                        System.out.print("Hours worked: ");
                        int hours = Integer.parseInt(scanner.nextLine());
                        manager.addEmployee(new Intern(id, name, pay, maxHours, hours));
                    }
                    break;
                case 'k':
                    System.out.print("Category (f/p/i): ");
                    String catStr = scanner.nextLine();
                    if (catStr.isEmpty()) {
                        continue;
                    }
                    char cat = Character.toLowerCase(catStr.charAt(0));
                    if (cat == 'f') {
                        for (FullTimeEmployee e : manager.getFullTimeEmployees()) {
                            System.out.println(e);
                        }
                    } else if (cat == 'p') {
                        for (PartTimeEmployee e : manager.getPartTimeEmployees()) {
                            System.out.println(e);
                        }
                    } else if (cat == 'i') {
                        for (Intern e : manager.getInterns()) {
                            System.out.println(e);
                        }
                    } else {
                        continue;
                    }
                    break;
                case 's':
                    System.out.print("Search (ID or Name): ");
                    String query = scanner.nextLine();
                    if (query.isEmpty()) {
                        continue;
                    }
                    boolean found = false;
                    for (Employee e : manager.getAllEmployees()) {
                        if (String.valueOf(e.getId()).equals(query) || e.getName().equalsIgnoreCase(query)) {
                            System.out.println(e);
                            found = true;
                        }
                    }
                    if (!found) {
                        continue;
                    }
                    break;
                case 'r':
                    System.out.print("ID: ");
                    String removeStr = scanner.nextLine();
                    if (removeStr.isEmpty()) {
                        continue;
                    }
                    Employee toRemove = manager.findByIdOrName(removeStr);
                    if (toRemove == null) {
                        continue;
                    }
                    manager.removeEmployee(toRemove);
                    break;
                case 'l':
                    System.out.print("ID: ");
                    String salaryStr = scanner.nextLine();
                    if (salaryStr.isEmpty()) {
                        continue;
                    }
                    Employee emp = manager.findByIdOrName(salaryStr);
                    if (emp == null) {
                        continue;
                    }
                    System.out.println(emp.getName() + " salary: " + emp.calculateMonthlyPay());
                    break;
                case 'e':
                    System.exit(0);
                    break;
                default:
                    continue;
            }
        }
    }

    public static void printHelp() {
        System.out.println("[a] add employee");
        System.out.println("[k] show all employees of category x");
        System.out.println("[s] search by id or name");
        System.out.println("[r] remove employee");
        System.out.println("[l] show salary");
        System.out.println("[e] exit program");
    }
}
