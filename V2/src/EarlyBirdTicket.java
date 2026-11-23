import java.time.LocalDate;

public class EarlyBirdTicket extends SuperTicket {
    private double earlyBirdDiscountPercentage;

    public EarlyBirdTicket(String ticketId, String eventName, double basePrice, LocalDate eventDate,
                           double earlyBirdDiscountPercentage) {
        super(ticketId, eventName, basePrice, eventDate);
        this.earlyBirdDiscountPercentage = earlyBirdDiscountPercentage;
    }

    @Override
    public double calculatePrice() {
        return super.basePrice * (1.0 - earlyBirdDiscountPercentage / 100.0);
    }

    @Override
    public boolean allowedToEnter(int personCount) {
        return personCount == 1;
    }

    @Override
    public String printOut() {
        return "=== EARLY BIRD TICKET ===\n" +
                info() + "\n" +
                "price: " + calculatePrice();
    }
}