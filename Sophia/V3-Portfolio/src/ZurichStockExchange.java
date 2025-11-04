import java.util.HashMap;
import java.util.Map;

//Implementierung
public class ZurichStockExchange implements StockExchange {
    private final Map<String, Double> prices;

    public ZurichStockExchange() {
        prices = new HashMap<>();
        prices.put("Microsoft", 120.00); // Beispiel: 120 CHF in Zuerich
        prices.put("Nestle", 105.00);
        prices.put("Roche", 300.25);
    }

    @Override
    public double getPrice(String stockName) {
        // Gibt den Preis zurück oder 0.0, falls die Aktie nicht gefunden wird
        return prices.getOrDefault(stockName, 0.0);
    }

    @Override
    public String getName() {
        return "Zurich Stock Exchange (CHF)";
    }
}