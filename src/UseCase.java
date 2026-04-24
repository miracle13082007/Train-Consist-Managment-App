import java.util.Scanner;

public class UseCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        String[] bogieIds = new String[n];

        for (int i = 0; i < n; i++) {
            bogieIds[i] = scanner.nextLine();
        }

        String searchKey = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (bogieIds[i].equals(searchKey)) {
                found = true;
                break;
            }
        }

        System.out.println(found);

        scanner.close();
    }
}