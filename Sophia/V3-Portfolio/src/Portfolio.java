import java.util.ArrayList;
import java.util.List;

/**
 * Verwaltet eine Sammlung von Aktien.
 * Kann den aktuellen Wert bestimmen, indem eine beliebige
 * StockExchange-Implementierung uebergeben wird (Polymorphismus).
 */
public class Portfolio {
    // Entspricht der Anforderung: "eine Sammlung von Aktien"
    private final List<Stock> holdings;

    public Portfolio() {
        this.holdings = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        this.holdings.add(stock);
    }

    /**
     * Berechnet den Gesamtwert des Portfolios unter Verwendung der uebergebenen Boerse.
     * @param exchange Die zu verwendende StockExchange-Implementierung.
     * @return Der Gesamtwert des Portfolios in der Waehrung der Boerse.
     */
    public double calculateTotalValue(StockExchange exchange) {
        double totalValue = 0.0;
        System.out.println("\n--- Berechnung mit " + exchange.getName() + " ---");

        for (Stock stock : holdings) {
            double price = exchange.getPrice(stock.getName());
            double stockValue = price * stock.getQuantity();

            if (price > 0.0) {
                System.out.printf("%-10s: %d Stueck @ %.2f = %.2f\n",
                        stock.getName(),
                        stock.getQuantity(),
                        price,
                        stockValue);
                totalValue += stockValue;
            } else {
                System.out.printf("%-10s: Preis nicht gefunden auf der %s.\n",
                        stock.getName(),
                        exchange.getName());
            }
        }
        return totalValue;
    }

    public List<Stock> getHoldings() {
        return holdings;
    }
}