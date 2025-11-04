package src.logic;

import src.service.CalculatorService;
import src.exception.InvalidInputException;

public class CalculatorController {

    private final CalculatorService service;

    public CalculatorController() {
        this.service = new CalculatorService();
    }

    public double calculate(double a, double b, String operation) throws InvalidInputException {
        if (operation == null || operation.isEmpty()) {
            throw new InvalidInputException("Keine Operation angegeben!");
        }

        // Delegation an den Service
        return service.performCalculation(a, b, operation);
    }
}
