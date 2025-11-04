import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AirportMap app = new AirportMap();
        app.loadFromCSV("/Users/sophiasas/Documents/GitHub/Sop-Lyn-M320Rep/Sophia/Q3Airport/src/airports.csv"); //To make it work, put your absolute path here. Strangely doesnt see the file in the project.

        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\n===== ✈️ Airport Manager Menu =====");
            System.out.println("1. Show all airports");
            System.out.println("2. Search for an airport");
            System.out.println("3. Add a new airport");
            System.out.println("4. Remove an airport");
            System.out.println("5. Sort airports alphabetically");
            System.out.println("6. Show search history");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1" -> app.showAll();
                case "2" -> {
                    System.out.print("Enter airport code: ");
                    String code = scanner.nextLine();
                    app.searchAirport(code);
                }
                case "3" -> {
                    System.out.print("Enter new airport code: ");
                    String code = scanner.nextLine();
                    System.out.print("Enter airport name: ");
                    String name = scanner.nextLine();
                    app.addAirport(code, name);
                }
                case "4" -> {
                    System.out.print("Enter airport code to remove: ");
                    String code = scanner.nextLine();
                    app.removeAirport(code);
                }
                case "5" -> app.sortAirports();
                case "6" -> app.showSearchHistory();
                case "0" -> System.out.println("👋 Exiting program...");
                default -> System.out.println("❌ Invalid option. Try again.");
            }
        } while (!choice.equals("0"));
    }
}
