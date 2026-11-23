import java.time.LocalDate;

public class GroupTicket extends SuperTicket {
    private int maxPerson;
    private double groupDiscountPercentage;

    public GroupTicket(String ticketId, String eventName, double basePrice, LocalDate eventDate,
                       int maxPerson, double groupDiscountPercentage) {
        super(ticketId, eventName, basePrice, eventDate);
        this.maxPerson = maxPerson;
        this.groupDiscountPercentage = groupDiscountPercentage;
    }

    @Override
    public double calculatePrice() {
        return super.basePrice - super.basePrice * (groupDiscountPercentage / 100.0);
    }

    @Override
    public boolean allowedToEnter(int personCount) {
        return personCount <= maxPerson;
    }

    @Override
    public String printOut() {
        return "=== GROUP TICKET ===\n" +
                info() + "\n" +
                "max persons: " + maxPerson + "\n" +
                "price: " + calculatePrice();
    }
}