import java.time.LocalDate;

public class VipTicket extends SuperTicket {
    private boolean backstage;
    private boolean catering;

    public VipTicket(String ticketId, String eventName, double basePrice, LocalDate eventDate,
                     boolean backstage, boolean catering) {
        super(ticketId, eventName, basePrice, eventDate);
        this.backstage = backstage;
        this.catering = catering;
    }

    @Override
    public double calculatePrice() {
        double finalPrice = super.basePrice;
        if (backstage) {
            finalPrice += 100.0;
        }
        if (catering) {
            finalPrice += 250.0;
        }
        return finalPrice;
    }

    @Override
    public boolean allowedToEnter(int personCount) {
        return personCount == 1;
    }

    @Override
    public String info() {
        return "event: " + eventName + "\n" +
                "date: " + eventDate + "\n" +
                "ticketid: " + ticketId + "\n" +
                "used: " + used + "\n" +
                "backstage: " + backstage + "\n" +
                "catering: " + catering;
    }

    @Override
    public String printOut() {
        return "=== VIP TICKET ===\n" +
                info() + "\n" +
                "price: " + calculatePrice();
    }
}