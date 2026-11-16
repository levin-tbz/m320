import java.util.UUID;

public class Customer {
    private String name;
    private final UUID id;

    public Customer(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}
