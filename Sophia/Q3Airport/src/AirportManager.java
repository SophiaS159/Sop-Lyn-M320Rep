import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Manages all airport data, utilizing HashMap and TreeSet for efficient storage 
 * and retrieval. Implements O(1) lookup and Linear Search.
 */
public class AirportManager {
    private final Map<String, Airport> codeToAirportMap = new HashMap<>();
    private final Set<Airport> sortedAirports = new TreeSet<>();


    public void loadData(String filePath) {
        System.out.println("Loading data from: " + filePath + "...");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);

                if (parts.length == 2) {
                    String code = parts[0].trim().toUpperCase();
                    String name = parts[1].trim();

                    Airport airport = new Airport(code, name);

                    codeToAirportMap.put(code, airport);

                    sortedAirports.add(airport);
                }
            }
            System.out.println("✅ Data loaded successfully. Total airports: " + codeToAirportMap.size());
        } catch (IOException e) {
            System.err.println("❌ ERROR: Could not load file. Ensure 'airport_data.txt' is in the correct path.");
            e.printStackTrace();
        }
    }
    //Implements a search algorithm: O(1)

    public Airport findAirportByCode(String code) {
        // O(1) operation due to the nature of HashMap
        return codeToAirportMap.get(code.toUpperCase());
    }


    public List<Airport> searchAirportsByPartialName(String partialName) {
        List<Airport> results = new ArrayList<>();
        String searchTerm = partialName.toLowerCase();

        //Must check every item in the collection
        for (Airport airport : sortedAirports) {
            if (airport.getName().toLowerCase().contains(searchTerm)) {
                results.add(airport);
            }
        }
        return results;
    }

    public Set<Airport> getSortedAirports() {
        return sortedAirports;
    }
}