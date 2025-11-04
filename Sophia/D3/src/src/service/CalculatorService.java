package src.service;

import src.exception.InvalidInputException;

public class CalculatorService {

    public double performCalculation(double a, double b, String operation) throws InvalidInputException {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) throw new InvalidInputException("Division durch 0 ist nicht erlaubt!");
                return a / b;
            default:
                throw new InvalidInputException("Ungültige Operation! Verwenden Sie +, -, * oder /.");
        }
    }
}
