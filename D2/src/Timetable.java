import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Stores planes and provides operations for managing and querying their
 * takeoff schedules.
 */
public class Timetable {
    private List<Plane> planes;

    /** Creates an empty timetable. */
    public Timetable() {
        this.planes = new ArrayList<>();
    }

    /**
     * Adds a plane to this timetable.
     *
     * @param plane the plane to add
     */
    public void addPlane(Plane plane) {
        this.planes.add(plane);
    }

    /**
     * Removes the first matching plane from this timetable, if present.
     *
     * @param plane the plane to remove
     */
    public void removePlane(Plane plane) {
        this.planes.remove(plane);
    }

    /**
     * Returns the list of planes stored in this timetable.
     *
     * @return the mutable list of planes
     */
    public List<Plane> getPlanes() {
        return planes;
    }

    /**
     * Replaces the planes stored in this timetable.
     *
     * @param planes the new list of planes
     */
    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    /**
     * Finds planes whose takeoff date matches the given date.
     *
     * @param date the date to search for
     * @return a new list containing the matching planes
     */
    public List<Plane> planesTakingoffOn(LocalDate date) {
        ArrayList<Plane> matchingPlanes = new ArrayList<>();
        for (Plane p : this.planes) {
            if (p.getTakeoffTime().toLocalDate().equals(date)) {
                matchingPlanes.add(p);
            }
        }

        return matchingPlanes;
    }

    /**
     * Returns a multiline summary of the planes and their takeoff times.
     *
     * @return this timetable's textual representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Timetable: \n");
        for (Plane p : this.planes) {
            sb.append(p.getName());
            sb.append(" takeoff: ");
            sb.append(p.getTakeoffTime());
            sb.append("\n");
        }

        return sb.toString();
    }
}
