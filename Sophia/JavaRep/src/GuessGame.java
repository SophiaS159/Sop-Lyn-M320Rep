import java.util.Scanner;
import java.util.Random;

public class GuessGame {

    private int secretNumber;
    private boolean guessedCorrectly;

    // Konstruktor: initialisiert das Spiel
    public GuessGame() {
        Random rand = new Random();
        secretNumber = rand.nextInt(100) + 1; // Zahl zwischen 1 und 100
        guessedCorrectly = false;
    }

    // Startet den Spielablauf
    public void startGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Willkommen zum Ratespiel!");
        System.out.println("Ich habe mir eine Zahl zwischen 1 und 100 ausgedacht.");
        System.out.println("Kannst du sie erraten?");

        while (!guessedCorrectly) {
            System.out.print("Dein Tipp: ");
            int guess = sc.nextInt();
            checkGuess(guess);
        }

        System.out.println("Spiel beendet. Danke fürs Spielen!");
        sc.close();
    }

    // Überprüft den Tipp und gibt Rückmeldung
    private void checkGuess(int guess) {
        if (guess == secretNumber) {
            System.out.println("Richtig! Die Zahl war " + secretNumber + ".");
            guessedCorrectly = true;
        } else if (guess < secretNumber) {
            System.out.println("Die Zahl ist größer!");
        } else {
            System.out.println("Die Zahl ist kleiner!");
        }
    }

    // Einstiegspunkt
    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        game.startGame();
    }
}
