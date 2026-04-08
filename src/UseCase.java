import java.util.*;
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

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("[%s: Cap %d]", id, capacity);
    }
}

public class UseCase {
    public static void main(String[] args) {
        // 1. Create a list of bogies
        List<Bogie> consist = Arrays.asList(
                new Bogie("B1", "Sleeper", 72),
                new Bogie("B2", "AC Chair", 56),
                new Bogie("B3", "Sleeper", 72),
                new Bogie("B4", "First Class", 24),
                new Bogie("B5", "AC Chair", 65),
                new Bogie("B6", "Goods-Rectangular", 0)
        );

        // 2. Convert list to stream, 3. Apply groupingBy(), 4. Store in Map
        Map<String, List<Bogie>> groupedBogies = consist.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        // 5. Display the grouped result
        System.out.println("--- Grouped Train Consist Report ---");
        groupedBogies.forEach((type, list) -> {
            System.out.println("Type: " + type + " | Count: " + list.size());
            System.out.println("  Bogies: " + list);
        });
    }
}