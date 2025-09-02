import java.util.UUID;

public class Person {

    // Vars
    private final UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String email;
    private String password;

    public Person() {
        id = UUID.randomUUID();
        firstName = "Example";
        lastName = "Example";
        age = 0;
        phoneNumber = "000 000 00 00";
        email = "example@gmail.com";
        password = "********************";
    }

    public Person(String firstName, String lastName, int age, String phoneNumber,String email, String password){
        id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public UUID getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    // Setter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Prints the person
    public void printDetailedPerson() {
        System.out.println("\nPerson:");
        System.out.println("  ID: " + id);
        System.out.println("  Name: " + firstName + " " + lastName);
        System.out.println("  Age: " + age);
        System.out.println("  Phone: " + phoneNumber);
        System.out.println("  Email: " + email);
        System.out.println("  Password: " + password);
        System.out.println("---------------------");
    }

    public void printPerson() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("---------------------");
    }
}
