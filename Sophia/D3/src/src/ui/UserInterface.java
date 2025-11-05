package src.ui;
import src.exception.InvalidInputException;
import src.logic.ConversionLogic;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final ConversionLogic logic = new ConversionLogic();

    public void startApplication() {
        System.out.println("--- Währungsrechner gestartet ---");
        boolean running = true;
        while (running) {
            try {
                System.out.print("\nBetrag eingeben: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Von Währung (z.B. EUR): ");
                String from = scanner.nextLine().toUpperCase();

                System.out.print("Nach Währung (z.B. USD): ");
                String to = scanner.nextLine().toUpperCase();

                double result = logic.convert(amount, from, to);

                System.out.printf("ERGEBNIS: %.2f %s entspricht %.2f %s\n", amount, from, result, to);

            } catch (InvalidInputException e) {

                System.err.println("FEHLER bei der Eingabe/Umrechnung: " + e.getMessage());

            } catch (java.util.InputMismatchException e) {
                System.err.println("FEHLER: Ungültiges Zahlenformat. Bitte nur Zahlen eingeben.");
                scanner.nextLine();
            } catch (Exception e) {
                System.err.println("Ein unerwarteter Fehler ist aufgetreten: " + e.getMessage());
            }


            System.out.print("Beenden? (J/N): ");
            String stop = scanner.nextLine();
            if (stop.trim().equalsIgnoreCase("J")) {
                running = false;
            }
        }
        System.out.println("--- Währungsrechner beendet ---");
    }
}