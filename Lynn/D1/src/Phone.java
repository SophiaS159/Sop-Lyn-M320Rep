import java.util.UUID;

public class Phone extends Device{

    private double storage;
    private double size;


    public Phone (String name, int age, String ip, String username, String password, UUID id_person, double storage, double size){
        super(name, age, ip, username, password, id_person);
        this.storage = storage;
        this.size = size;
    }

    public double getStorage() {
        return storage;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setStorage(double storage) {
        this.storage = storage;
    }

    @Override
    public void printDetailedDevice() {
        System.out.println("\nPhone:");
        System.out.println("  Phone Name: " + getName());
        System.out.println("  Age: " + getAge());
        System.out.println("  IP: " + getIp());
        System.out.println("  Username: " + getUsername());
        System.out.println("  Password: " + getPassword());
        System.out.println("  Owner ID: " + getId_person());
        System.out.println("  Storage: " + storage + " GB");
        System.out.println("  Size: " + size + " CM");
        System.out.println("---------------------");
    }

    @Override
    public void printDevice() {
        System.out.println("Phone Name: " + getName());
        System.out.println("---------------------");
    }

}
