import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UseCase {

    // Regex Constants
    // TRN- followed by exactly 4 digits
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    // PET- followed by exactly 2 uppercase letters
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    private static final Pattern trainPattern = Pattern.compile(TRAIN_ID_REGEX);
    private static final Pattern cargoPattern = Pattern.compile(CARGO_CODE_REGEX);

    public static boolean validateTrainId(String trainId) {
        if (trainId == null) return false;
        Matcher matcher = trainPattern.matcher(trainId);
        return matcher.matches();
    }

    public static boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Matcher matcher = cargoPattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Sample Inputs
        String[] testTrainIds = {"TRN-1234", "TRN12", "TRN-123A", "1234-TRN", "TRN-9999"};
        String[] testCargoCodes = {"PET-AB", "PET-bc", "PET123", "PET-XYZ", "PET-KO"};

        System.out.println("--- Train ID Validation ---");
        for (String id : testTrainIds) {
            System.out.println(id + " : " + (validateTrainId(id) ? "VALID" : "INVALID"));
        }

        System.out.println("\n--- Cargo Code Validation ---");
        for (String code : testCargoCodes) {
            System.out.println(code + " : " + (validateCargoCode(code) ? "VALID" : "INVALID"));
        }
    }
}