import java.time.LocalDate;

public abstract class SuperTicket {
    protected String ticketId;
    protected String eventName;
    protected double basePrice;
    protected LocalDate eventDate;
    protected boolean used;

    public SuperTicket(String ticketId, String eventName, double basePrice, LocalDate eventDate) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.basePrice = basePrice;
        this.eventDate = eventDate;
        this.used = false;
    }

    public abstract double calculatePrice();

    public abstract boolean allowedToEnter(int personCount);

    public void use() {
        if (this.used) {
            throw new RuntimeException("Ticket already used");
        }
        this.used = true;
    }

    public String info() {
        return "event: " + eventName + "\n" +
                "date: " + eventDate + "\n" +
                "ticketid: " + ticketId + "\n" +
                "used: " + used;
    }

    public String printOut() {
        return "=== TICKET ===\n" +
                info() + "\n" +
                "price: " + calculatePrice();
    }
}