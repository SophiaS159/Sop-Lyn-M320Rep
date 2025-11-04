import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AirportMap {
    private Map<String, String> airports = new HashMap<>();
    private List<String> searchHistory = new ArrayList<>();

    // Load from CSV
    public void loadFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    airports.put(parts[0].trim(), parts[1].trim());
                }
            }
            System.out.println("✅ Airports loaded successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }

    // Show all airports
    public void showAll() {
        System.out.println("\n📋 List of all airports:");
        airports.forEach((code, name) ->
                System.out.println("Code: " + code + " → " + name)
        );
    }

    // Search for an airport
    public void searchAirport(String code) {
        String result = airports.get(code.toUpperCase());
        if (result != null) {
            System.out.println("✅ " + code.toUpperCase() + " → " + result);
        } else {
            System.out.println("❌ Airport not found for code: " + code);
        }
        searchHistory.add(0, code.toUpperCase());
    }

    // Remove an airport
    public void removeAirport(String code) {
        if (airports.remove(code.toUpperCase()) != null) {
            System.out.println("🗑️ Airport " + code + " removed.");
        } else {
            System.out.println("❌ No airport found with code " + code);
        }
    }

    // Add new airport
    public void addAirport(String code, String name) {
        airports.put(code.toUpperCase(), name);
        System.out.println("➕ Added/Updated: " + code.toUpperCase() + " → " + name);
    }

    // Sort alphabetically
    public void sortAirports() {
        System.out.println("\n🔤 Airports sorted alphabetically:");
        airports.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry ->
                        System.out.println(entry.getKey() + " → " + entry.getValue()));
    }

    // Show search history
    public void showSearchHistory() {
        System.out.println("\n🕘 Search History (latest first):");
        if (searchHistory.isEmpty()) {
            System.out.println("No searches yet.");
        } else {
            searchHistory.forEach(System.out::println);
        }
    }
}
