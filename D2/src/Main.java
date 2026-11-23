import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Demonstrates creating planes and passengers and querying a timetable.
 */
public class Main {
    /**
     * Runs the timetable demonstration.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        Timetable timetable = new Timetable();

        Plane plane = new Plane("329ej3", LocalDateTime.now());
        plane.addPassenger(new Passenger("sigma"));
        plane.addPassenger(new Passenger("max"));
        timetable.addPlane(plane);
        timetable.addPlane(new Plane("foajfekj", LocalDateTime.now()));

        System.out.println(timetable);
        System.out.println(plane);
        List<Plane> planes = timetable.planesTakingoffOn(LocalDate.now());
        System.out.println("planes today");
        for (Plane p : planes) {
            System.out.println(p.getName());
        }
    }
}
