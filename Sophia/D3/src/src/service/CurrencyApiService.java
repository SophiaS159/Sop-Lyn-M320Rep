package src.service;

import src.exception.InvalidInputException;

public class CurrencyApiService {


    public double getExchangeRate(String fromCurrency, String toCurrency) throws InvalidInputException {

        if (fromCurrency.length() != 3 || toCurrency.length() != 3) {
            throw new InvalidInputException("Ungültiger Währungscode. Es werden nur 3-stellige Codes akzeptiert (z.B. EUR, USD).");
        }

        if (fromCurrency.equalsIgnoreCase("EUR") && toCurrency.equalsIgnoreCase("USD")) {
            System.out.println("DEBUG: Rufe simulierten Kurs EUR -> USD (1.08) ab.");
            return 1.08;
        } else if (fromCurrency.equalsIgnoreCase("USD") && toCurrency.equalsIgnoreCase("EUR")) {
            System.out.println("DEBUG: Rufe simulierten Kurs USD -> EUR (0.92) ab.");
            return 0.92;
        } else {
            throw new InvalidInputException("Wechselkurs für " + fromCurrency + " nach " + toCurrency + " nicht verfügbar (Simuliert).");
        }
    }
}