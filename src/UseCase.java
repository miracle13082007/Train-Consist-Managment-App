// 1. Create a custom exception class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    private String id;
    private String type;
    private int capacity;

    // 2. Validate capacity inside constructor
    public PassengerBogie(String id, String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            // 3. Throw the exception if business rules are violated
            throw new InvalidCapacityException("Capacity must be greater than zero for Bogie ID: " + id);
        }
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "PassengerBogie{" + "ID='" + id + '\'' + ", Type='" + type + '\'' + ", Capacity=" + capacity + '}';
    }
}

public class UseCase {
    public static void main(String[] args) {
        // Attempt to create bogies
        try {
            System.out.println("Attempting to create valid bogie...");
            PassengerBogie b1 = new PassengerBogie("B1", "Sleeper", 72);
            System.out.println("Successfully created: " + b1);

            System.out.println("\nAttempting to create invalid bogie (Zero Capacity)...");
            PassengerBogie b2 = new PassengerBogie("B2", "AC Chair", 0);

        } catch (InvalidCapacityException e) {
            // Handle the domain-specific error
            System.err.println("ERROR: " + e.getMessage());
        }

        try {
            System.out.println("\nAttempting to create invalid bogie (Negative Capacity)...");
            PassengerBogie b3 = new PassengerBogie("B3", "First Class", -10);
        } catch (InvalidCapacityException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}