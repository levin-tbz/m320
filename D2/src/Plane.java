import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a plane, its takeoff time, and its passengers.
 */
public class Plane {
    private String name;
    private List<Passenger> passengers;
    private LocalDateTime takeoffTime;

    /**
     * Creates a plane with the given name and takeoff time.
     *
     * @param name the plane's name
     * @param takeoffTime the scheduled takeoff date and time
     */
    Plane(String name, LocalDateTime takeoffTime) {
        this.name = name;
        this.passengers = new ArrayList<>();
        this.takeoffTime = takeoffTime;
    }

    /**
     * Returns this plane's name.
     *
     * @return the plane's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets this plane's name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds a passenger to this plane.
     *
     * @param passanger the passenger to add
     */
    public void addPassenger(Passenger passanger) {
        this.passengers.add(passanger);
    }

    /**
     * Removes the first matching passenger from this plane, if present.
     *
     * @param passanger the passenger to remove
     */
    public void removePassenger(Passenger passanger) {
        this.passengers.remove(passanger);
    }

    /**
     * Returns the passengers on this plane.
     *
     * @return the mutable list of passengers
     */
    public List<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Replaces the passengers on this plane.
     *
     * @param passengers the new list of passengers
     */
    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    /**
     * Returns this plane's scheduled takeoff time.
     *
     * @return the takeoff date and time
     */
    public LocalDateTime getTakeoffTime() {
        return takeoffTime;
    }

    /**
     * Sets this plane's scheduled takeoff time.
     *
     * @param takeoffTime the new takeoff date and time
     */
    public void setTakeoffTime(LocalDateTime takeoffTime) {
        this.takeoffTime = takeoffTime;
    }

    /**
     * Returns a textual summary of this plane and its passengers.
     *
     * @return this plane's textual representation
     */
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
