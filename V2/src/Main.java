import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        runCli();
    }

    private static void runCli() {
        TicketManager manager = new TicketManager();
        seedTickets(manager);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addTicket(manager, scanner);
                case "2" -> manager.printAll();
                case "3" -> {
                    System.out.print("Ticket ID: ");
                    String id = scanner.nextLine().trim();
                    SuperTicket found = manager.findById(id);
                    System.out.println(found != null ? found.printOut() : "Not found");
                }
                case "4" -> {
                    System.out.print("Ticket ID: ");
                    String id = scanner.nextLine().trim();
                    SuperTicket found = manager.findById(id);
                    if (found != null) {
                        System.out.println("Final price: " + found.calculatePrice());
                    } else {
                        System.out.println("Not found");
                    }
                }
                case "5" -> {
                    System.out.print("Ticket ID: ");
                    String id = scanner.nextLine().trim();
                    System.out.print("Person count: ");
                    int count = Integer.parseInt(scanner.nextLine().trim());
                    manager.checkAndUse(id, count);
                    System.out.println("Entry granted and ticket marked as used.");
                }
                case "6" -> System.out.println("Total worth: " + manager.totalWorth());
                case "7" -> {
                    System.out.print("Ticket ID: ");
                    String id = scanner.nextLine().trim();
                    manager.removeById(id);
                    System.out.println("Removed if present.");
                }
                case "8" -> running = false;
                case "9" -> {
                    System.out.print("Test person count: ");
                    int count = Integer.parseInt(scanner.nextLine().trim());
                    manager.demoPolymorphism(count);
                }
                default -> System.out.println("Invalid option");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n1. Ticket hinzufügen");
        System.out.println("2. Alle Tickets anzeigen");
        System.out.println("3. Ticket suchen");
        System.out.println("4. Endpreis eines Tickets anzeigen");
        System.out.println("5. Zutritt prüfen und Ticket entwerten");
        System.out.println("6. Gesamtwert aller Tickets anzeigen");
        System.out.println("7. Ticket löschen");
        System.out.println("8. Beenden");
        System.out.println("9. Polymorphie-Demo (printOut, calculatePrice, allowedToEnter)");
        System.out.print("> ");
    }

    private static void addTicket(TicketManager manager, Scanner scanner) {
        System.out.println("Type: 1=Standard, 2=VIP, 3=Group, 4=EarlyBird");
        String type = scanner.nextLine().trim();

        System.out.print("ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Event: ");
        String event = scanner.nextLine().trim();
        System.out.print("Base price: ");
        double basePrice = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine().trim());

        SuperTicket ticket = switch (type) {
            case "1" -> {
                System.out.print("Seat number: ");
                int seat = Integer.parseInt(scanner.nextLine().trim());
                System.out.print("Discount allowed (true/false): ");
                boolean allowed = Boolean.parseBoolean(scanner.nextLine().trim());
                System.out.print("Discount amount (or empty): ");
                String rawDiscount = scanner.nextLine().trim();
                Optional<Double> discount = rawDiscount.isEmpty() ? Optional.empty() : Optional.of(Double.parseDouble(rawDiscount));
                yield new DefaultTicket(id, event, basePrice, date, seat, allowed, discount);
            }
            case "2" -> {
                System.out.print("Backstage (true/false): ");
                boolean backstage = Boolean.parseBoolean(scanner.nextLine().trim());
                System.out.print("Catering (true/false): ");
                boolean catering = Boolean.parseBoolean(scanner.nextLine().trim());
                yield new VipTicket(id, event, basePrice, date, backstage, catering);
            }
            case "3" -> {
                System.out.print("Max persons: ");
                int maxPersons = Integer.parseInt(scanner.nextLine().trim());
                System.out.print("Group discount %: ");
                double pct = Double.parseDouble(scanner.nextLine().trim());
                yield new GroupTicket(id, event, basePrice, date, maxPersons, pct);
            }
            case "4" -> {
                System.out.print("Early bird discount %: ");
                double pct = Double.parseDouble(scanner.nextLine().trim());
                yield new EarlyBirdTicket(id, event, basePrice, date, pct);
            }
            default -> null;
        };

        if (ticket != null) {
            manager.add(ticket);
            System.out.println("Added.");
        }
    }

    private static void seedTickets(TicketManager manager) {
        manager.add(new DefaultTicket("T-1", "Openair", 120.0, LocalDate.of(2026, 7, 15), 42, true, Optional.of(20.0)));
        manager.add(new VipTicket("T-2", "Openair", 120.0, LocalDate.of(2026, 7, 15), true, false));
        manager.add(new GroupTicket("T-3", "Theater", 200.0, LocalDate.of(2026, 8, 10), 5, 15.0));
        manager.add(new EarlyBirdTicket("T-4", "Concert", 90.0, LocalDate.of(2026, 9, 1), 25.0));
    }
}