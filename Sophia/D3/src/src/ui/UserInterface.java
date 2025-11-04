package src.ui;

import java.util.Scanner;
import src.logic.CalculatorController;
import src.exception.InvalidInputException;

public class UserInterface {

    private final CalculatorController controller;
    private final Scanner scanner;

    public UserInterface() {
        this.controller = new CalculatorController();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Einfacher Taschenrechner ===");

        while (true) {
            try {
                System.out.print("Erste Zahl eingeben (oder 'exit' zum Beenden): ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Auf Wiedersehen!");
                    break;
                }

                double a = Double.parseDouble(input);

                System.out.print("Zweite Zahl: ");
                double b = Double.parseDouble(scanner.nextLine());

                System.out.print("Operation (+, -, *, /): ");
                String op = scanner.nextLine();

                double result = controller.calculate(a, b, op);
                System.out.println("Ergebnis: " + result);

            } catch (InvalidInputException e) {
                System.out.println("Fehler: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Zahleneingabe!");
            } catch (Exception e) {
                System.out.println("Ein unerwarteter Fehler ist aufgetreten: " + e.getMessage());
            }
        }
    }
}
