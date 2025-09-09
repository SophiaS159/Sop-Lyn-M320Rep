import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private final  List<Person> persons = new ArrayList<>();
    private final List<Device> devices = new ArrayList<>();
    private final Person user;
    Scanner scanner = new Scanner(System.in);

    public Library(String email, String password) {
        persons.add(new Person("Max", "Mustermann", 25, "123 456 78 90", "max@example.com", "qwertzuhbv257z7u"));
        persons.add(new Person("Anna", "Schmidt", 30, "987 654 32 10", "anna.schmidt@example.com", "gdgdgghehiqwaa"));
        persons.add(new Person("Tom", "Müller", 40, "555 666 77 33", "tom.mueller@example.com", "kdkffjjfj2012912e90ää2wöü12,.."));

        devices.add(new Laptop("MPC", 5, "192.168.0.10", "max_user", "laptop123", persons.get(0).getId(), 34, 2003.00, 2.40));
        devices.add(new Phone("Max Phone", 4, "192.168.0.11", "max_phone", "phone123", persons.get(0).getId(), 254, 15));
        devices.add(new Laptop("LannaTop", 2, "192.168.0.20", "anna_s", "tablet123", persons.get(1).getId() , 12, 1309.00, 2.90));

        for (Person p : persons){
            if (p.getEmail().equals(email)){
                if(p.getPassword().equals(password)){
                    user = p;
                    return;
                }
                throw new PersonNotFoundException("Error: The password wasn't right.");
            }
        }
        throw new PersonNotFoundException("Error: The email couldn't be found in the library.");
    }

    //Print All
    public void showAllPersons(){
        System.out.println("\nAll Persons in the Library:");
        for (Person p : persons){
            System.out.print(persons.indexOf(p) + ".) \n");
            p.printPerson();
        }
    }

    public void showAllDevices(){
        System.out.println("\nAll Devices in the Library:");
        for (Device d : devices){
            System.out.print(devices.indexOf(d) + ".) \n");
            d.printDevice();
        }
    }

    //Print detailed
    public void detailedPerson(int index){
        persons.get(index).printDetailedPerson();
        System.out.println("\nDevices:");
        for (Device d : devices) {
            if (d.getId_person().equals(persons.get(index).getId())) {
                d.printDevice();
            }
        }
    }

    public void detailedDevice(int index){
        devices.get(index).printDetailedDevice();
        for (Person p : persons) {
            if (p.getId().equals(devices.get(index).getId_person())) {
                System.out.println("\nPerson:");
                p.printPerson();
            }
        }
    }

    //Add
    public void addPerson() {
        System.out.println("Creator:");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        int age;
        do {
            System.out.print("Age: ");
            age = Integer.parseInt(scanner.nextLine());
        } while (age < 0);
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        String password;
        while (true) {
            System.out.print("Password: ");
            password = scanner.nextLine();
            System.out.print("Repeat Password: ");
            String repeatedPassword = scanner.nextLine();
            if (password.equals(repeatedPassword)) {
                break;
            }
        }
        persons.add(new Person(firstName,lastName,age,phoneNumber,email,password));
    }

    public void addDevice(int indexPers) {
        System.out.println("Creator:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        int age;
        do {
            System.out.print("Age: ");
            age = Integer.parseInt(scanner.nextLine());
        } while (age < 0);
            System.out.print("Ip: ");
            String ip = scanner.nextLine();
            if (ip.isEmpty()){
                ip = "123.123.123.12";
            }
            System.out.print("Username: ");
            String username = scanner.nextLine();
            String password;
            while (true) {
            System.out.print("Password: ");
            password = scanner.nextLine();
            System.out.print("Repeat Password: ");
            String repeatedPassword = scanner.nextLine();
            if (password.equals(repeatedPassword)) {
                break;
            }
        }
        System.out.print("Would you like to create a:\n" +
                "1.) Laptop\n2.) Phone\nEnter: ");
        switch (Integer.parseInt(scanner.nextLine())){
            case 1:
                int ram;
                do {
                    System.out.print("Ram in GB: ");
                    ram = Integer.parseInt(scanner.nextLine());
                } while (ram < 0);
                double storage;
                do {
                    System.out.print("Storage in GB: ");
                    storage = Double.parseDouble(scanner.nextLine());
                } while (storage < 0.00);
                double weight;
                do {
                    System.out.print("Weight in KG: ");
                    weight = Double.parseDouble(scanner.nextLine());
                } while (weight < 0.00);
                devices.add(new Laptop(name, age,ip,username,password, persons.get(indexPers).getId(), ram, storage, weight));
                break;
            case 2:
                storage = 0;
                do {
                    System.out.print("Storage in GB: ");
                    storage = Double.parseDouble(scanner.nextLine());
                } while (storage < 0.00);
                double size;
                do {
                    System.out.print("Size in CM: ");
                    size = Double.parseDouble(scanner.nextLine());
                } while (size < 0.00);
                devices.add(new Phone(name, age,ip,username,password, persons.get(indexPers).getId(), storage, size));
                break;
            default:
                System.out.println("Error: This Action Is Not Possible!");
                break;
        }
}

    //Edit
    public void editPerson(int index) {
        while (true) {
            persons.get(index).printDetailedPerson();
            System.out.print("""
                    Editor (* You can always return to the Menu with Q.):
                    1.) Name *
                    2.) Age
                    3.) Phone Number *
                    4.) Email *
                    5.) Password *
                    6.) Exit Editor
                    Enter:\s""");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    System.out.print("\nFirst Name: ");
                    String firstName = scanner.nextLine();
                    if (returnToEditor(firstName)) break;
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    if (returnToEditor(lastName)) break;
                    persons.get(index).setFirstName(firstName);
                    persons.get(index).setLastName(lastName);
                    break;
                case 2:
                    int age = 0;
                    do {
                        System.out.print("\nAge: ");
                        age = Integer.parseInt(scanner.nextLine());
                    } while (age < 0);
                    persons.get(index).setAge(age);
                    break;
                case 3:
                    System.out.print("\nPhone Number: ");
                    String phoneNumber = scanner.nextLine();
                    if (returnToEditor(phoneNumber)) break;
                    persons.get(index).setPhoneNumber(phoneNumber);
                    break;
                case 4:
                    System.out.print("\nEmail: ");
                    String email = scanner.nextLine();
                    if (returnToEditor(email)) break;
                    persons.get(index).setEmail(email);
                    break;
                case 5:
                    while (true) {
                        System.out.print("\nEnter old Password: ");
                        String oldPassword = scanner.nextLine();
                        if (returnToEditor(oldPassword)) break;
                        System.out.print("New Password: ");
                        String newPassword = scanner.nextLine();
                        if (returnToEditor(newPassword)) break;
                        System.out.print("Repeat new Password: ");
                        String repeatedNewPassword = scanner.nextLine();
                        if (returnToEditor(repeatedNewPassword)) break;
                        if (persons.get(index).getPassword().equals(oldPassword) && newPassword.equals(repeatedNewPassword)) {
                            persons.get(index).setPassword(newPassword);
                            break;
                        }
                    }
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }

    public void editDevice(int index) {
        while (true) {
            devices.get(index).printDetailedDevice();
            System.out.print("""
                    
                    Editor (* You can always return to the Menu with Q.):
                    1.) Name *
                    2.) Age
                    3.) Ip *
                    4.) Username *
                    5.) Password *
                    6.) Extras
                    7.) Exit Editor
                    Enter:\s""");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    System.out.print("\nName: ");
                    String name = scanner.nextLine();
                    if (returnToEditor(name)) break;
                    devices.get(index).setName(name);
                    break;
                case 2:
                    int age = 0;
                    do {
                        System.out.print("\nAge: ");
                        age = Integer.parseInt(scanner.nextLine());
                    } while (age < 0);
                    devices.get(index).setAge(age);
                    break;
                case 3:
                    System.out.print("\nIp: ");
                    String ip = scanner.nextLine();
                    if (returnToEditor(ip)) break;
                    devices.get(index).setIp(ip);
                    break;
                case 4:
                    System.out.print("\nUsername: ");
                    String username = scanner.nextLine();
                    if (returnToEditor(username)) break;
                    devices.get(index).setUsername(username);
                    break;
                case 5:
                    while (true) {
                        System.out.print("\nEnter old Password: ");
                        String oldPassword = scanner.nextLine();
                        if (returnToEditor(oldPassword)) break;
                        System.out.print("New Password: ");
                        String newPassword = scanner.nextLine();
                        if (returnToEditor(newPassword)) break;
                        System.out.print("Repeat new Password: ");
                        String repeatedNewPassword = scanner.nextLine();
                        if (returnToEditor(repeatedNewPassword)) break;
                        if (devices.get(index).getPassword().equals(oldPassword) && newPassword.equals(repeatedNewPassword)) {
                            devices.get(index).setPassword(newPassword);
                            break;
                        }
                    }
                    break;
                case 6:
                    Device dev = devices.get(index);
                    if (dev instanceof Laptop laptop) {
                        int ram;
                        do {
                            System.out.print("Ram in GB: ");
                            ram = Integer.parseInt(scanner.nextLine());
                        } while (ram < 0);
                        laptop.setRam(ram);

                        double storage;
                        do {
                            System.out.print("Storage in GB: ");
                            storage = Double.parseDouble(scanner.nextLine());
                        } while (storage < 0.00);
                        laptop.setStorage(storage);

                        double weight;
                        do {
                            System.out.print("Weight in KG: ");
                            weight = Double.parseDouble(scanner.nextLine());
                        } while (weight < 0.00);
                        laptop.setWeight(weight);

                    } else if (dev instanceof Phone phone) {
                        double storage;
                        do {
                            System.out.print("Storage in GB: ");
                            storage = Double.parseDouble(scanner.nextLine());
                        } while (storage < 0);
                        phone.setStorage(storage);

                        double size;
                        do {
                            System.out.print("Size in CM: ");
                            size = Double.parseDouble(scanner.nextLine());
                        } while (size < 0);
                        phone.setSize(size);
                    }
                    break;
                case 7:
                    return;
                default:
                    break;
            }
        }
    }

    private boolean returnToEditor(String q){
        return q.equals("q") || q.equals("Q");
    }

    //Delete
    public void deletePerson(int index){
        devices.removeIf(d -> d.getId_person().equals(persons.get(index).getId()));
        persons.remove(index);
    }

    public void deleteDevice(int index) {
        devices.remove(index);
    }
}
