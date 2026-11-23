/**
 * Represents a passenger identified by name.
 */
public class Passenger {
    private String name;

    /**
     * Creates a passenger with the given name.
     *
     * @param name the passenger's name
     */
    Passenger(String name) {
        this.name = name;
    }

    /**
     * Returns this passenger's name.
     *
     * @return the passenger's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets this passenger's name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns this passenger's name as the textual representation.
     *
     * @return the passenger's name
     */
    @Override
    public String toString() {
        return name;
    }
}
