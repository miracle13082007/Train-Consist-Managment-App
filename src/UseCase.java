import java.util.*;

class GoodsBogie {
    String id;
    String shape; // Cylindrical, Rectangular, etc.
    String cargo;

    public GoodsBogie(String id, String shape, String cargo) {
        this.id = id;
        this.shape = shape;
        this.cargo = cargo;
    }

    public String getShape() { return shape; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return String.format("[%s | Shape: %s | Cargo: %s]", id, shape, cargo);
    }
}

public class UseCase {
    public static void main(String[] args) {
        // 1. Prepare a list of goods bogies
        List<GoodsBogie> goodsConsist = Arrays.asList(
                new GoodsBogie("G1", "Rectangular", "Coal"),
                new GoodsBogie("G2", "Cylindrical", "Petroleum"),
                new GoodsBogie("G3", "Rectangular", "Grain"),
                new GoodsBogie("G4", "Cylindrical", "Petroleum")
        );

        System.out.println("Checking Safety Compliance for Consist:");
        goodsConsist.forEach(System.out::println);

        // 2. Convert to stream | 3. allMatch() with safety logic
        boolean isSafe = goodsConsist.stream().allMatch(bogie -> {
            if (bogie.getShape().equalsIgnoreCase("Cylindrical")) {
                return bogie.getCargo().equalsIgnoreCase("Petroleum");
            }
            return true; // Non-cylindrical bogies pass this specific rule
        });

        // 5. Display Result
        System.out.println("-------------------------------------------");
        if (isSafe) {
            System.out.println("STATUS: SAFE - All safety rules satisfied.");
        } else {
            System.out.println("STATUS: UNSAFE - Violation detected in cargo assignment!");
        }
    }
}