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

    public void addEmployee(Employee employee) {
        if (employee instanceof FullTimeEmployee fullTimeEmployee) {
            fullTimeEmployees.add(fullTimeEmployee);
        } else if (employee instanceof PartTimeEmployee partTimeEmployee) {
            partTimeEmployees.add(partTimeEmployee);
        } else if (employee instanceof Intern intern) {
            interns.add(intern);
        }
    }

    public void removeEmployee(Employee employee) {
        if (employee instanceof FullTimeEmployee fullTimeEmployee) {
            fullTimeEmployees.remove(fullTimeEmployee);
        } else if (employee instanceof PartTimeEmployee partTimeEmployee) {
            partTimeEmployees.remove(partTimeEmployee);
        } else if (employee instanceof Intern intern) {
            interns.remove(intern);
        }
    }

    public ArrayList<FullTimeEmployee> getFullTimeEmployees() {
        return fullTimeEmployees;
    }

    public ArrayList<PartTimeEmployee> getPartTimeEmployees() {
        return partTimeEmployees;
    }


    public ArrayList<Intern> getInterns() {
        return interns;
    }

    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> all = new ArrayList<>();
        all.addAll(fullTimeEmployees);
        all.addAll(partTimeEmployees);
        all.addAll(interns);
        return all;
    }

    public Employee findByIdOrName(String query) {
        for (Employee e : getAllEmployees()) {
            if (String.valueOf(e.getId()).equals(query) || e.getName().equalsIgnoreCase(query)) {
                return e;
            }
        }
        return null;
    }
}
