import java.util.HashMap;
import java.util.Map;

public class WeatherService {
    private final Map<String, String> weatherData;

    public WeatherService() {
        weatherData = new HashMap<>();
        weatherData.put("zurich", "18°C, sunny");
        weatherData.put("bern", "16°C, partly cloudy");
        weatherData.put("basel", "19°C, clear sky");
        weatherData.put("geneva", "17°C, rainy");
        weatherData.put("lausanne", "17°C, cloudy");
        weatherData.put("lugano", "21°C, sunny");
        weatherData.put("st. gallen", "15°C, rainy");
        weatherData.put("lucerne", "18°C, partly cloudy");
        weatherData.put("winterthur", "16°C, sunny");
        weatherData.put("thun", "17°C, clear sky");
        weatherData.put("schaffhausen", "16°C, cloudy");
        weatherData.put("neuchatel", "15°C, rainy");
        weatherData.put("fribourg", "17°C, cloudy");
        weatherData.put("biel", "16°C, partly cloudy");
        weatherData.put("sion", "20°C, sunny");
    }

    public String getWeather(String city) {
        return weatherData.getOrDefault(city.toLowerCase() , "no weather data available.");
    }
}
