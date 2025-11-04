import java.util.InputMismatchException;
import java.util.Scanner;

//Core Logic
public class PortfolioApp {

    public static void main(String[] args) {
        //Erstellt Portfolio und mit füllt Aktien
        Portfolio myPortfolio = new Portfolio();
        myPortfolio.addStock(new Stock("Microsoft", 10));
        myPortfolio.addStock(new Stock("Nestle", 5));
        myPortfolio.addStock(new Stock("Tesla", 8));
        myPortfolio.addStock(new Stock("Roche", 12));

        System.out.println("Willkommen beim Portfolio-Rechner!");
        System.out.println("Aktien im Portfolio: " + myPortfolio.getHoldings());
        System.out.println("------------------------------------------");

        //Implementierung der Boersen (TASK-Anforderung)
        StockExchange nyse = new NewYorkStockExchange();
        StockExchange zse = new ZurichStockExchange();


        StockExchange[] exchanges = {nyse, zse};

        //Benutzermeunu erstellen (TASK-Anforderung)
        runMenu(myPortfolio, exchanges);
    }

    private static void runMenu(Portfolio portfolio, StockExchange[] exchanges) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\nBitte waehlen Sie eine Boerse zur Berechnung des Portfoliowertes:");
            for (int i = 0; i < exchanges.length; i++) {
                System.out.println((i + 1) + ") " + exchanges[i].getName());
            }
            System.out.println("0) Beenden");
            System.out.print("Ihre Wahl: ");

            try {
                choice = scanner.nextInt();

                if (choice >= 1 && choice <= exchanges.length) {
                    // Die gewählte Börse wird dem Portfolio gegeben
                    StockExchange selectedExchange = exchanges[choice - 1];

                    double totalValue = portfolio.calculateTotalValue(selectedExchange);

                    // Ausgabe des Gesamtwertes mit passende Art vo Geld
                    System.out.printf("\n--- GESAMTWERT --- \nDas Portfolio ist auf der %s %.2f wert.\n",
                            selectedExchange.getName(),
                            totalValue);
                    System.out.println("------------------\n");

                } else if (choice == 0) {
                    System.out.println("Programm beendet. Auf Wiedersehen!");
                } else {
                    System.out.println("Ungueltige Auswahl. Bitte geben Sie eine Zahl von 0 bis " + exchanges.length + " ein.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Fehler: Bitte geben Sie eine gueltige Zahl ein.");
                scanner.next(); // fehler bei Eingabe
            }
        }
        scanner.close();
    }
}