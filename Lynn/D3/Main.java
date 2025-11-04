public class Main {
    public static void main(String[] args) {
        UserInputHandler inputHandler = new UserInputHandler();
        WeatherService weatherService = new WeatherService();
        WeatherLogic logic = new WeatherLogic(weatherService);
        while (true) {
            try {
                String city = inputHandler.getCityFromUser();
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
}
