import java.util.UUID;

public abstract class Device {

    // Vars
    private String name;
    private int age;
    private String ip;
    private String username;
    private String password;
    private final UUID id_person;


    public Device(String name, int age, String ip, String username, String password, UUID id_person) {
        this.name = name;
        this.age = age;
        this.ip = ip;
        this.username = username;
        this.password = password;
        this.id_person = id_person;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getIp() {
        return ip;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UUID getId_person() {
        return id_person;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Prints Device
    public abstract void printDetailedDevice();
//    {
//        System.out.println("\nDevice:");
//        System.out.println("  Device Name: " + name);
//        System.out.println("  Age: " + age);
//        System.out.println("  IP: " + ip);
//        System.out.println("  Username: " + username);
//        System.out.println("  Password: " + password);
//        System.out.println("  Owner ID: " + id_person);
//        System.out.println("---------------------");
//    }

    public abstract void printDevice();
//    {
//        System.out.println("Device Name: " + name);
//        System.out.println("---------------------");
//    }
}
