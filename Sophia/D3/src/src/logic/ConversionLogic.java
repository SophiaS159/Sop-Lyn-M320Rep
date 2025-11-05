package src.logic;

import src.exception.InvalidInputException;
import src.service.CurrencyApiService;

public class ConversionLogic {
    private final CurrencyApiService apiService = new CurrencyApiService();


    public double convert(double amount, String fromCurrency, String toCurrency) throws InvalidInputException {

        if (amount <= 0) {
            throw new InvalidInputException("Der Betrag muss positiv sein.");
        }

        double rate = apiService.getExchangeRate(fromCurrency, toCurrency);

        double result = amount * rate;
        System.out.println("DEBUG: Betrag * Kurs = " + amount + " * " + rate + " = " + result);

        return result;
    }
}