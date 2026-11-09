import java.util.ArrayList;

public class EmployeeManager {
    private ArrayList<FullTimeEmployee> fullTimeEmployees;
    private ArrayList<PartTimeEmployee> partTimeEmployees;
    private ArrayList<Intern> interns;

    EmployeeManager() {
        this.fullTimeEmployees = new ArrayList<>();
        this.partTimeEmployees = new ArrayList<>();
        this.interns = new ArrayList<>();
    }
}
