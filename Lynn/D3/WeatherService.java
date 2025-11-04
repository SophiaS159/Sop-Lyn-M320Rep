import java.util.HashMap;
import java.util.Map;

public class WeatherService {
    private final Map<String, String> weatherData;

    public WeatherService() {
        weatherData = new HashMap<>();
        weatherData.put("Zurich", "18°C, sunny");
        weatherData.put("Bern", "16°C, partly cloudy");
        weatherData.put("Basel", "19°C, clear sky");
        weatherData.put("Geneva", "17°C, rainy");
    }

    public String getWeather(String city) {
        return weatherData.getOrDefault(city, "no weather data available.");
    }
}
