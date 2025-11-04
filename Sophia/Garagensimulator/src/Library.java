import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    private final List<User> users = new ArrayList<>();
    private final List<Vehicle> vehicles = new ArrayList<>();

    public Library() {
        // --- Example data in arrays ---
        User[] userArray = {
                new User(1, "alina", "Alina Baum", 33, "alinabaum@example.com","+444 444 44 4444", "test123"),
                new User(2, "rex", "Rex Bucher", 27, "rexbucher@example.com","+333 333 33 3333", "iloveCars1998"),
                new User(3, "maxim", "Maxim Eibe", 42, "maximeibe@example.com","+222 222 22 2222", "motorcycleFav2009")
        };

        Vehicle[] vehicleArray = {
                new Car(1, "EFG345HC", "blue", "F150", "bmw"),
                new Car(2, "ABC123DE", "red", "SP34", "toyota"),
                new Motorcycle(3, "BW55JUC", "black", "K-49", "yamaha")
        };

        // --- Convert arrays to ArrayLists ---
        users.addAll(Arrays.asList(userArray));
        vehicles.addAll(Arrays.asList(vehicleArray));

        // Assign vehicles to users
        users.get(0).addVehicle(vehicles.get(0)); // Alina → F150
        users.get(1).addVehicle(vehicles.get(1)); // Rex → SP34
        users.get(2).addVehicle(vehicles.get(2)); // Maxim → K-49
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                return user;
            }
        }
        return null;
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void deleteUser(User user) {
        users.remove(user);
    }
}
