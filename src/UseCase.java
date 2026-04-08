import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return String.format("Bogie{ID='%s', Type='%s', Capacity=%d}", id, type, capacity);
    }
}

public class UseCase {
    public static void main(String[] args) {
        // 1. Create a list of bogies (Reuse from UC7 logic)
        List<Bogie> consist = new ArrayList<>();
        consist.add(new Bogie("B1", "Sleeper", 72));
        consist.add(new Bogie("B2", "AC Chair", 56));
        consist.add(new Bogie("B3", "First Class", 24));
        consist.add(new Bogie("B4", "Sleeper", 80));
        consist.add(new Bogie("B5", "AC Chair", 65));

        System.out.println("--- Original Consist ---");
        consist.forEach(System.out::println);

        // 2. Convert list to stream, 3. Apply filter, 4. Collect to new list
        int capacityThreshold = 60;
        List<Bogie> highCapacityBogies = consist.stream()
                .filter(b -> b.capacity > capacityThreshold)
                .collect(Collectors.toList());

        // 5. Display filtered bogies
        System.out.println("\n--- High-Capacity Bogies (Capacity > " + capacityThreshold + ") ---");
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            highCapacityBogies.forEach(System.out::println);
        }

        // Verify original integrity
        System.out.println("\nOriginal list size remains: " + consist.size());
    }
}