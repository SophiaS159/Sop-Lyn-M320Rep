public class WeatherLogic {
    private final WeatherService weatherService;

    public WeatherLogic(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public String getWeatherReport(String city) {
        String weather = weatherService.getWeather(city);
        return "The current weather in " + city + ": " + weather;
    }
}
