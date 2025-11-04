import java.util.HashMap;
import java.util.Map;

//Implementierung
public class NewYorkStockExchange implements StockExchange {
    private final Map<String, Double> prices;

    public NewYorkStockExchange() {

        prices = new HashMap<>();
        prices.put("Microsoft", 100.00); // B: 100$ in NY
        prices.put("Nestle", 120.50);
        prices.put("Tesla", 250.75);
    }

    @Override
    public double getPrice(String stockName) {
        // Gibt den Preis zurück oder 0.0, falls die Aktie nicht gefunden wird
        return prices.getOrDefault(stockName, 0.0);
    }

    @Override
    public String getName() {
        return "New York Stock Exchange (USD)";
    }
}