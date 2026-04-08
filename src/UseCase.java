class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String bogieId;
    private String shape;
    private String assignedCargo = "Empty";

    public GoodsBogie(String bogieId, String shape) {
        this.bogieId = bogieId;
        this.shape = shape;
    }

    public void assignCargo(String cargoType) {
        System.out.println("\nAttempting: " + cargoType + " -> " + bogieId + " (" + shape + ")");

        try {
            if (cargoType.equalsIgnoreCase("Petroleum") && shape.equalsIgnoreCase("Rectangular")) {
                throw new CargoSafetyException("CRITICAL SAFETY ERROR: Petroleum requires Cylindrical storage!");
            }
            this.assignedCargo = cargoType;
            System.out.println("SUCCESS: Cargo assigned.");
        } catch (CargoSafetyException e) {
            System.err.println("CAUGHT: " + e.getMessage());
            System.out.println("STATUS: Assignment rejected for safety.");
        } finally {
            System.out.println("LOG: Validation process completed for " + bogieId);
        }
    }

    public String getAssignedCargo() {
        return assignedCargo;
    }
}

public class UseCase {
    public static void main(String[] args) {
        GoodsBogie b1 = new GoodsBogie("GB-101", "Cylindrical");
        GoodsBogie b2 = new GoodsBogie("GB-102", "Rectangular");

        b1.assignCargo("Petroleum");
        b2.assignCargo("Petroleum");
        b2.assignCargo("Coal");

        System.out.println("\nFinal Consist Summary:");
        System.out.println("Bogie 101: " + b1.getAssignedCargo());
        System.out.println("Bogie 102: " + b2.getAssignedCargo());
    }
}