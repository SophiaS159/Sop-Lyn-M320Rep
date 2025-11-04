import java.util.Scanner;

public class UserInputHandler {
    public String getCityFromUser() throws InvalidCityException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a city (exit with q): ");
        String city = scanner.nextLine().trim();

        if (city.length() < 2 && !city.toLowerCase().equals("q")) {
            throw new InvalidCityException("Invalid city input! Please enter at least 2 letters.");
        }

        return city;
    }
}
