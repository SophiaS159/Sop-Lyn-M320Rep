/**
 * Modul 320: Interfaces anwenden
 * Interface, das den Vertrag fuer eine Boersen-Abfrage definiert.
 * Ermoeglicht flexible Preisabfragen unabhaengig von der konkreten Boerse (Polymorphismus).
 */
public interface StockExchange {
    /**
     * Gibt den aktuellen Preis einer Aktie in einer bestimmten Waehrung zurueck.
     * @param stockName Der Name der Aktie (z.B. "Microsoft").
     * @return Der Preis der Aktie als double.
     */
    double getPrice(String stockName);

    /**
     * Gibt den Namen der Boerse zurueck.
     * @return Der Name der Boerse.
     */
    String getName();
}