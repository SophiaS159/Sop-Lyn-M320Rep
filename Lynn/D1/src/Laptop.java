import java.util.UUID;

public class Laptop extends Device{

    private int ram;
    private double storage;
    private double weight;

    public Laptop (String name, int age, String ip, String username, String password, UUID id_person, int ram, double storage, double weight){
        super(name, age, ip, username, password, id_person);
        this.ram = ram;
        this.storage = storage;
        this.weight = weight;
    }


    public int getRam(){
        return ram;
    }
    public double getStorage(){
        return storage;
    }
    public double getWeight(){
        return weight;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setStorage(double storage) {
        this.storage = storage;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void printDetailedDevice() {
        System.out.println("\nLaptop:");
        System.out.println("  Laptop Name: " + getName());
        System.out.println("  Age: " + getAge());
        System.out.println("  IP: " + getIp());
        System.out.println("  Username: " + getUsername());
        System.out.println("  Password: " + getPassword());
        System.out.println("  Owner ID: " + getId_person());
        System.out.println("  Ram: " + ram + " GB");
        System.out.println("  Storage: " + storage + " GB");
        System.out.println("  Weight: " + weight + " KG");
        System.out.println("---------------------");
    }

    @Override
    public void printDevice() {
        System.out.println("Laptop Name: " + getName());
        System.out.println("---------------------");
    }
}
