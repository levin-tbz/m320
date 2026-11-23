import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    private List<SuperTicket> tickets = new ArrayList<>();

    public void add(SuperTicket ticket) {
        this.tickets.add(ticket);
    }

    public void removeById(String ticketId) {
        this.tickets.removeIf(t -> t.ticketId.equals(ticketId));
    }

    public SuperTicket findById(String ticketId) {
        return this.tickets.stream()
                .filter(t -> t.ticketId.equals(ticketId))
                .findFirst()
                .orElse(null);
    }

    public void printAll() {
        for (SuperTicket t : tickets) {
            System.out.println(t.printOut());
            System.out.println("---");
        }
    }

    public double totalWorth() {
        double sum = 0.0;
        for (SuperTicket t : tickets) {
            sum += t.calculatePrice();
        }
        return sum;
    }

    public void checkAndUse(String ticketId, int personCount) {
        SuperTicket ticket = findById(ticketId);
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket not found: " + ticketId);
        }
        if (!ticket.allowedToEnter(personCount)) {
            throw new IllegalStateException("Entry denied for " + personCount + " person(s)");
        }
        ticket.use();
    }

    public void demoPolymorphism(int testPersons) {
        for (SuperTicket t : tickets) {
            System.out.println(t.printOut());
            System.out.println("calculated price: " + t.calculatePrice());
            System.out.println("allowed for " + testPersons + " persons: " + t.allowedToEnter(testPersons));
            System.out.println("===");
        }
    }
}