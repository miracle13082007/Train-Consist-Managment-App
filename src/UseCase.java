import java.util.Arrays;
import java.util.Scanner;

public class UseCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of bogie types:");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] bogies = new String[n];

        System.out.println("Enter bogie names:");
        for (int i = 0; i < n; i++) {
            bogies[i] = scanner.nextLine();
        }

        Arrays.sort(bogies);

        System.out.println("Sorted bogie names:");
        System.out.println(Arrays.toString(bogies));

        scanner.close();
    }
}