import java.util.Scanner;

public class Menu {
    private final Library library = new Library();
    private final Scanner scanner = new Scanner(System.in);

    // --- Helper method for safe integer input ---
    private int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public void start() {
        System.out.println("=== Welcome to the Vehicle Management System ===");
        System.out.println("1. Login");
        System.out.println("2. Register");
        int startChoice = readInt("Choice: ");

        User loggedIn = null;

        if (startChoice == 1) {
            loggedIn = login();
        } else if (startChoice == 2) {
            loggedIn = register();
        }

        if (loggedIn != null) {
            userMenu(loggedIn);
        } else {
            System.out.println("Exiting...");
        }
    }

    private User login() {
        System.out.println("\n=== LOGIN ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = library.login(username, password);
        if (user == null) {
            System.out.println("Login failed!");
        }
        return user;
    }

    private User register() {
        System.out.println("\n=== REGISTER ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Full name: ");
        String fullName = scanner.nextLine();
        int age = readInt("Age: ");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        int newId = library.getUsers().size() + 1;
        User newUser = new User(newId, username, fullName, age, email, phone, password);
        library.registerUser(newUser);

        System.out.println("Registration successful! You are now logged in.");
        return newUser;
    }

    private void userMenu(User loggedIn) {
        System.out.println("Welcome, " + loggedIn.getFullName() + "!");
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Show my vehicles");
            System.out.println("2. Add vehicle");
            System.out.println("3. Delete vehicle");
            System.out.println("4. Update vehicle");
            System.out.println("5. Update my data");
            System.out.println("6. Show my data (via Action example)");
            System.out.println("0. Logout");
            choice = readInt("Choice: ");

            switch (choice) {
                case 1 -> loggedIn.showVehicles();
                case 2 -> addVehicle(loggedIn);
                case 3 -> deleteVehicle(loggedIn);
                case 4 -> updateVehicle(loggedIn);
                case 5 -> updateUser(loggedIn);
                case 6 -> {
                    // 🔥 Using Action abstraction here
                    Action action = new ShowUserDataAction();
                    action.execute(loggedIn, library);
                }
            }
        } while (choice != 0);

        System.out.println("Logged out. Goodbye!");
    }

    // --- Vehicle methods (add/delete/update)
    private void addVehicle(User loggedIn) {
        System.out.print("Plate number: ");
        String plate = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        Vehicle v = new Vehicle(999, plate, color, model, type, brand);
        loggedIn.addVehicle(v);
        System.out.println("Vehicle added!");
    }

    private void deleteVehicle(User loggedIn) {
        loggedIn.showVehicles();
        System.out.print("Enter plate number to delete: ");
        String plateDel = scanner.nextLine();
        Vehicle found = loggedIn.getMyVehicles().stream()
                .filter(v -> v.toString().contains(plateDel))
                .findFirst().orElse(null);
        if (found != null) {
            loggedIn.removeVehicle(found);
            System.out.println("Vehicle deleted.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    private void updateVehicle(User loggedIn) {
        loggedIn.showVehicles();
        System.out.print("Enter plate number to update: ");
        String plateEdit = scanner.nextLine();
        Vehicle v = loggedIn.getMyVehicles().stream()
                .filter(veh -> veh.toString().contains(plateEdit))
                .findFirst().orElse(null);
        if (v != null) {
            System.out.print("New color: ");
            v.repaint(scanner.nextLine());
            System.out.println("Vehicle updated.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    private void updateUser(User loggedIn) {
        System.out.println("\nWhat do you want to update?");
        System.out.println("1. Email");
        System.out.println("2. Phone");
        System.out.println("3. Age");
        System.out.println("4. Password");
        int updateChoice = readInt("Choice: ");

        switch (updateChoice) {
            case 1 -> {
                System.out.print("New email: ");
                loggedIn.changeEmail(scanner.nextLine());
                System.out.println("Email updated.");
            }
            case 2 -> {
                System.out.print("New phone: ");
                loggedIn.changePhone(scanner.nextLine());
                System.out.println("Phone updated.");
            }
            case 3 -> {
                int newAge = readInt("New age: ");
                loggedIn.changeAge(newAge);
                System.out.println("Age updated.");
            }
            case 4 -> {
                System.out.print("Old password: ");
                String oldPw = scanner.nextLine();
                System.out.print("New password: ");
                String newPw = scanner.nextLine();
                loggedIn.changePassword(oldPw, newPw);
            }
        }
    }
}
