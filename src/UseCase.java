import java.util.*;

class Bogie {
    String id;
    String type;
    int capacity;

    public Bogie(String id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return String.format("%s (%s: %d)", id, type, capacity);
    }
}

public class UseCase {
    public static void main(String[] args) {
        // 1. Create a list of bogies
        List<Bogie> consist = Arrays.asList(
                new Bogie("S1", "Sleeper", 72),
                new Bogie("S2", "Sleeper", 72),
                new Bogie("A1", "AC Chair", 56),
                new Bogie("F1", "First Class", 24)
        );

        System.out.println("Train Consist attached to Engine:");
        consist.forEach(System.out::println);

        // 2. Convert to stream | 3. Map to capacity | 4. Reduce to sum
        int totalSeats = consist.stream()
                .map(b -> b.capacity)           // Extracting numeric values
                .reduce(0, Integer::sum);       // Aggregating into a single total

        // 5. Display result
        System.out.println("------------------------------------");
        System.out.println("Total Seating Capacity of Train: " + totalSeats);
    }
}