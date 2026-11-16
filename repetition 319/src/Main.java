import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Project> projects = new ArrayList<>();

        tui(projects);
    }

    private static void tui(ArrayList<Project> projects) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("-> ");
            String[] input = scanner.nextLine().split(" ");

            switch (input[0]) {
                case "add":
                    Customer customer = new Customer(input[1]);
                    projects.add(new Project(customer, Boolean.parseBoolean(input[2])));
                    break;
                case "list":
                    for (Project p : projects) {
                        System.out.println(p);
                    }
                    break;
                case "work":
                    int projectIndex = Integer.parseInt(input[1]);
                    int minutes = Integer.parseInt(input[2]);
                    Project project = projects.get(projectIndex);
                    project.setMinutesWorkedOnProject(project.getMinutesWorkedOnProject() + minutes);
                    break;
                case "help":
                    System.out.println("add [customer name] [internal]");
                    System.out.println("list");
                    System.out.println("work [project index] [minutes]");
                    break;
                case "exit":
                    return;
            }
        }
    }
}