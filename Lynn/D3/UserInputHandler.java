import java.util.Scanner;

public class UserInputHandler {
    public  UserInputHandler()  {
        WeatherService weatherService = new WeatherService();
        WeatherLogic logic = new WeatherLogic(weatherService);

        while (true) {
            try {
                String city = getCityFromUser();
                if (city.equals("q")) {
                    System.exit(0);
                }
                String report = logic.getWeatherReport(city);
                System.out.println(report);
            } catch (InvalidCityException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private String getCityFromUser() throws InvalidCityException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a city (exit with q): ");
        String city = scanner.nextLine().trim();

        if (city.length() < 2 && !city.toLowerCase().equals("q")) {
            throw new InvalidCityException("Invalid city input! Please enter at least 2 letters.");
        }
        return city;
    }
}
