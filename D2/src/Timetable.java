import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Timetable {
    private List<Plane> planes;

    public Timetable() {
        this.planes = new ArrayList<>();
    }

    public void addPlane(Plane plane) {
        this.planes.add(plane);
    }

    public void removePlane(Plane plane) {
        this.planes.remove(plane);
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public List<Plane> planesTakingoffOn(LocalDate date) {
        ArrayList<Plane> matchingPlanes = new ArrayList<>();
        for (Plane p : this.planes) {
            if (p.getTakeoffTime().toLocalDate().equals(date)) {
                matchingPlanes.add(p);
            }
        }

        return matchingPlanes;
    }

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
