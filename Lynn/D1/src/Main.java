import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        while (true){
//            System.out.println("Welcome to The Library!!");
//            System.out.print("Please Login:\nEmail: ");
//            String email = scanner.nextLine();
//            System.out.print("Password: ");
//            String password = scanner.nextLine();
            Library library = new Library("max@example.com","qwertzuhbv257z7u");
            library.nav();
        }
    }
}