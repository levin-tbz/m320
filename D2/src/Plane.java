import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Plane {
    private String name;
    private List<Passenger> passengers;
    private LocalDateTime takeoffTime;

    Plane(String name, LocalDateTime takeoffTime) {
        this.name = name;
        this.passengers = new ArrayList<>();
        this.takeoffTime = takeoffTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPassenger(Passenger passanger) {
        this.passengers.add(passanger);
    }

    public void removePassenger(Passenger passanger) {
        this.passengers.remove(passanger);
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public LocalDateTime getTakeoffTime() {
        return takeoffTime;
    }

    public void setTakeoffTime(LocalDateTime takeoffTime) {
        this.takeoffTime = takeoffTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("plane: ").append(this.name);
        sb.append("takeoff: ").append(this.takeoffTime).append("\n");
        sb.append("passengers: ");
        for (Passenger p : this.passengers) {
            sb.append(p).append(", ");
        }
        return sb.toString();
    }
}
