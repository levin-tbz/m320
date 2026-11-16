public class Project {
    private Customer customer;
    private int minutesWorkedOnProject;
    private boolean internal;

    Project(Customer customer, boolean internal) {
        this.customer = customer;
        this.minutesWorkedOnProject = 0;
        this.internal = internal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getMinutesWorkedOnProject() {
        return minutesWorkedOnProject;
    }

    public void setMinutesWorkedOnProject(int minutesWorkedOnProject) {
        this.minutesWorkedOnProject = minutesWorkedOnProject;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    @Override
    public String toString() {
        return customer.toString() + " minutes worked on project: " + minutesWorkedOnProject + " internal: " + internal;
    }
}
