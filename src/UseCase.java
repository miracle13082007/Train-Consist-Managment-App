public class UseCase {

    public static void sortBogieCapacities(int[] capacities) {
        int n = capacities.length;
        boolean swapped;

        System.out.println("Starting Bubble Sort on capacities...");

        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for adjacent comparison
            // n-1-i because the last i elements are already sorted
            for (int j = 0; j < n - 1 - i; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swapping Logic
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: If no two elements were swapped by inner loop, then break
            if (!swapped) break;
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample dataset of bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("Original Capacities: ");
        printArray(capacities);

        sortBogieCapacities(capacities);

        System.out.print("Sorted Capacities (Ascending): ");
        printArray(capacities);

        // Demonstration of stability with duplicate values
        int[] duplicates = {72, 56, 56, 24};
        System.out.print("\nSorting with Duplicates: ");
        sortBogieCapacities(duplicates);
        printArray(duplicates);
    }
}