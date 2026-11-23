import java.time.LocalDate;
import java.util.Optional;

public class DefaultTicket extends SuperTicket {
    private int seatNumber;
    private boolean discountAllowed;
    private Optional<Double> discount;

    public DefaultTicket(String ticketId, String eventName, double basePrice, LocalDate eventDate,
                         int seatNumber, boolean discountAllowed, Optional<Double> discount) {
        super(ticketId, eventName, basePrice, eventDate);
        this.seatNumber = seatNumber;
        this.discountAllowed = discountAllowed;
        this.discount = discount;
    }

    @Override
    public double calculatePrice() {
        if (discountAllowed && discount != null && discount.isPresent()) {
            return super.basePrice - discount.get();
        }
        return super.basePrice;
    }

    @Override
    public boolean allowedToEnter(int personCount) {
        return personCount == 1;
    }

    @Override
    public String printOut() {
        return "=== STANDARD TICKET ===\n" +
                info() + "\n" +
                "seat: " + seatNumber + "\n" +
                "price: " + calculatePrice();
    }
}