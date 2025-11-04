import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String fullName;
    private int age;
    private String email;
    private String phone;
    private String password;
    private final List<Vehicle> myVehicles = new ArrayList<>();

    public User(int id, String username, String fullName, int age, String email, String phone, String password) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // --- Getters ---
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getFullName() { return fullName; }
    public int getAge() { return age; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    // --- Password check ---
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    // --- CRUD for User ---
    public void changeEmail(String newEmail) {
        this.email = newEmail;
    }

    public void changePhone(String newPhone) {
        this.phone = newPhone;
    }

    public void changePassword(String oldPw, String newPw) {
        if (this.password.equals(oldPw)) {
            this.password = newPw;
            System.out.println("Password successfully updated.");
        } else {
            System.out.println("Incorrect current password!");
        }
    }

    public void changeAge(int newAge) {
        this.age = newAge;
    }

    // --- Show user info ---
    public void showMyData() {
        System.out.println("____User Data____");
        System.out.println("ID: " + id);
        System.out.println("Username: " + username);
        System.out.println("Full Name: " + fullName);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("_________________");
    }

    // --- Vehicle management ---
    public void addVehicle(Vehicle v) {
        myVehicles.add(v);
    }

    public void removeVehicle(Vehicle v) {
        myVehicles.remove(v);
    }

    public List<Vehicle> getMyVehicles() {
        return myVehicles;
    }

    public void showVehicles() {
        if (myVehicles.isEmpty()) {
            System.out.println("No vehicles assigned.");
        } else {
            for (Vehicle v : myVehicles) {
                System.out.println(v);
            }
        }
    }
}
